package exception;

public class SQLQueryException extends Exception{
	public SQLQueryException() {
		super("//오류가 발생하였습니다 \n오류번호 04: 쿼리실행 오류 \nSQL 쿼리를 다시 확인해주세요//");
	}
	
	static String ifnull(String num) {
		if (num.equals("")) {
		return "//오류가 발생하였습니다 \n오류번호 02: 공백입력 오류 \n공백이 아닌 숫자를 입력해 주세요\n입력값 : ["+num+"]//\n\n";
		} else {
			return "//오류가 발생하였습니다 \n오류번호 03: 문자입력 오류 \n문자를 제외하고 숫자를 입력해 주세요\n입력값 : ["+num+"]//\n\n";
		}		
	}
}