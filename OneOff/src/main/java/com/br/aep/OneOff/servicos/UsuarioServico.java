package com.br.aep.OneOff.servicos;

import com.br.aep.OneOff.entities.Usuario;

public interface UsuarioServico {

		
		public Usuario deletar(final Long cpf );
		
		public Usuario buscaPorId(final Long cpf);

		public Usuario atualizarUsuario(Usuario user) throws Exception;
		
		public Usuario saveUser(Usuario user) throws Exception;

	
}
