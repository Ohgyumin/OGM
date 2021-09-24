<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="rid" %>
<%@ attribute name="userid" %>

<c:if test="${seUser == userid}">
	<a href="delrp.do?rid=${rid}&mcnt=${mcnt}&selUser=${selUser}">삭제</a>
</c:if>