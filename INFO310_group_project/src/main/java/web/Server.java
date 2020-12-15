 package web;

/**
 * INFO310
 * Server.java
 * 
 * Creates the Jooby server that hosts the HTML and module URIs
 * that call specific DAO methods.
 * 
 * @author Hugo Baird
 */

import dao.StaffDAO;
import dao.StaffInterface;
import dao.StudentDAO;
import dao.ContactRequestDAO;
import dao.ContactRequestInterface;
import dao.StudentInterface;
import java.util.concurrent.CompletableFuture;
import org.jooby.Jooby;
import org.jooby.json.Gzon;

public class Server extends Jooby {
    
    StudentInterface StudentDAO = new StudentDAO();
    StaffInterface CustomerDAO = new StaffDAO();
    ContactRequestInterface crDAO = new ContactRequestDAO();
    
    public Server() {
        use(new Gzon());
        use(new StudentModule(StudentDAO));
        use(new StaffModule(CustomerDAO));
        use(new ContactRequestModule(crDAO));
        use(new AssetModule()); 
    }
   
    public static void main(String[] args) throws Exception {
        System.out.println("\nServer is starting...");
        Server server = new Server();
        CompletableFuture.runAsync(() -> {
            server.start();
        });
        server.onStarted(() -> {
            System.out.println("\nServer successfully started.");
            System.out.println("\nPress 'Enter' to stop the server.");
        });
        System.in.read();
        System.exit(0);
    }
}
