package structs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by squeaky on 6/29/16
 */
public class DisjointSet<T> {
    private class SetItem {
        private T data;
        private int parent;

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public T getData() {
            return data;
        }

        SetItem(T data, int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    private List<SetItem> sets;
    private Map<T, Integer> itemDict = new HashMap<T, Integer>();
    private int sequenceNum = 0;

    public DisjointSet(int size) {
        sets = new ArrayList<>(size);
    }

    public int find(T data) {
        int index = itemDict.get(data);
        if(index == sets.get(index).getParent()) {
            return index;
        }

        return find(sets.get(index).getData());
    }

    public void add(T data) {
        sets.add(new SetItem(data, sequenceNum));
        itemDict.put(data, sequenceNum++);
    }

    /*
     * Unions the second element to the first.
     */
    public void union(T first, T second) {
        int parentFirst = find(first);
        int parentSecond = find(second);
        if(parentFirst != parentSecond) { //If they have the same parent, they're part of the same set
            reassignParent(second, parentFirst);
        }
    }

    private void reassignParent(T data, int parent) {
        sets.get(index(data)).setParent(parent);

    }

    private int index(T data) {
        return itemDict.get(data);
    }
}
