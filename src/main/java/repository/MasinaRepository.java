package repository;

import model.Masina;
import java.util.ArrayList;
import java.util.List;

public class MasinaRepository {

    //Colectie care stocheaza obiecte de tip masina
    private List<Masina> listaMasini;

    //Constructorul pentru a instantia lista de masini
    public MasinaRepository() {
        this.listaMasini = new ArrayList<>();
    }

    //Metoda primeste un obiect de tip masina si l adauga in lista
    public void adaugaMasina(Masina masina) {
       this.listaMasini.add(masina);
    }

    // Metoda care returnează toate mașinile din "garaj"
    public List<Masina> getToateMasinile() {
        return this.listaMasini;

    }




}
