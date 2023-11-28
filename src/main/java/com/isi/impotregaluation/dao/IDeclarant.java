package com.isi.impotregaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.impotregaluation.entities.Declarant;

@Repository
public interface IDeclarant extends JpaRepository<Declarant, Long> {

}
