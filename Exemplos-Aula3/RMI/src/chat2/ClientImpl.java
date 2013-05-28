package chat2;

import java.rmi.Naming;  
import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;  
  
import javax.swing.JOptionPane;  
  
@SuppressWarnings("serial")  
public class ClientImpl extends UnicastRemoteObject implements Client {  
    public ClientImpl() throws RemoteException {super();}   
      
    public static void main(String[] args) {  
        Server conn;  
        try {  
            conn = (Server) Naming.lookup("//127.0.0.1/Server1");  
            try {  
                String login = JOptionPane.showInputDialog(null, "Informe seu hostname:");  
                Naming.rebind(login, new ClientImpl());  
                Player player = new Player();  
                player.setLogin(login);  
                conn.connect(player);
                boolean d = false;                
                conn.sendMessage(player, JOptionPane.showInputDialog(null, "Digite uma mensagem"));  
                conn.disconnect(player);  
            } catch (Exception e) {  
                System.out.println("Erro: " + e.getMessage());  
                e.printStackTrace();  
            }  
        } catch (Exception e) {  
            System.out.println("Client exception: " + e.getMessage());  
            e.printStackTrace();  
        }  
    }  
  
    @Override  
    public void receiveMessage(String msg) throws RemoteException {  
        System.out.println(msg);  
    }  
} 