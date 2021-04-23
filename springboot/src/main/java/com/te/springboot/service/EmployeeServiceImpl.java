package com.te.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.bean.EmployeeBean;
import com.te.springboot.dao.EmployeeDao;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao employee;
	
	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return employee.getEmployee(id);
	}

	@Override
	public boolean deleteEmpData(int id) {
		// TODO Auto-generated method stub
		return employee.deleteEmpData(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {
		// TODO Auto-generated method stub
		return employee.getAllEmp();
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return employee.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return employee.updateEmployee(bean);
	}

}
