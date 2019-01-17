package com.aytocartagena.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aytocartagena.model.builders.MedidaMotaAguaBasicaBuilder;
import com.aytocartagena.model.builders.MedidaMotaContaminacionBasicaBuilder;
import com.aytocartagena.model.builders.MedidaMotaGpsBuilder;
import com.aytocartagena.model.builders.MedidaMotaParkingBuilder;
import com.aytocartagena.model.builders.MotaAguaBasicaBuilder;
import com.aytocartagena.model.builders.MotaContaminacionBasicaBuilder;
import com.aytocartagena.model.builders.MotaGpsBuilder;
import com.aytocartagena.model.builders.MotaParkingBuilder;
import com.aytocartagena.model.medidas.MedidaMota;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.motas.MotaAguaBasica;
import com.aytocartagena.model.motas.MotaContaminacionBasica;
import com.aytocartagena.model.motas.MotaGps;
import com.aytocartagena.model.motas.MotaParking;
import com.aytocartagena.service.MedidaMotaService;
import com.aytocartagena.service.MotaService;
import com.aytocartagena.service.UsuarioService;
 
@Controller
public class PruebasController {


	@Autowired(required = true)
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;

	@Autowired(required = true)
	@Qualifier("motaServiceImpl")
	private MotaService motaService;

	@Autowired(required = true)
	@Qualifier("medidaMotaServiceImpl")
	private MedidaMotaService medidaMotaService;

	
	 @RequestMapping(value = { "/auth/admin/generar" }, method = RequestMethod.GET)
	    public String generar(Model model) throws ParseException, InterruptedException  {
		
	     
	     model.addAttribute("titulo", "Cartagena Smart City - Centro de datos");
	     model.addAttribute("subtitulo", "Se ha generado contenido de prueba");
	     
	     generarDatos();
	     generarDatos();
	     generarDatos();
	     generarDatos();
	     generarDatos();
	        return "index";
	    }
	
	 @RequestMapping(value = { "/auth/admin/resetear" }, method = RequestMethod.GET)
	    public String resetear(Model model)  {
		 List<Mota> motas = motaService.getAll();
	     
	    for (Mota mota : motas) {
	    	motaService.remove(mota);
		}
	    model.addAttribute("titulo", "Cartagena Smart City - Centro de datos");
	    model.addAttribute("subtitulo", "La Base de datos ha sido regenerada");
	        return "index";
	    }
	 private void generarDatos() throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd hh:mm:ss");
		 int min=1,max=1000;
		 Random random= new Random();
		 int a=random.nextInt(max - min + 1) + min;
		int b=random.nextInt(max - min + 1) + min;
		int c=random.nextInt(max - min + 1) + min;
		 int d=random.nextInt(max - min + 1) + min;
		 float latitud=37.66354783559146F;
		 float longitud=-0.9773220842921546F;
		 float latitudAgua=37.56455453823631F;
		 float longitudAgua=-0.9903683489405921F;
	     MotaGps motaGps= new MotaGpsBuilder()
					.setDescripcion("Grua municipal vehículo nº"+a)
					.setFabricante("Garming").setModelo("Gps traccker for Iot")
					.setNumInventario(1)
					.setUrlFichaProductoFabricante("http://www.garming.com/iotproduct.jsp?productid=23")
					.build();
			MotaContaminacionBasica motaContaminacionBasica = new MotaContaminacionBasicaBuilder()
					.setDescripcion("Mota de detección de contaminación nº"+b)
					.setFabricante("Libellium").setModelo("polutionsensor2000")
					.setNumInventario(2)
					.setUrlFichaProductoFabricante("http://www.libellium.com/product.jsp?productid=23")
					.setPosicionAltitud(40)
					.setPosicionLatitud(latitud)
					.setPosicionLongitud(longitud)
					.setUltimaRevision(sdf.parse("2018/01/01 14:00:00")).setNotasRevision("Revisión inicial realizada por M.Pujante. Todo correcto.").build();
			MotaParking motaParking= new MotaParkingBuilder()
					.setDescripcion("Mota aparcamiento  nº "+c)
					.setFabricante("Libellium").setModelo("SmartParking134")
					.setNumInventario(3)
					.setUrlFichaProductoFabricante("http://www.libellium.com/product.jsp?productid=23")
					.setPosicionAltitud(40).setPosicionLatitud(latitud).setPosicionLongitud(longitud)
					.setDireccionCalle("Calle San Miguel")
					.setDireccionCodPostal("30201")
					.setDireccionNumero("1 - 10")
					.build();
			MotaAguaBasica motaAguaBasica = new MotaAguaBasicaBuilder()
					.setDescripcion("Mota de control de la calidad del agua del mar "+d)
					.setFabricante("Libellium").setModelo("SmartWaterBasic")
					.setNumInventario(4)
					.setUrlFichaProductoFabricante("http://www.libellium.com/iotproduct.jsp?productid=23")
					.setPosicionAltitud(40).setPosicionLatitud(latitudAgua).setPosicionLongitud(longitudAgua)
					.setLugar("mar mediterráneo")
					.build();
				 	a=random.nextInt(max - min + 1) + min;
					b=random.nextInt(max - min + 1) + min;
					c=random.nextInt(max - min + 1) + min;
					d=random.nextInt(max - min + 1) + min;
			MotaContaminacionBasica motaContaminacionBasica2 = new MotaContaminacionBasicaBuilder()
					.setDescripcion("Mota de detección de contaminación nº"+b)
					.setFabricante("Libellium").setModelo("polutionsensor2000")
					.setNumInventario(2)
					.setUrlFichaProductoFabricante("http://www.libellium.com/product.jsp?productid=23")
					.setPosicionAltitud(40)
					.setPosicionLatitud(latitud)
					.setPosicionLongitud(longitud)
					.setUltimaRevision(sdf.parse("2018/01/01 14:00:00")).setNotasRevision("Revisión inicial realizada por M.Pujante. Todo correcto.").build();
			MotaParking motaParking2= new MotaParkingBuilder()
					.setDescripcion("Mota aparcamiento  nº "+c)
					.setFabricante("Libellium").setModelo("SmartParking134")
					.setNumInventario(3)
					.setUrlFichaProductoFabricante("http://www.libellium.com/product.jsp?productid=23")
					.setPosicionAltitud(40).setPosicionLatitud(latitud).setPosicionLongitud(longitud)
					.setDireccionCalle("Calle San Miguel")
					.setDireccionCodPostal("30201")
					.setDireccionNumero("1 - 10")
					.build();
			MotaAguaBasica motaAguaBasica2 = new MotaAguaBasicaBuilder()
					.setDescripcion("Mota de control de la calidad del agua del mar "+d)
					.setFabricante("Libellium").setModelo("SmartWaterBasic")
					.setNumInventario(4)
					.setUrlFichaProductoFabricante("http://www.libellium.com/iotproduct.jsp?productid=23")
					.setPosicionAltitud(40).setPosicionLatitud(latitudAgua).setPosicionLongitud(longitudAgua)
					.setLugar("mar mediterráneo")
					.build();
		
