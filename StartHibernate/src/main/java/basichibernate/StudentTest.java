package basichibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

/**
 * Hello world!
 *
 */
public class StudentTest 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=cfg.buildSessionFactory();
        Student obj=new Student();
        obj.setId(1);
        obj.setName("Dr");
        obj.setEmail("dr@gmail.com");
        obj.setAddress("Pune");
        //Transaction State of the object
        
        Session s=sf.openSession();
        //s.save(obj);
        //Persist state of the object
        s.beginTransaction().commit();
        List<Student> stud=(List<Student>) s.createQuery("FROM Student").list();
        
        for (Iterator iterator = stud.iterator(); iterator.hasNext();) {
			System.out.println(((Student) iterator.next()).toString());
		}
        System.out.println(stud.toString());
        
    }
}
