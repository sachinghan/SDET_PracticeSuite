package concepts.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* LISTS IN AUTOMATION TESTING
 *
 * a) ArrayList = A row of numbered lockers
 * - you can instantly open locker #42 (Fast access)
 * -if you want to install a new locker between #5 and #6 you have to physically move lockers #6 to #100 one spot to the right
 * b) LinkedList = A treasure hunt
 *  - you only kow where the first clue is
 *  - clue 1 points to clue 2 -you must follow the chain
 *  - to insert a new clue in the middle, you just change the paper inside
 *    the previous clue to point to the new one (Fast insertion)
 *
 * 2) SCENARIOS
 * a) ArrayList : Managing a list of "Supported Browsers"
 *   (Read heavy, usually sorted)
 * b) LinkedList : Managing a sequence of "Test Steps"
 *  (Insertion/deletions might happen during recording)
 *
 */
public class ListLesson {

    public void demonstrateArrayList() {
        System.out.println("\n---ArrayList Demo---");
        List<String> browsers = new ArrayList<>();
        browsers.add("Chrome");
        browsers.add("Firefox");
        browsers.add("Edge");
        browsers.add("safari");
        browsers.add("IE"); //Adding an old browser
        System.out.println("Initial list is " + browsers);

        //size()
        System.out.println("Total browsers " + browsers.size());
        //get() Retrieving an element
        System.out.println("Browser at index 1 " + browsers.get(1));//Firefox
        // set() - updating an element
        System.out.println("Updating");
        browsers.set(4, "Internet explorer");
        System.out.println("Updated list is " + browsers);
        //remove()
        browsers.remove("Internet explorer");
        System.out.println("After removal " + browsers);
        //Collections.sort()
        Collections.sort(browsers);
        System.out.println("Sorted list is " + browsers);
        //clear() - removing everything
        browsers.clear();
        System.out.println("After clear " + browsers);
    }

    public void demonstrateLinkedList() {
        System.out.println("\n---LinkedList Demo---");
        List<String> steps = new LinkedList<>();
        steps.add("Open Browser");
        steps.add("Enter url");
        steps.add("click login");
        steps.add("verify dashbaord");
        System.out.println("Initial steps " + steps);
        // size()
        System.out.println("Total steps " + steps.size());
        // add(index,element) - Injecting missing steps (Efficient in LinkedList)
        steps.add(2, "enter username");
        steps.add(3, "enter pwd");
        System.out.println("After fixing steps " + steps);
        //get()
        System.out.println("Step 1 " + steps.get(0));
        //set() - modifying a step
        steps.set(5, "verify home page");
        System.out.println("After modification " + steps);

        //remove
        steps.remove(0);
        System.out.println("After removal " + steps);
        //clear()
        steps.clear();
        System.out.println("After clear " + steps);
    }

    static void main(String[] args) {
        ListLesson lesson = new ListLesson();
        lesson.demonstrateArrayList();
        lesson.demonstrateLinkedList();
    }
}