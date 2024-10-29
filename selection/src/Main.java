import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String entradaString = "";
        int entradaInt = 0;

        String caminhoArquivo = "/tmp/pokemon.csv";
        List<Pokemon> listaPokemons = LeituraCsv.lerArquivoCompleto(caminhoArquivo);

        List<Pokemon> listaSelecionados = new ArrayList<>();

        while (!(entradaString = scanner.nextLine()).equals("FIM")) {
            entradaInt = Integer.parseInt(entradaString);
            listaSelecionados.add(BuscaPokemon.pesquisarPorId(listaPokemons, entradaInt));
        }

        selectionSort(listaSelecionados);

        for (Pokemon p : listaSelecionados) System.out.println(p);

        long tempoInicial = System.currentTimeMillis();
        int numeroComparacoes = listaSelecionados.size();
        int numeroMovimentacoes = 0;

        long tempoFinal = System.currentTimeMillis();
        long tempoExecucao = tempoFinal - tempoInicial;

        String matricula = "859385";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("matricula_selecao.txt"))) {
            writer.write(matricula + "\t" + tempoExecucao + "ms\t" + numeroComparacoes + "\t" + numeroMovimentacoes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }

    public static void selectionSort(List<Pokemon> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getNome().compareTo(lista.get(min_idx).getNome()) < 0) {
                    min_idx = j;
                }
            }
            Pokemon temp = lista.get(min_idx);
            lista.set(min_idx, lista.get(i));
            lista.set(i, temp);
        }
    }
}

class Pokemon {
    private int id;
    private int geracao;
    private String nome;
    private String descricao;
    private ArrayList<String> tipos;
    private ArrayList<String> habilidades;
    private double peso;
    private double altura;
    private int taxaCaptura;
    private boolean lendario;
    private java.util.Date dataCaptura;

    public Pokemon() {
        this.id = 0;
        this.geracao = 0;
        this.nome = "";
        this.descricao = "";
        this.tipos = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.peso = 0.0;
        this.altura = 0.0;
        this.taxaCaptura = 0;
        this.lendario = false;
        this.dataCaptura = new java.util.Date();
    }

    public Pokemon(int id, int geracao, String nome, String descricao, ArrayList<String> tipos,
                   ArrayList<String> habilidades, double peso, double altura, int taxaCaptura,
                   boolean lendario, java.util.Date dataCaptura) {
        this.id = id;
        this.geracao = geracao;
        this.nome = nome;
        this.descricao = descricao;
        this.tipos = tipos;
        this.habilidades = habilidades;
        this.peso = peso;
        this.altura = altura;
        this.taxaCaptura = taxaCaptura;
        this.lendario = lendario;
        this.dataCaptura = dataCaptura;
    }

    public Pokemon(String[] valores) throws Exception {
        for (int i = 0; i < valores.length; i++) if (valores[i].isEmpty()) valores[i] = "0";

        this.id = Integer.parseInt(valores[0]);
        this.geracao = Integer.parseInt(valores[1]);
        this.nome = valores[2];
        this.descricao = valores[3];

        this.tipos = new ArrayList<>();
        valores[4] = "'" + valores[4] + "'";
        this.tipos.add(valores[4]);
        if (!valores[5].equals("0")) {
            valores[5] = "'" + valores[5].trim() + "'";
            this.tipos.add(valores[5]);
        }

        valores[6] = valores[6].replace("\"", "");
        valores[6] = valores[6].replace("[", "");
        valores[6] = valores[6].replace("]", "");
        String[] habilidadesArray = valores[6].split(",");
        this.habilidades = new ArrayList<>();
        for (String h : habilidadesArray) habilidades.add(h.trim());

        this.peso = Double.parseDouble(valores[7]);
        this.altura = Double.parseDouble(valores[8]);
        this.taxaCaptura = Integer.parseInt(valores[9]);
        this.lendario = valores[10].equals("1");

        if (valores[11].isEmpty()) {
            this.dataCaptura = null;
        } else {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            this.dataCaptura = formatoData.parse(valores[11]);
        }
    }

    public int getId() { return id; }
    public int getGeracao() { return geracao; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public ArrayList<String> getTipos() { return tipos; }
    public ArrayList<String> getHabilidades() { return habilidades; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public int getTaxaCaptura() { return taxaCaptura; }
    public boolean getLendario() { return lendario; }
    public java.util.Date getDataCaptura() { return dataCaptura; }

    public String toString() {
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = (dataCaptura != null) ? formatoSaida.format(dataCaptura) : "Data não disponível";

        return String.format(
                "[#%d -> %s: %s - %s - %s - %.1fkg - %.1fm - %d%% - %b - %d gen] - %s",
                id, nome, descricao, tipos, habilidades, peso, altura, taxaCaptura, lendario, geracao, dataFormatada
        );
    }
}

class BuscaPokemon {
    public static Pokemon pesquisarPorId(List<Pokemon> pokemons, int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }
}

class LeituraCsv {
    public static List<Pokemon> lerArquivoCompleto(final String arquivo) {
        List<Pokemon> personagens = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            br.readLine();
            String linhaCsv = "";
            while ((linhaCsv = br.readLine()) != null) {
                linhaCsv = formatarLinha(linhaCsv);
                Pokemon personagem = new Pokemon(linhaCsv.split(";"));
                personagens.add(personagem);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            personagens = null;
        }
        return personagens;
    }

    private static String formatarLinha(String linha) {
        char[] arrayAux = linha.toCharArray();
        boolean dentroLista = false;
        for (int i = 0; i < arrayAux.length; i++) {
            if (!dentroLista && arrayAux[i] == ',') arrayAux[i] = ';';
            else if (arrayAux[i] == '"') dentroLista = !dentroLista;
        }
        return new String(arrayAux);
    }
}