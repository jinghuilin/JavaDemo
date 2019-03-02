<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h3>员工管理>> 查看员工</h3>
<form id="submitForm" action="employee.do?action=getByPage" method="post">
	<input id="hiddenInput" name="pageIndex" type="hidden"/>
	<table width="100%" border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>姓名:</td>
			<td><input id="empNme" type="text" name="empName" value="${requestScope.condition.empName }" onfocus="clearName()"></td>
			<td>性别:</td>
			<td>
				<select id="sex" name="sex">
					<option value="-1">全部</option>
					<option value="1" <c:if test="${requestScope.condition.sex eq 1 }">selected="selected"</c:if>>男</option>
					<option value="0" <c:if test="${requestScope.condition.sex eq 0 }">selected="selected"</c:if>>女</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>角色:</td>
			<td>
				<select id="roleId" name="roleId">
					<option value="0">全部</option>
					<c:forEach items="${requestScope.roleList }" var="role">
					<option value="${role.roleId }" <c:if test="${requestScope.condition.roleId eq role.roleId }">selected="selected"</c:if>>${role.roleName }</option>
					</c:forEach>
				</select>
			</td>
			<td>状态:</td>
			<td>
				<select id="status" name="status">
					<option value="-1">全部</option>
					<option value="1" <c:if test="${requestScope.condition.status eq 1 }">selected="selected"</c:if>>正常</option>
					<option value="0" <c:if test="${requestScope.condition.status eq 0 }">selected="selected"</c:if>>禁用</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>出生日期:</td>
			<td colspan="3">
				<input id="startBirthday" type="text" name="startBirthday" value='<fmt:formatDate value="${requestScope.condition.startBirthday}" pattern="yyyy-MM-dd"/>' >-
				<input id="endBirthday" type="text" name="endBirthday" value='<fmt:formatDate value="${requestScope.condition.endBirthday}" pattern="yyyy-MM-dd" />'>(yyyy-MM-dd)
				<input type="submit" value="查询" >
				<!-- <input type="submit" onclick="myReset()" value="重置查询条件"> -->
			</td>
		</tr>
	</table>
</form>
<h3>员工信息表</h3>
<table width="100%" border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>姓名</td>
		<td>性别</td>
		<td>出生日期</td>
		<td>角色</td>
		<td>状态</td>
		<td>操作</td>
	</tr>
	<c:if test="${empty sessionScope.empList}">
	<tr>
		<td colspan="6">没有查到数据</td>
	</tr>
	</c:if>
	<c:if test="${not empty sessionScope.empList}">
	<c:forEach items="${sessionScope.empList}" var="employee" varStatus="status">
	<tr>
		<td><a href="employee.do?action=getById&empId=${employee.empId }">${employee.empName}</a></td>
		<td>${employee.sex eq 1 ? "男" : "女"}</td>
		<td><fmt:formatDate value="${employee.birthday}" pattern="yyyy-MM-dd"/></td>
		<td>
			<c:forEach items="${requestScope.roleList }" var="role">
				<c:if test="${employee.roleId == role.roleId}">${role.roleName }</c:if>
			</c:forEach>
		</td>
		<td>${employee.status eq 1 ? "正常" : "禁用"}</td>
		<td><a href="employee.do?action=delete&empId=${employee.empId }" onclick="return confirm('确定删除？')">删除</a><a href="employee.do?action=getById2&empId=${employee.empId }">分配角色</a></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="6" align="center">
			<a href="javascript:doEmployee(1)">首页</a>
			<a href="javascript:doEmployee(${pageUtil.prePageIndex})">上一页</a>
			第${pageUtil.pageIndex}页/共${pageUtil.totalPages}页
			<a href="javascript:doEmployee(${pageUtil.nextPageIndex})">下一页</a>
			<a href="javascript:doEmployee(${pageUtil.totalPages})">末页</a>
		</td>
	</tr>
	</c:if>
</table>
