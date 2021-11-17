public class Students {
    String program;
    int year;
    float average;
    String lastName;
    int hashid;

    public Students(String sprogram, int syear, float saverage, String slastname) throws Exception {
        if (saverage >= 0 && saverage <= 100) {
            this.program = sprogram;
            this.year = syear;
            this.average = saverage;
            this.lastName = slastname;
        } else {
            throw new Exception("\nFatal error: Average Grade should be between 0 and 100 (inclusive).");
        }
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

    public int getHashid() {
        return hashid;
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

    public void setHashid(int hashid) {
        this.hashid = hashid;
    }

    public String toString() {
        return "Program : " + program + "\nYear : " + year + "\nAverage Grade : " + average + "\nlast Name : "
                + lastName + "\n";
    }

    public String toFileString() {
        return program + "-" + year + "-" + average + "-" + lastName + " ";
    }

    public String toHashString() {
        return program + " " + year + " " + average + " " + lastName + " ";
    }
}