package com.examplejdbc.management.events;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;


public class App 
{
    public static void main( String[] args )
    {
    	final Logger log = Logger.getLogger(App.class.getName());
    	log.info("Printing in log file");
    	log.error("Trying log.error");
    	log.warn("Trying log.warn");
    	ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        EventDao eve = (EventDao) context.getBean("eveDAO");
        Event event =(Event) context.getBean("eveObj");
        //Event event = new Event(4,1000,200,"Kolkata","Football","Sports");
        //eve.insert(event);
        
        List<Event> eve1 = eve.findByEveName("Football");
        System.out.println("Find By Event Name");
        for(int i=0;i<eve1.size();i++)
        	{
        	log.info("Printing by event Name: Football");
        	//System.out.println("\n\nEvent Name: "+eve1.get(i).getEveName()+"\nEvent Type: "+eve1.get(i).getEveType()+"\nPrice: "+eve1.get(i).getPrice()+"\nLocation: "+eve1.get(i).getCity()+"\nTickets Avail: "+eve1.get(i).getTickets_avail());
        	log.info("\n\nEvent Name: "+eve1.get(i).getEveName()+"\nEvent Type: "+eve1.get(i).getEveType()+"\nPrice: "+eve1.get(i).getPrice()+"\nLocation: "+eve1.get(i).getCity()+"\nTickets Avail: "+eve1.get(i).getTickets_avail());
        	}
        
        List<Event> eve2=eve.findByEveType("Sports");
        System.out.println("Find By Type");
        for(int i=0;i<eve2.size();i++)
        	{
        	log.info("Finding Event By Type=Sports");
        	//System.out.println("\n\nEvent Name: "+eve2.get(i).getEveName()+"\nEvent Type: "+eve2.get(i).getEveType()+"\nPrice: "+eve2.get(i).getPrice()+"\nLocation: "+eve2.get(i).getCity()+"\nTickets Avail: "+eve2.get(i).getTickets_avail());
        	log.info("\n\nEvent Name: "+eve2.get(i).getEveName()+"\nEvent Type: "+eve2.get(i).getEveType()+"\nPrice: "+eve2.get(i).getPrice()+"\nLocation: "+eve2.get(i).getCity()+"\nTickets Avail: "+eve2.get(i).getTickets_avail());
        	}
        
        List<Event> eve3=eve.findAll();
        System.out.println("Getting everything from table");
        for(int i=0;i<eve3.size();i++)
        	{
        	log.info("Printing the entire table");
        	//System.out.println("\n\nEvent Name: "+eve3.get(i).getEveName()+"\nEvent Type: "+eve3.get(i).getEveType()+"\nPrice: "+eve3.get(i).getPrice()+"\nLocation: "+eve3.get(i).getCity()+"\nTickets Avail: "+eve3.get(i).getTickets_avail());
        	log.info("\n\nEvent Name: "+eve3.get(i).getEveName()+"\nEvent Type: "+eve3.get(i).getEveType()+"\nPrice: "+eve3.get(i).getPrice()+"\nLocation: "+eve3.get(i).getCity()+"\nTickets Avail: "+eve3.get(i).getTickets_avail());
        	}
    }
}
