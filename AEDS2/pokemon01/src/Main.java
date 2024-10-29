import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
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

        for (Pokemon p : listaSelecionados) System.out.println(p);

        scanner.close();
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
    private Date dataCaptura;

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
        this.dataCaptura = new Date();
    }

    public Pokemon(int id, int geracao, String nome, String descricao, ArrayList<String> tipos,
                   ArrayList<String> habilidades, double peso, double altura, int taxaCaptura,
                   boolean lendario, Date dataCaptura) {
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
        if (valores[5] != "0") {
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
        this.lendario = (valores[10].equals("1"));

        if (valores[11].isEmpty()) {
            this.dataCaptura = null;
        } else {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            this.dataCaptura = formatoData.parse(valores[11]);
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getGeracao() { return geracao; }
    public void setGeracao(int geracao) { this.geracao = geracao; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ArrayList<String> getTipos() { return tipos; }
    public void setTipos(ArrayList<String> tipos) { this.tipos = tipos; }

    public ArrayList<String> getHabilidades() { return habilidades; }
    public void setHabilidades(ArrayList<String> habilidades) { this.habilidades = habilidades; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public int getTaxaCaptura() { return taxaCaptura; }
    public void setTaxaCaptura(int taxaCaptura) { this.taxaCaptura = taxaCaptura; }

    public boolean getLendario() { return lendario; }
    public void setLendario(boolean lendario) { this.lendario = lendario; }

    public Date getDataCaptura() { return dataCaptura; }
    public void setDataCaptura(Date dataCaptura) { this.dataCaptura = dataCaptura; }

    public Pokemon clonar() {
        try {
            return (Pokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonagem não suportada.");
            return null;
        }
    }

    public String toString() {
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = (dataCaptura != null) ? formatoSaida.format(dataCaptura) : "Data não disponível";

        return "[#" + id + " -> " + nome + ": " + descricao +
                " - " + tipos + " - " + habilidades +
                " - " + peso + "kg - " + altura + "m - " +
                taxaCaptura + "% - " + lendario +
                " - " + geracao + " gen] - " + dataFormatada;
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
            while((linhaCsv = br.readLine()) != null) {
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
