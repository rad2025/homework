public class Aircraft {
    //intialize varaibles
    private String planeType;
    private int passengerSeats;
    //constructor
    public Aircraft() {
        //default varaibles
        planeType = "";
        passengerSeats = 0;
    }
    //constructor with parameters
    public Aircraft(String type, int seats) {
        planeType = type;
        passengerSeats = seats;
    }
    //for string fucntion
    public String toString() {
        return "Aircraft Type: " + planeType + ", Seats: " + passengerSeats;
    }
}
