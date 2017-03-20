package corp.everis.pwc.moam;

import java.util.ArrayList;
import java.util.Stack;

import notinuse.XMLParser;

/*
 * 	This is the class that will convert a given string into SQL or Spanish.
 * 
 * 	@author		Yves Delvaulx
 * 	@version	0.1
 */
public class ShuntingYard {
	protected static boolean postfixerror = false;
	protected static boolean infixerror = false;
	protected static boolean bPrintInfix = false ;
	protected static String language = "SQL";

	public static void main(String[] args) {
		//String infix = "IIF(  LENGTH(LOCAL_CURRENCY_v) < 4,   RPAD(LOCAL_CURRENCY_v,4,' ')  ,LOCAL_CURRENCY_v)";
		//String infix = "IIF((DATE_IN_v=LAST_DAY(DATE_IN_v)) OR (DATE_IN_v<=TO_DATE(TO_CHAR(SYSDATE,'MM')  ),1,0)";
		//String infix ="(A<B)=(C>D)OR(E<=F)!=(G>=H)AND(A=B)";
		//String infix ="IIF(A||B||C = 1,D||E,F||G||H)";
		String infix = "IIF( SUBSTR(Contract_IN,1,5)='90000' AND SUBSTR(Contract_IN,-3,3)='COA' OR AssignedRep_IN='USZETX0' OR ( SUBSTR(Contract_IN,-5,1) = 'C' AND SUBSTR(Contract_IN,-3,3)='PUC' ) ,'1','0')";
		//String infix = "IIF( ((SUBSTR(Contract_IN,1,5)='90000' )AND SUBSTR(Contract_IN,-3,3)='COA' )OR AssignedRep_INOR ='USZETX0','1','0')";
		//String infix = "IIF((DATE_IN_v=LAST_DAY(DATE_IN_v))OR(DATE_IN_v<TO_DATE(TO_CHAR(SYSDATE,'MM')))OR(DATE_IN_v>=TO_DATE(TO_CHAR(SYSDATE,'MM')||'01'||TO_CHAR(SYSDATE,'YYYY'),'MMDDYYYY')),1,0)";
		//String infix = "DECODE(TRUE, AGE_BUCKET_VAR = 0, 1,AGE_BUCKET_VAR = 0 AND AGE_BUCKET_VAR =30, 2, AGE_BUCKET_VAR = 31 AND AGE_BUCKET_VAR =60, 3,  AGE_BUCKET_VAR = 61 AND AGE_BUCKET_VAR =90, 4   ,  AGE_BUCKET_VAR = 91 AND AGE_BUCKET_VAR =120, 5         ,AGE_BUCKET_VAR = 121 AND AGE_BUCKET_VAR =150, 6   ,  AGE_BUCKET_VAR = 151 AND AGE_BUCKET_VAR =180, 7   , AGE_BUCKET_VAR = 181 AND AGE_BUCKET_VAR =365, 8   , AGE_BUCKET_VAR  365, 9                                 , 0)";
		//String infix = "IIF(LENGTH(COMPLETE_ROW_V)<$$FILE_LENGTH  ,  RPAD(COMPLETE_ROW_V,$$FILE_LENGTH-1,' ')|| '|' || KEY_DATE_V  ,  SUBSTR(COMPLETE_ROW,1,$$FILE_LENGTH-1)|| '|' || KEY_DATE_V  )";
		//String infix = "IIF(DATE_COMPARE(TO_DATE(SUBSTR(Cancel_Date,0,10),'DD.MM.YYYY'),  TO_DATE(TO_CHAR(MONTH_ID) || '01','YYYYMMDD')  ) < 1,true,false)";
		try {
			switch(language){
			case "SQL":
				System.out.printf("SQL: %s%n", outfixToSQL(infixToPostfix(infix)));
				break;
			case "Spanish":
				System.out.printf("Español: %s%n", outfixToSpanish(infixToPostfix(infix)));
				break;
			}

		} catch (Exception e) {
			Main.writeError(e);
		}
	}
	public String main(String s){
		// CHECK IF WE WANT TO RETURN SQL OR ANOTHER LANGUAGE, CALLING XMLParser.getLanguage()
		// DEPENDING ON THE RETURNED VALUE WE CALL outfixToSQL OR outfixToSpanish.
		s =	s.replaceAll(" [\\s]+"," ");
		switch(XMLParser.getLanguage()){
		case "SQL" :
			return outfixToSQL(infixToPostfix(s));	
		case "Español" : 
			return outfixToSpanish(infixToPostfix(s));	
		default: 
			return outfixToSQL(infixToPostfix(s));

		}

	}
	
	/*
	 * 	This function will translate the given string to Reverse Polish Notation,
	 * 	so that it can be processed in the next function.
	 * 
	 * 	@parameter	infix	The string we want to translate to RPN.
	 * 	@return				A string containing the RPN of the input.
	 */
	
