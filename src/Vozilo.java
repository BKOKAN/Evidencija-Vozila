public class Vozilo {
    private String registracijskiBroj;
    private String marka;
    private int godinaProizvodnje;


    public Vozilo(String registracijskiBroj, int godinaProizvodnje, String marka){
        this.registracijskiBroj = registracijskiBroj;
        this.godinaProizvodnje = godinaProizvodnje;
        this.marka = marka;
    }

    public void prikaziPodatke(){
        System.out.println("Godina proizvodnje: " + godinaProizvodnje);
        System.out.println("Marka: " + marka);
        System.out.println("Registracijski broj: " + registracijskiBroj);
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public String getRegistracijskiBroj() {
        return registracijskiBroj;
    }

    public String getMarka() {
        return marka;
    }
}
