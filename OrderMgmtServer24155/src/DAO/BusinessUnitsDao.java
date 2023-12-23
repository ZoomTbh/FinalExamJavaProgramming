
package DAO;

import java.util.List;
import model.BusinessUnits;
import org.hibernate.Session;

public class BusinessUnitsDao {
    public BusinessUnits RegisterBusinessUnits (BusinessUnits busiObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.save(busiObj);
         ss.beginTransaction().commit();
         ss.close();
         return busiObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
   public BusinessUnits UpdateBusinessUnits (BusinessUnits busiObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.update(busiObj);
         ss.beginTransaction().commit();
         ss.close();
         return busiObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   
    public BusinessUnits DeleteBusinessUnits (BusinessUnits busiObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.delete(busiObj);
         ss.beginTransaction().commit();
         ss.close();
         return busiObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public BusinessUnits SearchBusinessUnits (BusinessUnits busiObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         BusinessUnits theBusinessUnits = (BusinessUnits)ss.get(BusinessUnits.class, busiObj.getClass());
         ss.close();
         return theBusinessUnits;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
     
    public List<BusinessUnits> allBusinesses(){
        try{
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<BusinessUnits>businesses = ss.createQuery("select busi from BusinessUnits busi").list();
        ss.close();
        return businesses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    } 
}
