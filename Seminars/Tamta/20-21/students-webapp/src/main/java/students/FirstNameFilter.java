package students;

public class FirstNameFilter implements Filter {
    private final String firstNameFilter;


    public FirstNameFilter(String firstNameFilter) {
        this.firstNameFilter = firstNameFilter;
    }


    @Override
    public boolean filter(Student student) {
        return student.getLastName().startsWith(firstNameFilter);
    }

    @Override
    public String format() {
        return "firstname like '%" + firstNameFilter + "%'";
        //firstname like '%tamta%'
    }

}
