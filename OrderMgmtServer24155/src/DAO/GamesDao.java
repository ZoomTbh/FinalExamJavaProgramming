
package DAO;

import java.util.List;
import model.Games;
import org.hibernate.Session;


public class GamesDao {
     public Games RegisterGames (Games gameObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.save(gameObj);
         ss.beginTransaction().commit();
         ss.close();
         return gameObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
   public Games UpdateGames (Games gameObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.update(gameObj);
         ss.beginTransaction().commit();
         ss.close();
         return gameObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
   
    public Games DeleteGames (Games gameObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         ss.delete(gameObj);
         ss.beginTransaction().commit();
         ss.close();
         return gameObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
     public Games SearchGames (Games gameObj){
        try{
         Session ss = HibernateUtil.getSessionFactory().openSession();
         Games theGames = (Games)ss.get(Games.class, gameObj.getGameId());
         ss.close();
         return theGames;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
     
     
    public List<Games> allGames(){
        try{
        Session ss= HibernateUtil.getSessionFactory().openSession();
        List<Games>gamess = ss.createQuery("select game from Games game").list();
        ss.close();
        return gamess;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
