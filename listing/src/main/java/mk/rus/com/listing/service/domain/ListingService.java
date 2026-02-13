package mk.rus.com.listing.service.domain;

import mk.rus.com.listing.model.domain.Category;
import mk.rus.com.listing.model.domain.Listing;
import mk.rus.com.listing.model.domain.Location;

import java.util.List;
import java.util.Optional;

public interface ListingService {
    List<Listing> findAll();
    List<Listing> findAllByCategory(Category category);
    List<Listing> findAllByLocation(Location location);
    Listing save(Listing listing);
    Optional<Listing> findById(Long id);
    Optional<Listing> update(Long id, Listing listing);
    Optional<Listing> deleteById(Long id);
}
