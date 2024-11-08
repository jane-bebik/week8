package com.example.week8;

import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class StudentManager {
    private HashSet<Student> studentSet;
    private TreeSet<Student> studentTreeSet;
    private Stack<Student> studentStack;

    public StudentManager() {
        studentSet = new HashSet<>();
        studentTreeSet = new TreeSet<>((s1, s2) -> s1.getName().compareTo(s2.getName()));
        studentStack = new Stack<>();
    }

    public boolean addStudent(Student student) {
        // Add student to HashSet and treeSet
        boolean addedToSet = studentSet.add(student);
        boolean addedToTreeSet = studentTreeSet.add(student);
        if (addedToSet && addedToTreeSet) {
            studentStack.push(student);
            return true;
        } else {
            return false; // Student already exists
        }
    }

    public HashSet<Student> getStudentsInSet() {
        return studentSet;
    }

    public TreeSet<Student> getStudentsInTreeSet() {
        return studentTreeSet;
    }

    public Student popLastStudent() {
        // Return the last student added, or null if the stack is empty
        return studentStack.isEmpty() ? null : studentStack.pop();
    }
}
