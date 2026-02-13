package mk.rus.com.listing.web.controllers;

import mk.rus.com.listing.model.domain.Listing;
import mk.rus.com.listing.service.domain.ListingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/listings")
public class ListingController {

    private final ListingService listingService;

    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    // Show all listings
    @GetMapping
    public String listAll(Model model) {
        List<Listing> listings = listingService.findAll();
        model.addAttribute("listings", listings);
        return "listings";
    }

    // Form to add a new listing
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "add-listing";
    }

    // Handle form submission
    @PostMapping("/add")
    public String addListing(@ModelAttribute Listing listing) {
        // For simplicity, we only use title, description, and price
        listing.setPrice(new BigDecimal(listing.getPrice().toString()));
        listingService.save(listing);
        return "redirect:/listings";
    }
}
