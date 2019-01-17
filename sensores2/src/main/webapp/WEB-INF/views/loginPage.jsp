<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${titulo}</title>
   <%@ include file="/WEB-INF/views/css.jsp" %>
<%@ include file="/WEB-INF/views/menucss.jsp" %>
 <style>
 #loginContainer *{
 margin-bottom:1em;
 }
  #loginContainer table {border: 1px solid #cacaca;}
  #loginContainer td {padding:1em;}
 
 </style>
</head>
<body>
<%@ include file="/WEB-INF/views/js.jsp" %>
<%@ include file="/WEB-INF/views/menujs.jsp" %>
<%@ include file="/WEB-INF/views/menu.jsp" %>
<section class="principal">


     
     <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
    <div id="loginContainer" style="width:100%; text-align:center;">
   <h3 >Introduzca su nombre de usuario y contraseña</h3>  
     
   <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
      <table style="margin:auto;">
         <tr>
            <td>Usuario:</td>
            <td><input type='text' name='username' value='' class="form-control"></td>
         </tr>
         <tr>
            <td>Contraseña:</td>
            <td><input type='password' name='password' class="form-control"/></td>
         </tr>
         <tr>
            <td colspan="2"><input name="submit" type="submit" value="Login" class="btn btn-primary"/></td>
         </tr>
      </table>
  </form>
  </div>


  </section>
</body>
</html> 