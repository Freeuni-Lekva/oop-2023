package students;

public class YearFilter implements Filter{
    private final int year;

    public YearFilter(int year) {
        this.year = year;
    }

    @Override
    public boolean filter(Student student) {
        return student.getEnrollmentYear() == year;
    }

    @Override
    public String format() {
        return "year =" + year;
        //year = 2018
    }
}
