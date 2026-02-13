package mk.rus.com.listing.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "app_users")
public class User {
    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;
}
