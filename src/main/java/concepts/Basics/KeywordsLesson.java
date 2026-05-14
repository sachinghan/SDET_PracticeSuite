package concepts.Basics;
/*
  Keywords (STATIC, FINAL, THIS, SUPER)
  a) static - Belongs to the class. Loaded into memory once
  b) final - Restricts modification (Constants, no overriding, no inheritance)
  c) this -  Refers to current object. Used to resolve variable shadowing.
  d) super - Refers to parent object. Used to access hidden fields/methods.

Interview questions -
TRAP 1- If a list is final, can we add elements to it ?
Yes final only protects the reference pointer, not the object internal state.
TRAP - 2 In what order do blocks execute ?
(Static block-> Instance block-> Constructor)
TRAP - 3 Can a static method call this or super ?
No this and super refer to objects, but static methods belong to class
TRAP - 4 what is variable shadowing ?
when a local variable has the same name as instance variable, use this to differentiate

 */

import java.util.ArrayList;
import java.util.List;

public class KeywordsLesson {

    public void demonstrateFinalTrap(){

        System.out.println("\n ----- 1 The final reference trap");
        final List<String> myTeam = new ArrayList<>();
       // myTeam = new ArrayList<>(); // compiler error cannot reassign a final reference
        myTeam.add("James");
        myTeam.add("Shawn");
        System.out.println("We can modify the internal state of the final object "+myTeam);
        System.out.println("Rule is in case of 'final' you cannot change the remote control, but you can change the channel");
    }

    // TRAP 2 STATIC VS INSTANCE BLOCKS execution order
    static  class OrderTest{
        static{
            System.out.println("1) Static block (Runs only when class is loaded into memory)");
        }
        {
            System.out.println("2) Instance block (Runs everytime an object is created before constructor)");
        }

        public OrderTest(){
            System.out.println("3) Constructor runs when object is created");
        }
    }

    public void demonstrateExecutionOrder(){
        System.out.println("\n-----2 . Execution order trap");
        System.out.println("creating first object");
        new OrderTest();
        System.out.println("creating second object");
        new OrderTest(); // Notice that static block does not run again
    }

    // Trap 3 STATIC METHOD LIMITATIONS & BLANK FINALS
    class Employee{
        static String companyName = "Google";
        final int id; // Blank final - declared but initialized later, we will use constructor to intialize the blank final field

        Employee(int id) {
            this.id = id;
        }

        public static void printCompany() {
            System.out.println("Company is "+companyName);
        //    System.out.println("Id is "+id); // compiler error - static method cannot access non-static variable
        //    System.out.println(this.companyName);// error - Cannot use this is a static context.
        }
    }

    class Parent{
        int speed = 50;
        void showType(){
            System.out.println("Parent type - Generic vehicle");
        }
    }

    class Child extends Parent{
        int speed=100; // Variable shadowing Child has a variable with the exact same name
        void displaySpeed(int speed){
            System.out.println("\n-----4 Vairbale shadowing (this vs super)");
            System.out.println("Local variable parameter "+speed); // Refers to parameter
            System.out.println("Instance variable (this.speed) "+this.speed);//Refers to child's variable
            System.out.println("Parent variable (super.speed) "+super.speed); //Refers to Parent's hidden variable
        }

        @Override
        void showType() {
            super.showType();// calling parent's overriden method
            System.out.println("Type sports car");
        }
    }

    public void demonstrateShadowing(){
        Child c = new Child();
        c.displaySpeed(150);
        System.out.println("\n---Calling overriden method via super");
        c.showType();

    }

    //Runner class
    public static void main(String[] args){
        KeywordsLesson lesson = new KeywordsLesson();
        lesson.demonstrateFinalTrap();
        lesson.demonstrateExecutionOrder();
        lesson.demonstrateShadowing();
    }

}
