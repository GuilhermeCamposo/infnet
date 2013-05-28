package chat2;

import java.rmi.Remote;  
import java.rmi.RemoteException;  
  
public interface Server extends Remote {  
    void connect(Player player) throws RemoteException;  
    void sendMessage(Player player, String msg) throws RemoteException;  
    void disconnect(Player player) throws RemoteException;  
} 