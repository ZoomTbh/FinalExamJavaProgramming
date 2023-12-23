/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.implementation;

import DAO.LicenceDao;
import Service.LicenceService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Licence;

/**
 *
 * @author royon
 */
public class LicenceServiceImplementation extends UnicastRemoteObject implements LicenceService{

    public LicenceServiceImplementation() throws RemoteException{
    }
    LicenceDao dao = new LicenceDao();
    @Override
    public Licence RegisterLicence(Licence liceObj) throws RemoteException {
        return dao.RegisterLicence(liceObj);
    }

    @Override
    public Licence UpdateLicence(Licence liceObj) throws RemoteException {
        return dao.UpdateLicence(liceObj);
    }

    @Override
    public Licence DeleteLicence(Licence liceObj) throws RemoteException {
        return dao.DeleteLicence(liceObj);
    }

    @Override
    public Licence SearchLicence(Licence liceObj) throws RemoteException {
        return dao.SearchLicence(liceObj);
    }

    @Override
    public List<Licence> allLicences() throws RemoteException {
       return dao.allLicences();
    }
    
}
