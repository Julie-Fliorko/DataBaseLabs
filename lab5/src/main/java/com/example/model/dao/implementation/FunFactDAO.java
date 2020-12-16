package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.FunFact;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class FunFactDAO implements GenericDAO<FunFact> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<FunFact> findAll() {
        List<FunFact> facts = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            facts = session.createQuery("from FunFact").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facts;
    }

    @Override
    public FunFact findOne(Integer id){
        FunFact fact = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            fact = session.get(FunFact.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fact;
    }

    @Override
    public void create(FunFact fact){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(fact);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, FunFact fact){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(fact);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            FunFact license = session.get(FunFact.class, id);
            if (license != null) {
                session.delete(license);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
