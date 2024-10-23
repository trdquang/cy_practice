import java.util.Date;
import java.util.List;

import entity.User;
import org.hibernate.Session;
import util.HibernateUtils;

public class Test {

    public static void main(String[] args) {

        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
            // Begin a unit of work
            session.beginTransaction();

            // Insert user
            Date currentDate = new Date();
            User user1 = new User();
            user1.setFullname("example");
            user1.setUsername("abcd");
            user1.setPassword("12345678910"); // Should encode password

            Long userId = (Long) session.save(user1);
            System.out.println("User id = " + userId);

            // Count user from database
            Long numberOfUser = session.createQuery("SELECT COUNT(id) FROM User", Long.class).uniqueResult();
            System.out.println("Number of user in database: " + numberOfUser);

            // Get user by id
            User savedUser = session.find(User.class, userId);
            System.out.println("savedUser: " + savedUser);

            // Update user
            savedUser.setFullname("GP Coder");
            session.update(savedUser);

            // Get users
            List<User> users = session.createQuery("FROM User", User.class).list();
            users.forEach(System.out::println);

            // Delete user
            session.delete(savedUser);

            // Count user from database
            numberOfUser = session.createQuery("SELECT COUNT(id) FROM User", Long.class).uniqueResult();
            System.out.println("Number of user in database: " + numberOfUser);

            // Commit the current resource transaction, writing any unflushed changes to the database.
            session.getTransaction().commit();
        }
    }

    public static void add(User user){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Long userId = (Long) session.save(user);
            session.getTransaction().commit();
        }
    }
}