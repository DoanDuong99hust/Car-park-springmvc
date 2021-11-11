package com.dspringmvc.service.impl;

import com.dspringmvc.converter.EmployeeConverter;
import com.dspringmvc.dto.EmployeeDTO;
import com.dspringmvc.entity.EmployeeEntity;
import com.dspringmvc.repository.IEmployeeRepository;
import com.dspringmvc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Override
    @Transactional
    public EmployeeDTO save(EmployeeDTO employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        if (employee.getEmployeeId() != null) {
            EmployeeEntity oldEmployee = iEmployeeRepository.findOne(employee.getEmployeeId());
            employeeEntity = employeeConverter.toEntity(oldEmployee, employee);
        } else {
            employeeEntity = employeeConverter.toEntity(employee);
        }
        return employeeConverter.toDto(iEmployeeRepository.save(employeeEntity));
    }

    @Override
    @Transactional
    public void delete(long[] ids) {
        for (long id: ids) {
            iEmployeeRepository.delete(id);
        }
    }

    @Override
    public List<EmployeeDTO> findAll(Pageable pageble) {
        List<EmployeeDTO> models = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = iEmployeeRepository.findAll(pageble).getContent();
        for (EmployeeEntity employee: employeeEntityList
             ) {
            models.add(employeeConverter.toDto(employee));
        }
        return models;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeDTO> models = new ArrayList<>();
        List<EmployeeEntity> employeeEntityList = iEmployeeRepository.findAll();
        for (EmployeeEntity employee: employeeEntityList
             ) {
            models.add(employeeConverter.toDto(employee));
        }
        return models;
    }

    @Override
    public int getTotalItem() {
        return (int) iEmployeeRepository.count();
    }

    @Override
    public EmployeeDTO findOne(long id) {
        EmployeeEntity employeeEntity = iEmployeeRepository.findOne(id);
        return employeeConverter.toDto(employeeEntity);
    }
}
