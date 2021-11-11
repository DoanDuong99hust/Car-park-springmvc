package com.dspringmvc.controller.employee.api;

import com.dspringmvc.dto.EmployeeDTO;
import com.dspringmvc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "employeeApi")
public class EmployeeApi {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/api/employee")
    public EmployeeDTO create(@RequestBody EmployeeDTO employeeDTO) {
        return iEmployeeService.save(employeeDTO);
    }

    @PutMapping("/api/employee")
    public EmployeeDTO update(@RequestBody EmployeeDTO updateEmployeeDTO) {
        return iEmployeeService.save(updateEmployeeDTO);
    }

    @DeleteMapping("/api/employee")
    public void delete(@RequestBody long[] ids) {
        iEmployeeService.delete(ids);
    }
}
