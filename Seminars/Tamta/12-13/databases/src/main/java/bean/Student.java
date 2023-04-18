package bean;

import java.util.Date;

public class Student {
    private int studentId;
    private String idNumber;
    private String firstName;
    private String lastName;
    private Date registerDate;

    public int getStudentId() {
        return studentId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
