package concepts.oops;

public class Overriding {
    static class Animal{
        void sound(){
            System.out.println("Animal sound");
        }
    }

    static class Dog extends Animal{
        // so here child class changes parent method
        void sound(){
            System.out.println("Dog barks");
        }
    }

    public static void main(String args[]){
        Dog dog= new Dog();
        Animal animal = new Animal();
        dog.sound();
        animal.sound();
    }

}
