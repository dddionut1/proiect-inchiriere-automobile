package service;

import model.Utilizator;
import repository.UtilizatorRepository;

public class LoginService {

    private UtilizatorRepository utilizatorRepo;

    //Constructorul pentru initializarea repository ului;
    public LoginService() {
        this.utilizatorRepo = new UtilizatorRepository();
    }

    //Metoda apeleaza gasesteUtilizator si returneaza  daca datele introduse sunt corecte ;
    public Utilizator autentificare(String user, String pass) {
        return utilizatorRepo.gasesteUtilizator(user, pass);
    }
}