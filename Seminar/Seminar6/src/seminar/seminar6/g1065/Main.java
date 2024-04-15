package seminar.seminar6.g1065;

import seminar.seminar2.g1065.Locatie;
import seminar.seminar2.g1065.MijlocFix;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<MijlocFix> mijloaceFixe = seminar.seminar2.g1065.Main.citireDate("mf.csv");
        System.out.println("Lista mijloacelor fixe:");
//        for (MijlocFix mijlocFix:mijloaceFixe){
//            System.out.println(mijlocFix);
//        }

////        Afisare prin Consumer implementat
//        mijloaceFixe.forEach(new Consumer<MijlocFix>() {
//            @Override
//            public void accept(MijlocFix mijlocFix) {
//                System.out.println(mijlocFix);
//            }
//        });

////        Afisare prin transmitere cod consum - functie lambda
//        mijloaceFixe.forEach((mijlocFix -> System.out.println(mijlocFix)));

//        Afisare prin transmitere cod folosind referinta la functie
        mijloaceFixe.forEach(System.out::println);

        double vmin = 50000, vmax = 500000;
//        List<MijlocFix> cerinta1 = mijloaceFixe.stream().filter(new Predicate<MijlocFix>() {
//            @Override
//            public boolean test(MijlocFix mijlocFix) {
//                double valoare = mijlocFix.getValoare();
//                return valoare>=vmin && valoare<=vmax;
//            }
//        }).toList();
        List<MijlocFix> cerinta1 = mijloaceFixe.stream().
                filter(mijlocFix -> mijlocFix.getValoare() >= vmin && mijlocFix.getValoare() <= vmax).
                toList();
        System.out.println("Cerinta 1");
        cerinta1.forEach(System.out::println);

        String denumireLocatie = "Brasov";

        List<MijlocFix> cerinta2 = mijloaceFixe.stream().
                filter(mijlocFix -> mijlocFix.getLocatie().getDenumire().equals(denumireLocatie)).
                toList();
        System.out.println("Cerinta 2:");
        cerinta2.forEach(System.out::println);

        try {
            Date data = seminar.seminar2.g1065.Main.fmt.parse("01.01.2013");
            List<MijlocFix> cerinta3 = mijloaceFixe.stream().
                    filter(mijlocFix -> mijlocFix.getDataAchizitie().before(data)).
                    toList();
            System.out.println("Cerinta 3");
            cerinta3.forEach(System.out::println);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        List<MijlocFix> cerinta4 = mijloaceFixe.stream().
                sorted((mf1, mf2) -> Double.compare(mf1.uzura(), mf2.uzura())).
                toList();
        System.out.println("Cerinta 4:");
        cerinta4.forEach(mijlocFix -> System.out.println(mijlocFix + "\n" + mijlocFix.uzura()));

        Set<String> cerinta5 = mijloaceFixe.stream().
                map(mijlocFix -> mijlocFix.getLocatie().getDenumire()).
                collect(Collectors.toSet());
        System.out.println("Cerinta 5:");
        cerinta5.forEach(System.out::println);

        Map<Long, Locatie> cerinta6 = mijloaceFixe.stream().
                collect(
                        Collectors.toMap(
                                mijlocFix -> mijlocFix.getNrInventar(),
                                mijlocFix -> mijlocFix.getLocatie()));
        System.out.println("Cerinta 6:");
        cerinta6.keySet().forEach(vinv-> System.out.println(vinv+":"+cerinta6.get(vinv)));


    }
}
