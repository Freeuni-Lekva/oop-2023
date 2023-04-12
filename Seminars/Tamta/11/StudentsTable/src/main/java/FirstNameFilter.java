public class FirstNameFilter implements Filter {
    private final String firstNameStarter;


    public FirstNameFilter(String firstNameStarter) {
        this.firstNameStarter = firstNameStarter;
    }


    @Override
    public boolean filter(Student student) {
        return student.getFirstName().startsWith(firstNameStarter);
    }
}
