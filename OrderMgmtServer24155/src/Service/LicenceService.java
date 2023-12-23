/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Licence;

/**
 *
 * @author royon
 */
public interface LicenceService extends Remote{
    Licence RegisterLicence (Licence liceObj) throws RemoteException;
    Licence UpdateLicence (Licence liceObj) throws RemoteException;
    Licence DeleteLicence (Licence liceObj) throws RemoteException;
    Licence SearchLicence (Licence liceObj) throws RemoteException;
    List <Licence> allLicences () throws RemoteException;
}