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

/*
 * 	This is the class that will convert a SQLquery into mappings and it's necessary DDL's.
 * 
 * 	@author		Yves Delvaulx
 * 	@version	0.1
 */
public class SQLParserNEW {

	static ArrayList<String> sfOther = new ArrayList<String>();
	static ArrayList<String> sOldTables = new ArrayList<String>();
	static String qry = "SELECT CAST(CURRENT_DATE-1 (FORMAT 'YYYYMMDD')) AS f.castedDate  FROM ctl.CTL_FECHAS_DM_V  f INNER JOIN ctl.CTL_LOG_PROCESOS l1 ON ( l1.fecha_carga = CURRENT_DATE - 1 ) INNER JOIN ctl.CTL_LOG_PROCESOS l2 ON ( l2.fecha_carga = CURRENT_DATE-1 ) INNER JOIN dim.DIM_DIA d  ON ( d.fec_dia = CURRENT_DATE ) WHERE f.datamart = 'FASE_SAS' AND f.fec_ultima_carga_dm_empezada = f.fec_ultima_carga_dm_finalizada AND f.fec_ultima_carga_dm_empezada < CURRENT_DATE -1 AND l1.proceso = 'fac_picos_gdp.sql' AND l1.fecha_fin IS NOT NULL AND l2.proceso = 'fac_inventario_actual.sql'  AND l2.fecha_fin IS NOT NULL AND d.id_dia_de_semana <> 7 GROUP BY 1";
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
			+ "(?<=>)|(?=>)|"
			+ "(?<=\\))|(?=\\))|"
			+ "(?<=\\()|(?=\\()");

	public String main(String s){
		qry = qry.toUpperCase();

		for(String part : qry.split(kw))
			System.out.println(part);
		return s;
	}


	public SQLParserNEW() {
		super();
	}

	public static void main(String[] args) {
		// WE DISSECT THE ORIGINAL QUERY
		System.out.print("START:   "+qry);
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

		System.out.println("FINAL:  "+dissectQRY(updateAliases(tmpquery)));

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
		String var = "";
		String tmp ="";
		int count = 0;
		int parenthesis;
		int pos= 0;
		int i;
		// CHECK FOR SUBQUERIES
		Pattern p = Pattern.compile("\\(SELECT|\\([\\s]*SELECT");
		Matcher m = p.matcher(query);
		
		while(m.find()){
			count ++;
		}
		if(0<count){
			tmp = query;

			for(int c = 0;c < count;c++){
				i = tmp.indexOf("SELECT");
				if(tmp.substring(0, i).trim().endsWith("(")){
					tmp = tmp.substring(i);
					parenthesis = 1;
					pos = 0;

					// WE LOOK FOR WHEN THERE IS THE CORRESPONDING CLOSING PARENTHESIS SO THAT WE HAVE
					// THE END OF THE ORIGINAL SUBQUERY.
					while(pos <= tmp.length() && parenthesis > 0 ){
						switch (tmp.charAt(pos)){
						case '(':
							parenthesis ++;
							break;
						case ')':
							parenthesis --;
							break;
						}
						pos++;
					}
					// WE GET THE ALIAS OF OUR SUBQUERY AND STORE IT IN A VARIABLE.
					var = tmp.substring(pos).trim().substring(0,tmp.substring(pos).trim().indexOf(" "));
					if(var.trim().equals("AS")){
						var = tmp.substring(pos).trim().substring(3).substring(0, tmp.substring(pos).trim().substring(3).indexOf(" "));
					}
					String pre = query.substring(0, query.indexOf(tmp.substring(0,pos-1))).substring(0,query.substring(0, query.indexOf(tmp.substring(0,pos-1))).lastIndexOf("("));
					String post = query.substring(query.indexOf(tmp.substring(0,pos))+tmp.substring(0,pos).length());
					String mid = dissectQRY(tmp.substring(0,pos-1));
					mid = mid.substring(mid.lastIndexOf(" FROM ")+6).trim();
					if(post.trim().startsWith("AS")){
						post = post.trim();
						post = post.substring(post.indexOf(" ")).trim();
						post = post.substring(post.indexOf(" ")).trim();
					}
					if(mid.contains("AS"))
						mid = mid.substring(0, mid.indexOf(" "))+" "+mid.substring(mid.lastIndexOf(" "));
					mid = mid.replaceAll("\\)", "");
					query = pre.trim() +" "+ mid +" "+ post.trim();
					post = dissectQRY(tmp.substring(0,pos-1)).substring(tmp.lastIndexOf(" FROM ")+6).trim();
					post = post.substring(post.lastIndexOf(" "));
					query = query.replaceAll(" "+var+"\\."," "+post.trim()+"\\.");
					tmp = updateAliases(tmp);
					query = updateAliases(query);


				}else{
					// IN CASE WE FIND A SELECT NOT PRECEDED BY A '(',
					// WE FOUND THE FIRST SELECT, AND IT'S NOT PART OF OUR
					// SUBQUERIES SELECTS. SO WE DON'T COUNT THIS LOOP.
					tmp = tmp.substring(i+6);
				}
			}

		}
		count = 0;
		tmp ="";
		String jntmp = "";
		p = Pattern.compile(" JOIN ");
		m = p.matcher(query);
		while(m.find()){
			count ++;
		}
		if(0<count){
			tmp = query;
			while(0<countJoins(tmp)){
				tmp = tmp.substring(0,tmp.lastIndexOf("JOIN"));
				if(tmp.trim().endsWith("INNER")){
					jntmp = tmp.trim().substring(0,tmp.lastIndexOf("INNER")).trim();
				}else if(tmp.trim().endsWith("OUTER")){
					jntmp = tmp.substring(0,tmp.lastIndexOf("OUTER")).trim().substring(0,tmp.substring(0,tmp.lastIndexOf("OUTER")).trim().lastIndexOf(" ") );
				}
				tmp = dissectQRY(updateAliases(jntmp));
				if(query.trim().indexOf(jntmp.trim())!=0)
					query = query.replace(jntmp,tmp.substring(tmp.lastIndexOf(" FROM ")+5));
				else
					query = query.replace(jntmp,tmp);

				if(jntmp.contains(" JOIN "))
					jntmp = jntmp.substring(0,jntmp.lastIndexOf("ON")).trim();

				jntmp = jntmp.substring(jntmp.lastIndexOf(" ")).trim();
				tmp = tmp.substring(tmp.lastIndexOf(" ")).trim();
				query = query.replaceAll(" "+jntmp+"\\."," "+tmp+"\\.");
				query = query.replaceAll(" "+jntmp+" "," "+tmp+" ");
				query = updateAliases(query);

			}

		}


		query = analyzeQRY(query);
		if(query.contains("WHERE")){
			query = analyzeQRY(query);
		}
		System.out.println(query);
		return query;
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
			tmp = s.substring(s.trim().indexOf(" ")+1, s.indexOf("FROM"));
			conds = getJoinCondition(s.substring(s.indexOf("ON")));
			for(String condition : conds)
				for(String var : condition.split(kw))
					if(!isKeyWord(var) && !NumberUtils.isCreatable(var))
						tmp = tmp +","+ var;
			// FOR EACH OF THE FIELDNAMES, WE CHECK IF IT'S PRECEDED BY THE MASTERALIAS, DETAILALIAS OR ANOTHER ONE,
			// AND ADD THEM TO A CORRESPONDING ARRAYLIST.
			for(String tablefield : tmp.split(",")){
				tablefield = tablefield.trim();
				if(tablefield.contains(".")){
					if(tablefield.substring(0, tablefield.indexOf(".")).equals(sMAlias)){
						if(!sfMNames.contains(tablefield)){
							sfMNames.add(tablefield);
							tfNames.add(tablefield);
						}
					}else if(tablefield.substring(0, tablefield.indexOf(".")).equals(sDAlias)){
						if(!sfDNames.contains(tablefield)){
							sfDNames.add(tablefield);
							tfNames.add(tablefield);
						}
					}else{
						if(!sfOther.contains(tablefield))
							sfOther.add(tablefield);
					}

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
				if(sfn.trim().contains(" AS "))
					sfn = sfn.substring(sfn.indexOf(" AS ")+4);
				if(0<=sfn.trim().indexOf(sMAlias+".")){
					if(!sfMNames.contains(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2))){
						sfMNames.add(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2));
					}
				}else
					sfOther.add(sfn.trim());
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
	
		tmp = "";
		if(sfOther.isEmpty()){
			tmp = " SELECT ";
			for(TARGETFIELD tf : p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getTARGETFIELD())
				tmp = tmp + sMAlias +"."+ tf.getNAME() + ", ";
			tmp = tmp.substring(0,tmp.lastIndexOf(",")) + " FROM " +p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getNAME()+" "+sMAlias;
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
		String keyw ="";
		while(!tmp.equals("") && !keyw.equals("WHERE")){
			if(!isKeyWord(" "+keyw+" ")&&tmp.contains(" ")){
				// IF THE KEYWORD ISN'T A KEYWORD AND THE CONDITION CONTAINS AN EMPTY SPACE 
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
			}else if(tmp.contains(" ") && !keyw.trim().equals("AND")&& !keyw.trim().equals("OR")){
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
		mSrc = mSrc.replace("TGT_", "");
		mSrc.substring(0,mSrc.length()/2);
		dSrc = dSrc.replace(".", "");
		dSrc = dSrc.replace("SRC_", "");
		dSrc = dSrc.replace("TGT_", "");
		dSrc.substring(0,mSrc.length()/2);
		sMAlias = sMAlias.replace(".", "");
		sMAlias = sMAlias.replace("TGT_", "");
		sMAlias = sMAlias.replace("SRC_", "");
		sDAlias = sDAlias.replace(".", "");
		sDAlias = sDAlias.replace("SRC_", "");
		sDAlias = sDAlias.replace("TGT_", "");

		// FOR A JOINER WE NEED A MASTER AND A DETAIL SOURCE, IT'S CORRESPONDING SOURCE QUALIFIERS, 
		// A JOINER TRANSFORMATION AND A TARGET.
		// EACH SOURCEFIELD WILL BE A FIELD IN THE SOURCE, THE SOURCE QUALIFIER, THE JOINER AND THE TARGET.
		// BASED ON THIS KNOWLEDGE, WE CAN GENERATE THE CONNECTORS ALREADY AS WELL AS THESE FIELDS.


		// CREATING A SOURCE OBJECT FOR THE MASTER
		SOURCE m = new SOURCE("SRC_"+mSrc,"DB2","","","1","","DB2","1");
		ArrayList<SOURCEFIELD> smfs = new ArrayList<SOURCEFIELD>();
		int fieldnum = 0;
		int physicaloffset = 0;
		fieldnum = 0;
		for(String s : sfM){
			physicaloffset = physicaloffset + 10;
			SOURCEFIELD sf = new SOURCEFIELD(s.substring(s.indexOf(".")+1),"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
			smfs.add(sf);

			con = new CONNECTOR(sf.getNAME(),"SRC_"+mSrc,"Source Definition","Source Qualifier","SQ_SRC_"+ mSrc,sf.getNAME());
			cons.add(con);
			con = new CONNECTOR(sf.getNAME(),"SQ_SRC_"+ mSrc,"Source Qualifier","Joiner","JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),sf.getNAME());
			cons.add(con);
			con = new CONNECTOR(sf.getNAME(),"JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","Target Definition",mSrc+dSrc,sf.getNAME());
			cons.add(con);

		}
		m.getSOURCEFIELD().addAll(smfs);
		inst = new INSTANCE("DB2","SRC_"+mSrc,"SOURCE", "NO", "Source Definition","SRC_"+mSrc);
		insts.add(inst);


		// CREATING A SOURCE OBJECT FOR THE DETAIL AND THE TRANSFORMFIELDS
		SOURCE d = new SOURCE("SRC_"+dSrc,"DB2","","","1","","DB2","1");
		ArrayList<SOURCEFIELD> sdfs = new ArrayList<SOURCEFIELD>();
		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
		fieldnum = 0;
		physicaloffset = 0;
		for(String s : sfD){
			physicaloffset = physicaloffset+10;
			SOURCEFIELD sf = new SOURCEFIELD(s.substring(s.indexOf(".")+1),"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
			TRANSFORMFIELD trf = new TRANSFORMFIELD(s.substring(s.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
			trfs.add(trf);
			sf.setNAME(s);
			sdfs.add(sf);
			if(sf.getNAME().contains("."))
				sf.setNAME(sf.getNAME().substring(sf.getNAME().indexOf(".")+1));
			con = new CONNECTOR(sf.getNAME(),"SRC_"+dSrc,"Source Definition","Source Qualifier","SQ_SRC_"+ dSrc,sf.getNAME());
			cons.add(con);
			con = new CONNECTOR(sf.getNAME(),"SQ_SRC_"+ dSrc,"Source Qualifier","Joiner","JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s.substring(s.indexOf(".")+1));
			cons.add(con);
			con = new CONNECTOR(sf.getNAME(),"JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","Target Definition",mSrc+dSrc,s.substring(s.indexOf(".")+1));
			cons.add(con);
			fieldnum++;
		}
		d.getSOURCEFIELD().addAll(sdfs);
		inst = new INSTANCE("DB2","SRC_"+dSrc,"SOURCE","NO","Source Definition","SRC_"+dSrc);
		insts.add(inst);
		// ADDING BOTH SOURCES TO AN ARRAYLIST TO ADD THEM TO THE FOLDER
		ArrayList<SOURCE> srcs = new ArrayList<SOURCE>();
		srcs.add(m);
		srcs.add(d);

		// CREATING A TARGET AND ADDING ITS TARGETFIELDS
		TARGET tgt = new TARGET();
		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
		trfs = new ArrayList<TRANSFORMFIELD>();
		i = 0;
		for(String t : tfss){
			TARGETFIELD tf = new TARGETFIELD();
			TRANSFORMFIELD trf = new TRANSFORMFIELD();
			i++;
			if(t.substring(0, 1).equals(sMAlias)){
				tf = new TARGETFIELD(t.substring(t.indexOf(".")+1),"varchar","NOT A KEY","10","0","NULL",Integer.toString(i));
				trf = new TRANSFORMFIELD(t.substring(t.indexOf(".")+1),"string","INPUT/OUTPUT/MASTER","10","0");
			}else{
				tf = new TARGETFIELD(t.substring(t.indexOf(".")+1),"varchar","NOT A KEY","10","0","NULL",Integer.toString(i));
				trf = new TRANSFORMFIELD(t.substring(t.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
			}
			trfs.add(trf);
			tfs.add(tf);
		}
		// TARGET DETAILS 
		tgt = new TARGET(""+mSrc+dSrc, "1", "DB2", "1",tfs);

		// TARGET INSTANCE
		inst = new INSTANCE(""+mSrc+dSrc,"TARGET","NO","Target Definition",""+mSrc+dSrc);
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
				TRANSFORMFIELD tf = new TRANSFORMFIELD(sf.getNAME(), "string", "INPUT/OUTPUT", sf.getPRECISION(),sf.getSCALE());
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
				String temp = cond.substring(0,cond.indexOf(".")-1);
				cond = temp + cond.substring(cond.indexOf(".")+1);
				
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
		mSrc = mSrc.replace("TGT_", "");
		dSrc = dSrc.replace(".", "");
		dSrc = dSrc.replace("TGT_", "");
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
		srcTbl = srcTbl.replace("TGT_", "");
		srcTbl = srcTbl.replace("SRC_", "");
		srcTbl = srcTbl.substring(0, srcTbl.length()/2);
		srcAlias = srcAlias.replace(".", "");
		srcAlias = srcAlias.replace("TGT_", "");
		
		// CREATING A SOURCE, SQ, TARGET AND CONNECTORS
		SOURCE src = new SOURCE();
		TARGET tgt = new TARGET();
		Integer physicaloffset = 0;
		for(String s : sourcefieldnames){
			physicaloffset = physicaloffset +10;
			SOURCEFIELD sf = new SOURCEFIELD(s,"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
			TRANSFORMFIELD trf = new TRANSFORMFIELD(s.substring(s.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
			TARGETFIELD tf = new TARGETFIELD(s,"varchar","NOT A KEY","10","0","NULL",Integer.toString(fieldnum+1));

			con = new CONNECTOR(s,"SRC_"+srcTbl,"Source Definition","Source Qualifier","SQ_"+ srcTbl,s);
			cons.add(con);
			if(!srcAlias.equals("")){
				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Filter","FIL_"+srcTbl,s);
				cons.add(con);
				con = new CONNECTOR(s,"FIL_"+srcTbl,"Filter","Target Definition",""+srcTbl,s);
				cons.add(con);
			}else{
				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Filter","FIL_"+srcTbl,s);
				cons.add(con);
				con = new CONNECTOR(s,"FIL_"+srcTbl,"Filter","Target Definition",""+srcTbl,s);
				cons.add(con);
			}



			sfs.add(sf);
			tfs.add(tf);
			trfs.add(trf);


			fieldnum ++;
		}
		src = new SOURCE("SRC_"+srcTbl, "DB2", "", "", "1","","DB2", "1",sfs);
		
		inst = new INSTANCE("DB2","SRC_"+srcTbl,"SOURCE", "NO", "Source Definition","SRC_"+srcTbl);
		insts.add(inst);
		inst = new INSTANCE("FIL_"+srcTbl,"TRANSFORMATION","NO","Filter","FIL_"+srcTbl);
		insts.add(inst);


		// TARGET DETAILS 
		tgt = new TARGET(srcTbl, "1", "DB2", "1",tfs);
		// TARGET INSTANCE
		inst = new INSTANCE(srcTbl,"TARGET","NO","Target Definition",srcTbl);
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
		srcTbl = srcTbl.replace("TGT_", "");
		srcTbl = srcTbl.replace("SRC_", "");
		srcTbl = srcTbl.substring(0, srcTbl.length()/2);
		srcAlias = srcAlias.replace(".", "");
		srcAlias = srcAlias.replace("TGT_", "");
		
		// CREATING A SOURCE, SQ, TARGET AND CONNECTORS
		SOURCE src = new SOURCE();
		TARGET tgt = new TARGET();
		Integer physicaloffset = 0;
		for(String s : sourcefieldnames){
			physicaloffset = physicaloffset +10;
			SOURCEFIELD sf = new SOURCEFIELD(s,"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
			TRANSFORMFIELD trf = new TRANSFORMFIELD(s.substring(s.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
			TARGETFIELD tf = new TARGETFIELD(s,"varchar","NOT A KEY","10","0","NULL",Integer.toString(fieldnum+1));

			con = new CONNECTOR(s,"SRC_"+srcTbl,"Source Definition","Source Qualifier","SQ_"+ srcTbl,s);
			cons.add(con);
			if(!srcAlias.equals(""))
				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Target Definition",""+srcTbl,srcAlias+"."+s);
			else
				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Target Definition",""+srcTbl,s);

			sfs.add(sf);
			tfs.add(tf);
			trfs.add(trf);
			cons.add(con);

			fieldnum ++;
		}
		src = new SOURCE("SRC_"+srcTbl, "DB2", "", "", "1","","DB2", "1",sfs);
		inst = new INSTANCE("DB2","SRC_"+srcTbl,"SOURCE", "NO", "Source Definition","SRC_"+srcTbl);
		insts.add(inst);

		// TARGET DETAILS 
		tgt = new TARGET(""+srcTbl, "1", "DB2", "1",tfs);
		// TARGET INSTANCE
		inst = new INSTANCE(""+srcTbl,"TARGET","NO","Target Definition",""+srcTbl);
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

//package corp.everis.pwc.moam;
//
//import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.commons.lang3.math.NumberUtils;
//
//import corp.everis.pwc.raw.ASSOCIATEDSOURCEINSTANCE;
//import corp.everis.pwc.raw.ATTRIBUTE;
//import corp.everis.pwc.raw.CONFIG;
//import corp.everis.pwc.raw.CONNECTOR;
//import corp.everis.pwc.raw.FOLDER;
//import corp.everis.pwc.raw.INSTANCE;
//import corp.everis.pwc.raw.MAPPING;
//import corp.everis.pwc.raw.POWERMART;
//import corp.everis.pwc.raw.REPOSITORY;
//import corp.everis.pwc.raw.SOURCE;
//import corp.everis.pwc.raw.SOURCEFIELD;
//import corp.everis.pwc.raw.TABLEATTRIBUTE;
//import corp.everis.pwc.raw.TARGET;
//import corp.everis.pwc.raw.TARGETFIELD;
//import corp.everis.pwc.raw.TARGETLOADORDER;
//import corp.everis.pwc.raw.TRANSFORMATION;
//import corp.everis.pwc.raw.TRANSFORMFIELD;
//
//public class SQLParser {
//
//	static ArrayList<String> sfOther = new ArrayList<String>();
//	static ArrayList<String> sOldTables = new ArrayList<String>();
//	static String qry = "SELECT CAST(CURRENT_DATE-1 (FORMAT 'YYYYMMDD')) AS f.CURRENT_DATE  FROM ctl.CTL_FECHAS_DM_V  f INNER JOIN ctl.CTL_LOG_PROCESOS l1 ON ( l1.fecha_carga = CURRENT_DATE - 1 ) INNER JOIN ctl.CTL_LOG_PROCESOS l2 ON ( l2.fecha_carga = CURRENT_DATE-1 ) INNER JOIN dim.DIM_DIA d  ON ( d.fec_dia = CURRENT_DATE ) WHERE f.datamart = 'FASE_SAS' AND f.fec_ultima_carga_dm_empezada = f.fec_ultima_carga_dm_finalizada AND f.fec_ultima_carga_dm_empezada < CURRENT_DATE -1 AND l1.proceso = 'fac_picos_gdp.sql' AND l1.fecha_fin IS NOT NULL AND l2.proceso = 'fac_inventario_actual.sql'  AND l2.fecha_fin IS NOT NULL AND d.id_dia_de_semana <> 7 GROUP BY 1";
//	//static String qry = "SELECT A.A1,A.A2,C.C1 FROM TBLA A LEFT OUTER JOIN TBLB B ON A.A1 = B.B1 LEFT OUTER JOIN TBLC C ON B.B1 = C.C1";
//	//static String qry = "SELECT SUM ( A.A + B.B ) FROM ( SELECT A.A,B.B, ( SELECT C.C FROM TBLA A INNER JOIN TBLC C ON C.C = A.A ) AS C FROM TBLB B INNER JOIN ( SELECT B.B FROM TBL B ) AS B";
//	//static String qry = "SELECT NOMIX.CIFNIF AS NIF_CLIENTE,NOMIX.NUM_CLIENTE,NOMIX.COD_ESTADO_GENERAL,NOMIX.TIPO_DOCUMENTO_NORM,NOMIX.CLASE_CLI_COD_CLASE_CLIENTE,NOMIX.DES_TIPO_CLIENTE,NOMIX.DES_SUBTIPO_CLIENTE,NOMIX.CIF_CABECERA,SEGM_ACT.COD_SEGMENTO AS COD_SEGM_ANT, SEGM_ACT.FEC_SEGMENTO,NOMIX.GRUPO_COMERCIAL,NOMIX.ANTIG_MESES,NOMIX.FEC_INSTALACION,CURRENT_TIMESTAMP AS FECHA_CARGA	FROM ${DBDWHV}.${V_MS_CLIENTES_NO_MIXTOS} NOMIX	LEFT OUTER JOIN (SELECT ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}.NIF_CLIENTE, ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}.COD_SEGMENTO, ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}.FEC_SEGMENTO FROM ${DBDWHV}.${V_HC_MS_HIST_SEGMENTO_MERCADO}) SEGM_ACT ON NOMIX.CIFNIF =SEGM_ACT.NIF_CLIENTE WHERE CAST(NOMIX.FEC_INSTALACION AS DATE FORMAT 'YYYYMMDD') > CAST('${FEC_ANT}' AS DATE FORMAT 'YYYYMMDD') 	AND  CAST(NOMIX.FEC_INSTALACION AS DATE FORMAT 'YYYYMMDD') <= CAST('${FEC_ACT}' AS DATE FORMAT 'YYYYMMDD')";
//
//
//	/*
//	 *  The keywords we use/filter with at the moment
//	 */
//
//	final static String kw = new String(""
//			+ "(?<=FROM)|(?=FROM)|"
//			+ "(?<!LEFT\\sOUTER|RIGHT\\sOUTER)(?=\\sJOIN\\s)|"
//			+ "(?<!LEFT\\sOUTER|RIGHT\\sOUTER)(?<=\\sJOIN\\s)|"
//			+ "(?=LEFT\\sOUTER|RIGHT\\sOUTER)(?!\\sJOIN\\s)|"
//			+ "(?<=LEFT\\sOUTER|RIGHT\\sOUTER)(?!\\sJOIN\\s)|"
//			+ "(?<=LEFT\\sOUTER\\sJOIN\\s|RIGHT\\sOUTER\\sJOIN\\s)|"
//			+ "(?=LEFT\\sOUTER\\sJOIN\\s|RIGHT\\sOUTER\\sJOIN\\s)|"
//			+ "(?<=FULL\\sOUTER\\sJOIN\\s|INNER\\sJOIN\\s)|"
//			+ "(?=FULL\\sOUTER\\sJOIN\\s|INNER\\sJOIN\\s)|"
//			+ "(?<=\\sON\\s)|(?=\\sON\\s)|"
//			+ "(?<=\\sAND\\s)|(?=\\sAND\\s)|"
//			+ "(?<=\\sWHERE\\s)|(?=\\sWHERE\\s)|"
//			+ "(?<=\\sAS\\s)|(?=\\sAS\\s)|"
//			+ "(?<=\\sSELECT\\s)|(?=\\sSELECT\\s)|"
//			+ "(?<=\\bSELECT\\s)|(?=\\bSELECT\\s)|"
//			+ "(?<=\\sSUM\\s)|(?=\\sSUM\\s)|"
//			+ "(?<=\\sSUM)|(?=\\sSUM)|"
//			+ "(?<=\\sIS NOT NULL)|(?=\\sIS NOT NULL)|"
//			+ "(?<==)|(?==)|"
//			+ "(?<=<)|(?=<)|"
//			+ "(?<=\\+)|(?=\\+)|"
//			+ "(?<=\\-)|(?=\\-)|"
//			+ "(?<=>)|(?=>)|"
//			+ "(?<=\\))|(?=\\))|"
//			+ "(?<=\\()|(?=\\()");
//
//	public String main(String s){
//		qry = qry.toUpperCase();
//		qry = qry.replace("  ", " ");
//		for(String part : qry.split(kw))
//			System.out.println(part);
//		return s;
//	}
//
//
//	public SQLParser() {
//		super();
//	}
//
//	public static void main(String[] args) {
//		// WE DISSECT THE ORIGINAL QUERY
//		qry = qry.toUpperCase();
//		while(qry.contains("  "))
//			qry = qry.replace("  ", " ");
//		System.out.print("ORIGINAL QUERY:   "+qry+"\n");
//		String tmpquery = qry;
//		int pos = 0;
//		while(pos!=tmpquery.length()-1){
//			if(tmpquery.substring(pos,pos+1).equals(".")){
//				String alias = "";
//				String fieldname = "";
//				alias = tmpquery.substring(0,pos).trim();
//				alias = alias.substring(alias.lastIndexOf(" ")).trim();
//				if(alias.contains(","))
//					alias = alias.substring(alias.lastIndexOf(",")+1).trim();
//				fieldname = tmpquery.substring(pos+1).trim();
//				if(fieldname.contains(" "))
//					fieldname = fieldname.substring(0,fieldname.indexOf(" "));
//				tmpquery = tmpquery.replaceFirst(alias+"."+fieldname, alias+"."+alias+fieldname);
//			}
//			pos++;
//		}
//
//		System.out.println("FINAL QUERY:  "+dissectQRY(updateAliases(tmpquery)));
//
//	}
//
//	/* 	
//	 *	This function dissects the query. First it checks if the 
//	 *	query contains a subquery. If it does, it calls itself and passes 
//	 *	that subquery as a parameter. It does the same with joins and where's.
//	 *
//	 * 	@param	query	The query to dissect
//	 * 	@return 		The updated query.
//	 */
//	private static String dissectQRY(String query){
//		String var = "";
//		String tmp ="";
//		int count = 0;
//		int parenthesis;
//		int pos= 0;
//		int i;
//		// CHECK FOR SUBQUERIES
//		Pattern p = Pattern.compile("\\(SELECT|\\([\\s]*SELECT");
//		Matcher m = p.matcher(query);
//
//		while(m.find()){
//			count ++;
//		}
//		if(0<count){
//			tmp = query;
//
//			for(int c = 0;c < count;c++){
//				i = tmp.indexOf("SELECT");
//				if(tmp.substring(0, i).trim().endsWith("(")){
//					tmp = tmp.substring(i);
//					parenthesis = 1;
//					pos = 0;
//
//					// WE LOOK FOR WHEN THERE IS THE CORRESPONDING CLOSING PARENTHESIS SO THAT WE HAVE
//					// THE END OF THE ORIGINAL SUBQUERY.
//					while(pos <= tmp.length() && parenthesis > 0 ){
//						switch (tmp.charAt(pos)){
//						case '(':
//							parenthesis ++;
//							break;
//						case ')':
//							parenthesis --;
//							break;
//						}
//						pos++;
//					}
//					// WE GET THE ALIAS OF OUR SUBQUERY AND STORE IT IN A VARIABLE.
//					var = tmp.substring(pos).trim().substring(0,tmp.substring(pos).trim().indexOf(" "));
//					if(var.trim().equals("AS")){
//						var = tmp.substring(pos).trim().substring(3).substring(0, tmp.substring(pos).trim().substring(3).indexOf(" "));
//					}
//					String pre = query.substring(0, query.indexOf(tmp.substring(0,pos-1))).substring(0,query.substring(0, query.indexOf(tmp.substring(0,pos-1))).lastIndexOf("("));
//					String post = query.substring(query.indexOf(tmp.substring(0,pos))+tmp.substring(0,pos).length());
//					String mid = dissectQRY(tmp.substring(0,pos-1));
//					mid = mid.substring(mid.lastIndexOf(" FROM ")+6).trim();
//					if(post.trim().startsWith("AS")){
//						post = post.trim();
//						post = post.substring(post.indexOf(" ")).trim();
//						post = post.substring(post.indexOf(" ")).trim();
//					}
//					if(mid.contains("AS"))
//						mid = mid.substring(0, mid.indexOf(" "))+" "+mid.substring(mid.lastIndexOf(" "));
//					mid = mid.replaceAll("\\)", "");
//					query = pre.trim() +" "+ mid +" "+ post.trim();
//					post = dissectQRY(tmp.substring(0,pos-1)).substring(tmp.lastIndexOf(" FROM ")+6).trim();
//					post = post.substring(post.lastIndexOf(" "));
//					query = query.replaceAll(" "+var+"\\."," "+post.trim()+"\\.");
//					tmp = updateAliases(tmp);
//					query = updateAliases(query);
//
//
//				}else{
//					// IN CASE WE FIND A SELECT NOT PRECEDED BY A '(',
//					// WE FOUND THE FIRST SELECT, AND IT'S NOT PART OF OUR
//					// SUBQUERIES SELECTS. SO WE DON'T COUNT THIS LOOP.
//					tmp = tmp.substring(i+6);
//				}
//			}
//
//		}
//		count = 0;
//		tmp ="";
//		String jntmp = "";
//		p = Pattern.compile(" JOIN ");
//		m = p.matcher(query);
//		while(m.find()){
//			count ++;
//		}
//		if(0<count){
//			tmp = query;
//			while(0<countJoins(tmp)){
//				tmp = tmp.substring(0,tmp.lastIndexOf("JOIN"));
//				if(tmp.trim().endsWith("INNER")){
//					jntmp = tmp.trim().substring(0,tmp.lastIndexOf("INNER")).trim();
//				}else if(tmp.trim().endsWith("OUTER")){
//					jntmp = tmp.substring(0,tmp.lastIndexOf("OUTER")).trim().substring(0,tmp.substring(0,tmp.lastIndexOf("OUTER")).trim().lastIndexOf(" ") );
//				}
//				tmp = dissectQRY(updateAliases(jntmp));
//				if(query.trim().indexOf(jntmp.trim())!=0)
//					query = query.replace(jntmp,tmp.substring(tmp.lastIndexOf(" FROM ")+5));
//				else
//					query = query.replace(jntmp,tmp);
//
//				if(jntmp.contains(" JOIN "))
//					jntmp = jntmp.substring(0,jntmp.lastIndexOf("ON")).trim();
//
//				jntmp = jntmp.substring(jntmp.lastIndexOf(" ")).trim();
//				tmp = tmp.substring(tmp.lastIndexOf(" ")).trim();
//				query = query.replaceAll(" "+jntmp+"\\."," "+tmp+"\\.");
//				query = query.replaceAll(" "+jntmp+" "," "+tmp+" ");
//				query = updateAliases(query);
//
//			}
//
//		}
//
//		System.out.println("PRE     " +query+"\n");
//		query = analyzeQRY(query);
//		System.out.println("POST    " +query+"\n");
//		if(query.contains("WHERE")){
//			query = analyzeQRY(query);
//			System.out.println("POST    " +query+"\n");
//		}
//
//		return query;
//	}
//
//	/*
//	 * 	This function counts the number of joins in the given query
//	 * 
//	 * 	@param	query	The query to analyze.
//	 *	@return			An integer representing the number of joins in the query.				
//	 */
//	private static Integer countJoins(String qry){
//		Pattern p = Pattern.compile(" JOIN ");
//		Matcher m = p.matcher(qry);
//		Integer count = 0;
//		while (m.find()){
//			// COUNT HOW MANY TIMES 'JOIN' OCCURS IN THE QUERY
//			count +=1;
//		}		
//		return count;
//	}
//
//	/*
//	 * 	This function updates the aliases of the query.
//	 * 	It will look for the tablenames and check if their alias 
//	 * 	corresponds.
//	 * 
//	 * 	@param	query	The query to update.
//	 * 	@return			The updated query.
//	 */
//	private static String updateAliases(String query){
//		String tmpquery = query;
//		ArrayList<String> fields = new ArrayList<String>(); 
//		Pattern p = Pattern.compile("\\w+\\.\\w+");
//		Matcher m = p.matcher(query);
//		while(m.find())
//			if(!fields.contains(m.group()))
//				fields.add(m.group());
//		for(String s : fields){
//			for(int i = 0;i<fields.size()-1;i++){
//				String compare = fields.get(i);
//				if(!s.equals(compare) && s.contains(".") && compare.contains(".") && compare.substring(compare.indexOf(".")).equals(s.substring(s.indexOf(".")))){
//					tmpquery = tmpquery.replace(compare, s);
//					fields.set(i, s);
//				}
//			}
//		}
//
//		return tmpquery;
//	}
//
//	/*
//	 * 	This function checks the query to see what kind of mapping
//	 * 	it needs to be transformed into. It checks i.e. if the query
//	 * 	is a join and calls the corresponding function to create the mapping.
//	 * 
//	 * 	@param s	The query.
//	 */
//	private static String analyzeQRY(String s){
//		s = updateAliases(s);
//		String sDAlias = "";
//		String sDName = ""; 
//		String sMAlias = "";
//		String sMName = "";
//		String joinType = "";
//		String tmp = "";
//		ArrayList<String> sfMNames = new ArrayList<String>();
//		ArrayList<String> sfDNames = new ArrayList<String>();
//		ArrayList<String> tfNames = new ArrayList<String>();
//		sfOther = new ArrayList<String>();
//		sOldTables = new ArrayList<String>();
//		ArrayList<String> conds = new ArrayList<String>();
//		POWERMART p = new POWERMART();
//
//
//		if(s.contains("JOIN")){
//			// IF THE QUERY CONTAINS 'JOIN', WE CHECK WHAT KIND OF JOIN IT IS.
//			// WE STORE THE NAME OF THE MASTER TABLE, DETAIL TABLE, MASTER ALIAS AND DETAIL ALIAS.
//			if(s.contains("FULL OUTER JOIN")){
//				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("FULL OUTER JOIN"));
//				sMName = sMAlias.trim();
//				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
//				sMAlias = sMAlias.trim();
//				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
//				sDAlias = s.substring(s.indexOf("FULL OUTER JOIN")+15,s.indexOf(" ON "));
//				sDName = sDAlias.trim();
//				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
//				sDAlias = sDAlias.trim();
//				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
//				joinType = "FOJ";
//			}else if(s.contains("LEFT OUTER JOIN")){
//				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("LEFT OUTER JOIN"));
//				sMName = sMAlias.trim();
//				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
//				sMAlias = sMAlias.trim();
//				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
//				sDAlias = s.substring(s.indexOf("LEFT OUTER JOIN")+15,s.indexOf(" ON "));
//				sDName = sDAlias.trim();
//				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
//				sDAlias = sDAlias.trim();
//				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
//				joinType = "LOJ";
//			}else if(s.contains("RIGHT OUTER JOIN")){
//				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("RIGHT OUTER JOIN"));
//				sMName = sMAlias.trim();
//				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
//				sMAlias = sMAlias.trim();
//				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
//				sDAlias = s.substring(s.indexOf("RIGHT OUTER JOIN")+16,s.indexOf(" ON "));
//				sDName = sDAlias.trim();
//				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
//				sDAlias = sDAlias.trim();
//				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
//				joinType = "ROJ";
//			}else if(s.contains("INNER JOIN")){
//				sMAlias = s.substring(s.indexOf("FROM")+4,s.indexOf("INNER JOIN"));
//				sMName = sMAlias.trim();
//				sMName = sMName.substring(0,sMName.indexOf(" ")).trim();
//				sMAlias = sMAlias.trim();
//				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
//				sDAlias = s.substring(s.indexOf("INNER JOIN")+10,s.indexOf(" ON "));
//				sDName = sDAlias.trim();
//				sDName = sDName.substring(0,sDName.trim().indexOf(" ")).trim();
//				sDAlias = sDAlias.trim();
//				sDAlias = sDAlias.substring(sDAlias.trim().indexOf(" ")).trim();
//				joinType = "IJ";
//			}
//			// WE KEEP THESE ALIASES IN AN ARRAYLIST SO THAT WE CAN REPLACE THEM AFTERWARDS IN THE ORIGINAL 
//			// QUERY WITH THE NEW TABLENAME.
//			sOldTables.add(sMAlias);
//			sOldTables.add(sDAlias);
//
//			// WE GET ALL THE FIELDNAMES, BY TAKING A SUBSTRING FROM AFTER THE SELECT UNTIL THE 'FROM' KEYWORD.
//			// AFTER THIS WE TAKE THE CONDITION AND TAKE ALL THE WORDS THAT AREN'T KEYWORDS.
//			tmp = s.substring(s.trim().indexOf(" ")+1, s.indexOf("FROM"));
//			//			while(s.contains(" "+sMAlias+"."))
//			//				s = s.replace(" "+sMAlias+".", " ");
//			//			while(s.contains(" "+sDAlias+"."))
//			//				s = s.replace(" "+sDAlias+".", " ");
//
//			conds = getJoinCondition(s.substring(s.indexOf("ON")));
//
//			for(String condition : conds)
//				for(String var : condition.split(kw))
//					if(!isKeyWord(var) && !NumberUtils.isCreatable(var.trim()))
//						tmp = tmp +","+ var;
//			// FOR EACH OF THE FIELDNAMES, WE CHECK IF IT'S PRECEDED BY THE MASTERALIAS, DETAILALIAS OR ANOTHER ONE,
//			// AND ADD THEM TO A CORRESPONDING ARRAYLIST.
//			for(String tablefield : tmp.split(",")){
//				tablefield = tablefield.trim();
//				if(tablefield.contains(".")){
//					if(tablefield.substring(0, tablefield.indexOf(".")).equals(sMAlias)){
//						if(!sfMNames.contains(tablefield)){
//							sfMNames.add(tablefield);
//							tfNames.add(tablefield);
//						}
//					}else if(tablefield.substring(0, tablefield.indexOf(".")).equals(sDAlias)){
//						if(!sfDNames.contains(tablefield)){
//							sfDNames.add(tablefield);
//							tfNames.add(tablefield);
//						}
//					}
//				}else{
//					if(!sfOther.contains(tablefield))
//						sfOther.add(tablefield);
//				}
//
//
//
//			}
//
//
//			// WE HAVE ALL THE NECESSARY DATA TO CONVERT THE QUERY TO A MAPPING/POWERCENTER OBJECT.
//			p = convToJoiner(sMName, sMAlias,sfMNames, sDName, sDAlias, sfDNames,  tfNames, conds, joinType);
//
//		}else if(s.contains(" WHERE ")){
//			// GET THE TABLENAME
//			sMAlias = s.substring(s.indexOf("FROM")+4).trim();
//			if(0 < sMAlias.indexOf(" ")){
//				sMName = sMAlias.substring(0, sMAlias.indexOf(" ")).trim();;
//				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
//				sMAlias = sMAlias.substring(0,sMAlias.indexOf(" ")).trim();
//			}else{
//				sMName = sMAlias;
//			}
//			// GET THE WHERE CONDITION(S)
//			String filtercondition = s.substring(s.indexOf(" WHERE ")+7);
//
//			// GET THE SOURCEFIELDS
//			tmp = s.substring(s.trim().indexOf(" ")+1, s.indexOf(" FROM "));
//			for(String var : s.substring(s.indexOf(" WHERE ")+7).split(kw))
//				if(!isKeyWord(var) && !NumberUtils.isCreatable(var.trim()) )
//					tmp = tmp +","+ var;
//			for(String sfn : tmp.split(",")){
//				if(!sfn.trim().startsWith("'") && !sfn.trim().endsWith("'")){
//					if(sfn.trim().contains(" AS "))
//						sfMNames.add(sfn.substring(sfn.indexOf(" AS ")+4));
//					if(0<=sfn.trim().indexOf(sMAlias+".")){
//						if(!sfMNames.contains(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2))){
//							sfMNames.add(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2));
//						}
//					}else
//						sfOther.add(sfn.trim());
//				}
//			}
//
//			p = convToSelFil(sMName, sMAlias, sfMNames, filtercondition);
//
//		}else{
//			// NO TRANSFORMATION, JUST SELECT INSERT.
//
//			// GET THE TABLENAME
//			sMAlias = s.substring(s.indexOf("FROM")+4).trim();
//			if(0 < sMAlias.indexOf(" ")){
//				sMName = sMAlias.substring(0, sMAlias.indexOf(" ")).trim();;
//				sMAlias = sMAlias.substring(sMAlias.indexOf(" ")).trim();
//			}else{
//				sMName = sMAlias;
//			}
//
//			// GET THE SOURCEFIELDS
//			tmp = s.substring(s.trim().indexOf(" ")+1, s.indexOf("FROM"));
//			if(tmp.contains(",")){
//				for(String sfn : tmp.split(",")){
//					if(sfn.trim().contains(" AS "))
//						sfn = sfn.substring(sfn.indexOf(" AS ")+4);
//					if(0<=sfn.trim().indexOf(sMAlias+"."))
//						sfMNames.add(sfn.trim().substring(sfn.trim().indexOf(sMAlias+".")+2));
//					else
//						sfOther.add(sfn.trim());
//				}
//			}else 
//				if(0<tmp.length()){
//					if(tmp.trim().contains(" AS "))
//						tmp = tmp.substring(tmp.indexOf(" AS ")+4);
//					if(0<=tmp.trim().indexOf(sMAlias+"."))
//						sfMNames.add(tmp.trim().substring(tmp.trim().indexOf(sMAlias+".")+2));
//					else
//						sfOther.add(tmp.trim());
//				}
//
//			p = convToSelIns(sMName, sMAlias, sfMNames);
//
//		}
//
//		/*	
//		 * MappingParser.generateDDL(p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0));
//		for (SOURCE src :  p.getREPOSITORY().get(0).getFOLDER().get(0).getSOURCE()){
//			MappingParser.generateDDL(src);
//		}
//		 */	
//		MappingParser.writeToXML(p);
//
//		tmp = "";
//		if(sfOther.isEmpty()){
//			tmp = " SELECT ";
//			for(TARGET t : p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET()){
//				for(TARGETFIELD tf : t.getTARGETFIELD())
//					tmp = tmp + sMAlias +"."+ tf.getNAME() + ", ";
//				tmp = tmp.substring(0,tmp.lastIndexOf(",")) + " FROM " +t.getNAME()+" "+sMAlias;
//			}
//
//		}else{
//			tmp = " SELECT ";
//			for(TARGETFIELD tf : p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getTARGETFIELD())
//				tmp = tmp + sMAlias +"."+tf.getNAME() + ", ";
//			for(String sf : sfOther)
//				tmp = tmp + sf + ", ";
//
//			tmp = tmp.substring(0,tmp.lastIndexOf(",")) + " FROM " +p.getREPOSITORY().get(0).getFOLDER().get(0).getTARGET().get(0).getNAME()+" "+sMAlias;
//
//		}
//		if(s.contains("WHERE") && !tmp.contains(" WHERE ")){
//			tmp = tmp + s.substring(s.indexOf(" WHERE "));
//		}else if(s.contains("WHERE")){
//			tmp = tmp.substring(0,tmp.indexOf(" WHERE "));
//		}
//		sfOther.clear();
//
//		return tmp;
//	}
//
//	/*
//	 * 	This function gets the joincondition of the given joinquery.
//	 * 
//	 * 	@param	s	The query with the join.
//	 * 	@return		It returns an ArrayList of Strings with all the conditions.
//	 */
//	private static ArrayList<String> getJoinCondition(String s){
//		// FUNCTION THAT RETURNS AN ARRAYLIST OF STRINGS
//		// WITH THE JOINCONDITION.
//		ArrayList<String> conds = new ArrayList<String>();
//		String condition = "";
//		// WE CHECK WHERE THE CONDITION STARTS (AFTER THE ON IN THE JOIN)
//		int i = s.indexOf("ON");
//		String tmp = s.substring(i+3).trim();
//		tmp = tmp.trim();
//		if(tmp.startsWith("("))
//			tmp = tmp.substring(1).trim();
//		if(tmp.endsWith(")"))
//			tmp = tmp.substring(0, tmp.length()-1).trim();
//
//
//		String keyw ="";
//		while(!tmp.equals("") && !keyw.equals("WHERE")){
//			if(!isKeyWord(" "+keyw+" ")&&tmp.contains(" ")){
//				// IF THE KEYWORD ISN'T A KEYWORD AND THE CONDITION CONTAINS AN EMPTY SPACE 
//				// WE ADD THE NEXT PART TO THE CONDITION, FROM THE START UNTIL
//				// THE NEXT SPACE.
//				condition = condition + tmp.substring(0, tmp.indexOf(" ")+1);
//				// WE SET TMP = SUBSTRING STARTING AFTER THE NEXT SPACE.
//				tmp = tmp.substring(tmp.indexOf(" ")+1);
//				// IN CASE THERE'S STILL ANOTHER SPACE IN TMP
//				// WE SET KEYW = THE SUBSTRING FROM THE START UNTIL THAT SPACE,
//				// SO THAT WE CAN CHECK IT AGAIN.
//				if(tmp.indexOf(" ")>0)
//					keyw = tmp.substring(0,tmp.indexOf(" "));
//			}else if(tmp.contains(" ") && !keyw.trim().equals("AND")&& !keyw.trim().equals("OR")){
//				condition = condition + tmp.substring(0, tmp.indexOf(" ")+1);
//				tmp = tmp.substring(tmp.indexOf(" ")+1);
//				if(tmp.indexOf(" ")>0)
//					keyw = tmp.substring(0,tmp.indexOf(" "));
//			}else if(!tmp.contains(" ")){
//				// IN CASE KEYW IS A KEYWORD AND DOESN'T CONTAIN AN EMPTY SPACE 
//				// WE ADD IT TO THE CONDITION AND ADD THAT CONDITION TO THE ARRAYLIST
//				condition = condition + tmp;
//				tmp = "";
//				conds.add(condition);
//				// WE RESET THE CONDITIONSTRING AND KEYWORDS
//				condition = "";
//				keyw = "";
//			}else {
//				// IN CASE WE DON'T HAVE ANY SPACES LEFT, 
//				// WE CAN ASSUME WE'RE AT THE LAST KEYWORD OF OUR CONDITION
//				// AND FINISH IT UP.
//				tmp = tmp.substring(keyw.length());
//				conds.add(condition);
//				condition = "";
//				keyw = "";
//			}
//		}
//		return conds;
//	}
//
//	/*
//	 * 	This function creates a POWERMART-object containing a mapping
//	 * 	with a joinertransformation, based on the given join-query.
//	 * 
//	 * 	@param	mSrc	The name of the Master source table.
//	 * 	@param	sMAlias	The alias of the Master source table.
//	 * 	@param	sfM		An ArrayList of the sourcefieldnames from the Master source table.
//	 * 	@param	dSrc	The name of the Detail source table.
//	 * 	@param	sDAlias	The alias of the Detail source table.
//	 * 	@param	sfD		An ArrayList of the sourcefieldnames from the Detail source table.
//	 * 	@param 	tfss	An ArrayList of the targetfieldnames from both source tables.
//	 * 	@param	conds	An ArrayList with the joinconditions.
//	 * 	@param	joinType	The type of join.
//	 * 	@return			A POWERMART object containing the mapping with the jointransformation.
//	 */
//	private static POWERMART convToJoiner(String mSrc, String sMAlias,ArrayList<String> sfM, String dSrc, String sDAlias,ArrayList<String> sfD, ArrayList<String> tfss, ArrayList<String> conds, String joinType){
//		MAPPING map = new MAPPING();
//		FOLDER folder = new FOLDER("XDW991593" ,"Everis : Antonio Jesus, Group for Global Corporate Teaser Tool(GCT), Developer, antonio.jesus.munoz.lapaz@zurich.com" ,"NOTSHARED","w991593" ,"","rwx---r--" ,"55cd59eb-588d-4840-8dee-97c3257a4945");
//		int i;
//
//		INSTANCE inst = new INSTANCE();
//		ArrayList<INSTANCE> insts = new ArrayList<INSTANCE>();
//		CONNECTOR con = new CONNECTOR();
//		ArrayList<CONNECTOR> cons = new ArrayList<CONNECTOR>();
//		String cond = "";
//
//		mSrc = mSrc.replace(".", "");
//		mSrc = mSrc.replace("SRC_", "");
//		mSrc = mSrc.replace("TGT_", "");
//		mSrc.substring(0,mSrc.length()/2);
//		dSrc = dSrc.replace(".", "");
//		dSrc = dSrc.replace("SRC_", "");
//		dSrc = dSrc.replace("TGT_", "");
//		dSrc.substring(0,mSrc.length()/2);
//		sMAlias = sMAlias.replace(".", "");
//		sMAlias = sMAlias.replace("TGT_", "");
//		sMAlias = sMAlias.replace("SRC_", "");
//		sDAlias = sDAlias.replace(".", "");
//		sDAlias = sDAlias.replace("SRC_", "");
//		sDAlias = sDAlias.replace("TGT_", "");
//
//		// FOR A JOINER WE NEED A MASTER AND A DETAIL SOURCE, IT'S CORRESPONDING SOURCE QUALIFIERS, 
//		// A JOINER TRANSFORMATION AND A TARGET.
//		// EACH SOURCEFIELD WILL BE A FIELD IN THE SOURCE, THE SOURCE QUALIFIER, THE JOINER AND THE TARGET.
//		// BASED ON THIS KNOWLEDGE, WE CAN GENERATE THE CONNECTORS ALREADY AS WELL AS THESE FIELDS.
//
//
//		// CREATING A SOURCE OBJECT FOR THE MASTER
//		SOURCE m = new SOURCE("SRC_"+mSrc,"DB2","","","1","","DB2","1");
//		ArrayList<SOURCEFIELD> smfs = new ArrayList<SOURCEFIELD>();
//		int fieldnum = 0;
//		int physicaloffset = 0;
//		fieldnum = 0;
//		for(String s : sfM){
//			physicaloffset = physicaloffset + 10;
//			SOURCEFIELD sf = new SOURCEFIELD(s.substring(s.indexOf(".")+1),"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
//			smfs.add(sf);
//
//			con = new CONNECTOR(sf.getNAME(),"SRC_"+mSrc,"Source Definition","Source Qualifier","SQ_SRC_"+ mSrc,sf.getNAME());
//			cons.add(con);
//			con = new CONNECTOR(sf.getNAME(),"SQ_SRC_"+ mSrc,"Source Qualifier","Joiner","JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),sf.getNAME());
//			cons.add(con);
//			con = new CONNECTOR(sf.getNAME(),"JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","Target Definition","TGT_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),sf.getNAME());
//			cons.add(con);
//
//		}
//		m.getSOURCEFIELD().addAll(smfs);
//		inst = new INSTANCE("DB2","SRC_"+mSrc,"SOURCE", "NO", "Source Definition","SRC_"+mSrc);
//		insts.add(inst);
//
//
//		// CREATING A SOURCE OBJECT FOR THE DETAIL AND THE TRANSFORMFIELDS
//		SOURCE d = new SOURCE("SRC_"+dSrc,"DB2","","","1","","DB2","1");
//		ArrayList<SOURCEFIELD> sdfs = new ArrayList<SOURCEFIELD>();
//		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
//		fieldnum = 0;
//		physicaloffset = 0;
//		for(String s : sfD){
//			physicaloffset = physicaloffset+10;
//			SOURCEFIELD sf = new SOURCEFIELD(s.substring(s.indexOf(".")+1),"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
//			TRANSFORMFIELD trf = new TRANSFORMFIELD(s.substring(s.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
//			trfs.add(trf);
//			sf.setNAME(s);
//			sdfs.add(sf);
//			if(sf.getNAME().contains("."))
//				sf.setNAME(sf.getNAME().substring(sf.getNAME().indexOf(".")+1));
//			con = new CONNECTOR(sf.getNAME(),"SRC_"+dSrc,"Source Definition","Source Qualifier","SQ_SRC_"+ dSrc,sf.getNAME());
//			cons.add(con);
//			con = new CONNECTOR(sf.getNAME(),"SQ_SRC_"+ dSrc,"Source Qualifier","Joiner","JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s.substring(s.indexOf(".")+1));
//			cons.add(con);
//			con = new CONNECTOR(sf.getNAME(),"JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","Target Definition","TGT_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),s.substring(s.indexOf(".")+1));
//			cons.add(con);
//			fieldnum++;
//		}
//		d.getSOURCEFIELD().addAll(sdfs);
//		inst = new INSTANCE("DB2","SRC_"+dSrc,"SOURCE","NO","Source Definition","SRC_"+dSrc);
//		insts.add(inst);
//		// ADDING BOTH SOURCES TO AN ARRAYLIST TO ADD THEM TO THE FOLDER
//		ArrayList<SOURCE> srcs = new ArrayList<SOURCE>();
//		srcs.add(m);
//		srcs.add(d);
//
//		// CREATING A TARGET AND ADDING ITS TARGETFIELDS
//		TARGET tgt = new TARGET();
//		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
//		trfs = new ArrayList<TRANSFORMFIELD>();
//		i = 0;
//		for(String t : tfss){
//			TARGETFIELD tf = new TARGETFIELD();
//			TRANSFORMFIELD trf = new TRANSFORMFIELD();
//			i++;
//			if(t.substring(0, 1).equals(sMAlias)){
//				tf = new TARGETFIELD(t.substring(t.indexOf(".")+1),"varchar","NOT A KEY","10","0","NULL",Integer.toString(i));
//				trf = new TRANSFORMFIELD(t.substring(t.indexOf(".")+1),"string","INPUT/OUTPUT/MASTER","10","0");
//			}else{
//				tf = new TARGETFIELD(t.substring(t.indexOf(".")+1),"varchar","NOT A KEY","10","0","NULL",Integer.toString(i));
//				trf = new TRANSFORMFIELD(t.substring(t.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
//			}
//			trfs.add(trf);
//			tfs.add(tf);
//		}
//		// TARGET DETAILS 
//		tgt = new TARGET("TGT_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3), "1", "DB2", "1",tfs);
//
//		// TARGET INSTANCE
//		inst = new INSTANCE("TGT_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"TARGET","NO","Target Definition","TGT_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3));
//		insts.add(inst);
//
//		// TARGETLOADORDER
//		TARGETLOADORDER tgtlo = new TARGETLOADORDER(tgt.getNAME(),"1");
//		map.getTARGETLOADORDER().add(tgtlo);
//
//		// TRANSFORMATIONS
//		// SOURCE QUALIFIERS
//		TRANSFORMATION trns = new TRANSFORMATION();
//		ArrayList<TABLEATTRIBUTE> tas = new ArrayList<TABLEATTRIBUTE>();
//		TABLEATTRIBUTE tabat = new TABLEATTRIBUTE();
//
//		for(SOURCE src : srcs){
//			ArrayList<TRANSFORMFIELD> sftotf = new ArrayList<TRANSFORMFIELD>();
//			for(SOURCEFIELD sf : src.getSOURCEFIELD()){
//				if(sf.getNAME().contains(".")){
//					sf.setNAME(sf.getNAME().substring(sf.getNAME().indexOf(".")+1));
//				}
//				TRANSFORMFIELD tf = new TRANSFORMFIELD(sf.getNAME(), "string", "INPUT/OUTPUT", sf.getPRECISION(),sf.getSCALE());
//				sftotf.add(tf);
//			}
//			tas = new ArrayList<TABLEATTRIBUTE>();
//			tabat = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
//			tas.add(tabat);
//			tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
//			tas.add(tabat);
//			tabat = new TABLEATTRIBUTE("Is Partitionable","NO");
//			tas.add(tabat);
//			tabat = new TABLEATTRIBUTE("Output is deterministic","NO");
//			tas.add(tabat);
//			tabat = new TABLEATTRIBUTE("Output is repeatable","Never");
//			tas.add(tabat);
//			trns = new TRANSFORMATION("SQ_"+src.getNAME(),"Source Qualifier","1","NO","1");
//			trns.getTRANSFORMFIELD().addAll(sftotf);
//			inst = new INSTANCE("DB2","SQ_"+src.getNAME(),"TRANSFORMATION", "NO", "Source Qualifier","SQ_"+src.getNAME());
//
//			// ASSOCIATEDSOURCEINSTANCE 
//			ASSOCIATEDSOURCEINSTANCE asi = new ASSOCIATEDSOURCEINSTANCE(src.getNAME());
//			inst.getASSOCIATEDSOURCEINSTANCE().add(asi);
//			insts.add(inst);
//
//			map.getTRANSFORMATION().add(trns);
//		}
//		// JOIN TRANSFORMATION DETAILS & TABLEATTRIBUTES
//		tas = new ArrayList<TABLEATTRIBUTE>();
//		tabat = new TABLEATTRIBUTE("Case Sensitive String Comparison","YES");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Cache Directory","$PMCacheDir");
//		tas.add(tabat);
//
//		for(String s : conds){
//			cond = cond + s +" AND ";
//		}
//		if(cond.length()!=0){
//			cond = cond.substring(0, cond.length()-5);
//			while(cond.contains(".")){
//				String temp = cond.substring(0,cond.indexOf(".")-1);
//				cond = temp + cond.substring(cond.indexOf(".")+1);
//
//			}
//		}
//
//		tabat = new TABLEATTRIBUTE("Join Condition",cond);
//		tas.add(tabat);
//		// JOINTYPE
//		switch (joinType){
//		case "FOJ" : 
//			tabat = new TABLEATTRIBUTE("Join Type","Full Outer Join");	
//			break;
//		case "LOJ" : 
//			tabat = new TABLEATTRIBUTE("Join Type","Master Outer Join");
//			break;
//		case "ROJ" : 
//			tabat = new TABLEATTRIBUTE("Join Type","Detail Outer Join");
//			break;
//		case "IJ" : 
//			tabat = new TABLEATTRIBUTE("Join Type","Normal Join");
//			break;
//		}
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Null ordering in master","Null Is Highest Value");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Null ordering in detail","Null Is Highest Value");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Joiner Data Cache Size","Auto");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Joiner Index Cache Size","Auto");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Sorted Input","NO");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Master Sort Order","AUTO");
//		tas.add(tabat);
//		tabat = new TABLEATTRIBUTE("Transformation Scope","All Input");
//		tas.add(tabat);
//		// TODO "JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3)
//		trns = new TRANSFORMATION("JNR_"+mSrc.substring(0, 3)+"_"+dSrc.substring(0, 3),"Joiner","1","NO","1");
//		trns.getTRANSFORMFIELD().addAll(trfs);
//		trns.getTABLEATTRIBUTE().addAll(tas);
//
//		inst = new INSTANCE(trns.getNAME(),"TRANSFORMATION","NO","Joiner",trns.getNAME());
//		insts.add(inst);
//
//		// ADD NODES TO MAPPING
//		map.getTRANSFORMATION().add(trns);
//		map.getINSTANCE().addAll(insts);
//		map.getCONNECTOR().addAll(cons);
//		// MAPPING DETAILS
//		map.setISVALID("YES");
//		mSrc = mSrc.replace(".", "");
//		mSrc = mSrc.replace("TGT_", "");
//		dSrc = dSrc.replace(".", "");
//		dSrc = dSrc.replace("TGT_", "");
//		map.setNAME("m_JNR_"+mSrc+"_"+dSrc);
//		map.setOBJECTVERSION("1");
//		map.setVERSIONNUMBER("1");
//
//		// CONFIG
//		CONFIG config = new CONFIG();
//		config.setDESCRIPTION("Default session configuration object");
//		config.setISDEFAULT("YES");
//		config.setNAME("default_session_config");
//		config.setVERSIONNUMBER("1");
//		config.getATTRIBUTE().addAll(getConfigAttributes());
//
//
//
//
//		folder.getSOURCE().addAll(srcs);
//		folder.getTARGET().add(tgt);
//		folder.getMAPPING().add(map);
//		folder.getCONFIG().add(config);
//
//		REPOSITORY repository = new REPOSITORY("XDIPCRS","DB2","Latin1","184");
//		repository.getFOLDER().add(folder);
//
//		POWERMART powermart = new POWERMART("","");
//		powermart.getREPOSITORY().add(repository);
//
//		return powermart;
//	}
//
//	/*
//	 * 	This function creates a POWERMART-object containing a mapping
//	 * 	with a filtertransformation, based on the given filter-query.
//	 * 
//	 * 	@param	srcTbl				The name of the source table.
//	 * 	@param	srcAlias			The alias of the source table.
//	 * 	@param	sourcefieldnames	An ArrayList of the sourcefieldnames from the source table.
//	 * 	@param	filtercondition		The filtercondition of the filter.
//	 * 	@return						A POWERMART object containing the mapping with the jointransformation.
//	 */
//	private static POWERMART convToSelFil(String srcTbl, String srcAlias, ArrayList<String> sourcefieldnames, String filtercondition){
//		MAPPING map = new MAPPING();
//		FOLDER folder = new FOLDER("XDW991593" ,"Everis : Antonio Jesus, Group for Global Corporate Teaser Tool(GCT), Developer, antonio.jesus.munoz.lapaz@zurich.com" ,"NOTSHARED","w991593" ,"","rwx---r--" ,"55cd59eb-588d-4840-8dee-97c3257a4945");
//		ArrayList<SOURCEFIELD> sfs = new ArrayList<SOURCEFIELD>();
//		ArrayList<CONNECTOR> cons = new ArrayList<CONNECTOR>();
//		ArrayList<INSTANCE> insts = new ArrayList<INSTANCE>();
//		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
//		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
//		CONNECTOR con = new CONNECTOR();
//		INSTANCE inst = new INSTANCE();
//		int fieldnum = 0;
//
//		srcTbl = srcTbl.replace(".", "");
//		srcTbl = srcTbl.replace("TGT_", "");
//		srcTbl = srcTbl.replace("SRC_", "");
//		srcTbl = srcTbl.substring(0, srcTbl.length()/2);
//		srcAlias = srcAlias.replace(".", "");
//		srcAlias = srcAlias.replace("TGT_", "");
//
//		// CREATING A SOURCE, SQ, TARGET AND CONNECTORS
//		SOURCE src = new SOURCE();
//		TARGET tgt = new TARGET();
//		Integer physicaloffset = 0;
//		for(String s : sourcefieldnames){
//			physicaloffset = physicaloffset +10;
//			SOURCEFIELD sf = new SOURCEFIELD(s,"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
//			TRANSFORMFIELD trf = new TRANSFORMFIELD(s.substring(s.indexOf(".")+1),"string","INPUT/OUTPUT","10","0");
//			TARGETFIELD tf = new TARGETFIELD(s,"varchar","NOT A KEY","10","0","NULL",Integer.toString(fieldnum+1));
//
//			con = new CONNECTOR(s,"SRC_"+srcTbl,"Source Definition","Source Qualifier","SQ_"+ srcTbl,s);
//			cons.add(con);
//			if(!srcAlias.equals("")){
//				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Filter","FIL_"+srcTbl,s);
//				cons.add(con);
//				con = new CONNECTOR(s,"FIL_"+srcTbl,"Filter","Target Definition","TGT_"+srcTbl,s);
//				cons.add(con);
//			}else{
//				con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Filter","FIL_"+srcTbl,s);
//				cons.add(con);
//				con = new CONNECTOR(s,"FIL_"+srcTbl,"Filter","Target Definition","TGT_"+srcTbl,s);
//				cons.add(con);
//			}
//
//
//
//			sfs.add(sf);
//			tfs.add(tf);
//			trfs.add(trf);
//
//
//			fieldnum ++;
//		}
//		src = new SOURCE("SRC_"+srcTbl, "DB2", "", "", "1","","DB2", "1",sfs);
//
//		inst = new INSTANCE("DB2","SRC_"+srcTbl,"SOURCE", "NO", "Source Definition","SRC_"+srcTbl);
//		insts.add(inst);
//		inst = new INSTANCE("FIL_"+srcTbl,"TRANSFORMATION","NO","Filter","FIL_"+srcTbl);
//		insts.add(inst);
//
//
//		// TARGET DETAILS 
//		tgt = new TARGET("TGT_"+srcTbl, "1", "DB2", "1",tfs);
//		// TARGET INSTANCE
//		inst = new INSTANCE("TGT_"+srcTbl,"TARGET","NO","Target Definition","TGT_"+srcTbl);
//		insts.add(inst);
//
//		// TARGETLOADORDER
//		TARGETLOADORDER tgtlo = new TARGETLOADORDER(tgt.getNAME(),"1");
//		map.getTARGETLOADORDER().add(tgtlo);
//
//		ArrayList<TABLEATTRIBUTE> tas = new ArrayList<TABLEATTRIBUTE>();
//		TABLEATTRIBUTE tabat = new TABLEATTRIBUTE();
//
//		tas = new ArrayList<TABLEATTRIBUTE>();
//		tabat = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Is Partitionable","NO");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Output is deterministic","NO");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Output is repeatable","Never");
//		tas.add(tabat);
//		inst = new INSTANCE("DB2","SQ_"+srcTbl,"TRANSFORMATION", "NO", "Source Qualifier","SQ_"+srcTbl);
//
//		// SOURCE QUALIFIER
//		TRANSFORMATION trns = new TRANSFORMATION();
//		trns = new TRANSFORMATION("SQ_"+srcTbl,"Source Qualifier","1","NO","1");
//		trns.getTRANSFORMFIELD().addAll(trfs);
//		trns.getTABLEATTRIBUTE().addAll(tas);
//
//		//        <TRANSFORMATION DESCRIPTION ="" NAME ="FIL_DUP" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Filter" VERSIONNUMBER ="1">
//
//		TRANSFORMATION filtertransformation = new TRANSFORMATION("FIL_"+srcTbl,"Filter","1","NO","1");
//		filtertransformation.getTRANSFORMFIELD().addAll(trfs);
//		TABLEATTRIBUTE ta = new TABLEATTRIBUTE("Filter Condition",filtercondition);
//		filtertransformation.getTABLEATTRIBUTE().add(ta);
//		ta = new TABLEATTRIBUTE("Tracing Level","Normal");
//		filtertransformation.getTABLEATTRIBUTE().add(ta);
//
//		// ASSOCIATEDSOURCEINSTANCE 
//		ASSOCIATEDSOURCEINSTANCE asi = new ASSOCIATEDSOURCEINSTANCE(src.getNAME());
//		inst.getASSOCIATEDSOURCEINSTANCE().add(asi);
//		insts.add(inst);
//
//		// ADD NODES TO MAPPING
//		map.getTRANSFORMATION().add(trns);
//		map.getTRANSFORMATION().add(filtertransformation);
//		map.getINSTANCE().addAll(insts);
//		map.getCONNECTOR().addAll(cons);
//		// MAPPING DETAILS
//		map.setISVALID("YES");
//		map.setNAME("m_FIL_"+srcTbl);
//		map.setOBJECTVERSION("1");
//		map.setVERSIONNUMBER("1");
//
//		// CONFIG
//		CONFIG config = new CONFIG();
//		config.setDESCRIPTION("Default session configuration object");
//		config.setISDEFAULT("YES");
//		config.setNAME("default_session_config");
//		config.setVERSIONNUMBER("1");
//		config.getATTRIBUTE().addAll(getConfigAttributes());
//
//
//
//		folder.getSOURCE().add(src);
//		folder.getTARGET().add(tgt);
//		folder.getMAPPING().add(map);
//		folder.getCONFIG().add(config);
//		REPOSITORY repository = new REPOSITORY("XDIPCRS","DB2","Latin1","184");
//		repository.getFOLDER().add(folder);
//
//		POWERMART powermart = new POWERMART("","");
//		powermart.getREPOSITORY().add(repository);
//
//		return powermart;
//	}
//
//	/*
//	 * 	This function creates a POWERMART-object containing a mapping
//	 * 	that just loads the targettable, without any transformations.
//	 * 
//	 * 	@param	srcTbl				The name of the source table.
//	 * 	@param	srcAlias			The alias of the source table.
//	 * 	@param	sourcefieldnames	An ArrayList of the sourcefieldnames from the source table.
//	 * 	@return						A POWERMART object containing the mapping.
//	 */
//	private static POWERMART convToSelIns(String srcTbl, String srcAlias, ArrayList<String> sourcefieldnames){
//		MAPPING map = new MAPPING();
//		FOLDER folder = new FOLDER("XDW991593" ,"Everis : Antonio Jesus, Group for Global Corporate Teaser Tool(GCT), Developer, antonio.jesus.munoz.lapaz@zurich.com" ,"NOTSHARED","w991593" ,"","rwx---r--" ,"55cd59eb-588d-4840-8dee-97c3257a4945");
//		ArrayList<SOURCEFIELD> sfs = new ArrayList<SOURCEFIELD>();
//		ArrayList<CONNECTOR> cons = new ArrayList<CONNECTOR>();
//		ArrayList<INSTANCE> insts = new ArrayList<INSTANCE>();
//		ArrayList<TARGETFIELD> tfs = new ArrayList<TARGETFIELD>();
//		ArrayList<TRANSFORMFIELD> trfs = new ArrayList<TRANSFORMFIELD>();
//		CONNECTOR con = new CONNECTOR();
//		INSTANCE inst = new INSTANCE();
//		int fieldnum = 0;
//
//		srcTbl = srcTbl.replace(".", "");
//		srcTbl = srcTbl.replace("TGT_", "");
//		srcTbl = srcTbl.replace("SRC_", "");
//		//srcTbl = srcTbl.substring(0, srcTbl.length()/2);
//		//srcAlias = srcAlias.replace(".", "");
//		//srcAlias = srcAlias.replace("TGT_", "");
//
//		// CREATING A SOURCE, SQ, TARGET AND CONNECTORS
//		SOURCE src = new SOURCE();
//		TARGET tgt = new TARGET();
//		Integer physicaloffset = 0;
//		for(String s : sourcefieldnames){
//			if(s.startsWith(srcAlias))
//				s = s.substring(srcAlias.length());
//			physicaloffset = physicaloffset +10;
//			SOURCEFIELD sf = new SOURCEFIELD(s,"","","varchar","NOT A KEY","10","0","NULL","","0","ELEMITEM","","0",Integer.toString(fieldnum*10),Integer.toString(physicaloffset),"10",Integer.toString(fieldnum),"0","NO");
//			TRANSFORMFIELD trf = new TRANSFORMFIELD(s,"string","INPUT/OUTPUT","10","0");
//			TARGETFIELD tf = new TARGETFIELD(s,"varchar","NOT A KEY","10","0","NULL",Integer.toString(fieldnum+1));
//
//			con = new CONNECTOR(s,"SRC_"+srcTbl,"Source Definition","Source Qualifier","SQ_"+ srcTbl,s);
//			cons.add(con);
//			con = new CONNECTOR(s,"SQ_"+ srcTbl,"Source Qualifier","Target Definition","TGT_"+srcTbl,s);
//			cons.add(con);
//
//			sfs.add(sf);
//			tfs.add(tf);
//			trfs.add(trf);
//
//			fieldnum ++;
//		}
//		src = new SOURCE("SRC_"+srcTbl, "DB2", "", "", "1","","DB2", "1",sfs);
//		inst = new INSTANCE("DB2","SRC_"+srcTbl,"SOURCE", "NO", "Source Definition","SRC_"+srcTbl);
//		insts.add(inst);
//
//		// TARGET DETAILS 
//		tgt = new TARGET("TGT_"+srcTbl, "1", "DB2", "1",tfs);
//		// TARGET INSTANCE
//		inst = new INSTANCE("TGT_"+srcTbl,"TARGET","NO","Target Definition","TGT_"+srcTbl);
//		insts.add(inst);
//
//		// TARGETLOADORDER
//		TARGETLOADORDER tgtlo = new TARGETLOADORDER(tgt.getNAME(),"1");
//		map.getTARGETLOADORDER().add(tgtlo);
//
//		ArrayList<TABLEATTRIBUTE> tas = new ArrayList<TABLEATTRIBUTE>();
//		TABLEATTRIBUTE tabat = new TABLEATTRIBUTE();
//
//		tas = new ArrayList<TABLEATTRIBUTE>();
//		tabat = new TABLEATTRIBUTE("Number Of Sorted Ports","0");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Tracing Level","Normal");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Is Partitionable","NO");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Output is deterministic","NO");
//		tas.add(tabat);
//
//		tabat = new TABLEATTRIBUTE("Output is repeatable","Never");
//		tas.add(tabat);
//		inst = new INSTANCE("DB2","SQ_"+srcTbl,"TRANSFORMATION", "NO", "Source Qualifier","SQ_"+srcTbl);
//
//		// SOURCE QUALIFIER
//		TRANSFORMATION trns = new TRANSFORMATION();
//		trns = new TRANSFORMATION("SQ_"+srcTbl,"Source Qualifier","1","NO","1");
//		trns.getTRANSFORMFIELD().addAll(trfs);
//		trns.getTABLEATTRIBUTE().addAll(tas);
//
//		// ASSOCIATEDSOURCEINSTANCE 
//		ASSOCIATEDSOURCEINSTANCE asi = new ASSOCIATEDSOURCEINSTANCE(src.getNAME());
//		inst.getASSOCIATEDSOURCEINSTANCE().add(asi);
//		insts.add(inst);
//
//		// ADD NODES TO MAPPING
//		map.getTRANSFORMATION().add(trns);
//		map.getINSTANCE().addAll(insts);
//		map.getCONNECTOR().addAll(cons);
//		// MAPPING DETAILS
//		map.setISVALID("YES");
//		map.setNAME("m_SelIns_"+srcTbl);
//		map.setOBJECTVERSION("1");
//		map.setVERSIONNUMBER("1");
//
//		// CONFIG
//		CONFIG config = new CONFIG();
//		config.setDESCRIPTION("Default session configuration object");
//		config.setISDEFAULT("YES");
//		config.setNAME("default_session_config");
//		config.setVERSIONNUMBER("1");
//		config.getATTRIBUTE().addAll(getConfigAttributes());
//
//
//
//		// TODO: FIND A WAY TO GET ALL THE DATA FOR THE SESSIONTRANSFORMATIONINST.
//		/*for(INSTANCE in : map.getINSTANCE()){
//					// SESSIONTRANSFORMATIONINST
//					SESSTRANSFORMATIONINST sesstr = new SESSTRANSFORMATIONINST(in.getNAME(), in.getTRANSFORMATIONNAME(), in.getTRANSFORMATIONTYPE(), "", "", "1");
//					sess.getSESSTRANSFORMATIONINST().add(sesstr);
//				}*/
//
//
//
//		folder.getSOURCE().add(src);
//		folder.getTARGET().add(tgt);
//		folder.getMAPPING().add(map);
//		folder.getCONFIG().add(config);
//
//		REPOSITORY repository = new REPOSITORY("XDIPCRS","DB2","Latin1","184");
//		repository.getFOLDER().add(folder);
//
//		POWERMART powermart = new POWERMART("","");
//		powermart.getREPOSITORY().add(repository);
//
//		return powermart;
//	}
//
//	/*
//	 * 	This function compares the given string with the list of keywords
//	 * 	at checks if it's in the list or not.
//	 * 
//	 * 	@param	s	The string to check.
//	 * 	@return		True or false depending on the check.
//	 */
//	private static boolean isKeyWord(String s){
//		Pattern p = Pattern.compile(kw);
//		Matcher m = p.matcher(s);
//
//		if(m.find())
//			return true;
//		else
//			return false;
//	}
//
//	/*
//	 * 	This function returns a list of the configurationattributes of a mapping.
//	 * 
//	 * 	@return		The attributes.
//	 */
//	private static ArrayList<ATTRIBUTE> getConfigAttributes(){
//		ArrayList<ATTRIBUTE> configattributes = new ArrayList<ATTRIBUTE>();
//		ATTRIBUTE attr = new ATTRIBUTE();
//
//		attr = new ATTRIBUTE("Advanced","");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Constraint based load ordering","NO");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Cache LOOKUP() function","YES");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Default buffer block size","Auto");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Line Sequential buffer length","1024");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Maximum Memory Allowed For Auto Memory Attributes","512MB");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Maximum Percentage of Total Memory Allowed For Auto Memory Attributes","5");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Additional Concurrent Pipelines for Lookup Cache Creation","Auto");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Custom Properties","");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Pre-build lookup cache","Auto");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Optimization Level","Medium");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("DateTime Format String","MM/DD/YYYY HH24:MI:SS.US");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Pre 85 Timestamp Compatibility","NO");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Log Options","0");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Save session log by","Session runs");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Save session log for these runs","0");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Session Log File Max Size","0");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Session Log File Max Time Period","0");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Maximum Partial Session Log Files","1");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Writer Commit Statistics Log Frequency","1");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Writer Commit Statistics Log Interval","0");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Error handling","");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Stop on errors","0");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Override tracing","None");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("On Stored Procedure error","Stop");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("On Pre-session command task error","Stop");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("On Pre-Post SQL error","Stop");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Enable Recovery","NO");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Error Log Type","None");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Error Log Table Name Prefix","");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Error Log File Name","PMError.log");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Log Source Row Data","NO");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Data Column Delimiter","|");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Partitioning Options","");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Dynamic Partitioning","Disabled");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Number of Partitions","1");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Multiplication Factor","Auto");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Session on Grid","");
//		configattributes.add(attr);
//		attr = new ATTRIBUTE("Is Enabled","NO");
//		configattributes.add(attr);
//		return configattributes;
//	}
//
//
//}







