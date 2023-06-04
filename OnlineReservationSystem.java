
import java.util.Scanner;

class ReservationSystem {
    private String loginId;
    private String password;
    public ReservationSystem(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    public boolean login(String inputLoginId, String inputPassword) 
    {
        return loginId.equals(inputLoginId) && password.equals(inputPassword);
    }

    public void reserveTicket(String trainNumber, String classType, String dateOfJourney, String from, String to) {
        // Logic to save the reservation details in the central database
        System.out.println("Ticket reserved successfully!");
    }

    public void cancelTicket(String pnrNumber) {
        // Logic to retrieve and display information related to the PNR number
        System.out.println("Ticket cancellation confirmed!");
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem("admin", "password");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Login ID: ");
        String loginId = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (system.login(loginId, password)) {
            System.out.println("Login successful!");

            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Train Number: ");
                    String trainNumber = scanner.nextLine();
                    System.out.print("Class Type: ");
                    String classType = scanner.nextLine();
                    System.out.print("Date of Journey: ");
                    String dateOfJourney = scanner.nextLine();
                    System.out.print("From: ");
                    String from = scanner.nextLine();
                    System.out.print("To: ");
                    String to = scanner.nextLine();

                    system.reserveTicket(trainNumber, classType, dateOfJourney, from, to);
                    break;

                case 2:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("PNR Number: ");
                    String pnrNumber = scanner.nextLine();

                    system.cancelTicket(pnrNumber);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Login failed! Invalid credentials.");
        }

        scanner.close();
    }
}