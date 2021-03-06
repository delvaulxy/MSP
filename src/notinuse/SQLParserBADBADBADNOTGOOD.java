package notinuse;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;

import corp.everis.pwc.moam.MappingParser;
import corp.everis.pwc.raw.ASSOCIATEDSOURCEINSTANCE;
import corp.everis.pwc.raw.ATTRIBUTE;
import corp.everis.pwc.raw.CONFIG;
import corp.everis.pwc.raw.CONNECTOR;
import corp.everis.pwc.raw.FOLDER;
import corp.everis.pwc.raw.INSTANCE;
import corp.everis.pwc.raw.MAPPING;
import corp.everis.pwc.raw.POWERMART;
import corp.everis.pwc.raw.REPOSITORY;
import corp.everis.pwc.raw.SOURCE;
import corp.everis.pwc.raw.SOURCEFIELD;
import corp.everis.pwc.raw.TABLEATTRIBUTE;
import corp.everis.pwc.raw.TARGET;
import corp.everis.pwc.raw.TARGETFIELD;
import corp.everis.pwc.raw.TARGETLOADORDER;
import corp.everis.pwc.raw.TRANSFORMATION;
import corp.everis.pwc.raw.TRANSFORMFIELD;

public class SQLParserBADBADBADNOTGOOD {

	static ArrayList<String> sfOther = new ArrayList<String>();
	static ArrayList<String> sOldTables = new ArrayList<String>();
	static String qry = "SELECT CAST(CURRENT_DATE-1 (FORMAT 'YYYYMMDD')) AS f.CURRENT_DATE  FROM CTL_FECHAS_DM_V  f "
			+ "INNER JOIN CTL_LOG_PROCESOS l1 ON ( l1.fecha_carga = CURRENT_DATE - 1 ) "
			+ "INNER JOIN CTL_LOG_PROCESOS l2 ON ( l2.fecha_carga = CURRENT_DATE-1 ) "
			+ "INNER JOIN DIM_DIA d  ON ( d.fec_dia = CURRENT_DATE ) "
			+ "WHERE f.datamart = 'FASE_SAS' AND f.fec_ultima_carga_dm_empezada = f.fec_ultima_carga_dm_finalizada "
			+ "AND f.fec_ultima_carga_dm_empezada < CURRENT_DATE -1 AND l1.proceso = 'fac_picos_gdp' "
			+ "AND l1.fecha_fin IS NOT NULL AND l2.proceso = 'fac_inventario_actual'  "
			+ "AND l2.fecha_fin IS NOT NULL AND d.id_dia_de_semana <> 7 GROUP BY 1";
	//static String qry = "SELECT A.A1,A.A2,C.C1 FROM TBLA A LEFT OUTER JOIN TBLB B ON A.A1 = B.B1 LEFT OUTER JOIN TBLC C ON B.B1 = C.C1";
	//static String qry = "SELECT SUM ( A.A + B.B ) FROM ( SELECT A.A,B.B, ( SELECT C.C FROM TBLA A INNER JOIN TBLC C ON C.C = A.A ) AS C FROM TBLB B INNER JOIN ( SELECT B.B FROM TBL B ) AS B";
	//static String qry = "SELECT NOMIX.CIFNIF AS NIF_CLIENTE,NOMIX.NUM_CLIENTE,NOMIX.COD_ESTADO_GENERAL,NOMIX.TIPO_DOCUMENTO_NORM,NOMIX.CLASE_CLI_COD_CLASE_CLIENTE,NOMIX.DES_TIPO_CLIENTE,NOMIX.DES_SUBTIPO_CLIENTE,NOMIX.CIF_CABECERA,SEGM_ACT.COD_SEGMENTO AS COD_SEGM_ANT, SEGM_ACT.FEC_SEGMENTO,NOMIX.GRUPO_COMERCIAL,NOMIX.ANTIG_MESES,NOMIX.FEC_INSTALACION,CURRENT_TIMESTAMP AS FECHA_CARGA	FROM ${DBDWHV}.${V_MS_CLIENTES_NO_MIXTOS} NOMIX	LEFT OUTER JOIN (SELECT ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}.NIF_CLIENTE, ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}.COD_SEGMENTO, ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}.FEC_SEGMENTO FROM ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}) SEGM_ACT ON NOMIX.CIFNIF =SEGM_ACT.NIF_CLIENTE WHERE CAST(NOMIX.FEC_INSTALACION AS DATE FORMAT 'YYYYMMDD') > CAST('${FEC_ANT}' AS DATE FORMAT 'YYYYMMDD') 	AND  CAST(NOMIX.FEC_INSTALACION AS DATE FORMAT 'YYYYMMDD') <= CAST('${FEC_ACT}' AS DATE FORMAT 'YYYYMMDD')";


	/*
	 *  The keywords we use/filter with at the moment
	 */

	final static String kw = new String(""
			+ "(?<=FROM)|(?=FROM)|"
			+ "(?<!LEFT\\sOUTER|RIGHT\\sOUTER)(?=\\sJOIN\\s)|"
			+ "(?<!LEFT\\sOUTER|RIGHT\\sOUTER)(?<=\\sJOIN\\s)|"
			+ "(?=LEFT\\sOUTER|RIGHT\\sOUTER)(?!\\sJOIN\\s)|"
			+ "(?<=LEFT\\sOUTER|RIGHT\\sOUTER)(?!\\sJOIN\\s)|"
			+ "(?<=LEFT\\sOUTER\\sJOIN\\s|RIGHT\\sOUTER\\sJOIN\\s)|"
			+ "(?=LEFT\\sOUTER\\sJOIN\\s|RIGHT\\sOUTER\\sJOIN\\s)|"
			+ "(?<=FULL\\sOUTER\\sJOIN\\s|INNER\\sJOIN\\s)|"
			+ "(?=FULL\\sOUTER\\sJOIN\\s|INNER\\sJOIN\\s)|"
			+ "(?<=\\sON\\s)|(?=\\sON\\s)|"
			+ "(?<=\\sAND\\s)|(?=\\sAND\\s)|"
			+ "(?<=\\sWHERE\\s)|(?=\\sWHERE\\s)|"
			+ "(?<=\\sAS\\s)|(?=\\sAS\\s)|"
			+ "(?<=\\sSELECT\\s)|(?=\\sSELECT\\s)|"
			+ "(?<=\\bSELECT\\s)|(?=\\bSELECT\\s)|"
			+ "(?<=\\sSUM\\s)|(?=\\sSUM\\s)|"
			+ "(?<=\\sSUM)|(?=\\sSUM)|"
			+ "(?<=\\sIS NOT NULL)|(?=\\sIS NOT NULL)|"
			+ "(?<==)|(?==)|"
			+ "(?<=<)|(?=<)|"
			+ "(?<=\\+)|(?=\\+)|"
			+ "(?<=\\-)|(?=\\-)|"
			+ "(?<=>)|(?=>)|"
			+ "(?<=\\))|(?=\\))|"
			+ "(?<=\\()|(?=\\()");

	public static ArrayList<POWERMART> powermarts = new ArrayList<POWERMART>();

	public String main(String s){
		qry = qry.toUpperCase();
		qry = qry.replace("  ", " ");
		for(String part : qry.split(kw))
			System.out.println(part);
		return s;
	}


	public SQLParserBADBADBADNOTGOOD() {
		super();
	}

