package bibl.user;

import java.time.LocalDate;

public class Person {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String dui;
    private Gender gender;

    public Person(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth) {
        this.setName(name);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setDui(dui);
        this.setDateOfBirth(dateOfBirth);
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDui() {
        return dui;
    }

    public Gender getGender() {
        return gender;
    }

    //SETTERS

    public void setName(String name) {
        if (name != null){
            this.name = name;}
    }

    public void setLastName(String lastName) {
        if (lastName != null){
            this.lastName = lastName;
        }
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDui(String dui) {
        if (dui.length() == 9){
            this.dui = dui;
        }
    }
}
