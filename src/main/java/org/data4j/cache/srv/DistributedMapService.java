package org.data4j.cache.srv;

import org.data4j.customer.listener.CustomerEntryListener;
import org.data4j.entity.Customer;

import com.hazelcast.core.IMap;

/**
 * DistributedMapService Class is implementation of IDistributedMapService Interface.
 * 
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public class DistributedMapService implements IDistributedMapService {
	
	private IMap<String, Customer> customerMap;

	/**
     * Constructor of DistributedMapService
     *
     * @param IMap customerMap
	 *
     */
	public DistributedMapService(IMap<String, Customer> customerMap) {
		setCustomerMap(customerMap);
		getCustomerMap().addEntryListener(new CustomerEntryListener(), true);		
	}
	
	/**
     * Adds Customer entries to customerMap
     *
     * @param Customer customer
     * @return boolean the result of operation
     * 
     */
	@Override
	public void addToDistributedMap(Customer customer) {
		getCustomerMap().put(customer.getId(), customer);
	}

	/**
     * Removes Customer entries from customerMap
     *
     * @param Customer customer
     * @return boolean the result of operation
     * 
     */
	@Override
	public void removeFromDistributedMap(Customer customer) {
		getCustomerMap().remove(customer.getId());
	}
	
	/**
     * Gets Customer Map
     *
     * @return IMap customerMap
     */
	
	public IMap<String, Customer> getCustomerMap() {
		return customerMap;
	}

	public void setCustomerMap(IMap<String, Customer> customerMap) {
		this.customerMap = customerMap;
	}
	
}