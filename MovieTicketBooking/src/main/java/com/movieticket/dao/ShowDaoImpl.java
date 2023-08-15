package com.movieticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movieticket.exception.ShowNotFoundException;
import com.movieticket.model.Show;
import com.movieticket.util.DBConnection;
import com.movieticket.util.Queries;

public class ShowDaoImpl implements IShowDao {

	@Override
	public void addShow(Show show) {
		try {
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);
			statement.setString(1, show.getShowName());
			statement.setInt(2, show.getShowId());
			statement.setString(3, show.getShowType());
			statement.setString(4, show.getLocation());
			statement.setDouble(5, show.getPrice());
			statement.setInt(6, show.getTotalNoSeat());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateShow(int showId, double price) {
		try {
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);
			statement.setDouble(1, price);
			statement.setInt(2, showId);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}

	}

	@Override
	public Show findById(int showId) {
		Show show = new Show();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYID);) {
			statement.setInt(1, showId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String showName = rs.getString("showName");
				int showId1 = rs.getInt("showId");
				String showType = rs.getString("showType");
				String location = rs.getString("location");
				Double price = rs.getDouble("price");
				int totalNoSeat = rs.getInt("totalNoSeat");

				show.setShowName(showName);
				show.setShowId(showId1);
				show.setLocation(location);
				show.setShowType(showType);
				show.setPrice(price);
				show.setTotalNoSeat(totalNoSeat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public void deleteShow(int showId) {
		try {
			Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);
			statement.setInt(1, showId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Show> findAllShow() {
		List<Show> shows = new ArrayList<Show>();

		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.FINDALLQUERY);
				ResultSet rs = statement.executeQuery();) {
			while (rs.next()) {
				Show show = new Show();
				String showName = rs.getString("showName");
				int showId1 = rs.getInt("showId");
				String showType = rs.getString("showType");
				String location = rs.getString("location");
				Double price = rs.getDouble("price");
				int totalNoSeat = rs.getInt("totalNoSeat");
				show.setShowName(showName);
				show.setShowId(showId1);
				show.setLocation(location);
				show.setShowType(showType);
				show.setPrice(price);
				show.setTotalNoSeat(totalNoSeat);
				shows.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	@Override
	public List<Show> findByShowType(String showType) throws ShowNotFoundException {
		List<Show> shows = new ArrayList<>();

		try (Connection connection = DBConnection.openConnection();
				// create a prepared statement
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYSHOWTYPE);) {
			statement.setString(1, showType);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Show show = new Show();
				String showName = rs.getString("showName");
				int showId = rs.getInt("showId");
				String showType1 = rs.getString("showType");
				String location = rs.getString("location");
				Double price = rs.getDouble("price");
				int totalNoSeat = rs.getInt("totalNoSeat");

				show.setShowName(showName);
				show.setShowId(showId);
				show.setLocation(location);
				show.setShowType(showType1);
				show.setPrice(price);
				show.setTotalNoSeat(totalNoSeat);

				shows.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	@Override
	public List<Show> findByLocationTotalNoSeat(String location, Integer totalNoSeat) throws ShowNotFoundException {
		List<Show> shows = new ArrayList<>();
		try (Connection connection = DBConnection.openConnection()) {
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYLOCATIONTOTALSEAT);
			statement.setString(1, location);
			statement.setInt(2, totalNoSeat);

			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Show show = new Show();
				String showName = resultSet.getString("showName");
				int showId = resultSet.getInt("showId");
				String showType1 = resultSet.getString("showType");
				String location1 = resultSet.getString("location");
				Double price = resultSet.getDouble("price");
				int totalNoSeat1 = resultSet.getInt("totalNoSeat");
				
				show.setShowName(showName);
				show.setShowId(showId);
				show.setLocation(location1);
				show.setShowType(showType1);
				show.setPrice(price);
				show.setTotalNoSeat(totalNoSeat1);

				shows.add(show);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}
		return shows;
	}

	@Override
	public List<Show> findByLocationPrice(String location, double price) throws ShowNotFoundException {
		List<Show> shows = new ArrayList<Show>();
		try (Connection connection = DBConnection.openConnection();
			PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYLOCATIONPRICE);) {
			statement.setString(1, location);
			statement.setDouble(2, price);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Show show = new Show();
				String showName = resultSet.getString("showName");
				int showId = resultSet.getInt("showId");
				String showType1 = resultSet.getString("showType");
				String location1 = resultSet.getString("location");
				Double price1 = resultSet.getDouble("price");
				int totalNoSeat1 = resultSet.getInt("totalNoSeat");
				
				show.setShowName(showName);
				show.setShowId(showId);
				show.setLocation(location1);
				show.setShowType(showType1);
				show.setPrice(price1);
				show.setTotalNoSeat(totalNoSeat1);

				shows.add(show);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection();
		}

		return shows;
	}

}
