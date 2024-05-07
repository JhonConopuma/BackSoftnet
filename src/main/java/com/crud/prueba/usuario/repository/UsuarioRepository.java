package com.crud.prueba.usuario.repository;

import com.crud.prueba.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository implements IUsuarioRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Usuario> findAll() {
        String SQL = "SELECT * FROM MAE_USUARIO WHERE INT_FLG_ELIMINADO = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Usuario.class));
    }

    @Override
    public List<Usuario> findById(int COD_USUARIO) {
        String SQL = "SELECT * FROM MAE_USUARIO WHERE INT_FLG_ELIMINADO = 1 AND COD_USUARIO =?";
        return jdbcTemplate.query(SQL, new Object[]{COD_USUARIO}, BeanPropertyRowMapper.newInstance(Usuario.class));
    }

    @Override
    public int save(Usuario usuario) {
        String SQL = "INSERT INTO MAE_USUARIO VALUES(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{usuario.getTIP_DOCUMENT(), usuario.getVAR_DOC_IDENTIDAD(), usuario.getVAR_APELLIDOS(), usuario.getVAR_NOMBRES(), usuario.getVAR_PASSWORD(), usuario.getVAR_NUM_TELEFONO(), usuario.getINT_FLG_ELIMINADO(), usuario.getFEC_REGISTRO(), usuario.getFEC_MODIFICACION()});
    }

    @Override
    public int update(Usuario usuario) {
        String SQL = "UPDATE MAE_USUARIO SET TIP_DOCUMENT =?, VAR_DOC_IDENTIDAD =?, VAR_APELLIDOS =?, VAR_NOMBRES =?, VAR_PASSWORD =?, VAR_NUM_TELEFONO =?, INT_FLG_ELIMINADO =?, FEC_REGISTRO =?, FEC_MODIFICACION =?  WHERE COD_USUARIO =?";
        return jdbcTemplate.update(SQL, new Object[]{usuario.getTIP_DOCUMENT(), usuario.getVAR_DOC_IDENTIDAD(), usuario.getVAR_APELLIDOS(), usuario.getVAR_NOMBRES(), usuario.getVAR_PASSWORD(), usuario.getVAR_NUM_TELEFONO(), usuario.getINT_FLG_ELIMINADO(), usuario.getFEC_REGISTRO(), usuario.getFEC_MODIFICACION(), usuario.getCOD_USUARIO()});
    }

    @Override
    public int delete(int COD_USUARIO) {
        String SQL = "UPDATE MAE_USUARIO SET INT_FLG_ELIMINADO = 0  WHERE COD_USUARIO =?";
        return jdbcTemplate.update(SQL, new Object[]{COD_USUARIO});
    }
}
