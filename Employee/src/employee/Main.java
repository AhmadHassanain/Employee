/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

/**
 *
 * @author ahmad
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main {
    
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How Many Employee youneed to add ?");
        int num=Integer.parseInt(JOptionPane.showInputDialog(null, "number of employee", "number", JOptionPane.INFORMATION_MESSAGE));
        Employee emps[] = new Employee[num];
        ReadByJOptionPane(emps);
        ShowInJOptionPane(emps);
        AddBonusToAll(emps, 15);
        ShowInCommandLine(emps);
        
        
    }
     private static void sortBySalary(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if (employees[j].getSalary() > employees[i].getSalary()) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    private static void sortByName(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                int compare = employees[j].getName().compareTo(employees[i].getName());
                if (compare < 0) {
                    Employee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
    }

    private static void ShowInCommandLine(Employee[] emps) {
        System.out.println("****************************");
        System.out.printf("%-9s%-15s%-13s\n", "Name", "Department", "Salary");
        for (Employee employee : emps) {
            System.out.printf("%-9s%-15s%-10.2f\n",
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getSalary());
        }
        System.out.println("Number Of Employee is : " + Employee.count);
    }

    private static void ShowInJOptionPane(Employee[] emps) {
        String output = "";
        int count = 0;
        for (Employee employee : emps) {
            count++;
            output += "Employee" + count + " : \n";
            output += "     Name : " + employee.getName() + "     \n";
            output += "     Department : " + employee.getDepartment() + "     \n";
            output += "     Salary : " + employee.getSalary() + "     \n";
            output += "----------\n";
        }
        output += "Number Of Employee is : " + Employee.count;
        JOptionPane.showMessageDialog(null, output);
    }

    private static void ReadByScanner(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter Data...");
            Employee emp = new Employee();

            //name input
            System.out.print("Enter the name : ");
            emp.setName(in.nextLine());
            //departnment input
            System.out.print("Enter the Department : ");
            emp.setDepartment(in.nextLine());
            //salary input
            System.out.print("Enter hte salary : ");
            emp.setSalary(Integer.parseInt(in.nextLine()));

            employees[i] = emp;
        }
    }

    private static void ReadByJOptionPane(Employee[] emps) {
        for (int i = 0; i < emps.length; i++) {
            System.out.println("Enter Data...");

            Employee emp = new Employee();
            //name input
            emp.setName(JOptionPane.
                    showInputDialog(null, "Name", "Employee", JOptionPane.INFORMATION_MESSAGE));
            //departnment input
            emp.setDepartment(JOptionPane.
                    showInputDialog(null, "Department", "Employee", JOptionPane.INFORMATION_MESSAGE));
            //salary input
            emp.setSalary(Integer.parseInt(JOptionPane.
                    showInputDialog(null, "Salary", "Employee", JOptionPane.INFORMATION_MESSAGE)));

            emps[i] = emp;
        }
    }

    private static void AddBonusToAll(Employee[] emps, double bonus) {
        for (int i = 0; i < emps.length; i++) {
            double salary = emps[i].getSalary();
            emps[i].setBounsSalary(salary, bonus);
        }
    }
    
}
