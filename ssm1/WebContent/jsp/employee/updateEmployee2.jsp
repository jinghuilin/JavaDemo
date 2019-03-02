<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String basepath = request.getScheme() + "://"
					+ request.getServerName() + ":"
					+ request.getServerPort()
					+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
</head>
<body>
	<input id="success" type="hidden" value="${requestScope.success }">
	<div id="header"><%@ include file="/jsp/manager/headerManager.jsp" %></div>
	<div id="main">
		<div class="nav"><%@ include file="/jsp/manager/navManager.jsp" %></div>
		<div class="container">
			<h3>用户管理>> 分配角色</h3>
			<form id="updateEmployeeForm" action="employee.do?action=update" method="post">
				<table width="100%" border="1" cellpadding="10" cellspacing="0">
					<tbody>
				        <tr>
					    	<td>名称:</td>
					        <td>
								<input name="empId" type="hidden" value="${requestScope.employee.empId }"/>
					        	<input  readonly="readonly" name="empName" id="empName" class="input" type="text" onblur="testEmpName()" value="${requestScope.employee.empName }">
					        </td>
				        </tr>
				        <tr>
				          	<td>密码:</td>
				          	<td><input readonly="readonly" name="password" id="password" class="input" type="text" onblur="testPassword()" value="${requestScope.employee.password }"></td>
				        </tr>
				        <tr>
				          	<td>性别:</td>
							<td>
								<select onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;" name="sex">
									<option value="-1">全部</option>
									<option value="1" <c:if test="${requestScope.employee.sex eq 1 }">selected="selected"</c:if>>男</option>
									<option value="0" <c:if test="${requestScope.employee.sex eq 0 }">selected="selected"</c:if>>女</option>
								</select>
							</td>
				        </tr>
				        <tr>
				          <td>出生日期:</td>
				          <td><input  readonly="readonly" name="birthday" class="input" type="text" value='<fmt:formatDate value="${requestScope.employee.birthday}" pattern="yyyy-MM-dd"/>'></td>
				        </tr>
				        <tr>
							<td>角色:</td>
							<td>
								<select name="roleId">
									<option value="0">全部</option>
									<c:forEach items="${requestScope.roleList }" var="role">
									<option value="${role.roleId }" <c:if test="${requestScope.employee.roleId eq role.roleId }">selected="selected"</c:if>>${role.roleName }</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>状态:</td>
							<td>
								<select onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;" name="status">
									<option value="-1">全部</option>
									<option value="1" <c:if test="${requestScope.employee.status eq 1 }">selected="selected"</c:if>>正常</option>
									<option value="0" <c:if test="${requestScope.employee.status eq 0 }">selected="selected"</c:if>>禁用</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
					      		<input type="submit" value="提交" />
					      		<input type="reset" />
					     	</td> 
					  	</tr>
			     	</tbody>
				</table>
			</form>
		</div>
	</div>
	<div id="footer"></div>
	<script>
		var success = document.getElementById("success").value;
		if(success){
			alert("更新成功");
		}
</script>
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src='js/leftnav.js'></script>
</body>
</html>