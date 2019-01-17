  <!-- Ace Responsive Menu -->
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
   <div class="row">
		 <div class="col-md-12">
    <nav>
        <!-- Menu Toggle btn-->
        <div class="menu-toggle">
            <h3>Menu</h3>
            <button type="button" id="menu-btn">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- Responsive Menu Structure-->
        <!--Note: declare the Menu style in the data-menu-style="horizontal" (options: horizontal, vertical, accordion) -->
        <ul id="respMenu" class="ace-responsive-menu" data-menu-style="horizontal">
              <sec:authorize access="isAuthenticated()">
              <sec:authentication var="user" property="principal" />
   			<li class="pull-right">
                <a class="" href="#!">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <span class="title">${user.username}</span>

                </a>
               
            </li>
            	</sec:authorize>
              <li>
                <a href="<c:url value='/'/>">
                    <i class="fa fa-home" aria-hidden="true"></i>
                    <span class="title">Inicio</span>
                </a>
            </li>
             <sec:authorize access="hasRole('USER')">
	            <li>
                <a href="#!">
                    <i class="fa fa-microchip" aria-hidden="true"></i>
                    <span class="title">Motas</span>

                </a>
                <!-- Level Two-->
				<ul>
					<li>
						<a class="" href="<c:url value='/auth/privado/motas'/>">
							<i class="fa fa-microchip" aria-hidden="true"></i> <span class="title">Motas</span>
						</a>
					</li>
					<li>
						<a class="" href="<c:url value='/auth/privado/motas/nueva'/>">
							<i class="fa fa-plus" aria-hidden="true"></i> <span class="title">Nueva Mota</span>
						</a>
					</li>
					<li>
						<a class="" href="<c:url value='/auth/privado/medidas'/>">
							<i class="fa fa-thermometer-half" aria-hidden="true"></i> <span class="title">Mediciones</span>
						</a>
					</li>
				</ul>
			</li>
			</sec:authorize>
			    <sec:authorize access="hasRole('ADMIN')">
	            <li>
                <a href="#!">
                    <i class="fa fa-cog" aria-hidden="true"></i>
                    <span class="title">Administración</span>

                </a>
                <!-- Level Two-->
				<ul>
					<li><!-- No está implementado -->
	                	<a class="" href="#">
	                  	  <i class="fa fa-user-edit" aria-hidden="true"></i>
	                   	 <span class="title">Usuarios</span>
	               		 </a>
		            </li>
					<li  class="soloUsuariosExpertos">
						 <a href="#!">
                  			  <i class="fa fa-asterisk" aria-hidden="true"></i>
                   			 <span class="title">Datos de prueba</span>

                		</a>
						
						
						
						<ul>
							<li>
								 <a class="" href="<c:url value='/auth/admin/resetear'/>"> <i
									class="fa fa-trash" aria-hidden="true"></i> <span
									class="title">Resetear Bd</span>
							</a>
							</li>
							<li><a href="<c:url value='/auth/admin/generar'/>"> <i class="fa fa-cogs"
									aria-hidden="true"></i> <span class="title">Generar datos</span>

							</a></li>

						</ul>
					</li>
					
				</ul>
			</li>
			</sec:authorize>
			
	   			
       		
             
            	   <sec:authorize access="isAuthenticated()">
   			<li>
                <a class="" href="<c:url value='/logout'/>">
                    <i class="fa fa-sign-out-alt" aria-hidden="true"></i>
                    <span class="title">Logout</span>

                </a>
               
            </li>
			</sec:authorize>
 		<sec:authorize access="isAnonymous()">
             <li>
                <a class="" href="<c:url value='/login'/>">
                    <i class="fa fa-sign-in-alt" aria-hidden="true"></i>
                    <span class="title">Login</span>
                </a>
            </li>
             </sec:authorize> 
        </ul>
    </nav>
  </div>
</div>
    	<!--Plugin Initialization-->
     <script type="text/javascript">
         $(document).ready(function () {
             $("#respMenu").aceResponsiveMenu({
                 resizeWidth: '768', // Set the same in Media query       
                 animationSpeed: 'fast', //slow, medium, fast
                 accoridonExpAll: false //Expands all the accordion menu on click
             });
         });
	</script>