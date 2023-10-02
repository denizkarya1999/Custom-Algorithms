import java.util.ArrayList;
import java.util.List;

public class karyaTagGenerator {
    public static void main(String[] args) {
        String name, visa, schoolCode, tag;
        name = "Deniz Karya Acikbas";
        visa = "F1";
        schoolCode = "UMD";
        tag = tagGenerator(name, visa, schoolCode);

        System.out.println(tag);
    }

    static String tagGenerator(String name, String visa, String schoolCode) {
        String prototype = "";
        String generatedID = "11024795";

        // Detect index of blanks
        List<Integer> blankLists = new ArrayList<Integer>();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                blankLists.add(i);
            }
        }

        // Cut until first blank
        int firstNameLength = blankLists.get(0);

        // Initialize the first name
        for (int a = 0; a < firstNameLength; a++) {
            prototype += name.charAt(a);
        }

        // Initialize the first two part of generatedID
        for (int b = 0; b < 2; b++) {
            prototype += generatedID.charAt(b);
        }

        // Initialize the middle name
        int middleNameLength = blankLists.get(1);
        for (int c = firstNameLength + 1; c < middleNameLength; c++) {
            prototype += name.charAt(c);
        }

        // Initialize the second version
        for (int d = 2; d < 4; d++) {
            prototype += generatedID.charAt(d);
        }

        // Initialize surname
        for (int e = middleNameLength + 1; e < name.length(); e++) {
            prototype += name.charAt(e);
        }

        // Initialize last generated ID
        prototype += generatedID.substring(4, 8);

        // Initialize school code
        prototype += schoolCode;

        return prototype;
    }
}