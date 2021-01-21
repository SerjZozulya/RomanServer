package ru.zozulyasv.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "action", required = false) String action,
                            Model model) {
        double answer;
        String actionSymbol;

        switch (action) {
            case "multiplication":
                actionSymbol = "*";
                answer = a * b;
                break;
            case "addition":
                actionSymbol = "+";
                answer = a + b;
                break;
            case "subtraction":
                actionSymbol = "-";
                answer = a - b;
                break;
            case "division":
                actionSymbol = "/";
                answer = a / (double)b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }

        if (action != null) {
            model.addAttribute("answer", "Requested: "
                    + a + " "
                    + actionSymbol + " "
                    + b + " "
                    + "Answer: " +
                    answer);
        }
        else  model.addAttribute("answer", "error");
        
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return  "first/goodbye";
    }
}
