
public  abstract class Vehicle implements Comparable<Vehicle>{

	public Vehicle(String name, String type, int noOfavailableVehicle) {
		super();
		this.name = name;
		this.type = type;
		this.noOfavailableVehicle = noOfavailableVehicle;
		
	}

	protected String name;
	protected String type ;
	protected int noOfavailableVehicle;
	
	  
	    public boolean equals(Object o) {         //comparing two  vehicles on their name (return TRUE if equal / FALSE if Not Equal)
	        if(o instanceof Vehicle){   //testing if it is a  vehicle object
	            return ((Vehicle) o).name.equals(this.name);
	        }
	        return false;
	    }                              
	  //setters and getters

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getNoOfavailableVehicle() {
			return noOfavailableVehicle;
		}

		public void setNoOfavailableVehicle(int noOfavailableVehicle) {
			this.noOfavailableVehicle = noOfavailableVehicle;
		}

		@Override
		public String toString() {
			return "Vehicle [name=" + name + ", type=" + type + ", noOfavailableVehicle=" + noOfavailableVehicle
					+ "]";
		}

	}

	//BY : Razi atyani 