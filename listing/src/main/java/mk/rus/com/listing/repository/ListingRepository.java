package mk.rus.com.listing.repository;

import mk.rus.com.listing.model.domain.Category;
import mk.rus.com.listing.model.domain.Listing;
import mk.rus.com.listing.model.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByCategory(Category category);

    List<Listing> findByLocation(Location location);
}