	static String infixToPostfix(String infix) {
		// TO DO THIS, WE NEED OUR STACK AND OUTPUTSTRING.
		Stack<String> s = new Stack<>();
		StringBuilder output= new StringBuilder();
		
		// IN CASE THE GIVEN STRING IS NULL, WE RETURN AN EMPTY STRING;
		if(infix == null)
			return "";
		// IN CASE THE GIVEN STRING CONTAINS "--", WE WON'T BE ABLE TO PARSE IT FOR SURE, SINCE WE DON'T KNOW
		// WHERE THE COMMENTED SECTION ENDS. IN THIS CASE WE RETURN A STATEMENT INFORMING THE USER ABOUT IT.
		if(infix.contains("--"))
			return "No se puede processar la expression " + infix;

		// WE NEED TO SPLIT THE INFIX-EXPRESSION AT EACH POWERCENTER FUNCTION.
		// TO ACHIEVE THIS WE DEFINE A STRING WITH REGULAR EXPRESSIONS THAT CONTAINS ALL OF THE POSSIBLE COMBINATIONS.
		final String ops = new String("(?<=ABORT\\()|(?=ABORT\\()|(?<=ABSF\\()|(?=ABS\\()|(?<=ADD_TO_DATE\\()|(?=ADD_TO_DATE\\()|(?<=AES_DECRRYPT\\()|(?=AES_DECRRYPT\\()|"
				+ "(?<=AES_ENCRYPT\\()|(?=AES_ENCRYPT\\()|(?<=ASCII\\()|(?=ASCII\\()|(?<=AVG\\()|(?=AVG\\()|"
				+ "(?<=CEIL\\()|(?=CEIL\\()|(?<=CHOOSE\\()|(?=CHOOSE\\()|(?<=CHR\\()|(?=CHR\\()|(?<=CHRCODE\\()|"
				+ "(?=CHRCODE\\()|(?<=COMPRESS\\()|(?=COMPRESS\\()|(?<=CONCAT\\()|(?=CONCAT\\()|(?<=CONVERT_BASE\\()|"
				+ "(?=CONVERT_BASE\\()|(?<=COS\\()|(?=COS\\()|(?<=COSH\\()|(?=COSH\\()|(?<=COUNT\\()|(?=COUNT\\()|(?<=CRC32\\()|"
				+ "(?=CRC32\\()|(?<=CUME\\()|(?=CUME\\()|(?<=DATE_COMPARE\\()|(?=DATE_COMPARE\\()|(?<=DATE_DIFF\\()|"
				+ "(?=DATE_DIFF\\()|(?<=DEC_BASE64\\()|(?=DEC_BASE64\\()|(?<=DECODE\\()|(?=DECODE\\()|(?<=DECOMPRESS\\()|"
				+ "(?=DECOMPRESS\\()|(?<=ENC_BASE64\\()|(?=ENC_BASE64\\()|(?<=ERROR\\()|(?=ERROR\\()|(?<=EXP\\()|(?=EXP\\()|"
				+ "(?<=FIRST\\()|(?=FIRST\\()|(?<=FLOOR\\()|(?=FLOOR\\()|(?<=FV\\()|(?=FV\\()|(?<=GET_DATE_PART\\()|(?=GET_DATE_PART\\()|"
				+ "(?<=GREATEST\\()|(?=GREATEST\\()|(?<=IIF\\()|(?=IIF\\()|(?<=IIF\\s\\()|(?=IIF[\\s]+\\()|(?<=[^M]IN\\()|(?=[^M]IN\\()|(?<=INDEXOF\\()|(?=INDEXOF\\()|"
				+ "(?<=INITCAP\\()|(?=INITCAP\\()|(?<=INSTR\\()|(?=INSTR\\()|(?<=ISNULL\\()|(?=ISNULL\\()|(?<=IS_DATE\\()|(?=IS_DATE\\()|"
				+ "(?<=IS_NUMBER\\()|(?=IS_NUMBER\\()|(?<=IS_SPACES\\()|(?=IS_SPACES\\()|(?<=LAST\\()|(?=LAST\\()|(?<=LAST_DAY\\()|(?=LAST_DAY\\()|"
				+ "(?<=LEAST\\()|(?=LEAST\\()|(?<=LENGTH\\()|(?=LENGTH\\()|(?<=LN\\()|(?=LN\\()|(?<=LOG\\()|(?=LOG\\()|(?<=LOOKUP\\()|(?=LOOKUP\\()|"
				+ "(?<=LOWER\\()|(?=LOWER\\()|(?<=LPAD\\()|(?=LPAD\\()|(?<=LTRIM\\()|(?=LTRIM\\()|(?<=MAKE_DATE_TIME\\()|(?=MAKE_DATE_TIME\\()|"
				+ "(?<=MAX\\()|(?=MAX\\()|(?<=MD5\\()|(?=MD5\\()|(?<=MEDIAN\\()|(?=MEDIAN\\()|(?<=MEPAHONE\\()|(?=MEPAHONE\\()|(?<=MIN\\()|"
				+ "(?=MIN\\()|(?<=MOD\\()|(?=MOD\\()|(?<=MOVINGAVG\\()|(?=MOVINGAVG\\()|(?<=MOVINGSUM\\()|(?=MOVINGSUM\\()|(?<=NPER\\()|"
				+ "(?=NPER\\()|(?<=PERCENTILE\\()|(?=PERCENTILE\\()|(?<=PMT\\()|(?=PMT\\()|(?<=POWER\\()|(?=POWER\\()|(?<=PV\\()|(?=PV\\()|"
				+ "(?<=RAND\\()|(?=RAND\\()|(?<=RATE\\()|(?=RATE\\()|(?<=REG_EXTRACT\\()|(?=REG_EXTRACT\\()|(?<=REG_MATCH\\()|(?=REG_MATCH\\()|"
				+ "(?<=REG_REPLACE\\()|(?=REG_REPLACE\\()|(?<=REPLACECHAR\\()|(?=REPLACECHAR\\()|(?<=REPLACESTR\\()|(?=REPLACESTR\\()|(?<=REVERSE\\()|"
				+ "(?=REVERSE\\()|(?<=ROUND\\()|(?=ROUND\\()|(?<=RPAD\\()|(?=RPAD\\()|(?<=RTRIM\\()|(?=RTRIM\\()|(?<=SETCOUNTVARIABLE\\()|"
				+ "(?=SETCOUNTVARIABLE\\()|(?<=SET_DATE_PART\\()|(?=SET_DATE_PART\\()|(?<=SETMAXVARIABLE\\()|(?=SETMAXVARIABLE\\()|(?<=SETMINVARIABLE\\()|"
				+ "(?=SETMINVARIABLE\\()|(?<=SETVARIABLE\\()|(?=SETVARIABLE\\()|(?<=SIGN\\()|(?=SIGN\\()|(?<=SIN\\()|(?=SIN\\()|(?<=SINH\\()|(?=SINH\\()|"
				+ "(?<=SOUNDEX\\()|(?=SOUNDEX\\()|(?<=SQRT\\()|(?=SQRT\\()|(?<=STDDEV\\()|(?=STDDEV\\()|(?<=SUBSTR\\()|(?=SUBSTR\\()|(?<=SUM\\()|"
				+ "(?=SUM\\()|(?<=SYSTIMESTAMP\\()|(?=SYSTIMESTAMP\\()|(?<=TAN\\()|(?=TAN\\()|(?<=TANH\\()|(?=TANH\\()|(?<=TO_BIGINT\\()|(?=TO_BIGINT\\()|"
				+ "(?<=TO_CHAR\\()|(?=TO_CHAR\\()|(?<=TO_DATE\\()|(?=TO_DATE\\()|(?<=TO_DECIMAL\\()|(?=TO_DECIMAL\\()|(?<=TO_FLOAT\\()|(?=TO_FLOAT\\()|"
				+ "(?<=TO_INTEGER\\()|(?=TO_INTEGER\\()|(?<=TRUNC\\()|(?=TRUNC\\()|(?<=UPPER\\()|(?=UPPER\\()|(?<=VARIANCE\\()|(?=VARIANCE\\()|"
				+ "(?<=[\\s]AND[\\s])|(?=[\\s]AND[\\s])|(?<=[\\)]*AND[\\(]*)|(?=[\\)]*AND[\\(]*)|"
				+ "(?<=[\\s]OR[\\s])|(?=[\\s]OR[\\s])|(?<=\\)OR[\\s])|(?=[\\s]OR\\()|(?=\\)OR\\()|"
				+ "(?<=NOT)|(?=NOT)|"
				+ "(?<=<=)|(?=<=)|"	  //   <=
				+ "(?<=>=)|(?=>=)|"   //   >=
				+ "(?=<)(?!=)|(?<=<)(?!=)|"     //   <
				+ "(?=>)(?!=)|(?<=>)(?!=)|"     //   >
				+ "(?<=\\!=)|(?=!=)|" //   !=
				+ "(?<=[\\s]=[\\s])|(?=[\\s]=[\\s])|" //   =
				+ "(?<=^=)|(?=^=)|(?<=<>)|(?=<>)|(?<=\\))|(?=\\))|(?<=\\|\\|)|(?=\\|\\|)|(?<=%)|(?=%)|(?<=\\,)|(?=\\,)|(?<=[:.]*\\()|"
				+ "(?<=\\+)|(?=\\+)|(?<=\"\\-\")|(?=\"\\-\")|(?<=\\*)|(?=\\*)"
				+ "|(?<=[\\d]\\.[\\d])|(?=[\\s]\\-[\\s])|(?<=[\\s]\\-[\\s])|(?=\\-[\\s])|(?<=\\-[\\s])");		
		//+ "[^\\.]{1}(?==)"
		//+ "(?==^\\w=)|(?<==)(?!\\.)|"     //   =
		//final String ops = new String("(?<=[:.]*\\()|(?<=!=)|(?=!=)|(?<=[^!]=)|(?=[^!]=)|(?<=[\\d]\\.[\\d])|(?=[\\s]\\-[\\s])|(?<=[\\s]\\-[\\s])|(?=\\-[\\s])|(?<=\\-[\\s])");
		
		infix = infix.toUpperCase();
		infix = infix.replaceAll("(?<=\\w)=", " =");
		infix = infix.replaceAll("=(?!=\\w)", "= ");
		infix = infix.replaceAll("\\)=", ") = ");
		//infix = infix.replaceAll("=(?![^\\w])", "= ");
		//infix = infix.replaceAll("=(?![^\\w])", "= ");
		/*infix = infix.replaceAll("¿", "");
		infix = infix.replaceAll("-", "\"-\"");
		infix = infix.replaceAll(" ", "");*/
		
		// CHECK IF WE WANT TO PRINT THE INFIX TO THE CONSOLE.
		if(bPrintInfix)
			System.out.printf("infix:   %s%n", infix);
		
		
		// WE SPLIT THE INFIX IN TOKENS, AND ANALYZE THEM ONE BY ONE.
		for(String token : infix.split(ops)){
			// WE TRIM THE TOKEN.
			token = token.trim();
			
			// IN CASE WE WANT TO PRINT THE TOKENS TO THE CONSOLE, WE SET THE BOOLEAN INFIXERROR TO TRUE.
			if(infixerror)
				System.out.println("OUTPUT: "+token);

			// WE CHECK IF THE TOKEN IS A POWERCENTER FUNCTION WITH THE isOps FUNCTION, OR IF IT MATCHES ONE OF THE FOLLOWING CHARS (:.*\\()
			if(isOps(token)||token.matches("(:.*\\()")){
				switch(token){
				// IN CASE IT IS A ")", WE CHECK IF THE LENGTH OF THE TOKEN ON TOP OF THE STACK ISN'T 0, 
				// AND WHILE THE TOKEN ISN'T EMPTY OR DOESN'T END WITH A "(", WE TAKE IT AND APPEND IT TO THE OUTPUTSTRING FOLLOWED BY A "¿"-CHAR.
				case ")":
					if(0<s.peek().length())
						while(!s.empty() && !s.peek().substring(s.peek().length()-1).equals("("))
							output.append(s.pop()+"¿");
					
					//  WHEN WE FOUND A TOKEN THAT ENDS WITH "(", WE WANT TO APPEND THAT ONE AS WELL.
					if(!s.empty())
						output.append(s.pop()+"¿");
					break;
				default:
					// IF THE TOKEN IS A POWERCENTER FUNCTION OR ONE OF THE CHARS DEFINED ABOVE,
					// WE CHECK IF IT'S A FUNCTION WE ALREADY KNOW HOW TO PROCESS OR NOT.
					if(resolved(token)){
						// IN CASE WE KNOW HOW TO PROCESS IT, WE CHECK IF THE TOKEN ISN'T EMPTY AND COMPARE
						// IT'S PRIORITY WITH THE TOKEN ON TOP OF THE STACK.
						while(!s.isEmpty() && !hasPriority(token,s.peek().toString())){
							// IF IT DOESN'T HAVE PRIORITY, WE APPEND IT TO THE OUTPUT.
							output.append(s.pop()+"¿");
						}
						// IF THE TOKEN ISN'T A ")" WE PUSH IT ON TOP OF THE STACK. 
						if(!token.equals(")")){
							s.push(token);
						}
						break;
					}else{
						// IN CASE WE DON'T KNOW HOW TO PROCESS THE FUNCTION YET, WE INFORM THE USER.
						return "La expressión \""+token+"\" todavía no esta procesado.";
					}
				}



			}else{
				// IN CASE IT'S NOT A FUNCTION, AND IT'S NOT A WHITESPACE OR NOTHING, 
				// WE CAN ASSUME IT'S A VARIABLE, AND APPEND IT TO THE OUTPUTSTRING.
				if(!token.equals(" ") && !token.equals(""))
					output.append(token+"¿");
			}
		}
		
		// AT THIS POINT WE SPLITTED THE WHOLE INFIX. IN CASE THERE ARE STILL TOKENS IN THE STACK, 
		// WE START PUSHING THEM TO THE OUTPUT, LAST IN FIRST OUT.
		while(!s.isEmpty()){
			if(!")".equals(s.peek()))
				output.append(s.pop()+"¿");
			else
				s.pop();
		}

		// WE RETURN OUR INFIX WRITTEN IN REVERSE POLISH NOTATION.
		return output.toString();
	}

