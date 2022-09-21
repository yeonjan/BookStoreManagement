<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload=function(){
		let deleteBtns=document.querySelectorAll(".deleteBtn");
		//console.log(deleteBtns)
		
		deleteBtns.forEach(function(el){
			//console.log(el);
			
			el.addEventListener("click",function(e){
				console.log(e);
				e.preventDefault();
				//console.log(this);
				let isbn = el.parentNode.parentNode.children[0].innerText; //el==this 
				if(confirm("선택한 도서를 삭제하시겠습니까?")){
					location.href="${root}/book?action=delete&isbn="+isbn;
				}
				
			})
			
		})
		
		
		
	}

</script>
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
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${requestScope.list}">
      <tr>
        <td>${list.isbn}</td>
        <td><a href="${root}/book?action=detail&isbn=${list.isbn}">${list.title}</a></td>
        <td>${list.author}</td>
        <td>${list.price}</td>
        <td><a class ="deleteBtn" href=""> 삭제</a></td>
      </tr>
    </c:forEach>
  </table>
  <%@ include file="/include/footer.jsp" %>
</body>

</html>