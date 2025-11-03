import java.util.*;

public class ShoppingSystem {

    // ---------- Product Class ----------
    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public void showDetails() {
            System.out.println("Product: " + name + ", Price: ₹" + price);
        }

        public String getName() {
            return name;
        }
    }

    // ---------- Order Class ----------
    static class Order {
        private String orderId;
        private List<Product> products;

        public Order(String orderId) {
            this.orderId = orderId;
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
            System.out.println("Added product '" + product.getName() + "' to Order " + orderId);
        }

        public void showOrderDetails() {
            System.out.println("\nOrder " + orderId + " contains:");
            for (Product product : products) {
                product.showDetails();
            }
        }

        public String getOrderId() {
            return orderId;
        }
    }

    // ---------- Customer Class ----------
    static class Customer {
        private String name;
        private String email;
        private List<Order> orders;

        public Customer(String name, String email) {
            this.name = name;
            this.email = email;
            this.orders = new ArrayList<>();
        }

        public void placeOrder(Order order) {
            orders.add(order);
            System.out.println(name + " placed Order " + order.getOrderId());
        }

        public void showCustomerOrders() {
            System.out.println("\nOrders placed by " + name + ":");
            for (Order order : orders) {
                order.showOrderDetails();
            }
        }
    }

    // ---------- Main Demo ----------
    public static void main(String[] args) {
        // Step 1 - Create Customer
        Customer customer1 = new Customer("Amit", "amit@gmail.com");

        // Step 2 - Create Products
        Product product1 = new Product("Laptop", 55000);
        Product product2 = new Product("Mobile", 20000);
        Product product3 = new Product("Mouse", 500);

        // Step 3 - Create Orders and add Products
        Order order1 = new Order("O001");
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order("O002");
        order2.addProduct(product3);

        // Step 4 - Associate orders with Customer
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        // Step 5 - Show all Orders and Products
        customer1.showCustomerOrders();
    }
}
