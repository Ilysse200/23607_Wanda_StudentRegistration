package auca.rw.registration.AucaRegistration.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class AcademicUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String codeNumb;
    private String name;

    @Enumerated(EnumType.STRING)
    private EAcademicUnit e_unit;

//    @ManyToMany(mappedBy = "departments")
//    private List<StudentCourse> courses; // Represents the courses associated with a department

    public AcademicUnit(String codeNumb, String name, EAcademicUnit e_unit) {
//        this.code = code;
        this.codeNumb = codeNumb;
        this.name = name;
        this.e_unit = e_unit;
    }

    public AcademicUnit() {

    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
//    public void setCode(UUID code) {
//        this.code = code;
//    }

    public void setCodeNumb(String codeNumb) {
        this.codeNumb = codeNumb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setE_unit(EAcademicUnit e_unit) {
        this.e_unit = e_unit;
    }

//    public UUID getCode() {
//        return code;
//    }

    public String getCodeNumb() {
        return codeNumb;
    }

    public String getName() {
        return name;
    }

    public EAcademicUnit getE_unit() {
        return e_unit;
    }

//    public Set<StudentCourse> getCourses() {
//        return (Set<StudentCourse>) courses;
//    }

//    public void setCourses(Set<StudentCourse> courses) {
//        this.courses = (List<StudentCourse>) courses;
//    }
}
