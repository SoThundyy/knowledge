package it.thundyy.caching;

import it.thundyy.caching.database.MemoryDatabase;
import it.thundyy.caching.employee.caffeine.CaffeineEmployeeManager;
import it.thundyy.caching.employee.Employee;

public class CachingMain {
    public static void main(String[] args) {
        MemoryDatabase database = new MemoryDatabase();
        database.add(new Employee(5L, "John", 25, "Developer"));
        database.add(new Employee(6L, "Jane", 30, "Developer"));
        
        CaffeineEmployeeManager manager = new CaffeineEmployeeManager(database);
        
        manager.add(1L);
        manager.add(2L);
        manager.add(3L);
        
        System.out.println(manager.getEmployee(1L));
        System.out.println(manager.getEmployee(5L));
        System.out.println(manager.getEmployee(6L));
        System.out.println(manager.getEmployee(7L));
    }
}