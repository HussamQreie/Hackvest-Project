package com.hackfest.controller;

import com.hackfest.entity.User;
import com.hackfest.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserRepository userRepo;

    public AdminController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/manage")
    public String manage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null || !"admin".equals(user.getRole())) return "redirect:/login";
        model.addAttribute("users", userRepo.findAll());
        return "admin/manage";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam String username, @RequestParam String password, 
                            @RequestParam String name, @RequestParam String email) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // Plain text vuln
        newUser.setRole("student");
        newUser.setName(name);
        newUser.setEmail(email);
        userRepo.save(newUser); // CSRF vuln (no token)
        return "redirect:/admin/manage";
    }
}