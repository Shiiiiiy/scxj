<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="cms" tagdir="/WEB-INF/tags/cms" %>
<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getMobilePath()}"/>
<c:set var="ctxf" value="${pageContext.request.contextPath}${fns:getFrontPath()}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<c:set var="urlSuffix" value="${fns:getUrlSuffix()}"/>