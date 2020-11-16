package stars.boundary.admin;

import stars.boundary.SelectUI;
import stars.controller.*;
import stars.entity.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EditStudentAccess extends SelectUI {
    public void editStudentAccess(AdminController adminController) {
        ArrayList<Student> studentList = adminController.getStudentList();
        Student selectedStudent = (Student) select(studentList);
        if (selectedStudent == null) {
            System.out.println("\nNo Students in Database!\n");
            return;
        }

        Scanner sc = new Scanner(System.in);
        LocalDateTime start, end;
        while (true) {
            try {
                System.out.print("  a. Access Period Start (DD/MM/YYYY hh:mm): ");
                start = LocalDateTime.parse(sc.nextLine(), dateFormatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect Format");
            }
        }
        while (true) {
            try {
                System.out.print("  b. Access Period End (DD/MM/YYYY hh:mm): ");
                end = LocalDateTime.parse(sc.nextLine(), dateFormatter);
                if (end.isAfter(start)) {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect Format");
            }
        }
        adminController.editAccess(selectedStudent.getStudentID(), start, end);
    }
}
