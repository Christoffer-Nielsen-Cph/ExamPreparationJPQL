package facades;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
        Student student = new Student(fname,lname, null);
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
    public void addStudentToSemester(long studentID,long semesterID){
        EntityManager em = emf.createEntityManager();
        Semester semester = em.find(Semester.class,semesterID);
        Student student = em.find(Student.class,studentID);
        em.getTransaction().begin();
        student.setCurrentsemester(semester);
        em.getTransaction().commit();
        em.close();


    }
    public void addTeacherToSemester(long teacherID, long semesterID){
        EntityManager em = emf.createEntityManager();
        TeacherSemesterId teacherSemester = em.find(TeacherSemesterId.class,semesterID);

        Teacher teacher = em.find(Teacher.class,teacherID);


        em.getTransaction().begin();


        teacherSemester.setTeachersId(teacherID);
        teacherSemester.setTeachingId(semesterID);


        em.getTransaction().commit();
        em.close();

    }
    public void removeTeacherFromSemester(long teacherID, long semesterID){

    }
    public void updateSemester(long id, String description, String name){
        EntityManager em = emf.createEntityManager();
        Semester semester = em.find(Semester.class,id);
        em.getTransaction().begin();
        semester.setDescription(description);
        semester.setName(name);
        em.getTransaction().commit();
        em.close();
    }
    public List<Student> getAllStudentsFromSemester(long semesterID){
        EntityManager em = emf.createEntityManager();
        List<Student> students = new ArrayList<>();
        Semester semester = em.find(Semester.class,semesterID);
        students = semester.getStudents();
        em.close();
        return students;
    }
    /*public List<Student> getAllStudentsByTeacher(long teacherID){
        EntityManager em = emf.createEntityManager();
        List<Student> students = new ArrayList<>();
        Teacher teacher = em.find(Teacher.class,teacherID);



    } */

}
