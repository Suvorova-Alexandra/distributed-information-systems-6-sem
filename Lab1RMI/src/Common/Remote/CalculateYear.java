package Common.Remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculateYear extends Remote {
boolean isLeap(int year) throws RemoteException;

}
