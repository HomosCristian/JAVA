package seminar.seminar2.g1065;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MijlocFix extends ElementPatrimonial implements Cloneable {
    private Categorie categorie;
    private int durataNormata;

    private int unCamp;

    private static final long serialVersionUID=1L;

    public MijlocFix() {
    }

    public MijlocFix(long nrInventar) {
        super(nrInventar);
    }

    public MijlocFix(String denumire, long nrInventar, double valoare, Date dataAchizitie,
                     Locatie locatie, Categorie categorie, int durataNormata) throws Exception {
        super(denumire, nrInventar, valoare, dataAchizitie, locatie);
        if (durataNormata < 0 || durataNormata > 100) {
            throw new Exception("Durata normata invalida!");
        }
        this.categorie = categorie;
        this.durataNormata = durataNormata;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getDurataNormata() {
        return durataNormata;
    }

    public void setDurataNormata(int durataNormata) throws Exception {
        if (durataNormata < 0 || durataNormata > 100) {
            throw new Exception("Durata normata invalida!");
        }
        this.durataNormata = durataNormata;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MijlocFix clona_superficiala = (MijlocFix) super.clone();
        clona_superficiala.setDataAchizitie((Date) dataAchizitie.clone());
        clona_superficiala.setLocatie((Locatie) locatie.clone());
        return clona_superficiala;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                " " + categorie +
                "," + durataNormata +
                "}";
    }

    @Override
    public double uzura() {
        Date dataCurenta = new Date();
        long diferentaMilis = dataCurenta.getTime() - dataAchizitie.getTime();
        long nrMilisZi = 24 * 60 * 60 * 1000;
        long diferentaZile = diferentaMilis / nrMilisZi;
        return ((double) diferentaZile) / (durataNormata * 365);
    }
}
