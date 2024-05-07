package com.crud.prueba.usuario.repository;

import com.crud.prueba.usuario.model.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    public List<Usuario> findAll();
    public List<Usuario> findById(int COD_USUARIO);
    public int save(Usuario usuario);
    public int update(Usuario usuario);
    public int delete(int COD_USUARIO);
}
