package GetExcel_Data;

public class User {
    String firstName;
    String lastName;
    String dob;
    String cellPhone;

    public User(String firstName, String lastName, String dob, String cellPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "User [FirstName=" + firstName + ", LastName=" + lastName +
               ", DOB=" + dob + ", CellPhone=" + cellPhone + "]";
    }
}

