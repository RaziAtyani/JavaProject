
public class Car extends Vehicle {
	public Car(String name, String type, int noOfCarAvailable, String rating,int noOfPassengers) {
		super(name ,type ,noOfCarAvailable );
		this.noOfPassengers = noOfPassengers;
		this.rating = rating;
	}
	private  int noOfPassengers;
	private String rating ;
	
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating)  throws RuntimeException {
	        if((rating.equalsIgnoreCase("HC") || rating.equalsIgnoreCase("SP") || rating.equalsIgnoreCase("NC"))) {
	            this.rating = rating.toUpperCase();
	        }else {
	            throw new RuntimeException("ERROR , Rating Should Be (HC, SP or NC)");
	        }
	    }
	@Override
	public String toString() {
		return "Car [noOfPassengers=" + noOfPassengers + ", rating=" + rating + ", toString()=" + super.toString()
				+ "]";
	}
	@Override
	
	public int compareTo(Vehicle o) {
		return Integer.compare(name.compareTo(o.name), 0);
	}
	
	
	
	
	
	
	
	

}
