package estructuras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

    public void push(String user, String operation, String date) {
        this.longitud++;

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
                JOptionPane.showMessageDialog(null, "Error al crear el reporte de bitácora.", "Error con la bitácora.", JOptionPane.ERROR_MESSAGE);
            }
            
            String cmd = "comando.cmd";
            
            File comando = new File(cmd);
            if (!comando.exists()) {
                comando.createNewFile();
            }
            try (PrintWriter write = new PrintWriter(cmd, "UTF-8")) {
                write.println("param([switch]$Elevated) function Test-Admin { $currentUser = New-Object Security.Principal.WindowsPrincipal $([Security.Principal.WindowsIdentity]::GetCurrent()) $currentUser.IsInRole([Security.Principal.WindowsBuiltinRole]::Administrator) } if ((Test-Admin) -eq $false) { if ($elevated) { # tried to elevate, did not work, aborting } else { Start-Process powershell.exe -Verb RunAs -ArgumentList ('-noprofile -noexit -file \"{0}\" -elevated' -f ($myinvocation.MyCommand.Definition)) } exit } 'running with full privileges'");
                write.println("cd " + ruta);
                write.println("dot -Tpng Bitacora.dot -o Bitacora.png");
            }            

            try {                                
                Runtime.getRuntime().exec(cmd);                
            } catch (IOException e) {
                System.out.println (e);
            }

            ruta = ruta + "\\Bitacora.png";
            reportWindow showReport = new reportWindow();
            ImageIcon imageReport = new ImageIcon(ruta);
            showReport.lblVisor.setIcon(imageReport);
            showReport.setVisible(true);
        }
    }
}
