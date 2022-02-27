package com.emlakburada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emlakburada.entity.Advert;

public class AdvertRepository extends JdbcConnectionRepository {
	
	private static final String INSERT_ADVERT = "INSERT INTO ADVERT (ID, HEADER, PRICE, CITY, AREA) VALUES (?,?,?,?,?);";
	private static final String SELECT_ALL_ADVERT = "SELECT * FROM ADVERT";
	private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE id = ?";

	public void save(Advert advert) {
		Connection connection = connect();
		if (connection != null) {
			PreparedStatement prepareStatement = null;
			try {
				prepareStatement = connection.prepareStatement(INSERT_ADVERT);
				prepareStatement.setInt(1, advert.id);
				prepareStatement.setString(2, advert.header);
				prepareStatement.setInt(3, advert.price);
				prepareStatement.setString(4, advert.city);
				prepareStatement.setInt(5, advert.area);
				int executeUpdate = prepareStatement.executeUpdate();
				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection olusturulamadi!");
		}
	}

	public List<Advert> findAll() {
		List<Advert> advertList = new ArrayList<Advert>();
		Connection connection = connect();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERT);
			ResultSet result = prepareStatement.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String header = result.getString("header");
				int price = result.getInt("price");
				String city = result.getString("city");
				int area = result.getInt("area");
				advertList.add(prepareAdvert(id, header, price, city, area));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return advertList;
	}

	private Advert prepareAdvert(int id, String header, int price, String city, int area) {
		Advert advert = new Advert();
		advert.id = id;
		advert.header = header;
		advert.price = price;
		advert.city = city;
		advert.area = area;
		return advert;
	}

	public Advert findOne(int id) {
		Advert advert = null;
		Connection connection = connect();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
			prepareStatement.setInt(1, id);
			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				int advertId = result.getInt("id");
				String header = result.getString("header");
				int price = result.getInt("price");
				String city = result.getString("city");
				int area = result.getInt("area");
				advert = prepareAdvert(advertId, header, price, city, area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return advert;
	}
}
