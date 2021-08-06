import java.util.Date;

public class BillingClass {
	//Constants 
	private static final double ROOM_A = 55.00; 
	private static final double ROOM_B = 75.00; 
	private static final double ROOM_C = 85.00; 
	private static final double ROOM_D = 100.00; 
	private static final double ROOM_E = 130.00; 
	private static final double DELUXE_RATE = 15.80;
	private static final double STANDARD_RATE = 11.75;  
	private static final double DELUXE_RATE_CHILD = DELUXE_RATE * 60 / 100;
	private static final double STANDARD_RATE_CHILD = STANDARD_RATE * 60 / 100;
	

	//Variables
	private int noOfAdults; 
	private int noOfChildren; 
	private int mealType; //1- Deluxe , 2-Standard; 
	private char roomType; // A,B,C,D or E
	private double deposit; 
	private String dayOfWeek; 
	private int daysAfterParty;
	private double TotalAmount; 

	/**
	 * Default Constructor
	 */
	public BillingClass() {}
	
	/**
	 * Custom Constructor
	 * @param noOfAdults
	 * @param noOfChildren
	 * @param mealType
	 * @param roomType
	 * @param deposit
	 * @param dayOfWeek
	 * @param daysAfterParty
	 */
	public BillingClass(int noOfAdults, int noOfChildren, int mealType, char roomType, double deposit, String dayOfWeek,
			int daysAfterParty) {
		super();
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.mealType = mealType;
		this.roomType = roomType;
		this.deposit = deposit;
		this.dayOfWeek = dayOfWeek;
		this.daysAfterParty = daysAfterParty;
	}
	
	/*Getters and Setters*/
	public int getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public int getMealType() {
		return mealType;
	}
	public void setMealType(int mealType) {
		this.mealType = mealType;
	}
	public char getRoomType() {
		return roomType;
	}
	public void setRoomType(char roomType) {
		this.roomType = roomType;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public int getDaysAfterParty() {
		return daysAfterParty;
	}
	public void setDaysAfterParty(int daysAfterParty) {
		this.daysAfterParty = daysAfterParty;
	} 
	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public void calculateTotalBill() {
		//Add Meal
		switch(mealType) {
		case 1: 
			TotalAmount = (noOfAdults * DELUXE_RATE) + (noOfChildren * DELUXE_RATE_CHILD);
			break;
		case 2: 
			TotalAmount = (noOfAdults * STANDARD_RATE) + (noOfChildren * STANDARD_RATE_CHILD);
			break;
		}
		
		//Tip for meal cost 
		TotalAmount  += TotalAmount * .18;
		
		//Add Room
		switch(roomType) {
			case 'A' : TotalAmount +=  ROOM_A; break; 
			case 'B' : TotalAmount +=  ROOM_B; break; 
			case 'C' : TotalAmount +=  ROOM_C; break; 
			case 'D' : TotalAmount +=  ROOM_D; break; 
			case 'E' : TotalAmount +=  ROOM_E; break; 
		}
		 
		 //addtional fees
		 if(dayOfWeek.equalsIgnoreCase("Friday") || dayOfWeek.equalsIgnoreCase("Saturday")  || dayOfWeek.equalsIgnoreCase("Sunday")) {
			 TotalAmount += TotalAmount * 0.07;
		 }
		 
		System.out.format("\nInitial due: $%.2f", TotalAmount);
		
	}
	
	/**
	 * Calculate the Discount for promptly payment
	 */
	public void calculateDiscount() {
		if(daysAfterParty >= 0 && daysAfterParty <=10) {
			if(TotalAmount < 100.00) {
				TotalAmount -= TotalAmount * 0.5/100; 
			}else if(TotalAmount < 400.00 && TotalAmount>=100.00) {
				TotalAmount -= TotalAmount * 3.0/100; 
			}else if(TotalAmount < 800.00 && TotalAmount>=400.00) {
				TotalAmount -= TotalAmount * 4.0/100; 
			}else if(TotalAmount>=800.00) {
				TotalAmount -= TotalAmount * 5.0/100; 
			}
		}
		
		 //minus the deposit
		 TotalAmount = TotalAmount - deposit;
	}
	
}
