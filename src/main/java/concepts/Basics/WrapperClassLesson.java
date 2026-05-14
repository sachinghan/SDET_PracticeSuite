package concepts.Basics;
/*
 TOPIC AUTOBOXING, UNBOXING & WRAPPER CLASSES
 In Java, wrapper classes allow primitive data types to be represented as objects.
 This enables primitives to be used in object-oriented features such as collections, generics, and APIs that require objects
 Java has 8 primitive data types (int, double, boolean...) which are not Objects
 Wrapper classses (Integer, Double, Boolean) wrap these primitves into Objects.
 1) Autoboxing - automatic conversion of primitive to Wrapper (Object)
 primitive data type-> Object
  eg. Integer num = 10; (Compiler does : Integer.valueOf(10))
  2) Unboxing - Automatic conversion of Wrapper to Primitives
  eg. int n=num; (Compiler does : num.intValue())

 Interview Questions -
 - Why do we need wrapper classes ? (Collections like ArrayList<Integer> don't support primitives)
 What is the "Integer cache"? (Values from -128 to 127 are cached and reused)
 what happens if u unbox a null integer ? (NullPointerException)
 */

import java.util.ArrayList;
import java.util.List;

public class WrapperClassLesson {
    // Demo 1 - Autoboxing and Unboxing
    public void demonstrateBasics() {
        System.out.println("\n-----1 Autoboxing and unboxing basics");
        // (Autoboxing) (int->Integer)(primitive->Object)
        Integer ref = 10;
        //Unboxing (Integer->int)
        int val = ref;
        System.out.println("Value is " + val);
        //Why we need them
        //   List<int> list = new ArrayList<>();//compiler error
        List<Integer> list = new ArrayList<>();
        list.add(5); //AutoBoxing happens here
    }

    // Demo 2 - Null pointer trap
    public void demonstrateNullTrap() {
        System.out.println("\n----2 The Null pointer trap");
        Integer score = null; // It's an Object , so it can be null
        try {
            //Unboxing happens here. finalScore= score.intValue()
            //Since score is null, calling a method on it causes NPE
            int finalScore = score;
        } catch (NullPointerException e) {
            System.out.println("CRASH- cannot update a null Integer");
        }
    }

    // Demo 3 The Integer Cache Trap (-128 to 127)
    public void demonstrateIntegerCache() {
        System.out.println("\n----3 The Integer cache trap");
        // within cache range (-128 to 127)
        Integer a = 100;
        Integer b = 100;
        System.out.println("100==100? " + (a == b));
        // Outside cache range
        Integer x = 200;
        Integer y = 200;
        System.out.println("200==200? " + (x == y));

        //solution - always use .equals() for Objects
        System.out.println("200.equals(200)? " + x.equals(y));
    }

    //Demo 4 Performance impact
    public void demonstratePerformance() {
        System.out.println("---4 Performance impact");
        long start = System.currentTimeMillis();
        Long sumWrapper = 0L; //Wrapper class
        for (long i = 0; i < Integer.MAX_VALUE / 10; i++) {
            sumWrapper += i; //Unbox, Add, Autobox (expensive time)
        }

        System.out.println("Wrapper Time " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        long sumPrimitive = 0L; // Primitve
        for (long i = 0; i < Integer.MAX_VALUE / 10; i++) {
            sumPrimitive += i;
        }
        System.out.println("Primitive time " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void main(String[] args){
        WrapperClassLesson lesson = new WrapperClassLesson();
        lesson.demonstrateBasics();
        lesson.demonstrateNullTrap();
        lesson.demonstrateIntegerCache();
        lesson.demonstratePerformance();
    }
}