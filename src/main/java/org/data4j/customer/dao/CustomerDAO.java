package org.data4j.customer.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.data4j.entity.Customer;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
 
/**
 * Customer DAO
 *
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
@Transactional(readOnly = true)
public class CustomerDAO implements ICustomerDAO {
 
    private SessionFactory sessionFactory;
 
    /**
     * Adds Customer
     *
     * @param Customer customer
     * 
     */
	@Transactional(readOnly = false)
    @Override
    public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);    	
    }
	
	/**
     * Adds Customers
     *
     * @param Map customerMap
     * 
     */
	@Transactional(readOnly = false)
    @Override
    public void addCustomers(Map<String, Customer> customerMap) {
		Collection<Customer> customerCol = customerMap.values();
		for(Customer customer : customerCol) {
			sessionFactory.getCurrentSession().save(customer); 
		}           	
    }
	
	/**
     * Deletes Customer
     *
     * @param String id
     * 
     */
	@Transactional(readOnly = false)
    @Override
    public void deleteCustomer(String id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete Customer where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();   	
    }
 
    /**
     * Gets Customer List
     *
     * @return List - Customer list
     */
	@Override
    public List<Customer> getCustomers() {
        @SuppressWarnings("unchecked")
		List<Customer> list = sessionFactory.getCurrentSession().createQuery("from Customer").list();
        return list;
    }
    
    /**
     * Get Customer
     *
     * @param  String User Id
     * @return Customer
     */
    @Override
	public Customer getCustomerById(String id) {
		Customer customer = (Customer) sessionFactory.getCurrentSession()
							                .createQuery("from Customer where id=?")
							                .setParameter(0, id).uniqueResult();
		return customer;
	}
    
    /**
     * Gets Customer Map
     *
     * @param  Collection<String> collection of keys 
     * @return Map<String, Customer> Customer Map
     */
    @Override
	public Map<String, Customer> getCustomerMap(Collection<String> idCol) {
    	Map<String, Customer> customerMap = new HashMap<String, Customer>();
		for(String id : idCol) {
			Customer customer = (Customer) sessionFactory
					                    .getCurrentSession()
						                .createQuery("from Customer where id=?")
						                .setParameter(0, id)
						                .uniqueResult();
			customerMap.put(customer.getId(), customer);
		}
		
		return customerMap;
	}
    
    /**
     * Get Customer Id Set
     *
     * @return Customer Id Set
     */
    @Override
	public Set<String> getCustomerIds() {
		@SuppressWarnings("unchecked")
		List<String> customerIdList = sessionFactory
									.getCurrentSession()
							        .createQuery("select cus.id from Customer cus")
							        .list();
		return new HashSet<String>(customerIdList);
	}
    
    /**
     * Sets Hibernate Session Factory
     *
     * @param SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }	
 
}
