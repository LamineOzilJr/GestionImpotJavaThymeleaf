package com.isi.impotregaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.impotregaluation.entities.Declaration;

@Repository
public interface IDeclaration  extends JpaRepository<Declaration, Long> {

}
