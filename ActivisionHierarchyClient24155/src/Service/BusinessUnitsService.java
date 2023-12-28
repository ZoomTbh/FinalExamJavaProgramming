
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.BusinessUnits;


public interface BusinessUnitsService extends Remote{
    BusinessUnits RegisterBusinessUnits (BusinessUnits busiObj) throws RemoteException;
    BusinessUnits UpdateBusinessUnits (BusinessUnits busiObj) throws RemoteException;
    BusinessUnits DeleteBusinessUnits (BusinessUnits busiObj) throws RemoteException;
    BusinessUnits SearchBusinessUnits (BusinessUnits busiObj) throws RemoteException;
    List <BusinessUnits> allBusinesses () throws RemoteException;
}