package matchPositions;

public class matchPositions {
    public static void main(String[] args) {
        // Create a company and a companies array
        Company datasoft = new Company("Datasoft", "Software Engineer Internship", 1000, true, true,
                new String[] { "C#", "Python" });
        Company johnson = new Company("Johnson", "Software Engineer Internship", 1000, true, true,
                new String[] { "C#", "Python", "EF Core", "SQL" });
        Company loti = new Company("Loti", "Software Engineer Internship", 1000, true, false,
                new String[] { "C#", "Python", "EF Core", "SQL", "React", "Angular", "Kotlin" });
        Company[] companies = new Company[] { datasoft, johnson, loti };

        // Create a requirement
        String[] denizSkills = new String[] { "C#", "Java", "Python", "JavaScript", "HTML", "CSS", "SQL",
                "Entity Framework Core", "ASP.NET Core", "ASP.NET Web API", "Git", "xUnit", "Postman", "Swagger",
                "Bitbucket", "Jira", "Powershell" };
        Requirement deniz = new Requirement("Software Engineer Internship", 500, true, true, denizSkills);

        companies = sortCompanies(companies, deniz);

        for (int a = 0; a < companies.length; a++) {
            System.out.println(companies[a].getName());
        }
    }

    static Company[] sortCompanies(Company[] companies, Requirement assignedRequirement) {
        // Score the company first and add into array
        int[] companyScores = new int[companies.length];
        for (int a = 0; a < companies.length; a++) {
            companies[a].setScore(scoreCompany(companies[a], assignedRequirement));
            companyScores[a] = scoreCompany(companies[a], assignedRequirement);
        }

        // Then sort the companies
        sort(companyScores);

        // Get each company by score and assign into sortedCompanies array
        Company[] sortedCompanies = new Company[companies.length];
        for (int b = 0; b < companies.length; b++) {
            sortedCompanies[b] = search(companies, companyScores[b]);
        }

        return sortedCompanies;
    }

    static int scoreCompany(Company targetCompany, Requirement assignedRequirement) {
        int score = 0;

        if (targetCompany.getnumberOfEmployees() >= assignedRequirement.getnumberOfEmployees())
            score += 10;

        if (!targetCompany.getPosition().equalsIgnoreCase(assignedRequirement.getPosition()))
            throw new IllegalArgumentException("Position must be similar");

        if ((!targetCompany.getrecruitsF1()) && (assignedRequirement.getrecruitsF1() == true))
            throw new IllegalArgumentException("Find a company that recruits F1 Visa Holders");

        if (targetCompany.getinnerMan() == assignedRequirement.getinnerMan())
            score += 50;

        // Send each item to a linear search algorithm
        String[] applicantSkillsArray = assignedRequirement.getskills();
        String[] companySkillsArray = targetCompany.getskills();
        for (int a = 0; a < applicantSkillsArray.length; a++) {
            score += search(companySkillsArray, applicantSkillsArray[a]);
        }

        return score;
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

    // Method overloading to get companies based on score
    static Company search(Company[] arr, int score) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getScore() == score) {
                return arr[i];
            }
        }
        return null;
    }

    static void sort(int[] arr) {
        int j, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
