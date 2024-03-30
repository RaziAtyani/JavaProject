
public class Driver2 {

	public static void main(String[] args) {
		RentVehicleSystem  system= new RentVehicleSystem();
		 system.addCustomer("225","yousef","809","unlimited");
		 system.addCustomer("268","Aadel","879","unlimited");
		 system.addCar("yup", "car", 8, "6.5", 4);
		 system.addBus("rp", "bus", 6, 5, 9);
		 System.out.println( system.addToCart("225", "yousef", "yup"));
		 System.out.println(system.addToCart("225", "bus", "rp"));
		// System.out.println(system.removeFromCart("23","razi" , "yu"));
		 System.out.println(system.processRequests("225"));
		 System.out.println(system.processRequests("268"));
		// System.out.println(system.returnVehicle("225", "y"));
		 System.out.println(system.searchVehicle("yup","car","6.5"));
		 System.out.println(system.getAllCustomersInfo());
		 System.out.println(system.getAllVehiclesInfo());
		
	
		
		
		
		
		
		
		
		
		
		
		
	}

}
