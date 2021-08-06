import java.util.Scanner;
import java.util.*; 


public class BillingMainClass {
	//Variables 
	static int noOfAdults; 
	static int noOfChildren; 
	static int mealType; //1- Deluxe , 2-Standard; 
	static char roomType; // A,B,C,D or E
	static double deposit; 
	static String dayOfWeek; 
	static int daysAfterParty;
	static Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) {
		try {
			
			//Get clients details
			menu();
			
			BillingClass bill = new BillingClass(noOfAdults, noOfChildren, mealType, roomType, deposit, dayOfWeek, daysAfterParty);
			bill.calculateTotalBill();
			
			discountPromo(); 
			bill.setDaysAfterParty(daysAfterParty);
			bill.calculateDiscount();
			
			
			System.out.format("\nTotal Bill is: $%.2f", bill.getTotalAmount());

		}catch(Exception ex) {
			//ex.printStackTrace();
			System.out.println("ERROR - System Failure! You have entered an invalid value. Please restart");
		}finally {
			scan.close();
		}

	}


	public static void menu() throws Exception {
		System.out.println("\t\tWelcome to Caswells Catering and Convention Services."); 
		System.out.println("Please take you time and input the following details: "); 
		System.out.println("\nTotal Number of Adults: "); 
		noOfAdults = scan.nextInt(); 
		System.out.println("\nTotal Number of Children: "); 
		noOfChildren = scan.nextInt(); 
		System.out.println("\nType of Meal: \n 1-Deluxe\n 2-Standard\nPlease select the number: "); 
		mealType = scan.nextInt(); 
		
		if(mealType > 2 || mealType < 1) {
			throw new Exception("ERROR - System Failure! You have entered an invalid value. Please restart");
		}
		
		System.out.println("\nType of Room:\n 1-Room A : $55.00\n 2-Room B : $75.00\n 3-Room C : $85.00\n 4-Room D : $100.00 \n 5-Room E : $130.00");
		System.out.println("Please Select the number: ");
		int iRoom = scan.nextInt();
		
		if(iRoom > 5 || iRoom < 1) {
			throw new Exception("ERROR - System Failure! You have entered an invalid value. Please restart");
		}
		
		System.out.println("\nDay of the Party:\n 1-Monday \n 2-Tuesday\n 3-Wednesday\n 4-Thursday\n 5-Friday\n 6-Saturday\n 7-Sunday"); 
		System.out.println("Please select the number:");
		int iDay = scan.nextInt();
		
		if(iDay > 7 || iDay < 1) {
			throw new Exception("ERROR - System Failure! You have entered an invalid value. Please restart");
		}
		
		//map room and days to the global variables 
		mapRoom(iRoom);
		mapDayOfTheWeek(iDay);
		
		System.out.println("\nWould you like to make a deposit (Yes/No)?"); 
		String option = scan.next(); 
		
		if(option.equalsIgnoreCase("yes")) {
			System.out.println("\nEnter Amount for deposit: "); 
			deposit = scan.nextDouble();
		}
		
	}
	
	/**
	 * Map Room 
	 * @param iRoom
	 * @throws Exception
	 */
	public static void mapRoom(int iRoom) throws Exception {
		switch(iRoom) {
		case 1: roomType = 'A'; break; 
		case 2: roomType = 'B'; break;
		case 3: roomType = 'C'; break; 
		case 4: roomType = 'D'; break;
		case 5: roomType = 'E'; break;
		}
		
	}
	
	
	/**
	 * Map Day of The Week
	 * @param iDay
	 * @throws Exception
	 */
	public static void mapDayOfTheWeek(int iDay) throws Exception {
		switch(iDay) {
		case 1: dayOfWeek = "Monday"; break; 
		case 2: dayOfWeek = "Tuesday"; break;
		case 3: dayOfWeek = "Wednesday"; break; 
		case 4: dayOfWeek = "Thursday"; break;
		case 5: dayOfWeek = "Friday"; break;
		case 6: dayOfWeek = "Saturday"; break;
		case 7: dayOfWeek = "Sunday"; break;
		}
	}

	/**
	 * Discount promo for promptly payment
	 */
	public static void discountPromo() {
		System.out.println("\n\nATTENTION !Here are some good news!");
		System.out.println("Discounts are given if you are able to pay within 10 days."); 
		System.out.println("\nEnter no of days payment will be made (0-365): "); 
		daysAfterParty = scan.nextInt();
	}
	
	
}
