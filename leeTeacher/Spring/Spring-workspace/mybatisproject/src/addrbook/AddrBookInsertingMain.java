package addrbook;

import java.util.List;

public class AddrBookInsertingMain {
	public static void main(String[] args) throws Exception {
		AddrBookVO vo = new AddrBookVO();
		vo.abName = "haha";
		vo.abTel = "010-10001-0100";
		vo.abBirth = "200202";
		vo.abComdept = "1111";
		boolean result = new AddrBookDAO().insertDB(vo);
		System.out.println(result);
		}
}
