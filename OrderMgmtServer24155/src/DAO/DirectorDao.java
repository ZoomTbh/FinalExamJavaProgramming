/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Director;
import org.hibernate.Session;

/**
 *
 * @author royon
 */
public class DirectorDao {
    public Director RegisterDirector (Director dirObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.save(dirObj);
         ss.beginTransaction().commit();
         ss.close();
         return dirObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
   public Director UpdateDirector (Director dirObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.update(dirObj);
         ss.beginTransaction().commit();
         ss.close();
         return dirObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   
    public Director DeleteDirector (Director dirObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.delete(dirObj);
         ss.beginTransaction().commit();
         ss.close();
         return dirObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public Director SearchDirector (Director dirObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Director theDirector = (Director)ss.get(Director.class, dirObj.getDirectorId());
         ss.close();
         return theDirector;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
     
    public List<Director> allDirectors(){
        try{
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Director>directors = ss.createQuery("select dir from Director dir").list();
        ss.close();
        return directors;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    } 
}
