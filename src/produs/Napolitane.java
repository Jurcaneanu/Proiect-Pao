package produs;

public class Napolitane extends Produs {
    private String crema;
    private int diametru;
    private int greutate;
    public Napolitane(String crema,int diametru,int greutate){
        this.crema=crema;
        this.diametru=diametru;
        this.greutate=greutate;
   }

    public int getDiametru() {
        return diametru;
    }

    public int getGreutate() {
        return greutate;
    }

    public String getCrema() {
        return crema;
    }

    public void setCrema(String crema) {
        this.crema = crema;
    }

    public void setDiametru(int diametru) {
        this.diametru = diametru;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    @Override
    public String toString() {
        return super.getNume()+" cu pretul :"+super.getPret()+" depozit :"+super.getNumeDepozit()+"cantitate"+ super.getCantitate()+
                "\n"+"crema: "+crema +"diametru: "+"greutate : " +greutate;
    }
}
