import java.util.Scanner;

public class ClassListSystem {

    static Scanner scan = new Scanner(System.in);

    static String line;
    static String program;
    static int year;
    static float avggrade;

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
                    } else {
                        System.out.println("\nUh Oh! The input is incorrect. Please enter your choice again.");
                        System.out.println(
                                "Your Input should be the Program Name(text only) and Year(integer number only) and should not be blank.\n");
                    }
                }

                else if (menu == 2) {

                }

                else if (menu == 3) {

                }

                else if (menu == 4) {

                }

                else if (menu == 5) {

                }

                else if (menu == 6) {

                }

                else if (menu == 7) {

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
