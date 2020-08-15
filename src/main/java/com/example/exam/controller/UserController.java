package com.example.exam.controller;

import com.example.exam.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal){
        var user = userService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }

    @PostMapping("/register")
    public String registerPage(@RequestParam("name")String name, @RequestParam("email")String email, @RequestParam("login")String login,
                               @RequestParam("password")String password, Model model, HttpSession session, Principal principal) {

        userService.register(name, email, login, password);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        return "register";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}
