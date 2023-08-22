package com.isi.ImpotRegaluation.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.isi.ImpotRegaluation.dao.IDeclaration;
import com.isi.ImpotRegaluation.entities.Declaration;

@Controller
public class DeclarationController {
	
	 // Injection des dépendances pour le repository
	 private final IDeclaration iDeclaration;
	    @Autowired
	    public DeclarationController(IDeclaration iDeclaration) {
	        this.iDeclaration = iDeclaration;
	    }
	    
	    // Endpoints pour ajouter et lister des déclarations 
	    @GetMapping("/api/declarations/add")
	    public String showAddDeclarationForm(Declaration declaration) {
	        return "add-declaration";
	    }

	    @PostMapping("/api/declarations/add")
	    public String addDeclaration(@Validated Declaration declaration, BindingResult result) {
	        if (result.hasErrors()) {
	            return "add-declaration";
	        }
	        iDeclaration.save(declaration);
	        return "redirect:/api/declarations/list";
	    }

	    @GetMapping("/api/declarations/list")
	    public String listDeclarations(Model model) {
	        List<Declaration> declarations = iDeclaration.findAll();
	        model.addAttribute("declarations", declarations);
	        return "list-declarations";
	    }
	    
	    @GetMapping("/api/declarations/edit/{id}")
	    public String showEditDeclarationForm(@PathVariable Long id, Model model) {
	        Declaration declaration = iDeclaration.findById(id).orElse(null);
	        if (declaration == null) {
	            // Gérer le cas où l'ID de la déclaration n'est pas trouvé
	        }
	        model.addAttribute("declaration", declaration);
	        return "edit-declaration";
	    }

	    @PostMapping("/api/declarations/edit/{id}")
	    public String updateDeclaration(@PathVariable Long id, @Validated Declaration declaration, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit-declaration";
	        }
	        declaration.setId(id); // S'assurer de definir l'ID pour la mise à jour
	        iDeclaration.save(declaration);
	        return "redirect:/api/declarations/list";
	    	}
	    
	    @GetMapping("/api/declarations/delete/{id}")
	    public String deleteDeclaration(@PathVariable Long id) {
	        iDeclaration.deleteById(id);
	        return "redirect:/api/declarations/list";
	    }
	}
