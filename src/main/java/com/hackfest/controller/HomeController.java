package com.hackfest.controller;

import com.hackfest.entity.User;
import com.hackfest.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final UserRepository userRepo;

    public HomeController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
    User user = userRepo.findByUsernameAndPassword(username, password); // SQL Injection vuln
    if (user != null) {
        session.setAttribute("user", user);
        return "redirect:/dashboard";
    }
    model.addAttribute("error", "Invalid username or password");
    return "login"; // Return the login template with an error message
}

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        String role = user.getRole();
        if ("admin".equals(role)) {
            return "redirect:/admin/manage";
        } else {
            return "redirect:/student/profile";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}