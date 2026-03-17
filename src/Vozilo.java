public class Vozilo {
    private String registracijskiBroj;
    private String marka;
    private int godinaProizvodnje;


    public Vozilo(String registracijskiBroj, int godinaProizvodnje, String marka){
        if( godinaProizvodnje <=0){
            throw new IllegalArgumentException("Godina proizvodnje mora biti pozitivan broj");
        }
            this.godinaProizvodnje = godinaProizvodnje;

        if(registracijskiBroj.isEmpty() || marka.isEmpty()){
            throw new IllegalArgumentException("Ovaj podatak je obavezan molim upisite primjeren podatak!");
        }
            this.registracijskiBroj = registracijskiBroj;
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
