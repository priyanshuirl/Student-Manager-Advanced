import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Students> students;

    public ArrayList<Students> getstudents() {
        return students;
    }

    public void addStudents(Students addstudents) {
        if (students == null) {
            students = new ArrayList<Students>();
        }
        students.add(addstudents);
    }
}
