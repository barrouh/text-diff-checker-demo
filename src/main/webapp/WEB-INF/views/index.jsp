<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="date" class="java.util.Date" />
<fmt:formatDate value="${date}" pattern="yyyy" var="currentYear" />

<!DOCTYPE html>
<html lang="en">
<head>
    <title>TextDiffChecker Demo</title>
	<spring:url value="/resources/core/css/main.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/core/css/codemirror.css" var="codemirrorCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${codemirrorCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
	<link rel="icon" href="/resources/core/img/diff.png" type="image/png" />
</head>
<body>

<div class="home-hero">
		<span>Diff Checker is an online diff tool to compare text differences between two text files.
		<br>Enter the contents of two files and click
		<strong>Find Difference!</strong>
		</span>
</div>
<div class="resultDiv col-xs-12 col-sm-12 col-md-12 col-lg-12">
	${htmlResult}
</div>
<div class=" mainDiv">
	
	<form id="myForm"   method='POST'  action='/checkDiffs'>
	 	<div class="textFrom col-xs-12 col-sm-12 col-md-6 col-lg-6 ">
	 	<span class="textarea-label">original text</span>
	     <textarea id="textFrom1" name="originalText">${originalText}</textarea>
	    </div>
	    
	    <div class="textFrom col-xs-12 col-sm-12 col-md-6 col-lg-6 ">
	    <span class="textarea-label">changed text</span>
	     <textarea id="textFrom2" name="changedText">${changedText}</textarea>
	    </div>
		<br>
		<button type="submit" class="greenButton">Find Difference!</button>
	</form>
</div>
	<spring:url value="/resources/core/js/main.js" var="coreJs" />
	<spring:url value="/resources/core/js/codemirror.js" var="codemirrorJs" />
	<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
	<spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script src="${codemirrorJs}"></script>
	<script src="${coreJs}"></script>
	<script>
		var textFrom1 = CodeMirror.fromTextArea(document.getElementById("textFrom1"), {
		  lineNumbers: true,
		  extraKeys: {"Ctrl-Space": "autocomplete"},
		  mode: {name: "javascript", globalVars: true}
		});
		
		var textFrom2 = CodeMirror.fromTextArea(document.getElementById("textFrom2"), {
			  lineNumbers: true,
			  extraKeys: {"Ctrl-Space": "autocomplete"},
			  mode: {name: "javascript", globalVars: true}
		});
	</script>

</body>

<footer>
	<p> Made in Morocco By <a href="https://github.com/barrouh"  target="_blank">Mohamed Barrouh</a> © ${currentYear}</p>
</footer>
</html>
