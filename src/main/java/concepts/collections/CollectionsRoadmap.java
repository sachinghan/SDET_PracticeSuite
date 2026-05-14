package concepts.collections;

public class CollectionsRoadmap {
    /*
     * Java Collections Framework Roadmap
     *
     * 1. List Interface (Ordered [Insertion Order], allows duplicates)
     *    - ArrayList: Dynamic array, fast random access (O(1)), slow insertion/deletion in middle.
     *    - LinkedList: Doubly linked list, fast insertion/deletion (O(1)), slow access (O(n)).
     *    - Vector: Legacy, synchronized (thread-safe) version of ArrayList.
     *
     * 2. Set Interface (Unordered, no duplicates)
     *    - HashSet: Uses HashMap internally, no order guaranteed, allows one null.
     *    - LinkedHashSet: Maintains insertion order.
     *    - TreeSet: Sorted order (Natural or Comparator), no nulls allowed.
     *
     * 3. Map Interface (Key-Value pairs, unique keys)
     *    - HashMap: Unordered, allows one null key, multiple null values.
     *    - LinkedHashMap: Maintains insertion order.
     *    - TreeMap: Sorted by keys.
     *    - Hashtable: Legacy, synchronized, no nulls.
     *
     * 4. Queue Interface (FIFO - First In First Out)
     *    - PriorityQueue: Elements processed based on priority.
     *    - Deque (ArrayDeque): Double-ended queue, faster than Stack for LIFO.
     */
    /*
     * =================================================
     *   Java Collections Framework Hierarchy
     * =================================================
     *
     * The framework is built around a set of core interfaces.
     *
     * 1. Iterable (Top-level interface)
     *    |
     *    +-- Collection (extends Iterable)
     *        |   (Maintains Insertion Order)
     *        +-- List (Ordered, allows duplicates)
     *        |   |
     *        |   +-- ArrayList
     *        |   +-- LinkedList
     *        |   +-- Vector
     *        |
     *        +-- Set (No duplicates)
     *        |   |
     *        |   +-- HashSet (Unordered)
     *        |   +-- LinkedHashSet (Insertion order)
     *        |   +-- SortedSet (Interface)
     *        |       |
     *        |       +-- NavigableSet (Interface)
     *        |           |
     *        |           +-- TreeSet (Sorted order)
     *        |
     *        +-- Queue (Processing order, typically FIFO)
     *            |
     *            +-- PriorityQueue
     *            +-- Deque (Interface - Double-ended queue)
     *                |
     *                +-- ArrayDeque
     *
     * 2. Map (Separate hierarchy, does NOT extend Collection)
     *    |
     *    +-- HashMap, LinkedHashMap, Hashtable
     *    +-- SortedMap (Interface) -> NavigableMap (Interface) -> TreeMap
     *
     */
    /*
     * =================================================
     *   Top Interview Questions (Tricky & Frequent)
     * =================================================
     *
     * 1. How does HashMap work internally?
     *    - Uses Hashing. Key.hashCode() determines the bucket index.
     *    - Collision handling: Linked List (Java 7) -> Balanced Tree (Java 8+ if threshold > 8).
     *    - Contract: If two objects are equal, their hashCodes must be same.
     *
     * 2. Fail-Fast vs Fail-Safe Iterators?
     *    - Fail-Fast: Throws ConcurrentModificationException if collection is modified during iteration (e.g., ArrayList, HashMap).
     *    - Fail-Safe: Works on a clone/snapshot or weakly consistent view, no exception (e.g., CopyOnWriteArrayList, ConcurrentHashMap).
     *
     * 3. ArrayList vs LinkedList?
     *    - ArrayList: Fast access (get), slow modification (shift elements). Uses dynamic array.
     *    - LinkedList: Slow access, fast modification (pointer change). Uses doubly linked list.
     *
     * 4. Difference between Comparable and Comparator?
     *    - Comparable: Natural ordering (compareTo method), modifies the class itself.
     *    - Comparator: Custom ordering (compare method), separate class/lambda, allows multiple sorting strategies.
     *
     * 5. HashMap vs Hashtable vs ConcurrentHashMap?
     *    - HashMap: Not thread-safe, allows null key/value.
     *    - Hashtable: Thread-safe (legacy, locks whole map), no nulls.
     *    - ConcurrentHashMap: Thread-safe (segment locking/CAS), faster than Hashtable, no nulls.
     *
     * 6. What happens if you override equals() but not hashCode()?
     *    - Violates contract. Two "equal" objects might have different hashCodes, causing them to be stored in different buckets in a HashMap/HashSet, leading to data retrieval failure.
     *
     * 7. Time Complexity of HashMap operations?
     *    - Average: O(1) for get/put.
     *    - Worst Case: O(n) (Java 7) or O(log n) (Java 8+) if high collisions occur.
     *
     * 8. How to make a Collection unmodifiable?
     *    - Collections.unmodifiableList(list), Collections.unmodifiableMap(map), etc.
     *    - List.of(), Set.of(), Map.of() (Java 9+ Immutable factories).
     */

    public static void main(String[] args) {
        System.out.println("Collections Roadmap initialized. Explore List, Set, Map, and Queue implementations.");
    }

}
