<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="result.jsp">
    <table border="1" cellspacing="2" cellpadding="5">
        <tr>
            <th>과일 목록</th>
            <th>가격</th>
        </tr>
        <tr>
            <td><input type="checkbox" name="fruit" value="체리">체리</td>
            <td>25000</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="fruit" value="오렌지">오렌지</td>
            <td>23000</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="fruit" value="사과">사과</td>
            <td>16000</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="구입">
            </td>
        </tr>
    </table>
</form>
</body>
</html>