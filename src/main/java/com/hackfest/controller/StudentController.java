package com.hackfest.controller;

import com.hackfest.entity.User;
import com.hackfest.repository.EnrollmentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final EnrollmentRepository enrollmentRepo;

    public StudentController(EnrollmentRepository enrollmentRepo) {
        this.enrollmentRepo = enrollmentRepo;
    }

    @GetMapping("/profile")
    public String profile(@RequestParam(required = false) Long id, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) return "redirect:/login";
        Long userId = id != null ? id : user.getId(); // IDOR vuln intentional
        model.addAttribute("user", user); // Use session user directly
        model.addAttribute("enrollments", enrollmentRepo.findByStudentId(userId)); // Fetch enrollments
        return "student/profile";
    }
}