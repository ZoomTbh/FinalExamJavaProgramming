
package DAO;

import java.util.List;
import model.Studios;
import org.hibernate.Session;


public class StudiosDao {
     public Studios RegisterStudios (Studios stuObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.save(stuObj);
         ss.beginTransaction().commit();
         ss.close();
         return stuObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
   public Studios UpdateStudios (Studios stuObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.update(stuObj);
         ss.beginTransaction().commit();
         ss.close();
         return stuObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   
    public Studios DeleteStudios (Studios stuObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.delete(stuObj);
         ss.beginTransaction().commit();
         ss.close();
         return stuObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public Studios SearchStudios (Studios stuObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Studios theStudios = (Studios)ss.get(Studios.class, stuObj.getStudioId());
         ss.close();
         return theStudios;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
     
    public List<Studios> allStudios(){
        try{
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Studios>studioss = ss.createQuery("select stu from Studios stu").list();
        ss.close();
        return studioss;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
