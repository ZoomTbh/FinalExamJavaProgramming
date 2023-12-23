
package Service.implementation;

import DAO.BusinessUnitsDao;
import Service.BusinessUnitsService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.BusinessUnits;


public class BusinessUnitsServiceImplementation extends UnicastRemoteObject implements BusinessUnitsService{

    public BusinessUnitsServiceImplementation() throws RemoteException{
    }
    BusinessUnitsDao dao = new BusinessUnitsDao();
    @Override
    public BusinessUnits RegisterBusinessUnits(BusinessUnits busiObj) throws RemoteException {
        return dao.RegisterBusinessUnits(busiObj);
    }

    @Override
    public BusinessUnits UpdateBusinessUnits(BusinessUnits busiObj) throws RemoteException {
        return dao.UpdateBusinessUnits(busiObj);
    }

    @Override
    public BusinessUnits DeleteBusinessUnits(BusinessUnits busiObj) throws RemoteException {
       return dao.DeleteBusinessUnits(busiObj);
    }

    @Override
    public BusinessUnits SearchBusinessUnits(BusinessUnits busiObj) throws RemoteException {
        return dao.SearchBusinessUnits(busiObj);
    }

    @Override
    public List<BusinessUnits> allBusinesses() throws RemoteException {
        return dao.allBusinesses();
    }
    
}
