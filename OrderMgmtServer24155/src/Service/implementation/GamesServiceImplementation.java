/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.implementation;

import DAO.GamesDao;
import Service.GamesService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Games;

/**
 *
 * @author royon
 */
public class GamesServiceImplementation extends UnicastRemoteObject implements GamesService{

    public GamesServiceImplementation() throws RemoteException{
    }
    GamesDao dao = new GamesDao();
    @Override
    public Games RegisterGames(Games gameObj) throws RemoteException {
        return dao.RegisterGames(gameObj);
    }

    @Override
    public Games UpdateGames(Games gameObj) throws RemoteException {
        return dao.UpdateGames(gameObj);
    }

    @Override
    public Games DeleteGames(Games gameObj) throws RemoteException {
        return dao.DeleteGames(gameObj);
    }

    @Override
    public Games SearchGames(Games gameObj) throws RemoteException {
        return dao.SearchGames(gameObj);
    }

    @Override
    public List<Games> allGames() throws RemoteException {
        return dao.allGames();
    }
    
}
