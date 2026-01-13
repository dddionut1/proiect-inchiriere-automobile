# Proiect Închiriere Automobile (Java + JavaFX)
RULARE ROMANA;

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
4. Dacă IntelliJ îți cere, apasă “Load Maven Changes” ca să descarce dependențele.
5. Dacă apar erori JavaFX, verifică JDK 17+ și reimportă Maven (Reload All Maven Projects).
   

## Note
- Proiectul include `.gitignore` pentru a exclude fișiere generate (`target/`, `out/`, `.idea/`, `*.iml`).

RUN ENGLISH;
## Run (IntelliJ)
1. Open the project in IntelliJ as a Maven project (from `pom.xml`).
2. Set the Project SDK to JDK 17+:
    - File → Project Structure → Project SDK
3. Run the main class:
    - `src/main/java/gui/PornireAplicatie.java`
4. If prompted, click “Load Maven Changes” to download dependencies.
5. If JavaFX errors appear, reload Maven (Reload All Maven Projects) and re-check the JDK.
