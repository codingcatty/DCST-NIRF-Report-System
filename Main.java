import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: Main program for the DCST NIRF Report System.
 * Author: Dhanashri
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final List<DCSTMember> members =
            new ArrayList<>();

    private static final NIRFReportSystem reportSystem =
            new NIRFReportSystem();

    public static void main(String[] args) {

        // Sample records for demonstration only.
        members.add(new DCSTMember(
                "Student A", "S001", "CST",
                DCSTMember.MemberType.STUDENT));

        members.add(new DCSTMember(
                "Teacher A", "T001", "CST",
                DCSTMember.MemberType.TEACHING_STAFF));

        int choice;

        do {
            System.out.println("\n==================================");
            System.out.println("     DCST NIRF REPORT SYSTEM");
            System.out.println("==================================");

            System.out.println("1. Add student or staff member");
            System.out.println("2. Display members");
            System.out.println("3. Display member count");
            System.out.println("4. Manage NIRF activities");
            System.out.println("5. Demonstrate OOP concepts");
            System.out.println("6. Reflection and cloning");
            System.out.println("7. Display sample courses and subjects");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {

                case 1:
                    addMember();
                    break;

                case 2:
                    displayMembers();
                    break;

                case 3:
                    DCSTMember.displayMemberCount();
                    break;

                case 4:
                    reportSystem.menu(sc);
                    break;

                case 5:
                    demonstrateOOP();
                    break;

                case 6:
                    advancedFeatures();
                    break;

                case 7:
                    showCourses();
                    break;

                case 0:
                    System.out.println("Thank you. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose a valid option.");
            }

        } while (choice != 0);
    }

    // Reads an integer from the user.
    private static int readInt() {

        try {
            return Integer.parseInt(sc.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
            return -1;
        }
    }

    // Adds a new student or staff member.
    private static void addMember() {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter department: ");
        String dept = sc.nextLine();

        System.out.println("1. Student");
        System.out.println("2. Teaching staff");
        System.out.println("3. Non-teaching staff");

        System.out.print("Select type: ");
        int typeChoice = readInt();

        DCSTMember.MemberType type;

        if (typeChoice == 1) {
            type = DCSTMember.MemberType.STUDENT;

        } else if (typeChoice == 2) {
            type = DCSTMember.MemberType.TEACHING_STAFF;

        } else if (typeChoice == 3) {
            type = DCSTMember.MemberType.NON_TEACHING_STAFF;

        } else {
            System.out.println("Invalid type.");
            return;
        }

        members.add(new DCSTMember(name, id, dept, type));

        System.out.println("Member added successfully.");
    }

    // Displays all members.
    private static void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("No members available.");
        }

        for (DCSTMember member : members) {
            member.display();
        }
    }

    private static void demonstrateOOP() {

        // 1. Object referencing: both variables share one object.
        System.out.println("\n--- Object Referencing ---");

        DCSTMember first = new DCSTMember(
                "Reference Demo", "R001", "CST",
                DCSTMember.MemberType.STUDENT);

        DCSTMember second = first;

        second.name = "Updated Student Name";

        System.out.println("Name through first: " + first.name);
        System.out.println("Name through second: " + second.name);

        // 2. Abstract class and method overriding.
        System.out.println("\n--- Inheritance and Polymorphism ---");

        AcademicActivity a1 =
                new Workshop("ISA Preparation Workshop", 2026);

        AcademicActivity a2 =
                new StudyTour("Industry Study Tour", 2025);

        a1.showDetails();
        a2.showDetails();

        // Method overloading.
        a1.showDetails("DCST Seminar Hall");

        // Interface method implementation.
        a1.makeReport();
        a2.makeReport();

        // 3. Message passing: objects are passed to a method.
        System.out.println("\n--- Message Passing ---");

        sendMessage((ParticipantActivity) a1, "Student A");
        sendMessage((ParticipantActivity) a2, "Student B");

        // 4. Access modifiers.
        System.out.println("\n--- Access Modifiers ---");

        System.out.println("Public name: " + first.name);
        System.out.println("Private ID through getter: "
                + first.getId());
        System.out.println("Protected department: "
                + first.department);

        // 5. Generics and collections.
        System.out.println("\n--- Collections ---");
        NIRFManager.showCollections();

        // 6. Custom exception handling.
        System.out.println("\n--- Exception Handling ---");

        try {
            NIRFManager.checkYear(2026);
        } catch (InvalidYearException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Accepts any object implementing ParticipantActivity.
    private static void sendMessage(
            ParticipantActivity activity, String person) {

        activity.participate(person);
    }

    // Reflection, cloning and persistence demonstration.
    private static void advancedFeatures() {

        System.out.println("\n--- Reflection ---");
        AdvancedFeatures.showReflection();

        System.out.println("\n--- Deep and Shallow Cloning ---");

        try {
            AdvancedFeatures.showCloning();

        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed: " + e.getMessage());
        }

        System.out.println("\n--- Activity Cloning ---");

        ActivityRecord sample = new ActivityRecord(
                "InfoFest", "Non-academic", 2026);

        try {
            ActivityRecord copy = sample.clone();

            System.out.println("Cloned activity:");
            copy.display();

        } catch (CloneNotSupportedException e) {
            System.out.println("Could not clone activity.");
        }

        System.out.println(
                "Use option 4 to save or load activity records.");
    }

    // Displays illustrative courses, subjects and activities.
    private static void showCourses() {

        System.out.println("\n--- Sample Courses and Subjects ---");

        System.out.println("Course: MCA");
        System.out.println("Subjects: Java Programming, "
                + "Database Management Systems, Operating Systems");

        System.out.println("\nCourse: Computer Science");
        System.out.println("Subjects: Data Structures, "
                + "Computer Networks, Software Engineering");

        System.out.println("\nAcademic activities:");
        System.out.println("ISA, Midpoint, SEA, study tours, "
                + "workshops, seminars, placements");

        System.out.println("\nNon-academic activities:");
        System.out.println("InfoFest, Plateaunia, Play-on, "
                + "sports, cultural events, outreach");

        System.out.println(
                "\nNote: Verify official courses and activities "
                + "before submitting the report.");
    }
}