	/*
	 * 	This function compares two strings of keywords and check
	 * 	which keyword has priority on the other one.
	 * 	
	 * 	@param	in1	The first string.
	 * 	@param	in2	The second string.
	 * 	@return		True or false, depending on if the string has priority or no.
	 */
	
	private static boolean hasPriority(String in1,String in2){
		// THIS FUNCTION CHECKS WHICH TOKEN/FUNCTION HAS PRIORITY, 
		// BY CALLING THE getValue FUNCTION THAT RETURNS THE VALUE
		// OF THE GIVEN TOKEN, AND COMPARING IT AFTERWARDS.
		Integer i1 = getValue(in1);
		Integer i2 = getValue(in2);

		if(i1 == 1)
			if(i1 > i2)
				return true;
			else
				return false;
		else
			if(i1 >= i2)
				return true;
			else
				return false;
	}

	/*
	 * 	This function translates RPN to SQL.
	 * 
	 * 	@param	postfix	The RPN we want to translate to SQL.
	 * 	@return			The SQL generated from the RPN.
	 */
	
	private static String outfixToSQL(String postfix){
		// THIS FUNCTION WRITES THE REVERSE POLISH NOTATION OF THE EXPRESSION IN SQL.
		String readable = new String();
		String temp = new String();
		int index = 0;
		int pos1 = 0;
		int pos2 = 0;
		Stack<String> s = new Stack<>();
		
		// WE CHECK IF THE POSTFIX/RPN NOTATION ISN'T NULL OR DOESN'T CONTAINS "--" LIKE BEFORE.
		if(postfix == null)
			return "";
		if(postfix.contains("--"))
			return postfix;

		// WE SPLIT THE POSTFIX WITH THE "¿"-CHAR.
		for(String token : postfix.split("¿")){
			// IN CASE WE WANT TO DEBUG AND PRINT EACH TOKEN, WE SET THE BOOLEAN postfixerror TO TRUE ON TOP.
			if(postfixerror)
				System.out.println(token + "                            "+s.toString());

			temp ="";
			// DEPENDING ON THE VALUE OF THE TOKEN, WE CHECK HOW TO TRANSLATE IT.
			
			// FOR EXAMPLE:
			// INFIX   = "IIF(A+B=C,1,3)"
			// POSTFIX = " A ¿ B ¿ C ¿ 1 ¿ 3 ¿ , ¿ , ¿ = ¿ + ¿ IIF( "
			// WE PROCESS THE FIRST TOKEN A. IT'S A VARIABLE, SO WE PUSH IT TO OUR STACK
			// A
			// THE NEXT TOKEN IS ALSO A VARIABLE, AND WE PUSH IT TO THE STACK AS WELL.
			// A | B
			// THE FOLLOWING THREE TOKENS AS WELL.
			// A | B | C
			// A | B | C | 1
			// A | B | C | 1 | 3
			// THE NEXT TOKEN IS A COMMA, SO WE TAKE THE COMMA, CONCATENATE IT WITH THE TOKEN ON TOP OF OUR STACK,
			// ,3
			// AND CONCATENATE THIS WITH THE TOKEN ON TOP OF THE STACK AS WELL.
			// A | B | C | 1,3
			// OUR NEXT TOKEN IS ANOTHER COMMA, SO WE DO THE SAME:
			// A | B | C,1,3
			// THE NEXT TOKEN IS A = SIGN, WHICH DOES THE SAME:
			// A | B=C,1,3
			// JUST LIKE THE +
			// A+B=C,1,3
			// THE NEXT ONE IS TRICKIER: WE HAVE TO CONVERT THE IIF( TO A CASE WHEN IN SQL.
			// WE DO THIS BY COUNTING LOOKING FOR THE COMMA'S IN THE VARIABLE ON TOP OF THE STACK, THAT AREN'T BETWEEN PARENTHESISES.
			// WE CHECK CHAR BY CHAR, IF IT'S A "(", WE COUNT IT. WHEN IT'S A ")", WE DISCOUNT IT FROM THE PREVIOUS INTEGER. 
			// IF IT'S A "," AND THE PREVIOUS INTEGER = 0, WE KEEP IT'S POSITION AND LOOK FOR THE SECOND COMMA. WHEN WE HAVE THE SECOND
			// COMMA AS WELL, WE KNOW THE WHAT THE DIFFERENT PART'S OF OUR CASE WHEN STATEMENT ARE, AND IN OUR CASE WE CAN CONVERT IT TO:
			// CASE WHEN A+B=C THEN 1 ELSE 3 END
			// IN THIS CASE IT SEEMS WAY TOO COMPLICATED, BUT IN CASE OUR TOKEN IS SOMETHING LIKE THIS
			// A+B=(C*D=SUBSTRING(E,1,1)),TO_CHAR(VAR),3
			// WE STILL NEED TO BE ABLE TO DIFFERENTIATE THE COMMA'S FROM OUR IIF STATEMENT AND OUR SUBSTRING.
			if(!isOps(token) && !token.matches("(:.*\\()")){
				s.push(token);
			}else{
				switch(token){
				case "AND":
					temp = s.pop();
					s.push(s.pop()+" AND "+ temp);
					break;
				case "OR":
					temp = s.pop();
					s.push(s.pop()+" OR "+ temp);
					break;
				case "!=":
					temp = s.pop();
					s.push(s.pop()+" != "+ temp);
					break;
				case "ISNULL(":
					s.push(" ISNULL(" + s.pop() +")");
					break;
				case "LAST_DAY(":
					s.push(" LAST_DAY(" + s.pop() +")");
					break;
				case "LENGTH(":
					s.push(" LENGTH(" + s.pop() +")");
					break;
				case "LTRIM(":
					s.push(" LTRIM(" + s.pop() +")");
					break;
				case "LPAD(":
					s.push(" LPAD(" + s.pop() +")");
					break;
				case "RAND(":
					s.push(" RAND()");
					break;
				case "RTRIM(":
					s.push(" RTRIM(" + s.pop() +")");
					break;
				case "RPAD(":
					s.push(" RPAD(" + s.pop() +")");
					break;
				case "NOT":
					s.push(token +s.pop());
					break;
				case "-":
					temp = s.pop();
					s.push(s.pop()+" MINUS "+ temp);
					break;
				case "+":
					temp = s.pop();
					s.push(s.pop()+" SUM "+ temp);
					break;
				case "*":
					temp = s.pop();
					s.push(s.pop()+" * "+ temp);
					break;
				case "=":
					temp = s.pop();
					s.push(s.pop()+" = "+ temp);
					break;
				case "<=":
					temp = s.pop();
					s.push(s.pop()+" <= "+ temp);
					break;
				case ">=":
					temp = s.pop();
					s.push(s.pop()+" >= "+ temp);
					break;
				case "<":
					temp = s.pop();
					s.push(s.pop()+" < "+ temp);
					break;
				case ">":
					temp = s.pop();
					s.push(s.pop()+" > "+ temp);
					break;
				case "||":
					temp = s.pop();
					if(12<temp.length() && temp.substring(0, 12).equals("CONCATENATE("))
						temp = temp.substring(12, temp.lastIndexOf(")"));
					s.push("CONCATENATE("+s.pop()+","+ temp+") ");
					break;
				case ",":
					temp = ","+s.pop();
					s.push(s.pop()+temp);
					break;
				case "(":
					temp = "("+s.pop()+") ";
					s.push(temp);
					break;
				case "IIF(":
					index = 0;
					pos1 = 0;
					pos2 = 0;
					for(int i = 0 ; i< s.peek().length() ; i++)
						switch (s.peek().charAt(i)){
						case '(' :
							index ++;
							break;
						case ')' :
							index --;
							break;
						case ',' :
							if(pos1==0 && index == 0)
								pos1 = i;
							else if(index == 0)
								pos2 = i;
							break;
						}
					if(pos1<pos2){
						temp = " CASE WHEN("+s.peek().substring(0,pos1) + " THEN " + s.peek().substring(pos1+1,pos2) + " ELSE " + s.peek().substring(pos2+1,s.peek().length())+ ") END";
					}
					s.pop();
					s.push(temp);
					break;
				case "TO_CHAR(":
					switch(s.get(s.size()-1)){
					case ",":
						//DATE
						s.push(s.pop()+s.pop()+"'"+s.pop());
						break;
					default:
						//NUMERIC
						s.push(s.pop());
						break;
					}
					s.push("TO_CHAR(" + s.pop() +")");
					break;
				case "TO_DATE(":
					s.push("TO_DATE(" + s.pop() +")");
					break;
				case "DECODE(":
					index = 0;
					pos1 = 0;
					pos2 = 0;
					boolean pair = true;
					boolean firstrun = true;
					String compare = "";
					temp =" CASE (";
					for(int i = 0 ; i< s.peek().length() ; i++)
						switch (s.peek().charAt(i)){
						case '(' :
							index ++;
							break;
						case ')' :
							index --;
							break;
						case ',' :
							if(index==0){
								//FIRSTRUN
								if(firstrun){
									pos2 = i;
									compare = s.peek().substring(0,i);
									pos1 = pos2 +1;
								}
								if(pair && !firstrun){
									pos2 = i;
									temp = temp +"WHEN "+compare+" = (" + s.peek().substring(pos1,pos2) + ") THEN ";
									pos1 = pos2 +1;
									pair = false;
								}else if(!firstrun){
									pos2 = i;
									temp = temp +s.peek().substring(pos1,pos2)+", ";
									pos1 = pos2 +1;
									pair = true;
								}
								firstrun = false;
							}
							break;
						}
					temp = temp + ") END AS";
					s.pop();
					s.push(temp);
					break;
				case "DATE_COMPARE(":
					switch(s.get(s.size()-1)){
					case ",":
						//DATE
						s.push("DATE_COMPARE(" + s.pop()+"'"+s.pop()+"') ");
						break;
					default:
						//NUMERIC
						s.push("DATE_COMPARE("+s.pop()+") ");
						break;
					}
					break;
				case "SUBSTR(":
					s.push(" SUBSTRING("+s.pop()+") ");
					break;
				case "MIN(":
					s.push("MIN("+s.pop()+") ");
					break;
				case "MAX(":
					s.push("MAX("+s.pop()+") ");
					break;
				case "ROUND(":
					s.push("ROUND("+s.pop()+") ");
					break;
				case "SYSTIMESTAMP(":
					s.push("SYSTIMESTAMP()");
					break;
				default:
					if(token.matches("(:.*\\()")){
						s.push(token+s.pop()+") ");
					}else
						s.push(token);
					break;
				}
			}
		}
		// WHEN WE PROCESSED THE WHOLE POSTFIX, WE EMPTY THE STACK APPENDING IT TO A STRING AND RETURN IT.
		for(String fin : s){
			readable =  readable+fin;
		}
		readable.replace("--,--", ",");
		return readable;
	}

