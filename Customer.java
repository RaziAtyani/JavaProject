import java.util.ArrayList;

public class Customer implements Comparable<Customer>  {

    private final String id;
    private String name;
    private String address;
    private String plan;

    private ArrayList<String> interestedVehicleList = new ArrayList<>();
    private ArrayList<String> rentedVehicleList = new ArrayList<>();


    public Customer(String id,String name, String address, String plan) {
        this.id = id;
        this.name = name;
        this.address = address;
        setPlan(plan);
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) throws RuntimeException {

        if (plan.equalsIgnoreCase("LIMITED")||plan.equalsIgnoreCase("UNLIMITED"))
            this.plan = plan.toUpperCase();
        else {
            throw new RuntimeException("ERROR , Plan must be ( LIMITED or UNLIMITED )");
        }
    }

    public ArrayList<String> getInterestedVehicleList() {
        return interestedVehicleList;
    }

    public void setInterestedVehicleList(ArrayList<String> interestedVehicleList) {
        this.interestedVehicleList = interestedVehicleList;
    }

    public ArrayList<String> getRentedVehicleList() {
        return rentedVehicleList;
    }

    public void setRentedVehicleList(ArrayList<String> rentedVehicleList) {
        this.rentedVehicleList = rentedVehicleList;
    }


    @Override
    public int compareTo(Customer o) {
        return Integer.compare(name.compareTo(o.name), 0);
    }

    @Override
    public String toString() {
        return  "#Customer Id : " + id +"\n  - name : " + name + "\n  - address : " + address + "\n  - plan : " + plan +  "\n  - interestedVehicleList : " + interestedVehicleList +" (By name)"+ "\n  - rentedVehicleList : " + rentedVehicleList+ " (By name)" ;
    }
}

//BY : razi atyani 