Hazelcast MapLoader Feature

com.hazelcast.core.MapLoader Interface provides very important flexibility for data access. Distributed map implementation is an in-memory data store but it can be backed by any type of data store such as RDBMS, OODBMS, or simply a file based data store.

IMap.get(key) normally returns the value that is available in-memory. However, if the entry doesn’t exist in-memory, Hazelcast returns null. If a Loader implementation is provided then, instead of returning null, Hazelcast will load the unknown entry by calling the implementation’s load (key) or loadAll(keys) methods. Loaded entries will be placed into the distributed map and they will stay in-memory until they are explicitly removed or implicitly evicted (if eviction is configured).

V load(K key) : Loads the value of a given key. If distributed map doesn’t contain the value for the given key then Hazelcast will call implementation’s load (key) method
to obtain the value. Implementation can use any means of loading the given key such as an ORM framework, simple SQL or reading a file etc.

Map<K, V> loadAll(Collection<K> keys) : Loads given keys. This is batch load operation so that implementation can optimize the multiple loads.

Set<K> loadAllKeys() : Loads all of the keys from the store. This method is used for pre-populating the in-memory map when the map is first touched/used. If MapLoader.loadAllKeys returns NULL then nothing will be loaded. Your MapLoader.loadAllKeys implementation can return all or some of the keys. You may select and return only the hot keys, for instance. Also note that this is the fastest way of pre-populating the map as Hazelcast will optimize the loading process by having each node loading owned portion of the entries.

MapLoader initialization flow is as the following :

1- When getMap() first called from any node, initialization starts
2- Hazelcast will call MapLoader.loadAllKeys() to get all your keys on each node
3- Each node will figure out the list of keys it owns
4- Each node will load all its owned keys by calling MapLoader.loadAll(keys)
5- Each node puts its owned entries into the map by calling IMap.putTransient(key,value)

This article shows how to implement Hazelcast MapLoader Feature.

Used Technologies : 

JDK 1.7.0_40
Spring 3.2.4
Hazelcast 3.0
Hibernate 4.1.8
Tomcat-Jdbc 7.0.27
MySQL Connector 5.1.17
Maven 3.0.4