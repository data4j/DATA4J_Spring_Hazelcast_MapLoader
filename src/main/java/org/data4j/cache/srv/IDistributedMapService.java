package org.data4j.cache.srv;

import org.data4j.entity.Customer;

import com.hazelcast.core.IMap;

/**
 * A new IDistributedMapService Interface is created for service layer to expose cache functionality.
 *  
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public interface IDistributedMapService {

	/**
     * Adds Customer entries to customerMap
     *
     * @param Customer customer
     * @return boolean the result of operation
     * 
     */
	void addToDistributedMap(Customer customer);

	/**
     * Removes Customer entries from customerMap
     *
     * @param Customer customer
     * @return boolean the result of operation
     * 
     */
	void removeFromDistributedMap(Customer customer);

	/**
     * Gets Customer Map
     *
     * @return IMap customerMap
     */
	IMap<String, Customer> getCustomerMap();
}
