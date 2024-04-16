import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Subiectul 3
       Stoc s1 = new Stoc(1, "abc", 11, 111, 100, "$");
       Stoc s2 = new Stoc(1, "abc", 11, 111, 100, "$");
       Stoc s3 = new Stoc(2, "bcd", 22, 222, 200, "$");

        List<Stoc> stocuriExemplu = new ArrayList<>();
        stocuriExemplu.add(s1);
        stocuriExemplu.add(s2);
        stocuriExemplu.add(s3);

        //Exemplu toString
        System.out.println(s1.toString());

        //Exemplu equals
        if(s2.equals(s1)){
            System.out.println("Stocuri egale!");
        }
        else{
            System.out.println("Storcuri diferite!");
        }

        //Exemplus compare
        System.out.println(s1.compareTo(s2));

        //Exemplus citire matrice
        List<Stoc> stocuri = citireDate("stocuri.csv");

        //Afisare valoare/cantitate

        for (Stoc s:stocuriExemplu){
            System.out.println(s.getValoare()/s.getCantitate());
        }

        Map<Integer,Long> map = stocuriExemplu.stream().collect(Collectors.groupingBy(
                stoc -> stoc.getCodDep(),
                Collectors.counting()
        ));
        //afisarea propriu-zisa a map-ului
        map.keySet().forEach(st-> System.out.println(st + ":" + map.get(st)));

        try{
            salvare(stocuriExemplu, "erge.csv");
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    public static List<Stoc> citireDate(String numeFisier) {
        List<Stoc> stocuri = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader(numeFisier));
            String linie;
            try{
                while((linie = in.readLine()) !=null){
                    Stoc stoc = new Stoc();
                    String[] tokens = linie.split(",");
                    stoc.setCod(Integer.parseInt(tokens[0]));
                    stoc.setDenumire(String.valueOf(tokens[1]));
                    stoc.setCodDep(Integer.parseInt(tokens[2]));
                    stoc.setCantitate(Double.parseDouble(tokens[3]));
                    stoc.setValoare(Double.parseDouble(tokens[4]));
                    stoc.setUnitateDeMasura(String.valueOf(tokens[5]));
                    stocuri.add(stoc);
                }
            } catch (FileNotFoundException e){
                throw new RuntimeException(e);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        } catch (Exception ex){
            System.err.println(ex);
        }
        return stocuri;
    }

    public static void salvare(List<Stoc> stocuri, String numeFisier) throws IOException{
        FileWriter writer = new FileWriter(numeFisier);

        Collections.sort(stocuri, Stoc::compareTo);
        Collections.reverse(stocuri);

        for(Stoc s:stocuri){
            StringBuilder line = new StringBuilder();
            line.append(s.getCod());
            line.append(",");
            line.append(s.getDenumire());
            line.append(",");
            line.append(s.getCodDep());
            line.append(s.getCantitate());
            line.append(",");
            line.append(s.getValoare());
            line.append(",");
            line.append(s.getUnitateDeMasura());
            line.append("\n");
            writer.write(line.toString());
        }
    }


}