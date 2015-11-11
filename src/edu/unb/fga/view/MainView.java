package edu.unb.fga.view;

import edu.unb.fga.controllers.ControlTable;
import edu.unb.fga.dadosabertos.Camara;
import edu.unb.fga.dadosabertos.Deputado;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;
import javax.xml.bind.JAXBException;
import edu.unb.fga.models.DadosAbertos;
import edu.unb.fga.models.ModeloTable;
import edu.unb.fga.models.DeputadoModel;

public class MainView extends javax.swing.JFrame {

    private final DeputadoModel modelo = new DeputadoModel();
    private TableRowSorter<ModeloTable> sorter;
    private final ModeloTable tabelas = DadosAbertos.getTabelaDeputados();
    List<Deputado> deputados;

    public MainView() {
        initComponents();
        new Thread() {
            @Override
            public void run() {
                Camara camara = new Camara();
                try {
                    camara.obterDados();
                } catch (JAXBException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na obtenção dos dados!\nErro:" + ex.getMessage());
                }
                deputados = camara.getDeputados();

                DadosAbertos.setDeputados(deputados);

                ControlTable controle = new ControlTable();
                controle.criarTabela(deputados);
            }
        }.start();
        tabela(tabelas);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabela = new javax.swing.JTable();
        jButtonPesquisa = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(40, 101, 223));

        jTableTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTabela);

        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons 1/magnifier.png"))); // NOI18N
        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons 1/report_user.png"))); // NOI18N
        jButton1.setText("Partidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons 1/add.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisa)
                        .addGap(0, 237, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisa)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed

    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        String texto = jTextFieldPesquisa.getName().toUpperCase();
        if (texto.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(javax.swing.RowFilter.regexFilter(texto));
        }
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    public void tabela(ModeloTable tab) {

        jTableTabela.setModel(tab);
        jTableTabela.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTableTabela.getColumnModel().getColumn(0).setResizable(false);
        jTableTabela.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTableTabela.getColumnModel().getColumn(1).setResizable(false);
        jTableTabela.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTableTabela.getColumnModel().getColumn(2).setResizable(false);
        jTableTabela.getColumnModel().getColumn(3).setPreferredWidth(230);
        jTableTabela.getColumnModel().getColumn(3).setResizable(false);
        jTableTabela.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableTabela.getColumnModel().getColumn(4).setResizable(false);
        jTableTabela.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableTabela.getColumnModel().getColumn(5).setResizable(false);

        jTableTabela.getTableHeader().setReorderingAllowed(false);
        jTableTabela.setAutoResizeMode(jTableTabela.AUTO_RESIZE_OFF);
        jTableTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        sorter = new TableRowSorter<ModeloTable>(tab);
        jTableTabela.setRowSorter(sorter);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabela;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}
