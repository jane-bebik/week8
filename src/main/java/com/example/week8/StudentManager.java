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

        // Adding sample students
        addSampleStudent(new Student(1, "John Doe", "john@example.com"));
        addSampleStudent(new Student(2, "Jane Smith", "jane@example.com"));
        addSampleStudent(new Student(3, "Alice Johnson", "alice@example.com"));
        addSampleStudent(new Student(4, "Bob Brown", "bob@example.com"));
    }

    private void addSampleStudent(Student student) {
        studentSet.add(student);
        studentTreeSet.add(student);
        studentStack.push(student);
    }

    public boolean addStudent(Student student) {
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
        return studentStack.isEmpty() ? null : studentStack.pop();
    }
}