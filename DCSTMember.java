/**
 * Description: Stores student and staff details for the DCST NIRF report.
 * Author: Dhanashri
 */
public class DCSTMember {

    // Public: accessible from other classes.
    public String name;

    // Private: accessible only inside this class.
    private String id;

    // Protected: accessible in the same package and subclasses.
    protected String department;

    private MemberType type;

    // Enum: represents the different types of members.
    public enum MemberType {
        STUDENT,
        TEACHING_STAFF,
        NON_TEACHING_STAFF
    }

    // Static counter shared by all objects.
    private static int memberCount = 0;

    // Constructor initializes all attributes.
    public DCSTMember(String name, String id,
                      String department, MemberType type) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.type = type;

        memberCount++;
    }

    // Getter for the private ID.
    public String getId() {
        return id;
    }

    public MemberType getType() {
        return type;
    }

    // Displays member details.
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Type: " + type);
        System.out.println("----------------------");
    }

    // Static method displays the total number of objects created.
    public static void displayMemberCount() {
        System.out.println("Total members created: " + memberCount);
    }
}