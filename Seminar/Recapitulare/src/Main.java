import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Element e1 = new Element(1,1,2);
        Element e2 = new Element(1,1,2);
        Element e3 = new Element(3,4,2.2);
        Element e4 = new Element(3,4,2);
        List<Element> elementeEemplu = new ArrayList<>();
        elementeEemplu.add(e1);
        elementeEemplu.add(e2);
        elementeEemplu.add(e3);

        //Exemplu toString()
        System.out.println(e1.toString());

        //Exemplus equals
        if(e2.equals(e1)){
            System.out.println("Elemente egale!");
        }
        else{
            System.out.println("Elemente diferite!");
        }

        //Exemplu compareTo()
        System.out.println(e1.compareTo(e2));

        //Exemplu citire matrice
        List<Element> elemente = citireDate("matricerara.csv");

        //Numarul de elemente negative
        int i = 0;
        for(Element e:elemente){
            if(e.getValoareElement()<0){
                i++;
            }
        }
        System.out.println("Numarul de elemente negative din matrice:" +i);

        //Implementare collector: afiseaza media pe coloanele matricei
        Map<Integer,Double> medieColoane = elemente.stream().collect(Collectors.groupingBy(
                element -> element.getIndexColoana(),
                Collectors.averagingDouble(Element::getValoareElement))
        );
        medieColoane.keySet().forEach(col-> System.out.println(col + ":" + medieColoane.get(col)));

        //Exemplu scriere in .csv
        try{
            salvareCSV(elemente, "erge.csv");
        } catch (IOException e){
            throw new RuntimeException(e);
        }


        //Exemplu serializare
        serializare(elementeEemplu, "elemente.dat");

        //Exemplu deserializare
        List<Element> elemente2= new ArrayList<>();
        elemente2 = deserializare("elemente.dat");
        for(Element e:elemente2){
            System.out.println(e);
        }
    }

    //Citire matrice
    public static List<Element> citireDate(String numeFisier) throws FileNotFoundException{
        List<Element> elemente = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader(numeFisier));
            String linie;
            try{
                while((linie = in.readLine()) !=null){
                    Element element = new Element();
                        String[] tokens = linie.split(",");
                        element.setIndexLinie(Integer.parseInt(tokens[0]));
                        element.setIndexColoana(Integer.parseInt(tokens[1]));
                        element.setValoareElement(Double.parseDouble(tokens[2]));
                    elemente.add(element);
                }
            } catch (FileNotFoundException e){
                throw new RuntimeException(e);
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        } catch (Exception ex){
            System.err.println(ex);
        }
        return elemente;
    }

    //Scriere in fisier .csv
    public static void salvareCSV(List<Element> elemente, String numeFisier) throws IOException{
        FileWriter writer = new FileWriter(numeFisier);

        Collections.sort(elemente, Element::compareTo);
        Collections.reverse(elemente);

        for(Element e:elemente){
            StringBuilder line = new StringBuilder();
            line.append(e.getIndexLinie());
            line.append(",");
            line.append(e.getIndexColoana());
            line.append(",");
            line.append(e.getValoareElement());
            line.append("\n");
            writer.write(line.toString());
        }
    }

    //Serializare
    public static void serializare(List<Element> elemente, String numeFisier){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(numeFisier))){
            for(Element e:elemente){
                out.writeObject(e);
            }
        } catch (Exception ex){
            System.err.println(ex);
        }
    }

    //Deserializare

    public static List<Element> deserializare(String numeFisier){
        List<Element> elemente = new ArrayList<>();
        try(FileInputStream in1 = new FileInputStream(numeFisier); ObjectInputStream in = new ObjectInputStream(in1)){
            while (in1.available()!=0){
                elemente.add((Element)in.readObject());
            }
        } catch (Exception ex){
            System.err.println(ex);
        }
        return elemente;
    }

}
