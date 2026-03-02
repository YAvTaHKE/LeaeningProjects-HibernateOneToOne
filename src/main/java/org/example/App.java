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

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // С помощью Hibernate получите любого директора, а затем получите его школу.
            /*Principal principal = session.get(Principal.class, 3);
            System.out.println(principal);
            School school = principal.getSchool();
            System.out.println(school);*/

            // Получите любую школу, а затем получите ее директора.
            /*School school = session.get(School.class, 1);
            System.out.println(school);
            Principal principal = school.getDirector();
            System.out.println(principal);*/

            // Создайте нового директора и новую школу и свяжите эти сущности.
            /*Principal principal = new Principal("Ivan", 55);
            School school = new School(125, principal);
            session.persist(school);
*/
            // Смените директора у существующей школы.
            /*School school = session.get(School.class, 4);
            Principal principal = school.getPrincipal();
            if (principal != null) {
                principal.setSchool(null);
            }

            Principal newPrincipal = new Principal("Evgeniy", 33, school);
            school.setPrincipal(newPrincipal);

            session.persist(newPrincipal);*/


            // Попробуйте добавить вторую школу для существующего директора и изучите возникающую ошибку.
            School sc = session.get(School.class, 2);
            Principal pr = session.get(Principal.class, 2);
            pr.setSchool(sc);
            session.persist(pr);

            session.getTransaction().commit();



        } finally {
            sessionFactory.close();
        }
    }
}
