package auca.rw.registration.AucaRegistration.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseIdentifier")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "courseDefinition")
    private CourseDefinition courseDefinition;

    @ManyToOne
    @JoinColumn(name="semesterId")
    private Semester semester;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentRegistrationIdentifier")
    private StudentReg studentRegistration;

//    @ManyToMany
//    @JoinTable(
//            name = "course_department",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "department_id")
//    )
//    private List<AcademicUnit> departments; // Represents the departments associated with a course

    public StudentCourse() {
    }

    public StudentCourse(Course course) {
        this.course = course;
    }

    public StudentCourse(CourseDefinition courseDefinition, Semester semester, StudentReg studentRegistration) {
//        this.id = id;
        this.courseDefinition = courseDefinition;
        this.semester = semester;
//        this.studentRegistration = studentRegistration;

    }

//    public UUID getCourse_id() {
//        return this.id;
//    }
//
//    public void setCourse_id(UUID course_id) {
//        this.id = course_id;
//    }

    public CourseDefinition getCourseDefinition() {
        return this.courseDefinition;
    }

    public void setCourseDefinition(CourseDefinition courseDefinition) {
        this.courseDefinition = courseDefinition;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public StudentReg getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentReg studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

//    public List<AcademicUnit> getDepartments() {
//        return departments;
//    }

//    public void setDepartments(List<AcademicUnit> departments) {
//        this.departments = departments;
//    }
}
