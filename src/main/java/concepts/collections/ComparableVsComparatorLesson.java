package concepts.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * COMPARABLE vs COMPARATOR
 * <p>
 * 1. Comparable (java.lang.Comparable)
 * - "Natural Ordering": Defines the default way objects of this class are sorted.
 * - The class itself implements this interface.
 * - Method: `public int compareTo(T other)`
 * - Usage: `Collections.sort(list)`
 * - Limitation: You can only have ONE implementation (one way to sort).
 * <p>
 * 2. Comparator (java.util.Comparator)
 * - "Custom Ordering": Defines an external way to sort objects.
 * - Implemented in a separate class or as a lambda.
 * - Method: `public int compare(T o1, T o2)`
 * - Usage: `Collections.sort(list, comparator)`
 * - Advantage: You can define multiple comparators for different sorting logic (by name, by age, etc.).
 * <p>
 * MEMORY TRICK
 * Comparable = "I am able to compare MYSELF" (compareTo)
 * Comparator - "An external actor compares two objects" (compare)
 * <p>
 * INTERVIEW QUESTIONS:
 * 1. Difference between Comparable and Comparator?
 * - Comparable affects the original class (modifies source). Comparator is external (doesn't touch source).
 * - Comparable = `java.lang`, Comparator = `java.util`.
 * - Comparable = `compareTo()`, Comparator = `compare()`.
 * <p>
 * 2. When to use which?
 * - Use Comparable for the "default" sort (e.g., ID).
 * - Use Comparator when you can't modify the class (3rd party library) or need multiple sort types.
 * <p>
 * 3. What does compareTo return?
 * - Negative integer: this < other
 * - Zero: this == other
 * - Positive integer: this > other
 * 4). How to sort in reverese order ? (Swap 01 and 02, or multiply result by -1)
 * Can we use Comparator with Arrays.sort() ? Yes
 */
public class ComparableVsComparatorLesson {

    static void main(String[] args) {
        ComparableVsComparatorLesson lesson = new ComparableVsComparatorLesson();
        lesson.demonstrateComparable();
        lesson.demonstrateComparator();
        lesson.demonstrateLambdaComparator();
        lesson.problemSolvingScenario();
    }

    public void demonstrateComparable() {
        System.out.println("\n-- 1. Comparable (Natural Order: ID) --");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Alice", 50000));
        employees.add(new Employee(101, "Bob", 40000));
        employees.add(new Employee(102, "Charlie", 90000));

        System.out.println("Before Sort: " + employees);

        // Uses compareTo() defined in Employee class
        Collections.sort(employees);

        System.out.println("After Sort (by ID): " + employees);
    }

    public void demonstrateComparator() {
        System.out.println("\n-- 2. Comparator (Custom Order: Salary) --");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Alice", 50000));
        employees.add(new Employee(101, "Bob", 40000));
        employees.add(new Employee(102, "Charlie", 90000));

        // Uses the external SalaryComparator
        Collections.sort(employees, new SalaryComparator());

        System.out.println("After Sort (by Salary): " + employees);
    }

    public void demonstrateLambdaComparator() {
        System.out.println("\n-- 3. Java 8 Lambda Comparator (Sort by Name) --");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(103, "Alice", 50000));
        employees.add(new Employee(101, "Bob", 40000));
        employees.add(new Employee(102, "Charlie", 90000));

        // Modern way: No need for separate class
        // Sort by Name Descending
        Collections.sort(employees, (e1, e2) -> e2.name.compareTo(e1.name));

        System.out.println("After Sort (by Name Descending): " + employees);
    }

    /**
     * PROBLEM STATEMENT: Multi-Level Sorting
     * Scenario: Sort employees by Salary (Low to High).
     * If two employees have the same salary, sort them by Name (A-Z).
     */
    public void problemSolvingScenario() {
        System.out.println("\n-- 4. Problem Solving: Multi-Level Sorting --");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "John", 50000));
        employees.add(new Employee(102, "Adam", 50000)); // Same salary as John
        employees.add(new Employee(103, "Zack", 30000));

//        // Logic: Compare salary first. If 0 (equal), compare name.
//        Comparator<Employee> multiLevelComparator = (e1, e2) -> {
//            int salaryCompare = Double.compare(e1.salary, e2.salary);
//            if (salaryCompare == 0) {
//                // Salaries are equal, sort by Name
//                return e1.name.compareTo(e2.name);
//            }
//            return salaryCompare;
//        };
//
//        Collections.sort(employees, multiLevelComparator);
//        System.out.println("Sorted (Salary -> Name): " + employees);


        //CLASSIC APPROACH MANUAL LOGIC INSIDE compare()
        Comparator<Employee> complexSorter = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                //step 1 compare salaries (descending)
                //note for descending we swap e2 and e1
                int salaryCompare = Double.compare(e2.salary, e1.salary);
                //step 2 if salaries are not equal, return that result
                if (salaryCompare !=0) {
                    return salaryCompare;
                }
                // step 3 if salaries are equal, compare names (Ascending)
                return e1.name.compareTo(e2.name);
            }
        };

        Collections.sort(employees,complexSorter);
        for(Employee e:employees){
            System.out.println(e);
        }
    }

    // 1. The Class implementing Comparable (Natural Order by ID)
    static class Employee implements Comparable<Employee> {
        int id;
        String name;
        double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        //Comparable implementation
        // Natural Sorting Logic: Sort by ID
        @Override
        public int compareTo(Employee other) {
            // return this.id - other.id; // Basic logic
            return Integer.compare(this.id, other.id); // Safe wrapper
        }

        @Override
        public String toString() {
            return "{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }

    // 2. Separate Comparator Class (Sort by Salary)
    static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.salary, e2.salary);
        }
    }
}