/*
 * probPathFinderJFrame.java
 *
 * Created on 5 de agosto de 2005, 12:07
 */
package IA.PathFinderDemo;

import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.AStarSearch;
import aima.search.informed.IterativeDeepeningAStarSearch;
import aima.search.uninformed.DepthLimitedSearch;
import aima.search.uninformed.IterativeDeepeningSearch;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 *
 * @author  javier
 */
public class ProbPathFinderDemoJFrame extends javax.swing.JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static int DIFICULTAD = 5;
    private ProbPathFinderBoard p;
    private int alg = 1;
    private int heur = 1;
    private int nc = 8;
    private int dif = DIFICULTAD;

    /** Creates new form probPathFinderJFrame */
    public ProbPathFinderDemoJFrame() {
        initComponents();

        p = new ProbPathFinderBoard(nc, dif, drawPanel1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        drawPanel1 = new Laberinto();
        instrum = new javax.swing.JTextArea();
        reiniciar = new javax.swing.JButton();
        ejecutar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        camino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tiempo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mixed = new javax.swing.JRadioButton();
        cityblock = new javax.swing.JRadioButton();
        euclidean = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        IDAStar = new javax.swing.JRadioButton();
        AStar = new javax.swing.JRadioButton();
        DF = new javax.swing.JRadioButton();
        ID = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        dificultad = new javax.swing.JComboBox();
        dificultad.addItem("Facil");
        dificultad.addItem("Dificil");
        dificultad.addItem("Muy Dificil");
        dificultad.setSelectedIndex(0);
        jLabel5 = new javax.swing.JLabel();
        sizes = new javax.swing.JComboBox();
        sizes.addItem("5x5");
        sizes.addItem("6x6");
        sizes.addItem("7x7");
        sizes.addItem("8x8");
        sizes.addItem("9x9");
        sizes.addItem("10x10");
        sizes.addItem("11x11");
        sizes.addItem("12x12");
        sizes.setSelectedIndex(3);
        size = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        tipoA = new javax.swing.JMenuItem();
        tipoB = new javax.swing.JMenuItem();
        tipoC = new javax.swing.JMenuItem();
        tipoD = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PathFinder");

        drawPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawPanel1MousePressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout drawPanel1Layout = new org.jdesktop.layout.GroupLayout(drawPanel1);
        drawPanel1.setLayout(drawPanel1Layout);
        drawPanel1Layout.setHorizontalGroup(
            drawPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 402, Short.MAX_VALUE)
        );
        drawPanel1Layout.setVerticalGroup(
            drawPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 406, Short.MAX_VALUE)
        );

        instrum.setColumns(10);
        instrum.setEditable(false);
        instrum.setLineWrap(true);
        instrum.setRows(10);
        instrum.setPreferredSize(new java.awt.Dimension(180, 150));

        reiniciar.setText("Actualizar parametros");
        reiniciar.setToolTipText("Reiniciar el mapa");
        reiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reiniciarMousePressed(evt);
            }
        });

        ejecutar.setText("Ejecutar");
        ejecutar.setToolTipText("Ejecutar el algoritmo seleccionado");
        ejecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ejecutarMousePressed(evt);
            }
        });

        limpiar.setText("Limpiar");
        limpiar.setToolTipText("Borrar el camino encontrado");
        limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                limpiarMousePressed(evt);
            }
        });
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        camino.setColumns(35);
        camino.setEditable(false);

        jLabel2.setText("Camino: ");

        tiempo.setColumns(10);
        tiempo.setEditable(false);

        jLabel1.setText("Tiempo: ");

        buttonGroup2.add(mixed);
        mixed.setText("City Block + bl");
        mixed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mixedActionPerformed(evt);
            }
        });

        buttonGroup2.add(cityblock);
        cityblock.setText("City Block");
        cityblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityblockActionPerformed(evt);
            }
        });

        buttonGroup2.add(euclidean);
        euclidean.setSelected(true);
        euclidean.setText("Euclidean");
        euclidean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                euclideanActionPerformed(evt);
            }
        });

        jLabel3.setText("Heuristicas: ");

        buttonGroup1.add(IDAStar);
        IDAStar.setText("IDA*");
        IDAStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDAStarActionPerformed(evt);
            }
        });

        buttonGroup1.add(AStar);
        AStar.setText("A*");
        AStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AStarActionPerformed(evt);
            }
        });

        buttonGroup1.add(DF);
        DF.setSelected(true);
        DF.setText("Deph First");
        DF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DFActionPerformed(evt);
            }
        });

        buttonGroup1.add(ID);
        ID.setText("ID");
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        jLabel4.setText("Algoritmo: ");

        dificultad.setPreferredSize(new java.awt.Dimension(180, 24));
        dificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dificultadActionPerformed(evt);
            }
        });

        jLabel5.setText("Dificultad: ");

        sizes.setToolTipText("Tama�o del mapa");
        sizes.setPreferredSize(new java.awt.Dimension(70, 24));
        sizes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizesActionPerformed(evt);
            }
        });

        size.setText("Tama�o: ");

        jMenu1.setText("Menu");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Salir);

        jMenuBar2.add(jMenu1);

        jMenu2.setText("Problemas");

        tipoA.setText("Tipo A");
        tipoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAActionPerformed(evt);
            }
        });
        jMenu2.add(tipoA);

        tipoB.setText("Tipo B");
        tipoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBActionPerformed(evt);
            }
        });
        jMenu2.add(tipoB);

        tipoC.setText("Tipo C");
        tipoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoCActionPerformed(evt);
            }
        });
        jMenu2.add(tipoC);

        tipoD.setText("Tipo D");
        tipoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDActionPerformed(evt);
            }
        });
        jMenu2.add(tipoD);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(drawPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createSequentialGroup()
                                    .add(119, 119, 119)
                                    .add(reiniciar)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(ejecutar)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(limpiar)))
                            .add(layout.createSequentialGroup()
                                .add(size)
                                .add(5, 5, 5)
                                .add(sizes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5)
                                .add(jLabel5)
                                .add(5, 5, 5)
                                .add(dificultad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(12, 12, 12)
                        .add(instrum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jLabel1)
                        .add(tiempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(camino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(113, 113, 113)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel3)
                                .add(euclidean)
                                .add(cityblock)
                                .add(mixed))
                            .add(layout.createSequentialGroup()
                                .add(34, 34, 34)
                                .add(jLabel4)
                                .add(DF)
                                .add(ID)
                                .add(AStar)
                                .add(IDAStar)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(3, 3, 3)
                                .add(size))
                            .add(sizes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(3, 3, 3)
                                .add(jLabel5))
                            .add(dificultad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(drawPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(28, 28, 28))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(instrum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 368, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(56, 56, 56)))
                .add(74, 74, 74)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(4, 4, 4)
                        .add(jLabel1))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(tiempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel2)
                        .add(camino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(reiniciar)
                    .add(ejecutar)
                    .add(limpiar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(477, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(jLabel4))
                    .add(DF)
                    .add(ID)
                    .add(AStar)
                    .add(IDAStar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(jLabel3))
                    .add(euclidean)
                    .add(cityblock)
                    .add(mixed))
                .add(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDActionPerformed
// TODO add your handling code here:
        p = new ProbPathFinderBoard(nc, new String("D"), drawPanel1);
    }//GEN-LAST:event_tipoDActionPerformed

    private void tipoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoCActionPerformed
// TODO add your handling code here:
        p = new ProbPathFinderBoard(nc, new String("C"), drawPanel1);
    }//GEN-LAST:event_tipoCActionPerformed

    private void tipoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBActionPerformed
// TODO add your handling code here:
        p = new ProbPathFinderBoard(nc, new String("B"), drawPanel1);
    }//GEN-LAST:event_tipoBActionPerformed

    private void tipoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAActionPerformed
