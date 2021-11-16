public class Students {
    String program;
    int year;
    float average;

    public Students(String sprogram, int syear, float saverage) {
        this.program = sprogram;
        this.year = syear;
        this.average = saverage;
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

    public void setProgram(String sprogram) {
        this.program = sprogram;
    }

    public void setYear(int syear) {
        this.year = syear;
    }

    public void setAverage(float saverage) {
        this.average = saverage;
    }

    public String toString() {
        return "\nProgram : " + program + "\nYear : " + year + "\nAverage Grade : " + average + "\n";
    }

    public String toFileString() {
        return program + "-" + year + "-" + average + " ";
    }
}