import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassListSystem {

    private static StudentManager studentmanager = new StudentManager();
    static Scanner scan = new Scanner(System.in);

    static ArrayList<String> studentfile = new ArrayList<>();

    static String line = "";
    static String program;
    static int year;
    static int isPHD;
    static float avggrade;
    static String lastname;
    static String supervisor;
    static String undergname;

    public static void main(String[] args) {
        int menu = 0;
        while (menu != 8) {

            System.out.println("\n------------------------------------------------------------");
            System.out.println("\nMenu Options:\n");

            System.out.println(
                    "(1) Enter information for a new Student.\n(2) Enter information for a new Graduate Student.\n(3) Show all student information with each attribute on a separate line.\n(4) Print the average of the average grades for all students as well as the total number of students.\n(5) Enter a specific program and show all student information for that program.\n(6) Load student information from an input file.\n(7) Save all student information to an output file.\n(8) End program.");

            System.out.print("\nEnter the option number of the action that you want to perform (1 - 8): ");
            menu = scan.nextInt();
            if (menu <= 8 && menu >= 1) {
                if (menu == 1) {
                    System.out.println("\nEnter Student Program and Year for the Student: ");
                    scan.skip("\\R?");
                    String[] info = scan.nextLine().split(" ");
                    if ((!info[0].equals(null) || !info[info.length - 1].equals(null))
                            && (!info[0].equals("") && !info[info.length - 1].equals("")) && info.length >= 2) {
                        program = info[0];
                        year = Integer.parseInt(info[info.length - 1]);

                        System.out.print("Enter Average grade, or leave blank: ");
                        String grade = scan.nextLine();
                        if (grade.length() == 0) {
                            avggrade = 0.0f;
                        } else {
                            avggrade = (Float.parseFloat(grade));
                        }
                        System.out.print("Enter the Last Name of the Student :");
                        String lname = scan.nextLine();
                        if (lname != "") {
                            lastname = lname;
                            Students studentrecord = new Students(program, year, avggrade, lastname);
                            if (studentmanager.checkstudent(program, year, avggrade, lastname) == null) {
                                studentmanager.addStudents(studentrecord);
                                System.out.println("\n\nData for the Student added successfully.\n");
                            } else {
                                System.out.println("\n\nData for this student already exists.\n");
                            }
                        } else {
                            System.out.println(
                                    "\nLast Name cannot be left Blank. It is manadatory to enter last name, Please try again.\n");
                        }

                    } else {
                        System.out.println("\nUh Oh! The input is incorrect. Please enter your choice again.");
                        System.out.println(
                                "Your Input should be the Program Name(text only) and Year(integer number only) and should not be blank.\n");
                    }
                }

                else if (menu == 2) {

                    System.out.println("\nEnter Student Program and the years worked on Graduate Degree : ");
                    scan.skip("\\R?");
                    String[] info = scan.nextLine().split(" ");
                    if ((!info[0].equals(null) || !info[info.length - 1].equals(null))
                            && (!info[0].equals("") && !info[info.length - 1].equals("")) && info.length >= 2) {
                        program = (info[0]);
                        year = (Integer.parseInt(info[info.length - 1]));

                        System.out.print("Enter Average grade, or leave blank: ");
                        String grade = scan.nextLine();
                        if (grade.length() == 0) {
                            avggrade = (0.0f);
                        } else {
                            avggrade = (Float.parseFloat(grade));
                        }
                        System.out.print("Enter the Name of the Supervisor: ");
                        String supname = scan.nextLine();
                        if (supname.length() != 0) {
                            supervisor = (supname);
                        } else {
                            System.out.println("\nSupervisor Name is Mandatory and Cannot be left Blank.");
                            return;
                        }
                        System.out.print("Enter whether student is PHD or not (Enter 1 for Yes and 0 for No): ");
                        int isphd = scan.nextInt();
                        if (isphd == 1 || isphd == 0) {
                            isPHD = (isphd);
                        } else {
                            System.out.println("\nPlease Enter either 1 or 0 ( 1 for Yes and 0 for No )");
                            return;
                        }
                        System.out.print("Enter the Name of Undergraduate School or leave blank: ");
                        scan.skip("\\R?");
                        String ugsname = scan.nextLine();
                        if (ugsname.length() == 0) {
                            undergname = ("Not_Mentioned");
                        } else {
                            undergname = (ugsname);
                        }
                        System.out.print("Enter the Last Name of the Student :");
                        String lname = scan.nextLine();
                        if (lname != "") {
                            lastname = lname;
                            GraduateStudents studentrecord = new GraduateStudents(program, year, avggrade, lastname,
                                    supervisor, isPHD, undergname);
                            if (studentmanager.checkgradstudent(program, year, avggrade, lastname, supervisor, isPHD,
                                    undergname) == null) {
                                studentmanager.addGraduateStudents(studentrecord);
                                System.out.println("\n\nData for the Student added successfully.\n");
                            } else {
                                System.out.println("\n\nData for this student already exists.\n");
                            }
                        } else {
                            System.out.println(
                                    "Last Name cannot be left Blank. It is manadatory to enter last name, Please try again.");
                        }
                    } else {
                        System.out.println("\nUh Oh! The input is incorrect. Please enter your choice again.");
                        System.out.println(
                                "Your Input should be the Program Name(text only) and Year(integer number only) and should not be blank.\n");
                    }
                }

                else if (menu == 3) {
                    int counter = 1;
                    int gcounter = 1;
                    if (studentmanager.getStudents() != null || studentmanager.getGraduateStudents() != null) {
                        System.out.println("\nData stored for All the Students\n");
                        if (studentmanager.getStudents() != null) {
                            for (Students studentval : studentmanager.getStudents()) {
                                System.out.println("Data for Student Number " + counter);
                                System.out.println(studentval.toString());
                                counter++;
                            }
                        } else {
                            System.out.println("\nNo Data found for Undergraduate Students\n");
                        }
                        if (studentmanager.getGraduateStudents() != null) {
                            for (GraduateStudents gradstudval : studentmanager.getGraduateStudents()) {
                                System.out.println("Data for Graduate Student Number " + gcounter);
                                System.out.println(gradstudval.toString());
                                gcounter++;
                            }
                        }
                    } else {
                        System.out
                                .println("\nNo Data found for Any Students. Please consider adding some data first.\n");
                    }
                }

                else if (menu == 4) {
                    float avg = 0.0f;
                    float avgSum = 0.0f;
                    int totalStud = 0;
                    if (studentmanager.getStudents() != null) {
                        for (Students studval : studentmanager.getStudents()) {
                            avgSum += studval.getAverage();
                            totalStud++;
                        }
                    }
                    if (studentmanager.getGraduateStudents() != null) {
                        for (GraduateStudents gradstudval : studentmanager.getGraduateStudents()) {
                            avgSum += gradstudval.getAverage();
                            totalStud++;
                        }
                    }
                    avg = avgSum / totalStud;
                    System.out.println("\n\nAverage of the average grades for all students is : " + avg);
                    System.out.println("\nTotal number of students is : " + totalStud);
                }

                else if (menu == 5) {
                    int enrol = 0;
                    System.out.print("Enter the Program for which you need information on : ");
                    scan.skip("\\R?");
                    String prog = scan.nextLine();
                    if (studentmanager.getStudents() != null) {
                        for (Students studval : studentmanager.getStudents()) {
                            if (studval.getProgram().equals(prog)) {
                                System.out.println(studval.toString());
                                enrol++;
                            }
                        }
                    }
                    if (studentmanager.getGraduateStudents() != null) {
                        for (GraduateStudents gradstudval : studentmanager.getGraduateStudents()) {
                            if (gradstudval.getProgram().equals(prog)) {
                                System.out.println(gradstudval.toString());
                                enrol++;
                            }
                        }
                    }
                    if (enrol == 0) {
                        System.out.println("\nNo Students are Enrolled in " + prog + " program.\n");
                    }
                }

                else if (menu == 6) {
                    System.out.print("Enter the Name of the File you want to Load Data from: ");
                    scan.skip("\\R?");
                    String fname = scan.nextLine();
                    System.out.print("\nLoading Data from " + fname + "...\n\n");
                    try {
                        BufferedReader input = new BufferedReader(new FileReader(fname));
                        while ((line = input.readLine()) != null) {
                            studentfile.add(line);
                        }
                        for (int i = 0; i < studentfile.size(); i++) {
                            String[] items = studentfile.get(i).split("-");

                            if (items.length == 4) {
                                String uprogram = items[0];
                                int uyear = Integer.parseInt(items[1]);
                                float uavggrade = Float.parseFloat(items[2]);
                                String ulastname = items[3];
                                Students studentrecord = new Students(uprogram, uyear, uavggrade, ulastname);
                                if (studentmanager.checkstudent(uprogram, uyear, uavggrade, ulastname) == null) {
                                    studentmanager.addStudents(studentrecord);
                                }
                            } else if (items.length == 7) {
                                String gprogram = items[0];
                                int gyear = Integer.parseInt(items[1]);
                                float gavggrade = Float.parseFloat(items[2]);
                                String glastname = items[3];
                                String gsuper = items[4];
                                int gisphd = Integer.parseInt(items[5]);
                                String gugname = items[6];
                                GraduateStudents studentrecord = new GraduateStudents(gprogram, gyear, avggrade,
                                        glastname, gsuper, gisphd, gugname);
                                if (studentmanager.checkgradstudent(gprogram, gyear, gavggrade, glastname, gsuper,
                                        gisphd, gugname) == null) {
                                    studentmanager.addGraduateStudents(studentrecord);
                                }
                            }
                        }
                        input.close();
                        System.out.println("\nData loaded from file " + fname + " Successfully.\n");
                    } catch (IOException e) {
                        System.out.println("\nSomething Went Wrong, Could Not open the file " + fname
                                + ", Please recheck the Name of the file you entered and make sure it exists.\n");
                    }

                }

                else if (menu == 7) {
                    System.out.println("\nSaving into students.txt Output File...\n");
                    File studentsrecord = new File("students.txt");
                    try {
                        FileWriter fw = new FileWriter(studentsrecord);
                        Writer output = new BufferedWriter(fw);
                        for (Students studrec : studentmanager.getStudents()) {
                            output.write(studrec.toFileString() + "\n");
                        }
                        for (GraduateStudents gradstudrec : studentmanager.getGraduateStudents()) {
                            output.write(gradstudrec.toFileString() + "\n");
                        }
                        output.close();
                        System.out.println("File Saved Successfully!\n");
                    } catch (IOException e) {
                        System.out.println("\nSomething Went Wrong, Cannot Save to the File.\n");
                    }
                }

                else if (menu == 8) {
                    System.out.println("\nHave a Nice Day!\n");
                    System.exit(0);
                }

            } else {
                System.out.println("\nPlease enter a Vaild Choice ( A number from 1 to 8 )\n");
            }
        }
    }
}