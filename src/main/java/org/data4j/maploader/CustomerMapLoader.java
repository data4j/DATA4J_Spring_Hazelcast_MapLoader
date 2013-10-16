package org.data4j.maploader;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.data4j.customer.dao.CustomerDAO;
import org.data4j.customer.dao.ICustomerDAO;
import org.data4j.entity.Customer;
import org.data4j.util.ApplicationContextUtil;

import com.hazelcast.core.MapLoader;

/**
 * CustomerMapLoader Class loads the cache that doesn't contain the value for the given key.
 * 
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public class CustomerMapLoader implements MapLoader<String, Customer> {

	private static final Logger logger = Logger.getLogger(CustomerMapLoader.class);
		
	/**
     * Loads Customer entry from data-store to cache
     *
     * @param String key
     * @return Customer the result of db query
     * 
     */
	@Override
	public Customer load(String id) {
		Customer customer = getCustomerDAO().getCustomerById(id);
		logger.debug("load method is being processed. Customer : " + customer);
		return customer;
	}

	/**
     * Loads Customer entries from data-store to cache
     *
     * @param Collection keys
     * @return Map the result of db query
     * 
     */
	@Override
	public Map<String, Customer> loadAll(Collection<String> idCol) {
		Map<String, Customer> customerMap = getCustomerDAO().getCustomerMap(idCol);
		logger.debug("loadAll method is being processed. CustomerMap : " + customerMap);
		return customerMap;
	}

	/**
     * Loads keys(Customer Ids) from data-store to cache
     *
     * @return Set key(Customer Id) set
     * 
     */
	@Override
	public Set<String> loadAllKeys() {
		return null;
	}

	/**
     * Gets CustomerDAO via Application Context
     *
     * @return ICustomerDAO Interface of CustomerDAO
     * 
     */
	public ICustomerDAO getCustomerDAO() {
		return ApplicationContextUtil.getApplicationContext().getBean(CustomerDAO.class);
	}	
	
}
