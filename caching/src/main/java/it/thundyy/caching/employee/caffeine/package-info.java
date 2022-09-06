/**
 * An implementation of an Employee caching system using the Caffeine caching library.
 *
 * Uses the {@link com.github.benmanes.caffeine.cache.LoadingCache} interface to cache the employees and to eventually
 * retrieve some not already cached data from the database (in-memory) {@link it.thundyy.caching.database.MemoryDatabase}.
 */
package it.thundyy.caching.employee.caffeine;