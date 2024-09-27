public class Reservation {
    private static int idCounter = 1;
    private int reservationId;
    private String username;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(String username, String trainNumber, String trainName, String classType, 
                       String dateOfJourney, String from, String to) {
        this.reservationId = idCounter++;
        this.username = username;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getUsername() {
        return username;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Username: " + username + 
               ", Train Number: " + trainNumber + ", Train Name: " + trainName + 
               ", Class Type: " + classType + ", Date of Journey: " + dateOfJourney + 
               ", From: " + from + ", To: " + to;
    }
}
