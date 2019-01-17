<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title}</title>
   <%@ include file="/WEB-INF/views/css.jsp" %>
<%@ include file="/WEB-INF/views/menucss.jsp" %>
 <style>
 th {
 text-align:center;
 }
 .opcional{
 display:none;
 }
 .visible{
 display:block !important;
 }
 </style>
</head>
<body>

<%@ include file="/WEB-INF/views/js.jsp" %>
<%@ include file="/WEB-INF/views/menujs.jsp" %>
<%@ include file="/WEB-INF/views/menu.jsp" %>
<c:url var="urlFormulario" value=''/>
 <c:if test="${editar}">
<c:url var="urlFormulario" value='/auth/privado/motas/guardar'/>
</c:if>
<section class="principal" style="text-align:center;">
	
	<div class="row">
		 <div class="col-md-12"><h1  style="font-size:4em;">${title}</h1></div>
	</div>
	<div class="row">
		 <div class="col-md-12"><h2  style="font-size:4em;">${subtitulo}</h2></div>
	</div>
	<div class="row">
		 <div class="col-md-12">&nbsp;</div>
	</div>
	<div class="row">
	 <div class="col-md-2"></div>
		 <div class="col-md-8" style="background: #f8f9fa !important; padding: 2em;">
		 <form:form action="${urlFormulario}"  commandName="motaDto" method="POST">
		 <form:hidden path=""/>
		<div class="row">
			<c:if test="${!nueva}">
				<div class="col-md-12">
		 			<form:select   path="tipoMota" class="form-control"  onchange="filtrarCampos();"  disabled="true">
		 			 <form:options items="${tiposMota}" />
		 			</form:select>
		 			  <form:hidden  path="tipoMota" />
				 </div>
			</c:if>
			<c:if test="${nueva}">
				<div class="col-md-12">
		 			<form:select   path="tipoMota" class="form-control"  onchange="filtrarCampos();"  >
		 			 <form:options items="${tiposMota}" />
		 			</form:select>
				 </div>
			</c:if>
		 	 <div class="col-md-4">
		 	 	<label for="idmota">IdMota</label>
                <input id="idMota" class="form-control" disabled="disabled" value="${motaDto.idMota}"/>
                <form:hidden  path="idMota" />
		 	 </div>
		 	 <div class="col-md-4">
		 	 <label for="descripcion">Descripcion</label>
                <form:input id="descripcion" path="descripcion" class="form-control" />
		 	 </div>
		 	  <div class="col-md-4">
		 	  <label for="numInventario">Num inventario</label>
                <form:input id="numInventario" path="numInventario" class="form-control" />
		 	 </div>
		 	  <div class="col-md-4">
		 		  <label for=fabricante>Fabricante</label>
                <form:input id="fabricante" path="fabricante" class="form-control" />
		 	 </div>
		 	  <div class="col-md-4">
		 	 	<label for="modelo">Modelo</label>
                <form:input id="modelo" path="modelo" class="form-control" />
		 	 </div>
		 	  <div class="col-md-4">
		 	 	<label for="ficha">Ficha</label>
                <form:input id="ficha" path="urlFichaProductoFabricante" class="form-control" />
		 	 </div>
		 	 
		 </div>
		 <div class="row opcional" data-tipo1="parking" data-tipo2="agua_basica" data-tipo3="contaminacion_basica">
			<div class="col-md-4">
		 	 	<label for="latitud">Latitud</label>
                <form:input id="latitud" path="posicion.latitud" class="form-control" />
		 	 </div>
		 	 <div class="col-md-4">
		 	 	<label for="longitud">Longitud</label>
                 <form:input id="longitud" path="posicion.longitud" class="form-control" />
		 	 </div>
		 	 <div class="col-md-4">
		 	 	<label for="altitud">Altitud</label>
                <form:input id="altitud" path="posicion.altitud" class="form-control" />
		 	 </div>
		 	 
		 </div>
		 <div class="row opcional" data-tipo1="agua_basica">
		 <div class="col-md-12">
		 	 	<label for="lugar">Lugar</label>
                <form:input id="lugar" path="lugar" class="form-control" />
		 </div>
		 	 
		 </div>
		 <div class="row opcional" data-tipo1="contaminacion_basica">
			 <div class="col-md-6">
			 	 	<label for="ultimaRevisison">Última revisión</label>
	                <form:input id="ultimaRevisison" type="date" path="ultimaRevision" class="form-control" />
			 </div>
			  <div class="col-md-6">
			 	 	<label for="notasRevision">Notas revisión</label>
	                <form:input id="notasRevision" path="notasRevision" class="form-control" />
			 </div>
		 	 
		 </div>
		 <div class="row opcional" data-tipo1="parking">
				<div class="col-md-4">
			 	 	<label for="calle">Calle</label>
	                <form:input id="calle" path="direccion.calle" class="form-control" />
			 	 </div>
			 	 <div class="col-md-4">
			 	 	<label for="numero">Número</label>
	                 <form:input id="numero" path="direccion.numero" class="form-control" />
			 	 </div>
			 	 <div class="col-md-4">
			 	 	<label for="codpostal">Codígo postal</label>
	                <form:input id="codpostal" path="direccion.codpostal" class="form-control" />
			 	 </div>
		 	 
		 </div>
		 
		 <div class="row">
		  <div class="col-md-12">&nbsp;</div>
		 </div>
		 <div class="row">
			 <c:if test="${editar}">
				  <div class="col-md-6"> 
				  <button class="btn btn-success btn-lg btn-block" type="submit">Guardar</button>
				  </div>
			  </c:if>
		  <div class="col-md-<c:if test="${editar}">6</c:if><c:if test="${!editar}">12</c:if>"> 
		  <a class="btn btn-primary btn-lg btn-block" href="<c:url value='/auth/privado/motas'/>">Volver al listado</a>
		  </div>
		 </div>
		 
		 </form:form>
		 </div>
	<div class="col-md-2"></div>
	</div>

