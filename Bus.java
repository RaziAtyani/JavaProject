
public class Bus  extends  Vehicle {
	public Bus(String name, String type, int noOfAvailableBuss,int numberOfWheels, int capacity) {
		super(name ,type ,noOfAvailableBuss );
		this.numberOfWheels = numberOfWheels;
		this.capacity = capacity;
	}
	
	
	
	
	
	private  int numberOfWheels ;
	private int  capacity ;
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		
	}
	@Override
	public int compareTo(Vehicle o) {
	
		 return Integer.compare(name.compareTo(o.name), 0);
		
	}
	@Override
	public String toString() {
		return "Bus [numberOfWheels=" + numberOfWheels + ", capacity=" + capacity + "    " + super.toString()+"]";
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
