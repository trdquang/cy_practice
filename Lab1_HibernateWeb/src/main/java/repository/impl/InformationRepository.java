package repository.impl;

import entity.Information;
import entity.Product;
import org.hibernate.Session;
import repository.IInformationRepository;
import search.InformationSearch;
import search.ProductSearch;
import util.HibernateUtils;

import java.util.List;

public class InformationRepository implements IInformationRepository {
    @Override
    public List<Information> getAll(InformationSearch informationSearch) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            System.out.println("search in4 ok");
            return session.createQuery("from Information ", Information.class).list();

        }catch (Exception e){
            System.out.println("err when search in4: " + e);
        }
        return null;
    }
}
