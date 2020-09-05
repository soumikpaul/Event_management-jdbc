package com.examplejdbc.management.events;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;


//import com.examplejdbc.databaseconn.Customer;

public class EventDaoImpl implements EventDao{
	private DataSource dataSource;
	final Logger log = Logger.getLogger(EventDaoImpl.class.getName());

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void insert(Event dummyEvent) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO EVENTS " +
				"(ID, EVENT_NAME,EVENT_TYPE,CITY,PRICE,TICKETS) VALUES (?, ?, ?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dummyEvent.getId());
			ps.setString(2, dummyEvent.getEveName());
			ps.setString(3, dummyEvent.getEveType());
			ps.setString(4, dummyEvent.getCity());
			ps.setInt(5, dummyEvent.getPrice());
			ps.setInt(6, dummyEvent.getTickets_avail());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			log.error("Error "+e);
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error("Error "+e);

				}
			}
		}

	}

	public List<Event> findByEveName(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM EVENTS WHERE EVENT_NAME = ?";
		List<Event> eveList=new ArrayList<Event>();
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			Event event=null;
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				event = new Event(
						rs.getInt("ID"),
						rs.getInt("PRICE"),
						rs.getInt("TICKETS"),
						rs.getString("CITY"), 
						rs.getString("EVENT_NAME"), 
						rs.getString("EVENT_TYPE") 
						);
				eveList.add(event);
			}
			rs.close();
			ps.close();
			return eveList;
		} catch (SQLException e) {
			log.error("Error "+e);
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {			
					log.error("Error "+e);
					}
			}
		}
	}
	public List<Event> findByEveType(String type) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM EVENTS WHERE EVENT_TYPE = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, id);
			ps.setString(1, type);
			//Customer customer = null;
			Event event=null;
			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				event = new Event(
//						rs.getInt("ID"),
//						rs.getInt("PRICE"),
//						rs.getInt("TICKETS"),
//						rs.getString("CITY"), 
//						rs.getString("EVENT_NAME"), 
//						rs.getString("EVENT_TYPE") 
//						);
//			}
			List<Event> eveList=new ArrayList<Event>();
			while(rs.next()) {
				event = new Event(
						rs.getInt("ID"),
						rs.getInt("PRICE"),
						rs.getInt("TICKETS"),
						rs.getString("CITY"), 
						rs.getString("EVENT_NAME"), 
						rs.getString("EVENT_TYPE") 
						);
				eveList.add(event);
			}
			rs.close();
			ps.close();
			return eveList;
		} catch (SQLException e) {
			log.error("Error "+e);
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error("Error "+e);
					}
			}
		}
	}
	public List<Event> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM EVENTS";
		List<Event> eveList=new ArrayList<Event>();
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Event event=null;
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				event = new Event(
						rs.getInt("ID"),
						rs.getInt("PRICE"),
						rs.getInt("TICKETS"),
						rs.getString("CITY"), 
						rs.getString("EVENT_NAME"), 
						rs.getString("EVENT_TYPE") 
						);
				eveList.add(event);
			}
			rs.close();
			ps.close();
			return eveList;
		} catch (SQLException e) {
			log.error("Error "+e);
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					log.error("Error "+e);
					}
			}
		}
	}
}
