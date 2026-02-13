package mk.rus.com.listing.service.domain.impl;

import mk.rus.com.listing.model.domain.Category;
import mk.rus.com.listing.repository.CategoryRepository;
import mk.rus.com.listing.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        return findById(id)
                .map((existing) -> {
                    existing.setName(category.getName());
                    existing.setParent(category.getParent());

                    return categoryRepository.save(existing);
                });
    }

    @Override
    public Optional<Category> deleteById(Long id) {
        Optional<Category> category = findById(id);
        category.ifPresent(this.categoryRepository::delete);
        return category;
    }

    @Override
    public List<Category> findSubcategories(Long parentId) {
        return categoryRepository.findByParentId(parentId);
    }
}
