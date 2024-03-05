package seminar.seminar2.g1065;
public class Locatie {
    private String denumire,adresa;

    public Locatie(){}

    public Locatie(String denumire, String adresa) {
        this.denumire = denumire;
        this.adresa = adresa;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "{" + denumire + ", " + adresa + "}";
    }



}

