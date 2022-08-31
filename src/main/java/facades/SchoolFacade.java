package facades;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.*;

public class SchoolFacade {
    private static SchoolFacade instance;
    private static EntityManagerFactory emf;

    public SchoolFacade() {
    }

    public static SchoolFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SchoolFacade();
        }
        return instance;
    }

    public Student createStudent(String fname, String lname) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student(fname, lname, null);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        return student;
    }

    public Semester createSemester(String desc, String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Semester semester = new Semester(desc, name);
        em.persist(semester);
        em.getTransaction().commit();
        em.close();
        return semester;
    }

    public Teacher createTeacher(String fname, String lname) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Teacher teacher = new Teacher(fname, lname);
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
        return teacher;
    }

    public Student addStudentToSemester(long studentID, long semesterID) {
        EntityManager em = emf.createEntityManager();
        Semester semester = em.find(Semester.class, semesterID);
        Student student = em.find(Student.class, studentID);
        em.getTransaction().begin();
        student.setCurrentsemester(semester);
        em.getTransaction().commit();
        em.close();
        return student;


    }

    public void addTeacherToSemester(long semesterID, long teacherID) {
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        Semester semester = em.find(Semester.class, semesterID);
        em.getTransaction().begin();
        teacher.getSemesters().add(semester);
        em.getTransaction().commit();
        em.close();

    }

    public void removeTeacherFromSemester(long teacherID, long semesterID) {
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        Semester semester = em.find(Semester.class, semesterID);
        em.getTransaction().begin();
        teacher.getSemesters().remove(semester);
        em.getTransaction().commit();
        em.close();

    }

    public void updateSemester(long id, String description, String name) {
        EntityManager em = emf.createEntityManager();
        Semester semester = em.find(Semester.class, id);
        em.getTransaction().begin();
        if (semester != null) {
            semester.setDescription(description);
            semester.setName(name);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Set<Student> getAllStudentsFromSemester(long semesterID) {
        EntityManager em = emf.createEntityManager();
        Set<Student> students = new HashSet<>();
        Semester semester = em.find(Semester.class, semesterID);
        students = semester.getStudents();
        em.close();
        return students;
    }

    public Set<Student> getAllStudentsByTeacher(long teacherID) {
        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, teacherID);
        Set<Student> studentsInSemester = new LinkedHashSet<>();
        Set<Semester> semesters = teacher.getSemesters();
        for (Semester semester : semesters) {
            studentsInSemester = semester.getStudents();
        }
        em.close();
        return studentsInSemester;


    }

}
