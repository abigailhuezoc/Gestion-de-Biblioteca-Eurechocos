package bibl.user;

import java.time.LocalDate;

public class User extends Person {
    private LocalDate dateOfCreation = LocalDate.now();
    private String cellphone;
    private String email;
    private String

    public User(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth, LocalDate dateOfCreation, String cellphone, String email) {
        super(name, lastName, gender, dui, dateOfBirth);
        this.dateOfCreation = dateOfCreation;
        this.cellphone = cellphone;
        this.email = email;
    }

    //GETTERS
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }


    //SETTERS
    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
