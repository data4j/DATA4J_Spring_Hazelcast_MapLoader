package org.data4j.customer.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.data4j.entity.Customer;
 
/**
 * Customer DAO Interface
 *
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public interface ICustomerDAO {
 
    /**
     * Adds Customer
     *
     * @param Customer customer
     */
    void addCustomer(Customer customer);
    
    /**
     * Adds Customers
     *
     * @param Map customerMap
     * 
     */
	void addCustomers(Map<String, Customer> customerMap);
	
    /**
     * Deletes Customer
     *
     * @param String id
     * 
     */
	void deleteCustomer(String id);
    
    /**
     * Gets Customer List
     *
     * @return List - Customer list
     */
    List<Customer> getCustomers();
 
    /**
     * Gets Customer
     * 
     * @param String id
     */
    Customer getCustomerById(String id);
    
    /**
     * Gets Customer Map
     *
     * @param  Collection<String> collection of keys 
     * @return Map<String, Customer> Customer Map
     */
    Map<String, Customer> getCustomerMap(Collection<String> idCol);
    
    /**
     * Get Customer Id Set
     *
     * @return Customer Id Set
     */
    Set<String> getCustomerIds();
}
