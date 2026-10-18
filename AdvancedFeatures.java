import java.io.*;
import java.lang.reflect.Field;

/**
 * Description: Demonstrates advanced Java features.
 */
public class AdvancedFeatures {

    // Reflection: displays the fields of DCSTMember.
    public static void showReflection() {

        System.out.println("\nFields of DCSTMember:");

        Field[] fields = DCSTMember.class.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    // Persistence: saves an activity object to a file.
    public static void saveRecord(ActivityRecord record,
                                  String fileName) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {

            out.writeObject(record);
            System.out.println("Record saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving record: "
                    + e.getMessage());
        }
    }

    // Loads a previously saved activity object.
    public static void loadRecord(String fileName) {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream(fileName))) {

            ActivityRecord record =
                    (ActivityRecord) in.readObject();

            System.out.println("Loaded record:");
            record.display();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading record: "
                    + e.getMessage());

        } finally {
            System.out.println("File operation completed.");
        }
    }

    // A nested class used to demonstrate cloning.
    static class Address {

        String city;

        Address(String city) {
            this.city = city;
        }
    }

    static class StudentProfile implements Cloneable {

        String name;
        Address address;

        StudentProfile(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        // Shallow copy shares the same Address object.
        public StudentProfile shallowCopy()
                throws CloneNotSupportedException {
            return (StudentProfile) super.clone();
        }

        // Deep copy creates a separate Address object.
        public StudentProfile deepCopy()
                throws CloneNotSupportedException {

            StudentProfile copy =
                    (StudentProfile) super.clone();

            copy.address = new Address(this.address.city);

            return copy;
        }
    }

    public static void showCloning()
            throws CloneNotSupportedException {

        StudentProfile original =
                new StudentProfile("Student A", new Address("Goa"));

        StudentProfile shallow = original.shallowCopy();
        StudentProfile deep = original.deepCopy();

        original.address.city = "Panjim";

        System.out.println("Original address: "
                + original.address.city);

        System.out.println("Shallow copy address: "
                + shallow.address.city);

        System.out.println("Deep copy address: "
                + deep.address.city);
    }
}