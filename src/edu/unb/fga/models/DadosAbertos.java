package edu.unb.fga.models;

import edu.unb.fga.dadosabertos.Deputado;
import java.util.List;

public class DadosAbertos {

    private static List<Deputado> deputados;
    private static ModeloTable tabelaDeputados;
    private static ModeloTable tabelaPartidos;

    public DadosAbertos() {

    }

    public static ModeloTable getTabelaDeputados() {
        return tabelaDeputados;
    }

    public static void setTabelaDeputados(ModeloTable tabelaDeputados) {
        DadosAbertos.tabelaDeputados = tabelaDeputados;
    }

    public static ModeloTable getTabelaPartidos() {
        return tabelaPartidos;
    }

    public static void setTabelaPartidos(ModeloTable tabelaPartidos) {
        DadosAbertos.tabelaPartidos = tabelaPartidos;
    }

    public static List<Deputado> getDeputados() {
        return deputados;
    }

    public static void setDeputados(List<Deputado> deputados) {
        DadosAbertos.deputados = deputados;
    }
}
