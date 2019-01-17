package com.aytocartagena.util;

import java.util.Arrays;
import java.util.List;

public class Constantes {
	public static final  String PREFIJO_TABLAS="app_";
	public static class TiposMota{
		public static final String AGUA_BASICA="agua_basica";
		public static final String CONTAMINACION_BASICA="contaminacion_basica";
		public static final String GPS="gps";
		public static final String PARKING="parking";
		public static final  List<String> TIPOS_MOTA= Arrays.asList(AGUA_BASICA,CONTAMINACION_BASICA,GPS,PARKING);
	}
}
