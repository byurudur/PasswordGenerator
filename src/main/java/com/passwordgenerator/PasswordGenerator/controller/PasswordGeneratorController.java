package com.passwordgenerator.PasswordGenerator.controller;
import com.passwordgenerator.PasswordGenerator.service.PasswordGeneratorService;
// import com.passwordgenerator.service.PasswordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordGeneratorController {
    @Autowired
    private PasswordGeneratorService passwordGeneratorService;

    @GetMapping("/")
    public String showForm() {
        return "passwordForm";

    }


    @PostMapping("/generate")
    public String generatePassword(@RequestParam("length") int length,
                                   @RequestParam(value = "useUppercase", required = false) boolean useUppercase,
                                   @RequestParam(value = "useLowercase", required = false) boolean useLowercase,
                                   @RequestParam(value = "useSpecialChars", required = false) boolean useSpecialChars,
                                   Model model) {
        String password = passwordGeneratorService.generatePassword(length, useUppercase, useLowercase, useSpecialChars);
        model.addAttribute("password", password);
        return "result";
    }

}
