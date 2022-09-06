package it.thundyy.caching.listener;

import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import it.thundyy.caching.employee.Employee;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PrintSomethingRemovalListener implements RemovalListener<Long, Employee> {
    
    @Override
    public void onRemoval(@Nullable Long aLong, @Nullable Employee s, RemovalCause removalCause) {
        System.out.println("Removed employee with personalId: " + aLong);
        System.out.println("Role: " + s.role());
    }
}
