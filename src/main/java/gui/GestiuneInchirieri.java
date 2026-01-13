package gui;

import java.util.ArrayList;
import java.util.List;

public class GestiuneInchirieri {
    // Lista care ține evidența tuturor tranzacțiilor
    private List<String> istoricInchirieri;

    public GestiuneInchirieri() {
        this.istoricInchirieri = new ArrayList<>();
    }

    // Metoda care adaugă o închiriere în evidență
    public void inregistreazaInchiriere(String numeClient, Masina masina) {
        String detalii = "Client: " + numeClient +
                " | Auto: " + masina.getMarca() + " " + masina.getModel() +
                " | Culoare: " + masina.getCuloare() +
                " | Pret: " + masina.getPret() + " RON";
        istoricInchirieri.add(detalii);
        System.out.println("LOG GESTIUNE: " + detalii);
    }

    // Metoda pentru a vedea toată lista (pentru documentație/rapoarte)
    public List<String> getIstoric() {
        return istoricInchirieri;
    }
}