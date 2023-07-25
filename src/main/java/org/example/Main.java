package org.example;

import org.example.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<Employee> loadData(){
        List<Employee> employees = Arrays.asList(
                new Employee("Joydeep","Architect",45,180,"New York"),
                new Employee("Bimolesh","Architect",49,200,"San Francisco"),
                new Employee("Avishek","Senior",35,120,"New York"),
                new Employee("Amitava","Mid",33,100,"San Francisco"),
                new Employee("Anirban","Jounior",30,90,"New York"),
                new Employee("Loknath","Jounior",27,90,"New York")
        );
        return employees;
    }
    public static void main(String[] args) {

        List<Employee> employees = loadData();

        // height salary of the employee
        Long max = employees.stream().map(e -> e.getSalary()).max(Long::compare).get();
        System.out.println("height salary of the employee is : " + max);

        // name of the employee get max salary
        System.out.println("----------------------------------------------------------------------->");
        Stream<String> maxSalaryWithName = employees.stream().filter(e -> e.getSalary() == max).map(Employee::getName);
        maxSalaryWithName.forEach( e-> System.out.println("Name of employee has max salary : " + e));

        System.out.println("----------------------------------------------------------------------->");
        // lowest salary of the employee
        Long min = employees.stream().map(e -> e.getSalary()).min(Long::compare).get();
        System.out.println("lowest salary of the employee is :" + min);

        System.out.println("----------------------------------------------------------------------->");
        //Employees get more than 100 salary
        List<Employee> employeeMoreThan100 = employees.stream().filter(e -> e.getSalary() > 100).collect(Collectors.toList());
        System.out.println("Employees get more than 100 salary :-> ");
        employeeMoreThan100.stream().forEach(e-> System.out.println("Employee Name " + e.getName() + " Salary : " + e.getSalary() ));

        System.out.println("----------------------------------------------------------------------->");
        // 2nd highest salary
        Long secoundHighestSalary = employees.stream().map(e -> e.getSalary()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("2nd highest salary : " + secoundHighestSalary);

        System.out.println("----------------------------------------------------------------------->");
        // count how many employee present each group
        Map<String, Long> employeeCountEachGroup = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        employeeCountEachGroup.forEach((group,count) -> System.out.println(group + ":" + count));

        System.out.println("----------------------------------------------------------------------->");
        // name of employees in each group
        Map<String, List<String>> employeeInfoEachGroup = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        employeeInfoEachGroup.forEach((group, name) -> System.out.println(group + ":" + name));

        System.out.println("----------------------------------------------------------------------->");
        // average salary of employees
        Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Averege salary of employees : " + averageSalary);

        System.out.println("----------------------------------------------------------------------->");
        // average salary department wish
        Map<String, Double> averageSalaryDepartmentWish = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        averageSalaryDepartmentWish.forEach((dept,avg) -> System.out.println(dept + ":" + avg));

        System.out.println("----------------------------------------------------------------------->");
        // department wish sum salary
        Map<String, Double> sumSalaryDepartmentWish = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        sumSalaryDepartmentWish.forEach((dept, sum) -> System.out.println(dept + ":" + sum));

        System.out.println("----------------------------------------------------------------------->");
        Map<String, Map<String, Double>> sumSalaryDepartmentAndCityWish = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getCity, Collectors.summingDouble(Employee::getSalary))));
        sumSalaryDepartmentAndCityWish.forEach((dept, citySal) -> {
            System.out.println("--> Department : " + dept);
            citySal.forEach((city,sal) -> System.out.println("city : " + city +" : " + " sumSalary : " + sal ));
        });
    }
}