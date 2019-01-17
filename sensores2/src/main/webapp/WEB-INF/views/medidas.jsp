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
		 <div class="col-md-12"><h1 >${title}</h1></div>
	</div>
	<div class="row">
		 <div class="col-md-12"><h2 style="font-size:4em;"><i class="fa fa-thermometer-half fa-2x" aria-hidden="true"></i> ${subtitulo}</h2></div>
	</div>
	<div class="row">
		 <div class="col-md-12">&nbsp;</div>
	</div>
	<div class="row">	<div class="col-md-12">
				<div id="mapid" style="width: 80%; height: 600px; margin: auto;"></div>
				<script>
					var mymap = L.map('mapid').setView([ 37.6581402164756, -1.0070582085937758 ], 11);
					L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpejY4NXVycTA2emYycXBndHRqcmZ3N3gifQ.rJcFIG214AriISLbB6B5aw',
									{
										maxZoom : 18,
										attribution : 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, '
												+ '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
												+ 'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
										id : 'mapbox.streets'
									}).addTo(mymap);
					 L.AwesomeMarkers.Icon.prototype.options.prefix = 'fa';
					 var parking = L.AwesomeMarkers.icon({ icon: 'car', markerColor: 'orange' });
					 var contaminacion_basica = L.AwesomeMarkers.icon({ icon: 'biohazard', markerColor: 'black' });
					 var gps = L.AwesomeMarkers.icon({ icon: 'map-marked-alt', markerColor: 'green' });
					 var agua_basica = L.AwesomeMarkers.icon({ icon: 'tint', markerColor: 'lightblue' });
					       
					<c:forEach var="medida" items="${medidasMotasDto}" varStatus="contador">
						var latitud=${medida.sensorGps.posicion.latitud};
						var longitud=${medida.sensorGps.posicion.longitud};
						L.marker([ latitud, longitud ], {icon: ${medida.tipo}}).addTo(mymap).bindPopup("<span class='wrapperMota'>${medida.textoMedidaHtml}</span>");
					</c:forEach>
					var popup = L.popup();
				</script>


			</div>
			</div>
	<div class="row">
		 <div class="col-md-12">&nbsp;</div>
	</div>
	
<!--   Medidas enviadas por las motas -->

	<div class="row">
		 <div class="col-md-12">
		
		
		<table class="table tg" id="tabla-resultados" style="width:100%" >
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
</section>
  <script type="text/javascript">
	  function filtrarCampos(){
		  var tipoDeMota= $("#tipoMota").val();
		  $(".opcional").removeClass("visible");
		  $("[data-tipo~='"+tipoDeMota+"']").addClass("visible");
		 
	  }
	  filtrarCampos();
  </script>
    <script type="text/javascript">
  $('#tabla-resultados').DataTable({ responsive: true });
  $('#tabla-resultados').DataTable().page.len(50).draw();
  </script>
</body>
</html> 