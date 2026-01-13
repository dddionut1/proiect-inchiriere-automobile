package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;

//Aceasta este o aplicatie JavaFX;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Obiectul care tine minte toate inchirierile pe parcursul programului;
        GestiuneInchirieri gestiune = new GestiuneInchirieri();

        Button btn = new Button("Autentificare");
        Label userLabel = new Label("Nume Utilizator:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Introduceți utilizatorul");
        usernameField.setMaxWidth(200);

        Label passLabel = new Label("Parolă:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Introduceți parola");
        passwordField.setMaxWidth(200);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(userLabel, usernameField, passLabel, passwordField, btn);

        btn.setOnAction(event -> {
            String password = passwordField.getText();
            if (password.equals("2026")) {
                arataListaMasini(primaryStage, usernameField.getText(), gestiune);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Eroare Autentificare");
                alert.setContentText("Parola este incorectă!");
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Sistem Închirieri Auto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void arataListaMasini(Stage stage, String nume, GestiuneInchirieri gestiune) {
        Label titlu = new Label("Sistem Gestiune - Bine ai venit, " + nume.toUpperCase() + "!");
        titlu.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2c3e50; -fx-padding: 10;");

        TableView<Masina> tabel = new TableView<>();

        // Folosim un tablou cu un singur element pentru a modifica suma totala din interiorul butoanelor;
        final double[] totalPlata = {0.0};

        Label labelTotal = new Label("Total de plată: 0.00 RON");
        labelTotal.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #e67e22;");

        //  STILIZARE TABEL
        tabel.getStylesheets().add("data:text/css," +
                ".table-row-cell { -fx-cell-size: 90px; }" +
                ".table-cell { -fx-alignment: CENTER; }"
        );

        // 1. Coloana Imagine
        TableColumn<Masina, String> colPoza = new TableColumn<>("Imagine");
        colPoza.setMinWidth(120);
        colPoza.setCellValueFactory(new PropertyValueFactory<>("pozaPath"));
        colPoza.setCellFactory(param -> new TableCell<>() {
            private final javafx.scene.image.ImageView view = new javafx.scene.image.ImageView();
            @Override
            protected void updateItem(String path, boolean empty) {
                super.updateItem(path, empty);
                if (empty || path == null) {
                    setGraphic(null);
                } else {
                    try {
                        javafx.scene.image.Image img = new javafx.scene.image.Image(new java.io.File(path).toURI().toString());
                        view.setImage(img);
                        view.setFitHeight(80); // Mărit de la 50 la 80
                        view.setPreserveRatio(true);
                        setGraphic(view);
                    } catch (Exception e) {
                        setGraphic(null);
                    }
                }
            }
        });

        // 2. Coloane Date de bază
        TableColumn<Masina, String> colMarca = new TableColumn<>("Marcă");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        TableColumn<Masina, String> colModel = new TableColumn<>("Model");
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Masina, Double> colPret = new TableColumn<>("Preț/Zi");
        colPret.setCellValueFactory(new PropertyValueFactory<>("pret"));
        colPret.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(Double pret, boolean empty) {
                super.updateItem(pret, empty);
                if (empty || pret == null) setText(null);
                else setText(String.format("%.2f RON", pret));
            }
        });

        // 3. Coloane (Culoare, Descriere)
        TableColumn<Masina, String> colCuloare = new TableColumn<>("Culoare");
        colCuloare.setCellValueFactory(new PropertyValueFactory<>("culoare"));

        TableColumn<Masina, String> colDescriere = new TableColumn<>("Descriere");
        colDescriere.setMinWidth(200);
        colDescriere.setCellValueFactory(new PropertyValueFactory<>("descriere"));

        // 4. Coloana Status
        TableColumn<Masina, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setStyle("");
                } else {
                    Masina m = getTableView().getItems().get(getIndex());
                    if (m.isDisponibila()) {
                        setText("LIBER");
                        setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    } else {
                        setText("OCUPAT");
                        setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    }
                }
            }
        });

        tabel.getColumns().addAll(colPoza, colMarca, colModel, colCuloare, colPret, colDescriere, colStatus);

        ObservableList<Masina> date = FXCollections.observableArrayList(
                new Masina("Dacia", "Logan", 150.0, "Gri", "Economică și fiabilă.", "imagini/logan.jpg", true),
                new Masina("BMW", "X5", 450.0, "Negru", "SUV Premium, tractiune integrala.", "imagini/bmw.jpg", true),
                new Masina("Audi", "A4", 300.0, "Albastru", "Eleganță germană.", "imagini/audi.jpg", true),
                new Masina("Bentley", "Continental GT", 1300.0, "Verde", "Lux suprem, putere V12.", "imagini/bentley.jpg", true),
                new Masina("Ferrari", "Roma", 1800.0, "Roșu", "Supercar italian.", "imagini/ferrari.jpg", true),
                new Masina("Opel", "Insignia", 348.0, "Maro", "Mașină spațioasă.", "imagini/opel.jpg", true),
                new Masina("Ford", "Puma", 515.0, "Galben", "SUV compact, modern.", "imagini/ford.jpg", true),
                new Masina("Mercedes", "S-Class", 900.0, "Negru", "Standardul de aur.", "imagini/mercedes.jpg", true),
                new Masina("Tesla", "Model 3", 770.0, "Alb", "Electrică, autopilot.", "imagini/tesla.jpg", true),
                new Masina("Volkswagen", "Golf 8", 445.0, "Albastru", "Manevrabilitate de top.", "imagini/golf.jpg", true)
        );
        tabel.setItems(date);

        // BUTOANE
        Button btnInchiriere = new Button("Închiriază Mașina");
        btnInchiriere.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 15;");

        Button btnAnuleaza = new Button("Anulează Rezervarea");
        btnAnuleaza.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 15;");

        Button btnIstoric = new Button("Vezi Evidență");
        btnIstoric.setStyle("-fx-background-color: #7f8c8d; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 15;");

        Button btnInfo = new Button("Termeni și Oferte");
        btnInfo.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 15;");

        Button btnLogout = new Button("Deconectare");
        btnLogout.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 15;");

        btnInchiriere.setOnAction(e -> {
            Masina selectata = tabel.getSelectionModel().getSelectedItem();

            if (selectata == null) {
                new Alert(Alert.AlertType.WARNING, nume + ", te rugăm să selectezi o mașină din tabel!").show();
            } else if (selectata.isDisponibila()) {
                // 1. Modifica statusul mașinii
                selectata.setDisponibila(false);

                // 2. Actualizeaza suma totală
                totalPlata[0] += selectata.getPret();
                labelTotal.setText(String.format("Total de plată: %.2f RON", totalPlata[0]));

                // 3. Înregistrare în gestiune (Istoric)
                gestiune.inregistreazaInchiriere(nume.toUpperCase(), selectata);

                // 4. Reimprospatare tabel (se face ROȘU)
                tabel.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succes");
                alert.setHeaderText("Rezervare confirmata!");
                alert.setContentText("Mașina " + selectata.getMarca() + " a fost rezervată de " + nume + ".\n" +
                        "Suma adaugata: " + selectata.getPret() + " RON");
                alert.show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Ne pare rău, " + nume + ", mașina este deja OCUPATĂ!").show();
            }
        });

        btnAnuleaza.setOnAction(e -> {
            Masina selectata = tabel.getSelectionModel().getSelectedItem();

            if (selectata == null) {
                new Alert(Alert.AlertType.WARNING, nume + ", alege mașina pentru care vrei să anulezi rezervarea!").show();
            } else if (!selectata.isDisponibila()) {
                // 1. Facem mașina liberă din nou
                selectata.setDisponibila(true);

                // 2. Scădem prețul din totalul de plată
                totalPlata[0] -= selectata.getPret();
                if (totalPlata[0] < 0) totalPlata[0] = 0; // Siguranță să nu avem sume negative
                labelTotal.setText(String.format("Total de plată: %.2f RON", totalPlata[0]));

                // 3. Notăm anularea în istoric pentru evidență
                gestiune.getIstoric().add("[ANULARE] " + nume.toUpperCase() + " a eliberat " + selectata.getMarca());

                // 4. Reîmprospătare tabel (se face VERDE)
                tabel.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Anulare");
                alert.setHeaderText("Rezervare eliminată!");
                alert.setContentText("Mașina " + selectata.getMarca() + " este din nou LIBERĂ, " + nume + ".");
                alert.show();
            } else {
                // Cazul în care mașina e deja liberă (Verde)
                new Alert(Alert.AlertType.WARNING, "Hei " + nume + ", această mașină este deja disponibilă!").show();
            }
        });
        btnIstoric.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("ISTORIC ÎNCHIRIERI:\n\n");
            if (gestiune.getIstoric().isEmpty()) sb.append("Nicio închiriere momentan.");
            else for (String t : gestiune.getIstoric()) sb.append(t).append("\n");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Gestiune Închirieri");
            alert.setHeaderText("Evidența tranzacțiilor");
            alert.setContentText(sb.toString());
            alert.getDialogPane().setMinWidth(500);
            alert.showAndWait();
        });
        btnInfo.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informații Sistem");
            alert.setHeaderText("Termeni, Reguli și Promoții");
            alert.setContentText(
                    "REGULI GENERALE:\n" +
                            "• Vârsta minimă: 21 ani.\n" +
                            "• Permis de conducere valid (minim 1 an).\n\n" +
                            "OFERTE SPECIALE:\n" +
                            "1. Reducere 10% pentru închirieri de peste 7 zile!\n" +
                            "2. Weekend Special: 15% reducere la orice model SUV.\n" +
                            "3. Client Fidel: A 5-a închiriere este GRATUITĂ (o zi)!"
            );
            alert.getDialogPane().setMinWidth(450); // Lărgim fereastra să nu taie textul
            alert.showAndWait();
        });

        btnLogout.setOnAction(e -> {
            Alert confirmare = new Alert(Alert.AlertType.CONFIRMATION);
            confirmare.setTitle("Deconectare");
            confirmare.setHeaderText(null);
            confirmare.setContentText(nume + ", ești sigur că vrei să părăsești aplicația?");

            confirmare.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    start(stage); // Te trimite la login doar dacă apeși OK
                }
            });
        });

        HBox butoane = new HBox(15, btnInchiriere, btnAnuleaza, btnIstoric, btnInfo, btnLogout);
        butoane.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, titlu, tabel,labelTotal, butoane);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #d7e1ec);");

        Scene scene = new Scene(layout, 1100, 750);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}