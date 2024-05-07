package com.crud.prueba.usuario.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Empresa {
    @NonNull
    int COD_EMPRESA;
    @NonNull
    int COD_USUARIO;
    String VAR_CARGO;
    String VAR_COREO;
    int INT_ESTADO;
    String VAR_NOM_IMAGEN;
    int INT_FLG_ELIMINADO;
    Date FEC_REGISTRO;
    Date FEC_MODIFICACION;

    // Constructor sin argumentos
    public Empresa() {
        // Este constructor está vacío
    }
}
