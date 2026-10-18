/**
 * Description: Represents academic activities conducted by DCST.
 */

// First interface.
interface Reportable {
    void makeReport();
}

// Second interface.
interface ParticipantActivity {
    void participate(String personName);
}

// Abstract class.
abstract class AcademicActivity implements Reportable {

    protected String name;
    protected int year;

    // Constructor.
    public AcademicActivity(String name, int year) {
        this.name = name;
        this.year = year;
    }

    // Abstract method: subclasses must implement it.
    public abstract void showDetails();

    // Overloading: same method name, different parameters.
    public void showDetails(String venue) {
        System.out.println(name + " was held at "
                + venue + " in " + year);
    }

    @Override
    public void makeReport() {
        System.out.println("Report recorded for "
                + name + " (" + year + ")");
    }
}

// Workshop inherits the abstract class and implements interfaces.
class Workshop extends AcademicActivity
        implements ParticipantActivity {

    public Workshop(String name, int year) {
        super(name, year);
    }

    // Overriding the abstract method.
    @Override
    public void showDetails() {
        System.out.println("Workshop: " + name
                + ", Year: " + year);
    }

    @Override
    public void participate(String personName) {
        System.out.println(personName
                + " participated in " + name);
    }
}

// StudyTour provides a different implementation.
class StudyTour extends AcademicActivity
        implements ParticipantActivity {

    public StudyTour(String name, int year) {
        super(name, year);
    }

    @Override
    public void showDetails() {
        System.out.println("Study Tour: " + name
                + ", Year: " + year);
    }

    @Override
    public void participate(String personName) {
        System.out.println(personName
                + " joined " + name);
    }
}