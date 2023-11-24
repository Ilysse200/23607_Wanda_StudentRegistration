package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class StudentReg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "academic_unit_id")
    private AcademicUnit academicUnit;

    // Add a Many-to-One relationship to the Semester entity
    @ManyToOne
    @JoinColumn(name = "semester_id") // Name of the foreign key column in the StudentReg table
    private Semester semester;

    @JsonManagedReference
    @OneToMany(mappedBy = "studentRegistration") // One StudentReg can have many StudentCourses
    //@JoinColumn(name = "studentCourses")
    private List<StudentCourse> studentCourses;

    private LocalDate regDate;

    public StudentReg(Student student, AcademicUnit academicUnit, Semester semester, LocalDate regDate) {
        this.student = student;
        this.academicUnit = academicUnit;
        this.semester = semester; // Set the semester for this registration
        this.regDate = regDate;
    }

    public StudentReg() {

    }

//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
