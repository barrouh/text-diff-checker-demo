<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TextDiffChecker Demo</title>
	<spring:url value="/resources/core/css/main.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>
<body>

	<div class="container">
	
	
	</div>

	<spring:url value="/resources/core/js/main.js" var="coreJs" />
	<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
	<spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
 
</body>
<footer>
	<p>© Barrouh.com 2018</p>
</footer>
</html>
