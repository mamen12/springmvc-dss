package com.dss.thymeleaf.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.common.beans.beans.EmployeeRequest;
import com.api.common.beans.beans.EmployeeResponse;
import com.api.common.beans.beans.Request;
import com.api.common.beans.constant.utils.UrlFormatter;


@Service
public class EmployeeService {
	
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Value("${api.protocol}")
	private String http;
	
	@Value("${api.url.employee}")
	private String host;
	
	@Value("${api.url.employee.port}")
	private String port;
	
	@Value("${api.url.employee.path.list}")
	private String pathListEmployee;
	
	@Value("${api.url.employee.path.save}")
	private String pathSaveEmployee;
	
	@Value("${api.url.employee.path.detail}")
	private String pathDetailEmployee;

	
	@Value("${api.url.employee.path.update}")
	private String pathUpdateEmployee;
	
	@Value("${api.url.employee.path.delete}")
	private String pathDeleteEmployee;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<EmployeeResponse> listEmployee(){
		Request<EmployeeRequest> rq = new Request<EmployeeRequest>();
		
		String url = UrlFormatter.formatUrl(http, host, port, pathListEmployee);
		EmployeeResponse[] emplo = restTemplate.postForObject(url, rq, EmployeeResponse[].class);
		List<EmployeeResponse> list = Arrays.asList(emplo);
		return list;
	}
	
	
	public String saveEmployee(EmployeeRequest request) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Request<EmployeeRequest> rq = new Request<EmployeeRequest>();
		request.setTglLahir(sdf.parse(request.getTglLahirWeb()));
		rq.setRequestPayload(request);
		String url = UrlFormatter.formatUrl(http, host, port, pathSaveEmployee);
		String rs = restTemplate.postForObject(url, rq, String.class);
		return rs;
	}


	public EmployeeResponse getEmployeeById(long id) {
		Request<EmployeeRequest> rq = new Request<EmployeeRequest>();
		
		EmployeeRequest rqEmployee = new EmployeeRequest();
		rqEmployee.setId(id);
		rq.setRequestPayload(rqEmployee);
		
		String url = UrlFormatter.formatUrl(http, host, port, pathDetailEmployee);
		EmployeeResponse emplo = restTemplate.postForObject(url, rq, EmployeeResponse.class);
		return emplo;
	}
	
	public String deleteEmployeId(long id) {
		Request<EmployeeRequest> rq = new Request<EmployeeRequest>();
		
		EmployeeRequest rqEmployee = new EmployeeRequest();
		rqEmployee.setId(id);
		rq.setRequestPayload(rqEmployee);
		
		String url = UrlFormatter.formatUrl(http, host, port, pathDeleteEmployee);
		String rs = restTemplate.postForObject(url, rq, String.class);
		return rs;
	}
	

	public String updateEmployee(EmployeeRequest request) throws ParseException {
		Request<EmployeeRequest> rq = new Request<EmployeeRequest>();
		rq.setRequestPayload(request);
		String url = UrlFormatter.formatUrl(http, host, port, pathUpdateEmployee);
		String rs = restTemplate.postForObject(url, rq, String.class);
		return rs;
	}
	
	
	
}
