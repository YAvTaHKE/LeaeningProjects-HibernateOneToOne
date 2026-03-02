package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

/**
 * @author Neil Alishev
 */
@Entity
@Table(name = "principal", schema = "schema1")
public class Principal {

    @Id
    //альтернатива автогенерации @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "principal_seq")
    @SequenceGenerator(
            name = "principal_seq",
            sequenceName = "schema1.principal_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToOne (mappedBy = "principal")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private School school;

    public Principal() {}

    public Principal(String name, int age, School school) {
        this.school = school;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Principal{" +
                "age=" + age +
                ", name='" + name +
                ", School='" + school + '\'' +
                '}';
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
