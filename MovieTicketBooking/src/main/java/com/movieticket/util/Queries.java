package com.movieticket.util;

public class Queries {

	public static final String CREATEQUERY = "CREATE TABLE IF NOT EXISTS showDetails( showName VARCHAR(20),showId INTEGER PRIMARY KEY AUTO_INCREMENT, showType VARCHAR(20), location VARCHAR(20), price DOUBLE, totalNoSeat INTEGER)";

	public static final String INSERTQUERY = "Insert into showDetails(showName,showId, showType, location, price, totalNoSeat) values (?,?,?,?,?,?);";

	public static final String UPDATEQUERY = "update showDetails set price=? where showId=? ;";
	
	public static final String DELETEQUERY = "delete from showDetails where showId=? ";
	
	public static final String FINDALLQUERY = "select * from showDetails";

	public static final String QUERYBYID = "select * from showDetails where showId = ? ;";

	public static final String QUERYBYSHOWTYPE = "select * from showDetails  where showType  = CONCAT(?) ;";

	public static final String QUERYBYLOCATIONTOTALSEAT = "select * from showDetails where location = ? and totalNoSeat >= ? ;";
	
	public static final String QUERYBYLOCATIONPRICE = "select * from showDetails where location = ? and price <= ? ;";
}
