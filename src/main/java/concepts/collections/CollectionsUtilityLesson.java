package concepts.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * COLLECTIONS UTILITY CLASS (java.util.Collections)
 *
 * The `Collections` class (plural) consists exclusively of static methods that operate on or return collections.
 * It is a utility class, similar to how `Arrays` is for arrays.
 *
 * INTERVIEW QUESTIONS & CONCEPTS:
 * 1. Collection vs Collections?
 *    - Collection: The root interface (List, Set, Queue).
 *    - Collections: A utility class with static helper methods (sort, reverse, etc.).
 *
 * 2. How to sort a list?
 *    - Collections.sort(list) -> Uses Natural Ordering (Comparable).
 *    - Collections.sort(list, comparator) -> Uses Custom Ordering.
 *
 * 3. How to make a collection Thread-Safe?
 *    - Collections.synchronizedList(list), synchronizedMap(map), etc.
 *
 * 4. How to make a collection Read-Only (Immutable)?
 *    - Collections.unmodifiableList(list).
 */
public class CollectionsUtilityLesson {

    public void demonstrateSortingAndSearching() {
        System.out.println("\n-- 1. Sorting and Searching --");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(40);

        System.out.println("Original: " + numbers);

        // 1. Sorting (Natural Order - Ascending)
        // Time Complexity: O(n log n) - Uses MergeSort/TimSort
        Collections.sort(numbers);
        System.out.println("Sorted (Ascending): " + numbers);

        // 2. Binary Search (List MUST be sorted first!)
        // Returns index of key, or negative value if not found
        int index = Collections.binarySearch(numbers, 30);
        System.out.println("Found 30 at index: " + index);

        // 3. Sorting (Reverse Order)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted (Descending): " + numbers);
    }

    public void demonstrateModifications() {
        System.out.println("\n-- 2. Common Modifications (Reverse, Shuffle, Swap) --");
        List<String> cards = new ArrayList<>();
        cards.add("Ace");
        cards.add("King");
        cards.add("Queen");
        cards.add("Jack");

        // Reverse
        Collections.reverse(cards);
        System.out.println("Reversed: " + cards);

        // Shuffle (Randomize) - Essential for testing random scenarios
        Collections.shuffle(cards);
        System.out.println("Shuffled: " + cards);

        // Swap - Swap elements at two positions
        Collections.swap(cards, 0, cards.size() - 1);
        System.out.println("Swapped First and Last: " + cards);
    }

    public void demonstrateWrappers() {
        System.out.println("\n-- 3. Wrappers (Unmodifiable & Synchronized) --");
        List<String> items = new ArrayList<>();
        items.add("Laptop");
        items.add("Mouse");

        // 1. Unmodifiable View (Read-Only)
        // Interview Q: How to prevent a method from modifying your list?
        List<String> readOnlyList = Collections.unmodifiableList(items);
        System.out.println("Read-Only List created: " + readOnlyList);

        try {
            readOnlyList.add("Keyboard"); // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception caught: Cannot modify an unmodifiable list!");
        }

        // 2. Synchronized View (Thread-Safe)
        // Interview Q: How to make ArrayList thread-safe without using Vector?
        List<String> syncList = Collections.synchronizedList(items);
        System.out.println("Synchronized List created. Note: Must manually synchronize block when iterating!");
    }

    /**
     * PROBLEM SOLVING: Min, Max, and Frequency
     */
    public void problemSolvingScenario() {
        System.out.println("\n-- 4. Problem Solving: Min, Max & Frequency --");
        List<Integer> prices = List.of(10, 50, 20, 10, 5, 100, 10); // Immutable list

        System.out.println("Prices: " + prices);
        System.out.println("Min Price: " + Collections.min(prices));
        System.out.println("Max Price: " + Collections.max(prices));
        System.out.println("Frequency of '10': " + Collections.frequency(prices, 10));
    }

    public static void main(String[] args) {
        CollectionsUtilityLesson lesson = new CollectionsUtilityLesson();
        lesson.demonstrateSortingAndSearching();
        lesson.demonstrateModifications();
        lesson.demonstrateWrappers();
        lesson.problemSolvingScenario();
    }
}