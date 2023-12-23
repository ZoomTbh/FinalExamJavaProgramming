/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Company;
import org.hibernate.Session;

/**
 *
 * @author royon
 */
public class CompanyDao {
   
    public Company RegisterCompany (Company compObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.save(compObj);
         ss.beginTransaction().commit();
         ss.close();
         return compObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
   public Company UpdateCompany (Company compObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.update(compObj);
         ss.beginTransaction().commit();
         ss.close();
         return compObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   
    public Company DeleteCompany (Company compObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.delete(compObj);
         ss.beginTransaction().commit();
         ss.close();
         return compObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public Company SearchCompany (Company compObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Company theCompany = (Company)ss.get(Company.class, compObj.getId());
         ss.close();
         return theCompany;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
     
    public List<Company> allCompanies(){
        try{
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Company>companies = ss.createQuery("select comp from Company comp").list();
        ss.close();
        return companies;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    

}
