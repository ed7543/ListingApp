package mk.rus.com.listing.config.initialization;

import jakarta.annotation.PostConstruct;
import mk.rus.com.listing.model.domain.Category;
import mk.rus.com.listing.model.domain.Listing;
import mk.rus.com.listing.model.domain.Location;
import mk.rus.com.listing.model.domain.User;
import mk.rus.com.listing.model.enums.Role;
import mk.rus.com.listing.repository.CategoryRepository;
import mk.rus.com.listing.repository.ListingRepository;
import mk.rus.com.listing.repository.LocationRepository;
import mk.rus.com.listing.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Profile("!test")
@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ListingRepository listingRepository;
    private final LocationRepository locationRepository;


    public DataInitializer(UserRepository userRepository,
                           CategoryRepository categoryRepository,
                           ListingRepository listingRepository,
                           LocationRepository locationRepository
                           ) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.listingRepository = listingRepository;
        this.locationRepository = locationRepository;

    }

    @PostConstruct
    public void init() {

        // ----------------- USERS -----------------
        User john = userRepository.save(new User(
                "john",
                "john",
                "John",
                "Doe",
                "john@email.com",
                Role.ROLE_USER,
                null
        ));

        User anna = userRepository.save(new User(
                "anna",
               "anna",
                "Anna",
                "Smith",
                "anna@email.com",
                Role.ROLE_USER,
                null
        ));

        User admin = userRepository.save(new User(
                "admin",
                "admin",
                "Admin",
                "Admin",
                "admin@email.com",
                Role.ROLE_ADMIN,
                null
        ));

        // ----------------- LOCATIONS -----------------
        Location skopje = locationRepository.save(new Location(null, "Skopje", "Skopje Region", null));
        Location bitola = locationRepository.save(new Location(null, "Bitola", "Pelagonia", null));
        Location ohrid = locationRepository.save(new Location(null, "Ohrid", "Southwest", null));
        Location tetovo = locationRepository.save(new Location(null, "Tetovo", "Polog", null));

        // ----------------- CATEGORIES -----------------
        Category vehicles = categoryRepository.save(new Category(null, "Vehicles", null, null, null));
        Category cars = categoryRepository.save(new Category(null, "Cars", vehicles, null, null));
        Category motorcycles = categoryRepository.save(new Category(null, "Motorcycles", vehicles, null, null));

        Category electronics = categoryRepository.save(new Category(null, "Electronics", null, null, null));
        Category phones = categoryRepository.save(new Category(null, "Phones", electronics, null, null));
        Category laptops = categoryRepository.save(new Category(null, "Laptops", electronics, null, null));

        Category realEstate = categoryRepository.save(new Category(null, "Real Estate", null, null, null));
        Category apartments = categoryRepository.save(new Category(null, "Apartments", realEstate, null, null));
        Category houses = categoryRepository.save(new Category(null, "Houses", realEstate, null, null));

        // ----------------- LISTINGS -----------------
        listingRepository.save(new Listing(
                null,
                "BMW 320d 2015",
                "Well maintained BMW, automatic, full equipment.",
                new BigDecimal("12500.00"),
                skopje,
                cars,
                john
        ));

        listingRepository.save(new Listing(
                null,
                "iPhone 14 Pro",
                "Like new, 256GB, space black.",
                new BigDecimal("850.00"),
                bitola,
                phones,
                anna
        ));

        listingRepository.save(new Listing(
                null,
                "2 Bedroom Apartment for Rent",
                "Fully furnished apartment in city center.",
                new BigDecimal("350.00"),
                ohrid,
                apartments,
                john
        ));

        listingRepository.save(new Listing(
                null,
                "Yamaha R6",
                "Excellent condition, 2020 model.",
                new BigDecimal("9800.00"),
                tetovo,
                motorcycles,
                anna
        ));

        listingRepository.save(new Listing(
                null,
                "Gaming Laptop ASUS ROG",
                "RTX 3060, 16GB RAM, 1TB SSD.",
                new BigDecimal("1400.00"),
                skopje,
                laptops,
                john
        ));
    }
}
