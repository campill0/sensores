<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>${titulo}</title>
   <%@ include file="/WEB-INF/views/css.jsp" %>
<%@ include file="/WEB-INF/views/menucss.jsp" %>
 
</head>
<body>
<%@ include file="/WEB-INF/views/menu.jsp" %>
<h3 style=" color: #ad0000;
    font-size: 3em;
    text-align: center;
    margin-top: 2em;">${mensaje}</h3>
<%@ include file="/WEB-INF/views/js.jsp" %>
<%@ include file="/WEB-INF/views/menujs.jsp" %>

  
</body>
</html> 