// TODO add your handling code here:
        p = new ProbPathFinderBoard(nc, new String("A"), drawPanel1);
    }//GEN-LAST:event_tipoAActionPerformed

    private void dificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dificultadActionPerformed
// TODO add your handling code here:
        dif = DIFICULTAD - dificultad.getSelectedIndex();
    }//GEN-LAST:event_dificultadActionPerformed

    private void mixedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mixedActionPerformed
// TODO add your handling code here:
        heur = 3;
    }//GEN-LAST:event_mixedActionPerformed

    private void euclideanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_euclideanActionPerformed
// TODO add your handling code here:
        heur = 1;
    }//GEN-LAST:event_euclideanActionPerformed

    private void cityblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityblockActionPerformed
// TODO add your handling code here:
        heur = 2;
    }//GEN-LAST:event_cityblockActionPerformed

    private void IDAStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDAStarActionPerformed
// TODO add your handling code here:
        alg = 4;
    }//GEN-LAST:event_IDAStarActionPerformed

    private void sizesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizesActionPerformed
// TODO add your handling code here:
        nc = sizes.getSelectedIndex() + 5;
        p = new ProbPathFinderBoard(nc, dif, drawPanel1);
        drawPanel1.setPlano(nc, p.getPlano());
    }//GEN-LAST:event_sizesActionPerformed

    private void AStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AStarActionPerformed
// TODO add your handling code here:
        alg = 3;
    }//GEN-LAST:event_AStarActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
// TODO add your handling code here:
        alg = 2;
    }//GEN-LAST:event_IDActionPerformed

    private void DFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DFActionPerformed
