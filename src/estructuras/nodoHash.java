package estructuras;

public class nodoHash {

    private int userI;
    private String userS;
    private String password;
    private listaDobleCarpeta carpetas;

    nodoHash(String userS, String password, int userI) {
        this.userS = userS;
        this.carpetas = new listaDobleCarpeta();        
        this.userI = userI;
        //Encriptar Contraseña
        this.password = password;
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
