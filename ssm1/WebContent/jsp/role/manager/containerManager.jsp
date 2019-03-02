<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>角色管理>> 查询角色</h3>
<form id="submitForm" action="role.do?action=getByPage" method="post">
	<input id="hiddenInput" name="strPageIndex" type="hidden"/>
	<table width="100%">
		<tr>
			<td>角色名称:</td>
			<td><input name="roleName" id="roleName" type="text" value="${requestScope.role.roleName }" /></td>
			<td>状态:</td>
			<td>
				<select id="status" name="status">
					<option value="-1">全部</option>
					<option value="1" <c:if test="${requestScope.role.status eq 1 }">selected="selected"</c:if>>正常</option>
					<option value="0" <c:if test="${requestScope.role.status eq 0 }">selected="selected"</c:if>>禁用</option>
				</select>
				<input type="submit" value="查询" >
			</td>
		</tr>
	</table>
</form>
<h3>角色信息表</h3>
<table width="100%" border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>名称</td>
		<td>描述</td>
		<td>操作</td>
	</tr>
	<c:if test="${empty sessionScope.roleList}">
	<tr>
		<td colspan="4">没有查到数据</td>
	</tr>
	</c:if>
	<c:if test="${not empty sessionScope.roleList}">
	<c:forEach items="${sessionScope.roleList}" var="role" varStatus="status">
	<tr>
		<td><a href="role.do?action=getById&roleId=${role.roleId }">${role.roleName}</a></td>
		<td>${role.roleDesc }</td>
		<td>
			<a href="role.do?action=delete&roleId=${role.roleId }" onclick="return confirm('确定删除？')">删除</a>
			<a href="right.do?action=getAll&roleId=${role.roleId }">分配权限</a>
		</td>
	</tr>
	</c:forEach>
	</c:if>
	<%-- <tr>
		<td colspan="6" align="center">
			<a href="jsp/employee/doEmployee.jsp?pageIndex=1">首页</a>
			<a href="jsp/employee/doEmployee.jsp?pageIndex=${requestScope.prePageIndex}">上一页</a>
			第${requestScope.pageIndex}页/共${requestScope.totalPages}页
			<a href="jsp/employee/doEmployee.jsp?pageIndex=${requestScope.nextPageIndex}">下一页</a>
			<a href="jsp/employee/doEmployee.jsp?pageIndex=${requestScope.totalPages}">末页</a>
			<a href="javascript:doEmployee(1)">首页</a>
			<a href="javascript:doEmployee(${requestScope.prePageIndex})">上一页</a>
			第${requestScope.pageIndex}页/共${requestScope.totalPages}页
			<a href="javascript:doEmployee(${requestScope.nextPageIndex})">下一页</a>
			<a href="javascript:doEmployee(${requestScope.totalPages})">末页</a>
		</td>
	</tr> --%>
</table>
