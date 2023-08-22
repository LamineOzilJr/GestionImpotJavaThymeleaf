package com.isi.ImpotRegaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.ImpotRegaluation.entities.Declaration;

@Repository
public interface IDeclaration  extends JpaRepository<Declaration, Long> {

}
