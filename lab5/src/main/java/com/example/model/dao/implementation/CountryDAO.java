package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import com.example.model.entity.Country;
import com.example.util.HibernateUtil;


@SuppressWarnings({"unchecked"})
public class CountryDAO implements GenericDAO<Country> {
    protected final SessionFactory sessionFactory =  HibernateUtil.getSessionFactory();

    @Override
    public List<Country> findAll() {
        List<Country> country = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            country = session.createQuery("from Country").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public Country findOne(Integer id) {
        Country country = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            country = session.get(Country.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void create(Country credential) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(credential);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Country country) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Country country = session.get(Country.class, id);
            if (country != null) {
                session.delete(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
