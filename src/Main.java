import Furnizori.Depozit;
import bonurifacturi.Facturi;
import com.sun.xml.internal.txw2.output.DataWriter;
import produs.Napolitane;
import produs.PachetBiscuiti;
import produs.Produs;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Produs> hash_set=new HashSet<Produs>();
        Set<Facturi> set_facturi=new HashSet<>();
        List<Depozit> listDepozite=new LinkedList<>();
        int n=0;
        Service service=new Service();
        service.citireFisierBiscuiti("Bisc.csv",hash_set);
        service.citireFisierNapolitane("napol.csv",hash_set);
        service.citireFisierFacturi("FACTURI.csv",set_facturi);
        service.citireFisierDepozite("DEPOZIT.csv",hash_set);
        Scanner reader =new Scanner(System.in);
        System.out.println("Aleget una dintre urmatoarele optiuni ");
        System.out.println("1.Adauga produs nou");
        System.out.println("2.Adauga un furnizor nou");
        System.out.println("3.Adauga un depozit nou ");
        System.out.println("4.Afiseaza produsele in stock ");
        System.out.println("5.Calculeaza factura unui produs anume ");
        System.out.println("6.Afisati toate facturile neplatie");
        System.out.println("7.Afisati toti furnizori unui produs  prioritar calitatii");
        System.out.println("8.Afisati cele mai apropiate depozite pentru un produs anume ");
        System.out.println("9.Afisati suma facturilor neplatie ");
        System.out.println("10.Afisati toate facturile platite cu cardul ");
        n=reader.nextInt();
        while (n!=0){
            switch (n) {
                case 1:
                { System.out.println("Ce tip de produs doriti sa fie?");
                    System.out.println("1.Napolitane ");
                    System.out.println("2.Biscuiti");
                    Scanner read=new Scanner(System.in);
                    int tp=read.nextInt();
                    switch (tp){
                    case 1:{

                        service.adaugaNapolitane(hash_set);
                       try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                           DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                           Date date=new Date();
                           x.append("adauga_napolitane ,"+dateFormat.format(date)+"\r\n");
                           x.flush();
                           x.close();
                        }
                       catch (Exception e) {
                           System.out.println("you have an error");
                       }
                       break;
                    }
                    case 2:{
                        service.adaugaBiscuiti(hash_set);
                        try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                            DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            Date date=new Date();
                            x.append("adauga_biscuiti ,"+dateFormat.format(date)+"\r\n");
                            x.flush();
                            x.close();
                        }
                        catch (Exception e) {
                            System.out.println("you have an error");
                        }
                        break;
                    }

                    }
                    break;
                }

                case 2:
                {
                   service.adaugaFurnizor(hash_set);

                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("adauga_furnizor, "+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                   break;
                }
                case 3:{
                    service.adaugaDepozit(hash_set);
                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("adauga_depozit ,"+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                    break;
                }
                case 4: {
                  service.afiseazaProduse(hash_set);
                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("afiseaza_produse ,"+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                  break;
                }
                case 5:{
                   service.calculeazaFactura(hash_set,set_facturi);
                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("calculeaza_facturi , "+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                   break;
                }
                case 6:{
                    service.afiseazaFacturiNepl(set_facturi);
                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("calculeaza_facturiNeplatite , "+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                    break;
                }
                case 7:
                {
                    service.afisezaFurnizorCal(hash_set);
                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("afiseaza_Furnizori ,"+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                   break;
                }
                case 8:
                {
                   service.afiseazaDepDist(hash_set);
                    try(FileWriter x=new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("afiseaza_depozite ,"+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e){
                        System.out.println("you have an error");
                    }
                   break;
                }
                case 9:{
                    service.afiseazaSumaFactNepl(set_facturi);

                    try(FileWriter x = new FileWriter("AUDIT.csv",true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("afiseaza_suma_facturi_neplatite ,"+dateFormat.format(date)+"\r\n");
                        x.flush();
                        x.close();
                    }
                    catch (Exception e) {
                        System.out.println("you have an error");
                    }
                    break;
                }
                case 10:{
                    service.afiseazaSumaFactCard(set_facturi);
                    File file =new File("AUDIT.csv");
                    file.createNewFile();
                    try(FileWriter x=new FileWriter(file,true)){
                        DateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date=new Date();
                        x.append("afiseaza_suma_facturi_card, "+dateFormat.format(date)+"\r\n"  );
                        x.flush();
                        x.close();
                    }
                    catch (Exception e) {
                        System.out.println("you have an error");
                    }
                   break;
                }
            }
            n=reader.nextInt();
        }
    // service.citireBaza();
    }
}

