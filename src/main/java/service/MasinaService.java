package service;

import repository.MasinaRepository;
import model.Masina;
import java.util.List;

    public class MasinaService {

    //Cream o variabila de tip masina repository numita Repository;
    private MasinaRepository repository ;

    //Constructorul de instantiere al repository ului ;
    public MasinaService() {
        this.repository = new MasinaRepository();
    }

    //Returneaza toata lista de masini;
    public List <Masina> getToateMasiniDinService() {
        return repository.getToateMasinile();
    }

    //Adaug o masina cu toate caracteristicile in masinaRepository
    public void adaugaMasinaDinService(Masina m) {

        repository.adaugaMasina(m);
    }


}
