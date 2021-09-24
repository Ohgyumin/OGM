<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="mid" %>
<%@ attribute name="userid" %>

<a href="updatemsg.do?mid=${mid}&mcnt=${mcnt}&selUser=${selUser}">♥</a>
<c:if test="${seUser == userid}">
	<a href="delmsg.do?mid=${mid}&mcnt=${mcnt}&selUser=${selUser}">삭제</a>
</c:if>