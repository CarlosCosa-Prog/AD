package com.dam2.demo.controlador;

import com.dam2.demo.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Página Principal");
        model.addAttribute("mensaje", "¡Bienvenido a mi aplicación web!");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("titulo", "Sobre nosotros");
        model.addAttribute("descripcion", "Aplicación creada con Spring Boot MVC");
        return "about";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Juan", "juan@email.com", 25),
                new Usuario("María", "maria@email.com", 30),
                new Usuario("Pedro", "pedro@email.com", 28)
        );
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }
}