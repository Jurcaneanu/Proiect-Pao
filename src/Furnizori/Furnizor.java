package Furnizori;


import produs.Produs;

public class Furnizor {
    private String Nume;
    private int Calitate;

    public Furnizor (String Nume,int Calitate ,Produs P){
        this.Calitate=Calitate;
        this.Nume=Nume;
    }
    public Furnizor (){
        this.Calitate=0;
        this.Nume=" ";
    }

    public void setCalitate(int calitate) {
        Calitate = calitate;
    }

    public void setNumeFurnizor(String nume) {
        Nume = nume;
    }

    public String getNumeFurnizor() {
        return Nume;
    }

    public int getCalitate() {
        return Calitate;
    }

    @Override
    public String toString() {
        return getNumeFurnizor();
    }
}
