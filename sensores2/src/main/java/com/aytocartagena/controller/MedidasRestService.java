package com.aytocartagena.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.model.medidas.MedidaMota;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.service.MedidaMotaService;
import com.aytocartagena.service.MotaService;

@RestController
@RequestMapping("/api")
public class MedidasRestService {
	 
	 @Autowired(required = true)
	 @Qualifier("motaServiceImpl") 
	private MotaService motaService;
	 
	 @Autowired(required = true)
	 @Qualifier("medidaMotaServiceImpl") 
	private MedidaMotaService medidaMotaService;
	 
	 
	@GetMapping(value="/medidas/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public MedidaMota getMedidaMota(@PathVariable int id) {
		MedidaMota medidaMota = medidaMotaService.get(id);
		medidaMota.setIdMota(null);
		return medidaMota;
    }
	@GetMapping(value="/medidas2/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public MedidaMotaDto getMedidaMotaDto(@PathVariable int id) {
		MedidaMota medidaMota = medidaMotaService.get(id);
		medidaMota.setIdMota(null);
		MedidaMotaDto dto=new MedidaMotaDto(medidaMota);
		dto.setTextoMedidaHtml(null);
		return dto;
    }
	@GetMapping(value="/medidas", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<MedidaMota> getMedidasMotaAll() {
		List<MedidaMota> medidasMota = medidaMotaService.getAll();
		sustituirMotaPorId(medidasMota);
		return medidasMota;
    }
	@GetMapping(value={ "/medidas/desde/{desde}/hasta/{hasta}/{tipo}","/medidas/desde/{desde}/hasta/{hasta}" },  produces=MediaType.APPLICATION_JSON_VALUE)
    public List<MedidaMota> getMedidaMota(@PathVariable String desde,@PathVariable String hasta,@PathVariable Optional<String> tipo) {
		List<MedidaMota> medidas = medidaMotaService.getMedidasMotaByFechaYTipo(desde, hasta, tipo.orElse(""));
		 sustituirMotaPorId(medidas);
		return medidas;
    }

	@PostMapping(path="/medidas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> nuevaMedidaMota(@RequestBody List< MedidaMotaDto> medidaMotas) {
		List<Integer> ids=new ArrayList<Integer>();
		for (MedidaMotaDto medidaMota : medidaMotas) {
			Mota mota = motaService.getMota(medidaMota.getIdMota());
			MedidaMota medida = medidaMota.buildMedidaMota(mota);
			medidaMotaService.add(medida);
			ids.add(medida.getIdMedida());
		}
		 return ids;
	}
	
	@DeleteMapping("/medidas/{id}")
	public void eliminarMedidaMota(@PathVariable Integer id) {
		MedidaMota medidaMota = medidaMotaService.get(id);
		medidaMotaService.remove(medidaMota);
	}
	
	private void sustituirMotaPorId(List<MedidaMota> medidas) {
		for (MedidaMota medidaMota : medidas) {
			medidaMota.setIdMota(medidaMota.getIdMota());
			medidaMota.anularMota();
		}
	}
}
