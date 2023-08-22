package com.isi.ImpotRegaluation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isi.ImpotRegaluation.entities.Paiement;

@Repository
public interface IPaiement extends JpaRepository<Paiement, Long>{

}
