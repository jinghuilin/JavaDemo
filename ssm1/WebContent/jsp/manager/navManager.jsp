<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <div>
	<ul>
		<c:if test="${not empty sessionScope.rights }">
		<c:forEach items="${sessionScope.rights }" var="right">
		<c:if test="${right.parentId eq 0}">
		<c:set var="rightId" scope="session" value="${right.rightId }"></c:set>
		<li><a href="#">${right.rightName }</a>
			<ul>
				<c:forEach items="${sessionScope.rights }" var="right">
				<c:if test="${right.parentId eq rightId && right.rightType eq 1 }">
				<li><a href="${right.rightUrl }">${right.rightName }</a></li>
				</c:if>
				</c:forEach>
			</ul>
		</li>	
		</c:if>	
		</c:forEach>
		</c:if>
	</ul>
</div> --%>


    <ul id="accordion" class="accordion">
    	<c:if test="${not empty sessionScope.rights }">
		<c:forEach items="${sessionScope.rights }" var="right">
		<c:if test="${right.parentId eq 0}">
		<c:set var="rightId" scope="session" value="${right.rightId }"></c:set>
        <li>
            <div class="link">${right.rightName }<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <c:forEach items="${sessionScope.rights }" var="right">
				<c:if test="${right.parentId eq rightId && right.rightType eq 1 }">
				<li><a href="${right.rightUrl }">${right.rightName }</a></li>
				</c:if>
				</c:forEach>
            </ul>
        </li>
        </c:if>	
		</c:forEach>
		</c:if>
    </ul>
