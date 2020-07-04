package com.api.model;

public class Employee {
	
	public Integer id;
    public String employee_name;
    public Integer employee_salary;
    public Integer employee_age;
    public String profile_image;
	
	public Employee(int id,String employee_name,int employee_salary,int employee_age,String profile_image) {
		this.id = id;
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_age = employee_age;
		this.profile_image = profile_image;
	}
	
	public Employee(String employee_name,int employee_salary,int employee_age,String profile_image) {
		this.employee_name = employee_name;
		this.employee_salary = employee_salary;
		this.employee_age = employee_age;
		this.profile_image = profile_image;
	}
}
