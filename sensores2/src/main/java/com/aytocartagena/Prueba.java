package com.aytocartagena;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

public class Prueba {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/dd hh:mm:ss");
		
		// Se registran las motas
		MotaGps motaGps= new MotaGpsBuilder()
				.setDescripcion("Grua municipal vehículo nº 23")
				.setFabricante("Garming").setModelo("Gps traccker for Iot")
				.setNumInventario(1)
				.setUrlFichaProductoFabricante("http://www.garming.com/iotproduct.jsp?productid=23")
				.build();
		MotaContaminacionBasica motaContaminacionBasica = new MotaContaminacionBasicaBuilder()
				.setDescripcion("Mota Ficus Plaza San Francisco")
				.setFabricante("Libellium").setModelo("polutionsensor2000")
				.setNumInventario(2)
				.setUrlFichaProductoFabricante("http://www.libellium.com/product.jsp?productid=23")
				.setPosicionAltitud(40).setPosicionLatitud(37.1F).setPosicionLongitud(-0.965F)
				.setUltimaRevision(sdf.parse("2018/01/01 14:00:00")).setNotasRevision("Revisión inicial realizada por M.Pujante. Todo correcto.").build();
		MotaParking motaParking= new MotaParkingBuilder()
				.setDescripcion("Mota aparcamiento Calle San Miguel plaza nº1")
				.setFabricante("Libellium").setModelo("SmartParking134")
				.setNumInventario(3)
				.setUrlFichaProductoFabricante("http://www.libellium.com/product.jsp?productid=23")
				.setPosicionAltitud(40).setPosicionLatitud(37.63328F).setPosicionLongitud(-0.9322917F)
				.setDireccionCalle("Calle San Miguel")
				.setDireccionCodPostal("30201")
				.setDireccionNumero("1 - 10")
				.build();
		MotaAguaBasica motaAguaBasica = new MotaAguaBasicaBuilder()
				.setDescripcion("Mota de control de la calidad del agua en playa Cala Cortina ")
				.setFabricante("Libellium").setModelo("SmartWaterBasic")
				.setNumInventario(4)
				.setUrlFichaProductoFabricante("http://www.libellium.com/iotproduct.jsp?productid=23")
				.setPosicionAltitud(40).setPosicionLatitud(37.600638F).setPosicionLongitud(-0.984917F)
				.setLugar("playa cala cortina")
				.build();
		
		// Una vez registradas los datos recogidos por los sensores van llegando ...
		
		new MedidaMotaGpsBuilder(motaGps)
				.setFechaMedida(sdf.parse("2018/01/07 18:59:00"))
				.setPosicionAltitud(40).setPosicionLatitud(37.600638F).setPosicionLongitud(-0.984917F)
				.build();
		new MedidaMotaGpsBuilder(motaGps)
				.setFechaMedida(sdf.parse("2018/01/07 19:01:00"))
				.setPosicionAltitud(40).setPosicionLatitud(37.60100F).setPosicionLongitud(-0.98500F)
				.build();
		
		 new MedidaMotaContaminacionBasicaBuilder(motaContaminacionBasica)
				.setFechaMedida(sdf.parse("2018/01/07 19:02:00"))
				.setLuminosidad(4000.323F)
				.setPm1(23)
				.setPm10(0)
				.setPm25(0)
				.setRuido(20)
				.setTemperatura(32.22F)
				.setPosicionAltitud(40)
				.setPosicionLatitud(37.600638F)
				.setPosicionLongitud(-0.984917F)
				.build();
		 new MedidaMotaContaminacionBasicaBuilder(motaContaminacionBasica)
				.setFechaMedida(sdf.parse("2018/01/07 19:29:30"))
				.setLuminosidad(4000.323F)
				.setPm1(23)
				.setPm10(5)
				.setPm25(10)
				.setRuido(20)
				.setTemperatura(31.22F)
				.setPosicionAltitud(40)
				.setPosicionLatitud(37.600638F)
				.setPosicionLongitud(-0.984917F)
				.build();
		 
		 new MedidaMotaParkingBuilder(motaParking)
		 .setFechaMedida(sdf.parse("2018/01/07 19:30:00"))
		 .setOcupado(false);
		 new MedidaMotaParkingBuilder(motaParking)
		 .setFechaMedida(sdf.parse("2018/01/07 19:31:00"))
		 .setOcupado(true);
		 new MedidaMotaParkingBuilder(motaParking)
		 .setFechaMedida(sdf.parse("2018/01/07 19:32:00"))
		 .setOcupado(true);
		 
		 new MedidaMotaAguaBasicaBuilder(motaAguaBasica)
		 .setFechaMedida(sdf.parse("2018/01/07 19:33:00"))
		 .setConductividad(1.4F)
		 .setOrp(2)
		 .setPh(4.5F)
		 .setTemperaturaAgua(13.5F)
		 .setTurbidez(23)
		 .setPosicionAltitud(40)
		 .setPosicionLatitud(37.600638F)
		 .setPosicionLongitud(-0.984917F)
		 .build();
		 
		 List<Mota> motas= Arrays.asList(motaGps,motaContaminacionBasica,motaParking,motaAguaBasica);
		 for (Mota mota : motas) {
			System.out.println(mota);
			
		}
		

	}

}
