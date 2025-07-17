package org.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class BaseDAO<T>{
    private final SessionFactory sessionFactory;
    private Session session;
    protected  Class<T> tClass;
    public BaseDAO(Class<T> tClass){
        this.sessionFactory= org.example.util.SessionFactorySingleton.getSessionFactory();
        this.tClass = tClass;
    }

    public T createOrUpdate (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(element);
            session.getTransaction().commit();
            System.out.println("ya tout bon !");
            return element;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public T get (long id){
        session = sessionFactory.openSession();
        T element  = session.get(tClass,id);
        session.close();
        System.out.println("ya tout bon !");
        return element;
    }

    public boolean delete (long id){
        try{
            T element = get(id);
            if(element != null){
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.delete(element);
                session.getTransaction().commit();
                System.out.println("ya tout bon !");
                return true;
            }
            return false;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false;
        }finally {
            session.close();
        }
    }
    public List<T> get() {

        try {
            session = sessionFactory.openSession();
            return session.createQuery("from " + tClass.getSimpleName(), tClass).list();
        } catch (Exception e) {
            System.out.println("aleeeeeeeerte : " + e.getMessage());
            return null;
        } finally {
            System.out.println("ya tout bon !");
            if (session != null) {
                session.close();
            }
        }
    }

}
