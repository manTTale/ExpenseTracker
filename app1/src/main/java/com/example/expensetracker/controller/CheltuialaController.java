package com.example.expensetracker.controller;

import com.example.expensetracker.model.CheltuialaModel;
import com.example.expensetracker.service.CheltuialaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheltuialaController {

    @Autowired
    private CheltuialaService cheltuialaService;

    @GetMapping("/")
    public String afiseazaHomePage(Model model){
        model.addAttribute("listCheltuiala", cheltuialaService.preiaToateCheltuielile());
        return "index";
    }
    @GetMapping("/formularCheltuiala")
    public String afiseazaFormularCheltuiala(Model model){
        CheltuialaModel cheltuiala = new CheltuialaModel();
        model.addAttribute("cheltuialaNoua",cheltuiala);
        return "formularCheltuiala";
    }

    @PostMapping("/creazaCheltuiala")
    public String creazaCheltuiala(@ModelAttribute("cheltuialaNoua") CheltuialaModel cheltuiala){
        cheltuialaService.creazaCheltuiala(cheltuiala);
        return "redirect:/";
    }

    @GetMapping("/formularModificareCheltuiala/{id}")
    public String afiseazaFormularModificareCheltuiala(@PathVariable (value="id") Integer id,Model model){
        CheltuialaModel cheltuialaNoua = cheltuialaService.preiaOCheltuiala(id);
        model.addAttribute("cheltuialaNoua",cheltuialaNoua);
        return "formularModificareCheltuiala";
    }

    @GetMapping("/stergeCheltuiala/{id}")
    public String stergeCheltuiala(@PathVariable (value="id") Integer id){
        this.cheltuialaService.stergeCheltuiala(id);
        return "redirect:/";
    }
}
