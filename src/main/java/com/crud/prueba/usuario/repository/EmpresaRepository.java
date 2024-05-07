package com.crud.prueba.usuario.repository;

import com.crud.prueba.usuario.model.Empresa;
import com.crud.prueba.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpresaRepository implements IEmpresaRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Empresa> findAll() {
        String SQL = "SELECT * FROM DET_USUARIO_EMPRESA WHERE INT_FLG_ELIMINADO = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Empresa.class));
    }

    @Override
    public List<Empresa> findById(int COD_EMPRESA, int COD_USUARIO) {
        String SQL = "SELECT * FROM DET_USUARIO_EMPRESA WHERE INT_FLG_ELIMINADO = 1 AND COD_EMPRESA =? AND COD_USUARIO =?";
        return jdbcTemplate.query(SQL, new Object[]{COD_EMPRESA, COD_USUARIO}, BeanPropertyRowMapper.newInstance(Empresa.class));
    }

    @Override
    public int save(Empresa empresa) {
        String SQL = "INSERT INTO DET_USUARIO_EMPRESA VALUES(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{empresa.getCOD_EMPRESA(), empresa.getCOD_USUARIO(), empresa.getVAR_CARGO(), empresa.getVAR_COREO(), empresa.getINT_ESTADO(), empresa.getVAR_NOM_IMAGEN(), empresa.getINT_FLG_ELIMINADO(), empresa.getFEC_REGISTRO(), empresa.getFEC_MODIFICACION()});
    }

    @Override
    public int update(Empresa empresa) {
        String SQL = "UPDATE DET_USUARIO_EMPRESA SET VAR_CARGO =?, VAR_COREO =?, INT_ESTADO =?, VAR_NOM_IMAGEN =?, INT_FLG_ELIMINADO =?, FEC_REGISTRO =?, FEC_MODIFICACION =? WHERE COD_EMPRESA =? AND COD_USUARIO =?";
        return jdbcTemplate.update(SQL, new Object[]{empresa.getVAR_CARGO(), empresa.getVAR_COREO(), empresa.getINT_ESTADO(), empresa.getVAR_NOM_IMAGEN(), empresa.getINT_FLG_ELIMINADO(), empresa.getFEC_REGISTRO(), empresa.getFEC_MODIFICACION(),empresa.getCOD_EMPRESA(), empresa.getCOD_USUARIO()});
    }

    @Override
    public int delete(int COD_EMPRESA, int COD_USUARIO) {
        String SQL = "UPDATE DET_USUARIO_EMPRESA SET INT_FLG_ELIMINADO = 0  WHERE COD_EMPRESA =? AND COD_USUARIO =?";
        return jdbcTemplate.update(SQL, new Object[]{COD_EMPRESA, COD_USUARIO});
    }
}
