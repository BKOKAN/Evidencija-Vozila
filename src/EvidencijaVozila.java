import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class EvidencijaVozila {

    public void ucitajPodatkeIzDatoteke(File datoteka, ArrayList<String> dataVozila) {

        try (Scanner scanner = new Scanner(datoteka)) {
            while (scanner.hasNextLine()) {
                dataVozila.add(scanner.nextLine());
            }

            if (dataVozila.isEmpty()) {
                System.out.println("Datoteka je prazna!");
            } else {
                System.out.println("Učitani podaci:");
                for (String linija : dataVozila) {
                    System.out.println(linija);
                }
            }
        } catch (FileNotFoundException error) {
            System.out.println("Datoteka nije pronađena!");
        }
    }
    public void spremiPodatkeUDatoteku(File datoteka, ArrayList<String> dataVozila) {
        try (FileWriter writer = new FileWriter(datoteka)) {
            for (String linija : dataVozila) {
                writer.write(linija + System.lineSeparator());
            }
            System.out.println("Podaci su uspješno spremljeni u datoteku.");
        } catch (IOException e) {
            System.out.println("Došlo je do pogreške prilikom spremanja podataka: " + e.getMessage());
        }
    }
}