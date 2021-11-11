package com.dspringmvc.converter;

import com.dspringmvc.dto.EmployeeDTO;
import com.dspringmvc.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDTO toDto(EmployeeEntity employeeEntity) {
        EmployeeDTO results = new EmployeeDTO();
        results.setEmployeeId(employeeEntity.getEmployeeId());
        results.setAccount(employeeEntity.getAccount());
        results.setDepartment(employeeEntity.getDepartment());
        results.setEmployeeAddress(employeeEntity.getEmployeeAddress());
        results.setEmployeeBirthday(employeeEntity.getEmployeeBirthday());
        results.setEmployeeEmail(employeeEntity.getEmployeeEmail());
        results.setEmployeeName(employeeEntity.getEmployeeName());
        results.setEmployeePhone(employeeEntity.getEmployeePhone());
        results.setPassword(employeeEntity.getPassword());
        results.setSex(employeeEntity.getSex());
        return results;
    }

    public EmployeeEntity toEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity results = new EmployeeEntity();
        results.setAccount(employeeDTO.getAccount());
        results.setDepartment(employeeDTO.getDepartment());
        results.setEmployeeAddress(employeeDTO.getEmployeeAddress());
        results.setEmployeeBirthday(employeeDTO.getEmployeeBirthday());
        results.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        results.setEmployeeName(employeeDTO.getEmployeeName());
        results.setEmployeePhone(employeeDTO.getEmployeePhone());
        results.setPassword(employeeDTO.getPassword());
        results.setSex(employeeDTO.getSex());
        return results;
    }

    public EmployeeEntity toEntity(EmployeeEntity results, EmployeeDTO employeeDTO) {
        results.setAccount(employeeDTO.getAccount());
        results.setDepartment(employeeDTO.getDepartment());
        results.setEmployeeAddress(employeeDTO.getEmployeeAddress());
        results.setEmployeeBirthday(employeeDTO.getEmployeeBirthday());
        results.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        results.setEmployeeName(employeeDTO.getEmployeeName());
        results.setEmployeePhone(employeeDTO.getEmployeePhone());
        results.setPassword(employeeDTO.getPassword());
        results.setSex(employeeDTO.getSex());
        return results;
    }
}
