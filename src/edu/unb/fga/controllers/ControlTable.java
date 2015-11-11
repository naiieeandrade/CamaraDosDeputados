package edu.unb.fga.controllers;

import edu.unb.fga.dadosabertos.Deputado;
import edu.unb.fga.dadosabertos.Detalhes;
import edu.unb.fga.dadosabertos.Partido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import edu.unb.fga.models.DadosAbertos;
import edu.unb.fga.models.ModeloTable;

public class ControlTable {

    public static void criarTabela(List<Deputado> deputados) {

        ArrayList linhasDeDadosDetalhes = new ArrayList();
        ArrayList linhasDeDadosPartidos = new ArrayList();
        String[] colunasDetalhes = new String[]{"Nome", "Partido", "Estado", "Email", "Telefone", "Condição",
            "Sexo", "ID de cadastro", "Matrícula", "Nome do Parlamentar",
            "Gabinete", "Anexo", "Link da Foto", "UF", "Legislatura",
            "Data de Nascimento", "Data de Falecimento", "Parâmetro de Legislatura"};
        String[] colunasPartidos = new String[]{"ID", "Sigla", "Nome"};

        for (Deputado deputado : deputados) {

            try {
                deputado.obterDetalhes();
                System.out.print("|");
            } catch (IOException | JAXBException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro na obtenção dos detalhes");
            }

            Detalhes detalhes = deputado.getDetalhes();

            linhasDeDadosDetalhes.add(new Object[]{deputado.getNome(), deputado.getPartido(),
                deputado.getUf(), deputado.getEmail(), deputado.getFone(),
                deputado.getCondicao(), deputado.getSexo(), deputado.getIdeCadastro(),
                deputado.getMatricula(), deputado.getNomeParlamentar(), deputado.getGabinete(),
                deputado.getAnexo(), deputado.getUrlFoto(), detalhes.getUfRepresentacaoAtual(),
                detalhes.getSituacaoNaLegislaturaAtual(), detalhes.getDataNascimento(),
                detalhes.getDataFalecimento(), detalhes.getNumLegislatura()});

            Partido partidos = detalhes.getPartido();

            linhasDeDadosPartidos.add(new Object[]{partidos.getIdPartido(),
                partidos.getSigla(),
                partidos.getNome()});
        }

        ModeloTable tabelaDetalhes = new ModeloTable(linhasDeDadosDetalhes, colunasDetalhes);
        DadosAbertos.setTabelaDeputados(tabelaDetalhes);
        ModeloTable tabelaPartidos = new ModeloTable(linhasDeDadosPartidos, colunasPartidos);
        DadosAbertos.setTabelaPartidos(tabelaPartidos);

    }

    public static ModeloTable filtrarPartidos() {
        ModeloTable tabela = DadosAbertos.getTabelaPartidos();
        ControleDeputadoPartido<Object[]> dados = new ControleDeputadoPartido<>();
        String[] colunas = new String[]{"ID", "Sigla", "Nome"};

        try {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                Object dado1 = tabela.getValueAt(i, 0);
                Object dado2 = tabela.getValueAt(i, 1);
                Object dado3 = tabela.getValueAt(i, 2);
                if (!dados.contains(new Object[]{dado1, dado2, dado3})) {

                    Object ID = tabela.getValueAt(i, 0);
                    Object sigla = tabela.getValueAt(i, 1);
                    Object nome = tabela.getValueAt(i, 2);

                    dados.add(new Object[]{ID, sigla, nome});
                }
            }
        } catch (Exception e) {
        }
        ModeloTable ModelTable = new ModeloTable(dados, colunas);
        return ModelTable;
    }
}
