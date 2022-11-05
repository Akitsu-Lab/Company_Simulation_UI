package com.akitsulab.company_simulation_ui.controller;

import com.akitsulab.company_simulation_ui.dao.EmployeeDao;
import com.akitsulab.company_simulation_ui.domain.EmployeeList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ui/employee")
public class UiEmployeeController {
    private final EmployeeDao employeeDao;

    public UiEmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("list")
    public String list(Model model){
        EmployeeList employeeList = this.employeeDao.find();
        // Thymeleafのテンプレートに渡すデータをemployeeListというキーで登録
        model.addAttribute("employeeList",employeeList);
        return "employee/list";
    }
        
}
