import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import entity.Aluno;
import repository.AlunoRepository;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ResourceConfig config = new ResourceConfig();
        config.packages("controllers"); // Pacote onde estão suas rotas
        ServletContainer servletContainer = new ServletContainer(config);
        context.addServlet(new ServletHolder(servletContainer), "/api/*");

        server.start();
        server.join();
    }
}
