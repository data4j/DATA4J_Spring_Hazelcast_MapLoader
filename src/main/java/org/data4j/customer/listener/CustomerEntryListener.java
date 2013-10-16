package org.data4j.customer.listener;

import org.apache.log4j.Logger;
import org.data4j.entity.Customer;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;

/**
 * CustomerEntryListener Class listens entry changes on Customer Map object.
 * 
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public class CustomerEntryListener implements EntryListener<String, Customer> {

	private static final Logger logger = Logger.getLogger(CustomerEntryListener.class);
	
	/**
     * Invoked when an entry is added.
     *
     * @param EntryEvent
     * 
     */
	@Override
	public void entryAdded(EntryEvent<String, Customer> ee) {
		logger.debug("Entry is added. Member : " + ee.getMember() + ", Entry : "+ee.getOldValue() + ", Entry : " + ee.getValue());
	}

	/**
     * Invoked when an entry is evicted.
     *
     * @param EntryEvent
     * 
     */
	@Override
	public void entryEvicted(EntryEvent<String, Customer> ee) {
		logger.debug("Entry is evicted. Member : " + ee.getMember() + ", Entry : "+ee.getOldValue() + ", Entry : " + ee.getValue());
	}

	/**
     * Invoked when an entry is removed.
     *
     * @param EntryEvent
     * 
     */
	@Override
	public void entryRemoved(EntryEvent<String, Customer> ee) {
		logger.debug("Entry is removed. Member : " + ee.getMember() + ", Entry : "+ee.getOldValue() + ", Entry : " + ee.getValue());
	}

	/**
     * Invoked when an entry is updated.
     *
     * @param EntryEvent
     * 
     */
	@Override
	public void entryUpdated(EntryEvent<String, Customer> ee) {
		logger.debug("Entry is updated. Member : " + ee.getMember() + ", Entry : "+ee.getOldValue() + ", Entry : " + ee.getValue());
	}	

}
