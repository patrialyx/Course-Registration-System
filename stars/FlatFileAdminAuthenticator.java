package stars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlatFileAdminAuthenticator implements Authenticator {
    private final String ADMIN_ACCOUNT_FILE = "stars/adminAccount.txt";
    
    public boolean authenticate(String username, String password) {
        int hashedPassword = password.hashCode();
        System.out.println(hashedPassword);
        String adminUsername;
        int adminPassword;
        try {
            Scanner admin = new Scanner(new File(ADMIN_ACCOUNT_FILE));
            adminUsername = admin.nextLine();
            adminPassword = admin.nextInt();
            if (username.equals(adminUsername) && hashedPassword == adminPassword) {
                return true;
            } 
        } catch (FileNotFoundException e) {
            System.out.print("file not file error\n");
            return false;
        }
        return false;
    }
}
