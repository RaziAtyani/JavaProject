
import java.util.ArrayList;

public interface VehicleRentInt {

    public  void addCustomer( String id , String name, String address, String plan);
    public  void addCar(String name, String type, int noOfCarAvailable, String rating, int numberOfPassengers) ;
    public  void addTruck(String name, String type, double weight, double load, int noOfAvailableTruck);
    public  void addBus(String name, String type, int noOfAvailableBus,int numberOfWheels, int capacity) ;
    public  void setLimitedPlanLimit(int value); 
    public  String getAllCustomersInfo() ;
    public  String getAllVehiclesInfo() ;
    public boolean addToCart(String id ,String customerName,String vehicle_name);
    public  boolean removeFromCart( String id ,String customerName, String vehicleName );
    public  String processRequests(String id);
    public  boolean returnVehicle(String id , String vehicleName );
    public  ArrayList<Vehicle> searchVehicle(String name, String type,String rating);

        
    


}
