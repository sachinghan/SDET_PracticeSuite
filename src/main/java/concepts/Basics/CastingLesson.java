package concepts.Basics;

public class CastingLesson {

    static class Phone {
        void makeCall() {
            System.out.println("Making a basic voice call...");
        }
    }

    static class SmartPhone extends Phone {
        @Override
        void makeCall() {
            System.out.println("Making a High-Definition Video call...");
        }

        void browseWeb() {
            System.out.println("Browsing the internet on a 5G network!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 1. UPCASTING (Treating Child as Parent) ===");
        // We put a SmartPhone into a "Phone" box.
        // Left side (Label/Remote) = Phone | Right side (Reality) = SmartPhone
        Phone myBox = new SmartPhone();

        // We can only use the buttons available on the "Phone" label.
        myBox.makeCall(); 
        
        // myBox.browseWeb(); // ERROR: The label says it's just a Phone. It doesn't have a browse button!
        System.out.println("Result: Even though it IS a SmartPhone, we can only see 'Phone' features right now.");

        System.out.println("\n=== 2. instanceof (Checking the content) ===");
        // We check if the thing inside the "Phone" box is actually a SmartPhone.
        if (myBox instanceof SmartPhone) {
            System.out.println("Check Passed: The box definitely contains a SmartPhone.");
            
            System.out.println("\n=== 3. DOWNCASTING (Unboxing) ===");
            // Now we safely take it out of the "Phone" box and put it in a "SmartPhone" box.
            SmartPhone actualPhone = (SmartPhone) myBox;
            
            // Now all buttons are available again!
            actualPhone.makeCall();
            actualPhone.browseWeb();
        }

        System.out.println("\n=== 4. DANGEROUS DOWNCASTING (The Trap) ===");
        Phone basicPhone = new Phone(); // This is just a basic old phone.

        System.out.println("Trying to force a basic Phone to be a SmartPhone...");
        try {
            // This is like trying to use a touchscreen on a rotary phone.
            SmartPhone fakePhone = (SmartPhone) basicPhone;
            fakePhone.browseWeb();
        } catch (ClassCastException e) {
            System.out.println("CRASH! Error: You cannot force a basic Phone to act like a SmartPhone.");
            System.out.println("Message: " + e.getMessage());
        }
    }
}