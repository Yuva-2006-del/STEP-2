abstract class Vehicle { public abstract void dispatch(); }

class Bus extends Vehicle {
    public void dispatch() { System.out.println("🚌 Bus dispatched on fixed route. Capacity: 50 passengers."); }
}

class Taxi extends Vehicle {
    public void dispatch() { System.out.println("🚖 Taxi dispatched. Fare based on distance."); }
}

class Train extends Vehicle {
    public void dispatch() { System.out.println("🚆 Train dispatched as per schedule. Multiple cars available."); }
}

class Bike extends Vehicle {
    public void dispatch() { System.out.println("🚲 Bike dispatched for eco-friendly trip."); }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] fleet = { new Bus(), new Taxi(), new Train(), new Bike() };
        for (Vehicle v : fleet) v.dispatch(); // runtime polymorphism
    }
}
