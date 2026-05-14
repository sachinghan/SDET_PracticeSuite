package concepts.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A set is a collection that contains no duplicate elements. It models the mathematical set abstraction
 * THE THREE MAIN IMPLEMENTATION:
 * a) HashSet:
 *    - uses Hashing
 *    -Order - unordered
 *    -performance - fastest for add/remove/contains
 *    - Nulls: Allows one null value.
 *    -use case : removing duplicates when order doesn't matter
 *  b) LinkedHashSet:
 *   - uses hashing
 *   -order - maintains insertion order (first in first out)
 *   -performace - slightly slower than HashSet
 *   - Nulls: Allows one null value.
 *   - use case : removing duplicates but keeping the original sequence
 *   c) TreeSet:
 *      - Uses a Red-Black tree
 *      -order - sorted (Natural ordering or comparator)
 *      -performance - slowest
 *      - Nulls: No null values allowed (throws NullPointerException).
 *      - use case : need a sorted list of unique elements
 *
 *   Interview Questions (LIST vs SET)
 *   - can list contain duplicates (yes). can set ? (no)
 *   - can list contain multiple nulls ? (yes) can set ? (only one null)
 *   - how does hashset ensure uniqueness ? it uses HashMap internally.
 *    it calls hashcode() then equals() to check for duplicates
 */

public class SetLesson {
    /**
     *  Sceanrio - we have a list of bug id's with some duplicates, we want to know how each set handles them
     */

    public void demonstrateSetTypes(){

        System.out.println("\n --1 set types demo");
        String[] bugs = {"BUG-101","BUG-500","BUG-101","BUG-200","BUG-500","BUG-300"};
        //hashset (unordered)
        Set<String> hashSet = new HashSet<>();
        for(String bug : bugs){
            hashSet.add(bug);
        }
        System.out.println("Hashset random "+hashSet);
        //LinkedHashSet (insertion order)
        Set<String> linkedHashSet = new LinkedHashSet<>();
        for(String bug : bugs){
            linkedHashSet.add(bug);
        }
        System.out.println("LinkedHashSet insertion order "+linkedHashSet);
        //Tree set (sorted)
        Set<String> treeSet = new TreeSet<>();
        for(String bug : bugs){
            treeSet.add(bug);
        }
        System.out.println("TreeSet sorted "+treeSet);
    }

    public void demonstrateCommonMethods(){
        System.out.println("\n --2 common methods active users");
        Set<String> activeUsers = new HashSet<>();
        activeUsers.add("user1");
        activeUsers.add("user2");
        activeUsers.add("user3");
        activeUsers.add("user2");
        System.out.println("Current users "+activeUsers);
        //contains() - fast lookup 0(1)
        if(activeUsers.contains("user1")){
            System.out.println("user1 is online");
        }

        // remove()
        activeUsers.remove("user2");
        System.out.println("After removal of user2  "+activeUsers);
        //size
        System.out.println("Size "+activeUsers.size());
        //isEmpty()
        System.out.println("Is empty "+activeUsers.isEmpty());
        //clear()
        activeUsers.clear();
        System.out.println("After clear "+activeUsers);
        //isEmpty()
        System.out.println("Is empty "+activeUsers.isEmpty());
    }

    public static void main(String args[]){
        SetLesson setLesson = new SetLesson();
        setLesson.demonstrateSetTypes();
        setLesson.demonstrateCommonMethods();
    }
}
