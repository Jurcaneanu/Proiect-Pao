package produs;

public class PachetBiscuiti extends Produs {
    private String forma;
    private int nrBiscuiti;
    private String tip;

    public PachetBiscuiti(String forma,int nrBiscuiti,String tip){
        this.tip=tip;
        this.forma=forma;
        this.nrBiscuiti=nrBiscuiti;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setDenumire(String tip) {
        this.tip = tip;
    }

    public void setNrBiscuiti(int nrBiscuiti) {
        this.nrBiscuiti = nrBiscuiti;
    }

    public int getNrBiscuiti() {
        return nrBiscuiti;
    }

    public String getDenumire() {
        return tip;
    }

    public String getForma() {
        return forma;
    }

    @Override
    public String toString() {
        return super.getNume()+" cu pretul : "+super.getPret()+" depozit : "+super.getNumeDepozit()+" cantitate "+ super.getCantitate()+
                "\n" +"forma : "+forma+" nrBiscuiti : "+nrBiscuiti+ " tip : "+tip;
    }
}
