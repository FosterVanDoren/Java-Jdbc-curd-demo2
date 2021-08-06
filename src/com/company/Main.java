package com.company;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//	    //write the data you want to insert here

        EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDao();

        boolean flag = true;
        while(flag) {
            System.out.println();
            System.out.println("Welcome, please select an option from below");
            System.out.println("1. Add an employee");
            System.out.println("2. Update an employee's information");
            System.out.println("3. Delete an employee");
            System.out.println("4. Print a list of all employees");
            System.out.println("5. Find an employee based on their id");
            System.out.println("6. Exit");
            System.out.println();

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1: {
                    //add employee to the database
                    System.out.print("Please enter the employee's name: ");
                    String name = scan.next();
                    System.out.print("Please enter the employee's email: ");
                    String email = scan.next();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    dao.addEmployee(employee);
                    break;
                }
                case 2: {
                    //update an employee in the database
                    Employee employee = new Employee();
                    System.out.print("Please enter the employee's name: ");
                    String name = scan.next();
                    employee.setName(name);
                    System.out.print("Please enter the employee's email: ");
                    String email = scan.next();
                    employee.setEmail(email);
                    System.out.print("Please enter the employee's id: ");
                    int id = scan.nextInt();
                    employee.setId(id);
                    dao.updateEmployee(employee);

                    break;
                }
                case 3: {
                    //delete an employee from the database
                    System.out.print("Please enter the id of the employee that you would like to delete: ");
                    int id = scan.nextInt();
                    dao.deleteEmployee(id);
                    break;
                }
                case 4: {
                    //get all the employees in the database
                    List<Employee> employees = dao.getEmployees();
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;
                }
                case 5: {
                    //get
                    System.out.print("Please enter the id of the employee you want to find: ");
                    int id = scan.nextInt();
                    Employee employee = new Employee();
                    employee = dao.employeeById(id);
                    System.out.println(employee);
                    break;
                }
                case 6: {
                    //exit the system
                    System.out.println("Goodbye.");
                    System.out.println("Terminating program....");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("That is not of options listed. Please enter a valid option.");
                    System.out.println();

            }
        }

    }
}
