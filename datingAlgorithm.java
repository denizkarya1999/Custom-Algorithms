import java.util.ArrayList;
import java.util.List;

public class datingAlgorithm {
    public static void main(String[] args) {

        // Create a model profile
        UserProfile myExpectation = new UserProfile(
                null, "Average", 23, "Male", 5, true, true);
        String[] myInterests = new String[] {
                "Programming", "Drawing", "Music", "Kayaking", "Politics", "History", "Action Movies"
        };
        for (int a = 0; a < myInterests.length; a++) {
            myExpectation.addInterest(myInterests[a]);
        }

        // Create Jonathan Springfields
        UserProfile JonathanSpringfields = new UserProfile("Jonathan Springfields", "Average",
                24, "Male", 7, true, true);
        String[] jonathanInterests = new String[] {
                "Biology", "Drawing", "Music", "Kayaking", "Politics", "Mental Health", "Action Movies"
        };
        for (int b = 0; b < myInterests.length; b++) {
            JonathanSpringfields.addInterest(jonathanInterests[b]);
        }

        System.out.println(date(myExpectation, JonathanSpringfields));
    }

    public static boolean date(UserProfile userExpectation, UserProfile currentMatch) {
        // Initial check
        if (!(userExpectation.getHasBachelors() == currentMatch.getHasBachelors())
                || !(userExpectation.getOtherClearance() == currentMatch.getOtherClearance())
                || (currentMatch.getAppearance() == "Ugly")
                || (currentMatch.getLocation() >= (5 * userExpectation.getLocation()))) {
            return false;
        }
        // Search for common interests and store the common interest score
        int dateScore = 0;
        String[] currentInterests = new String[currentMatch.getInterests().size()];
        currentMatch.getInterests().toArray(currentInterests);
        String[] userInterests = new String[userExpectation.getInterests().size()];
        userExpectation.getInterests().toArray(userInterests);
        for (int c = 0; c <= currentInterests.length - 1; c++) {
            dateScore += search(currentInterests, userInterests[c]);
        }

        // Calculate based on expected score
        if (dateScore > 4) {
            return true;
        }

        return false;
    }

    static int search(String[] arr, String sValue) {
        int hit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == sValue) {
                hit++;
            }
        }
        return hit;
    }
}

class UserProfile {
    private String username;
    private int age;
    private String gender;
    private int locationDistance;
    private List<String> interests;
    private String appearance;
    private boolean otherClearance;
    private boolean hasBachelors;

    public UserProfile(String username, String appearance, int age, String gender, int locationDistance,
            boolean otherClearance, boolean hasBachelors) {
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.appearance = appearance;
        this.locationDistance = locationDistance;
        this.interests = new ArrayList<String>();
        this.otherClearance = otherClearance;
        this.hasBachelors = hasBachelors;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getLocation() {
        return locationDistance;
    }

    public String getAppearance() {
        return appearance;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void addInterest(String interest) {
        interests.add(interest);
    }

    public void removeInterest(String interest) {
        interests.remove(interest);
    }

    public boolean getOtherClearance() {
        return otherClearance;
    }

    public boolean getHasBachelors() {
        return hasBachelors;
    }
}