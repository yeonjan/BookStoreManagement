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
<h1>도서 목록 조회</h1>
<table class="table">
    <thead>
      <tr>
        <th>고유번호</th>
        <th>제목</th>
        <th>저자</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${requestScope.list}">
      <tr>
        <td>${list.isbn}</td>
        <td><a href="#">${list.title}</a></td>
        <td>${list.author}</td>
        <td>${list.price}</td>
      </tr>
    </c:forEach>
  </table>
  <%@ include file="/include/footer.jsp" %>
</body>

</html>