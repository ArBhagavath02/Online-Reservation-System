import java.util.*;

public class ReservationSystem {
    private List<User> users;
    private List<Reservation> reservations;
    private Scanner scanner;

    public ReservationSystem() {
        users = new ArrayList<>();
        reservations = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Adding a default user for testing
        users.add(new User("admin", "admin"));
    }

    public void start() {
        System.out.println("Welcome to Online Reservation System");
        if (login()) {
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Make a Reservation");
                System.out.println("2. Cancel a Reservation");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        makeReservation();
                        break;
                    case 2:
                        cancelReservation();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        System.out.println("Thank you for using the Online Reservation System!");
    }

    private boolean login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid credentials. Please try again.");
        return false;
    }

    private void makeReservation() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter train number: ");
        String trainNumber = scanner.nextLine();
        System.out.print("Enter train name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey (YYYY-MM-DD): ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter from (place): ");
        String from = scanner.nextLine();
        System.out.print("Enter to (destination): ");
        String to = scanner.nextLine();

        Reservation reservation = new Reservation(username, trainNumber, trainName, classType, dateOfJourney, from, to);
        reservations.add(reservation);
        System.out.println("Reservation made successfully! " + reservation);
    }

    private void cancelReservation() {
        System.out.print("Enter Reservation ID: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Reservation reservationToCancel = null;
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId() == reservationId) {
                reservationToCancel = reservation;
                break;
            }
        }

        if (reservationToCancel != null) {
            reservations.remove(reservationToCancel);
            System.out.println("Reservation cancelled successfully! " + reservationToCancel);
        } else {
            System.out.println("Reservation ID not found.");
        }
    }

    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        system.start();
    }
}
