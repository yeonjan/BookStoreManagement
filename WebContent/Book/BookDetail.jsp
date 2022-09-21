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
<h1>제목</h1>
<table class="table">
    <thead>
      <tr>
        <th>고유번호</th>
        <th>제목</th>
        <th>저자</th>
        <th>가격</th>
        <th>내용</th>
        <th>이미지</th>
      </tr>
    </thead>
    <tbody>
    <c:set var="book" value ="${requestScope.findBook}"></c:set>
      <tr>
        <td>${book.isbn}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
        <td>${book.price}</td>
        <td>${book.description}</td>
        <td>${book.img}</td>
      </tr>
   
  </table>
  <%@ include file="/include/footer.jsp" %>
</body>

</html>