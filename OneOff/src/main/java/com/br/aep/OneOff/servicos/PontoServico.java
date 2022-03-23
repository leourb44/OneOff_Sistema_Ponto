package com.br.aep.OneOff.servicos;

import com.br.aep.OneOff.entities.Ponto;
import com.br.aep.OneOff.exception.PontoException;

public interface PontoServico {

		
		
		public Ponto buscaPorId(final Long id);

		public Ponto atualizarPonto(Ponto ponto) throws PontoException;
		
		public Ponto savePonto(Ponto ponto) throws PontoException;

	
}
