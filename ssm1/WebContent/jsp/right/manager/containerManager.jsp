<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h3>权限管理>> 查看权限</h3>
<form id="submitForm" action="right.do?action=getByPage" method="post">
	<input id="hiddenInput" name="pageIndex" type="hidden"/>
	<table width="100%">
		<tr>
			<td>名称:</td>
			<td>
				<input id="rightName" type="text" name="rightName" value="${requestScope.condition.rightName }">
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
			<td>父权限:</td>
			<td>
				<select id="parentId" name="parentId">
					<option value="0">全部</option>
					<c:forEach items="${requestScope.oneRightList }" var="oneRight">
					<c:if test="${oneRight.parentId eq 0 }">
						<option value="${oneRight.rightId }" <c:if test="${requestScope.condition.parentId eq oneRight.rightId }">selected="selected"</c:if>>${oneRight.rightName }</option>
					</c:if>
					</c:forEach>
				</select>
				<input type="submit" value="查询" >
			</td>
		</tr>
	</table>
</form>
<h3>权限信息表</h3>
<table width="100%" border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>权限名称</td>
		<td>父级权限</td>
		<td>权限描述</td>
		<td>权限URL</td>
		<td>权限类型</td>
		<td>权限状态</td>
		<td>操作</td>
	</tr>
	<c:if test="${empty sessionScope.rightList}">
	<tr>
		<td colspan="7">没有查到数据</td>
	</tr>
	</c:if>
	<c:if test="${not empty sessionScope.rightList}">
	<c:forEach items="${sessionScope.rightList}" var="right" varStatus="status">
	<tr>
		<td><a href="right.do?action=getById&rightId=${right.rightId }">${right.rightName}</a></td>
		<td>
			<c:forEach items="${requestScope.oneRightList }" var="oneRight">
			<c:if test="${oneRight.rightId eq right.parentId }">
				${oneRight.rightName }
			</c:if>
			</c:forEach>
		</td>
		<td>${right.rightDesc}</td>
		<td>${right.rightUrl }</td>
		<td>${right.rightType }</td>
		<td>
			${right.status eq 1 ? "正常" : "禁用"}
		</td>
		<td><a href="right.do?action=delete&rightId=${right.rightId }" onclick="return confirm('确定删除？')">删除</a></td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="7" align="center">
			<a href="javascript:doEmployee(1)">首页</a>
			<a href="javascript:doEmployee(${sessionScope.pageUtil.prePageIndex})">上一页</a>
			第${sessionScope.pageUtil.pageIndex}页/共${sessionScope.pageUtil.totalPages}页
			<a href="javascript:doEmployee(${sessionScope.pageUtil.nextPageIndex})">下一页</a>
			<a href="javascript:doEmployee(${sessionScope.pageUtil.totalPages})">末页</a>
		</td>
	</tr>
	</c:if>
</table>
