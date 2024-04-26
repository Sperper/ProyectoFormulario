package com.es.proyectoFormulario.services.impl;

import com.es.proyectoFormulario.model.User;

import java.io.*;
import java.util.ArrayList;

public class GestionFicheroUser {

    /**
     * Método que lee el fichero users.txt, crea un usuario con esa información
     * y además lo añade a un ArrayList de usuarios.
     * @param ruta -> Ruta en la que se encuentra el fichero
     * @return ArrayList de User
     */
    public ArrayList<User> leerFichero(String ruta){
        ArrayList<User> arrUser = new ArrayList<>();

        File fich = new File(ruta);

        if (fich.exists() && fich.isFile() && fich.canRead()) {
            // Abrimos los flujos
            try {
                FileReader fr = new FileReader(fich);
                BufferedReader br = new BufferedReader(fr);

                // Operamos los con los ficheros
                String linea = br.readLine();
                while (linea != null) {
                    String id_user = "";
                    String isAdmin = "";
                    String name_user = "";
                    String pass_user = "";

                    // Array de string para almaenar los Strings guardados
                    String[] valores = linea.split(":");

                    id_user = valores[0];
                    name_user = valores[1];
                    pass_user = valores[2];
                    isAdmin = valores[3];

                    boolean isAdmin_b = Boolean.parseBoolean(isAdmin);

                    User u = new User(id_user, name_user, pass_user, isAdmin_b);

                    arrUser.add(u);


                    linea = br.readLine();

                }

                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error");
            }

        }

        return arrUser;
    }


    /**
     * Método para modificar el fichero users.txt
     * @param user -> ArrayList de usuarios
     * @param ruta -> Ruta en la que se ecuentra el fichero users.txt
     */
    public void modificarFichero (ArrayList<User> user, String ruta) {

        // Abrimos el fichero
        File fichero = new File(ruta);

        // If para comprobar si es un fichero, si existe y si se puede escribir
        if (fichero.isFile() && fichero.exists() && fichero.canWrite()) {
            try {
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw);

                // Se opera con el fichero despues de abrir los flujos
                for (int i=0; i<user.size(); i++) {
                    bw.write(user.get(i).getId()+":"+user.get(i).getName()+":"
                            +user.get(i).getPass()+":"+user.get(i).isAdmin());
                }


                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Método para añadir registros al fichero users.txt
     * @param ruta -> Ruta en la que se encuentra el fichero
     * @param u -> User que tiene que añadir
     */
    public void anadirFichero(String ruta, User u){
        // Inicializa el objeto File
        File fichero = new File(ruta);

        // If que comprueba si es un archivo, si existe y si se puede escribir
        if (fichero.isFile() && fichero.exists() && fichero.canWrite()) {
            // try-catch para capturar la IOException
            try {
                FileWriter fw = new FileWriter(fichero, true);
                BufferedWriter bw = new BufferedWriter(fw);

                // Se opera con el fichero despues de abrir los flujos

                bw.write(u.getId()+":"+u.getName()+":"
                        +u.getPass()+":"+u.isAdmin()+"\n");


                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
