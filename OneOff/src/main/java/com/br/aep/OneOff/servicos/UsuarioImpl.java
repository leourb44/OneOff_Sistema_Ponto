package com.br.aep.OneOff.servicos;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.br.aep.OneOff.entities.Usuario;
import com.br.aep.OneOff.exception.UsuarioException;
import com.br.aep.OneOff.repositorio.UsuarioRepositorio;

public class UsuarioImpl implements UsuarioServico {
	
public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";
	
	public static final String MESSAGE_ERROR_DOADOR_NOT_FOUND = "Usuario nao encontrado, tente novamente.";
	
	public static final String MESSAGE_ERROR_REGISTER_USER = "Erro ao salvar, tenten novamente!";
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private UsuarioServico usuarioServico;
	
	private ModelMapper mapper;


	@Override
	public Usuario deletar(Long cpf) {
		try {
			this.buscaPorId(cpf);
			this.usuarioRepositorio.deleteById(cpf);
			return null;
						
		}catch (UsuarioException m) {
			throw new UsuarioException(MESSAGE_ERROR, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Usuario buscaPorId(Long cpf) {
		try {
			Optional<Usuario> usuarioOptional = this.usuarioRepositorio.findById(cpf);
			if (usuarioOptional.isPresent()) {
				return this.mapper.map(usuarioOptional.get(), Usuario.class);
			}
			throw new UsuarioException(MESSAGE_ERROR_DOADOR_NOT_FOUND, HttpStatus.NOT_FOUND);
		} catch (UsuarioException m) {
			throw m;
		} catch (Exception e) {
			throw new UsuarioException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Usuario atualizarUsuario(Usuario user) throws Exception {
		
		try {
			Usuario usuario = new Usuario ();
			usuario.setCpf(user.getCpf());
			usuario.setSenha(user.getSenha());
			return usuarioServico.saveUser(usuario);
		} catch (UsuarioException c) {
			throw new UsuarioException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Usuario saveUser(Usuario user) throws Exception {
		try {
		return usuarioRepositorio.save(user);
		}catch (UsuarioException e) {
			throw new UsuarioException(MESSAGE_ERROR_REGISTER_USER, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
