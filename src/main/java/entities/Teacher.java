package entities;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "TEACHER")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @ManyToMany
    @JoinTable(name = "TEACHER_SEMESTER",
            joinColumns = @JoinColumn(name = "teachers_ID"),
            inverseJoinColumns = @JoinColumn(name = "teaching_ID"))
    private Set<Semester> semesters = new LinkedHashSet<>();

    public Teacher() {
    }

    public Teacher(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSemesters(Set<Semester> semesters) {
        this.semesters = semesters;
    }

    public Set<Semester> getSemesters() {
        return semesters;
    }
}