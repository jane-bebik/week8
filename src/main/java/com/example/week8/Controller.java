package com.example.week8;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {
    private StudentManager studentManager = new StudentManager();

    @FXML
    private TextArea outputArea;

    @FXML
    public void addStudent() {
        Student student = new Student(1, "John Doe", "john@example.com");
        boolean added = studentManager.addStudent(student);
        if (added) {
            outputArea.appendText("Added student: " + student + "\n");
        } else {
            outputArea.appendText("Student already exists in the system.\n");
        }
    }

    @FXML
    public void displayStudentsInSet() {
        outputArea.clear();
        outputArea.appendText("Students in HashSet:\n");
        studentManager.getStudentsInSet().forEach(student -> outputArea.appendText(student + "\n"));
    }

    @FXML
    public void displayStudentsInTreeSet() {
        outputArea.clear();
        outputArea.appendText("Students in TreeSet (sorted by name):\n");
        studentManager.getStudentsInTreeSet().forEach(student -> outputArea.appendText(student + "\n"));
    }

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