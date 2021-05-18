package Common.Remote;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculateYearObject extends UnicastRemoteObject implements CalculateYear {

    public CalculateYearObject() throws RemoteException {

    }
    @Override
    public boolean isLeap(int year) {
        boolean answer=false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    answer=true;
                }
            } else {
                answer=true;
            }
        }

        return answer;
    }
}
