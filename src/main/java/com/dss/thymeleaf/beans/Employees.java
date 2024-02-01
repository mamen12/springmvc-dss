package com.dss.thymeleaf.beans;

import java.util.ArrayList;
import java.util.List;

import com.api.common.beans.beans.EmployeeResponse;

public class Employees {
	
	private List<EmployeeResponse> listEmployees;
	
	public Employees() {
		listEmployees = new ArrayList<>();
	}
	
	public List<EmployeeResponse> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(List<EmployeeResponse> listEmployees) {
		this.listEmployees = listEmployees;
	}
	
	
}
