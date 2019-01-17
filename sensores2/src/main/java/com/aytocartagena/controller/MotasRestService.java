package com.aytocartagena.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.model.motas.MotaAguaBasica;
import com.aytocartagena.model.motas.MotaContaminacionBasica;
import com.aytocartagena.model.motas.MotaGps;
import com.aytocartagena.model.motas.MotaParking;
import com.aytocartagena.service.MotaService;

@RestController
@RequestMapping("/api")
public class MotasRestService {
	 
	 @Autowired(required = true)
	 @Qualifier("motaServiceImpl") 
	private MotaService motaService;
	 
	@GetMapping(value="/motas/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public Mota getMota(@PathVariable int id) {
		return motaService.getMota(id);
    }
	@GetMapping(value="/motas", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Mota> getMotasAll() {
		List<Mota> motas = motaService.getAll();
		//medidasMota no ha sido precargado por lo que si lo devolvemos dará error
		//así que las medidas de las motas las vamos a establecer a null
		//se devolverán todos los campos excepto medidasMota
		for (Mota mota : motas) {
			mota.setMedidasMota(null);
		}
		return motas;
    }
	
	@PostMapping(path="/motas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	Integer nuevaMota(@RequestBody MotaGps mota) {
		motaService.add(mota);
		 return mota.getIdMota();
	}
	
	/*
	@PutMapping("/motas/{id}")
	Mota actualizarMota(@RequestBody Mota nuevaMota, @PathVariable Integer id) {
		nuevaMota.setIdMota(id);
		 motaService.update(nuevaMota);
		 return nuevaMota;
	}
	
	@PostMapping(path="/motas", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	String nuevaMota(@RequestBody Mota mota) {
		motaService.add(mota);
		 return "ok";
	}
	*/
	
	@PostMapping(path="/motas/motaguabasica", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	Integer nuevaMota(@RequestBody MotaAguaBasica mota) {
		motaService.add(mota);
		 return mota.getIdMota();
	}
	@PostMapping(path="/motas/motacontaminacionbasica", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	void nuevaMota(@RequestBody MotaContaminacionBasica mota) {
		motaService.add(mota);
	}
	@PostMapping(path="/motas/motaparking", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	void nuevaMota(@RequestBody MotaParking mota) {
		motaService.add(mota);
	}
	@PutMapping("/motas/motagps/{id}")
	void actualizarMota(@RequestBody MotaGps nuevaMota, @PathVariable Integer id) {
		nuevaMota.setIdMota(id);
		 motaService.update(nuevaMota);
	}
	@PutMapping("/motas/motaaguabasica/{id}")
	void actualizarMota(@RequestBody MotaAguaBasica nuevaMota, @PathVariable Integer id) {
		nuevaMota.setIdMota(id);
		 motaService.update(nuevaMota);
	}
	@PutMapping("/motas/motacontaminacionbasica/{id}")
	void actualizarMota(@RequestBody MotaContaminacionBasica nuevaMota, @PathVariable Integer id) {
		nuevaMota.setIdMota(id);
		 motaService.update(nuevaMota);
	}
	@PutMapping("/motas/motaparking/{id}")
	void actualizarMota(@RequestBody MotaParking nuevaMota, @PathVariable Integer id) {
		nuevaMota.setIdMota(id);
		 motaService.update(nuevaMota);
	}
	
	@DeleteMapping("/motas/{id}")
	void eliminarMota(@PathVariable Integer id) {
		Mota mota = motaService.get(id);
		motaService.remove(mota);
	}
}
