/**
 * Created by Drapegnik on 08.03.17.
 */

package app.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.UUID;

/**
 * <p>Class for storing info about {@link Student}'s marks</p>
 * <b>{@link Subject}</b>, <b>{@link Mark#studentId}</b>, <b>{@link Mark#grade}</b>
 *
 * @author Ivan Pazhitnykh
 * @version 1.0
 */
@XmlRootElement
public class Mark implements Serializable {
    private String id;
    @XmlElement
    private Subject subject;
    @XmlElement
    private int grade;
    /**
     * Link with student {@link Student#id}
     */
    private String studentId;

    public Mark() {}

    public Mark(Subject subject, int grade, String studentId) {
        this.subject = subject;
        this.studentId = studentId;
        this.grade = grade;
        this.id = UUID.randomUUID().toString();

    }

    public Mark(String subject, int grade, String studentId) {
        this(Subject.valueOf(subject), grade, studentId);
    }

    public Subject getSubject() {return subject;}

    public String getStudentId() {return studentId;}

    public int getGrade() {return grade;}

    public String getId() {return id;}

    @Override
    public String toString() {
        return "Mark{" +
                "studentId='" + studentId + '\'' +
                ",\tsubject=" + subject +
                ",\tgrade=" + grade +
                '}';
    }

    public String shortToString() {
        return '{' +
                "subject=" + subject +
                ",\tgrade=" + grade +
                "} ";
    }
}
