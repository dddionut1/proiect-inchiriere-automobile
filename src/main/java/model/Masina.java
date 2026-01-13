package gui;

public class Masina {
    private String marca;
    private String model;
    private double pret;
    private String culoare;
    private String descriere;
    private String pozaPath;
    private boolean disponibila;

    //Constructorul cu toate caracteristicile masinii;
    public Masina(String marca, String model, double pret, String culoare, String descriere, String pozaPath, boolean disponibila) {
        this.marca = marca;
        this.model = model;
        this.pret = pret;
        this.culoare = culoare;
        this.descriere = descriere;
        this.pozaPath = pozaPath;
        this.disponibila = disponibila;
    }

    public String getMarca() {
        return marca;
    }
    public String getModel() {
        return model;
    }
    public double getPret() {
        return pret;
    }
    public String getCuloare() {
        return culoare;
    }
    public String getDescriere() {
        return descriere;
    }
    public String getPozaPath() {
        return pozaPath;
    }
    public boolean isDisponibila() {
        return disponibila;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setPret(double pret) {
        this.pret = pret;
    }
    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }
    public void setPozaPath(String pozaPath) {
        this.pozaPath = pozaPath;
    }
    public void setDisponibila(boolean disponibila) {
        this.disponibila = disponibila;
    }

}