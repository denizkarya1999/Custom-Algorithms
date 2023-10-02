package matchPositions;

public class Requirement {
    private String position;
    private int numberOfEmployees;
    private boolean recruitsF1, innerMan;
    private String[] skills;

    // Constructor
    public Requirement(String position, int numberOfEmployees, boolean recruitsF1, boolean innerMan,
            String[] skills) {
        this.position = position;
        this.numberOfEmployees = numberOfEmployees;
        this.recruitsF1 = recruitsF1;
        this.innerMan = innerMan;
        this.skills = skills;
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
