package repository.impl;

import entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.IUserRepository;
import search.UserSearch;
import util.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public List<User> getAll(UserSearch userSearch) {
        try (Session session = HibernateUtils.getSessionFactory().openSession();){


            String hql = "FROM User ";
            Query query = session.createQuery(hql);

            int startIndex = Math.max(userSearch.getPage()-1*userSearch.getLimit(), 0);
            query.setFirstResult(startIndex);
            query.setMaxResults(userSearch.getLimit());
            List <User> userList  = query.list();

            System.out.println("find user ok");
            return userList;
        }catch (Exception e){
            System.out.println("Err when get all user list: " + e);
        }

        return null;
    }

    public List<User> getUserWithPagingAndOrdering(){
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            //--------mo 1 giao dich
            session.beginTransaction();

            //--------------tao 1 builder tu session de truy van
            CriteriaBuilder builder =  session.getCriteriaBuilder();

            //tao doi tuong Query cho doi tuong user
            CriteriaQuery<User> query = builder.createQuery(User.class);

            //chon bang truy van
            Root<User> root = query.from(User.class);
            query.select(root);             //select
            query.where(builder.and(builder.ge(root.get("id"), 1)), builder.le(root.get("id"), 10000));
            query.orderBy(builder.desc(root.get("createDate")), builder.desc(root.get("updateDate")));

            List<User> userList = session.createQuery(query)
                    .setFirstResult(0)
                    .setMaxResults(5)
                    .getResultList();
            session.getTransaction().commit();

            System.out.println("Paging and sorting user ok");
            return userList;
        }catch (Exception e){
            System.out.println("Err when paging and ordering user: " + e);
        }
        return null;
    }


    public List<Object> getAllByColumn(String columnName){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            //mo 1 transaction
            session.beginTransaction();

            //tao 1 builder crie
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //chon kieu du lieu tra ve cho truy van
            CriteriaQuery<Object> query = builder.createQuery(Object.class);
            //chon bang de thao tac
            Root<User> root = query.from(User.class);
            //select
            query.select(root.get(columnName));

            //tra ra ket qua
            List<Object> objectList = session.createQuery(query).getResultList();

            //commit
            session.getTransaction().commit();
            return objectList;
        }catch (Exception e){
            System.out.println("err when get by column: " + e);
        }
        return null;
    }

    @Override
    public User findById(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();

            //tao mot truy van criteria
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = builder.createQuery(User.class);

            Root<User> root = query.from(User.class);
            query.select(root);
            query.where(builder.equal(root.get("id"), id));

            User user = session.createQuery(query).uniqueResult();

            session.getTransaction().commit();

            System.out.println("find user by id ok ");
            return user;
        }catch (Exception e){
            System.out.println("err when find user by id");
        }

        return null;
    }

    @Override
    public User add(User user) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();

            session.save(user);
            session.getTransaction().commit();

            System.out.println("save ok");
            return user;
        }catch (Exception e){
            System.out.println("err when add an user: " + e);
        }

        return null;
    }

    @Override
    public int edit(User user) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
            System.out.println("edit user oke");
            return 1;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println("err when edit user");
        }finally {
            session.close();
        }
        return -1;
    }

    @Override
    public int delete(User user){
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
            System.out.println("delete ok");
            return 1;
        }catch (Exception e){
            System.out.println("err when delete user: " + e);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        return -1;
    }
}
