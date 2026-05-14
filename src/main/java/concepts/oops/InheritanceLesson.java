package concepts.oops;

/* Inheritance is a mechanism where a new class (child class/subclass) acquires the properties and behaviour (fields and methods) of another class (parent class/superclass).
It represents as IS-A Relationship(eg, dog IS-A animal)
keyword - extends
TYPES OF INHERITANCE IN JAVA-
1) Single - A -> B
2) Multilevel - A->B->C
3) Hierarchical - A->B, A->C, A->D (Multiple child)
4) Multiple - A->C B-> C (Not supported with classes), BUT supported with Interfaces

 */

/* 1) Why does Java not support Multiple Inheritance with Classes ? (The Diamond problem)
   2) How do we achieve Multiple Inheritance in Java (Using Interfaces)
   3) What is the root class of all classes in java (java.lang.Object)
   4) Are constructors inherited ? (No, but they are executed via super() keyword )

 */

public class InheritanceLesson {


    class Animal {
        void eat() {
            System.out.println("Animal is eating");
        }
    }

    //--SINGLE INHERITANCE
    class Dog extends Animal {
        void bark() {
            System.out.println("Dog is barking");
        }
    }

    //--HIERARCHICAL INHERITANCE
    class Cat extends Animal {
        void meow() {
            System.out.println("Cat is meowing");
        }
    }
    //--MULTILEVEL INHERITANCE

    class BabyDog extends Dog {
        void weep() {
            System.out.println("BabyDog is weeping");
        }
    }

    public void demonstrateInheritanceTypesExcludingMultiple() {
        //Single
        System.out.println("--Single Inheritance--");
        Dog d = new Dog();
        d.bark();
        d.eat();

        //Hierarchical
        System.out.println("--Hierarchical Inheritance--");
        Cat c = new Cat();
        c.meow();
        c.eat();

        //Multilevel
        System.out.println("--Multilevel Inheritance--");
        BabyDog bd = new BabyDog();
        bd.weep();
        bd.bark();
        bd.eat();
    }

    // - MULTIPLE INHERITANCE (the Interface way)--other wise not possible with classes
    /* Concept - Diamond problem
    Java classes cannot extend multiple parents because if both parents have the  same method (eg. eat())
    , then the child won't know which one to call.

    A (eat)-> B
    C (eat)-> B

    Solution - Interfaces solve this because they don't have method bodies (traditionally), so the child must provide
     its own implementation removing ambiguity.

     */

    /* Interface - All the methods are declared with empty body and all fields are PUBLIC, STATIC and FINAL by default.
      The java compiler adds public, static final keywords before data members(varaibles)
      and methods are public and abstract -
     */

    interface Camera {

        void takePhoto();
    }

    interface MusicPlayer {
        void playMusic();
    }

    class SmartPhone implements MusicPlayer, Camera {

        @Override
        public void takePhoto() {
            System.out.println("Click photo ! Photo taken");
        }

        @Override
        public void playMusic() {
            System.out.println("Playing music ! Ustad Jashn e rekhta");
        }
    }

    public void demonstrateMultipleInheritance() {
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.playMusic(); // behaves like a music player
        smartPhone.takePhoto(); // behaves like a camera
    }

     /* PROBLEM STATEMENT
        Scenario - A company has different types of employees.
     All employees must have a Name and ID.
     A Developer has a specific programming language
     A manager has a specific Team Size
     Task - Use inheritance to avoid code duplication for Name and ID.

     Employee{
     name,
     id
     showDetails()
     }

     Developer extends Employee{
     @override
     showDetails()
     }

     Manager extends Employee{
     @override
     showDetails()
     }

      */

    // Base class
    class Employee {

        String name;
        int id;

        Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }

        void showDetails() {
            System.out.println("Name is " + name + " and id is " + id);
        }
    }

    // Child class 1

    class Developer extends Employee {
        String codingLanguage;

        Developer(String name, int id, String codingLanguage) {
            super(name, id);// Reusing parent constructor
            this.codingLanguage = codingLanguage;
        }

        void showDetails() {
            super.showDetails();
            System.out.println("Role is developer and coding language is " + codingLanguage);
        }
    }

    //Child class 2
    class Manager extends Employee {
        int teamSize;

        Manager(String name, int id, int teamSize) {
            super(name, id);
            this.teamSize = teamSize;
        }

        void showDetails() {
            super.showDetails();
            System.out.println("Role is manager and team size is " + teamSize);
        }
    }

    public void problemSolvingScenario() {
        System.out.println("--Problem Solving Scenario-- Employee system");
        Developer developer = new Developer("Shantanu", 1324, "Java");
        Manager manager = new Manager("Sachin", 67617, 50);
        developer.showDetails();
        manager.showDetails();
    }

    static void main(String[] args) {
        InheritanceLesson lesson = new InheritanceLesson();
        lesson.demonstrateInheritanceTypesExcludingMultiple();
        lesson.demonstrateMultipleInheritance();
        lesson.problemSolvingScenario();
    }
}