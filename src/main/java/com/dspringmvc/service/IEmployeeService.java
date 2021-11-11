package com.dspringmvc.service;

import com.dspringmvc.dto.EmployeeDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
	EmployeeDTO save(EmployeeDTO employee);
	void delete(long[] ids);
	List<EmployeeDTO> findAll(Pageable pageble);
	List<EmployeeDTO> findAll();
	int getTotalItem();
	EmployeeDTO findOne(long id);
}
