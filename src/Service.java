import Furnizori.Depozit;
import bonurifacturi.Facturi;
import produs.Napolitane;
import produs.PachetBiscuiti;
import Furnizori.Furnizor;
import produs.Produs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;


public class Service {
   public void adaugaNapolitane(Set <Produs> hash_set)  {
       Scanner cread=new Scanner(System.in);
       System.out.println("Ce crema doriti sa fie ?");
       String crem=cread.next();
       System.out.println("Ce diametru doriti sa fie ?");
       int diam =cread.nextInt();
       System.out.println("Ce greutate doriti sa aiba ?");
       int greut=cread.nextInt();
       Produs produs =new Napolitane(crem,diam,greut);
       System.out.println("Ce cantitate doriti ");
       int can=cread.nextInt();
       produs.setCantitate(can);
       System.out.println("Care este denumirea produsului");
       String nume=cread.next();
       produs.setNume(nume);
       produs.setInStock(true);
       System.out.println("La ce pret doriti sa il vindeti?");
       int pret=cread.nextInt();
       produs.setPret(pret);
       hash_set.add(produs);
   }
   public boolean adaugaBiscuiti(Set <Produs> hash_set){
       Scanner cread= new Scanner(System.in);
       System.out.println("Ce forma este biscuitele ?");
       String forma=cread.nextLine();
       System.out.println("Care este numarul de biscuiti din pachet ?");
       int nrb=cread.nextInt();
       System.out.println("Ce tip de biscuti sunt ? ex :sarati dulci  ");
       String tip=cread.next();
       Produs produs=new PachetBiscuiti(forma,nrb,tip);
       System.out.println("Ce cantitate doriti ");
       int can=cread.nextInt();
       produs.setCantitate(can);
       System.out.println("Care este denumirea produsului");
       String nume=cread.next();
       produs.setNume(nume);
       produs.setInStock(true);
       System.out.println("In ce loc doriti sa il depozitati ");
       String numd=cread.next();
      // produs.setNumeDepozit(depozit);
       System.out.println("La ce pret doriti sa il vindeti?");
       int pret=cread.nextInt();
       produs.setPret(pret);
       hash_set.add(produs);
       return true;
   }
   public boolean adaugaFurnizor(Set <Produs> hash_set){
       Scanner cread = new Scanner(System.in);
       System.out.println("Numele este furnizorului este ?");
       String nume=cread.nextLine();
       System.out.println("Ce produs furnizeaza ?");
       String po=cread.nextLine();
       Produs sda  =new Produs();
       for (Iterator<Produs> iterator = hash_set.iterator(); iterator.hasNext(); ) {
           Produs pp = iterator.next();
           if(pp.getNume().equals(po)==true)
           {
               sda = pp;
           }
       }
       System.out.println("Ce calitate are produsul furnizat ?");
       int c=cread.nextInt();
       Furnizor f=new Furnizor(nume,c,sda);
       sda.addFurnizor(f);
       return true;
   }
   public boolean adaugaDepozit(Set <Produs> hash_set){
       Scanner cread=new Scanner(System.in);
       System.out.println("Care este distanta de la magazin la depozit?");
       int f=cread.nextInt();
       System.out.println("Care este numele depozitului? ");
       String num=cread.next();
       System.out.println("Care este numele produsui depozitat ?");
       String nump=cread.next();
       Depozit d=new Depozit(f,num,nump);
       Produs pp=new Produs();
       for (Iterator<Produs> iterator=hash_set.iterator();iterator.hasNext();) {
           pp = iterator.next();
           if (pp.getNumeDepozit().equals(nump) == true) {
               pp.addDepozit(d);
               break;
           }
       }
       return true;
   }
   public boolean afiseazaProduse(Set <Produs> hash_set){
       for (Iterator<Produs> iterator = hash_set.iterator(); iterator.hasNext(); ) {
           Produs pp = iterator.next();
           if(pp.isInStock()==true)
               System.out.println(pp.toString());
       }
       return true;
   }
   public boolean calculeazaFactura(Set <Produs> hash_set, Set <Facturi> set_facturi){
       System.out.println("Care este numele produsului ?");
       Scanner cread=new Scanner(System.in);
       String np=cread.next();
       Produs sda  =new Produs();
       for (Iterator<Produs> iterator = hash_set.iterator(); iterator.hasNext(); ) {
           Produs pp = iterator.next();
           if(pp.getNume().equals(np)==true)
           {
               sda=pp;
           }
       }
       System.out.println("Ce cantitate doriti sa cumparati ?");
       Integer cant=cread.nextInt();
       while(cant >sda.getCantitate()&&sda.isInStock()==false) {
           System.out.println("Cantitatea dorita nu este disponibila ");
           cant = cread.nextInt();
       }
       Facturi factura=new Facturi();
       List<Depozit> dep=sda.getNumeDepozit();
       double costTran= dep.get(0).getDistanta()*4.5;// pret combustibil
       factura.setCostTransport((int)costTran);
       factura.setCostMarfa(sda.getPret()*cant);
       factura.setCostDepozitare(sda.getCantitate()*3);// pret mentenanta produs
       factura.setCostTotal(factura.getCostDepozitare()+factura.getCostMarfa()+factura.getCostTransport());
       System.out.println("Cum doriti sa fie achitata plata ?(true/card,false/cash)");
       Boolean b=cread.nextBoolean();
       factura.setTipPlata(b);
       set_facturi.add(factura);
       System.out.println(factura);
       return true;
   }
   public boolean afiseazaFacturiNepl(Set<Facturi> set_facturi){
       for(Iterator<Facturi> iterator=set_facturi.iterator();iterator.hasNext();)
       {
           Facturi fact =new Facturi();
           fact = iterator.next();
           if(fact.isPlatit() == false)
           {
               System.out.println(fact);
           }
       }
       return true;
   }
   public boolean afisezaFurnizorCal(Set <Produs> hash_set){
       System.out.println("Care este numele produsului ?");
       Scanner cread=new Scanner(System.in);
       String np=cread.next();
       Produs sda  =new Produs();
       for (Iterator<Produs> iterator = hash_set.iterator(); iterator.hasNext(); ) {
           Produs pp = iterator.next();
           if(pp.getNume().equals(np)==true)
           {
               sda = pp;
           }
       }
       List <Furnizor> fur=sda.getNumeFurnizori();
       fur.sort(Comparator.comparing(Furnizor::getCalitate));
       for (Iterator<Furnizor> iterator=fur.iterator();iterator.hasNext();)
       {
           Furnizor qw=new Furnizor();
           qw=iterator.next();
           System.out.println(qw);
       }
       return true;
   }
   public boolean afiseazaDepDist(Set <Produs> hash_set){
       System.out.println("Care este numele produsului ?");
       Scanner cread=new Scanner(System.in);
       String np=cread.next();
       Produs sda  =new Produs();
       for (Iterator<Produs> iterator = hash_set.iterator(); iterator.hasNext(); ) {
           Produs pp = iterator.next();
           if(pp.getNume().equals(np)==true)
           {
               sda = pp;
           }
       }
       List <Depozit> fur=sda.getNumeDepozit();
       fur.sort(Comparator.comparing(Depozit::getDistanta));
       for(Iterator<Depozit> iterator=fur.iterator();iterator.hasNext();){
           Depozit dd=iterator.next();
           System.out.println(dd);
       }
       return true;
   }
   public boolean afiseazaSumaFactNepl(Set <Facturi> set_facturi){
       Integer s=0;
       for(Iterator <Facturi> iterator=set_facturi.iterator();iterator.hasNext();){
           Facturi facturi=iterator.next();
           if(facturi.isPlatit()==false){
               s+=facturi.getCostTotal();
           }
       }
       System.out.println("Suma facturilor neplatite este "+s);
       return true;
   }
   public boolean afiseazaSumaFactCard(Set <Facturi> set_facturi){
       Integer s=0;
       for(Iterator <Facturi> iterator=set_facturi.iterator();iterator.hasNext();){
           Facturi facturi=iterator.next();
           if(facturi.isTipPlata()==true){
               s+=facturi.getCostTotal();
           }
       }
       System.out.println("Suma facturilor platite cu cardul este "+s);
       return true;
   }
   public void citireFisierBiscuiti(String fileName,Set <Produs> hash_set){
       File file=new File(fileName);
       try {
           Scanner scanner=new Scanner(file);
           while(scanner.hasNext()){
               String s=scanner.nextLine();
               String [] PropBiscuiti=s.split(",");
               String forma=PropBiscuiti[0];
               Integer nrBiscuiti=parseInt(PropBiscuiti[1]);
               String tip=PropBiscuiti[2];
               Integer cantitate=parseInt(PropBiscuiti[3]);
               Integer pret = parseInt(PropBiscuiti[4]);
               String  nume = PropBiscuiti[5];
               Produs pachetBiscuiti=new PachetBiscuiti(forma,nrBiscuiti,tip);
               pachetBiscuiti.setCantitate(cantitate);
               pachetBiscuiti.setPret(pret);
               pachetBiscuiti.setNume(nume);
               pachetBiscuiti.setInStock(true);
               hash_set.add(pachetBiscuiti);
           }
           scanner.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
   }
    public void citireFisierNapolitane(String fileName,Set <Produs> hash_set) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s=scanner.nextLine();
                String [] PropNap =s.split(",");
                String crema=PropNap[0];
                Integer diametru = parseInt(PropNap[1]);
                Integer greutate = parseInt(PropNap[2]);
                Integer cantitate = parseInt(PropNap[3]);
                Integer pret = parseInt(PropNap[4]);
                String nume = PropNap[5];
                Produs napolitane = new Napolitane(crema,diametru,greutate);
                napolitane.setCantitate(cantitate);
                napolitane.setPret(pret);
                napolitane.setNume(nume);
                napolitane.setInStock(true);
                hash_set.add(napolitane);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void citireFisierFacturi(String fileName,Set <Facturi> set_facturi) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s=scanner.nextLine();
                String [] Facturi = s.split(",");
               Integer costtotal=parseInt(Facturi[0]);
               Integer costmarfa=parseInt(Facturi[1]);
               Integer costdepozitare=parseInt(Facturi[2]);
               Integer costtransport=parseInt(Facturi[3]);
               boolean tipplata=Boolean.parseBoolean(Facturi[4]) ;
               boolean platit=Boolean.parseBoolean(Facturi[5]);
               Facturi facturi=new Facturi(costmarfa,costdepozitare,costtransport,costtotal,tipplata,platit);
               set_facturi.add(facturi);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void citireFisierDepozite(String fileName,Set <Produs> hash_set) {
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String s=scanner.nextLine();
                String [] Depozit =s.split(",");
                Integer distanta=parseInt(Depozit[0]);
                String nume=Depozit[1];
                String numeProd=Depozit[2];
                Depozit depozit=new Depozit(distanta,nume,numeProd);
                for (Iterator <Produs> iterator=hash_set.iterator();iterator.hasNext();){
                    Produs p=iterator.next();
                    if(p.getNume().equals(numeProd))
                        p.setNumeDepozit(depozit);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void citireBaza(){


            try {
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/magazin/biscuiti/","jurca","l(o*gitech98");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from emp");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

