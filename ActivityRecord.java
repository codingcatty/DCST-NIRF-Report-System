import java.io.Serializable;

/**
 * Description: Stores information about one NIRF activity.
 */
public class ActivityRecord implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String activityName;
    private String category;
    private int year;

    // Constructor initializes all attributes.
    public ActivityRecord(String activityName,
                          String category, int year) {
        this.activityName = activityName;
        this.category = category;
        this.year = year;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    // Displays activity details.
    public void display() {
        System.out.println("Year: " + year);
        System.out.println("Category: " + category);
        System.out.println("Activity: " + activityName);
        System.out.println("----------------------");
    }

    // Creates a shallow copy of this object.
    @Override
    public ActivityRecord clone()
            throws CloneNotSupportedException {
        return (ActivityRecord) super.clone();
    }
}