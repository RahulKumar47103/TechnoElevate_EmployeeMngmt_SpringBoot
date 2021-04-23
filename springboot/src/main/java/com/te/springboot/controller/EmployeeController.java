package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.EmployeeBean;
import com.te.springboot.bean.EmployeeResp;
import com.te.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String firstHandlerMethod() {
		return "technoElevate";

	}

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmployeeResp getEmp(int id) {
		EmployeeResp response = new EmployeeResp();
		EmployeeBean bean = service.getEmployee(id);
		if (bean != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("data found for id:\"+id");
			response.setBean(bean);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("data not found for id:" + id);
		}
		return response;

	}

	@GetMapping(path = "/getAllEmp", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResp getAllEmp() {
		EmployeeResp response = new EmployeeResp();
		List<EmployeeBean> bean = service.getAllEmp();
		if (bean != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("data found ");
			response.setEmployeeBeans(bean);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("details not found");
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResp deleteEp(@PathVariable(name = "emp_id") int id) {
		EmployeeResp response = new EmployeeResp();
		if (service.deleteEmpData(id)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("data deleted for id: " + id);

		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("something went wrong");
		}
		return response;

	}

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResp addEmp(@RequestBody EmployeeBean bean) {
		EmployeeResp response = new EmployeeResp();
		if (service.addEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Data added Successfully");
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("something went wrong");
		}
		return response;

	}

	@GetMapping(path="update",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResp updateEmp(@RequestBody EmployeeBean bean) {
		EmployeeResp response = new EmployeeResp();
		if (service.updateEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Data updated Successfully");
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("something went wrong");
		}
		return response;
		
	}
}
