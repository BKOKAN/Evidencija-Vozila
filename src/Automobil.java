public class Automobil extends Vozilo {
    private int brojVrata;

    public Automobil(String registracijskiBroj, String godinaProizvodnje, String marka,int brojVrata){
        super(registracijskiBroj,godinaProizvodnje,marka);
        if (brojVrata <= 0) {
            throw new IllegalArgumentException("Broj vrata mora biti pozitivan.");
        } else {
            this.brojVrata = brojVrata;
        }
    }

    public void setBrojVrata(int brojVrata) {
        this.brojVrata = brojVrata;
    }

    public int getBrojVrata() {
        return brojVrata;
    }

    @Override
    public void prikaziPodatke(){
        super.prikaziPodatke();
        System.out.println("Broj vrata: " + brojVrata);
    }

}
