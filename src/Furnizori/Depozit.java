package Furnizori;

public class Depozit {
    private int Distanta;
    private String Nume;
    private String ProdusDep;
    public Depozit(int distanta,String nume,String produsDep)
    {
        this.ProdusDep=produsDep;
        this.Nume=nume;
        this.Distanta=distanta;
    }
    public Depozit(){
        Distanta=0;
        Nume=" ";
        ProdusDep=" ";
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getNume() {
        return Nume;
    }

    public int getDistanta() {
        return Distanta;
    }

    public String getProdusDep() {
        return ProdusDep;
    }

    public void setDistanta(int distanta) {
        Distanta = distanta;
    }

    public void setProdusDep(String produsDep) {
        ProdusDep = produsDep;
    }

    @Override
    public String toString() {
        return "Numele depozitului este "+Nume+" cu produsul depozitat "+ProdusDep+" la o distanta de " +Distanta;
    }
}
