package mk.rus.com.listing.service.domain.impl;

import mk.rus.com.listing.model.domain.User;
import mk.rus.com.listing.repository.UserRepository;
import mk.rus.com.listing.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findById(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> update(String username, User user) {
        return findByUsername(username)
                .map(existing -> {
                    existing.setName(user.getName());
                    existing.setSurname(user.getSurname());
                    existing.setEmail(user.getEmail());
                    existing.setRole(user.getRole());
                    existing.setListings(user.getListings());
                    existing.setPassword(user.getPassword()); // if not using security yet
                    return userRepository.save(existing);
                });
    }

    @Override
    public Optional<User> deleteByUsername(String username) {
        Optional<User> user = findByUsername(username);
        user.ifPresent(userRepository::delete);
        return user;
    }
}
