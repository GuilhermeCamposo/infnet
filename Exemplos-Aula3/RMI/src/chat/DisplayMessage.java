package chat;

import java.rmi.RemoteException;


public class DisplayMessage implements Notificacao {
	private javax.swing.JTextArea textArea;
	private String nome;

    public DisplayMessage(javax.swing.JTextArea ta)
        throws RemoteException {
    	    textArea = ta;
    }
    
    public void enviarMensagemEntrada(String name)
        throws RemoteException
    {
        try {
    	    textArea.append(name + " has joined\n");
    	}
        catch(Exception e){
            System.out.println("Message Failure");
            e.printStackTrace();
        };
    }
    
    public void enviarMensagemTexto(String name, String message) throws RemoteException
    {
        try {
    	    textArea.append(name + " says: " + message + "\n");
    	}
        catch(Exception e){
            System.out.println("Message Failure");
            e.printStackTrace();
        };
    }
    
    public void enviarMensagemSaida(String name) throws RemoteException {
        try {
    	    textArea.append(name + " has left the building.\n");
    	}
        catch(Exception e){
            System.out.println("Message Failure");
        };
    }
    
  //este é chamado remotamente
    public String getNome() {
    	return nome;
    }
    
    
    public void setNome(String nome) throws RemoteException {
    	this.nome = nome;
    }
    	
}
