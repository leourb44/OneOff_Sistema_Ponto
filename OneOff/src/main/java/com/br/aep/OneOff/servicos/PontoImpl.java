package com.br.aep.OneOff.servicos;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.br.aep.OneOff.entities.Ponto;
import com.br.aep.OneOff.entities.Usuario;
import com.br.aep.OneOff.exception.PontoException;
import com.br.aep.OneOff.exception.UsuarioException;
import com.br.aep.OneOff.repositorio.PontoRepositorio;

public class PontoImpl implements PontoServico {
	
public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";
	
	public static final String MESSAGE_ERROR_PONTO_NOT_FOUND = "Ponto nao encontrado, tente novamente.";
	
	public static final String MESSAGE_ERROR_REGISTER_PONTO = "Erro ao salvar, tente novamente!";
	
	@Autowired
	private PontoRepositorio pontoRepositorio;
	
	@Autowired
	private PontoServico pontoServico;
	
	private ModelMapper mapper;



	@Override
	public Ponto buscaPorId(Long id) {
		try {
			Optional<Ponto> pontoOptional = this.pontoRepositorio.findById(id);
			if (pontoOptional.isPresent()) {
				return this.mapper.map(pontoOptional.get(), Ponto.class);
			}
			throw new PontoException(MESSAGE_ERROR_PONTO_NOT_FOUND, HttpStatus.NOT_FOUND);
		} catch (PontoException m) {
			throw m;
		} catch (Exception e) {
			throw new PontoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Ponto atualizarPonto(Ponto ponto) throws PontoException {
		
		try {
			Ponto newPonto = new Ponto ();
			newPonto.setHorarioEntrada(ponto.getHorarioEntrada());
			newPonto.setHorarioSaida(ponto.getHorarioSaida());
			newPonto.setDdMmYyyy(ponto.getDdMmYyyy());
			return pontoRepositorio.save(newPonto);
		} catch (PontoException c) {
			throw new PontoException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public Ponto savePonto(Ponto ponto) throws PontoException {
		try {
		return pontoRepositorio.save(ponto);
		}catch (PontoException e) {
			throw new PontoException(MESSAGE_ERROR_REGISTER_PONTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
