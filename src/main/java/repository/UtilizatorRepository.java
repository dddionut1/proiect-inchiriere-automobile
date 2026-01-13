package repository;

import model.Utilizator;

import java.util.ArrayList;
import java.util.List;

public class UtilizatorRepository {

    //Instantiem o lista de tip utilizator numita ListaUtilizatori;
    private List<Utilizator> listaUtilizatori;

    //In constructor cream o lista si adaugam automat un utilizator si parola" by default";
    public UtilizatorRepository()
    {
        this.listaUtilizatori = new ArrayList<>();
        this.listaUtilizatori.add(new Utilizator("admin", "1234","ADMIN"));
    }

    //Metoda in care adaugam utilizatori in lista noastra;
    public void adaugaUtilizator(Utilizator utilizator) {
        this.listaUtilizatori.add(utilizator);
    }

    //Metoda verifica daca exista utilizator cu acelasi nume si parola ,daca nu se potriveste cu datele noastre ,returneaza null;
    public Utilizator gasesteUtilizator(String username, String parola) {
        for (Utilizator utilizator : this.listaUtilizatori) {
            if (utilizator.getUsername().equals(username) && utilizator.getParola().equals(parola)) {
                return utilizator;
            }
        }
        return null;
    }
}


