package com.es.proyectoFormulario.model;

public class User {

    private String id;
    private String name;
    private String pass;
    private boolean isAdmin;
    /**
     *
     * @param id -> Id del usuario
     * @param name -> Nombre del usuario
     * @param pass -> Contraseña del usuario
     * @param isAdmin -> Boolean que es true si es admin o false si no lo es
     */
    public User(String id, String name, String pass, boolean isAdmin) {
        setAdmin(isAdmin);
        setPass(pass);
        setId(id);
        setName(name);
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean admin) {
            isAdmin = admin;
        }


}
