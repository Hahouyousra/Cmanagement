package com.mcommande.commandewebapp.controller;


import com.mcommande.commandewebapp.model.Commande;
import com.mcommande.commandewebapp.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin("/**")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;


    @GetMapping("/")
    public String employees(Model model)
    {   Iterable<Commande> commandes = commandeService.getCommandes();
        model.addAttribute("commandes", commandes);
        return "home";  }


    @RequestMapping(value = "/deleteCommande/{id}",
            method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
    public String deleteEmployee(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        commandeService.daleteCommande(id);
        return "redirect:/";
    }

    @PostMapping("/saveCommande")
    public ModelAndView saveEmployee(@ModelAttribute Commande commande) {
        commandeService.saveCommande(commande);
        return new ModelAndView("redirect:/");
    }

    @GetMapping(value = "/updateCommande/{id}")
    public String updateEmployee(@PathVariable("employee") Commande commande, RedirectAttributes redirectAttributes) {
        commandeService.updateCommande(commande);
        return "formUpdateEmployee";
    }




}
