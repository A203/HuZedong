package coreJava;

import java.util.Date;
import java.util.GregorianCalendar;

public class EmployeeTest {
	public static void main(String[] args) {
		// fill the staff array three Employee objects
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		for (Employee e : staff)
			e.raiseSalary(5);

		for (Employee e : staff)
			System.out.println("name = " + e.getName() + ",salary="
					+ e.getSalary() + ",hireDay=" + e.getHireDay());
	}
}

class Employee {
	private String name;
	private double salary;
	private Date hireDay;

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}
}