	/*
	 * 	This function translates the RPN to Spanish.
	 * 
	 * 	@param	postfix	The RPN we want to translate to Spanish.
	 * 	@return			The phrase describing the mapping in Spanish.
	 */
	
	private static String outfixToSpanish(String postfix){
		String readable = new String();
		String temp = new String();
		int index = 0;
		int pos1 = 0;
		int pos2 = 0;

		Stack<String> s = new Stack<>();
		if(postfix.contains("--"))
			return postfix;

		for(String token : postfix.split("¿")){
			if(postfixerror)
				System.out.println(token + "                            "+s.toString());

			temp ="";
			if(!isOps(token) && !token.matches("(:.*\\()")){
				s.push(token);
			}else{
				switch(token){
				case "AND":
					temp = s.pop();
					s.push(s.pop()+" y "+ temp+", ");
					break;
				case "OR":
					temp = s.pop();
					s.push(s.pop()+" o "+ temp+" ");
					break;
				case "!=":
					temp = s.pop();
					s.push(s.pop()+" no es igual a "+ temp+" ");
					break;
				case "ISNULL(":
					s.push( " que " + s.pop() +" sea igual a null, ");
					break;
				case "LAST_DAY(":
					s.push(" el ultimo dia de " + s.pop()+" ");
					break;
				case "LENGTH(":
					s.push(" la longitud de " + s.pop()+" " );
					break;
				case "LTRIM(":
					s.push(s.pop() +" de cual hemos quitado todo los espacios vacios a la izquierda y ");
					break;
				case "LPAD(":
					index = 0;
					pos1 = 0;
					pos2 = 0;
					for(int i = 0 ; i< s.peek().length() ; i++)
						switch (s.peek().charAt(i)){
						case '(' :
							index ++;
							break;
						case ')' :
							index --;
							break;
						case ',' :
							if(pos1==0 && index == 0)
								pos1 = i;
							else if(index == 0)
								pos2 = i;
							break;
						}
					temp = "el campo " + s.peek().substring(0,pos1)+", de cual quitamos "+s.peek().substring(pos1+1,pos2) + " veces el character " + s.peek().substring(pos2+1,s.peek().length()) + " a la izquierda ";
					s.pop();
					s.push(temp);
					break;
				case "RAND(":
					s.push(" un numero aleatorio ");
					break;
				case "RTRIM(":
					s.push(s.pop() +" de cual hemos quitado todo los espacios vacios a la derecha  ");
					break;
				case "RPAD(":
					index = 0;
					pos1 = 0;
					pos2 = 0;
					for(int i = 0 ; i< s.peek().length() ; i++)
						switch (s.peek().charAt(i)){
						case '(' :
							index ++;
							break;
						case ')' :
							index --;
							break;
						case ',' :
							if(pos1==0 && index == 0)
								pos1 = i;
							else if(index == 0)
								pos2 = i;
							break;
						}
					temp = "el campo " + s.peek().substring(0,pos1)+", de cual quitamos "+s.peek().substring(pos1+1,pos2) + " veces el character " + s.peek().substring(pos2+1,s.peek().length()) + " a la derecha ";
					s.pop();
					s.push(temp);
					break;
				case "NOT":
					s.push(" no " + s.pop());
					break;
				case "-":
					temp = s.pop();
					s.push(s.pop()+" menos "+ temp+" ");
					break;
				case "+":
					temp = s.pop();
					s.push(s.pop()+" sumado con "+ temp+" ");
					break;
				case "*":
					temp = s.pop();
					s.push(s.pop()+" veces "+ temp+" ");
					break;
				case "=":
					temp = s.pop();
					s.push(s.pop()+" sea igual a "+ temp+" ");
					break;
				case "<=":
					temp = s.pop();
					s.push(s.pop()+" sea menor o igual a "+ temp+" ");
					break;
				case ">=":
					temp = s.pop();
					s.push(s.pop()+" sea mayor o igual a "+ temp+" ");
					break;
				case "<":
					temp = s.pop();
					s.push(temp +" sea menor que "+ s.pop()+" ");
					break;
				case ">":
					temp = s.pop();
					s.push(s.pop()+" sea mayor que "+ temp +" ");
					break;
				case "||":
					temp = s.pop();
					if(17<temp.length() && temp.substring(0, 17).equals(" concatenado con "))
						temp = temp.substring(12, temp.lastIndexOf(" y "));
					s.push(" concatenado con "+s.pop()+","+ temp+" y ");
					break;
				case ",":
					temp = ","+s.pop();
					s.push(s.pop()+temp);
					break;
				case "(":
					// NO HACEMOS NADA
					break;
				case "IIF(":
					index = 0;
					pos1 = 0;
					pos2 = 0;
					for(int i = 0 ; i< s.peek().length() ; i++)
						switch (s.peek().charAt(i)){
						case '(' :
							index ++;
							break;
						case ')' :
							index --;
							break;
						case ',' :
							if(pos1==0 && index == 0)
								pos1 = i;
							else if(index == 0)
								pos2 = i;
							break;
						}
					temp = " en el caso  que "+s.peek().substring(0,pos1) + " utilizaremos el valor " + s.peek().substring(pos1+1,pos2) + ". Si no utilizaremos el valor " + s.peek().substring(pos2+1,s.peek().length())+ ". ";
					s.pop();
					s.push(temp);
					break;
				case "TO_CHAR(":
					switch(s.get(s.size()-1)){
					case ",":
						//DATE
						s.push(s.pop()+s.pop()+"'"+s.pop());
						break;
					default:
						//NUMERIC
						s.push(s.pop());
						break;
					}
					s.push(" tenemos que convertir " + s.pop() +" a (un) character(es) alfanumerico(s) y ");
					break;
				case "TO_DATE(":
					s.push(" convertiremos " + s.pop() + " a una fecha y ");
					break;
				case "DECODE(":
					index = 0;
					pos1 = 0;
					pos2 = 0;
					boolean pair = true;
					boolean firstrun = true;
					String compare = "";
					temp =" en el caso que ";
					for(int i = 0 ; i< s.peek().length() ; i++)
						switch (s.peek().charAt(i)){
						case '(' :
							index ++;
							break;
						case ')' :
							index --;
							break;
						case ',' :
							if(index==0){
								//FIRSTRUN
								if(firstrun){
									pos2 = i;
									compare = s.peek().substring(0,i);
									pos1 = pos2 +1;
								}
								if(pair && !firstrun){
									pos2 = i;
									temp = temp +" cuando "+compare+" sea " + s.peek().substring(pos1,pos2) + " utilizaremos el valor ";
									pos1 = pos2 +1;
									pair = false;
								}else if(!firstrun){
									pos2 = i;
									temp = temp +s.peek().substring(pos1,pos2)+", ";
									pos1 = pos2 +1;
									pair = true;
								}
								firstrun = false;
							}
							break;
						}
					temp = temp + "; ";
					s.pop();
					s.push(temp);
					break;
				case "DATE_COMPARE(":
					switch(s.get(s.size()-1)){
					case ",":
						//DATE
						s.push(" comparamos la fecha " + s.pop()+" en el formato '"+s.pop()+"' con ");
						break;
					default:
						//NUMERIC
						s.push(" comparamos la fecha "+s.pop()+" con ");
						break;
					}
					break;
				case "SUBSTR(":
					s.push(" la parte de "+s.pop()+" empezando en posición ");
					break;
				case "MIN(":
					s.push(" el mínimo de "+s.pop()+" y ");
					break;
				case "MAX(":
					s.push(" el máximo de "+s.pop()+" y ");
					break;
				case "ROUND(":
					s.push(s.pop()+" redondeado a ");
					break;
				case "SYSTIMESTAMP(":
					s.push(" la fecha del sístema ");
					break;
				default:
					if(token.matches("(:.*\\()")){
						s.push(token+s.pop()+") ");
					}else
						s.push(token);
					break;
				}
			}
		}

		for(String fin : s){
			readable =  readable+fin;
		}
		readable.replace("--,--", ",");
		return readable;
	}
	
