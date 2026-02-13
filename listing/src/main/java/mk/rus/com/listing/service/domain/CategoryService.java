package mk.rus.com.listing.service.domain;

import mk.rus.com.listing.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    Optional<Category> update(Long id, Category category);

    Optional<Category> deleteById(Long id);

    List<Category> findSubcategories(Long parentId);
}
