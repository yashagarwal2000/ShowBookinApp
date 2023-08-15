package com.movieticket.client;

import com.movieticket.exception.ShowNotFoundException;
import com.movieticket.model.Show;
import com.movieticket.service.IShowService;
import com.movieticket.service.ShowServiceImpl;

public class Demo {

	public static void main(String[] args) throws ShowNotFoundException {
		Show show = new Show();
//		Show show = new Show("Dangal", 116, "Movie", "Kanpur", 1050, 55);
		IShowService showService = new ShowServiceImpl();
//		showService.addShow(show);

//		showService.updateShow(102, 400);
		
		show = showService.getById(103);
		System.out.println(show);
		
		
		
//		showService.getAllShow().forEach(System.out::println);
		
//		showService.deleteShow(101);
		
//		showService.getByShowType("Movie").forEach(System.out::println);
		
//		showService.getByLocationTotalNoSeat("Kanpur", 55).forEach(System.out::println);
//		
//		showService.getByLocationPrice("Banglore", 1500).forEach(System.out::println);;
	}

}
