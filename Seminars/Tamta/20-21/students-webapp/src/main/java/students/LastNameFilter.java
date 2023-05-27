package students;

public class LastNameFilter implements Filter {
    private final String lastNameStarter;


    public LastNameFilter(String lastNameStarter) {
        this.lastNameStarter = lastNameStarter;
    }


    @Override
    public boolean filter(Student student) {
        return student.getLastName().startsWith(lastNameStarter);
    }

    @Override
    public String format() {
        return "lastname like '%" + lastNameStarter + "%'";
        //firstname like '%topuria%'
    }
}
