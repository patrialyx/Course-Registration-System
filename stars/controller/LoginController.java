package stars.controller;

import stars.boundary.*;
import stars.entity.*;

// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Scanner;
// import java.io.BufferedWriter;
// import java.io.File;

public class LoginController {
    /**
     * Verifies the username and passsword of the use
     * 
     * @param username
     * @param password
     */
    public boolean verifyLogin(String username, String password) {
        Authenticator studenAuthenticator = new FlatFileStudentAuthenticator();
        Authenticator adminAuthenticator = new FlatFileAdminAuthenticator();

        boolean verification = adminAuthenticator.authenticate(username, password);
        if (verification) {
            AdminUI ui = new AdminUI();
            ui.displayMenu();
            return true;
        } else {
            verification = studenAuthenticator.authenticate(username, password);
            if (verification) {
                StudentUI ui = new StudentUI(username);
                ui.displayMenu();
                return true;
            }
        }
        return false;
    }
}
