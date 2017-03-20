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

public class Filter extends TRANSFORMATION implements ISentence{

	protected ArrayList<SOURCE> sources;
	protected ArrayList<TARGET> targets;
	protected ArrayList<CONNECTOR> connectors;
	protected static ShuntingYard sy = new ShuntingYard();

	protected String sentence;

	public Filter() {
		super();
		this.sources = new ArrayList<SOURCE>();
		this.targets = new ArrayList<TARGET>();
		this.sentence = new String();
	}

	public Filter(TRANSFORMATION transformation, ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts, ArrayList<CONNECTOR> conns) {
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

			this.sentence = this.sentence + " SELECT "+ "\n (";
			for(CONNECTOR c : necessaryConns)
				for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
					if(c.getFROMFIELD().equals(tf.getNAME()))
						this.sentence = this.sentence +"S."+tf.getNAME()+", ";


			for(SOURCE s : this.getSources()){
				this.sentence = this.sentence.substring(0, this.sentence.length()-2)+")\n " + " FROM " +s.getNAME()+" S ";
			}

			this.sentence = this.sentence+ "\n ";
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Filter Condition"))
					if(!ta.getVALUE().equals(""))
						this.sentence=this.sentence+" WHERE "+"\n "+sy.main(ta.getVALUE())+"\n ";

		}else if(XMLParser.getLanguage().equals("Español")){
			this.sentence = "Dado el origen " + this.sources.get(0).getNAME() + " se obtendrán los registros filtrados por la siguiente expresión: \n ";

			this.sentence= this.sentence + " SELECT \n ";
			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD())
				this.sentence=this.sentence+"S."+tf.getNAME()+", ";
			this.sentence=this.sentence+")\n ";
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Filter Condition"))
					if(!ta.getVALUE().equals(""))
						this.sentence=this.sentence+" WHERE "+"\n "+sy.main(ta.getVALUE())+"\n ";
			}
		

	}

}
