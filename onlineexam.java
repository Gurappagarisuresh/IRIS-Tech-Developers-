import java.util.Scanner;

public class onlineexam {
    private String username;
    private String password;
    private boolean loggedIn;
    private boolean sessionClosed;

    public onlineexam() {
        this.loggedIn = false;
        this.sessionClosed = true;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.println("Enter password: ");
        String enteredPassword = scanner.nextLine();

        // Check if username and password are valid
        // Your validation logic here
        if (isValidUser(enteredUsername, enteredPassword)) {
            this.username = enteredUsername;
            this.password = enteredPassword;
            this.loggedIn = true;
            this.sessionClosed = false;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public void updateProfile() {
        if (loggedIn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter new username: ");
            String newUsername = scanner.nextLine();
            System.out.println("Enter new password: ");
            String newPassword = scanner.nextLine();

            // Update the profile with new username and password
            // Your update logic here

            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("You need to be logged in to update your profile.");
        }
    }

    public void selectAnswers() {
        if (loggedIn && !sessionClosed) {
            // Implement MCQ selection logic here
            System.out.println("MCQ answers selected.");
        } else {
            System.out.println("You need to be logged in and have an active session to select answers.");
        }
    }

    public void startTimerAndSubmit() {
        if (loggedIn && !sessionClosed) {
            // Implement timer and auto-submit logic here
            System.out.println("Timer started. Answers will be auto-submitted.");
        } else {
            System.out.println("You need to be logged in and have an active session to start the timer.");
        }
    }

    public void closeSession() {
        if (loggedIn && !sessionClosed) {
            // Implement closing session logic here
            this.sessionClosed = true;
            System.out.println("Session closed.");
        } else {
            System.out.println("You need to be logged in and have an active session to close the session.");
        }
    }

    public void logout() {
        if (loggedIn) {
            // Implement logout logic here
            this.loggedIn = false;
            this.sessionClosed = true;
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("You are already logged out.");
        }
    }

    private boolean isValidUser(String username, String password) {
        // Your validation logic here
        // Return true if the username and password are valid, otherwise false
        // Example validation logic:
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        onlineexam project = new onlineexam();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Select Answers for MCQs");
            System.out.println("4. Start Timer and Auto-Submit");
            System.out.println("5. Close Session");
            System.out.println("6. Logout");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    project.login();
                    break;
                case 2:
                    project.updateProfile();
                    break;
                case 3:
                    project.selectAnswers();
                    break;
                case 4:
                    project.startTimerAndSubmit();
                    break;
                case 5:
                    project.closeSession();
                    break;
                case 6:
                    project.logout();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
}
