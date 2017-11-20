package com.kpblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kpblogs.model.Employee;

@RestController
public class MainController {

	
    @RequestMapping("/getEmployee")
    public Employee getEmployee(@RequestParam(value="name", defaultValue="Khushvinder") String name) {
    	Employee employee = new Employee();
    	employee.seteName(name);
    	employee.setPhone("9810093311");
    	employee.setSalary(10000);
        return employee;
    }
}
