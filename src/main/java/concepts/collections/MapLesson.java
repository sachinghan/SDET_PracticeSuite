package concepts.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/** MAP INTERFACE (HashMap, LinkedHashMap, TreeMap)
 * A map is an object that maps keys to values.
 * - a map cannot contain duplicate keys
 * - Each key can map at most one value
 *  a) HashMap :
 *            -Unordered
 *            - allow 1 null key and multiple null values
 *            -0(1) for get/put
 *  b) LinkedHashMap:
 *               - Maintains insertion order
 *               -slightly slower than hashmap
 *  c) TreeMap - Sorted by key (Natural order or comparator)
 *             - 0(log N)
 *  d) HashTable :
 *              - Legacy class. Thread-safe (Synchronized)
 *              - No null keys/values allowed. Slower
 *    Interview Question -
 *    1)Internal working of hashmap
 *    It uses an array of nodes (Buckets)
 *    when u call put(K<V)
 *    1.it calls K.hashCode() to get a hash
 *    2.calculates index = hash%(array_size) lets say 10
 *    3. Places the node in that bucket
 *    COLLISION - if two keys land in the same bucket
 *    - Before Java 8 they form a linkedlist
 *    -java 8+ if list size>8 it converts to a red-black tree (0(log N)).
 *    2) what happens if you override equals() but not hashCode() ? (Map breaks. you might lose data)
 *    - why is String a good key ? (Immutable, cached hash)
 *    -Difference between HashMap and HashTable? (Thread-safety, Nulls)
 *
 */

public class MapLesson {
    // Storing employee id -> salary
    public void demonstrateMapTypes() {
        System.out.println("\n --1 Map types demo (Bug Tracking)");
        //HashMap (Randome order)
        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(103,5000);
        hashMap.put(101,3000);
        hashMap.put(102,4000);
        hashMap.put(null,0);//allows null key
        System.out.println("HashMap random "+hashMap);

        //LinkedHashMap (Insertion order)
        Map<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(103,5000);
        linkedHashMap.put(101,3000);
        linkedHashMap.put(102,4000);
        linkedHashMap.put(null,0); //allows null key
        System.out.println("Linked Hash Map ordered "+linkedHashMap);

        //TreeMap (sorted by key) means it will come in alphabetical or numerical order
        Map<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(103,5000);
        treeMap.put(101,3000);
        treeMap.put(102,4000);
       // treeMap.put(null,0); //crash treemap cannot handle null keys
        System.out.println("Tree Map sorted "+treeMap);

    }

    public void demonstrateCommonMethods() {
        System.out.println("\n --2 Common Map Methods");
        Map<Integer, String> employeeMap = new HashMap<>();

        // put()
        employeeMap.put(101, "John Doe");
        employeeMap.put(102, "Jane Smith");
        employeeMap.put(103, "Sam Wilson");

        // get()
        System.out.println("Employee with ID 102: " + employeeMap.get(102));

        // containsKey() & containsValue()
        System.out.println("Contains ID 105? " + employeeMap.containsKey(105));
        System.out.println("Contains 'John Doe'? " + employeeMap.containsValue("John Doe"));

        // replace / update
        employeeMap.put(101, "John Updated");
        System.out.println("Updated Employee with ID 101: " + employeeMap.get(101));

        // Iterating (Crucial !)
        System.out.println("Iterating over EntrySet");
        for(Map.Entry<Integer, String> entry : employeeMap.entrySet()){
            System.out.println("Key: "+entry.getKey()+" | Value : "+entry.getValue());
        }
    }

    /**
     * PROBLEM STATEMENT : Word frequency count
     * Sceanrio: Given a sentence,count how many times each word appears.
     * Input : "apple banana apple orange banana apple"
     * Output: {apple=3, banana=2, orange=1}
     */
    public void problemSolvingSceanrio(){
        System.out.println("\n --3 Problem Solving Sceanrio frequency count");
        String sentence = "apple banana apple orange banana apple";
        String[] words = sentence.split(" ");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word:words){
            if(frequencyMap.containsKey(word)){
                //if word exists, increment the count
                frequencyMap.put(word, (frequencyMap.get(word)+1));
            }
            else {
                //if new word,start count at 1
                frequencyMap.put(word,1);
            }
        }
        System.out.println("Word counts "+frequencyMap);
    }

    public static void main(String args[]){
        MapLesson mapLesson= new MapLesson();
        mapLesson.demonstrateMapTypes();
        mapLesson.demonstrateCommonMethods();
        mapLesson.problemSolvingSceanrio();
    }
}