	public static void main(String[] args) {
		// WE DISSECT THE ORIGINAL QUERY
		qry = qry.toUpperCase();
		while(qry.contains("  "))
			qry = qry.replace("  ", " ");
		System.out.print("ORIGINAL QUERY:   "+qry+"\n");
		String tmpquery = qry;
		int pos = 0;
		while(pos!=tmpquery.length()-1){
			if(tmpquery.substring(pos,pos+1).equals(".")){
				String alias = "";
				String fieldname = "";
				alias = tmpquery.substring(0,pos).trim();
				alias = alias.substring(alias.lastIndexOf(" ")).trim();
				if(alias.contains(","))
					alias = alias.substring(alias.lastIndexOf(",")+1).trim();
				fieldname = tmpquery.substring(pos+1).trim();
				if(fieldname.contains(" "))
					fieldname = fieldname.substring(0,fieldname.indexOf(" "));
				tmpquery = tmpquery.replaceFirst(alias+"."+fieldname, alias+"."+alias+fieldname);
			}
			pos++;
		}

		System.out.println("FINAL QUERY:  "+dissectQRY(updateAliases(tmpquery)));

	}

	/* 	
	 *	This function dissects the query. First it checks if the 
	 *	query contains a subquery. If it does, it calls itself and passes 
	 *	that subquery as a parameter. It does the same with joins and where's.
	 *
	 * 	@param	query	The query to dissect
	 * 	@return 		The updated query.
	 */
	private static String dissectQRY(String query){
		String s = query;
		String tmp = query;
		

		
		/*
		 * 	Find all sourcetables and create a sourceobject.
		 */
		ArrayList<String> alAliases = new ArrayList<String>();
		ArrayList<SOURCE> srcs = new ArrayList<SOURCE>();

		while(tmp.contains(".")){
			String alias = "";
			if(tmp.trim().contains(" ") && tmp.trim().indexOf(" ")<tmp.indexOf("."))
				alias = tmp.substring(0, tmp.indexOf(".")).substring(
					tmp.substring(0, tmp.indexOf(".")).lastIndexOf(" ")).trim();
			else
				alias = tmp.substring(0, tmp.indexOf(".")).trim();
			if(!alAliases.contains(alias)){
				alAliases.add(alias);	
			}
			
			tmp = tmp.substring(tmp.indexOf(".")+1);
		}
		tmp = query;
		/*
		 * 	Create Source, look for sourcefields and add them to the source.
		 */
		for(String alias : alAliases){
			int fieldnum = 0;
			int physicaloffset = 0;

			SOURCE src = new SOURCE("TBL_"+alias,"DB2","","","1","","DB2","1");
			while(tmp.contains(alias+".")){
				fieldnum ++;
				tmp = tmp.substring(tmp.indexOf(alias+".")+alias.length()+1);
				src.getSOURCEFIELD().add(new SOURCEFIELD(tmp.substring(0,tmp.indexOf(" ")),"","","varchar",
						"NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),
						Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO"));
				physicaloffset = physicaloffset + 10;
				
			}
			srcs.add(src);
		}
		
		if(s.contains(" WHERE ")){
			tmp = query.substring(query.indexOf(" WHERE ")+7);
			if(tmp.contains(" GROUP BY "))
				tmp = tmp.substring(0,tmp.indexOf(" GROUP BY "));
			if(tmp.contains(" ORDER BY "))
				tmp = tmp.substring(0,tmp.indexOf(" ORDER BY "));
			for(String alias : alAliases){
				if(tmp.contains(alias+".")){
					/*
					 * Create filter for that source.
					 */
					
				}
			}
		}
		
		// CHECK FOR SUBQUERIES
		Pattern p = Pattern.compile("\\(SELECT|\\([\\s]*SELECT");
		Matcher m = p.matcher(query);

		while(m.find()){
			tmp = s.substring(s.indexOf("SELECT")).trim();
			int iCheckBetween = 0;
			if(tmp.startsWith("(")){
				iCheckBetween = 1;
				int iPosition = s.indexOf("SELECT");
				while(0<iCheckBetween){
					if(tmp.substring(0, 1).equals("(")){
						iCheckBetween++;
						iPosition++;
						tmp.substring(1);
					}else if(tmp.substring(0, 1).equals(")")){
						iCheckBetween--;
						iPosition++;
						tmp.substring(1);
					}
				}
				s = s.replace(s.substring(s.indexOf("SELECT"),iPosition-1).trim(), dissectQRY(s.substring(s.indexOf("SELECT"),iPosition-1).trim()));
			}
		}

		// CHECK FOR SUBQUERIES
		p = Pattern.compile(" JOIN ");
		m = p.matcher(s);
		
		while(m.find()){
			tmp = s.substring(0,s.lastIndexOf("JOIN"));
			if(tmp.contains(" JOIN ")){
				if(tmp.trim().endsWith("INNER")){
					s= s.replace(tmp.trim().substring(0,tmp.trim().lastIndexOf("INNER")-1).trim(),
							dissectQRY(tmp.trim().substring(0,tmp.trim().lastIndexOf("INNER")-1).trim()));
				}else if(tmp.trim().endsWith("OUTER")){
					s = s.replace(tmp.substring(0,tmp.lastIndexOf("OUTER")-1).trim().substring(0,
							tmp.substring(0,tmp.lastIndexOf("OUTER")-1).trim().lastIndexOf(" ") ), 
							dissectQRY(tmp.substring(0,tmp.lastIndexOf("OUTER")).trim().substring(0,
									tmp.substring(0,tmp.lastIndexOf("OUTER")).trim().lastIndexOf(" ") )));
				}
			}
		}
		if(s.contains("WHERE"))
			s = analyzeQRY(s);
		s = analyzeQRY(s);
		// CHECK FOR SUBQUERIES

		
	

		return updateAliases(s);
				
	}
	

	/*
	 * 	This function counts the number of joins in the given query
	 * 
	 * 	@param	query	The query to analyze.
	 *	@return			An integer representing the number of joins in the query.				
	 */
	private static Integer countJoins(String qry){
		Pattern p = Pattern.compile(" JOIN ");
		Matcher m = p.matcher(qry);
		Integer count = 0;
		while (m.find()){
			// COUNT HOW MANY TIMES 'JOIN' OCCURS IN THE QUERY
			count +=1;
		}		
		return count;
	}

	/*
	 * 	This function updates the aliases of the query.
	 * 	It will look for the tablenames and check if their alias 
	 * 	corresponds.
	 * 
	 * 	@param	query	The query to update.
	 * 	@return			The updated query.
	 */
	private static String updateAliases(String query){
		String tmpquery = query;
		ArrayList<String> fields = new ArrayList<String>(); 
		Pattern p = Pattern.compile("\\w+\\.\\w+");
		Matcher m = p.matcher(query);
		while(m.find())
			if(!fields.contains(m.group()))
				fields.add(m.group());
		for(String s : fields){
			for(int i = 0;i<fields.size()-1;i++){
				String compare = fields.get(i);
				if(!s.equals(compare) && s.contains(".") && compare.contains(".") && compare.substring(compare.indexOf(".")).equals(s.substring(s.indexOf(".")))){
					tmpquery = tmpquery.replace(compare, s);
					fields.set(i, s);
				}
			}
		}

		return tmpquery;
	}

	private static void createJoiner(String query){
		SOURCE masterSrc = new SOURCE("","DB2","","","1","","DB2","1");
		SOURCE detailSrc = new SOURCE("","DB2","","","1","","DB2","1");

		String tmp = "";
//		if(query.contains("FULL OUTER JOIN")){
//
//			masterSrc.setNAME(query.substring(query.indexOf(" FROM ")+6).substring(0, query.substring(query.indexOf(" FROM ")+6).indexOf(" ")));
//			masterSrc.setAlias(query.substring(0, query.indexOf(" FULL OUTER JOIN ")).trim().substring(query.substring
//					(0, query.indexOf(" FULL OUTER JOIN ")).trim().lastIndexOf(" ")));
//			
//			detailSrc.setNAME(query.substring(query.indexOf(" FULL OUTER JOIN ")+6).substring(0, query.substring(query.indexOf(" FULL OUTER JOIN ")+17).indexOf(" ")));
//			detailSrc.setAlias(query.substring(0, query.indexOf(" ON ")).trim().substring(query.substring
//					(0, query.indexOf(" ON ")).trim().lastIndexOf(" ")));
//			
//		}else if(query.contains("LEFT OUTER JOIN")){
//			
//			masterSrc.setNAME(query.substring(query.indexOf(" FROM ")+6).substring(0, query.substring(query.indexOf(" FROM ")+6).indexOf(" ")));
//			masterSrc.setAlias(query.substring(0, query.indexOf(" LEFT OUTER JOIN ")).trim().substring(query.substring
//					(0, query.indexOf(" LEFT OUTER JOIN ")).trim().lastIndexOf(" ")));
//			
//			detailSrc.setNAME(query.substring(query.indexOf(" LEFT OUTER JOIN ")+6).substring(0, query.substring(query.indexOf(" LEFT OUTER JOIN ")+17).indexOf(" ")));
//			detailSrc.setAlias(query.substring(0, query.indexOf(" ON ")).trim().substring(query.substring
//					(0, query.indexOf(" ON ")).trim().lastIndexOf(" ")));
//
//		}else if(query.contains("RIGHT OUTER JOIN")){
//			
//			masterSrc.setNAME(query.substring(query.indexOf(" FROM ")+6).substring(0, query.substring(query.indexOf(" FROM ")+6).indexOf(" ")));
//			masterSrc.setAlias(query.substring(0, query.indexOf(" RIGHT OUTER JOIN ")).trim().substring(query.substring
//					(0, query.indexOf(" RIGHT OUTER JOIN ")).trim().lastIndexOf(" ")));
//			
//			detailSrc.setNAME(query.substring(query.indexOf(" RIGHT OUTER JOIN ")+6).substring(0, query.substring(query.indexOf(" RIGHT OUTER JOIN ")+17).indexOf(" ")));
//			detailSrc.setAlias(query.substring(0, query.indexOf(" ON ")).trim().substring(query.substring
//					(0, query.indexOf(" ON ")).trim().lastIndexOf(" ")));
//
//		}else if(query.contains("INNER JOIN")){
//			
//			masterSrc.setNAME(query.substring(query.indexOf(" FROM ")+6).substring(0, query.substring(query.indexOf(" FROM ")+6).indexOf(" ")));
//			masterSrc.setAlias(query.substring(0, query.indexOf(" INNER JOIN ")).trim().substring(query.substring
//					(0, query.indexOf(" INNER JOIN ")).trim().lastIndexOf(" ")));
//			
//			detailSrc.setNAME(query.substring(query.indexOf(" INNER JOIN ")+6).substring(0, query.substring(query.indexOf(" INNER JOIN ")+17).indexOf(" ")));
//			detailSrc.setAlias(query.substring(0, query.indexOf(" ON ")).trim().substring(query.substring
//					(0, query.indexOf(" ON ")).trim().lastIndexOf(" ")));
//		
//		}
		TRANSFORMATION masterSQ = new TRANSFORMATION("SQ_"+masterSrc.getNAME(),"Source Qualifier","1","NO","1");

		TRANSFORMATION detailSQ = new TRANSFORMATION("SQ_"+detailSrc.getNAME(),"Source Qualifier","1","NO","1");
		
		TRANSFORMATION joiner = new TRANSFORMATION("","Joiner","1","NO","1");
		TARGET target = new TARGET();
	}
	
	
	
	
	/*
	 * 	This function checks the query to see what kind of mapping
	 * 	it needs to be transformed into. It checks i.e. if the query
	 * 	is a join and calls the corresponding function to create the mapping.
	 * 
	 * 	@param s	The query.
	 */
	private static String analyzeQRY(String s){
		s = updateAliases(s);
		String sDAlias = "";
		String sDName = ""; 
		String sMAlias = "";
		String sMName = "";
		String joinType = "";
		String tmp = "";
		ArrayList<String> sfMNames = new ArrayList<String>();
		ArrayList<String> sfDNames = new ArrayList<String>();
		ArrayList<String> tfNames = new ArrayList<String>();
		sfOther = new ArrayList<String>();
		sOldTables = new ArrayList<String>();
		ArrayList<String> conds = new ArrayList<String>();
		POWERMART p = new POWERMART();

		
		if(s.contains("JOIN")){
			SOURCE masterSrc = new SOURCE();
			SOURCE detailSrc = new SOURCE();
			TRANSFORMATION masterSQ = new TRANSFORMATION();
			TRANSFORMATION detailSQ = new TRANSFORMATION();
			TRANSFORMATION joiner = new TRANSFORMATION();
			TARGET target = new TARGET();

			// IF THE QUERY CONTAINS 'JOIN', WE CHECK WHAT KIND OF JOIN IT IS.
			// WE STORE THE NAME OF THE MASTER TABLE, DETAIL TABLE, MASTER ALIAS AND DETAIL ALIAS.
			if(s.contains("FULL OUTER JOIN")){
				
				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("FULL OUTER JOIN"));
				sMName = sMAlias.trim();
				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
				sMAlias = sMAlias.trim();
				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
				sDAlias = s.substring(s.indexOf("FULL OUTER JOIN")+15,s.indexOf(" ON "));
				sDName = sDAlias.trim();
				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
				sDAlias = sDAlias.trim();
				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
				joinType = "FOJ";
			}else if(s.contains("LEFT OUTER JOIN")){
				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("LEFT OUTER JOIN"));
				sMName = sMAlias.trim();
				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
				sMAlias = sMAlias.trim();
				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
				sDAlias = s.substring(s.indexOf("LEFT OUTER JOIN")+15,s.indexOf(" ON "));
				sDName = sDAlias.trim();
				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
				sDAlias = sDAlias.trim();
				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
				joinType = "LOJ";
			}else if(s.contains("RIGHT OUTER JOIN")){
				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("RIGHT OUTER JOIN"));
				sMName = sMAlias.trim();
				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
				sMAlias = sMAlias.trim();
				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
				sDAlias = s.substring(s.indexOf("RIGHT OUTER JOIN")+16,s.indexOf(" ON "));
				sDName = sDAlias.trim();
				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
				sDAlias = sDAlias.trim();
				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
				joinType = "ROJ";
			}else if(s.contains("INNER JOIN")){
				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("INNER JOIN"));
				sMName = sMAlias.trim();
				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
				sMAlias = sMAlias.trim();
				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
				sDAlias = s.substring(s.indexOf("INNER JOIN")+10,s.indexOf(" ON "));
				sDName = sDAlias.trim();
				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
				sDAlias = sDAlias.trim();
				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
				joinType = "IJ";
			}
			// WE KEEP THESE ALIASES IN AN ARRAYLIST SO THAT WE CAN REPLACE THEM AFTERWARDS IN THE ORIGINAL 
			// QUERY WITH THE NEW TABLENAME.
			sOldTables.add(sMAlias);
			sOldTables.add(sDAlias);

