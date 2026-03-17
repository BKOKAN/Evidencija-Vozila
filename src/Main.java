import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File datoteka = new File("vozila.txt");
        ArrayList<String> dataVozila = new ArrayList<>();
        EvidencijaVozila evidencija = new EvidencijaVozila();

        try {
            if (datoteka.exists()) {
                System.out.println("Datoteka postoji. Učitavanje podataka...");
                evidencija.ucitajPodatkeIzDatoteke(datoteka, dataVozila);
            } else {
                System.out.println("Datoteka ne postoji. Kreiranje nove datoteke...");
                datoteka.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Došlo je do pogreške prilikom rada s datotekom: " + e.getMessage());
            return;
        }

        Scanner unos = new Scanner(System.in);
        boolean unosAktivan = true;

        while (unosAktivan) {
            System.out.println("Odaberite opciju:");
            System.out.println("1 - Dodaj automobil");
            System.out.println("2 - Dodaj motocikl");
            System.out.println("3 - Prikaz svih vozila");
            System.out.println("4 - Izlaz");
            System.out.print("Vaš izbor: ");

            String izbor = unos.nextLine();

            switch (izbor) {
                case "1":
                    System.out.print("Registracijski broj: ");
                    String regAuto = unos.nextLine();
                    System.out.print("Godina proizvodnje: ");
                    int godAuto = Integer.parseInt(unos.nextLine());
                    System.out.print("Marka: ");
                    String markaAuto = unos.nextLine();
                    System.out.print("Broj vrata: ");
                    int brojVrata = Integer.parseInt(unos.nextLine());

                    try {
                        Automobil auto = new Automobil(regAuto, godAuto, markaAuto, brojVrata);
                        dataVozila.add("Automobil;"+regAuto+";"+godAuto+";"+markaAuto+";"+brojVrata);
                        evidencija.spremiPodatkeUDatoteku(datoteka, dataVozila);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Greška: " + e.getMessage());
                    }
                    break;

                case "2":
                    // Dodavanje motocikla
                    System.out.print("Registracijski broj: ");
                    String regMoto = unos.nextLine();
                    System.out.print("Godina proizvodnje: ");
                    int godMoto = Integer.parseInt(unos.nextLine());
                    System.out.print("Marka: ");
                    String markaMoto = unos.nextLine();
                    System.out.print("Tip motora: ");
                    String tipMotora = unos.nextLine();

                    Motocikl moto = new Motocikl(regMoto, godMoto, markaMoto, tipMotora);
                    dataVozila.add("Motocikl;"+regMoto+";"+godMoto+";"+markaMoto+";"+tipMotora);
                    evidencija.spremiPodatkeUDatoteku(datoteka, dataVozila);
                    break;

                case "3":
                    System.out.println("\nTrenutna vozila u evidenciji:");
                    for (String linija : dataVozila) {
                        String[] dijelovi = linija.split(";");
                        if (dijelovi[0].equals("Automobil")) {
                            Automobil automobil = new Automobil(dijelovi[1], Integer.parseInt(dijelovi[2]), dijelovi[3], Integer.parseInt(dijelovi[4]));
                            automobil.prikaziPodatke();
                        } else if (dijelovi[0].equals("Motocikl")) {
                            Motocikl motocikl = new Motocikl(dijelovi[1], Integer.parseInt(dijelovi[2]), dijelovi[3], dijelovi[4]);
                            motocikl.prikaziPodatke();
                        }
                        System.out.println("------");
                    }
                    break;

                case "4":
                    unosAktivan = false;
                    System.out.println("Izlaz iz programa.");
                    break;

                default:
                    System.out.println("Nepoznata opcija. Pokušajte ponovno.");
            }
        }

        unos.close();
    }
}