import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Students> students;
    private ArrayList<GraduateStudents> graduatestudents;

    public ArrayList<Students> getStudents() {
        return students;
    }

    public ArrayList<GraduateStudents> getGraduateStudents() {
        return graduatestudents;
    }

    public void addStudents(Students addstudents) {
        if (students == null) {
            students = new ArrayList<Students>();
        }
        students.add(addstudents);
    }

    public void addGraduateStudents(GraduateStudents addstudents) {
        if (graduatestudents == null) {
            graduatestudents = new ArrayList<GraduateStudents>();
        }
        graduatestudents.add(addstudents);
    }

    public Students checkstudent(String program, int year, float avggrade, String lastname) {
        if (students != null) {
            for (Students students : students) {
                if (students.getProgram().equals(program) && students.getYear() == year
                        && students.getAverage() == avggrade && students.getLastName().equals(lastname)) {
                    return students;
                }
            }
        }
        return null;
    }

    public GraduateStudents checkgradstudent(String program, int year, float avggrade, String lastname,
            String supervisor, int isphd, String ugname) {
        if (graduatestudents != null) {
            for (GraduateStudents gradstudents : graduatestudents) {
                if (gradstudents.getProgram().equals(program) && gradstudents.getYear() == year
                        && gradstudents.getAverage() == avggrade && gradstudents.getLastName().equals(lastname)
                        && gradstudents.getLastName().equals(lastname) && gradstudents.getIsPHD() == isphd
                        && gradstudents.getUndergradschool().equals(ugname)) {
                    return gradstudents;
                }
            }
        }
        return null;
    }
}
