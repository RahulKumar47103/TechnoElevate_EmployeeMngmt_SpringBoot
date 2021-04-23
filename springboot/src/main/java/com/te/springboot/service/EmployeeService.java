package com.te.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.te.springboot.bean.EmployeeBean;

@Service
public interface EmployeeService {

	public EmployeeBean getEmployee(int id);

	public boolean deleteEmpData(int id);

	public List<EmployeeBean> getAllEmp();

	public boolean addEmployee(EmployeeBean bean);

	public boolean updateEmployee(EmployeeBean bean);
}
