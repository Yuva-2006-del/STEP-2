package com.company.security;

public class AccessModifierDemo {

    // Fields with different access modifiers
    private int privateField;
    String defaultField;           // package-private (no modifier)
    protected double protectedField;
    public boolean publicField;

    // Constructor to initialize all fields
    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    // Methods with different access modifiers
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {  // package-private
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Public method to test access within same class
    public void testInternalAccess() {
        System.out.println("--- Inside testInternalAccess() ---");
        // Access all fields
        System.out.println("privateField: " + privateField);
        System.out.println("defaultField: " + defaultField);
        System.out.println("protectedField: " + protectedField);
        System.out.println("publicField: " + publicField);

        // Call all methods
        privateMethod();      // accessible
        defaultMethod();      // accessible
        protectedMethod();    // accessible
        publicMethod();       // accessible
    }

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "default", 3.14, true);

        // Accessing fields
        // System.out.println(demo.privateField); // ❌ Error: privateField has private access
        System.out.println(demo.defaultField);     // ✅ OK: same package
        System.out.println(demo.protectedField);   // ✅ OK: same package
        System.out.println(demo.publicField);      // ✅ OK: public

        // Accessing methods
        // demo.privateMethod(); // ❌ Error: privateMethod has private access
        demo.defaultMethod();   // ✅ OK: same package
        demo.protectedMethod(); // ✅ OK: same package
        demo.publicMethod();    // ✅ OK: public

        // Demonstrate internal access
        demo.testInternalAccess();
    }
}
