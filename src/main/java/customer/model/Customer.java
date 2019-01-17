package customer.model;

import java.time.LocalDate;

public class Customer {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String civilStatus;
    private final String email;

    public Customer(long id, String firstName, String lastName, LocalDate birthDate, String civilStatus, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.civilStatus = civilStatus;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public String getEmail() {
        return email;
    }
}
