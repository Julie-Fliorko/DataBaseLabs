package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.Review;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ReviewDAO implements GenericDAO<Review> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Review> findAll() {
        List<Review> licenseList = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            licenseList = session.createQuery("from Review").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return licenseList;
    }

    @Override
    public Review findOne(Integer id) {
        Review license = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            license = session.get(Review.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license;
    }

    @Override
    public void create(Review license) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(license);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Review license) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(license);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Review license = session.get(Review.class, id);
            if (license != null) {
                session.delete(license);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
