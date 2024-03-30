
public class Truck extends Vehicle  {
       public Truck(String name, String type, int noOfAvailableTrucks,double weight, double load) {
		super(name ,type ,noOfAvailableTrucks  );
		this.weight = weight;
		this.load = load;
	}
       
       
       
	private double weight;
       private double load ;

	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getLoad() {
		return load;
	}


	public void setLoad(double load) {
		this.load = load;
	}


	@Override
	public String toString() {
		return "Truck [weight=" + weight + ", load=" + load + ", toString()=" + super.toString() + "]";
	}
	   @Override
	    public int compareTo(Vehicle o) {
	        return Integer.compare(name.compareTo(o.name), 0);
	    }
	
	
	
	
	
	
}