<!--   Medidas enviadas por las motas -->
<div class="row">
		 <div class="col-md-12">&nbsp;</div>
	</div>
	<c:if test="${not empty medidasMotasDto}">
	<div class="row">
		 <div class="col-md-12">
		
		<h1> Mediciones Mota</h1>
		
		<table class="table tg" id="tabla-resultados" style="width:100%;" >
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">idMedida</th>
						<th scope="col">Tipo</th>
						<th scope="col">fechaMedida</th>
						<th scope="col">ph</th>
						<th scope="col">orp</th>
						<th scope="col">conductividad</th>
						<th scope="col">temperaturaAgua</th>
						<th scope="col">turbidez</th>
						<th scope="col">latitud</th>
						<th scope="col">longitud</th>
						<th scope="col">altitud</th>
						<th scope="col">luminosidad</th>
						<th scope="col">ruido</th>
						<th scope="col">pm1</th>
						<th scope="col">pm25</th>
						<th scope="col">pm10</th>
						<th scope="col">temperatura</th>
						<th scope="col">ocupado</th>
						
	
	
					</tr>
				</thead>
				<tbody>
				<c:forEach var="medida" items="${medidasMotasDto}" varStatus="contador">
					<tr>
						<th scope="row">${contador.index+1}</th>
						<td>${medida.idMedida}</td>
						<td title="${medida.tipo}"><i class="${medida.tipoCssGrande}"></i> </td>
						<td>${medida.fechaMedida}</td>
						<td>${medida.sensorCalidadAgua.ph}</td>
						<td>${medida.sensorCalidadAgua.orp}</td>
						<td>${medida.sensorCalidadAgua.conductividad}</td>
						<td>${medida.sensorCalidadAgua.temperaturaAgua}</td>
						<td>${medida.sensorCalidadAgua.turbidez}</td>
						<td>${medida.sensorGps.posicion.latitud}</td>
						<td>${medida.sensorGps.posicion.longitud}</td>
						<td>${medida.sensorGps.posicion.altitud}</td>
						<td>${medida.sensorContaminacionBasico.luminosidad}</td>
						<td>${medida.sensorContaminacionBasico.ruido}</td>
						<td>${medida.sensorContaminacionBasico.pm1}</td>
						<td>${medida.sensorContaminacionBasico.pm25}</td>
						<td>${medida.sensorContaminacionBasico.pm10}</td>
						<td>${medida.sensorTemperatura.temperatura}</td>
						<td>${medida.sensorParking.ocupado}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</c:if>
</section>
  <script type="text/javascript">
	  function filtrarCampos(){
		  var tipoDeMota= $("#tipoMota").val();
		  $(".opcional").removeClass("visible");
		  $("[data-tipo1='"+tipoDeMota+"']").addClass("visible");
		  $("[data-tipo2='"+tipoDeMota+"']").addClass("visible");
		  $("[data-tipo3='"+tipoDeMota+"']").addClass("visible");
	  }
	  filtrarCampos();
  </script>
    <script type="text/javascript">
    $('#tabla-resultados').DataTable({ responsive: true });
  $('#tabla-resultados').DataTable().page.len(50).draw();
  </script>
</body>
</html> 