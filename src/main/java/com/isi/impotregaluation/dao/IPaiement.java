package com.isi.impotregaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.impotregaluation.entities.Paiement;

@Repository
public interface IPaiement extends JpaRepository<Paiement, Long>{

}
