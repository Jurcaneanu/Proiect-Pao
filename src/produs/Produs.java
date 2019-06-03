package produs;
import Furnizori.Depozit;
import Furnizori.Furnizor;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import java.lang.*;
import java.util.LinkedList;
import java.util.List;

public class Produs {
    private int Cantitate;
    private List <Depozit> numeDepozit;
    private List <Furnizor> numeFurnizor;
    private boolean inStock;
    private int pret;
    private String Nume;

    public Produs(boolean inStock){
        this.inStock=inStock;
    }

    public Produs(){
        this.inStock=false;
        this.Cantitate=0;
        numeDepozit=new LinkedList<>();
        numeFurnizor=new LinkedList<>();
        this.pret=0;
        this.Nume=" ";
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public int getCantitate() {

        return Cantitate;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getPret() {
        return pret;
    }

    public List<Depozit> getNumeDepozit() {
        return numeDepozit;
    }

    public void addFurnizor(Furnizor Nume ){
        numeFurnizor.add(Nume);
    }
    public List <Furnizor> getNumeFurnizori(){
        return numeFurnizor;
    }
    public boolean isInStock() {
        return inStock;
    }
    public void addDepozit(Depozit Nume){numeDepozit.add(Nume);}
    public void setCantitate(int cantitate) {
        Cantitate = cantitate;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setNumeDepozit(Depozit nume) {
        numeDepozit.add(nume);
    }

    @Override
    public String toString() {
        return "";
    }
}

