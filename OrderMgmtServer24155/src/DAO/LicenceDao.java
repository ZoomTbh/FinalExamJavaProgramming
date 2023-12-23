/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Licence;
import org.hibernate.Session;

/**
 *
 * @author royon
 */
public class LicenceDao {
    public Licence RegisterLicence (Licence liceObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.save(liceObj);
         ss.beginTransaction().commit();
         ss.close();
         return liceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
   public Licence UpdateLicence (Licence liceObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.update(liceObj);
         ss.beginTransaction().commit();
         ss.close();
         return liceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   
    public Licence DeleteLicence (Licence liceObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.delete(liceObj);
         ss.beginTransaction().commit();
         ss.close();
         return liceObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public Licence SearchLicence (Licence liceObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Licence theLicence = (Licence)ss.get(Licence.class, liceObj.getId());
         ss.close();
         return theLicence;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
     
    public List<Licence> allLicences(){
        try{
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Licence>licenses = ss.createQuery("select lice from Licence lice").list();
        ss.close();
        return licenses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    } 
}
