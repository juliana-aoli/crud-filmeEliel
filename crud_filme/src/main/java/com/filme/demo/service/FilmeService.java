package com.filme.demo.service;

import com.filme.demo.model.FilmeModel;
import com.filme.demo.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    //buscar todos os filmes
    public List<FilmeModel> findAll(){
        return filmeRepository.findAll();
    }

    //buscar filme por Id
    public FilmeModel buscarPorId(Long id){
        return filmeRepository.findById(id).get();
    }

    //criar filme
    public FilmeModel criarFilme(FilmeModel filmeModel){
        return filmeRepository.save(filmeModel);
    }

    //deletar filme
    public void deletarFilme(Long id){
        filmeRepository.deleteById(id);
    }

    //atualizar filme
    public FilmeModel atualizar(Long id, FilmeModel filmeNew){
        FilmeModel filmeModel = filmeRepository.findById(id).get();
        filmeModel.setTitulo(filmeNew.getTitulo());
        filmeModel.setGenero(filmeNew.getGenero());
        filmeModel.setAno(filmeNew.getAno());

        return filmeRepository.save(filmeModel);
    }
}