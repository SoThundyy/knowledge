package it.thundyy.caching.employee;

import it.thundyy.caching.database.MemoryDatabase;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class EmployeeManagerOperation {
    private static final String[] POSSIBLE_NAMES = {"John", "Paul", "George", "Ringo", "Pete", "Stuart", "Mick", "Keith", "Ronnie", "Charlie"};
    private static final String[] POSSIBLE_ROLES = {"Developer", "Tester", "Manager", "CEO", "CTO", "CFO", "CIO", "COO", "CDO", "CPO"};
    private static final int[] POSSIBLE_AGES = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    private static final Random LOCAL_RANDOM = ThreadLocalRandom.current();
    
    private final MemoryDatabase database;
    
    protected EmployeeManagerOperation(MemoryDatabase database) {
        this.database = database;
    }
    
    
    public String getRandomName() {
        return POSSIBLE_NAMES[LOCAL_RANDOM.nextInt(POSSIBLE_NAMES.length)];
    }
    
    public String getRandomRole() {
        return POSSIBLE_ROLES[LOCAL_RANDOM.nextInt(POSSIBLE_ROLES.length)];
    }
    
    public int getRandomAge() {
        return POSSIBLE_AGES[LOCAL_RANDOM.nextInt(POSSIBLE_AGES.length)];
    }
    
    public MemoryDatabase getDatabase() {
        return database;
    }
}
