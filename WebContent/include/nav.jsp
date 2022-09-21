<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar .navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${root}">Home</a></li>
      <li class="active"><a href="${root}/book?action=list">List</a></li>
      <li class="active"><a href="${root}/book?action=goRegist">Regist</a></li>
    </ul>
    
    
    
     <c:choose>
            <%-- session에 userInfo 객체가 없는 경우(로그인 X) --%>
            <c:when test="${empty sessionScope.userInfo}">
            <%-- userInfo는 내가 설정하는 부분 --%>
                <ul class="nav navbar-nav navbar-right">
      				<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      				<li><a href="${root}/user?action=goLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    			</ul>
            </c:when>
            <%-- 로그인 한 경우 --%>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
      				<li><a href="#"><span class="glyphicon glyphicon-user"></span> My Page</a></li>
      				<li><a href="${root}/user?action=logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    			</ul>
            </c:otherwise>
      </c:choose>
  </div>
</nav>