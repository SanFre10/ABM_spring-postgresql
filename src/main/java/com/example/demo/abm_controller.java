package com.example.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.json.*;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class abm_controller {
    @Autowired
    private personaRepository personaRepo;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("personas", personaRepo.findAllByOrderByIdAsc());
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        Persona p = new Persona(json.getString("nombre"), json.getString("apellido"), json.getString("telefono"),
                json.getString("email"));

        if (json.has("id"))
            p.setId(json.getInt("id"));

        personaRepo.save(p);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        personaRepo.deleteById(id);
        return "redirect:/";
    }
}