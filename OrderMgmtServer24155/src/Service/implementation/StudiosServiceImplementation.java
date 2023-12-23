
package Service.implementation;

import DAO.StudiosDao;
import Service.StudiosService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Studios;

/**
 *
 * @author royon
 */
public class StudiosServiceImplementation extends UnicastRemoteObject implements StudiosService{

    public StudiosServiceImplementation() throws RemoteException{
    }
    StudiosDao dao = new StudiosDao();
    @Override
    public Studios RegisterStudios(Studios stuObj) throws RemoteException {
        return dao.RegisterStudios(stuObj);
    }

    @Override
    public Studios UpdateStudios(Studios stuObj) throws RemoteException {
        return dao.UpdateStudios(stuObj);
    }

    @Override
    public Studios DeleteStudios(Studios stuObj) throws RemoteException {
        return dao.DeleteStudios(stuObj);
    }

    @Override
    public Studios SearchStudios(Studios stuObj) throws RemoteException {
        return dao.SearchStudios(stuObj);
    }

    @Override
    public List<Studios> allStudios() throws RemoteException {
        return dao.allStudios();
    }
    
}
