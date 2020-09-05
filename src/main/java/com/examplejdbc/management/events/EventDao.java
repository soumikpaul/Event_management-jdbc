package com.examplejdbc.management.events;

import java.util.List;

public interface EventDao {
	public void insert(Event dummyEvent);
	public List<Event> findByEveName(String name);
	public List<Event> findByEveType(String type);
	public List<Event> findAll();

}
