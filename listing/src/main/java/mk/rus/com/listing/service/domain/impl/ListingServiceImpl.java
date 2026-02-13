package mk.rus.com.listing.service.domain.impl;

import mk.rus.com.listing.model.domain.Category;
import mk.rus.com.listing.model.domain.Listing;
import mk.rus.com.listing.model.domain.Location;
import mk.rus.com.listing.repository.CategoryRepository;
import mk.rus.com.listing.repository.ListingRepository;
import mk.rus.com.listing.service.domain.ListingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {

    private final ListingRepository listingRepository;

    public ListingServiceImpl(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @Override
    public List<Listing> findAll() {
        return this.listingRepository.findAll();
    }

    @Override
    public List<Listing> findAllByCategory(Category category) {
        return listingRepository.findByCategory(category);
    }

    @Override
    public List<Listing> findAllByLocation(Location location) {
        return listingRepository.findByLocation(location);
    }

    @Override
    public Listing save(Listing listing) {
        return this.listingRepository.save(listing);
    }

    @Override
    public Optional<Listing> findById(Long id) {
        return this.listingRepository.findById(id);
    }

    @Override
    public Optional<Listing> update(Long id, Listing listing) {
        return findById(id)
                .map((existing) -> {
                    existing.setTitle(listing.getTitle());
                    existing.setDescription(listing.getDescription());
                    existing.setPrice(listing.getPrice());
                    existing.setLocation(listing.getLocation());
                    existing.setCategory(listing.getCategory());
                    existing.setOwner(listing.getOwner());
                    return listingRepository.save(existing);
                });
    }

    @Override
    public Optional<Listing> deleteById(Long id) {
        return findById(id).map(listing -> {
            listingRepository.delete(listing);
            return listing;
        });
    }
}
