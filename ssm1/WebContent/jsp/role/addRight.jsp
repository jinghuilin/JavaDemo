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

	<div id="header"><%@ include file="/jsp/manager/headerManager.jsp" %></div>
	<div id="main">
		<div class="nav"><%@ include file="/jsp/manager/navManager.jsp" %></div>
		<div class="container">
			<h3>角色管理>> 分配权限</h3>
			<form id="updateRoleForm" action="refRoleRights.do?action=insert" method="post">
				<input name="roleId" type="hidden" value="${requestScope.roleId }" />
				<table width="100%" border="1" cellpadding="10" cellspacing="0">
					<tbody>
						<c:if test="${not empty requestScope.rightList }">
						<c:forEach items="${requestScope.rightList }" var="right">
						<c:if test="${right.parentId eq 0}">
						<c:set var="rightId" scope="session" value="${right.rightId }"></c:set>
				        <tr>
					    	<td><input name="rights" id="checkBoxes" <c:forEach items="${requestScope.refRightIdList }" var="refRightId"><c:if test="${right.rightId eq refRightId }">checked</c:if></c:forEach> value="${right.rightId }" type="checkbox"/>${right.rightName }</td>
					        <td>
					        	<c:forEach items="${requestScope.rightList }" var="r2">
								<c:if test="${r2.parentId eq rightId }">
									<input type="checkbox" name="rights" id="checkBoxes" <c:forEach items="${requestScope.refRightIdList }" var="refRightId"><c:if test="${r2.rightId eq refRightId }">checked</c:if></c:forEach> value="${r2.rightId }" />${r2.rightName }
								</c:if>
								</c:forEach>
					        </td>
				        </tr>
				       	</c:if>	
						</c:forEach>
						</c:if>
						<tr>
							<td colspan="2" align="center">
					      		<input type="submit" value="保存"  />
					     	</td> 
					  	</tr>
			     	</tbody>
				</table>
			</form>
		</div>
	</div>
	<div id="footer"></div>
	
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src='js/leftnav.js'></script>
</body>
</html>