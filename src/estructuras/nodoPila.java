package estructuras;

public class nodoPila {

    private String user;
    private String date;
    private String operation;
    private nodoPila next;

    public nodoPila(String user, String date, String operation) {
        this.date = date;
        this.operation = operation;
        this.user = user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return this.user;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setNext(nodoPila next) {
        this.next = next;
    }

    public nodoPila getNext() {
        return this.next;
    }

}
