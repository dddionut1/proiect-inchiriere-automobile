package model;

public class Utilizator {
    private String username;
    private String parola;
    private String rol;

    //Constructor pentru a instantia toate atributele utilizatorului
    public Utilizator(String username, String parola, String rol) {
        this.username = username;
        this.parola = parola;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getParola() {
        return parola;
    }

    public String getRol() {
        return rol;
    }
}
