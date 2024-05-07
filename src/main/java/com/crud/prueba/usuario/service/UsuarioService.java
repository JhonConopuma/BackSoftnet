package com.crud.prueba.usuario.service;

import com.crud.prueba.usuario.model.Usuario;
import com.crud.prueba.usuario.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> list;
        try{
            list = iUsuarioRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public List<Usuario> findById(int COD_USUARIO) {
        List<Usuario> list;
        try{
            list = iUsuarioRepository.findById(COD_USUARIO);
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Usuario usuario) {
        int row;
        try{
            row = iUsuarioRepository.save(usuario);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Usuario usuario) {
        int row;
        try{
            row = iUsuarioRepository.update(usuario);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(int COD_USUARIO) {
        int row;
        try{
            row = iUsuarioRepository.delete(COD_USUARIO);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
