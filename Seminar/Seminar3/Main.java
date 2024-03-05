package seminar.seminar2.g1065;

import java.text.SimpleDateFormat;

public class Main {
    public static SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
    public static void main(String[] args) {
        try{
            Locatie locatie = new Locatie("Brasov","Strada x");
            MijlocFix mijlocFix = new MijlocFix("Autoturism Renault",
                    111L,
                    100000,
                    fmt.parse("01.01.2024"),
                    new Locatie("Brasov","Strada x"),
                    Categorie.MIJLOACE_TRANSPORT,10);
            System.out.println(mijlocFix);
            ObiectInventar obiectInventar= new ObiectInventar();
            obiectInventar.setLocatie(locatie);
            obiectInventar.setGestionar("Pop Adrian");
            obiectInventar.setNrInventar(100L);
            System.out.println(obiectInventar);
            MijlocFix mijlocFix2 = new MijlocFix(111L);
            //mijlocFix2.setDataAchizitie(fmt.parse("01.01.2025"));
            if (mijlocFix.equals(mijlocFix2)){
                System.out.println("Obiecte egale!\n");
            }
            else {
                System.out.println("Obiecte diferite!\n");
            }
            System.out.println(mijlocFix.compareTo(mijlocFix2));
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }
}
