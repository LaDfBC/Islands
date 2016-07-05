package main.java;

import structs.DisjointSet;

/**
 * Created by squeaky on 7/2/16.
 */
public class GradleChecker {
    public static void main(String[] args) {
        DisjointSet<Integer> set = new DisjointSet<Integer>(1);
        set.find(0);
    }
}
