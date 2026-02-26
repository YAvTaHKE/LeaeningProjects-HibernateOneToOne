package org.example.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Neil Alishev
 */
@Entity
@Table(name = "director")
public class Director {

    @Id
    //альтернатива автогенерации @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "director_seq")
    @SequenceGenerator(name = "director_seq", sequenceName = "director_director_id_seq", allocationSize = 1)
    @Column(name = "director_id")
    private int director_id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany (mappedBy = "director")
    private List<Movie> movieList;

    public Director() {}

    public Director(int director_id, String name, int age) {
        this.director_id = director_id;
        this.name = name;
        this.age = age;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int id) {
        this.director_id = id;
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
        return "Director{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
