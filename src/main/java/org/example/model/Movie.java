package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    //альтернатива автогенерации @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_movie_id_seq", allocationSize = 1)
    @Column(name = "movie_id")
    private int movie_id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year_of_production;

    @ManyToOne
    @JoinColumn (name = "director_id", referencedColumnName = "director_id")
    private Director director;

    public Movie(){};

    public Movie(String name, int year_of_production, Director director){
        this.name = name;
        this.year_of_production = year_of_production;
        this.director = director;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(int year_of_production) {
        this.year_of_production = year_of_production;
    }

    public Director getDirector() {
        return director;
    }

    public void setOwner(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year_of_production=" + year_of_production +
                '}';
    }
}
