<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户登录</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-3.2.0/css/bootstrap.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/css/bootstrap-3.2.0/js/bootstrap.js"></script>
<style>
.error {
	color: red;
}
</style>
<script type="text/javascript">

function clickCheckBox(obj,id)
{
	getById(id).value = obj.checked;
}

function getById(id)
{
	return document.getElementById(id);
}


</script>
</head>
<body>

	<div style="width: 400px; height: 200px; float: center; margin-left: 550px; margin-top: 50px;">

		<div class="page-header">
			<h1>用户登录1</h1>
		</div>

		<div class="error">${error}</div>

		<form role="form" action="<%=request.getContextPath()%>/loginServlet" method="post">
			<table>
				<tr>
					<td>用户名</td>
					<td>
						<div class="form-group">
							<input type="text" class="form-control" id="username" name="username" placeholder="输入用户名..." />
						</div>

					</td>
					<td>密码</td>
					<td>
						<div class="form-group">
							<div class="input-group">
								<input type="password" class="form-control" id="password" name="password" placeholder="输入密码..." /> 
							</div>

						</div>

					</td>

				</tr>

			</table>

			<div class="checkbox">
				<label> 
					<input id="rememberMeCheckbox" name="rememberMe" type="hidden" value="false">
					<input id="rememberMeCheckbox1" type="checkbox" name="rememberMe1" onclick="clickCheckBox(this,'rememberMeCheckbox');">
					记住我!
				</label>
			</div>
			<input type="submit" name="submit" class="btn btn-default btn-primary" value="登录" />
		</form>
	</div>


</body>
</html>
