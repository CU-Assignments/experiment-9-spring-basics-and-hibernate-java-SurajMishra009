import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // CREATE
        Student s1 = new Student("Suraj", 22);
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(s1);
        session.getTransaction().commit();
        System.out.println("Student saved: " + s1);

        // READ
        session = factory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, s1.getId());
        System.out.println("Retrieved: " + student);
        session.getTransaction().commit();

        // UPDATE
        session = factory.getCurrentSession();
        session.beginTransaction();
        student.setAge(23);
        session.update(student);
        session.getTransaction().commit();
        System.out.println("Updated: " + student);

        // DELETE
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        System.out.println("Deleted student");
        
        factory.close();
    }
}
