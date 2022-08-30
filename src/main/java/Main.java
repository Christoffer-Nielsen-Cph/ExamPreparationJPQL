import entities.Semester;
import entities.Student;
import facades.SchoolFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    private static SchoolFacade schoolFacade;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        schoolFacade = SchoolFacade.getInstance(emf);

        //Creates new student
        Student studentOne = schoolFacade.createStudent("Christoffer","Nielsen");

        //Creates new semester
        schoolFacade.createSemester("Datamatiker 1. sem", "CLdatone-a14e");

        //Creates new teacher
        schoolFacade.createTeacher("Frank","Hansen");

        //Updates a specific semester by its id
        schoolFacade.updateSemester(1,"Mit semester","my semester");

        //Adds students to a semester
        schoolFacade.addStudentToSemester(7,2);

        //Adds a teacher to a semester
        schoolFacade.addTeacherToSemester(1,1);

        //Gets all students from a specific semester and stores them in a list
        List<Student> students = schoolFacade.getAllStudentsFromSemester(1);
        for (Student student : students) {
            System.out.println(student);
        }

        //Closes connection
        emf.close();
    }
}
