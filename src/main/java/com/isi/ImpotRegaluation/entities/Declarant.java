package com.isi.ImpotRegaluation.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Declarant {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String raisonSociale;
	    private String adresse;
	    private String email;
	    private String telephone;
	    
	    // Relation OneToMany avec Declaration
	    @OneToMany(mappedBy = "declarant", cascade = CascadeType.ALL)
	    private Set<Declaration> declarations = new HashSet<>();
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		public Set<Declaration> getDeclarations() {
			return declarations;
		}
		public void setDeclarations(Set<Declaration> declarations) {
			this.declarations = declarations;
		}
		public String getRaisonSociale() {
			return raisonSociale;
		}
		public void setRaisonSociale(String raisonSociale) {
			this.raisonSociale = raisonSociale;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

}
