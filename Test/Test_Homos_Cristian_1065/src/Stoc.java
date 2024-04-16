import java.io.Serializable;
import java.util.Objects;

public class Stoc implements Comparable<Stoc> {

    protected int cod;
    protected  String denumire;
    protected int codDep;
    protected double cantitate;
    protected double valoare;
    protected String unitateDeMasura;

    public Stoc() {
    }

    public Stoc(int cod, String denumire, int codDep, double cantitate, double valoare, String unitateDeMasura) {
        this.cod = cod;
        this.denumire = denumire;
        this.codDep = codDep;
        this.cantitate = cantitate;
        this.valoare = valoare;
        this.unitateDeMasura = unitateDeMasura;

    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getCodDep() {
        return codDep;
    }

    public void setCodDep(int codDep) {
        this.codDep = codDep;
    }

    public double getCantitate() {
        return cantitate;
    }

    public void setCantitate(double cantitate) {
        this.cantitate = cantitate;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public String getUnitateDeMasura() {
        return unitateDeMasura;
    }

    public void setUnitateDeMasura(String unitateDeMasura) {
        this.unitateDeMasura = unitateDeMasura;
    }

    @Override
    public String toString() {
        return "Stocuri{" +
                "cod=" + cod +
                ", denumire='" + denumire + '\'' +
                ", codDep=" + codDep +
                ", cantitate=" + cantitate +
                ", valoare=" + valoare +
                ", unitateDeMasura='" + unitateDeMasura + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stoc stoc = (Stoc) o;
        return cod == stoc.cod && codDep == stoc.codDep && Double.compare(cantitate, stoc.cantitate) == 0 && Double.compare(valoare, stoc.valoare) == 0 && Objects.equals(denumire, stoc.denumire) && Objects.equals(unitateDeMasura, stoc.unitateDeMasura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, denumire, codDep, cantitate, valoare, unitateDeMasura);
    }

    @Override
    public int compareTo(Stoc s) {
        if(this.getValoare()== s.getValoare()) {
            return 1;
        }
        else{
            return -1;
        }
    }
}
