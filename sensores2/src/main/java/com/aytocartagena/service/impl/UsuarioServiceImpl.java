package com.aytocartagena.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.aytocartagena.dao.GenericDao;
import com.aytocartagena.dao.UsuarioDao;
import com.aytocartagena.model.Usuario;
import com.aytocartagena.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer>
        implements UsuarioService {

	   private UsuarioDao usuarioDao;
	    public UsuarioServiceImpl(){

	    }
	    @Autowired
	    public UsuarioServiceImpl(
	            @Qualifier("usuarioDaoImpl") GenericDao<Usuario, Integer> genericDao) {
	        super(genericDao);
	        this.usuarioDao = (UsuarioDao) genericDao;
	    }
}
