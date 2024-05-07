package com.crud.prueba.usuario.service;

import com.crud.prueba.usuario.model.Empresa;
import com.crud.prueba.usuario.model.Usuario;
import com.crud.prueba.usuario.repository.IEmpresaRepository;
import com.crud.prueba.usuario.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    private IEmpresaRepository iEmpresaRepository;

    @Override
    public List<Empresa> findAll() {
        List<Empresa> list;
        try{
            list = iEmpresaRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public List<Empresa> findById(int COD_EMPRESA, int COD_USUARIO) {
        List<Empresa> list;
        try{
            list = iEmpresaRepository.findById(COD_EMPRESA, COD_USUARIO);
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Empresa empresa) {
        int row;
        try{
            row = iEmpresaRepository.save(empresa);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Empresa empresa) {
        int row;
        try{
            row = iEmpresaRepository.update(empresa);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(int COD_EMPRESA, int COD_USUARIO) {
        int row;
        try{
            row = iEmpresaRepository.delete(COD_EMPRESA, COD_USUARIO);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
