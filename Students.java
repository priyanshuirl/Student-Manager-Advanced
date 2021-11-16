public class Students {
    String program;
    int year;
    float average;
    String lastName;

    public Students(String sprogram, int syear, float saverage, String slastname) {
        this.program = sprogram;
        this.year = syear;
        this.average = saverage;
        this.lastName = slastname;
    }

    public String getProgram() {
        return program;
    }

    public int getYear() {
        return year;
    }

    public float getAverage() {
        return average;
    }

    public String getLastName() {
        return lastName;
    }

    public void setProgram(String sprogram) {
        this.program = sprogram;
    }

    public void setYear(int syear) {
        this.year = syear;
    }

    public void setAverage(float saverage) {
        this.average = saverage;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return "\nProgram : " + program + "\nYear : " + year + "\nAverage Grade : " + average + "\nlast Name : "
                + lastName + "\n";
    }

    public String toFileString() {
        return program + "-" + year + "-" + average + "-" + lastName + " ";
    }
}