package com.movieticket.client;

import java.util.Scanner;

import com.movieticket.exception.ShowNotFoundException;
import com.movieticket.model.Show;
import com.movieticket.service.IShowService;
import com.movieticket.service.ShowServiceImpl;

public class Admin {

	public static void main(String[] args) throws ShowNotFoundException {
//		Show show = new Show();
		IShowService showService = new ShowServiceImpl();
		Scanner scanner = new Scanner(System.in);
		Integer showId;
		String showName;
		String showType;
		String location;
		double price;
		Integer totalNoSeat;		

		while (true) {
			System.out.println("Show Booking App Menu:");
			System.out.println("1. Display all Show");
			System.out.println("2. Add New Show");
			System.out.println("3. Update Show Price");
			System.out.println("4. Search Show by Show-Id");
			System.out.println("5. Delete Show From DataBase");
			System.out.println("6. Serach Show at a particular categories");
			System.out.println("7. Search Show By Location and Number of seat available");
			System.out.println("8. Search Show By Location and Price");
			System.out.println("9. exit");
			System.out.print("Enter your choice: ");
			
		
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character
			switch (choice) {
			case 1:
				System.out.println("All show present in the database");
				showService.getAllShow().forEach(System.out::println);
				break;
				
			case 2:
				System.out.println("Enter the show name : ");
				showName = scanner.next();
				System.out.println("Enter the new show Id : ");
				showId = scanner.nextInt();
				System.out.println("Enter the categories in which show lies : ");
				showType = scanner.next();
				System.out.println("Enter the show location : ");
				location = scanner.next();
				System.out.println("Enter the price of 1 tickect : ");
				price = scanner.nextDouble();
				System.out.println("Enter the total Number of Seat available for show : ");
				totalNoSeat = scanner.nextInt();
				
				Show show = new Show(showName,showId,showType,location,price,totalNoSeat);
				IShowService service = new ShowServiceImpl();
				service.addShow(show);
				System.out.println("New show has been added to the database");
				
				break;
				
			case 3:
				System.out.println("Enter the show id for which you want to update the price : ");
				showId = scanner.nextInt();
				System.out.println("Enter the updated amount for that show : ");
				price = scanner.nextDouble();
				IShowService showService2 = new ShowServiceImpl();
				showService2.updateShow(showId, price);
				System.out.println("The price of the show has been updated to : "+price);
				

				break;
				
			case 4:
				System.out.println("Enter the showId : ");
				showId = scanner.nextInt();
				
				IShowService showService3 = new ShowServiceImpl();
				System.out.println(showService3.getById(showId)); 
				break;
				
			case 5:
				System.out.println("Enter the showid to deleting the show : ");
				showId = scanner.nextInt();
				IShowService showService4 = new ShowServiceImpl();
				System.out.println("The show has been deleted " + showService4.getById(showId));
				showService4.deleteShow(showId);
				break;
				
			case 6:
				System.out.println("Enter the showType/categories : ");
				showType = scanner.next();
				IShowService showService5 = new ShowServiceImpl();
				showService5.getByShowType(showType).forEach(System.out::println);
				break;
				
			case 7:
				System.out.println("Enter the location : ");
				location = scanner.next();
				System.out.println("Enter the minimum Number of seat required : ");
				totalNoSeat = scanner.nextInt();
				IShowService showService6 = new ShowServiceImpl();
				showService6.getByLocationTotalNoSeat(location, totalNoSeat).forEach(System.out::println);
				break;
			
			case 8:
				System.out.println("Enter the location : ");
				location = scanner.next();
				System.out.println("Enter the price for the ticket : ");
				price = scanner.nextDouble();
				IShowService showService7 = new ShowServiceImpl();
				showService7.getByLocationPrice(location, price).forEach(System.out::println);
				break;
				
			case 9:
				System.out.println("exiting the application");
				return;
			default :
				System.out.println("Enter a valid choice");
			}
		}
	}

}
