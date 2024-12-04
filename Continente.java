import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String name; // Nome do continente
    private List<Pais> countries; // Lista de países no continente

    // Construtor
    public Continente(String name) {
        this.name = name;
        this.countries = new ArrayList<>();
    }

    // Adiciona um país ao continente
    public void addCountry(Pais country) {
        countries.add(country);
    }

    // Retorna a dimensão total do continente
    public double getTotalArea() {
        return countries.stream().mapToDouble(Pais::getArea).sum();
    }

    // Retorna a população total do continente
    public long getTotalPopulation() {
        return countries.stream().mapToLong(Pais::getPopulation).sum();
    }

    // Retorna a densidade populacional do continente
    public double getPopulationDensity() {
        double totalArea = getTotalArea();
        return totalArea == 0 ? 0 : (double) getTotalPopulation() / totalArea;
    }

    // Retorna o país com maior população
    public Pais getCountryWithHighestPopulation() {
        return countries.stream().max((a, b) -> Long.compare(a.getPopulation(), b.getPopulation())).orElse(null);
    }

    // Retorna o país com menor população
    public Pais getCountryWithLowestPopulation() {
        return countries.stream().min((a, b) -> Long.compare(a.getPopulation(), b.getPopulation())).orElse(null);
    }

    // Retorna o país com maior dimensão territorial
    public Pais getCountryWithLargestArea() {
        return countries.stream().max((a, b) -> Double.compare(a.getArea(), b.getArea())).orElse(null);
    }

    // Retorna o país com menor dimensão territorial
    public Pais getCountryWithSmallestArea() {
        return countries.stream().min((a, b) -> Double.compare(a.getArea(), b.getArea())).orElse(null);
    }

    // Retorna a razão territorial do maior país em relação ao menor país
    public double getAreaRatio() {
        Pais largest = getCountryWithLargestArea();
        Pais smallest = getCountryWithSmallestArea();
        if (largest != null && smallest != null && smallest.getArea() > 0) {
            return largest.getArea() / smallest.getArea();
        }
        return 0;
    }
}
