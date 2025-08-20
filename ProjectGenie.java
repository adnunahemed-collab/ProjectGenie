/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectgenie;

/**
 *
 * @author Methun
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ProjectGenie extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private String userName = "";
    private Random random = new Random();
    private String lastProject = ""; 
    private String userLevel = ""; 

    // //projects for beginners
    private String[] beginnerProjects = {
        "Calculator App",
        "To-Do List Manager",
        "Currency Converter",
        "Notes Taking App",
        "Reminder/Alarm App",
        "Recipe Sharing Platform",
        "Typing Speed Tester",
        "Student Grade Calculator",
        "Snake Game",
        "Tic Tac Toe Game",
        "Sudoku Solver",
        "Hangman Game",
        "Number Guessing Game",
        "Memory Puzzle Game",
        "Digital Resume Builder",
        "Dictionary App",
        "Smart Calculator (Scientific)",
        "Simple Compiler/Interpreter",
        "Quiz Game",
        "Portfolio Website"
    };
//projects for intermediates
    private String[] intermediateProjects = {
        "Library Management System",
        "Weather Forecasting App",
        "Chat Application",
        "Student Attendance System",
        "Expense Tracker",
        "Online Banking System",
        "Hotel Booking System",
        "Food Ordering App",
        "Online Voting System",
        "Music Player",
        "Video Streaming App",
        "Blog Platform",
        "Online Exam System",
        "Flight Reservation System",
        "Movie Ticket Booking",
        "Parking Management System",
        "Fitness Tracker",
        "Car Rental System",
        "Train Reservation System",
        "Inventory Management"
    };
//projects for professionals
    private String[] professionalProjects = {
        "Hospital Management System",
        "E-commerce Website",
        "School Management System",
        "Employee Payroll System",
        "Virtual File Explorer",
        "Online Course Platform",
        "Gaming Leaderboard",
        "Chatbot for FAQs",
        "Bank ATM Simulation",
        "Personal Finance Manager",
        "Task Scheduler",
        "Traffic Management Simulation",
        "Smart Home Controller",
        "Weather Data Visualizer",
        "Email Client",
        "News Aggregator",
        "Document Scanner App",
        "Online Survey System",
        "Flight Reservation System",
        "Enterprise ERP System (Advanced)"
    };

    // Mini coding challenges 
    private String[] codingChallenges = {
        "Write a program to reverse a string.",
        "Write a program to check if a number is prime.",
        "Write a program to find the largest number in an array.",
        "Write a program to print Fibonacci series.",
        "Write a program to check if a string is palindrome.",
        "Write a program to count vowels in a string.",
        "Write a program to sort an array without using library methods.",
        "Write a program to swap two numbers without a third variable.",
        "Write a program to calculate factorial of a number.",
        "Write a program to print a pyramid pattern."
    };

    public ProjectGenie() {
        setTitle("Project Advisor-AI(ProjectGnie)");
        setSize(520, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> handleUserInput());
        inputField.addActionListener(e -> handleUserInput());

        showMessage(" Bot: Hey there! Type your name to start.");
    }

    private void showMessage(String message) {
        chatArea.append(message + "\n");
    }

    private void handleUserInput() {
        String input = inputField.getText().trim();
        if (input.isEmpty()) return;

        showMessage(" User: " + input);
        inputField.setText("");

        if (userName.isEmpty()) {
            userName = input;
            showMessage(" Bot: Nice to meet you, " + userName + "!");
            showMessage(" Bot: Type 'project' for a project idea, 'challenge' for a coding challenge, or 'exit' to quit.");
        } else if (input.equalsIgnoreCase("project") && userLevel.isEmpty()) {
            showMessage(" Bot: Great! Please choose your level: Beginner, Intermediate, or Professional.");
        } else if (userLevel.isEmpty() && 
                   (input.equalsIgnoreCase("beginner") || input.equalsIgnoreCase("intermediate") || input.equalsIgnoreCase("professional"))) {
            userLevel = input.toLowerCase();
            showMessage(" Bot: Awesome! You selected " + userLevel + " level.");
            suggestProject();
        } else {
            switch (input.toLowerCase()) {
                case "exit":
                    showMessage(" Bot: Goodbye, " + userName + "! ");
                    System.exit(0);
                    break;

                case "project":
                    if (userLevel.isEmpty()) {
                        showMessage(" Bot: Please choose your level first: Beginner, Intermediate, or Professional.");
                    } else {
                        suggestProject();
                    }
                    break;

                case "more":
                    if (!lastProject.isEmpty() && !userLevel.isEmpty()) {
                        suggestProject();
                    } else {
                        showMessage(" Bot: Type 'project' first to get a project idea. 'challenge' for a coding challenge, or 'exit' to quit.");
                    }
                    break;

                case "challenge":
                    String challenge = codingChallenges[random.nextInt(codingChallenges.length)];
                    showMessage(" Bot: Here's a coding challenge for you, " + userName + ": " + challenge);
                    break;

                default:
                    showMessage(" Bot: Sorry, I didn’t understand. Try 'project', 'more', 'challenge', or 'exit'.");
                    break;
            }
        }
    }

    private void suggestProject() {
        String[] ideas;
        if (userLevel.equals("beginner")) {
            ideas = beginnerProjects;
        } else if (userLevel.equals("intermediate")) {
            ideas = intermediateProjects;
        } else {
            ideas = professionalProjects;
        }

        String idea;
        do {
            idea = ideas[random.nextInt(ideas.length)];
        } while (idea.equals(lastProject));
        lastProject = idea;

        showMessage(" Bot: Here's a " + userLevel + " project idea for you, " + userName + ": " + idea);
        showMessage(" Bot: If you want another idea, type 'more'. 'challenge' for a coding challenge, or 'exit' to quit. ");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProjectGenie().setVisible(true);
        });
    }
}
