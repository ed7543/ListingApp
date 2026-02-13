package mk.rus.com.listing.service.domain;

import mk.rus.com.listing.model.domain.Listing;
import mk.rus.com.listing.model.domain.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> findAll();
    Optional<Location> findById(Long id);
    Location save(Location location);
    Optional<Location> update(Long id, Location location);
    Optional<Location> deleteById(Long id);
}
