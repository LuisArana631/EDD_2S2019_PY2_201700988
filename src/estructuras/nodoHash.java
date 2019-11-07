package estructuras;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class nodoHash {

    private int userI;
    private String userS;
    private String password;
    private listaDobleCarpeta carpetas;

    nodoHash(String userS, String password) {
        this.userS = userS;
        this.carpetas = new listaDobleCarpeta();        
        //Codificar user
        this.userI = codificarUser(userS);
        //Encriptar Contraseña
        this.password = encriptarContraseña(password);
    }
    
    private String encriptarContraseña(String password){
        MessageDigest md = null;
        
        try{
            md = MessageDigest.getInstance("SHA-256");            
        }catch(NoSuchAlgorithmException e){
            
        }
        
        byte[] hash = md.digest(password.getBytes());
        StringBuilder bf =new StringBuilder();
        
        for(byte b : hash){
            bf.append(String.format("%02x",b));
        }
        
        return bf.toString();
    }
    
    private int codificarUser(String user){
        int codigo = 0;
        
        for(int i = 0; i < user.length(); i++){
            char caracter = user.charAt(i);
            
            codigo += caracter;
        }
        
        return codigo;
    }

    public listaDobleCarpeta getCarpetas() {
        return this.carpetas;
    }

    public void setCarpeta(listaDobleCarpeta carpetas) {
        this.carpetas = carpetas;
    }

    public int getUserI() {
        return this.userI;
    }

    public void setUserI(int userI) {
        this.userI = userI;
    }

    public String getUserS() {
        return this.userS;
    }

    public void setUsers(String userS) {
        this.userS = userS;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
