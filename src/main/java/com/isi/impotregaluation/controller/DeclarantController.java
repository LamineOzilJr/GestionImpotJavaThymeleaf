package com.isi.impotregaluation.controller;

import java.util.List;  
import java.util.String;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.isi.impotregaluation.dao.IDeclarant;
import com.isi.impotregaluation.entities.Declarant;


@Controller
public class DeclarantController {
	
	 // Injection des dépendances pour le repository
	 private final IDeclarant iDeclarant;
	 private final String listdeclarantendpoint = "redirect:/api/declarants/list";
	 
	 @Autowired
	    public DeclarantController(IDeclarant iDeclarant) {
	        this.iDeclarant = iDeclarant;
	    }
	 
	 // Endpoints pour ajouter et lister des déclarants
	 	@GetMapping("/api/declarants/add")
	    public String showAddDeclarantForm(Declarant declarant) {
	        return "add-declarant";
	    }

	    @PostMapping("/api/declarants/add")
	    public String addDeclarant(@Validated Declarant declarant, BindingResult result) {
	        if (result.hasErrors()) {
	            return "add-declarant";
	        }
	        iDeclarant.save(declarant);
	        return listdeclarantendpoint;
	    }

	    @GetMapping("/api/declarants/list")
	    public String listDeclarants(Model model) {
	        List<Declarant> declarants = iDeclarant.findAll();
	        model.addAttribute("declarants", declarants);
	        return "list-declarants";
	    }
	    
	    @GetMapping("/api/declarants/edit/{id}")
	    public String showEditDeclarantForm(@PathVariable Long id, Model model) {
	        Declarant declarant = iDeclarant.findById(id).orElse(null);
	        if (declarant == null) {
	            // Gérer le cas où l'ID du déclarant n'est pas trouvé
	        }
	        model.addAttribute("declarant", declarant);
	        return "edit-declarant";
	    }

	    @PostMapping("/api/declarants/edit/{id}")
	    public String updateDeclarant(@PathVariable Long id, @Validated @ModelAttribute("declarant") Declarant declarant, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit-declarant";
	        }
	        iDeclarant.save(declarant);
	        return listdeclarantendpoint;
	    }
	    
	    @GetMapping("/api/declarants/delete/{id}")
	    public String deleteDeclarant(@PathVariable Long id) {
	        iDeclarant.deleteById(id);
	        return listdeclarantendpoint;
	    }


}
