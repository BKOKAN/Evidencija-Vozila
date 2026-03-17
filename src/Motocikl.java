public class Motocikl extends Vozilo{
    private String tipMotora;

    public Motocikl(String registracijskiBroj, int godinaProizvodnje, String marka, String tipMotora) {
        super(registracijskiBroj, godinaProizvodnje, marka);
        this.tipMotora = tipMotora;
    }

    public void setTipMotora(String tipMotora) {
        this.tipMotora = tipMotora;
    }

    public String getTipMotora() {
        return tipMotora;
    }

    @Override
    public void prikaziPodatke(){
        super.prikaziPodatke();
        System.out.println("Tip motora : " + tipMotora);
    }
}
