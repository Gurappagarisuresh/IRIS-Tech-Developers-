import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        
        Random random = new Random();
        int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        
        boolean isGuessed = false;
        int attempts = 0;
        
        while (!isGuessed && attempts < maxAttempts) {
            String guessStr = JOptionPane.showInputDialog(null, "Guess the number (between " + minRange + " and " + maxRange + "):");
            
            // Check if the user cancels or closes the dialog
            if (guessStr == null) {
                break;
            }
            
            int guess = Integer.parseInt(guessStr);
            
            if (guess == generatedNumber) {
                isGuessed = true;
                score += maxAttempts - attempts;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number.");
            } else if (guess < generatedNumber) {
                JOptionPane.showMessageDialog(null, "Too low. Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Too high. Try again.");
            }
            
            attempts++;
        }
        
        if (!isGuessed) {
            JOptionPane.showMessageDialog(null, "Out of attempts. The number was: " + generatedNumber);
        }
        
        JOptionPane.showMessageDialog(null, "Your score: " + score);
    }
}
