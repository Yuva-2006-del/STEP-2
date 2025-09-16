import java.time.LocalDateTime;
import java.util.*;

// a. Immutable Product
public final class Product {
    private final String productId, name, category, manufacturer;
    private final double basePrice, weight;
    private final String[] features;
    private final Map<String, String> specifications;

    private Product(String productId, String name, String category,
                   String manufacturer, double basePrice, double weight,
                   String[] features, Map<String, String> specifications) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = basePrice;
        this.weight = weight;
        this.features = features.clone(); // defensive copy
        this.specifications = new HashMap<>(specifications);
    }

    // Factory methods
    public static Product createElectronics(String id, String name, double price) {
        return new Product(id, name, "Electronics", "DefaultManufacturer",
                price, 1.0, new String[]{"Warranty"}, new HashMap<>());
    }

    public static Product createClothing(String id, String name, double price) {
        return new Product(id, name, "Clothing", "DefaultBrand",
                price, 0.5, new String[]{"Cotton"}, new HashMap<>());
    }

    public static Product createBooks(String id, String name, double price) {
        return new Product(id, name, "Book", "DefaultPublisher",
                price, 0.3, new String[]{"Paperback"}, new HashMap<>());
    }

    // Getters (defensive copy for collections)
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public double getBasePrice() { return basePrice; }
    public double getWeight() { return weight; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String,String> getSpecifications() {
        return new HashMap<>(specifications);
    }

    public final double calculateTax(String region) {
        switch(region.toLowerCase()) {
            case "us": return basePrice * 0.07;
            case "eu": return basePrice * 0.20;
            default: return basePrice * 0.10;
        }
    }
}

// b. Customer
class Customer {
    private final String customerId, email, accountCreationDate;
    private String name, phoneNumber, preferredLanguage;

    public Customer(String customerId, String email, String accountCreationDate) {
        this.customerId = customerId;
        this.email = email;
        this.accountCreationDate = accountCreationDate;
    }

    // Modifiable setters
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }

    // Getters
    public String getCustomerId() { return customerId; }
    public String getEmail() { return email; }
    public String getAccountCreationDate() { return accountCreationDate; }

    // Package-private
    String getCreditRating() { return "Good"; }

    // Public safe profile
    public String getPublicProfile() {
        return "Customer: " + name + " (" + preferredLanguage + ")";
    }
}

// c. ShoppingCart
class ShoppingCart {
    private final String cartId, customerId;
    private final List<Object> items = new ArrayList<>();
    private double totalAmount;
    private int itemCount;

    public ShoppingCart(String cartId, String customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
    }

    public boolean addItem(Object product, int quantity) {
        if (product instanceof Product) {
            for (int i = 0; i < quantity; i++) {
                items.add(product);
            }
            itemCount += quanti
