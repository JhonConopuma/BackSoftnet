package com.crud.prueba.usuario.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Usuario {
    @NonNull
    int COD_USUARIO;
    String TIP_DOCUMENT;
    String VAR_DOC_IDENTIDAD;
    String VAR_APELLIDOS;
    String VAR_NOMBRES;
    String VAR_PASSWORD;
    String VAR_NUM_TELEFONO;
    int INT_FLG_ELIMINADO;
    Date FEC_REGISTRO;
    Date FEC_MODIFICACION;

    // Constructor sin argumentos
    public Usuario() {
        // Este constructor está vacío
    }
}