			// WE GET ALL THE FIELDNAMES, BY TAKING A SUBSTRING FROM AFTER THE SELECT UNTIL THE 'FROM' KEYWORD.
			// AFTER THIS WE TAKE THE CONDITION AND TAKE ALL THE WORDS THAT AREN'T KEYWORDS.
			tmp = s.trim().substring(s.trim().indexOf(" ")+1, s.trim().indexOf("FROM"));
			//			while(s.contains(" "+sMAlias+"."))
			//				s = s.replace(" "+sMAlias+".", " ");
			//			while(s.contains(" "+sDAlias+"."))
			//				s = s.replace(" "+sDAlias+".", " ");

			conds = getJoinCondition(s.substring(s.indexOf("ON")));

			for(String condition : conds)
				for(String var : condition.split(kw))
					if(!isKeyWord(var) && !NumberUtils.isCreatable(var.trim()))
						tmp = tmp +","+ var;
			// FOR EACH OF THE FIELDNAMES, WE CHECK IF IT'S PRECEDED BY THE MASTERALIAS, DETAILALIAS OR ANOTHER ONE,
			// AND ADD THEM TO A CORRESPONDING ARRAYLIST.
			for(String tablefield : tmp.split(",")){
				tablefield = tablefield.trim();
				if(tablefield.contains(".")){
					if(tablefield.substring(0, tablefield.indexOf(".")).equals(sMAlias)){
						tablefield = tablefield.substring(tablefield.indexOf(".")+1);
						if(!sfMNames.contains(tablefield)){
							sfMNames.add(tablefield);
							tfNames.add(tablefield);
						}
					}else if(tablefield.substring(0, tablefield.indexOf(".")).equals(sDAlias)){
						tablefield = tablefield.substring(tablefield.indexOf(".")+1);
						if(!sfDNames.contains(tablefield)){
							sfDNames.add(tablefield);
							tfNames.add(tablefield);
						}
					}
				}else{
					if(!sfOther.contains(tablefield))
						sfOther.add(tablefield);
				}



			}


