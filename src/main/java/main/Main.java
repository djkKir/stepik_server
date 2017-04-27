package main;
import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SingInServlet;
import servlets.SingUpServlet;


public class Main {


    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService();


        DBService dbS = new DBService();
       // dbS.cleanUp();
        dbS.createUsers();


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new SingUpServlet(accountService)), "/signup");
        context.addServlet(new ServletHolder(new SingInServlet(accountService)), "/signin");



        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);
        System.out.println("Server started");


        server.start();
        server.join();
    }
}
