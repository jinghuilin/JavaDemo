<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
%>
<div>
	<p class="title">权限管理系统</p>
	<div class="loginInfo">
		<span class="p1">${sessionScope.role.roleName }:</span>
		<a class="p1" href="/">${sessionScope.loginedEmployee.empName }</a>
		<a class="p1" href="employee.do?action=logout">注销</a>
	</div>
</div>