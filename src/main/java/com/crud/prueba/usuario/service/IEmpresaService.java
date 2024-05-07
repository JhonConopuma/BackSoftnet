package com.crud.prueba.usuario.service;

import com.crud.prueba.usuario.model.Empresa;
import com.crud.prueba.usuario.model.Usuario;

import java.util.List;

public interface IEmpresaService {
    public List<Empresa> findAll();
    public List<Empresa> findById(int COD_EMPRESA,int COD_USUARIO);
    public int save(Empresa empresa);
    public int update(Empresa empresa);
    public int delete(int COD_EMPRESA,int COD_USUARIO);
}
