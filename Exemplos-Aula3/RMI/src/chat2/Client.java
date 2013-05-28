package chat2;

import java.rmi.Remote;  
import java.rmi.RemoteException;  
  
public interface Client extends Remote {  
    void receiveMessage(String string) throws RemoteException;  
}