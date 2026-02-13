1. Listing CRUD

These are the core functionalities for your Listing entity:

Create a new listing

Form in HTML where a user can choose a category, location, title, description, price, and owner.

Map form submission to a POST endpoint.

Read / View listings

A main page showing all listings in a table or cards.

Optional: Add filters by category or location.

Optional: Detail page per listing.

Update listings

Edit page for a listing.

Pre-fill current values in the form.

Delete listings

Add a delete button on listing cards or detail page.

2. Category and Location management

If you want to allow CRUD for categories or locations:

View categories and subcategories in a tree or dropdown.

Add/edit/delete categories and locations (optional for now, can also keep them static).

3. User management (optional at this stage)

List all users (basic table).

Add/edit users (plain password, no security yet).

You can skip login/registration until you implement security.

4. HTML Frontend pages

Home page / listings page – show all listings.

Listing detail page – show details of a selected listing.

Add/Edit listing forms – HTML forms for creating/updating listings.

Category/Location filters – optional dropdown filters.

5. Optional nice-to-have features

Search by title or description (simple contains query).

Sort listings by price or location.

Show categories in a nested view (vehicles → cars, motorcycles).