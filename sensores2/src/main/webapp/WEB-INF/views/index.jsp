<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${titulo}</title>
   <%@ include file="/WEB-INF/views/css.jsp" %>
	<%@ include file="/WEB-INF/views/menucss.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/js.jsp" %>
<%@ include file="/WEB-INF/views/menujs.jsp" %>
<%@ include file="/WEB-INF/views/menu.jsp" %>

<section class="principal" style="text-align:center;">

	
	<div class="row">
		 <div class="col-md-12"><h1>${titulo}</h1></div>
	</div>
	<div class="row">
		 <div class="col-md-12"><h2>${subtitulo}</h2></div>
	</div>
	<div class="row">
		 <div class="col-md-3"></div>
		 <div class="col-md-6"> <img width="100%" 
		 src="${pageContext.request.contextPath}/resources/img/smart-city.jpg"></div>
		 <div class="col-md-3"></div>
	</div>
</section>
</body>
</html> 




