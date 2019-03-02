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
<title>Insert rights</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
</head>
<body>
	<input id="success" type="hidden" value="${requestScope.success }">
	<div id="header"><%@ include file="/jsp/manager/headerManager.jsp" %></div>
	<div id="main">
		<div class="nav"><%@ include file="/jsp/manager/navManager.jsp" %></div>
		<div class="container">
			<h3>权限管理>> 创建二级权限</h3>
			<form id="updateEmployeeForm" action="right.do?action=insert" method="post">
				<table width="100%" border="1" cellpadding="10" cellspacing="0">
					<tbody>
				        <tr>
					    	<td>权限名称:</td>
					        <td>
					        	<input name="rightName" id="rightName" class="input" type="text" value="${requestScope.right.rightName }">
					        </td>
				        </tr>
				        <tr>
				          	<td>权限描述:</td>
				          	<td><input name="rightDesc" id="rightDesc" class="input" type="text" value="${requestScope.right.rightDesc }"></td>
				        </tr>
				        <tr>
				          	<td>父权限:</td>
							<td>
								<select name="parentId">
									<option value="-1">全部</option>
									<c:forEach items="${requestScope.rightList }" var="r1">
										<c:if test="${r1.parentId eq 0 }">
										<option value="${r1.rightId }">${r1.rightName }</option>
										</c:if>
									</c:forEach>
								</select>
							</td>
				        </tr>
				        <tr>
				          	<td>权限url:</td>
							<td>
								<input name="rightUrl" id="rightUrl" type="text" value="${requestScope.right.rightUrl }"/>
							</td>
				        </tr>
				        <tr>
				          	<td>权限类型:</td>
							<td>
								<select name="rightType">
									<option value="-1">全部</option>
									<option value="1">菜单</option>
									<option value="2">按钮</option>
								</select>
							</td>
				        </tr>
						<tr>
							<td>状态:</td>
							<td>
								<select name="status">
									<option value="-1">全部</option>
									<option value="1" <c:if test="${requestScope.employee.status eq 1 }">selected="selected"</c:if>>正常</option>
									<option value="0" <c:if test="${requestScope.employee.status eq 0 }">selected="selected"</c:if>>禁用</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
					      		<input type="submit" value="添加二级权限" />
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
		console.log(success);
		if(success){
			alert("添加成功");
		}
</script>
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src='js/leftnav.js'></script>
</body>
</html>