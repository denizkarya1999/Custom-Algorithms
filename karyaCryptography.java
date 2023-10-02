
// Import the HashMap class
import java.util.HashMap;

public class karyaCryptography {

    public static void main(String[] args) {
        String message = "1st buy a cat, 2nd make a joke and 3rd entertain";
        if (decrypt(message)) {
            System.out.println("Message recieved");
        } else {
            System.out.println("Message not recieved");
        }
    }

    static boolean decrypt(String message) {
        boolean detected = false; // Variable to detect message
        int numberOfDetections = 0; // These are the numbers of detections
        HashMap<Character, Character> cryptography = new HashMap<Character, Character>(); // Create a hashmap
        cryptography.put('E', 'H');
        cryptography.put('1', 'E');
        cryptography.put('B', 'L');
        cryptography.put('C', 'P');
        cryptography.put('2', ' ');
        cryptography.put('J', 'U');
        cryptography.put('3', 'S');

        message = message.toUpperCase().replaceAll("\\s", "");
        ; // Make the characters upper case
        for (int i = 0; i < message.length(); i++) {
            if (cryptography.containsKey(message.charAt(i))) {
                numberOfDetections++;
            }
        }
        if (numberOfDetections >= cryptography.size()) {
            return detected = true;
        }
        return detected;
    }
}