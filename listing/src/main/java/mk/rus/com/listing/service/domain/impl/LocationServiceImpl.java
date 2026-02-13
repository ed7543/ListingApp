package mk.rus.com.listing.service.domain.impl;

import mk.rus.com.listing.model.domain.Location;
import mk.rus.com.listing.repository.LocationRepository;
import mk.rus.com.listing.service.domain.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return this.locationRepository.findById(id);
    }

    @Override
    public Location save(Location location) {
        return this.locationRepository.save(location);
    }

    @Override
    public Optional<Location> update(Long id, Location location) {
        return findById(id)
                .map((existing) -> {
                    existing.setCity(location.getCity());
                    existing.setRegion(location.getRegion());
                    return this.locationRepository.save(existing);
                });
    }

    @Override
    public Optional<Location> deleteById(Long id) {
        return findById(id)
                .map((existing) -> {
                    this.locationRepository.delete(existing);
                    return existing;
                });
    }
}
