package com.movieticket.model;

public class Show {
	private String showName;
	private Integer showId;
	private String showType;
	private String location;
	private double price;
	private Integer totalNoSeat;
	public Show() {
		super();
	}
	public Show(String showName,Integer showId, String showType, String location, double price, Integer totalNoSeat) {
		super();
		this.showName = showName;
		this.showId = showId;
		this.showType = showType;
		this.location = location;
		this.price = price;
		this.totalNoSeat = totalNoSeat;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public String getShowType() {
		return showType;
	}
	public void setShowType(String showType) {
		this.showType = showType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getTotalNoSeat() {
		return totalNoSeat;
	}
	public void setTotalNoSeat(Integer totalNoSeat) {
		this.totalNoSeat = totalNoSeat;
	}
	@Override
	public String toString() {
		return "Show [showName=" + showName + ", showId=" + showId + ", showType=" + showType + ", location=" + location
				+ ", price=" + price + ", totalNoSeat=" + totalNoSeat + "]";
	}
}
