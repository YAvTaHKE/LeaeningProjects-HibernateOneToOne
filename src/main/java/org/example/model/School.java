package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "School", schema = "schema1")
public class School {

    @Id
    //альтернатива автогенерации @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "school_seq")
    @SequenceGenerator(name = "school_seq", sequenceName = "schema1.school_id_seq", allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "school_number")
    private int school_number;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    private Principal principal;

    public School(){};

    public School(int school_number, Principal principal){
        this.school_number = school_number;
        this.principal = principal;
    }

    public int getId() {
        return id;
    }

    public void setId(int movie_id) {
        this.id = movie_id;
    }

    public int getSchool_number() {
        return school_number;
    }

    public void setSchool_number(int school_number) {
        this.school_number = school_number;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "School{" +
                "number='" + school_number +
                "principal='" + principal +
                '}';
    }
}
