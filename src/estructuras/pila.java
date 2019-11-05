package estructuras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ventanas.reportWindow;

public class pila {

    private nodoPila inicio;
    private nodoPila fin;
    private int longitud = 0;

    public Boolean empty() {
        return this.inicio == null;
    }

    public void push(String user, String operation) {
        this.longitud++;
        
        Date datePull = new Date();
        DateFormat dateHour = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
        String date = dateHour.format(datePull);
        nodoPila nuevo = new nodoPila(user, date, operation);

        if (this.empty() == false) {
            nuevo.setNext(this.inicio);
            this.inicio = nuevo;
        } else {
            this.inicio = nuevo;
            this.fin = nuevo;
        }
    }

    public int size() {
        return this.longitud;
    }

    public void graficar() throws IOException {
        if (this.empty() == false) {
            String ruta = System.getProperty("user.home");
            ruta = ruta + "\\Desktop\\Reports";
            File carpeta = new File(ruta);

            if (!carpeta.exists()) {
                if (!carpeta.mkdirs()) {
                    JOptionPane.showMessageDialog(null, "Error al crear la carpeta de Reportes.", "Error con Carpeta.", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            String rutaImg = ruta + "\\Bitacora.dot";
            File archivo = new File(rutaImg);

            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try {
                try (PrintWriter write = new PrintWriter(rutaImg, "UTF-8")) {
                    write.println("digraph punteo {");
                    write.println("label=\"Bitácora\";");
                    write.println("graph [fontsize=25 fontname=\"Verdana\" compound=true];");
                    write.println("node [shape=record fontsize=25 fontname=\"Verdana\"];");
                    write.print("struct1 [label=\"{");

                    nodoPila aux = this.inicio;
                    int count = 0;

                    while (aux != null) {
                        if (count != 0) {
                            write.print("|");
                        }

                        write.print("<f");
                        write.print(count);
                        write.print("> ");
                        write.print(aux.getOperation());
                        write.println("\\n");
                        write.print(aux.getDate());
                        write.println("\\n");
                        write.print(aux.getUser());
                        write.println("\\n");

                        count++;
                        aux = aux.getNext();
                    }

                    write.print("}\"];}");
                }

            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
            }           
           
            String rutaPng = ruta + "\\Bitacora.png";
            crearImagen(rutaImg, rutaPng);      
            
            reportWindow showReport = new reportWindow();
            ImageIcon imageReport = new ImageIcon(rutaPng);
            showReport.lblVisor.setIcon(imageReport);            
            showReport.setVisible(true);
            showReport.repaint();
        }
    }
    
    public void crearImagen(String dirDot, String dirPng){
        try{
            ProcessBuilder pbuild = new ProcessBuilder("dot", "-Tpng", "-o", dirPng, dirDot);            
            pbuild.redirectErrorStream(true);
            pbuild.start();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora." + e, "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
