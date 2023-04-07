public class Student {
    private final String firstName;
    private final String lastName;
    private final int year;


    public Student(String firstName, String lastName, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }
}
