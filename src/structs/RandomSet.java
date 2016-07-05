package structs;

import java.util.*;

/**
 * Created by squeaky on 7/4/16
 *
 * Supports two main operations: Add, and getNext().  The latter randomly selects, removes, and returns
 *  one of the previously added elements.
 *
 *  Add is  O(1), getNext() is O(1) in the average case but can be O(N) on repeated getNext() calls...
 *  but space is large - each element is stored twice.
 */
public class RandomSet<T> {
    Set<T> itemsAsSet = new HashSet<>();
    List<T> itemsAsList = new ArrayList<>();
    List<Integer> empties = new ArrayList<>();
    Random random = new Random();

    public void add(T item) {
        boolean newItem = itemsAsSet.add(item);
        if(newItem) {
            if(empties.isEmpty()) {
                itemsAsList.add(item);
            } else {
                 itemsAsList.set(empties.remove(0), item);
            }
        }
    }

    public T getNext() {
        if(itemsAsSet.size() == 0) { throw new IllegalStateException("This set contains no elements.  " +
                "You'll need to add some first by calling the add function."); }

        int position = Math.abs(random.nextInt() % itemsAsSet.size());

        //Adjust for gaps in the list
        if(!empties.isEmpty()) {
            for (Integer empty : empties) {
                if (empty >= position) {
                    position++;
                }
            }
        }

        T removed = itemsAsList.get(position);
        itemsAsList.set(position, null);
        itemsAsSet.remove(removed);
        empties.add(position);
        return removed;
    }
}
