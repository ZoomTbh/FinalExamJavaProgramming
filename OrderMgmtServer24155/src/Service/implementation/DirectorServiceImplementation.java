/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.implementation;

import DAO.DirectorDao;
import Service.DirectorService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Director;

/**
 *
 * @author royon
 */
public class DirectorServiceImplementation extends UnicastRemoteObject implements DirectorService{

    public DirectorServiceImplementation() throws RemoteException{
    }
    DirectorDao dao = new DirectorDao();
    
    @Override
    public Director RegisterDirector(Director dirObj) throws RemoteException {
        return dao.RegisterDirector(dirObj);
    }

    @Override
    public Director UpdateDirector(Director dirObj) throws RemoteException {
        return dao.UpdateDirector(dirObj);
    }

    @Override
    public Director DeleteDirector(Director dirObj) throws RemoteException {
        return dao.DeleteDirector(dirObj);
    }

    @Override
    public Director SearchDirector(Director dirObj) throws RemoteException {
        return dao.SearchDirector(dirObj);
    }

    @Override
    public List<Director> allDirectors() throws RemoteException {
        return dao.allDirectors();
    }
    
}
