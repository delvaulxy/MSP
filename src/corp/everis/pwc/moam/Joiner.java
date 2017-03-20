package corp.everis.pwc.moam;

import java.util.ArrayList;

import corp.everis.pwc.moam.ISentence;
import corp.everis.pwc.moam.ShuntingYard;
import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.SOURCEFIELD;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;
import notinuse.XMLParser;

public class Joiner extends TRANSFORMATION implements ISentence{
	protected ArrayList<SOURCE> sources;
	protected ArrayList<TARGET> targets;
	protected ArrayList<CONNECTOR> connectors;
	protected static ShuntingYard sy = new ShuntingYard();

	protected String sentence;

	public Joiner() {
		super();
		this.sources = new ArrayList<SOURCE>();
		this.targets = new ArrayList<TARGET>();
		this.sentence = new String();
	}

	public Joiner(TRANSFORMATION transformation, ArrayList<SOURCE> srcs, ArrayList<TARGET> tgts, ArrayList<CONNECTOR> conns) {
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
		String master = "TGT_"+this.getNAME();
		String detail = "TGT_"+this.getNAME();
		String condition = "";

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

			// SELECT mastertable.field1, mastertable.field2, detailtable.field1,detailtable.field2 
			for(CONNECTOR c : necessaryConns)
				for(SOURCE s : this.getSources()){
					for(SOURCEFIELD sf : s.getSOURCEFIELD())
						if(sf.getNAME().equals(c.getFROMFIELD())){
							for(CONNECTOR oC : this.getConnnectors())
								if(oC.getTOINSTANCE().equals(c.getFROMINSTANCE()) && oC.getTOFIELD().equals(c.getFROMFIELD())
										&& oC.getFROMINSTANCE().equals("SQ_"+master+"1"))
									this.sentence = this.sentence + "M."+sf.getNAME()+", ";
								else if(oC.getTOINSTANCE().equals(c.getFROMINSTANCE()) && oC.getTOFIELD().equals(c.getFROMFIELD())
										&& oC.getFROMINSTANCE().equals("SQ_"+detail+"2"))
									this.sentence = this.sentence +"D."+sf.getNAME()+", ";
							
						}
								
			}

			// from master 
			this.sentence = this.sentence.substring(0, this.sentence.length()-1)+ ")\n ";
			this.sentence = this.sentence + " FROM "+ "\n "+ master + " M ";

			// JOINTYPE
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Join Type")){
					switch(ta.getVALUE()){
					case "Normal Join":
						// normal join --> inner join detail on
						this.sentence = this.sentence + " INNER JOIN " + "\n"+detail +" D \n" +"ON" +"\n" ;	
						break;
					case "Full Outer Join":
						// Full outer join --> outer join on 
						this.sentence = this.sentence + " FULL OUTER JOIN " + "\n"+detail +" D \n" +"ON" +"\n" ;
						break;
					case "Master Join":
						// Master Join --> right outer join on 
						this.sentence = this.sentence + " RIGHT OUTER JOIN " + "\n"+detail +" D \n" +"ON" +"\n" ;
						break;
					case "Detail Join":
						// Detail Join --> left outer join on
						this.sentence = this.sentence + " LEFT OUTER JOIN " + "\n"+detail +" D \n" +"ON" +"\n" ;
						break;

					}
				}
			// condition
			String tmp = "";
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Join Condition"))
					condition = ta.getVALUE();
			for(String s : condition.split(" ")){
				boolean passed = true;
				for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
					if(s.equals(tf.getNAME())){
						if(tf.getPORTTYPE().contains("MASTER")){
							s = "M."+tf.getNAME();
							tmp = tmp +" "+ s;
						}else {
							s = "D."+tf.getNAME();
							tmp = tmp +" "+ s;
						}
					}else if(SQLParser.isKeyWord(s) && passed){
						tmp = tmp +" "+ s;
						passed = false;
					}else if(SQLParser.isKeyWord(" "+s+" ") && passed){
						tmp = tmp +" "+ s;
						passed = false;
					}
				}
			}
			condition = tmp;
			this.sentence = this.sentence + sy.main(condition)+ "\n ";

			
		}else if(XMLParser.getLanguage().equals("Español")){
			String conditionSpanish = "";
			this.sentence = "CRISTINA: Dados los orígenes " + master + " (Master) y " + detail + " (Detail), se cruzarán según la condición: " + "\n "; 
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Join Condition"))
					conditionSpanish = ta.getVALUE();
			for(TRANSFORMFIELD tf : this.getTRANSFORMFIELD()){
				if(tf.getPORTTYPE().contains("MASTER"))
					conditionSpanish = conditionSpanish.replace(tf.getNAME(), "M."+tf.getNAME());
				else
					conditionSpanish = conditionSpanish.replace(tf.getNAME(), "D."+tf.getNAME());
			}
			this.sentence = this.sentence + conditionSpanish + "\n";
			this.sentence = this.sentence + "La salida tendrá: ";
			for(TABLEATTRIBUTE ta : this.getTABLEATTRIBUTE())
				if(ta.getNAME().equals("Join Type")){
					switch(ta.getVALUE()){
					case "Normal Join":
						// normal join --> inner join detail on
						this.sentence = this.sentence + "Todos los registros que coincidan de " + master + " y " + detail +".\n" ;     
						break;
					case "Full Outer Join":
						// Full outer join --> outer join on 
						this.sentence = this.sentence + "Todos los registros de " + master + " y " + detail +".\n" ;
						break;
					case "Master Join":
						// Master Join --> right outer join on 
						this.sentence = this.sentence + "Todos los registros de " + master + " y los que coincidan de " + detail +"\n" ;
						break;
					case "Detail Join":
						// Detail Join --> left outer join on
						this.sentence = this.sentence + "Todos los registros de " + detail + " y los que coincidan de " + master +"\n" ;
						break;

					}
				}

		}
	}

}
