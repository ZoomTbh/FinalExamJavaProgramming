
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Studios;

public interface StudiosService extends Remote{
    Studios RegisterStudios (Studios stuObj) throws RemoteException;
    Studios UpdateStudios (Studios stuObj) throws RemoteException;
    Studios DeleteStudios (Studios stuObj) throws RemoteException;
    Studios SearchStudios (Studios stuObj) throws RemoteException;
    List <Studios> allStudios () throws RemoteException;
}
