package com.isi.ImpotRegaluation.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Declaration {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		private String titreDeclaration;
	    private LocalDate dateDeclaration;
	    private double montantDeclaration;
	    @ManyToOne
	    @JoinColumn(name = "id_declarant")
	    private Declarant declarant;
	    
	    // Relation OneToMany avec Paiement
	    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL)
	    private Set<Paiement> paiements = new HashSet<>();
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getTitreDeclaration() {
			return titreDeclaration;
		}
		public void setTitreDeclaration(String titreDeclaration) {
			this.titreDeclaration = titreDeclaration;
		}
		public Set<Paiement> getPaiements() {
			return paiements;
		}
		public void setPaiements(Set<Paiement> paiements) {
			this.paiements = paiements;
		}
		public LocalDate getDateDeclaration() {
			return dateDeclaration;
		}
		public void setDateDeclaration(LocalDate dateDeclaration) {
			this.dateDeclaration = dateDeclaration;
		}
		public double getMontantDeclaration() {
			return montantDeclaration;
		}
		public void setMontantDeclaration(double montantDeclaration) {
			this.montantDeclaration = montantDeclaration;
		}
		public Declarant getDeclarant() {
			return declarant;
		}
		public void setDeclarant(Declarant declarant) {
			this.declarant = declarant;
		}
	 
}
