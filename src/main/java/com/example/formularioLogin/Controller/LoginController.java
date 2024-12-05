/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.formularioLogin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 @Controller
public class LoginController {
    
    // Mostrar la página de login
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // Retorna la vista login.html
    }

    // Procesar el formulario de login
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Comprobamos las credenciales
        if ("admin".equals(username) && "admin".equals(password)) {
            return "redirect:/success"; // Redirigir a la página de éxito
        } else {
            model.addAttribute("error", "Credenciales incorrectas"); // Mensaje de error
            return "login"; // Volver al formulario de login
        }
    }

    // Página de éxito después de un login correcto
    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("message", "¡Te has logueado correctamente!");
        return "success"; // Retorna la vista success.html
    }
    
}
