<%@page import="addrbook.AddrBookVO"%>
<%@page import="java.util.List"%>
<%@page import="addrbook.AddrBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//post 방식일 때 한글 깨짐을 방지
	request.setCharacterEncoding("utf-8");
%>
<!-- 주소록 작성에서 변수들을 가져오기 위해 정의한 유스빈과 setProperty
	이거를 쓰면 하나하나 변수들을 request.getParameter로 정의하지 않아도 변수들을 가져올 수 있음
	다만 VO(TO) 클래스의 변수들과 이름이 같아야됨-->
<jsp:useBean id="ab" class="addrbook.AddrBookVO"></jsp:useBean>
<jsp:setProperty property="*" name="ab"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//client의 요구(action 참조)에 따라 처리한다.
	String action = request.getParameter("action");  // action(insert or update or delete or list)을 가져오기
	String forwardPage = "addrbook_list.jsp";
	AddrBookDAO dao = new AddrBookDAO(); //dao 메서드를 사용하기 위한 객체 생성
	if("insert".equals(action)){
		dao.insertDB(ab); //객체를 통해 메서드 실행 / ab는 위의 유즈빈으로 가져온 파라미터들
		response.sendRedirect("addrbook_control.jsp?action=list"); // 등록되면서 목록페이지로 이동함 아래의 두개를 합친 것/forward와 중복됨
		//List<AddrBookVO> list = dao.getDBList();
		//request.setAttribute("data", list);
		//pageContext.forward(forwardPage);
	} else if("edit".equals(action)){
		//1.클라이언트가 전송한 데이터 중에서 방명록id를 추출
		String abIdStr = request.getParameter("ab_id");
		//2.DB에서 해당 방명록 정보를 조회
		AddrBookVO vo = dao.getDB(Integer.parseInt(abIdStr)); 
		//3.방명록 정보를 request에 넣기
		request.setAttribute("ab", vo);
		forwardPage = "addrbook_edit_form.jsp";
		pageContext.forward(forwardPage);
	} else if("list".equals(action)){
		List<AddrBookVO> list = dao.getDBList(); //리스트를 만들고
		request.setAttribute("data", list); //data라는 이름으로 list값을 넣음
		pageContext.forward(forwardPage); // 위에서는 response로 끝냈지만 여기서는 안썻기에 list.jsp로 forward 해줘야함 
		//jsp에서 꺼내서 출력한다.
	} else if("delete".equals(action)){
		String abIdStr = request.getParameter("ab_id");
		AddrBookVO vo = dao.deleteDB(Integer.parseInt(abIdStr));
		response.sendRedirect("addrbook_control.jsp?action=list");
		
	} else {
		response.sendRedirect("addrbook_control.jsp?action=list"); // action이 없어도 목록을 뜨게 함
	}
%>
<%-- <jsp:forward page="<%=forwardPage %>"></jsp:forward> --%>
</body>
</html>