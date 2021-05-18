package com.company.Controller;

import com.company.BusinessLogic.ExternalService.Models.RemoteService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentsController {
    private RemoteService service;

    public StudentsController(RemoteService service) {
        this.service = service;
    }

    private static String readChoices(BufferedReader reader) throws IOException {
        System.out.println("0 - Exit.");
        System.out.println("1 - Enter student's lastname.");
        System.out.println("2 - Enter student's average score.");
        return reader.readLine();
    }

    public void startClient() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String student = "";
        boolean isActive = true;
        while (isActive) {
            String choice = readChoices(reader);
            switch (choice) {
                case "1":
                    System.out.println("Enter student's lastname:");
                    String lastname = reader.readLine();
                    student = service.getStudentByLastname(lastname);
                    System.out.println("Here is what was found with lastname = " + lastname + ": " + student + "\n");
                    break;
                case "2":
                    System.out.println("Enter student's average score:");
                    String averageScore = reader.readLine();
                    student = service.getStudentByAverageScore(averageScore);
                    System.out.println("Here is what was found with average score = " + averageScore + ": " + student + "\n");
                    break;
                case "0":
                    isActive = false;
                    break;
                default:
                    System.out.println("Enter a valid number!");
            }
        }
    }
}