	/*
	 * 	This function checks if a given string is a keyword or not.
	 * 
	 * 	@param	s	The string we want to check.
	 * 	@return		True or false, depending on if it's a keyword or not.
	 */
	
	private static boolean isOps(String s){
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("ABORT(");
		ops.add("ABS(");
		ops.add("ADD_TO_DATE(");
		ops.add("AES_DECRRYPT(");
		ops.add("AES_ENCRYPT(");
		ops.add("ASCII(");
		ops.add("AVG(");
		ops.add("CEIL(");
		ops.add("CHOOSE(");
		ops.add("CHR(");
		ops.add("CHRCODE(");
		ops.add("COMPRESS(");
		ops.add("CONCAT(");
		ops.add("CONVERT_BASE(");
		ops.add("COS(");
		ops.add("COSH(");
		ops.add("COUNT(");
		ops.add("CRC32(");
		ops.add("CUME(");
		ops.add("DATE_COMPARE(");
		ops.add("DATE_DIFF(");
		ops.add("DEC_BASE64(");
		ops.add("DECODE(");
		ops.add("DECOMPRESS(");
		ops.add("ENC_BASE64(");
		ops.add("ERROR(");
		ops.add("EXP(");
		ops.add("FIRST(");
		ops.add("FLOOR(");
		ops.add("FV(");
		ops.add("GET_DATE_PART(");
		ops.add("GREATEST(");
		ops.add("IIF(");
		ops.add("IN(");
		ops.add("INDEXOF(");
		ops.add("INITCAP(");
		ops.add("INSTR(");
		ops.add("ISNULL(");
		ops.add("IS_DATE(");
		ops.add("IS_NUMBER(");
		ops.add("IS_SPACES(");
		ops.add("LAST(");
		ops.add("LAST_DAY(");
		ops.add("LEAST(");
		ops.add("LENGTH(");
		ops.add("LN(");
		ops.add("LOG(");
		ops.add("LOOKUP(");
		ops.add(":LKP(");
		ops.add("LOWER(");
		ops.add("LPAD(");
		ops.add("LTRIM(");
		ops.add("MAKE_DATE_TIME(");
		ops.add("MAX(");
		ops.add("MD5(");
		ops.add("MEDIAN(");
		ops.add("MEPAHONE(");
		ops.add("MIN(");
		ops.add("MOD(");
		ops.add("MOVINGAVG(");
		ops.add("MOVINGSUM(");
		ops.add("NPER(");
		ops.add("PERCENTILE(");
		ops.add("PMT(");
		ops.add("POWER(");
		ops.add("PV(");
		ops.add("RAND(");
		ops.add("RATE(");
		ops.add("REG_EXTRACT(");
		ops.add("REG_MATCH(");
		ops.add("REG_REPLACE(");
		ops.add("REPLACECHAR(");
		ops.add("REPLACESTR(");
		ops.add("REVERSE(");
		ops.add("ROUND(");
		ops.add("RPAD(");
		ops.add("RTRIM(");
		ops.add("SETCOUNTVARIABLE(");
		ops.add("SET_DATE_PART(");
		ops.add("SETMAXVARIABLE(");
		ops.add("SETMINVARIABLE(");
		ops.add("SETVARIABLE(");
		ops.add("SIGN(");
		ops.add("SIN(");
		ops.add("SINH(");
		ops.add("SOUNDEX(");
		ops.add("SQRT(");
		ops.add("STDDEV(");
		ops.add("SUBSTR(");
		ops.add("SUM(");
		ops.add("SYSTIMESTAMP(");
		ops.add("TAN(");
		ops.add("TANH(");
		ops.add("TO_BIGINT(");
		ops.add("TO_CHAR(");
		ops.add("TO_DATE(");
		ops.add("TO_DECIMAL(");
		ops.add("TO_FLOAT(");
		ops.add("TO_INTEGER(");
		ops.add("TRUNC(");
		ops.add("UPPER(");
		ops.add("VARIANCE(");
		ops.add("AND");
		ops.add("OR");
		ops.add("NOT");
		ops.add(",");
		ops.add("+");
		ops.add("-");
		ops.add("*");
		ops.add("/");
		ops.add("<");
		ops.add(">");
		ops.add("<=");
		ops.add(">=");
		ops.add("^=");
		ops.add("=");
		ops.add("<>");
		ops.add("!=");
		ops.add("(");
		ops.add(")");
		ops.add("||");
		ops.add("%");
		ops.add(":");


		if(ops.contains(s))
			return true;
		else
			return false;
	}
	
