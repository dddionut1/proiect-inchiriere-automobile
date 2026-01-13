# Proiect Închiriere Automobile (Java + JavaFX)

Aplicație desktop realizată în Java, cu interfață JavaFX și build management prin Maven. Proiectul simulează un sistem de închiriere auto: gestionarea mașinilor, a utilizatorilor și operații de tip închiriere / anulare, organizat pe straturi (model / repository / service / gui).

## Funcționalități
- Gestionare mașini (disponibilitate, preț etc.)
- Gestionare utilizatori
- Închiriere / anulare (conform logicii implementate în `service`)
- Interfață grafică JavaFX

## Structură
- `src/main/java/gui` – interfața (JavaFX)
- `src/main/java/model` – clasele de domeniu (`Masina`, `Utilizator`)
- `src/main/java/repository` – gestionare date (repository)
- `src/main/java/service` – logică (ex: `LoginService`, `MasinaService`)
- `pom.xml` – configurare Maven
- `module-info.java` – configurare module Java
- `imagini/` – resurse (imagini)

## Cerințe
- JDK 17+ (recomandat)
- Maven (folosit prin `pom.xml`)
- JavaFX (configurat prin dependențe / setări proiect)

## Rulare (IntelliJ)
1. Deschide proiectul în IntelliJ ca proiect Maven (din `pom.xml`).
2. Setează JDK-ul: **File → Project Structure → Project SDK** (JDK 17+).
3. Rulează clasa principală:
    - `src/main/java/gui/PornireAplicatie.java`

## Note
- Proiectul include `.gitignore` pentru a exclude fișiere generate (`target/`, `out/`, `.idea/`, `*.iml`).
