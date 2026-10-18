import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: Manages academic and non-academic NIRF activities.
 */
public class NIRFReportSystem {

    private List<ActivityRecord> records = new ArrayList<>();

    public void menu(Scanner sc) {

        int choice;

        do {
            System.out.println("\n--- NIRF Activities ---");
            System.out.println("1. Add activity");
            System.out.println("2. Display activities");
            System.out.println("3. Save first activity");
            System.out.println("4. Load saved activity");
            System.out.println("0. Back to main menu");
            System.out.print("Enter choice: ");

            choice = readInt(sc);

            switch (choice) {

                case 1:
                    addActivity(sc);
                    break;

                case 2:
                    displayActivities();
                    break;

                case 3:
                    if (!records.isEmpty()) {
                        AdvancedFeatures.saveRecord(
                                records.get(0), "activities.dat");
                    } else {
                        System.out.println("No activity to save.");
                    }
                    break;

                case 4:
                    AdvancedFeatures.loadRecord("activities.dat");
                    break;

                case 0:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void addActivity(Scanner sc) {

        System.out.print("Activity name: ");
        String name = sc.nextLine();

        System.out.print("Category (Academic/Non-academic): ");
        String category = sc.nextLine();

        System.out.print("Year (2024, 2025, or 2026): ");
        int year = readInt(sc);

        try {
            NIRFManager.checkYear(year);

            records.add(new ActivityRecord(name, category, year));

            System.out.println("Activity added successfully.");

        } catch (InvalidYearException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Activity entry completed.");
        }
    }

    private void displayActivities() {

        if (records.isEmpty()) {
            System.out.println("No activities entered yet.");
        } else {
            for (ActivityRecord record : records) {
                record.display();
            }
        }
    }

    // Handles invalid numeric input.
    private int readInt(Scanner sc) {

        try {
            return Integer.parseInt(sc.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }
}