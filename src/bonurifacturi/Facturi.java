package bonurifacturi;

public class Facturi {
    private Integer CostMarfa;
    private Integer CostTransport;
    private Integer CostTotal;
    private Integer CostDepozitare;
    private boolean TipPlata; // 0,1 card/cash
    protected boolean Platit;
    public Facturi()
    {
        this.CostDepozitare=0;
        this.CostMarfa=0;
        this.CostTransport=0;
        this.CostTotal=0;
        this.TipPlata=false;
        this.Platit=false;
    }
    public Facturi(Integer CostMarfa,Integer CostDepozitare,Integer CostTransport,Integer CostTotal,boolean tipPlata,boolean platit)
    {
        this.CostDepozitare=CostDepozitare;
        this.CostMarfa=CostMarfa;
        this.CostTransport=CostTransport;
        this.CostTotal=CostTotal;
        this.TipPlata=tipPlata;
        this.Platit=platit;
    }

    public boolean isPlatit() {
        return Platit;
    }

    public boolean isTipPlata() {
        return TipPlata;
    }

    public Integer getCostMarfa() {
        return CostMarfa;
    }

    public Integer getCostDepozitare() {
        return CostDepozitare;
    }

    public Integer getCostTotal() {
        return CostTotal;
    }

    public Integer getCostTransport() {
        return CostTransport;
    }

    public void setCostDepozitare(Integer costDepozitare) {
        CostDepozitare = costDepozitare;
    }

    public void setCostMarfa(Integer costMarfa) {
        CostMarfa = costMarfa;
    }

    public void setCostTotal(Integer costTotal) {
        CostTotal = costTotal;
    }

    public void setCostTransport(Integer costTransport) {
        CostTransport = costTransport;
    }

    public void setPlatit(boolean platit) {
        Platit = platit;
    }

    public void setTipPlata(boolean tipPlata) {
        TipPlata = tipPlata;
    }

    @Override
    public String toString() {
        return "Costul totatl al facturii este de "+CostTotal+" lei din care "+CostTransport+" lei pentru transport, "+CostDepozitare+" lei pentru depozitare , "+CostMarfa+ " pentru marfa ";
    }
}
