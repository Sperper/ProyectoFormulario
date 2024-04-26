package com.es.proyectoFormulario.services.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GestionFicheroLogger {

    /**
     * Metodo para añadir un registro al fichero log
     * @param ruta -> Ruta donde se encuentra el fichero
     * @param mensaje -> Mensaje que va a añadir
     */
    public void anadirFichero (String ruta, String mensaje) {

        // Aqui se escribe en el fichero
        File fichLog = new File(ruta);

        if (fichLog.exists() && fichLog.isFile() && fichLog.canWrite()) { // If que comprueba si el fichero existe, es un archivo y si se puede escribir
            try { // Try-catch para capturar la excepción IOException
                FileWriter fw = new FileWriter(fichLog, true);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write(mensaje);

                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
