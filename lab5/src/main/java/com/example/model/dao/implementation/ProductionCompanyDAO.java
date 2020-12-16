package com.example.model.dao.implementation;

import com.example.model.dao.GenericDAO;
import com.example.model.entity.ProductionCompany;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ProductionCompanyDAO implements GenericDAO<ProductionCompany> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<ProductionCompany> findAll() {
        List<ProductionCompany> companies = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            companies = session.createQuery("from ProductionCompany").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public ProductionCompany findOne(Integer id) {
        ProductionCompany company = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            company = session.get(ProductionCompany.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void create(ProductionCompany company) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ProductionCompany company) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ProductionCompany company = session.get(ProductionCompany.class, id);
            if (company != null) {
                session.delete(company);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
