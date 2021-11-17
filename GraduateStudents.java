public class GraduateStudents extends Students {
    String supervisor;
    int isPHD;
    String undergradschool;

    GraduateStudents(String gprogram, int gyearworked, float gaverage, String glastname, String gsupervisor, int isPHD,
            String undergradschool) throws Exception {
        super(gprogram, gyearworked, gaverage, glastname);

        this.supervisor = gsupervisor;
        this.isPHD = isPHD;
        this.undergradschool = undergradschool;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public int getIsPHD() {
        return isPHD;
    }

    public String getUndergradschool() {
        return undergradschool;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setIsPHD(int isPHD) {
        this.isPHD = isPHD;
    }

    public void setUndergradschool(String undergradschool) {
        this.undergradschool = undergradschool;
    }

    @Override
    public String toString() {
        return "Program : " + program + "\nYears Worked : " + year + "\nAverage Grade : " + average
                + "\nSupervisor Name : " + supervisor + "\nIs student a PHD ? : " + ((isPHD == 1) ? " Yes " : " No ")
                + "\nName of the Undergraduate School Attended: " + undergradschool + "\nLast Name : " + lastName
                + "\n";
    }

    @Override
    public String toFileString() {
        return program + "-" + year + "-" + average + "-" + lastName + "-" + supervisor + "-" + isPHD + "-"
                + undergradschool + " ";
    }

    @Override
    public String toHashString() {
        return program + " " + year + " " + average + " " + lastName + " " + supervisor + " " + isPHD + " "
                + undergradschool + " ";
    }
}
