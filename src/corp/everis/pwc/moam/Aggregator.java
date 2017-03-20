package corp.everis.pwc.moam;

import java.util.ArrayList;

import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;
import notinuse.XMLParser;

public class Aggregator extends TRANSFORMATION implements ISentence {
	protected ArrayList<SOURCE> sources;
	protected ArrayList<TARGET> targets;
	protected ArrayList<CONNECTOR> connectors;
	protected static ShuntingYard sy = new ShuntingYard();

	protected String sentence;

	public Aggregator() {
		this.sources = new ArrayList<SOURCE>();
		this.targets = new ArrayList<TARGET>();
		this.sentence = new String();
	}

	public Aggregator(ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts) {
		this.sources = srcs;
		this.targets = tgts;
	}
	public Aggregator(TRANSFORMATION transformation, ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts, ArrayList<CONNECTOR> conns) {
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
		
		boolean firstrun = true;
		if(XMLParser.getLanguage().equals("SQL")){
			this.sentence = "INSERT INTO "+ "\n " + this.getTargets().get(0).getNAME()+ "\n( ";
			for(CONNECTOR c : necessaryConns)
				for(TARGETFIELD tf : this.getTargets().get(0).getTARGETFIELD())
					if(tf.getNAME().equals(c.getTOFIELD()))
						this.sentence = this.sentence +tf.getNAME()+",";
			this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ ")\n  SELECT \n( ";

			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
				if(tf.getPORTTYPE().equals("INPUT/OUTPUT")){
					this.sentence = this.sentence + "S."+tf.getNAME()+", ";
				}else if(tf.getPORTTYPE().equals("OUTPUT")){
					this.sentence = this.sentence + "(" + sy.main(tf.getEXPRESSION()) +") AS "+tf.getNAME() + ", ";
				}else if(tf.getPORTTYPE().equals("VARIABLE")){
					//this.sentence = this.sentence + getExpressionValue(tf.getEXPRESSION()) +") AS "+tf.getNAME() + ", ";
				}
			}
			this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n ";
			this.sentence = this.sentence + " FROM "+ "\n " + this.sources.get(0).getNAME();
			
			for(TRANSFORMFIELD tf: this.getTRANSFORMFIELD())
				if(tf.getEXPRESSIONTYPE() != null && tf.getEXPRESSIONTYPE().equals("GROUPBY") && firstrun){
					this.sentence = this.sentence + " FROM "+ "\n " + this.sources.get(0).getNAME() +" S \n GROUP BY \n";
					firstrun = false;
				}
			for(TRANSFORMFIELD tf: this.getTRANSFORMFIELD())
				for(CONNECTOR c : necessaryConns)
					if(tf.getNAME().equals(c.getFROMFIELD()) && tf.getEXPRESSIONTYPE() != null && tf.getEXPRESSIONTYPE().equals("GROUPBY"))
						this.sentence = this.sentence +"S."+tf.getNAME()+", ";

			if(this.sentence.substring(0, this.sentence.length()-1).equals(","))
				this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ "\n";

			
		
		
		
		}else if(XMLParser.getLanguage().equals("Español")){



			this.sentence = "Dado el orígen " + this.getSources().get(0).getNAME();
			int i = 0;
			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("INPUT/OUTPUT")){
					i = i+1;
				}

			if(i == 1)
				this.sentence =this.sentence +  ",\n el campo \n ";
			else if(i>1)
				this.sentence = this.sentence +",\n los campos \n ";

			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("INPUT/OUTPUT"))
					this.sentence = this.sentence + tf.getNAME() + ",\n ";

			if(i==1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n será entrada/salida, ";
			else if(i > 1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n serán entrada/salida, ";

			i = 0;
			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("INPUT")){
					i = i+1;
				}

			if(i == 1)
				this.sentence = this.sentence+ "\n el campo \n";
			else if(i>1)
				this.sentence = this.sentence+ "\n los campos \n";

			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("INPUT")){
					this.sentence = this.sentence + tf.getNAME() + ", \n";
				}
			if(i==1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n será entrada, ";
			else if(i > 1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n serán entrada, ";


			i = 0;
			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("OUTPUT")){
					i = i+1;
				}

			if(i == 1)
				this.sentence = this.sentence+ "\n el campo \n";
			else if(i>1)
				this.sentence = this.sentence+ "\n los campos \n";

			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("OUTPUT")){
					this.sentence = this.sentence + tf.getNAME() + " con expressión " + tf.getEXPRESSION() + ",\n ";
				}
			if(i==1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n será salida, ";
			else if(i > 1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n serán salidas, ";



			i = 0;
			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("LOCAL VARIABLE")){
					i = i+1;
				}

			if(i == 1)
				this.sentence = this.sentence+ "\n el campo ";
			else if(i>1)
				this.sentence = this.sentence+ "\n los campos ";

			for(TRANSFORMFIELD tf : this.transformfield)
				if(tf.getPORTTYPE().equals("LOCAL VARIABLE")){
					this.sentence = this.sentence + tf.getNAME() + " con expressión " + tf.getEXPRESSION() + ", \n";
				}
			if(i==1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n será una variable, ";
			else if(i > 1)
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ "\n serán variables, ";

			this.sentence = this.sentence + "\n agrupado por ";
			
			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
				if(tf.getEXPRESSIONTYPE() != null && tf.getEXPRESSIONTYPE().equals("GROUPBY"))
					this.sentence = this.sentence + tf.getNAME()+ ", ";
			
			this.sentence = this.sentence.substring(0, this.sentence.length()-2)+ ".";



		}
	}

	public String getExpressionValue(String expression){

		return sy.main(expression);
	}

}
