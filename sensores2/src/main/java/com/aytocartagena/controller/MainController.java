package com.aytocartagena.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MainController {
    
    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String welcomePage(Model model)  {
        model.addAttribute("titulo", "Cartagena Smart City - Central de datos");
        model.addAttribute("subtitulo", "Bienvenido");
    
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("titulo", "Logout");
        model.addAttribute("subtitulo", "Sesión cerrada correctamente.");
        return "index";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
    	model.addAttribute("titulo", "Acceso denegado.");
        if (principal != null) {
            model.addAttribute("mensaje", "Hola " + principal.getName()
                    + "<br> No tienes permiso para acceder a esta página!");
        } else {
            model.addAttribute("mensaje",
                    "No tienes permiso para acceder a esta página!");
        }
        return "403Page";
    }
  
	private boolean hasRole(String role) {
		 Collection<? extends org.springframework.security.core.GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		 boolean hasRole = false;
		  for (org.springframework.security.core.GrantedAuthority authority : authorities) {
		     hasRole = authority.getAuthority().equals(role);
		     if (hasRole) {
			  break;
		     }
		  }
		  return hasRole;
		} 
}