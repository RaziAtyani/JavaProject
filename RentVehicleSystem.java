import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RentVehicleSystem implements VehicleRentInt {

    private final  ArrayList<Customer> customers= new ArrayList<>() ;
    private final  ArrayList<Vehicle > vehicles=new ArrayList<>() ;
    private int limitedPlanLimit = 2;
    
   

    public RentVehicleSystem() {// default constructor planLimit  =2;

    }
    
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public ArrayList<Vehicle > getVehicles () {
        return vehicles ;
    }
    
    @Override
    public  void addCustomer( String id ,String name, String address, String plan) throws RuntimeException {      //method for adding a customer
    	
         
         
    	boolean customerE =(linearSearchCustomersById(id) != -1);  
        
        
        
        
        
        //if customer exist in the database(arraylist)
        if(!name.isEmpty()&&!address.isEmpty()&&!plan.isEmpty()&&!id.isEmpty()) {
            if (!customerE){
                Customer customer = new Customer(id.trim(),name.trim(),address.trim(),plan.trim());     //creating a new customer object
                customers.add(customer);    //adding the customer to the array list
            }else {
                throw new IllegalArgumentException("The Customer already Exist.");   //some exceptions  ;)
            }
        }else{
            throw new RuntimeException("Fields can't be empty.");
        }
    }       //done
    
    private int linearSearchCustomersById(String id){   //linear search for customer by name (returning index)
        for (int i = 0; i < customers.size(); i++) {
            if (id.trim().equalsIgnoreCase(customers.get(i).getId()))
                return i;
        }
        return -1;
    }
    
 
    
   

    @Override
    public  void addCar(String name, String type, int noOfCarAvailable, String rating, int numberOfPassengers) throws RuntimeException {    // method for adding a vehicle

        
        boolean VehicleExist = (linearSearchVehicleByName(name) != -1);   // if the vehicle name in the database (expecting that THERE IS NO vehicle WITH SAME TITLE )
        if (!name.isEmpty() && !type.isEmpty() && noOfCarAvailable!=0) {
            if(!VehicleExist) {
                Car car = new Car(name.trim(),type.trim(), noOfCarAvailable, rating.trim(),numberOfPassengers);     // creating  car object and add it to the array list
                vehicles.add(car);
            }else {
                throw new IllegalArgumentException(" Vehicle with the same name Exist.");   //some exceptions  ;)
            }

        } else{
            throw new RuntimeException("Fields can't be empty. ");
        }

    }  //done
    private int linearSearchVehicleByName(String name){   // linear search media by code  (returning index)
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).name.equalsIgnoreCase(name.trim())){
                return i;
            }
        }
        return -1;
    }
  
    @Override
    public  void addTruck(String name, String type, double weight, double load, int noOfAvailableTruck) throws RuntimeException{   // method for adding a  truck vehicle
        if (!name.isEmpty()) {
        	
            
            boolean vehicleExist = (linearSearchVehicleByName(name) != -1);
            if(!vehicleExist) {
                Truck truck = new Truck(name.trim() ,type.trim(), noOfAvailableTruck, weight,load);  //creating the truck object and adding it to the array list
                vehicles.add(truck);
            }else {
                throw new IllegalArgumentException("Vehicle with the same name Exist.");  //you know , exceptions also
            }
        } else{
            throw new RuntimeException("Fields can't be empty. ");
        }
    }    //done
    @Override
    public  void addBus(String name, String type, int noOfAvailableBus,int numberOfWheels, int capacity)  throws RuntimeException {
    	
        
    	
    	
    	boolean VehicleExist = (linearSearchVehicleByName(name) != -1);     // bla , bla same thing here (test if the vehicle exist)
        if (!name.isEmpty() && !type.isEmpty() && noOfAvailableBus!=0) {
            if(!VehicleExist) {

                Bus bus = new Bus(name.trim() ,type.trim(), noOfAvailableBus, numberOfWheels, capacity );
                vehicles.add(bus);       // creating the bus object and adding it to the array list

            }else {
                throw new IllegalArgumentException("Vehicle with the same name Exist.");   // :)
            }
        } else{
            throw new RuntimeException("Fields can't be empty. ");
        }


    }   //done


    @Override
    public void setLimitedPlanLimit(int value) {    //method for setting the limited plan limit
        this.limitedPlanLimit = value;
    }     //done

    @Override
    public String getAllCustomersInfo() {    // return all the customers as string ( calling the toString)
        Collections.sort(customers);
        StringBuilder str = new StringBuilder();
        for (Customer customer : customers) {
            str.append(customer).append("\n");   // appending every customer to a string builder
        }
        return str.toString();
    }    //done


    @Override
    public String getAllVehiclesInfo() { // return all the vehicle info as string ( calling the toString)

        Collections.sort(vehicles);
        StringBuilder str = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            str.append(vehicle).append("\n\n");  // appending every vehicle to a string builder
        }
        return str.toString();
    }       //done


    @Override
    public boolean addToCart(String id ,String customerName,String vehicle_name) {   // adding the vehicle to the cart of customer (given the customer id and vehicle name)

    	
        boolean success = false;
        int indexOfCus =linearSearchCustomersById(id);    //getting the customer index that satisfy the name

        if(indexOfCus >= 0 && ( customers.get(indexOfCus).getInterestedVehicleList().isEmpty() || !customers.get(indexOfCus).getInterestedVehicleList().contains(vehicle_name)  )){
        	
                
            
        	
        	if ((linearSearchVehicleByName(vehicle_name) != -1)) {   //test if the customer exist and if the vehicle exist and if it's not added to the cart already
                customers.get(indexOfCus).getInterestedVehicleList().add(vehicle_name.trim());  // adding the vehicle to the customer cart
                success = true;
            }
        }
        return success;   //returning if added or no

    }       //done


    @Override
    public  boolean removeFromCart( String id ,String customerName, String vehicleName ) {   // removing the vehicle from the customer cart (given customer name and vehicle title )
   

    	
    	
    	int indexOfCus = linearSearchCustomersById(id); 
        if (indexOfCus >= 0) {
            return customers.get(indexOfCus).getInterestedVehicleList().remove(customerName);
        }
        return false;
    }   //done


    @Override
    public String processRequests(String id) throws RuntimeException {// processing the cart of every customer in alphabetic order


        StringBuilder logs = new StringBuilder();
        int indexOfCus =linearSearchCustomersById(id);
        Customer c = customers.get(indexOfCus);
        ArrayList<String> cart = c.getInterestedVehicleList();     //interested list as the cart

        if(c.getPlan().equalsIgnoreCase("UNLIMITED")){   //if the customer is unlimited add every thing in the cart if it's available
            if(cart.size() > 0) {

            	

                    Iterator<String> iterator = cart.iterator();
                    while (iterator.hasNext()){
                        String s = iterator.next().trim();
                        
                        
                        for (int i = 0; i < vehicles.size(); i++) {
                            if (vehicles.get(i).name.equalsIgnoreCase(s.trim())){
                                s="i";
                            }
                            else {
                            	s= "-1";
                            }
                            
                        }
                        int indexOfVehicle =Integer.parseInt(s) ;
                        
                        
                        
                        
                        
                        
                        if (indexOfVehicle >= 0 && vehicles.get(indexOfVehicle).noOfavailableVehicle > 0) {    // to see if the vehicle exist and it is available
                            c.getRentedVehicleList().add(s.trim());
                            vehicles.get(indexOfVehicle).setNoOfavailableVehicle(vehicles.get(indexOfVehicle).noOfavailableVehicle - 1);
                            iterator.remove();
                            Date date = new Date();
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            logs.append("SENDING ").append(vehicles.get(indexOfVehicle).name).append(" TO ").append(c.getName()).append(" - Date - ").append(formatter.format(date)).append("\n");   //adding the logs
                        }
                    }
       
            }}
        
        else if (c.getPlan().equalsIgnoreCase("LIMITED")){    //limited plan customers
            int limitAllowed = limitedPlanLimit - c.getRentedVehicleList().size();   // creating a limit for the cart (interested list) to add vehicle from the cart depending on the limit
            if(cart.size() > 0 && limitAllowed >= cart.size()) {
                
            	
            	
            	
            	   Iterator<String> iterator = cart.iterator();
                   while (iterator.hasNext()){
                       String s = iterator.next().trim();
                       for (int i = 0; i < vehicles.size(); i++) {
                           if (vehicles.get(i).name.equalsIgnoreCase(s.trim())){
                               s="i";
                           }
                           else {
                           	s= "-1";
                           }}
                           
                       
                       int indexOfVehicle =Integer.parseInt(s)   ;
                       
                       
                           
                       
                       if (indexOfVehicle >= 0 && vehicles.get(indexOfVehicle).noOfavailableVehicle > 0) {    // to see if the vehicle exist and it is available
                           c.getRentedVehicleList().add(s.trim());
                           vehicles.get(indexOfVehicle).setNoOfavailableVehicle(vehicles.get(indexOfVehicle).noOfavailableVehicle - 1);
                           iterator.remove();
                           Date date = new Date();
                           SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                           logs.append("SENDING ").append(vehicles.get(indexOfVehicle).name).append(" TO ").append(c.getName()).append(" - Date - ").append(formatter.format(date)).append("\n");   //adding the logs
                       }
                   }


               
            	
            	
            	
            	
            	
            	
            	
            	
            	
            	
            }else {
                throw new RuntimeException("The Cart Has More Than Allowed");
            }
        }
        return logs.toString();   //the method sendToRented will add logs (sending {vehicle} to {Customer}) to the string builder , so will return it here.
    }


    @Override
    public  boolean returnVehicle( String id , String vehicleName ) throws RuntimeException { 
  

    	
        int indexOfCus = linearSearchCustomersById(id);  
        if (indexOfCus == -1) {  
            throw new RuntimeException("Customer does Not Exist");
        }
        
        
            
        int indexOfVehicle = (linearSearchVehicleByName(vehicleName));
        if (indexOfVehicle == -1){
            throw new RuntimeException("vehicle does Not Exist");
        }
        if(customers.get(indexOfCus).getRentedVehicleList().remove(vehicleName)){   // if the vehicle removed successfully increment the storage(copies available)
            vehicles.get(indexOfVehicle).setNoOfavailableVehicle(vehicles.get(indexOfVehicle).noOfavailableVehicle + 1);
            return true;
        }
        return false;
    }   //done


    @Override
     public  ArrayList<Vehicle> searchVehicle(String name, String type,String rating) {   //searching vehicle depend on the title or any properties of them , also none of them(will return everything)
        ArrayList<Vehicle> result = new ArrayList<>();   //creating
        
        for (Vehicle m : vehicles) {      
            boolean nameMatch = false, ratingMatch = false, typeMatch = false;   
            if (name.isEmpty()|| name.equals(m.name)) {
                nameMatch = true;     
            }
            if (m instanceof Car) {  
                if (rating.isEmpty() || rating.equalsIgnoreCase(((Car) m).getRating())) {
                    ratingMatch = true;      
                }
                if(type .isEmpty()) {
                    typeMatch = true;  
                   
                }
            }
            if (m instanceof Truck) {  
                if (type.isEmpty() || type.equalsIgnoreCase(((Truck) m).getType())) {
                    typeMatch = true;     
                }
                if(name.isEmpty()){
                    nameMatch = true;
                }else {
                    
                        if (!((Truck) m).getName().contains(name.trim())) {
                            nameMatch = false;
                            break;
                        } else {
                            nameMatch = true;
                        }
                    }
                
                if(rating.isEmpty()) {
                    ratingMatch = true;    
                }
            }
            if (m instanceof Bus){
                if (name.isEmpty() && type.isEmpty() && rating.isEmpty()) {
                    ratingMatch = true;
                   nameMatch = true;
                    typeMatch = true;      
                }                           
            }
            if (nameMatch && typeMatch &&  ratingMatch) {
                result.add(m);  
            }
        }
        Collections.sort(result);
        return result;
    }   
   
    
    public void readFromTheDataBaceFile(ArrayList<Customer>customers) throws FileNotFoundException {
    	File f1 = new File("CustomerDB.txt");
    	if (!f1.exists()) {
    		return;
    	}
    	Scanner sc = new Scanner ("f1");
    	
    	 while (sc.hasNextLine() ){
             String[] cus = sc.nextLine().split(":");
             if(cus.length == 5){
                 addCustomer(cus[0],cus[1],cus[3],cus[4]);
                 
             }
         }
         sc.close();

    }
    
    
    
    
    
    }