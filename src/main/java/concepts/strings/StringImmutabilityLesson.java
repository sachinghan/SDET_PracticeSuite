package concepts.strings;

/**
 * STRING IMMUTABILITY & CONSTANT POOL
 *
 * In Java, Strings are immutable. This means once a String object is created, its data cannot be changed.
 * If you modify a String (e.g., concat), a NEW object is created in memory.
 *
 * Real world analogy:
 * Think of a stone carving. Once you carve "Hello" into a stone, you cannot change it to "Hello World".
 * You have to take a new stone and carve "Hello World" onto it.
 * (StringBuilder is like a whiteboard - you can erase and rewrite).
 *
 * =================================================
 *   INTERVIEW QUESTIONS & ANSWERS
 * =================================================
 *
 * 1. Why is String immutable in Java?
 *    a) String Constant Pool (SCP): To save memory, Java reuses String literals. If Strings were mutable,
 *       changing one reference (s1) would affect all other references (s2) pointing to the same literal.
 *    b) Security: Strings are used for database connections, usernames, passwords, and class loading.
 *       If mutable, a hacker could change the connection string after security checks but before execution.
 *    c) Thread Safety: Immutable objects are automatically thread-safe. Multiple threads can share the same
 *       String instance without synchronization.
 *    d) HashCode Caching: Since the content doesn't change, the hashcode is calculated once and cached.
 *       This makes Strings excellent keys for HashMaps.
 *
 * 2. What is the String Constant Pool (SCP)?
 *    - A special memory region in the Heap where String literals are stored.
 *    - Before creating a new String literal, Java checks the pool. If it exists, the reference is returned.
 *      If not, a new string is added to the pool.
 *
 *    Diagram:
 *    String s1 = "Hello";
 *    String s2 = "Hello";
 *    String s3 = new String("Hello");
 *
 *       Stack             Heap Memory
 *    +-------+       +-------------------------+
 *    |  s1   | ----> |  String Constant Pool   |
 *    +-------+       |   +-----------------+   |
 *    |  s2   | ----> |   |     "Hello"     |   |
 *    +-------+       |   +-----------------+   |
 *                    +-------------------------+
 *
 *    +-------+       +-------------------------+
 *    |  s3   | ----> |      Heap Object        |
 *    +-------+       |   (value="Hello")       |
 *                    +-------------------------+
 *
 * 3. Difference between String, StringBuilder, and StringBuffer?
 *    -------------------------------------------------------------------------
 *    Feature          | String          | StringBuffer      | StringBuilder
 *    -------------------------------------------------------------------------
 *    Mutability       | Immutable       | Mutable           | Mutable
 *    Thread Safety    | Yes (Immutable) | Yes (Synchronized)| No
 *    Performance      | Fast (Reads)    | Slow (Overhead)   | Fastest
 *    Storage          | SCP / Heap      | Heap              | Heap
 *    -------------------------------------------------------------------------
 */

public class StringImmutabilityLesson {
    //proving immutability
    public void demonstrateImmutability() {
        System.out.println("Demonstrating Immutability");
        String s1="java";
        s1.concat("rules"); // this creates a new string but we ignore the result
        System.out.println("original string s1 "+s1); // still prints "java" because it is immutable
        //correct way
        String s2 = s1.concat("rules");
        System.out.println("new string s2 "+s2); // print javarules

    }

    //string constant pool
    public void demonstrateStringConstantPool() {
        System.out.println("Demonstrating String Constant Pool");
        String a= "hello";
        String b= "hello";//points to the same object in string constant pool
        String c = new String("hello");
        System.out.println("a==b ?"+ (a==b)); //true (same reference)
        System.out.println("a==c ?"+ (a==c)); // false different references
        System.out.println("a.equals(c) ?"+ (a.equals(c))); // true (same content)
    }

    /**
     * PROBLEM STATEMENT : Efficient String manipulation
     * Sceanrio: You need
     *
     */

    public static void main(String[] args) {
        StringImmutabilityLesson stringImmutabilityLesson = new StringImmutabilityLesson();
        stringImmutabilityLesson.demonstrateImmutability();
        stringImmutabilityLesson.demonstrateStringConstantPool();
    }

}
