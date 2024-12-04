import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String isoCode; // Código ISO 3166-1
    private String name; // Nome do país
    private long population; // População do país
    private double area; // Dimensão em km²
    private List<Pais> borderingCountries; // Lista de países limítrofes

    // Construtor
    public Pais(String isoCode, String name, double area) {
        this.isoCode = isoCode;
        this.name = name;
        this.area = area;
        this.borderingCountries = new ArrayList<>();
    }

    // Getters e Setters
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Pais> getBorderingCountries() {
        return borderingCountries;
    }

    // Adiciona um país à lista de limítrofes
    public void addBorderingCountry(Pais country) {
        if (borderingCountries.size() < 40 && !borderingCountries.contains(country)) {
            borderingCountries.add(country);
        }
    }

    // Verifica se dois países são iguais (mesmo código ISO)
    public boolean equals(Pais other) {
        return this.isoCode.equals(other.getIsoCode());
    }

    // Verifica se outro país é limítrofe
    public boolean isNeighbor(Pais other) {
        return borderingCountries.contains(other);
    }

    // Retorna a densidade populacional
    public double getPopulationDensity() {
        return (double) population / area;
    }

    // Retorna a lista de vizinhos comuns entre dois países
    public List<Pais> getCommonNeighbors(Pais other) {
        List<Pais> commonNeighbors = new ArrayList<>();
        for (Pais neighbor : borderingCountries) {
            if (other.getBorderingCountries().contains(neighbor)) {
                commonNeighbors.add(neighbor);
            }
        }
        return commonNeighbors;
    }
}
