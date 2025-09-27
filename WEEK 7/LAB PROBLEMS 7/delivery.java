class Delivery {
  
    public void calculateDelivery(int distance) {
        System.out.println("Basic Delivery: Distance " + distance + " km. Cost = " + (distance * 10));
    }

   
    public void calculateDelivery(int distance, int priorityFee) {
        int cost = distance * 10 + priorityFee;
        System.out.println("Premium Delivery: Distance " + distance + " km + Priority Fee = " + cost);
    }

  
    public void calculateDelivery(int distance, int orders, boolean isGroup) {
        int cost = (distance * 10) - (orders * 5);
        System.out.println("Group Delivery: Distance " + distance + " km with " + orders + " orders. Cost = " + cost);
    }

  
    public void calculateDelivery(int distance, double discount, int freeOver) {
        int cost = distance * 10;
        if (cost >= freeOver) {
            System.out.println("Festival Special: Free delivery (cost " + cost + " >= " + freeOver + ")");
        } else {
            cost = (int)(cost - (cost * discount / 100));
            System.out.println("Festival Special: Distance " + distance + " km after discount = " + cost);
        }
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        Delivery d = new Delivery();
        d.calculateDelivery(5);
        d.calculateDelivery(5, 20);
        d.calculateDelivery(10, 3, true);
        d.calculateDelivery(15, 20, 200);
    }
}
