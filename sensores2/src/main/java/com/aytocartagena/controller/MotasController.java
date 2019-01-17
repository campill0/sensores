package com.aytocartagena.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aytocartagena.controller.dto.MedidaMotaDto;
import com.aytocartagena.controller.dto.MotaDto;
import com.aytocartagena.model.medidas.MedidaMota;
import com.aytocartagena.model.motas.Mota;
import com.aytocartagena.service.MedidaMotaService;
import com.aytocartagena.service.MotaService;
import com.aytocartagena.service.UsuarioService;
import com.aytocartagena.util.Constantes;
 
@Controller
public class MotasController {
	
	@Autowired(required = true)
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;

	@Autowired(required = true)
	@Qualifier("motaServiceImpl")
	private MotaService motaService;

	@Autowired(required = true)
	@Qualifier("medidaMotaServiceImpl")
	private MedidaMotaService medidaMotaService;

	@ModelAttribute("motaDto")
	public MotaDto getMotaDto() {
		return new MotaDto();
	}
	
	
	
	  @RequestMapping(value = { "/auth/privado/medidas" }, method = RequestMethod.GET)
	    public String medidas(Model model)  {
	        model.addAttribute("titulo", "Mediciones");
	        model.addAttribute("subtitulo", "Mediciones");
	        List<MedidaMota> medidas = medidaMotaService.getAll();
	        List<MedidaMotaDto> medidaMotaDto= new ArrayList<MedidaMotaDto>();
	        for (MedidaMota medida : medidas) {
	        	medidaMotaDto.add(new MedidaMotaDto(medida));
			}
	        model.addAttribute("medidasMotasDto", medidaMotaDto);
	        return "medidas";
	    }
    @RequestMapping(value = { "/auth/privado/motas" }, method = RequestMethod.GET)
    public String motas(Model model)  {
        model.addAttribute("titulo", "Motas");
        model.addAttribute("subtitulo", "");
        List<Mota> motas = motaService.getAll();
        List<MotaDto> motasDto= new ArrayList<MotaDto>();
        for (Mota mota : motas) {
			motasDto.add(new MotaDto(mota));
		}
        //Java 8 lambdas
        motasDto.sort(new Comparator<MotaDto>() {
    		@Override
    		public int compare(MotaDto o1, MotaDto o2) {
    			return o2.getIdMota() - o1.getIdMota();
    		}
    	});	
        model.addAttribute("motas", motasDto);
        return "motas";
    }
    
    @RequestMapping(value = { "/auth/privado/motas/guardar" }, method = RequestMethod.POST)
    public String motaGuardar(Model model, @ModelAttribute("motaDto") MotaDto motaDto)  {
    	model.addAttribute("editar",true);
    	Mota mota= null;
    	if(motaDto.getIdMota()>0) {
    		 mota = motaService.get(motaDto.getIdMota());
    		mota.setPropiedadesMota(motaDto);
    		motaService.update(mota);
    	}else {
    		 mota= motaDto.buildMota();
    		 mota.setIdMota(null);
    		motaService.add(mota);
    	}
    	return motaEditar(model,mota.getIdMota());
    }
    @InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
		}
    
    @RequestMapping(value = { "/auth/privado/motas/nueva" }, method = RequestMethod.GET)
    public String motaNueva(Model model)  {
    	MotaDto motaDto=new MotaDto();
    	motaDto.setIdMota(0);
    	List<String> tiposMota = Constantes.TiposMota.TIPOS_MOTA;
    	model.addAttribute("tiposMota",tiposMota);
    	model.addAttribute("motaDto",motaDto);
    	model.addAttribute("editar", true);
    	model.addAttribute("nueva", true);
    	model.addAttribute("titulo", "Motas");
    	model.addAttribute("subtitulo", "Nueva Mota");
        return "motasDetalle";
    }
    
    @RequestMapping(value = { "/auth/privado/motas/editar/{id}" }, method = RequestMethod.GET)
    public String motaEditar(Model model, @PathVariable Integer id)  {
    	List<String> tiposMota = Constantes.TiposMota.TIPOS_MOTA;
    	model.addAttribute("tiposMota",tiposMota);
    	Mota mota = motaService.getMota(id);
    	MotaDto motaDto=new MotaDto(mota);
    	 List<MedidaMotaDto> medidasMotasDto= new ArrayList<MedidaMotaDto>();
         for (MedidaMota medidaMota : mota.getMedidasMota()) {
         	medidasMotasDto.add(new MedidaMotaDto(medidaMota));
 		}
         model.addAttribute("medidasMotasDto", medidasMotasDto);
    	model.addAttribute("motaDto",motaDto);
    	model.addAttribute("editar", true);
    	model.addAttribute("titulo", "Motas");
    	model.addAttribute("subtitulo", "Editar Mota ("+ mota.getIdMota()+")");
        
        return "motasDetalle";
    }
    
    
    @RequestMapping(value = { "/auth/privado/motas/ver/{id}" }, method = RequestMethod.GET)
    public String motaDetalle(Model model, @PathVariable Integer id)  {
    	List<String> tiposMota = Constantes.TiposMota.TIPOS_MOTA;
    	model.addAttribute("tiposMota",tiposMota);
        model.addAttribute("titulo", "Motas");
        Mota mota = motaService.getMota(id);
        List<MedidaMotaDto> medidasMotasDto= new ArrayList<MedidaMotaDto>();
        for (MedidaMota medidaMota : mota.getMedidasMota()) {
        	medidasMotasDto.add(new MedidaMotaDto(medidaMota));
		}
        model.addAttribute("medidasMotasDto", medidasMotasDto);
        MotaDto motaDto=new MotaDto(mota);
        model.addAttribute("subtitulo", "Detalle Mota ("+ mota.getIdMota()+")");
        model.addAttribute("motaDto", motaDto);
        return "motasDetalle";
    }
    
    @RequestMapping(value = { "/auth/privado/motas/eliminar/{id}" }, method = RequestMethod.GET)
    public String motaEliminar(Model model, @PathVariable Integer id)  {
        model.addAttribute("titulo", "Motas");
        Mota mota = motaService.get(id);
        motaService.remove(mota);
        return "redirect:/auth/privado/motas";
    }
   
}