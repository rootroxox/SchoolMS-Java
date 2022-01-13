package Item;
import Helper.CourseNode;
import java.util.ArrayList;

public class Transcript {
    ArrayList<CourseNode> completedCourses = new ArrayList<>();
    double GPA;

    public Transcript() {

    }

    public ArrayList<CourseNode> getCompletedCourses() {
        return completedCourses;
    }

    public void setCompletedCourses(ArrayList<CourseNode> completedCourses) {
        this.completedCourses = completedCourses;
        updateGPA();
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void updateGPA() {
        double gpa;
        double totalPointsEarned = 0.0;
        double totalCreditsAttempted = 0;

        for (CourseNode testNode : this.completedCourses) {
            totalPointsEarned += testNode.getPassCredit() * testNode.getCourse().getCredit();
            totalCreditsAttempted += testNode.getCourse().getCredit();
        }

        gpa = totalPointsEarned/totalCreditsAttempted;
        this.setGPA(gpa);
    }
}
