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
        <h2>도서 등록</h2>
        <form action="${root}/book" method="post">
        <input type ="hidden" name="action" value ="regist">
            <div class="mb-3 mt-3">
                <label for="id">고유번호</label> <input type="text"
                    class="form-control" id="isbn" name="isbn">
            </div>
            <div class="mb-3 mt-3">
                <label for="id">제목</label> <input type="text"
                    class="form-control" id="title" name="title">
            </div>
            <div class="mb-3 mt-3">
                <label for="id">저자</label> <input type="text"
                    class="form-control" id="author" name="author">
            </div>
            <div class="mb-3 mt-3">
                <label for="id">가격</label> <input type="number"
                    class="form-control" id="price" name="price">
            </div>
            
            <br>
            <button type="submit" class="btn btn-primary">등록</button>
        </form>
    </div>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>