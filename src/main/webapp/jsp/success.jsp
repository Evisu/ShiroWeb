<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>登录成功</title>
</head>
<body>
	欢迎${sessionScope.subject.principal}登录成功！
	<a href="${pageContext.request.contextPath}/logout">退出</a>
	<a href="${pageContext.request.contextPath}/jsp/list.jsp">操作</a>
</body>
</html>
