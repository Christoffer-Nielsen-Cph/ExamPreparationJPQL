import Facade.SchoolFacade;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static SchoolFacade schoolFacade;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        schoolFacade = SchoolFacade.getInstance(emf);
        schoolFacade.createStudent("Christoffer","Nielsen");
        schoolFacade.createSemester("Datamatiker 1. sem", "CLdatone-a14e");
        schoolFacade.createTeacher("Frank","Hansen");
    }
}
