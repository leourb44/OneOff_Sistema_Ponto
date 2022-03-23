package com.br.aep.OneOff.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.aep.OneOff.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