	     motaService.add(motaAguaBasica);
	     motaService.add(motaGps);
	     motaService.add(motaContaminacionBasica);
	     motaService.add(motaParking);	
	     
	     double escala = 30F;
	     motaAguaBasica.getPosicion().setLatitud((float )(motaAguaBasica.getPosicion().getLatitud()-(Math.random()/escala)));
		 motaAguaBasica.getPosicion().setLongitud((float )(motaAguaBasica.getPosicion().getLongitud()+(Math.random()/escala)));
		 
		
	     new MedidaMotaAguaBasicaBuilder(motaAguaBasica)
	     .setConductividad(1)
	     .setFechaMedida(sdf.parse("2018/01/07 18:59:00"))
	     .setOrp(2)
	     .setPh(2)
	     .setTemperaturaAgua(23)
	     .setTurbidez(0.5F).build();
	   
	     new MedidaMotaGpsBuilder(motaGps)
			.setFechaMedida(sdf.parse("2018/01/07 18:59:00"))
			.setPosicionAltitud(40)
			.setPosicionLatitud(latitud)
			.setPosicionLongitud(longitud)
			.build();
		new MedidaMotaGpsBuilder(motaGps)
				.setFechaMedida(sdf.parse("2018/01/07 19:01:00"))
				.setPosicionAltitud(40)
				.setPosicionLatitud(latitud)
				.setPosicionLongitud(longitud)
				.build();
		motaContaminacionBasica.getPosicion().setLatitud((float )(motaContaminacionBasica.getPosicion().getLatitud()-(Math.random()/escala)));
		 motaContaminacionBasica.getPosicion().setLongitud((float )(motaContaminacionBasica.getPosicion().getLongitud()+(Math.random()/escala)));
		
		new MedidaMotaContaminacionBasicaBuilder(motaContaminacionBasica)
				.setFechaMedida(sdf.parse("2018/01/07 19:02:00"))
				.setLuminosidad(4000.323F)
				.setPm1(23)
				.setPm10(0)
				.setPm25(0)
				.setRuido(20)
				.setTemperatura(32.22F)
				.build();
		
		new MedidaMotaParkingBuilder(motaParking)
		.setFechaMedida(sdf.parse("2018/01/07 19:30:00"))
		.setOcupado(false);
		motaParking.getPosicion().setLatitud((float )(motaContaminacionBasica.getPosicion().getLatitud()-(Math.random()/escala)));
		
		 motaParking.getPosicion().setLongitud((float )(motaContaminacionBasica.getPosicion().getLongitud()+(Math.random()/escala)));
		

		List<Mota> motastmp = Arrays.asList(motaAguaBasica,motaContaminacionBasica,motaParking,motaGps);
		
		for (Mota mota : motastmp) {
			List<MedidaMota> medidas = mota.getMedidasMota();
			for (MedidaMota medidaMota : medidas) {
				medidaMota.getSensorGps().getPosicion().setLatitud((float )(medidaMota.getSensorGps().getPosicion().getLatitud()-(Math.random()/escala)));
				
				medidaMota.getSensorGps().getPosicion().setLongitud((float )(medidaMota.getSensorGps().getPosicion().getLongitud()+(Math.random()/escala)));
				
			}
			
		}
		
	     motaService.update(motaGps);
	     motaService.update(motaParking);
	     motaService.update(motaAguaBasica);
	     motaService.update(motaContaminacionBasica);
	 }
   
}