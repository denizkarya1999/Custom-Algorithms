package matchPositions;

public class Company {
    private String name, position;
    private int numberOfEmployees, score;
    private boolean recruitsF1, innerMan;
    private String[] skills;

    // Constructor
    public Company(String name, String position, int numberOfEmployees, boolean recruitsF1, boolean innerMan,
            String[] skills) {
        this.name = name;
        this.position = position;
        this.numberOfEmployees = numberOfEmployees;
        this.recruitsF1 = recruitsF1;
        this.innerMan = innerMan;
        this.skills = skills;
    }

    // Score
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Position
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Employees
    public int getnumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setnumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    // Recruits F1
    public boolean getrecruitsF1() {
        return recruitsF1;
    }

    public void setrecruitsF1(boolean recruitsF1) {
        this.recruitsF1 = recruitsF1;
    }

    // Innerman found
    public boolean getinnerMan() {
        return innerMan;
    }

    public void setinnerMan(boolean innerMan) {
        this.innerMan = innerMan;
    }

    // Skills
    public String[] getskills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}