package corp.everis.pwc.moam;

import java.util.ArrayList;

import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;
import notinuse.XMLParser;
import sun.security.krb5.internal.TGSRep;

public class Sorter extends TRANSFORMATION implements ISentence {
	protected ArrayList<SOURCE> sources;
	protected ArrayList<TARGET> targets;
	protected ArrayList<CONNECTOR> connectors;
	protected static ShuntingYard sy = new ShuntingYard();

	protected String sentence;

	public Sorter() {
		super();
		this.sources = new ArrayList<SOURCE>();
		this.targets = new ArrayList<TARGET>();
		this.sentence = new String();
	}

	public Sorter(TRANSFORMATION transformation, ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts, ArrayList<CONNECTOR> conns) {
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
			for(TARGET t : targets){
				this.sentence = "INSERT INTO "+ "\n " + t.getNAME()+ "\n (";
				for(CONNECTOR c : necessaryConns)
					for(TARGETFIELD tf : t.getTARGETFIELD())
						if(c.getTOFIELD().equals(tf.getNAME()))
							this.sentence = this.sentence +tf.getNAME()+",";
			}
			this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ ")\n ";

			this.sentence = this.sentence + " SELECT ";
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Distinct"))
					if(ta.getVALUE().equals("YES"))
						this.sentence = this.sentence + "DISTINCT " + "\n";
					else
						this.sentence = this.sentence + "\n";
			for(CONNECTOR c : necessaryConns)
				for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
					if(tf.getNAME().equals(c.getFROMFIELD()))
						this.sentence = this.sentence +"S."+tf.getNAME()+", ";


			for(SOURCE s : this.getSources()){
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+")\n " + " FROM " +s.getNAME()+" S ";
			}

			this.sentence = this.sentence+ "\n "+" ORDER BY "+ "\n ";
			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
				switch(tf.getSORTDIRECTION()){
				case "ASCENDING" : 
					this.sentence = this.sentence + this.getSources().get(0).getNAME()+"."+tf.getNAME()+" ASC, ";	
					break;
				case "DESCENDING" : 
					this.sentence = this.sentence + this.getSources().get(0).getNAME()+"."+tf.getNAME()+" DESC, ";	
					break;
				}
			}
			this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ "\n ";
		
		}else if(XMLParser.getLanguage().equals("Español")){
			
			this.sentence = "Dado orígen " + this.getSources().get(0).getNAME() + " cogemos ";
			
			if(this.getTRANSFORMFIELD().size()==1)
				this.sentence =this.sentence +  " el campo \n ";
			else if(this.getTRANSFORMFIELD().size()>1)
				this.sentence = this.sentence +" los campos \n ";

			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
				this.sentence = this.sentence + tf.getNAME() + " ordenado de manera ";
					if(tf.getSORTDIRECTION().equals("ASC"))
						this.sentence = this.sentence + " ascendente, \n";
					else
						this.sentence = this.sentence + " descendente,\n ";	
			}
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Distinct") && ta.getNAME().equals("YES"))
					this.sentence = this.sentence.substring(0, this.sentence.length()-2) + ta.getVALUE() + "\n con datos distintos.  \n ";
				else
					this.sentence = this.sentence.substring(0, this.sentence.length()-2) + ".";
		}
	}
}
