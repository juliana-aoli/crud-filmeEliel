package com.filme.demo.repository;

import com.filme.demo.model.FilmeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository  extends JpaRepository<FilmeModel, Long> {

}