package auca.rw.registration.AucaRegistration.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "studentNames", nullable = false)
    private  String studentName;


    @Column(name = "dob", nullable = false)
    private String dateOfBirth;
//    @Id
//    private Long id;

    public Student(String studentName, String dateOfBirth) {
        //this.studentId = studentId;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {
    }
}
