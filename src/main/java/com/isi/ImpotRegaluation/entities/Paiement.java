package com.isi.ImpotRegaluation.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Paiement {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private LocalDate datePaiement;
	    private double montantPaiement;
	    @ManyToOne
	    @JoinColumn(name = "id_declaration")
	    private Declaration declaration;
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public LocalDate getDatePaiement() {
			return datePaiement;
		}
		public void setDatePaiement(LocalDate datePaiement) {
			this.datePaiement = datePaiement;
		}
		public double getMontantPaiement() {
			return montantPaiement;
		}
		public void setMontantPaiement(double montantPaiement) {
			this.montantPaiement = montantPaiement;
		}
		public Declaration getDeclaration() {
			return declaration;
		}
		public void setDeclaration(Declaration declaration) {
			this.declaration = declaration;
		}
	    
}
