package it.thundyy.caching.employee.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import it.thundyy.caching.database.MemoryDatabase;
import it.thundyy.caching.employee.Employee;
import it.thundyy.caching.listener.PrintSomethingRemovalListener;
import it.thundyy.caching.employee.EmployeeManagerOperation;

import java.util.concurrent.TimeUnit;

public class CaffeineEmployeeManager extends EmployeeManagerOperation {
    
    private final LoadingCache<Long, Employee> employeeCache = Caffeine.newBuilder()
            .maximumSize(100) // The maximum number of entries the cache may contain
            .expireAfterAccess(3L, TimeUnit.SECONDS) // The maximum time after an entry is last accessed before it is considered expired
            .removalListener(new PrintSomethingRemovalListener()) // A listener that is invoked when an entry is removed
            .build(this::retrieveFromDatabase); // The function that retrieves the data from the database
    
    public CaffeineEmployeeManager(MemoryDatabase database) {
        super(database);
    }
    
    /**
     * Retrieves the employee with the given personalId from the cache.
     * @param personalId The personalId of the employee to retrieve.
     * @return The employee with the given personalId.
     */
    public Employee retrieveFromDatabase(Long personalId) {
        return getDatabase().getEmployee(personalId);
    }
    
    /**
     * Adds a new employee to the cache, getting some random parameters from the arrays in {@link EmployeeManagerOperation}.
     * @param personalId The personalId of the employee to add.
     */
    public void add(Long personalId) {
        Employee employee = new Employee(personalId, getRandomName(), getRandomAge(), getRandomRole());
        employeeCache.put(personalId, employee);
        System.out.println("Added employee with name: " + employee.name());
    }
    
    /**
     * Gets the employee with the given personalId from the cache.
     * @param personalId The personalId of the employee to get.
     * @return The employee with the given personalId.
     */
    public Employee getEmployee(Long personalId) {
        return employeeCache.get(personalId);
    }
    
    public void removeEmployee(Long personalId) {
        employeeCache.invalidate(personalId);
    }
    
}
