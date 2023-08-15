package com.movieticket.service;

import java.util.List;

import com.movieticket.exception.ShowNotFoundException;
import com.movieticket.model.Show;

public interface IShowService {
	void addShow(Show show);
	void updateShow(int showId,double price);
	Show getById(int showId);
	void deleteShow(int showId);
	List<Show> getAllShow();
	List<Show> getByShowType(String showType) throws ShowNotFoundException;
	List<Show> getByLocationTotalNoSeat(String location, Integer totalNoSeat) throws ShowNotFoundException;
	List<Show> getByLocationPrice(String location,double price) throws ShowNotFoundException;
	
}
