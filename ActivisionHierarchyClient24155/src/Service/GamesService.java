
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Games;


public interface GamesService extends Remote{
    Games RegisterGames (Games gameObj) throws RemoteException;
    Games UpdateGames (Games gameObj) throws RemoteException;
    Games DeleteGames (Games gameObj) throws RemoteException;
    Games SearchGames (Games gameObj) throws RemoteException;
    List <Games> allGames () throws RemoteException;
}