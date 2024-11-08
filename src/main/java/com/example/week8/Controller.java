package com.example.week8;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    private StudentManager studentManager = new StudentManager();

    // FXML elements for user input
    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextArea outputArea;

    // Method to add student with data from input fields
    @FXML
    public void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                outputArea.appendText("Name and Email cannot be empty.\n");
                return;
            }

            Student student = new Student(id, name, email);
            boolean added = studentManager.addStudent(student);
            if (added) {
                outputArea.appendText("Added student: " + student + "\n");
            } else {
                outputArea.appendText("Student with ID " + id + " already exists in the system.\n");
            }

            // Clear the input fields after adding
            idField.clear();
            nameField.clear();
            emailField.clear();
        } catch (NumberFormatException e) {
            outputArea.appendText("Invalid ID. Please enter a valid integer.\n");
        }
    }

    // Method to display all students in the HashSet
    @FXML
    public void displayStudentsInSet() {
        outputArea.clear();
        outputArea.appendText("Students in HashSet:\n");
        studentManager.getStudentsInSet().forEach(student -> outputArea.appendText(student + "\n"));
    }

    // Method to display all students in the TreeSet
    @FXML
    public void displayStudentsInTreeSet() {
        outputArea.clear();
        outputArea.appendText("Students in TreeSet (sorted by name):\n");
        studentManager.getStudentsInTreeSet().forEach(student -> outputArea.appendText(student + "\n"));
    }

    // Method to pop the last added student from the stack
    @FXML
    public void popLastStudent() {
        Student lastAddedStudent = studentManager.popLastStudent();
        if (lastAddedStudent != null) {
            outputArea.appendText("Popped last added student: " + lastAddedStudent + "\n");
        } else {
            outputArea.appendText("No students to pop.\n");
        }
    }
}
