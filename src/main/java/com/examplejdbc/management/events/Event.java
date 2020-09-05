package com.examplejdbc.management.events;

public class Event {
	private int id,price,tickets_avail;
	private String city,eveName,eveType;
	public Event(int id,int price,int ticket,String city,String eveName,String eveType)
	{
		this.id=id;
		this.city=city;
		this.eveName=eveName;
		this.eveType=eveType;
		this.price=price;
		this.tickets_avail=ticket;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTickets_avail() {
		return tickets_avail;
	}
	public void setTickets_avail(int tickets_avail) {
		this.tickets_avail = tickets_avail;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEveName() {
		return eveName;
	}
	public void setEveName(String eveName) {
		this.eveName = eveName;
	}
	public String getEveType() {
		return eveType;
	}
	public void setEveType(String eveType) {
		this.eveType = eveType;
	}
	

}
