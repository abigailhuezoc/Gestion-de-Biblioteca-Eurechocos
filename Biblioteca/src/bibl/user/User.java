package bibl.user;

import java.time.LocalDate;
import java.time.Year;
import java.util.Random;

public class User extends Person {
    private LocalDate dateOfCreation = LocalDate.now();
    private String cellphone;
    private String email;
    private String userId = createCarne();

    public User(String name, String lastName, Gender gender, String dui, LocalDate dateOfBirth, LocalDate dateOfCreation, String cellphone, String email) {
        super(name, lastName, gender, dui, dateOfBirth);
        this.dateOfCreation = dateOfCreation;
        this.cellphone = cellphone;
        this.email = email;
    }

    //METODOS

    @Override
    public void showInformation() {
        super.showInformation();
        System.out.println("Email: " + this.email);
        System.out.println("Celular: " + this.cellphone);
    }

    @Override
    public String createCarne() {
        String year = String.valueOf(Year.now().getValue());
        String name = getName();

        String letters = name.length() >= 2 ? name.substring(0, 2).toUpperCase() : name.toUpperCase();

        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        String formattedNumbers = String.format("%04d", randomNumber);

        return year + letters + formattedNumbers;
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

    public String getUserId() {
        return userId;
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
