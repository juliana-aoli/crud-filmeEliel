package com.filme.demo.controller;

import com.filme.demo.model.FilmeModel;
import com.filme.demo.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeModel>> findAll(){
        List<FilmeModel> response = filmeService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeModel> buscarPorId(@PathVariable Long id){
        FilmeModel response = filmeService.buscarPorId(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<FilmeModel> criarFilme(@RequestBody FilmeModel filmeModel){
        FilmeModel response = filmeService.criarFilme(filmeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
        @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFilme(@PathVariable Long id){
        filmeService.deletarFilme(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeModel> atualizar(@PathVariable Long id, @RequestBody FilmeModel filmeModel){
        FilmeModel response = filmeService.atualizar(id, filmeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
