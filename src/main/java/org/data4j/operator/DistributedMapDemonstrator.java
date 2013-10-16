package org.data4j.operator;

import org.apache.log4j.Logger;
import org.data4j.cache.srv.IDistributedMapService;

/**
 * DistributedMapDemonstrator Class demonstrates Customers from customerMap.
 * 
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public class DistributedMapDemonstrator {

	private static final Logger logger = Logger.getLogger(DistributedMapDemonstrator.class);
	
	private	IDistributedMapService distributedMapService;
	
	/**
     * Demonstrates Customer Entries from customerMap.
	 *
     */
	public void demonstrate() {				
		logger.debug("Received Entry : 1 => " + distributedMapService.getCustomerMap().get("1"));
		logger.debug("Received Entry : 2 => " + distributedMapService.getCustomerMap().get("2"));
	}

	public void setDistributedMapService(IDistributedMapService distributedMapService) {
		this.distributedMapService = distributedMapService;
	}
	
}
