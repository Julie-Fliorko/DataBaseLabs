package com.example.model.dao.implementation;


import com.example.model.dao.GenericDAO;
import com.example.model.entity.Film;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class FilmDAO implements GenericDAO<Film>{
    protected final SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

    @Override
    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            films = session.createQuery("from Film", Film.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public Film findOne(Integer id) {
        Film film = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            film = session.get(Film.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void create(Film credential) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(credential);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Film film) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(film);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Film film = session.get(Film.class, id);
            if (film != null) {
                session.delete(film);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