			// WE HAVE ALL THE NECESSARY DATA TO CONVERT THE QUERY TO A MAPPING/POWERCENTER OBJECT.
			p = convToJoiner(sMName, sMAlias,sfMNames, sDName, sDAlias, sfDNames,  tfNames, conds, joinType);

		}else if(s.contains(" WHERE ")){
			// GET THE TABLENAME
			sMAlias = s.substring(s.indexOf("FROM")+4).trim();
			if(0 < sMAlias.indexOf(" ")){
				sMName = sMAlias.substring(0, sMAlias.indexOf(" ")).trim();;
				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
				sMAlias = sMAlias.substring(0,sMAlias.indexOf(" ")).trim();
			}else{
				sMName = sMAlias;
			}
			// GET THE WHERE CONDITION(S)
			String filtercondition = s.substring(s.indexOf(" WHERE ")+7);

			// GET THE SOURCEFIELDS
			tmp = s.substring(s.trim().indexOf(" ")+1, s.indexOf(" FROM "));
			for(String var : s.substring(s.indexOf(" WHERE ")+7).split(kw))
				if(!isKeyWord(var) && !NumberUtils.isCreatable(var.trim()) )
					tmp = tmp +","+ var;
			for(String sfn : tmp.split(",")){
				if(!sfn.trim().startsWith("'") && !sfn.trim().endsWith("'")){
					if(sfn.trim().contains(" AS "))
						sfMNames.add(sfn.substring(sfn.indexOf(" AS ")+4));
					if(0<=sfn.trim().indexOf(sMAlias+".")){
						if(!sfMNames.contains(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2))){
							sfMNames.add(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2));
						}
					}else
						sfOther.add(sfn.trim());
				}
			}

			p = convToSelFil(sMName, sMAlias, sfMNames, filtercondition);

		}else{
			// NO TRANSFORMATION, JUST SELECT INSERT.

			// GET THE TABLENAME
			sMAlias = s.substring(s.indexOf("FROM")+4).trim();
			if(0 < sMAlias.indexOf(" ")){
				sMName = sMAlias.substring(0, sMAlias.indexOf(" ")).trim();;
				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
			}else{
				sMName = sMAlias;
			}

			// GET THE SOURCEFIELDS
			tmp = s.substring(s.trim().indexOf(" ")+1, s.indexOf("FROM"));
			if(tmp.contains(",")){
				for(String sfn : tmp.split(",")){
					if(sfn.trim().contains(" AS "))
						sfn = sfn.substring(sfn.indexOf(" AS ")+4);
					if(0<=sfn.trim().indexOf(sMAlias+"."))
						sfMNames.add(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2));
					else
						sfOther.add(sfn.trim());
				}
			}else 
				if(0<tmp.length()){
					if(tmp.trim().contains(" AS "))
						tmp = tmp.substring(tmp.indexOf(" AS ")+4);
					if(0<=tmp.trim().indexOf(sMAlias+"."))
						sfMNames.add(tmp.trim().substring(tmp.trim().indexOf(sMAlias+".")+2));
					else
						sfOther.add(tmp.trim());
				}

			p = convToSelIns(sMName, sMAlias, sfMNames);

		}

		/*	
		 * MappingParser.generateDDL(p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0));
		for (SOURCE src :  p.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE()){
			MappingParser.generateDDL(src);
		}
		 */	
		MappingParser.writeToXML(p);
		System.out.println(s);
		powermarts.add(p);

		tmp = "";
		/*
		 * 	We build the new query to replace it in the original afterwards.
		 */
		if(sfOther.isEmpty()){
			tmp = " SELECT ";
			for(TARGET t : p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET()){
				for(TARGETFIELD tf : t.getTARGETFIELD())
					tmp = tmp + sMAlias +"."+ tf.getNAME() + ", ";
				if(tmp.contains(","))
					tmp = tmp.substring(0,tmp.lastIndexOf(",")) + " FROM " +t.getNAME()+" "+sMAlias;
			}

		}else{
			tmp = " SELECT ";
			for(TARGETFIELD tf : p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getTARGETFIELD())
				tmp = tmp + sMAlias +"."+tf.getNAME() + ", ";
			for(String sf : sfOther)
				tmp = tmp + sf + ", ";

			tmp = tmp.substring(0,tmp.lastIndexOf(",")) + " FROM " +p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getNAME()+" "+sMAlias;

		}
		if(s.contains("WHERE") && !tmp.contains(" WHERE ")){
			tmp = tmp + s.substring(s.indexOf(" WHERE "));
		}else if(s.contains("WHERE")){
			tmp = tmp.substring(0,tmp.indexOf(" WHERE "));
		}
		sfOther.clear();

		return tmp;
	}

	private static ArrayList<String> getFilterCondition(String alias, String sWhere){
		/*
		 * We split the 'Where'-condition, and check if that part contains a field from our source.
		 */
		sWhere = sWhere.trim();
		String tmp = "";
		String condition = "";
		while(sWhere.contains(" ")){
			tmp = sWhere.substring(0,sWhere.indexOf(" "));
			
		}
		
		return null;
	}
	
	
	/*
	 * 	This function gets the joincondition of the given joinquery.
	 * 
	 * 	@param	s	The query with the join.
	 * 	@return		It returns an ArrayList of Strings with all the conditions.
	 */
	private static ArrayList<String> getJoinCondition(String s){
		// FUNCTION THAT RETURNS AN ARRAYLIST OF STRINGS
		// WITH THE JOINCONDITION.
		ArrayList<String> conds = new ArrayList<String>();
		String condition = "";
		// WE CHECK WHERE THE CONDITION STARTS (AFTER THE ON IN THE JOIN)
		int i = s.indexOf("ON");
		String tmp = s.substring(i+3).trim();
		tmp = tmp.trim();
		if(tmp.startsWith("("))
			tmp = tmp.substring(1).trim();
		if(tmp.endsWith(")"))
			tmp = tmp.substring(0, tmp.length()-1).trim();


		String keyw ="";
		while(!tmp.equals("") && !keyw.equals("WHERE")){
			if(!isKeyWord(" "+keyw+" ")&&tmp.contains(" ")){
				// IF THE STRING ISN'T A KEYWORD AND THE CONDITION CONTAINS AN EMPTY SPACE 
				// WE ADD THE NEXT PART TO THE CONDITION, FROM THE START UNTIL
				// THE NEXT SPACE.
				condition = condition + tmp.substring(0, tmp.indexOf(" ")+1);
				// WE SET TMP = SUBSTRING STARTING AFTER THE NEXT SPACE.
				tmp = tmp.substring(tmp.indexOf(" ")+1);
				// IN CASE THERE'S STILL ANOTHER SPACE IN TMP
				// WE SET KEYW = THE SUBSTRING FROM THE START UNTIL THAT SPACE,
				// SO THAT WE CAN CHECK IT AGAIN.
				if(tmp.indexOf(" ")>0)
					keyw = tmp.substring(0,tmp.indexOf(" "));
			}else if(tmp.contains(" ") && !keyw.trim().equals("AND") && !keyw.trim().equals(")") && !keyw.trim().equals("OR")){
				condition = condition + tmp.substring(0, tmp.indexOf(" ")+1);
				tmp = tmp.substring(tmp.indexOf(" ")+1);
				if(tmp.indexOf(" ")>0)
					keyw = tmp.substring(0,tmp.indexOf(" "));
			}else if(!tmp.contains(" ")){
				// IN CASE KEYW IS A KEYWORD AND DOESN'T CONTAIN AN EMPTY SPACE 
				// WE ADD IT TO THE CONDITION AND ADD THAT CONDITION TO THE ARRAYLIST
				condition = condition + tmp;
				tmp = "";
				conds.add(condition);
				// WE RESET THE CONDITIONSTRING AND KEYWORDS
				condition = "";
				keyw = "";
			}else {
				// IN CASE WE DON'T HAVE ANY SPACES LEFT, 
				// WE CAN ASSUME WE'RE AT THE LAST KEYWORD OF OUR CONDITION
				// AND FINISH IT UP.
				tmp = tmp.substring(keyw.length());
				conds.add(condition);
				condition = "";
				keyw = "";
			}
		}
		return conds;
	}

	/*
	 * 	This function creates a POWERMART-object containing a mapping
	 * 	with a joinertransformation, based on the given join-query.
	 * 
	 * 	@param	mSrc	The name of the Master source table.
	 * 	@param	sMAlias	The alias of the Master source table.
	 * 	@param	sfM		An ArrayList of the sourcefieldnames from the Master source table.
	 * 	@param	dSrc	The name of the Detail source table.
	 * 	@param	sDAlias	The alias of the Detail source table.
	 * 	@param	sfD		An ArrayList of the sourcefieldnames from the Detail source table.
	 * 	@param 	tfss	An ArrayList of the targetfieldnames from both source tables.
	 * 	@param	conds	An ArrayList with the joinconditions.
	 * 	@param	joinType	The type of join.
	 * 	@return			A POWERMART object containing the mapping with the jointransformation.
	 */
	private static POWERMART convToJoiner(String mSrc, String sMAlias,ArrayList<String> sfM, String dSrc, String sDAlias,ArrayList<String> sfD, ArrayList<String> tfss, ArrayList<String> conds, String joinType){
		MAPPING map = new MAPPING();
		FOLDER folder = new FOLDER("XDW991593" ,"Everis : Antonio Jesus, Group for Global Corporate Teaser Tool(GCT), Developer, antonio.jesus.munoz.lapaz@zurich.com" ,"NOTSHARED","w991593" ,"","rwx---r--" ,"55cd59eb-588d-4840-8dee-97c3257a4945");
		int i;

		INSTANCE inst = new INSTANCE();
		ArrayList<INSTANCE> insts = new ArrayList<INSTANCE>();
		CONNECTOR con = new CONNECTOR();
		ArrayList<CONNECTOR> cons = new ArrayList<CONNECTOR>();
		String cond = "";

		mSrc = mSrc.replace(".", "");
		mSrc = mSrc.replace("SRC_", "");
		mSrc = mSrc.replace("", "");
		mSrc.substring(0,mSrc.length()/2);
		dSrc = dSrc.replace(".", "");
		dSrc = dSrc.replace("SRC_", "");
		dSrc = dSrc.replace("", "");
		dSrc.substring(0,mSrc.length()/2);
		sMAlias = sMAlias.replace(".", "");
		sMAlias = sMAlias.replace("", "");
		sMAlias = sMAlias.replace("SRC_", "");
		sDAlias = sDAlias.replace(".", "");
		sDAlias = sDAlias.replace("SRC_", "");
		sDAlias = sDAlias.replace("", "");

		// FOR A JOINER WE NEED A MASTER AND A DETAIL SOURCE, IT'S CORRESPONDING SOURCE QUALIFIERS, 
		// A JOINER TRANSFORMATION AND A TARGET.
		// EACH SOURCEFIELD WILL BE A FIELD IN THE SOURCE, THE SOURCE QUALIFIER, THE JOINER AND THE TARGET.
		// BASED ON THIS KNOWLEDGE, WE CAN GENERATE THE CONNECTORS ALREADY AS WELL AS THESE FIELDS.


		// CREATING A SOURCE OBJECT FOR THE MASTER
		SOURCE m = new SOURCE(createSource("SRC_"+mSrc,sfM));
		SOURCE d = new SOURCE(createSource("SRC_"+dSrc,sfD));
		ArrayList<SOURCEFIELD> smfs = new ArrayList<SOURCEFIELD>();
		int fieldnum = 0;
		int physicaloffset = 0;
		fieldnum = 0;
		for(String s : sfM){
			physicaloffset = physicaloffset + 10;
			con = new CONNECTOR(s,"SRC_"+mSrc,"Source Definition","Source Qualifier","SQ_SRC_"+ mSrc,s);
			cons.add(con);
			con = new CONNECTOR(s,"SQ_SRC_"+ mSrc,"Source Qualifier","Joiner","JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s);
			cons.add(con);
			con = new CONNECTOR(s,"JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","Target Definition",""+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s);
			cons.add(con);

		}
		m.getSOURCEFIELD().addAll(smfs);
		inst = new INSTANCE("DB2","SRC_"+mSrc,"SOURCE", "NO", "Source Definition","SRC_"+mSrc);
		insts.add(inst);


		// CREATING A SOURCE OBJECT FOR THE DETAIL AND THE TRANSFORMFIELDS
		ArrayList<SOURCEFIELD> sdfs = new ArrayList<SOURCEFIELD>();
		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
		fieldnum = 0;
		physicaloffset = 0;
		for(String s : sfD){
			physicaloffset = physicaloffset+10;
			TRANSFORMFIELD trf = new TRANSFORMFIELD(s.substring(s.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
			trfs.add(trf);
			con = new CONNECTOR(s,"SRC_"+dSrc,"Source Definition","Source Qualifier","SQ_SRC_"+ dSrc,s);
			cons.add(con);
			con = new CONNECTOR(s,"SQ_SRC_"+ dSrc,"Source Qualifier","Joiner","JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s.substring(s.indexOf(".")+1));
			cons.add(con);
			con = new CONNECTOR(s,"JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","Target Definition",""+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s.substring(s.indexOf(".")+1));
			cons.add(con);
			fieldnum++;
		}
		inst = new INSTANCE("DB2","SRC_"+dSrc,"SOURCE","NO","Source Definition","SRC_"+dSrc);
		insts.add(inst);
		// ADDING BOTH SOURCES TO AN ARRAYLIST TO ADD THEM TO THE FOLDER
		ArrayList<SOURCE> srcs = new ArrayList<SOURCE>();
		srcs.add(m);
		srcs.add(d);

		// CREATING A TARGET AND ADDING ITS TARGETFIELDS
		TARGET tgt = new TARGET(createTarget("TBL_"+sMAlias, sfM));
		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
		trfs = new ArrayList<TRANSFORMFIELD>();
		i = 0;
		for(String t : tfss){
			TRANSFORMFIELD trf = new TRANSFORMFIELD();
			i++;
			if(t.contains("."))
				trf = new TRANSFORMFIELD(t.substring(t.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
			else
				trf = new TRANSFORMFIELD(t,"string","INPUT/OUTPUT","10","0");
			trfs.add(trf);
		}

		// TARGET INSTANCE
		inst = new INSTANCE(tgt.getNAME(),"TARGET","NO","Target Definition",tgt.getNAME());
		insts.add(inst);

		// TARGETLOADORDER
		TARGETLOADORDER tgtlo = new TARGETLOADORDER(tgt.getNAME(),"1");
		map.getTARGETLOADORDER().add(tgtlo);

		// TRANSFORMATIONS
		// SOURCE QUALIFIERS
		TRANSFORMATION trns = new TRANSFORMATION();
		ArrayList<TABLEATTRIBUTE> tas = new ArrayList<TABLEATTRIBUTE>();
		TABLEATTRIBUTE tabat = new TABLEATTRIBUTE();

		for(SOURCE src : srcs){
			ArrayList<TRANSFORMFIELD> sftotf = new ArrayList<TRANSFORMFIELD>();
			for(SOURCEFIELD sf : src.getSOURCEFIELD()){
				if(sf.getNAME().contains(".")){
					sf.setNAME(sf.getNAME().substring(sf.getNAME().indexOf(".")+1));
				}
				TRANSFORMFIELD tf = new TRANSFORMFIELD(sf.getNAME(), "string", "INPUT/OUTPUT", sf.getPRECISION(),"0");
				sftotf.add(tf);
			}
			tas = new ArrayList<TABLEATTRIBUTE>();
			tabat = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
			tas.add(tabat);
			tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
			tas.add(tabat);
			tabat = new TABLEATTRIBUTE("Is Partitionable","NO");
			tas.add(tabat);
			tabat = new TABLEATTRIBUTE("Output is deterministic","NO");
			tas.add(tabat);
			tabat = new TABLEATTRIBUTE("Output is repeatable","Never");
			tas.add(tabat);
			trns = new TRANSFORMATION("SQ_"+src.getNAME(),"Source Qualifier","1","NO","1");
			trns.getTRANSFORMFIELD().addAll(sftotf);
			inst = new INSTANCE("DB2","SQ_"+src.getNAME(),"TRANSFORMATION", "NO", "Source Qualifier","SQ_"+src.getNAME());

			// ASSOCIATEDSOURCEINSTANCE 
			ASSOCIATEDSOURCEINSTANCE asi = new ASSOCIATEDSOURCEINSTANCE(src.getNAME());
			inst.getASSOCIATEDSOURCEINSTANCE().add(asi);
			insts.add(inst);

			map.getTRANSFORMATION().add(trns);
		}
		// JOIN TRANSFORMATION DETAILS & TABLEATTRIBUTES
		tas = new ArrayList<TABLEATTRIBUTE>();
		tabat = new TABLEATTRIBUTE("Case Sensitive String Comparison","YES");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Cache Directory","$PMCacheDir");
		tas.add(tabat);

		for(String s : conds){
			cond = cond + s +" AND ";
		}
		if(cond.length()!=0){
			cond = cond.substring(0, cond.length()-5);
			while(cond.contains(".")){
				if(cond.indexOf(" ")<cond.indexOf(".")){
					cond = cond.substring(0,cond.indexOf(" ")) + cond.substring(cond.indexOf(".")+1);
				}else{
					cond = cond.substring(cond.indexOf(".")+1);
				}
			}
		}

		tabat = new TABLEATTRIBUTE("Join Condition",cond);
		tas.add(tabat);
		// JOINTYPE
		switch (joinType){
		case "FOJ" : 
			tabat = new TABLEATTRIBUTE("Join Type","Full Outer Join");	
			break;
		case "LOJ" : 
			tabat = new TABLEATTRIBUTE("Join Type","Master Outer Join");
			break;
		case "ROJ" : 
			tabat = new TABLEATTRIBUTE("Join Type","Detail Outer Join");
			break;
		case "IJ" : 
			tabat = new TABLEATTRIBUTE("Join Type","Normal Join");
			break;
		}
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Null ordering in master","Null Is Highest Value");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Null ordering in detail","Null Is Highest Value");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Joiner Data Cache Size","Auto");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Joiner Index Cache Size","Auto");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Sorted Input","NO");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Master Sort Order","AUTO");
		tas.add(tabat);
		tabat = new TABLEATTRIBUTE("Transformation Scope","All Input");
		tas.add(tabat);
		// TODO "JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3)
		trns = new TRANSFORMATION("JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","1","NO","1");
		trns.getTRANSFORMFIELD().addAll(trfs);
		trns.getTABLEATTRIBUTE().addAll(tas);

		inst = new INSTANCE(trns.getNAME(),"TRANSFORMATION","NO","Joiner",trns.getNAME());
		insts.add(inst);

		// ADD NODES TO MAPPING
		map.getTRANSFORMATION().add(trns);
		map.getINSTANCE().addAll(insts);
		map.getCONNECTOR().addAll(cons);
		// MAPPING DETAILS
		map.setISVALID("YES");
		mSrc = mSrc.replace(".", "");
		mSrc = mSrc.replace("", "");
		dSrc = dSrc.replace(".", "");
		dSrc = dSrc.replace("", "");
		map.setNAME("m_JNR_"+mSrc+"_"+dSrc);
		map.setOBJECTVERSION("1");
		map.setVERSIONNUMBER("1");

		// CONFIG
		CONFIG config = new CONFIG();
		config.setDESCRIPTION("Default session configuration object");
		config.setISDEFAULT("YES");
		config.setNAME("default_session_config");
		config.setVERSIONNUMBER("1");
		config.getATTRIBUTE().addAll(getConfigAttributes());




		folder.getSOURCE().addAll(srcs);
		folder.getTARGET().add(tgt);
		folder.getMAPPING().add(map);
		folder.getCONFIG().add(config);

		REPOSITORY repository = new REPOSITORY("XDIPCRS","DB2","Latin1","184");
		repository.getFOLDER().add(folder);

		POWERMART powermart = new POWERMART("","");
		powermart.getREPOSITORY().add(repository);

		return powermart;
	}

	/*
	 * 	This function creates a POWERMART-object containing a mapping
	 * 	with a filtertransformation, based on the given filter-query.
	 * 
	 * 	@param	srcTbl				The name of the source table.
	 * 	@param	srcAlias			The alias of the source table.
	 * 	@param	sourcefieldnames	An ArrayList of the sourcefieldnames from the source table.
	 * 	@param	filtercondition		The filtercondition of the filter.
	 * 	@return						A POWERMART object containing the mapping with the jointransformation.
	 */
	private static POWERMART convToSelFil(String srcTbl, String srcAlias, ArrayList<String> sourcefieldnames, String filtercondition){
		MAPPING map = new MAPPING();
		FOLDER folder = new FOLDER("XDW991593" ,"Everis : Antonio Jesus, Group for Global Corporate Teaser Tool(GCT), Developer, antonio.jesus.munoz.lapaz@zurich.com" ,"NOTSHARED","w991593" ,"","rwx---r--" ,"55cd59eb-588d-4840-8dee-97c3257a4945");
		ArrayList<SOURCEFIELD> sfs = new ArrayList<SOURCEFIELD>();
		ArrayList<CONNECTOR> cons = new ArrayList<CONNECTOR>();
		ArrayList<INSTANCE> insts = new ArrayList<INSTANCE>();
		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
		CONNECTOR con = new CONNECTOR();
		INSTANCE inst = new INSTANCE();
		int fieldnum = 0;

		srcTbl = srcTbl.replace(".", "");
		srcTbl = srcTbl.replace("", "");
		srcTbl = srcTbl.replace("SRC_", "");
		srcTbl = srcTbl.substring(0, srcTbl.length()/2);
		srcAlias = srcAlias.replace(".", "");
		srcAlias = srcAlias.replace("", "");

		// CREATING A SOURCE, SQ, TARGET AND CONNECTORS
		TARGET tgt = new TARGET(createTarget("TBL_"+srcAlias,sourcefieldnames));
		for(String s : sourcefieldnames){
			TARGETFIELD tf = new TARGETFIELD(s,"varchar","NOT A KEY","10","0","NULL",Integer.toString(fieldnum+1));
			TRANSFORMFIELD trf = new TRANSFORMFIELD(s,"string","INPUT/OUTPUT","10","0");

			con = new CONNECTOR(s,"SRC_"+srcTbl,"Source Definition","Source Qualifier","SQ_"+ srcTbl,s);
			cons.add(con);
			if(!srcAlias.equals("")){
				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Filter","FIL_"+srcTbl,s);
				cons.add(con);
				con = new CONNECTOR(s,"FIL_"+srcTbl,"Filter","Target Definition","TBL_"+srcAlias,s);
				cons.add(con);
			}else{
				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Filter","FIL_"+srcTbl,s);
				cons.add(con);
				con = new CONNECTOR(s,"FIL_"+srcTbl,"Filter","Target Definition","TBL_"+srcAlias,s);
				cons.add(con);
			}
			trfs.add(trf);
			tfs.add(tf);
			fieldnum ++;
		}
		SOURCE src = new SOURCE(createSource("SRC_"+srcTbl,sourcefieldnames));

		inst = new INSTANCE("DB2","SRC_"+srcTbl,"SOURCE", "NO", "Source Definition","SRC_"+srcTbl);
		insts.add(inst);
		inst = new INSTANCE("FIL_"+srcTbl,"TRANSFORMATION","NO","Filter","FIL_"+srcTbl);
		insts.add(inst);

		// TARGET INSTANCE
		inst = new INSTANCE("TBL_"+srcAlias,"TARGET","NO","Target Definition","TBL_"+srcAlias);
		insts.add(inst);

		// TARGETLOADORDER
		TARGETLOADORDER tgtlo = new TARGETLOADORDER(tgt.getNAME(),"1");
		map.getTARGETLOADORDER().add(tgtlo);

		ArrayList<TABLEATTRIBUTE> tas = new ArrayList<TABLEATTRIBUTE>();
		TABLEATTRIBUTE tabat = new TABLEATTRIBUTE();

		tas = new ArrayList<TABLEATTRIBUTE>();
		tabat = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Is Partitionable","NO");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Output is deterministic","NO");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Output is repeatable","Never");
		tas.add(tabat);
		inst = new INSTANCE("DB2","SQ_"+srcTbl,"TRANSFORMATION", "NO", "Source Qualifier","SQ_"+srcTbl);

		// SOURCE QUALIFIER
		TRANSFORMATION trns = new TRANSFORMATION();
		trns = new TRANSFORMATION("SQ_"+srcTbl,"Source Qualifier","1","NO","1");
		trns.getTRANSFORMFIELD().addAll(trfs);
		trns.getTABLEATTRIBUTE().addAll(tas);

		//        <TRANSFORMATION DESCRIPTION ="" NAME ="FIL_DUP" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Filter" VERSIONNUMBER ="1">

		TRANSFORMATION filtertransformation = new TRANSFORMATION("FIL_"+srcTbl,"Filter","1","NO","1");
		filtertransformation.getTRANSFORMFIELD().addAll(trfs);
		TABLEATTRIBUTE ta = new TABLEATTRIBUTE("Filter Condition",filtercondition);
		filtertransformation.getTABLEATTRIBUTE().add(ta);
		ta = new TABLEATTRIBUTE("Tracing Level","Normal");
		filtertransformation.getTABLEATTRIBUTE().add(ta);

		// ASSOCIATEDSOURCEINSTANCE 
		ASSOCIATEDSOURCEINSTANCE asi = new ASSOCIATEDSOURCEINSTANCE(src.getNAME());
		inst.getASSOCIATEDSOURCEINSTANCE().add(asi);
		insts.add(inst);

		// ADD NODES TO MAPPING
		map.getTRANSFORMATION().add(trns);
		map.getTRANSFORMATION().add(filtertransformation);
		map.getINSTANCE().addAll(insts);
		map.getCONNECTOR().addAll(cons);
		// MAPPING DETAILS
		map.setISVALID("YES");
		map.setNAME("m_FIL_"+srcTbl);
		map.setOBJECTVERSION("1");
		map.setVERSIONNUMBER("1");

		// CONFIG
		CONFIG config = new CONFIG();
		config.setDESCRIPTION("Default session configuration object");
		config.setISDEFAULT("YES");
		config.setNAME("default_session_config");
		config.setVERSIONNUMBER("1");
		config.getATTRIBUTE().addAll(getConfigAttributes());



		folder.getSOURCE().add(src);
		folder.getTARGET().add(tgt);
		folder.getMAPPING().add(map);
		folder.getCONFIG().add(config);
		REPOSITORY repository = new REPOSITORY("XDIPCRS","DB2","Latin1","184");
		repository.getFOLDER().add(folder);

		POWERMART powermart = new POWERMART("","");
		powermart.getREPOSITORY().add(repository);

		return powermart;
	}

	/*
	 * 	This function creates a POWERMART-object containing a mapping
	 * 	that just loads the targettable, without any transformations.
	 * 
	 * 	@param	srcTbl				The name of the source table.
	 * 	@param	srcAlias			The alias of the source table.
	 * 	@param	sourcefieldnames	An ArrayList of the sourcefieldnames from the source table.
	 * 	@return						A POWERMART object containing the mapping.
	 */
	private static POWERMART convToSelIns(String srcTbl, String srcAlias, ArrayList<String> sourcefieldnames){
		MAPPING map = new MAPPING();
		FOLDER folder = new FOLDER("XDW991593" ,"Everis : Antonio Jesus, Group for Global Corporate Teaser Tool(GCT), Developer, antonio.jesus.munoz.lapaz@zurich.com" ,"NOTSHARED","w991593" ,"","rwx---r--" ,"55cd59eb-588d-4840-8dee-97c3257a4945");
		ArrayList<SOURCEFIELD> sfs = new ArrayList<SOURCEFIELD>();
		ArrayList<CONNECTOR> cons = new ArrayList<CONNECTOR>();
		ArrayList<INSTANCE> insts = new ArrayList<INSTANCE>();
		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
		CONNECTOR con = new CONNECTOR();
		INSTANCE inst = new INSTANCE();
		int fieldnum = 0;

		srcTbl = srcTbl.replace(".", "");
		srcTbl = srcTbl.replace("", "");
		srcTbl = srcTbl.replace("SRC_", "");
		//srcTbl = srcTbl.substring(0, srcTbl.length()/2);
		//srcAlias = srcAlias.replace(".", "");
		//srcAlias = srcAlias.replace("", "");

		// CREATING A SOURCE, SQ, TARGET AND CONNECTORS
		TARGET tgt = new TARGET(createTarget("TBL_"+srcAlias, sourcefieldnames));
		
		for(String s : sourcefieldnames){
			TRANSFORMFIELD trf = new TRANSFORMFIELD(s,"string","INPUT/OUTPUT","10","0");

			con = new CONNECTOR(s,"SRC_"+srcTbl,"Source Definition","Source Qualifier","SQ_"+ srcTbl,s);
			cons.add(con);
			con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Target Definition","TBL_"+srcAlias,s);
			cons.add(con);
			trfs.add(trf);

			fieldnum ++;
		}
		SOURCE src = new SOURCE(createSource("SRC_"+srcTbl,sourcefieldnames));
		inst = new INSTANCE("DB2","SRC_"+srcTbl,"SOURCE", "NO", "Source Definition","SRC_"+srcTbl);
		insts.add(inst);

		// TARGET INSTANCE
		inst = new INSTANCE("TBL_"+srcAlias,"TARGET","NO","Target Definition","TBL_"+srcAlias);
		insts.add(inst);

		// TARGETLOADORDER
		TARGETLOADORDER tgtlo = new TARGETLOADORDER(tgt.getNAME(),"1");
		map.getTARGETLOADORDER().add(tgtlo);

		ArrayList<TABLEATTRIBUTE> tas = new ArrayList<TABLEATTRIBUTE>();
		TABLEATTRIBUTE tabat = new TABLEATTRIBUTE();

		tas = new ArrayList<TABLEATTRIBUTE>();
		tabat = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Is Partitionable","NO");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Output is deterministic","NO");
		tas.add(tabat);

		tabat = new TABLEATTRIBUTE("Output is repeatable","Never");
		tas.add(tabat);
		inst = new INSTANCE("DB2","SQ_"+srcTbl,"TRANSFORMATION", "NO", "Source Qualifier","SQ_"+srcTbl);

		// SOURCE QUALIFIER
		TRANSFORMATION trns = new TRANSFORMATION();
		trns = new TRANSFORMATION("SQ_"+srcTbl,"Source Qualifier","1","NO","1");
		trns.getTRANSFORMFIELD().addAll(trfs);
		trns.getTABLEATTRIBUTE().addAll(tas);

		// ASSOCIATEDSOURCEINSTANCE 
		ASSOCIATEDSOURCEINSTANCE asi = new ASSOCIATEDSOURCEINSTANCE(src.getNAME());
		inst.getASSOCIATEDSOURCEINSTANCE().add(asi);
		insts.add(inst);

		// ADD NODES TO MAPPING
		map.getTRANSFORMATION().add(trns);
		map.getINSTANCE().addAll(insts);
		map.getCONNECTOR().addAll(cons);
		// MAPPING DETAILS
		map.setISVALID("YES");
		map.setNAME("m_SelIns_"+srcTbl);
		map.setOBJECTVERSION("1");
		map.setVERSIONNUMBER("1");

		// CONFIG
		CONFIG config = new CONFIG();
		config.setDESCRIPTION("Default session configuration object");
		config.setISDEFAULT("YES");
		config.setNAME("default_session_config");
		config.setVERSIONNUMBER("1");
		config.getATTRIBUTE().addAll(getConfigAttributes());



		// TODO: FIND A WAY TO GET ALL THE DATA FOR THE SESSIONTRANSFORMATIONINST.
		/*for(INSTANCE in : map.getINSTANCE()){
					// SESSIONTRANSFORMATIONINST
					SESSTRANSFORMATIONINST sesstr = new SESSTRANSFORMATIONINST(in.getNAME(), in.getTRANSFORMATIONNAME(), in.getTRANSFORMATIONTYPE(), "", "", "1");
					sess.getSESSTRANSFORMATIONINST().add(sesstr);
				}*/



		folder.getSOURCE().add(src);
		folder.getTARGET().add(tgt);
		folder.getMAPPING().add(map);
		folder.getCONFIG().add(config);

		REPOSITORY repository = new REPOSITORY("XDIPCRS","DB2","Latin1","184");
		repository.getFOLDER().add(folder);

		POWERMART powermart = new POWERMART("","");
		powermart.getREPOSITORY().add(repository);

		return powermart;
	}

	private static SOURCE createSource(String sourceName, ArrayList<String> sfNames){
		SOURCE s = new SOURCE(sourceName,"DB2","","","1","","DB2","1");
		
		Integer physicaloffset = 0;
		int fieldnum = 0;
		for(String sfName : sfNames){
			physicaloffset = physicaloffset +10;
			fieldnum++;
			s.getSOURCEFIELD().add(new SOURCEFIELD(sfName,"","","varchar","NOT A KEY","10","0","NULL",
					"","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),
					"10",Integer.toString(fieldnum),"0","NO"));
		}

		return s;
	}
	
	private static TARGET createTarget(String targetName, ArrayList<String> tfNames){
		TARGET tgt = new TARGET(targetName,"1","DB2","1");
		int fieldnum = 0;
		for(String s : tfNames){
			fieldnum++;
			tgt.getTARGETFIELD().add(new TARGETFIELD(s,"varchar","NOT A KEY","10","0","NULL",Integer.toString(fieldnum)));
		}
		
		return tgt;
	}
	
	/*
	 * 	This function compares the given string with the list of keywords
	 * 	at checks if it's in the list or not.
	 * 
	 * 	@param	s	The string to check.
	 * 	@return		True or false depending on the check.
	 */
	private static boolean isKeyWord(String s){
		Pattern p = Pattern.compile(kw);
		Matcher m = p.matcher(s);

		if(m.find())
			return true;
		else
			return false;
	}

	/*
	 * 	This function returns a list of the configurationattributes of a mapping.
	 * 
	 * 	@return		The attributes.
	 */
	private static ArrayList<ATTRIBUTE> getConfigAttributes(){
		ArrayList<ATTRIBUTE> configattributes = new ArrayList<ATTRIBUTE>();
		ATTRIBUTE attr = new ATTRIBUTE();

		attr = new ATTRIBUTE("Advanced","");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Constraint based load ordering","NO");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Cache LOOKUP() function","YES");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Default buffer block size","Auto");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Line Sequential buffer length","1024");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Maximum Memory Allowed For Auto Memory Attributes","512MB");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Maximum Percentage of Total Memory Allowed For Auto Memory Attributes","5");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Additional Concurrent Pipelines for Lookup Cache Creation","Auto");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Custom Properties","");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Pre-build lookup cache","Auto");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Optimization Level","Medium");
		configattributes.add(attr);
		attr = new ATTRIBUTE("DateTime Format String","MM/DD/YYYY HH24:MI:SS.US");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Pre 85 Timestamp Compatibility","NO");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Log Options","0");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Save session log by","Session runs");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Save session log for these runs","0");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Session Log File Max Size","0");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Session Log File Max Time Period","0");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Maximum Partial Session Log Files","1");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Writer Commit Statistics Log Frequency","1");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Writer Commit Statistics Log Interval","0");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Error handling","");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Stop on errors","0");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Override tracing","None");
		configattributes.add(attr);
		attr = new ATTRIBUTE("On Stored Procedure error","Stop");
		configattributes.add(attr);
		attr = new ATTRIBUTE("On Pre-session command task error","Stop");
		configattributes.add(attr);
		attr = new ATTRIBUTE("On Pre-Post SQL error","Stop");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Enable Recovery","NO");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Error Log Type","None");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Error Log Table Name Prefix","");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Error Log File Name","PMError.log");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Log Source Row Data","NO");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Data Column Delimiter","|");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Partitioning Options","");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Dynamic Partitioning","Disabled");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Number of Partitions","1");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Multiplication Factor","Auto");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Session on Grid","");
		configattributes.add(attr);
		attr = new ATTRIBUTE("Is Enabled","NO");
		configattributes.add(attr);
		return configattributes;
	}


}
