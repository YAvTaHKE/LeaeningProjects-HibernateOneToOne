package org.example;
/*
1) Создать Java приложение с подключенным Hibernate, которое имеет две
сущности - Режиссер и Фильм. Эти две сущности связаны с таблицами в
БД. В качестве стартового приложения можно использовать HibernateApp
(https://github.com/NeilAlishev/SpringCourse/tree/master/HibernateApp).
2) С помощью Hibernate получите любого режиссера, а затем получите список
его фильмов.
//3) Получите любой фильм, а затем получите его режиссера.
4) Добавьте еще один фильм для любого режиссера.
5) Создайте нового режиссера и новый фильм и свяжите эти сущности.
6) Смените режиссера у существующего фильма.
7) Удалите фильм у любого режиссера.
*/

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
/*//получите любого режиссера, а затем получите список
//его фильмов.
            Director person = session.get(Director.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());
            List<Movie> movieList = person.getMovieList();
            movieList.forEach(System.out::println);*/

/*            //Получите любой фильм, а затем получите его режиссера.
            Movie movie = session.get(Movie.class, 3);
            System.out.println(movie);
            Director director = movie.getDirector();
            System.out.println(director);*/

/*            //Добавьте еще один фильм для любого режиссера.
            Director director = session.get(Director.class, 3);
            Movie movie = new Movie("Аватар2", 2015, director);
            director.getMovieList().add(movie);

            director.getMovieList().forEach(System.out::println);

            session.save(movie);
*/
            //Создайте нового режиссера и новый фильм и свяжите эти сущности.
            session.getTransaction().commit();



        } finally {
            sessionFactory.close();
        }
    }
}