	/*
	 * 	This function returns a value for a given string. These
	 * 	values are used to determine the priority between each keyword.
	 * 
	 * 	@param	token	The string we want to get it's value of.
	 * 	@return			An integer representing the value of the given string.
	 */
	
	private static Integer getValue(String token){
		int i1 = 0;
		switch(token){
		case "ABORT(" :
			i1 = 1;
			break;
		case "ABS(" :
			i1 = 1;
			break;
		case "ADD_TO_DATE(" :
			i1 = 1;
			break;
		case "AES_DECRRYPT(" :
			i1 = 1;
			break;
		case "AES_ENCRYPT(" :
			i1 = 1;
			break;
		case "ASCII(" :
			i1 = 1;
			break;
		case "AVG(" :
			i1 = 1;
			break;
		case "CEIL(" :
			i1 = 1;
			break;
		case "CHOOSE(" :
			i1 = 1;
			break;
		case "CHR(" :
			i1 = 1;
			break;
		case "CHRCODE(" :
			i1 = 1;
			break;
		case "COMPRESS(" :
			i1 = 1;
			break;
		case "CONCAT(" :
			i1 = 4;
			break;
		case "CONVERT_BASE(" :
			i1 = 1;
			break;
		case "COS(" :
			i1 = 1;
			break;
		case "COSH(" :
			i1 = 1;
			break;
		case "COUNT(" :
			i1 = 1;
			break;
		case "CRC32(" :
			i1 = 1;
			break;
		case "CUME(" :
			i1 = 1;
			break;
		case "DATE_COMPARE(" :
			i1 = 4;
			break;
		case "DATE_DIFF(" :
			i1 = 1;
			break;
		case "DEC_BASE64(" :
			i1 = 1;
			break;
		case "DECODE(" :
			i1 = 4;
			break;
		case "DECOMPRESS(" :
			i1 = 1;
			break;
		case "ENC_BASE64(" :
			i1 = 1;
			break;
		case "ERROR(" :
			i1 = 1;
			break;
		case "EXP(" :
			i1 = 1;
			break;
		case "FIRST(" :
			i1 = 1;
			break;
		case "FLOOR(" :
			i1 = 1;
			break;
		case "FV(" :
			i1 = 1;
			break;
		case "GET_DATE_PART(" :
			i1 = 1;
			break;
		case "GREATEST(" :
			i1 = 1;
			break;
		case "IIF(" :
			i1 = 4;
			break;
		case "IN(" :
			i1 = 1;
			break;
		case "INDEXOF(" :
			i1 = 1;
			break;
		case "INITCAP(" :
			i1 = 1;
			break;
		case "INSTR(" :
			i1 = 1;
			break;
		case "ISNULL(" :
			i1 = 4;
			break;
		case "IS_DATE(" :
			i1 = 1;
			break;
		case "IS_NUMBER(" :
			i1 = 1;
			break;
		case "IS_SPACES(" :
			i1 = 1;
			break;
		case "LAST(" :
			i1 = 1;
			break;
		case "LAST_DAY(" :
			i1 = 4;
			break;
		case "LEAST(" :
			i1 = 1;
			break;
		case "LENGTH(" :
			i1 = 4;
			break;
		case "LN(" :
			i1 = 1;
			break;
		case "LOG(" :
			i1 = 1;
			break;
		case "LOOKUP(" :
			i1 = 1;
			break;
		case ":LKP(" :
			i1 = 1;
			break;
		case "LOWER(" :
			i1 = 1;
			break;
		case "LPAD(" :
			i1 = 4;
			break;
		case "LTRIM(" :
			i1 = 4;
			break;
		case "MAKE_DATE_TIME(" :
			i1 = 1;
			break;
		case "MAX(" :
			i1 = 4;
			break;
		case "MD5(" :
			i1 = 1;
			break;
		case "MEDIAN(" :
			i1 = 1;
			break;
		case "MEPAHONE(" :
			i1 = 1;
			break;
		case "MIN(" :
			i1 = 4;
			break;
		case "MOD(" :
			i1 = 1;
			break;
		case "MOVINGAVG(" :
			i1 = 1;
			break;
		case "MOVINGSUM(" :
			i1 = 1;
			break;
		case "NPER(" :
			i1 = 1;
			break;
		case "PERCENTILE(" :
			i1 = 1;
			break;
		case "PMT(" :
			i1 = 1;
			break;
		case "POWER(" :
			i1 = 1;
			break;
		case "PV(" :
			i1 = 1;
			break;
		case "RAND(" :
			i1 = 4;
			break;
		case "RATE(" :
			i1 = 1;
			break;
		case "REG_EXTRACT(" :
			i1 = 1;
			break;
		case "REG_MATCH(" :
			i1 = 1;
			break;
		case "REG_REPLACE(" :
			i1 = 1;
			break;
		case "REPLACECHAR(" :
			i1 = 1;
			break;
		case "REPLACESTR(" :
			i1 = 1;
			break;
		case "REVERSE(" :
			i1 = 1;
			break;
		case "ROUND(" :
			i1 = 4;
			break;
		case "RPAD(" :
			i1 = 4;
			break;
		case "RTRIM(" :
			i1 = 4;
			break;
		case "SETCOUNTVARIABLE(" :
			i1 = 1;
			break;
		case "SET_DATE_PART(" :
			i1 = 1;
			break;
		case "SETMAXVARIABLE(" :
			i1 = 1;
			break;
		case "SETMINVARIABLE(" :
			i1 = 1;
			break;
		case "SETVARIABLE(" :
			i1 = 1;
			break;
		case "SIGN(" :
			i1 = 1;
			break;
		case "SIN(" :
			i1 = 1;
			break;
		case "SINH(" :
			i1 = 1;
			break;
		case "SOUNDEX(" :
			i1 = 1;
			break;
		case "SQRT(" :
			i1 = 1;
			break;
		case "STDDEV(" :
			i1 = 1;
			break;
		case "SUBSTR(" :
			i1 = 4;
			break;
		case "SUM(" :
			i1 = 1;
			break;
		case "SYSTIMESTAMP(" :
			i1 = 1;
			break;
		case "TAN(" :
			i1 = 1;
			break;
		case "TANH(" :
			i1 = 1;
			break;
		case "TO_BIGINT(" :
			i1 = 1;
			break;
		case "TO_CHAR(" :
			i1 = 4;
			break;
		case "TO_DATE(" :
			i1 = 4;
			break;
		case "TO_DECIMAL(" :
			i1 = 1;
			break;
		case "TO_FLOAT(" :
			i1 = 1;
			break;
		case "TO_INTEGER(" :
			i1 = 1;
			break;
		case "TRUNC(" :
			i1 = 1;
			break;
		case "UPPER(" :
			i1 = 1;
			break;
		case "VARIANCE(" :
			i1 = 1;
			break;
		case "AND" :
			i1 = 4;
			break;
		case "OR" :
			i1 = 4;
			break;
		case "NOT" :
			i1 = 4;
			break;
		case "," :
			i1 = 4;
			break;
		case "+" :
			i1 = 4;
			break;
		case "\"-\"" :
			i1 = 4;
			break;
		case "*" :
			i1 = 5;
			break;
		case "/" :
			i1 = 5;
			break;
		case "<" :
			i1 = 4;
			break;
		case ">" :
			i1 = 4;
			break;
		case "<=" :
			i1 = 4;
			break;
		case ">=" :
			i1 = 4;
			break;
		case "^=" :
			i1 = 4;
			break;
		case "=" :
			i1 = 5;
			break;
		case "<>" :
			i1 = 3;
			break;
		case "!=" :
			i1 = 5;
			break;
		case "(" :
			i1 = 4;
			break;
		case ")" :
			i1 = 1;
			break;
		case "||" :
			i1 = 5;
			break;
		case "%" :
			i1 = 1;
			break;
		default : 
			if(token.matches("(:.*\\()")){
				i1 =4;
			}else 
				i1 = 1;
			break;
		}
		return i1;
	}

	
	/*
	 * 	This function returns true or false depending on
	 * 	if the function/keyword has been implemented yet or not.
	 * 
	 * 	@param	s	The string we want to check.
	 * 	@return		True if it's implemented already, false if not.
	 */
	
	private static boolean resolved(String s){
		ArrayList<String> ops = new ArrayList<String>();
		ops.add("AND");
		ops.add("OR");
		ops.add("!=");
		ops.add("ISNULL(");
		ops.add("LAST_DAY(");
		ops.add("LENGTH(");
		ops.add("LTRIM(");
		ops.add("LPAD(");
		ops.add("RTRIM(");
		ops.add("RPAD(");
		ops.add("NOT");
		ops.add("-");
		ops.add("+");
		ops.add("*");
		ops.add("=");
		ops.add("<=");
		ops.add(">=");
		ops.add("<");
		ops.add(">");
		ops.add("||");
		ops.add(",");
		ops.add("(");
		ops.add("IIF(");
		ops.add("TO_CHAR(");
		ops.add("TO_DATE(");
		ops.add("DECODE(");
		ops.add("DATE_COMPARE(");
		ops.add("SUBSTR(");
		ops.add("MIN(");
		ops.add("MAX(");
		ops.add("ROUND(");
		ops.add("SYSTIMESTAMP(");
		ops.add("RAND(");


		if(ops.contains(s))
			return true;
		else
			return false;	}


}