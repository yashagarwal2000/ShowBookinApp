package com.movieticket.service;

import java.awt.print.Book;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.movieticket.dao.IShowDao;
import com.movieticket.dao.ShowDaoImpl;
import com.movieticket.exception.ShowNotFoundException;
import com.movieticket.model.Show;

public class ShowServiceImpl implements IShowService {
	IShowDao showDao = new ShowDaoImpl();

	@Override
	public void addShow(Show show) {
//		call the method of show
		showDao.addShow(show);
	}

	@Override
	public void updateShow(int showId, double price) {
//		call the methord
		showDao.updateShow(showId, price);
	}

	@Override
	public Show getById(int showId) {
		return showDao.findById(showId);
	}

	@Override
	public void deleteShow(int showId) {
		showDao.deleteShow(showId);
	}

	@Override
	public List<Show> getAllShow() {
		return showDao.findAllShow();
	}

	@Override
	public List<Show> getByShowType(String showType) throws ShowNotFoundException {
		List<Show> shows = showDao.findByShowType(showType).stream().collect(Collectors.toList());
		if(shows.equals(null)) {
			throw new ShowNotFoundException("Does not have show by this type");
		}
		return shows;
	}

	@Override
	public List<Show> getByLocationTotalNoSeat(String location, Integer totalNoSeat) throws ShowNotFoundException {
		List<Show> shows = showDao.findByLocationTotalNoSeat(location, totalNoSeat).stream().collect(Collectors.toList());
		if (shows.equals(null)) {
			throw new ShowNotFoundException("does not have any seat left at this location");
		}
		return shows;
	}

	@Override
	public List<Show> getByLocationPrice(String location, double price) throws ShowNotFoundException {
		List<Show> shows = showDao.findByLocationPrice(location, price).stream().collect(Collectors.toList());
		if (shows.equals(null)) {
			throw new ShowNotFoundException("does not have a seat at this location at price");
		}
		return shows;
	}

}
