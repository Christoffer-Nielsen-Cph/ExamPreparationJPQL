import entities.Semester;
import entities.Student;
import facades.SchoolFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class Main {

    private static SchoolFacade schoolFacade;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        schoolFacade = SchoolFacade.getInstance(emf);

        //Creates new student
        //Student studentOne = schoolFacade.createStudent("Christoffer","Nielsen");

        //Creates new semester
        //schoolFacade.createSemester("Datamatiker 1. sem", "CLdatone-a14e");

        //Creates new teacher
        //schoolFacade.createTeacher("Frank","Hansen");

        //Updates a specific semester by its id
        //schoolFacade.updateSemester(1,"Mit semester","my semester");

        //Adds students to a semester
        //schoolFacade.addStudentToSemester(9,2);

        //Adds a teacher to a semester
        //schoolFacade.addTeacherToSemester(2,1);
        //schoolFacade.removeTeacherFromSemester(1,1);

        Set<Student> students = schoolFacade.getAllStudentsByTeacher(1);
        for (Student student : students) {
            System.out.println(student);
        }

        //Gets all students from a specific semester and stores them in a list
        /* Set<Student> students = schoolFacade.getAllStudentsFromSemester(1);
        for (Student student : students) {
            System.out.println(student);
        } */

        //Closes connection
        emf.close();
    }
}
