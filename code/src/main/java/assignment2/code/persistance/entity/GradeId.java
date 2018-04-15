package assignment2.code.persistance.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradeId implements Serializable {
    private static final long serialVersionUID = 1L;

    private EnrolmentId enrolmentId;
    private Integer meetingId;


    public EnrolmentId getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(EnrolmentId enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GradeId)) return false;
        GradeId gradeId = (GradeId) o;
        return Objects.equals(enrolmentId, gradeId.enrolmentId) &&
                Objects.equals(meetingId, gradeId.meetingId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(enrolmentId, meetingId);
    }
}
