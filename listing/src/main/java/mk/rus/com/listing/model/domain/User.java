package mk.rus.com.listing.model.domain;

import jakarta.persistence.*;
import lombok.*;
import mk.rus.com.listing.model.enums.Role;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_users")
public class User {

    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "owner")
    private List<Listing> listings;


}
