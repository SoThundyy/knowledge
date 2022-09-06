package it.thundyy.caching.database;

import it.thundyy.caching.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple in-memory database that stores the employees in a list.
 */
public class MemoryDatabase {
    private final List<Employee> employees = new ArrayList<>(); // The list of employees
    
    public void add(Employee employee) {
        employees.add(employee);
    }
    
    // Returns the employee with the given personalId opening a stream (not the best for performance)
    public Employee getEmployee(Long personalId) {
        return employees.stream()
                .filter(employee -> Objects.equals(employee.personalId(), personalId))
                .findFirst()
                .orElse(null);
    }
    
    public void removeEmployee(Long personalId) {
        employees.removeIf(employee -> Objects.equals(employee.personalId(), personalId));
    }
}
