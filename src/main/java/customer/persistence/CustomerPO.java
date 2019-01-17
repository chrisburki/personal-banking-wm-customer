package customer.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class CustomerPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String key;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String civilStatus;
    private String email;

    public long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
