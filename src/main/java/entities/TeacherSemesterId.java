package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeacherSemesterId implements Serializable {
    private static final long serialVersionUID = 1187182147754862481L;
    @Column(name = "teaching_ID", nullable = false)
    private Long teachingId;

    @Column(name = "teachers_ID", nullable = false)
    private Long teachersId;

    public TeacherSemesterId() {
    }

    public Long getTeachingId() {
        return teachingId;
    }

    public void setTeachingId(Long teachingId) {
        this.teachingId = teachingId;
    }

    public Long getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(Long teachersId) {
        this.teachersId = teachersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherSemesterId entity = (TeacherSemesterId) o;
        return Objects.equals(this.teachersId, entity.teachersId) &&
                Objects.equals(this.teachingId, entity.teachingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teachersId, teachingId);
    }

}