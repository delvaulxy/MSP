package corp.everis.pwc.moam;

import java.util.ArrayList;

import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;
import notinuse.XMLParser;

public class Expression extends TRANSFORMATION implements ISentence{
	protected ArrayList<SOURCE> sources;
	protected ArrayList<TARGET> targets;
	protected ArrayList<CONNECTOR> connectors;
	protected static ShuntingYard sy = new ShuntingYard();

	protected String sentence;

	public Expression() {
		super();
		this.sources = new ArrayList<SOURCE>();
		this.targets = new ArrayList<TARGET>();
		this.sentence = new String();
	}
	
	public Expression(ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts) {
		super();
		this.sources = srcs;
		this.targets = tgts;
	}

	public Expression(TRANSFORMATION transformation,ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts, ArrayList<CONNECTOR> conns){
		super(transformation);
		this.sources = srcs;
		this.targets = tgts;
		this.connectors = conns;
	}
	public ArrayList<SOURCE> getSources() {
		return sources;
	}

	public void setSources(ArrayList<SOURCE> sources) {
		this.sources = sources;
	}

	public void addSource(SOURCE source){
		this.sources.add(source);
	}

	public ArrayList<TARGET> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<TARGET> targets) {
		this.targets = targets;
	}

	public void addTarget(TARGET target){
		this.targets.add(target);
	}

	public String getSentence() {
		return this.sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public ArrayList<CONNECTOR> getConnnectors() {
		return connectors;
	}

	public void setConnnectors(ArrayList<CONNECTOR> connectors) {
		this.connectors = connectors;
	}

	public void addConnector(CONNECTOR connector){
		this.connectors.add(connector);
	}

	@Override
	public void toSentence() {
		ArrayList<CONNECTOR> necessaryConns = new ArrayList<CONNECTOR>();
		for(CONNECTOR c : this.getConnnectors())
			if(c.getFROMINSTANCE().equals(this.getNAME()))
				for(TARGETFIELD tgtf : this.getTargets().get(0).getTARGETFIELD())
					if(c.getTOFIELD().equals(tgtf.getNAME()))
						for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
							if(c.getFROMFIELD().equals(tf.getNAME()))
								necessaryConns.add(c);
		
		
		
		if(XMLParser.getLanguage().equals("SQL")){
			this.sentence = "INSERT INTO "+ "\n " + this.getTargets().get(0).getNAME()+ "\n (";
			for(CONNECTOR c : necessaryConns)
				for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
					if(tf.getNAME().equals(c.getFROMFIELD()))
						this.sentence = this.sentence +c.getTOFIELD()+",";
				}
			this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ ")\n ";
			this.sentence = this.sentence + " SELECT "+ "\n(";
							
			for(CONNECTOR c : necessaryConns)
				for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
					if(tf.getNAME().equals(c.getFROMFIELD()))
						if(!tf.getPORTTYPE().contains("INPUT")){
							this.sentence = this.sentence + "("+ sy.main(tf.getEXPRESSION()) +") AS "+tf.getNAME() + ", ";
						}else if(tf.getPORTTYPE().equals("INPUT/OUTPUT")){
							this.sentence = this.sentence + "S."+tf.getNAME()+", ";
						}
				}
			this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ ")\n ";
			this.sentence = this.sentence + " FROM "+ "\n " + this.sources.get(0).getNAME() +" S ";
		}else if(XMLParser.getLanguage().equals("Español")){
			
			// TODO ARRANGE THE TARGETFIELDS VS TRANSFORMFIELDS WITH CONNECTORS IN NECESSARYCONNS
			
				this.sentence = "Dado el orígen " + this.getSources().get(0).getNAME();
				int i = 0;
				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("INPUT/OUTPUT")){
						i = i+1;
					}
				
				if(i == 1)
					this.sentence =this.sentence +  ",\n el campo ";
				else if(i>1)
					this.sentence = this.sentence +", \n los campos ";

				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("INPUT/OUTPUT"))
						this.sentence = this.sentence + tf.getNAME() + ", ";

				if(i==1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " será entrada/salida, ";
				else if(i > 1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " serán entrada/salida, ";
				
				i = 0;
				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("INPUT")){
						i = i+1;
					}
				
				if(i == 1)
					this.sentence = this.sentence+ "\n el campo ";
				else if(i>1)
					this.sentence = this.sentence+ "\n  los campos ";

				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("INPUT")){
						this.sentence = this.sentence + tf.getNAME() + ", ";
					}
				if(i==1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " será entrada, ";
				else if(i > 1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " serán entrada, ";
				
				
				i = 0;
				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("OUTPUT")){
						i = i+1;
					}
				
				if(i == 1)
					this.sentence = this.sentence+ "\n el campo ";
				else if(i>1)
					this.sentence = this.sentence+ "\n los campos ";

				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("OUTPUT")){
						if(tf.getEXPRESSION()!=null){
							this.sentence = this.sentence + tf.getNAME() + " con valor " + sy.main(tf.getEXPRESSION()) + ", \n ";
						}else{
							this.sentence = this.sentence + tf.getNAME() + " con valor nulo, \n ";
						}
					}
				if(i==1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " será salida, ";
				else if(i > 1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " serán salidas, ";
				
				

				i = 0;
				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("LOCAL VARIABLE")){
						i = i+1;
					}
				
				if(i == 1)
					this.sentence = this.sentence+ " el campo ";
				else if(i>1)
					this.sentence = this.sentence+ " los campos ";

				for(TRANSFORMFIELD tf : this.transformfield)
					if(tf.getPORTTYPE().equals("LOCAL VARIABLE")){
						this.sentence = this.sentence + tf.getNAME() + " con valor " + ShuntingYard.infixToPostfix(tf.getEXPRESSION()) + ", ";
					}
				if(i==1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " será una variable, ";
				else if(i > 1)
					this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ " serán variables, ";
				
				this.sentence = this.sentence.substring(0, this.sentence.length()-2) + ".";
				
			
				
		}
	}

	
}
