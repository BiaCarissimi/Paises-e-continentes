public class Main {
    public static void main(String[] args) throws java.io.UnsupportedEncodingException {
        
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        // Criando os países
        Pais brazil = new Pais("BRA", "Brazil", 8515767.049);
        Pais argentina = new Pais("ARG", "Argentina", 2780400);
        Pais uruguay = new Pais("URU", "Uruguay", 176215);

        // Definindo as populações
        brazil.setPopulation(213993437);
        argentina.setPopulation(45376763);
        uruguay.setPopulation(3473730);

        // Adicionando países limítrofes
        brazil.addBorderingCountry(argentina);
        brazil.addBorderingCountry(uruguay);

        argentina.addBorderingCountry(brazil);
        argentina.addBorderingCountry(uruguay);

        uruguay.addBorderingCountry(brazil);
        uruguay.addBorderingCountry(argentina);

        // Criando o continente e adicionando os países
        Continente southAmerica = new Continente("South America");
        southAmerica.addCountry(brazil);
        southAmerica.addCountry(argentina);
        southAmerica.addCountry(uruguay);

        // Exibindo informações sobre o Brasil
        System.out.println("País: " + brazil.getName());
        System.out.println("População: " + brazil.getPopulation());
        System.out.println("Dimensão: " + brazil.getArea() + " km²");
        System.out.println("Densidade populacional: " + brazil.getPopulationDensity());
        System.out.println("Fronteiras:");
        for (Pais neighbor : brazil.getBorderingCountries()) {
            System.out.println("- " + neighbor.getName());
        }

        // Outras informações do continente
        System.out.println("\nDimensão total da América do Sul: " + southAmerica.getTotalArea());
        System.out.println("População total da América do Sul: " + southAmerica.getTotalPopulation());
        System.out.println("País com maior população: " + southAmerica.getCountryWithHighestPopulation().getName());
        System.out.println("Razão territorial (maior/menor): " + southAmerica.getAreaRatio());
    }
}
