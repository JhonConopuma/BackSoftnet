package com.crud.prueba.usuario.controller;

import com.crud.prueba.usuario.model.Empresa;
import com.crud.prueba.usuario.model.ServiceResponse;
import com.crud.prueba.usuario.model.Usuario;
import com.crud.prueba.usuario.service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empresa")
@CrossOrigin("*")
public class EmpresaController {

    @Autowired
    private IEmpresaService iEmpresaService;

    @GetMapping("/list")
    public ResponseEntity<List<Empresa>> list(){
        var result =iEmpresaService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/list/{COD_EMPRESA}/{COD_USUARIO}")
    public ResponseEntity<List<Empresa>> listId(@PathVariable int COD_EMPRESA, @PathVariable int COD_USUARIO){
        var result =iEmpresaService.findById(COD_EMPRESA, COD_USUARIO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse>  save(@RequestBody Empresa empresa) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iEmpresaService.save(empresa);
        if (result == 1) {
            serviceResponse.setMessage("Empresa creada corretamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse>  update(@RequestBody Empresa empresa) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iEmpresaService.update(empresa);
        if (result == 1) {
            serviceResponse.setMessage("Empresa actualizado corretamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{COD_EMPRESA}/{COD_USUARIO}")
    public ResponseEntity<ServiceResponse>  update(@PathVariable int COD_EMPRESA, @PathVariable int COD_USUARIO) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iEmpresaService.delete(COD_EMPRESA, COD_USUARIO);
        if (result == 1) {
            serviceResponse.setMessage("Usuario eliminado corretamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

}
