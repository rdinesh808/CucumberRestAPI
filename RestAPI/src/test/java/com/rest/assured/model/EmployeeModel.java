package com.rest.assured.model;

import java.util.Random;
import com.api.base.ApiBase;
import com.api.model.Employee;

public class EmployeeModel extends ApiBase {
	
	
	public Employee generatenewemployee(int id) {
		String name = fake.name().fullName();
		int min = 50000;
		int max = 90000;
		int salary = new Random().nextInt(max-min) + min;
		int age = fake.number().numberBetween(1, 80);
		String image = fake.beer().name().toString();
		return new Employee(id, name, salary, age, image);
	}
	
	public Employee updateexistingemployee(int id) {
		String name = fake.name().fullName();
		int min = 50000;
		int max = 90000;
		int salary = new Random().nextInt(max-min) + min;
		int age = fake.number().numberBetween(1, 80);
		String image = fake.beer().name().toString();
		return new Employee(name, salary, age, image);
	}

}
