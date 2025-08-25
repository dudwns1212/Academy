package exception;

public class SQLQueryException extends Exception{
	public SQLQueryException() {
		super("//오류가 발생하였습니다 \n오류번호 05: 쿼리실행 오류 \nSQL 쿼리를 다시 확인해주세요//\n\n");
	}
}