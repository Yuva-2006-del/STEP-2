class Phone {
    protected String brand, model;

    Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone Constructor called");
    }
}

class SmartPhone extends Phone {
    private String operatingSystem;

    SmartPhone(String brand, String model, String os) {
        super(brand, model); 
        this.operatingSystem = os;
        System.out.println("SmartPhone Constructor called");
    }

    void showDetails() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", OS: " + operatingSystem);
    }
}

public class Main2 {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("Samsung", "Galaxy S21", "Android");
        sp.showDetails();
    }
}
