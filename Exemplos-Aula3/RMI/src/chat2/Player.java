package chat2;

import java.io.Serializable;  
  
@SuppressWarnings("serial")  
public class Player implements Serializable {  
    private String nome;  
    private String login;  
      
    private Client lookup;  
  
    public void setNome(String nome) {  
        this.nome = nome;  
    }  
  
    public String getNome() {  
        return nome;  
    }  
  
    public void setLogin(String login) {  
        this.login = login;  
    }  
  
    public String getLogin() {  
        return login;  
    }  
  
    public void setConn(Client lookup) {  
        this.lookup = lookup;  
    }  
  
    public Client getConn() {  
        return lookup;  
    }  
}  