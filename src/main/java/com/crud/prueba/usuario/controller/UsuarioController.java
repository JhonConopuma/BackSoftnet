package com.crud.prueba.usuario.controller;


import com.crud.prueba.usuario.model.ServiceResponse;
import com.crud.prueba.usuario.model.Usuario;
import com.crud.prueba.usuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> list(){
        var result =iUsuarioService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/list/{COD_USUARIO}")
    public ResponseEntity<List<Usuario>> listId(@PathVariable int COD_USUARIO){
        var result =iUsuarioService.findById(COD_USUARIO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse>  save(@RequestBody Usuario usuario) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iUsuarioService.save(usuario);
        if (result == 1) {
            serviceResponse.setMessage("Usuario creado corretamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse>  update(@RequestBody Usuario usuario) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iUsuarioService.update(usuario);
        if (result == 1) {
            serviceResponse.setMessage("Usuario actualizado corretamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{COD_USUARIO}")
    public ResponseEntity<ServiceResponse>  update(@PathVariable int COD_USUARIO) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iUsuarioService.delete(COD_USUARIO);
        if (result == 1) {
            serviceResponse.setMessage("Usuario eliminado corretamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }


}
