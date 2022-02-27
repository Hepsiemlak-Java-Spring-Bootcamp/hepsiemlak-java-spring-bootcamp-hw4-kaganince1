package com.emlakburada.entity;

public class Advert {
	
	public int id;
	public String header;
	public int price;
	public String city;
	public int area;
	
	public Advert() {

	}

	public Advert(String header, int price, String city, int area) {
		super();
		this.header = header;
		this.price = price;
		this.city = city;
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", baslik=" + header + ", fiyat=" + price + ", sehir=" + city
				+ ", alan=" + area + "]";
	}
}
