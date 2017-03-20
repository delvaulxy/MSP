package corp.everis.pwc.moam;

import java.util.ArrayList;

import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.SOURCEFIELD;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;
import notinuse.XMLParser;

public class Lookup extends TRANSFORMATION implements ISentence {

	protected ArrayList<SOURCE> sources;
	protected ArrayList<TARGET> targets;
	protected ArrayList<CONNECTOR> connectors;
	protected static ShuntingYard sy = new ShuntingYard();

	protected String sentence;

	public Lookup() {
		super();
		this.sources = new ArrayList<SOURCE>();
		this.targets = new ArrayList<TARGET>();
		this.sentence = new String();
	}

	public Lookup(TRANSFORMATION transformation, ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts, ArrayList<CONNECTOR> conns) {
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
			String condition = "";
		for(TARGET t : targets){
			this.sentence = "INSERT INTO "+ "\n " + t.getNAME()+ "\n (";
			for(CONNECTOR c : necessaryConns)
				for(TARGETFIELD tf : t.getTARGETFIELD())
					if(tf.getNAME().equals(c.getTOFIELD()))
						this.sentence = this.sentence + tf.getNAME()+",";
		}
		this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ ")\n ";
		this.sentence = this.sentence + " SELECT "+ "\n (";
		for(CONNECTOR c : necessaryConns){
			for(SOURCE src : this.getSources())
				for(SOURCEFIELD sf : src.getSOURCEFIELD())
					if(sf.getNAME().equals(c.getFROMFIELD()))
						this.sentence = this.sentence + " S."+sf.getNAME()+",";
			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
				if(!tf.getPORTTYPE().contains("INPUT"))
					if(c.getFROMFIELD().equals(tf.getNAME()))
						this.sentence = this.sentence + " L."+tf.getNAME()+",";
		}
		this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ ")\n FROM \n";
		
		for(SOURCE src : this.getSources())
			this.sentence = this.sentence+ src.getNAME() + " S \n LEFT OUTER JOIN \n";	
		
		for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
			if(ta.getNAME().equals("Lookup table name"))
				this.sentence = this.sentence+ ta.getVALUE() + " L \n ON \n";	
		
		// condition
		for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
			if(ta.getNAME().equals("Lookup condition"))
				condition = ta.getVALUE();
		
		for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
			if(!tf.getPORTTYPE().contains("INPUT"))
				condition = condition.replace(tf.getNAME(), "L."+tf.getNAME());
			else
				condition = condition.replace(tf.getNAME(), "S."+tf.getNAME());
		}		
		condition = condition.replace("L.S.", "S.");
		this.sentence = this.sentence + sy.main(condition)+ "\n ";
		
		}else 	if(XMLParser.getLanguage().equals("Español")){
			this.sentence = "Dado orígen " + this.getSources().get(0).getNAME() + "\n se buscán los campos \n";
			
			
			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
				if(tf.getPORTTYPE().contains("LOOKUP"))
					this.sentence = this.sentence + tf.getNAME()+",\n ";
			
			this.sentence = this.sentence.substring(0, this.sentence.length()-3);
			
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Lookup table name"))
					if(!ta.getVALUE().equals(""))
						this.sentence = this.sentence + " \n en origen \n" + ta.getVALUE() + "\n  a condición que ";
					else
						this.sentence = this.sentence +  "\n  a condición que ";
			
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Lookup condition"))
					this.sentence = this.sentence + ta.getVALUE();	
			
			this.sentence = this.sentence + ".";
		}
	}

}
