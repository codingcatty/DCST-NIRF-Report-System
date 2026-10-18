import java.util.*;

/**
 * Description: Demonstrates generic programming and collections.
 */
public class NIRFManager<T> {

    // Generic collection can store objects of type T.
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    // Generic method can print a list of any type.
    public static <E> void printList(List<E> values) {
        for (E value : values) {
            System.out.println(value);
        }
    }

    public static void showCollections() {

        // List allows duplicate values.
        List<String> courses = new ArrayList<>();
        courses.add("MCA");
        courses.add("M.Sc. Computer Science");

        // Set stores unique values.
        Set<String> activities = new LinkedHashSet<>();
        activities.add("InfoFest");
        activities.add("InfoFest");
        activities.add("Play-on");

        // Queue processes items in order.
        Queue<String> tasks = new LinkedList<>();
        tasks.offer("Collect student details");
        tasks.offer("Collect staff details");

        // Map stores key-value pairs.
        Map<String, Integer> studentsByYear = new LinkedHashMap<>();
        studentsByYear.put("2024-25", 60);
        studentsByYear.put("2025-26", 65);
        studentsByYear.put("2026-27", 68);

        System.out.println("Courses: " + courses);
        System.out.println("Activities: " + activities);
        System.out.println("Next task: " + tasks.poll());
        System.out.println("Student counts: " + studentsByYear);
    }

    // Throws a custom exception for an invalid year.
    public static void checkYear(int year)
            throws InvalidYearException {

        if (year < 2024 || year > 2026) {
            throw new InvalidYearException(
                    "Year must be between 2024 and 2026.");
        }

        System.out.println("Year accepted: " + year);
    }
}

// Custom exception class.
class InvalidYearException extends Exception {

    public InvalidYearException(String message) {
        super(message);
    }
}