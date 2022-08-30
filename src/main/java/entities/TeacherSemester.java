package entities;

import javax.persistence.*;

@Entity
@Table(name = "TEACHER_SEMESTER")
public class TeacherSemester {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private TeacherSemesterId id;

    @MapsId("teachingId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teaching_ID", nullable = false)
    private Semester teaching;

    @MapsId("teachersId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "teachers_ID", nullable = false)
    private Teacher teachers;

    public TeacherSemester() {
    }

    public TeacherSemesterId getId() {
        return id;
    }

    public void setId(TeacherSemesterId id) {
        this.id = id;
    }

    public Semester getTeaching() {
        return teaching;
    }

    public void setTeaching(Semester teaching) {
        this.teaching = teaching;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }

}