// TODO add your handling code here:
        alg = 1;
    }//GEN-LAST:event_DFActionPerformed

    private void limpiarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarMousePressed
// TODO add your handling code here:
        drawPanel1.clean();
        instrum.setText("");
    }//GEN-LAST:event_limpiarMousePressed

    private void reiniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reiniciarMousePressed
// TODO add your handling code here:
        p = new ProbPathFinderBoard(nc, dif, drawPanel1);
        drawPanel1.setPlano(nc, p.getPlano());
    }//GEN-LAST:event_reiniciarMousePressed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
// TODO add your handling code here:
        dispose();   
    }//GEN-LAST:event_SalirActionPerformed

    private void ejecutarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ejecutarMousePressed
        drawPanel1.clean();
        Search search = null; //new DepthLimitedSearch(2*nc);;
        Problem problem = null;//  new Problem(p,new ProbPathFinderSuccessorFunction(), new ProbPathFinderGoalTest(),new ProbPathFinderHeuristicFunction());

        if (heur == 1) {
            problem = new Problem(p, new ProbPathFinderSuccessorFunction(), new ProbPathFinderGoalTest(), new ProbPathFinderHeuristicFunction());
        }
        if (heur == 2) {
            problem = new Problem(p, new ProbPathFinderSuccessorFunction(), new ProbPathFinderGoalTest(), new ProbPathFinderHeuristicFunction2());
        }
        if (heur == 3) {
            problem = new Problem(p, new ProbPathFinderSuccessorFunction(), new ProbPathFinderGoalTest(), new ProbPathFinderHeuristicFunction3());
        }

        if (alg == 1) {
            search = new DepthLimitedSearch(2 * nc);
        }
        if (alg == 2) {
            search = new IterativeDeepeningSearch();
        }
        if (alg == 3) {
            search = new AStarSearch(new GraphSearch());
        }
        if (alg == 4) {
            search = new IterativeDeepeningAStarSearch();
        }

        //System.out.println(alg);

        //     Search search =  new BreadthFirstSearch(new TreeSearch());
        //Search search =  new HillClimbingSearch();
        try {
            Date d1, d2;
            Calendar a, b;

            d1 = new Date();
            SearchAgent agent = new SearchAgent(problem, search);
            d2 = new Date();

            a = Calendar.getInstance();
            b = Calendar.getInstance();
            a.setTime(d1);
            b.setTime(d2);

            long m = b.getTimeInMillis() - a.getTimeInMillis();

            tiempo.setText(m + " ms");
            //   System.err.println(m+" Milisegundos");


            List actions = agent.getActions();

            int x = 0, y = 0;
            camino.setText("");
            for (int i = 0; i < actions.size() - 1; i++) {
                String action = (String) actions.get(i);
                camino.setText(camino.getText() + action);
                if (action.compareTo("S") == 0) {
                    y = y + 1;
                }
                if (action.compareTo("N") == 0) {
                    y = y - 1;
                }
                if (action.compareTo("W") == 0) {
                    x = x - 1;
                }
                if (action.compareTo("E") == 0) {
                    x = x + 1;
                }
                drawPanel1.modifyPlano(x, y);
            }
            String action = (String) actions.get(actions.size() - 1);
            camino.setText(camino.getText() + action + " (" + actions.size() + "pasos)");
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
     

    }//GEN-LAST:event_ejecutarMousePressed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_limpiarActionPerformed

    private void drawPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanel1MousePressed
               Point pnt = evt.getPoint();
        drawPanel1.changeState(pnt.getX(), pnt.getY());
        p.modifyPlano(drawPanel1.getPlano());

    }//GEN-LAST:event_drawPanel1MousePressed

    private void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        instrum.setText("");
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            instrum.append(key + " : " + property + "\n");
        //System.out.println(key + " : " + property);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ProbPathFinderDemoJFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AStar;
    private javax.swing.JRadioButton DF;
    private javax.swing.JRadioButton ID;
    private javax.swing.JRadioButton IDAStar;
    private javax.swing.JMenuItem Salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField camino;
    private javax.swing.JRadioButton cityblock;
    private javax.swing.JComboBox dificultad;
    private static Laberinto drawPanel1;
    private javax.swing.JButton ejecutar;
    private javax.swing.JRadioButton euclidean;
    private javax.swing.JTextArea instrum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JButton limpiar;
    private javax.swing.JRadioButton mixed;
    private javax.swing.JButton reiniciar;
    private javax.swing.JLabel size;
    private javax.swing.JComboBox sizes;
    private javax.swing.JTextField tiempo;
    private javax.swing.JMenuItem tipoA;
    private javax.swing.JMenuItem tipoB;
    private javax.swing.JMenuItem tipoC;
    private javax.swing.JMenuItem tipoD;
    // End of variables declaration//GEN-END:variables
}
