package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

    private EmployeeRepository eRepo = new EmployeeRepository();

    @GetMapping("/addEmployee")
    public String addEmploye(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(HttpServletRequest request){
        String name = request.getParameter("name");
        Employee emp = new Employee(name);
        eRepo.create(emp);

        return "redirect:/";
    }




}
