package mk.rus.com.listing.service.domain;

import mk.rus.com.listing.model.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findByUsername(String username);
    User save(User user);
    Optional<User> update(String username, User user);
    Optional<User> deleteByUsername(String username);
}