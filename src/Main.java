import java.util.List;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // Lista de cidades
        List<Cidade> cidades = Arrays.asList(
                new Cidade("GO", "Anápolis", false),
                new Cidade("GO", "Goiânia", true),
                new Cidade("SP", "Ribeirão Preto", false),
                new Cidade("SP", "Campinas", false),
                new Cidade("MG", "Belo Horizonte", true),
                new Cidade("MG", "Uberlândia", false),
                new Cidade("MG", "Montes Claros", false),
                new Cidade("MG", "Unaí", false),
                new Cidade("TO", "Palmas", true),
                new Cidade("TO", "Araguarí", false),
                new Cidade("MT", "Cuiabá", true),
                new Cidade("MS", "Dourados", false),
                new Cidade("MS", "Campo Grande", true),
                new Cidade("MS", "Corumbá", false),
                new Cidade("MT", "Barra do Garças", false),
                new Cidade("MT", "Araguaiana", false),
                new Cidade("RO", "Porto Velho", true),
                new Cidade("RO", "Costa Marques", false)
        );

        // Estrutura 1: Agrupar cidades por UF e imprimir em ordem alfabética
        System.out.println("=== Agrupamento por UF (Ordem Alfabética das Cidades) ===");
        Map<String, Set<Cidade>> cidadesPorUF = new TreeMap<>();
        for (Cidade cidade : cidades) {
            cidadesPorUF.computeIfAbsent(cidade.getUf(), k -> new TreeSet<>(Comparator.comparing(Cidade::getNome)))
                    .add(cidade);
        }
        cidadesPorUF.forEach((uf, listaCidades) -> {
            System.out.println(uf + ":");
            listaCidades.forEach(c -> System.out.println("  " + c.getNome()));
        });

        // Estrutura 2: Imprimir capitais primeiro e depois cidades em ordem alfabética
        System.out.println("\n=== Capitais Primeiro (Ordem Alfabética) ===");
        cidades.stream()
                .sorted(Comparator.comparing(Cidade::Capital).reversed()
                        .thenComparing(Cidade::getNome))
                .forEach(System.out::println);

        // Estrutura 3: Conjunto de cidades e ordem alfabética decrescente
        System.out.println("\n=== Cidades em Ordem Alfabética Decrescente ===");
        Set<Cidade> conjuntoCidades = new TreeSet<>(Comparator.comparing(Cidade::getNome).reversed());
        conjuntoCidades.addAll(cidades);
        conjuntoCidades.forEach(System.out::println);
    }
}