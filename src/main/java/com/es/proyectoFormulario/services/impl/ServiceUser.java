package com.es.proyectoFormulario.services.impl;

import com.es.proyectoFormulario.model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class ServiceUser {

    // ATRIBUTOS
    ArrayList<User> users; // Contiene todos los registros del fichero users.txt
    GestionFicheroUser gestion; // gestion es un objeto para poder llamar a los métodos de GestionFicheroUser
    LoggerService log;

    private String ruta = "resources/users/users.txt";


    public ServiceUser(){
        this.users = new ArrayList<>();
        this.gestion = new GestionFicheroUser();
        this.users = gestion.leerFichero("src/resources/archivosTema7/users/users.txt");
        this.log = new LoggerService();
    }
    /**
     * Método para comprobar si un usuario existe
     * @param idUser -> Nombre del usuario
     * @param password -> Contraseña del usuario
     * @return -> true si existe y false si no
     */

    public boolean checkUser(String idUser, String password) {



        // 1º manera de hacerlo
        /*
        for (int i=0; i<this.users.size(); i++) {
            User usuario = this.users.get(i); // usuario es el elemento de la posicion i de users
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getPass().equals(password)) {
                return true;
            }
        }
         */

        // 2º manera de hacerlo
        for (User usuario : this.users) {
            if (usuario.getName().equalsIgnoreCase(idUser) && usuario.getPass().equals(password)){
                return true;
            }
        }

        // 3º manera de hacerlo
        /*
        this.users.stream()
                .filter(usuario -> usuario.getId().equalsIgnoreCase(idUser) && usuario.getPass().equals(password))
                .findFirst()
                .isEmpty();
         */

        return false;

    }

    /**
     * Método para saber si un usuario existe
     * @param idUser -> nombre del usuario
     * @return -> true si existe y false si no existe
     */

    public boolean userExists(String idUser) {

        for (User usuario : this.users) {
            if (usuario.getName().equalsIgnoreCase(idUser)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para leer el fichero users.txt
     */
    public void leerFicheroUsers() {
        this.users=gestion.leerFichero(ruta);
    }

    /**
     * Metodo para añadir un fichero al fichero users.txt
     * @param u -> usuario que se va a añadir al fichero
     */

    public void anadirFicheroUsers(User u) {
        gestion.anadirFichero(ruta, u);
    }

    /**
     * Método para modificar el fichero users.txt
     */
    public void modificarFicheroUsers() {
        gestion.modificarFichero(this.users, ruta);
    }

}
