package Facade;

import entities.Semester;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SchoolFacade {
    private static SchoolFacade instance;
    private static EntityManagerFactory emf;

    public SchoolFacade() {
    }

    public static SchoolFacade getInstance(EntityManagerFactory _emf){
        if(instance == null){
            emf = _emf;
            instance = new SchoolFacade();
        }
        return instance;
    }

    public void createStudent(String fname, String lname){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student(fname,lname);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public void createSemester(String desc, String name){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Semester semester = new Semester(desc,name);
        em.persist(semester);
        em.getTransaction().commit();
        em.close();
    }

    public void createTeacher(String fname, String lname){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = new Teacher(fname,lname);
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

}
