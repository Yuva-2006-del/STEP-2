class Booking {

    public void calculatePrice(String roomType, int nights) {
        int baseRate = roomType.equals("Deluxe") ? 3000 : 2000;
        int cost = baseRate * nights;
        System.out.println("Standard Booking: " + roomType + " for " + nights + " nights. Cost = ₹" + cost);
    }

   
    public void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        int baseRate = roomType.equals("Deluxe") ? 3000 : 2000;
        int cost = (int)(baseRate * nights * seasonalMultiplier);
        System.out.println("Seasonal Booking: " + roomType + " × " + seasonalMultiplier + " = ₹" + cost);
    }


    public void calculatePrice(String roomType, int nights, int corporateDiscount, boolean mealPackage) {
        int baseRate = roomType.equals("Deluxe") ? 3000 : 2000;
        int cost = baseRate * nights - corporateDiscount;
        if (mealPackage) cost += 1000;
        System.out.println("Corporate Booking: " + roomType + ", Nights: " + nights + ", Discount: ₹" 
                           + corporateDiscount + ", Meals included. Total = ₹" + cost);
    }

    
    public void calculatePrice(String roomType, int nights, int guests, int decorationFee, boolean catering) {
        int baseRate = roomType.equals("Deluxe") ? 3000 : 2000;
        int cost = baseRate * nights + decorationFee;
        if (catering) cost += guests * 500;
        System.out.println("Wedding Package: " + guests + " guests, Decoration ₹" + decorationFee 
                           + ", Catering = " + (catering ? "Yes" : "No") + ". Total = ₹" + cost);
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Booking b = new Booking();
        b.calculatePrice("Deluxe", 3);
        b.calculatePrice("Standard", 2, 1.2);
        b.calculatePrice("Deluxe", 5, 2000, true);
        b.calculatePrice("Standard", 2, 100, 5000, true);
    }
}
