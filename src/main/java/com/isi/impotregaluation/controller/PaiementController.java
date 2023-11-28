package com.isi.impotregaluation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.isi.impotregaluation.dao.IDeclaration;
import com.isi.impotregaluation.dao.IPaiement;
import com.isi.impotregaluation.entities.Declaration;
import com.isi.impotregaluation.entities.Paiement;

import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PaiementController {
	
	// Injection des dépendances pour le repository
	 private final IPaiement iPaiement;
	 private final IDeclaration iDeclaration;

	    @Autowired
	    public PaiementController(IPaiement iPaiement, IDeclaration iDeclaration) {
	        this.iPaiement = iPaiement;
	        this.iDeclaration = iDeclaration;
	    }

	    // Endpoints pour ajouter et lister des paiements
	    @GetMapping("/api/paiements/add")
	    public String showAddpaiementForm(@RequestParam("declarationId") Long declarationId, Paiement paiement, Model model) {
	        model.addAttribute("declarationId", declarationId);
	        return "add-paiement";
	    }

	    @PostMapping("/api/paiements/add")
	    public String addpaiement(@RequestParam("declarationId") Long declarationId, @Validated Paiement paiement, BindingResult result) {
	        if (result.hasErrors()) {
	            return "add-paiement";
	        }
	        //control du montant
	        Declaration declaration = iDeclaration.findById(declarationId).orElse(null);
//	        if (declaration == null) {
//	            // Gérer le cas où l'ID de la déclaration n'est pas trouvé
//	            return "add-paiement";
//	        }
//	        
//	        if (paiement.getMontantPaiement() != declaration.getMontantDeclaration()) {
//	            result.rejectValue("montantPaiement", "MontantNotMatch", "Le montant du paiement doit être égal au montant de la déclaration.");
//	            return "add-paiement";
//	        }
//	        Declaration declaration = paiement.getDeclaration();
//	        if (declaration == null) {
//	            // Gérer le cas où la déclaration associée est manquante
//	            return "add-paiement";
//	        }
//	        if (paiement.getMontantPaiement() != declaration.getMontantDeclaration()) {
//	            result.rejectValue("montantPaiement", "MontantNotMatch", "Le montant du paiement doit être égal au montant de la déclaration.");
//	            return "add-paiement";
//	        }
//	        
	        paiement.setDeclaration(declaration); // Associer la déclaration au paiement
	        iPaiement.save(paiement);
	        return "redirect:/api/paiements/list";
	    }

	    @GetMapping("/api/paiements/list")
	    public String listpaiements(Model model) {
	        List<Paiement> paiements = iPaiement.findAll();
	        model.addAttribute("paiements", paiements);
	        return "list-paiements";
	    }
	    
	    @GetMapping("/api/paiements/edit/{id}")
	    public String showEditPaiementForm(@PathVariable Long id, Model model) {
	        Paiement paiement = iPaiement.findById(id).orElse(null);
	        if (paiement == null) {
	            // Gérer le cas où l'ID du paiement n'est pas trouvé
	        }
	        model.addAttribute("paiement", paiement);
	        return "edit-paiement";
	    }

	    @PostMapping("/api/paiements/edit/{id}")
	    public String updatePaiement(@PathVariable Long id, @Validated Paiement paiement, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit-paiement";
	        }
	        //control du montant
	        Declaration declaration = paiement.getDeclaration();
//	        if (declaration == null) {
//	            // Gérer le cas où la déclaration associée est manquante
//	            return "edit-paiement";
//	        }
//	        
//	        if (paiement.getMontantPaiement() != declaration.getMontantDeclaration()) {
//	            result.rejectValue("montantPaiement", "MontantNotMatch", "Le montant du paiement doit être égal au montant de la déclaration.");
//	            return "edit-paiement";
//	        }
	        paiement.setDeclaration(declaration);
	        paiement.setId(id); // Assurez-vous de définir l'ID pour la mise à jour
	        iPaiement.save(paiement);
	        return "redirect:/api/paiements/list";
	    }
	    
	    @GetMapping("/api/paiements/delete/{id}")
	    public String deletePaiement(@PathVariable Long id) {
	        iPaiement.deleteById(id);
	        return "redirect:/api/paiements/list";
	    }
	    
	    //gestion des details
	    @GetMapping("/api/paiements/details/{id}")
	    public String paiementDetails(@PathVariable Long id, Model model) {
	        Paiement paiement = iPaiement.findById(id).orElse(null);
	        if (paiement == null) {
	            // Gérer le cas où l'ID du paiement n'est pas trouvé
	        	return "baaakoul dh";
	        }
	        model.addAttribute("paiement", paiement);
	        return "details-paiement";
	    }

}
