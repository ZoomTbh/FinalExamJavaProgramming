/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Director;

/**
 *
 * @author royon
 */
public interface DirectorService extends Remote{
    Director RegisterDirector (Director dirObj) throws RemoteException;
    Director UpdateDirector (Director dirObj) throws RemoteException;
    Director DeleteDirector (Director dirObj) throws RemoteException;
    Director SearchDirector (Director dirObj) throws RemoteException;
    List <Director> allDirectors () throws RemoteException;
}
