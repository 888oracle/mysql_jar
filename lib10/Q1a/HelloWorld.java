import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HelloWorld {

    public static void main(String[] args) {
        // Create a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Message.class)
                .buildSessionFactory();

        // Create a session
        Session session = factory.getCurrentSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Display a "Hello world" message
            System.out.println("Hello world!");

            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            // Close the session
            session.close();
        }
    }
}