package estructuras;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class nodoHash {

    private int userI;
    private String userS;
    private String password;
    private String timeStamp;
    private listaDobleCarpeta carpetas;    

    public nodoHash(String userS, String password) {
        this.userS = userS;
        this.carpetas = new listaDobleCarpeta();        
        //Codificar user
        this.userI = codificarUser(userS);
        //Encriptar Contraseña
        this.password = encriptarContraseña(password);
        //Insertar  TimeStamp
        Date datePull = new Date();
        DateFormat dateHour =  new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        String date  = dateHour.format(datePull);        
        this.timeStamp = date;        
        //Agregar carpeta inicial
        this.carpetas.insertar("raiz");
    }
    
    private String encriptarContraseña(String password){
        MessageDigest md = null;
        
        try{
            md = MessageDigest.getInstance("SHA-256");            
        }catch(NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, "Error al encriptar contraseña.", "Error con contraseña.", JOptionPane.ERROR_MESSAGE);
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
    
    public String getTimeStamp(){
        return this.timeStamp;
    }
    
    public void setTimeStamp(String date){
        this.timeStamp = date;
    }

}
