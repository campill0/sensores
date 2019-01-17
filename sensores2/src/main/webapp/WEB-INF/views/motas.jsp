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
 <style>

</style>
</head>
<body>

<%@ include file="/WEB-INF/views/js.jsp" %>
<%@ include file="/WEB-INF/views/menujs.jsp" %>
<%@ include file="/WEB-INF/views/menu.jsp" %>


<section class="principal" style="text-align:center;">

	<div class="row">
		 <div class="col-md-12"><h1 ><i class="fa fa fa-microchip fa-2x" aria-hidden="true"></i><span style="font-size:4em;"> ${titulo}</span></h1></div>
		 
	</div>
	
		 <div class="col-md-3"></div>
		 <div class="col-md-6"> <img width="100%" 
		 src="${pageContext.request.contextPath}/resources/img/smart_cities_model.png"></div>
		 <div class="col-md-3"></div>
		</div>
			
		</div>
			<div class="row">
		 <div class="col-md-12">
		 
		 <table class="table tg" id="tabla-resultados" style="width:100%" >
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">IdMota</th>
						<th scope="col">Tipo</th>
						<th scope="col">Descripcion</th>
						<th scope="col">NumInventario</th>
						<th scope="col">Fabricante</th>
						<th scope="col">Modelo</th>
						<th scope="col">Ficha</th>
						<th scope="col" width="220">Acciones</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="mota" items="${motas}" varStatus="contador">
					<tr>
						<th scope="row">${contador.index+1}</th>
						<td>${mota.idMota}</td>
						<td title="${mota.tipoMota}"><i class="${mota.tipoCssGrande}"></i> </td>
						<td>${mota.descripcion}</td>
						<td>${mota.numInventario}</td>
						<td>${mota.fabricante}</td>
						<td>${mota.modelo}</td>
						<td>${mota.urlFichaProductoFabricante}</td>
						
						<td class="acciones">
						<a  class="btn btn-danger btn-lg" href="<c:url value='/auth/privado/motas/eliminar/${mota.idMota}'/>" style="margin-right:1em;" ><i class="fas fa-trash-alt"></i></a> 
						<a style="margin-right:1em;" class="btn btn-warning btn-lg" href="<c:url value='/auth/privado/motas/editar/${mota.idMota}'/>"><i class="fas fa-pen"></i></a>  
						<a class="btn btn-primary btn-lg" href="<c:url value='/auth/privado/motas/ver/${mota.idMota}'/>"><i class="far fa-eye"></i></a></td>
			
					</tr>
				</c:forEach>
				</tbody>
			</table>
		 </div>
			
		</div>
		
</section>
  <script type="text/javascript">
  $('#tabla-resultados').DataTable({ responsive: true });
  $('#tabla-resultados').DataTable().page.len(50).draw();
  </script>
</body>
</html> 