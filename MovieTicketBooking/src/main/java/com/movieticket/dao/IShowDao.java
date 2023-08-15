package com.movieticket.dao;

import java.util.List;

import com.movieticket.exception.ShowNotFoundException;
import com.movieticket.model.Show;

public interface IShowDao {
	void addShow(Show show);
	void updateShow(int showId,double price);
	Show findById(int showId);
	void deleteShow(int showId);
	List<Show> findAllShow();
	List<Show> findByShowType(String showType) throws ShowNotFoundException;
	List<Show> findByLocationTotalNoSeat(String location,Integer totalNoSeat) throws ShowNotFoundException;
	List<Show> findByLocationPrice(String location,double price) throws ShowNotFoundException;
}
