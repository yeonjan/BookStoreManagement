<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	<div class="container mt-3">
        <h2>로그인</h2>
        <form action="${root}/user" method="post">
        <input type ="hidden" name="action" value ="login">
            <div class="mb-3 mt-3">
                <label for="id">Id:</label> <input type="text"
                    class="form-control" id="id" placeholder="Enter id" name="id">
            </div>
            <div class="mb-3">
                <label for="pwd">Password:</label> <input type="text"
                    class="form-control" id="pwd" placeholder="Enter password"
                    name="pwd">
            </div>
            <div class="form-check mb-3">
                <label class="form-check-label"> <input
                    class="form-check-input" type="checkbox" name="remember">
                    아이디 저장하기
                </label>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <br>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>