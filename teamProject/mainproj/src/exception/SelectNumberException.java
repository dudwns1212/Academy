package exception;

public class SelectNumberException extends Exception{
	public SelectNumberException(int number) {
		super("//오류가 발생하였습니다 \n오류번호 01: 숫자입력 오류 \n범위에 맞는 숫자를 입력해 주세요\n입력값 : ["+number+"]//\n\n");
	}
}



