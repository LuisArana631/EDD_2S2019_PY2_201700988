package estructuras;

public class nodoSimpleError {

    private String user;
    private String password;
    private String motivo;
    private nodoSimpleError next;
    
    public nodoSimpleError(String user, String password, String motivo){
        this.user = user;
        this.password = password;
        this.motivo = motivo;
        this.next = null;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
    
    public String getMotivo(){
        return this.motivo;
    }
    
    public void setNext(nodoSimpleError next){
        this.next = next;
    }
    
    public nodoSimpleError getNext(){
        return this.next;
    }
    
}
