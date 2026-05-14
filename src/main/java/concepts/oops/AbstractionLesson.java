package concepts.oops;

/*
    Abstraction is the process of hiding the  implementation details and showing only the functionality to the user.
    It focuses on WHAT an object does rather than HOW it does it.
    In Java we achieve it by using
     a) Abstract classes (0 to 100 % abstraction)
     b) Interfaces (100 % abstraction)

     REAL WORLD ANALOGY
     Think of a "Car dashboard"
     - You know "WHAT" the break does (it stops the car)
     you do not need to know "HOW" the internal hydraulics or brake pads work.
     The complexity is hidden (abstracted) away from the driver

     Interview Questions:
     1) Difference between Abstract class and Interfaces ?
     ( Abstract class can have state/constructors, Interface is a contract)
     2) When to use which ?
     (Use Interfaces for "capabilities" eg. Runnable, Flyable)
     Use Abstract for 'Shared Identity' eg. Vehicle
     3) Can we instantiate an abstract class ? No
=========================================================================================
 */

public class AbstractionLesson {


    static void main(String[] args) {
        AbstractionLesson abstractionLesson = new AbstractionLesson();
        abstractionLesson.demonstrateAbstractClass();
        abstractionLesson.problemSolvingScenario();
    }

    public void demonstrateAbstractClass() {
        System.out.println("\n--1. Abstract class example");
        //  Vehicle v = new Vehicle("Maruti"); // we cannot instantiate abstract class
        Vehicle myCar = new Car("Toyota");
        myCar.startEngine(); // calls car's implementation
        myCar.honk(); //calls vehicle's shared implementation
        Vehicle myBike = new ElectricBike("Ather");
        myBike.startEngine();
        myBike.honk();
    }

    //This below method is 100% abstract from the implementation details
    //It doesn't know how the message is sent, knows only that it is sent
    private void sendAlert(NotificationService service, String msg, String to) {
        System.out.println("Alerting...");
        service.send(msg, to);
    }

    public void problemSolvingScenario() {
        System.out.println("Problem solving notification system");
        //This client code works with the interface, not the concrete class
        //This is called loose coupling

        NotificationService service;
        //User chooses Email
        service = new EmailService();
        sendAlert(service, "Server is down", "admin@company.com");
        //User chooses SMS
        service = new SMSService();
        sendAlert(service, "OTP is 1234", "+1-555-00199");
        //User chooses Whatsapp
        service = new WhatsAppService();
        sendAlert(service, "Hello there ", "+1-555-89649");
    }
    // -----2. USING INTERFACE
    /* PROBLEM STATEMENT - Notification system
       Scenario is: Your app needs to send notifications
       Today you support Email and SMS. Tomorrow you might add whatsapp or push
       Task : Design a system where the sender logic doesn't care about the specific channel
     */

    interface NotificationService {
        void send(String message, String recipient);
    }

    /* Vehicle - we cannot have just a vehicle. It must be a specific type (Car, Bike)
     */
    // ----1. USING ABSTRACT CLASS
    abstract class Vehicle {
        String brand;

        Vehicle(String brand) {
            this.brand = brand;
        }

        //Abstract method: No body Children must implement this method
        abstract void startEngine();

        void honk() {
            System.out.println(brand + " is honking beep ! beep !");
        }
    }

    class Car extends Vehicle {
        Car(String brand) {
            super(brand);
        }

        @Override
        void startEngine() {
            System.out.println("Car engine starts");
        }
    }

    class ElectricBike extends Vehicle {
        ElectricBike(String brand) {
            super(brand);
        }

        @Override
        void startEngine() {
            System.out.println("Electric bike starts silently with a button {silent hum}");
        }
    }

    class EmailService implements NotificationService {

        @Override
        public void send(String message, String recipient) {
            //Logic to connect to smtp server
            System.out.println("Sending Email to " + recipient + " with message " + message);
        }
    }

    class SMSService implements NotificationService {

        @Override
        public void send(String message, String recipient) {
            //Logic to connect to Telecom provider
            System.out.println("Sending SMS to " + recipient + " with message " + message);
        }
    }

    class WhatsAppService implements NotificationService {

        @Override
        public void send(String message, String recipient) {
            //Logic to connect to whatsapp api
            System.out.println("Sending Whatsapp to " + recipient + " with message " + message);
        }
    }
}