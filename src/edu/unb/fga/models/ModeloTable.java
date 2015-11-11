package edu.unb.fga.models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public final class ModeloTable extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private ArrayList linhas = null;
    private String[] colunas = null;
    private String[] colunasDetalhes;

    public ModeloTable(ArrayList linhas, String[] colunas) {
        setLinhas(linhas);
        setColunas(colunas);

    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] coluna) {
        this.colunas = coluna;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int numeroDaColuna) {
        return colunas[numeroDaColuna];
    }

    @Override
    public Object getValueAt(int numeroDaLinhas, int numeroDaColunas) {
        Object[] linha = (Object[]) getLinhas().get(numeroDaLinhas);
        return linha[numeroDaColunas];
    }
}
