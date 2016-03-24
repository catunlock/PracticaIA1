/*
 * probAntenasJFrame.java
 *
 * Created on 5 de agosto de 2005, 12:07
 */

package IA.probAntenas;

import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

/**
 *
 * @author  javier
 */
public class ProbAntenasJFrame extends javax.swing.JFrame {
  /**
	 * 
	 */
  private static final long serialVersionUID = 508166313833648089L;
  private ProbAntenasBoard p;
  private int alg=1;
  private int heur=1;
  private int nc=8;
  private int tp=10;
  private int pot=20;
  /** Creates new form probAntenasJFrame */
    public ProbAntenasJFrame() {
        initComponents();
        
        p=new ProbAntenasBoard(nc,pot,tp);
        drawPanel1.setPlano(tp,p.getPlano());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        size = new javax.swing.JLabel();
        sizes = new javax.swing.JComboBox();
        sizes.addItem("10x10");
        sizes.addItem("11x11");
        sizes.addItem("12x12");
        sizes.addItem("13x13");
        sizes.addItem("14x14");
        sizes.addItem("15x15");
        sizes.addItem("16x16");
        sizes.addItem("17x17");
        sizes.addItem("18x18");
        sizes.addItem("19x19");
        sizes.addItem("20x20");
        sizes.setSelectedIndex(0);
        nantenas = new javax.swing.JLabel();
        nant = new javax.swing.JTextField();
        pmax = new javax.swing.JLabel();
        pmaxima = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        HC = new javax.swing.JRadioButton();
        SA = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        heur1 = new javax.swing.JRadioButton();
        heur2 = new javax.swing.JRadioButton();
        heur3 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tiempo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        reiniciar = new javax.swing.JButton();
        ejecutar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        instrum = new javax.swing.JTextArea();
        drawPanel1 = new IA.probAntenas.AntenasCoberturaPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Antenas");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        size.setText("Tama�o: ");
        jPanel3.add(size);

        sizes.setToolTipText("Tama�o del mapa");
        sizes.setPreferredSize(new java.awt.Dimension(70, 24));
        sizes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizesActionPerformed(evt);
            }
        });
        jPanel3.add(sizes);

        nantenas.setText("Num Antenas:");
        jPanel3.add(nantenas);

        nant.setColumns(3);
        nant.setText(nc+"");
        jPanel3.add(nant);

        pmax.setText("Potencia Maxima:");
        jPanel3.add(pmax);

        pmaxima.setColumns(4);
        pmaxima.setText(pot+"");
        jPanel3.add(pmaxima);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel3, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("Algoritmo: ");
        jPanel2.add(jLabel4, new java.awt.GridBagConstraints());

        buttonGroup1.add(HC);
        HC.setSelected(true);
        HC.setText("Hill Climbing");
        HC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HCActionPerformed(evt);
            }
        });
        jPanel2.add(HC, new java.awt.GridBagConstraints());

        buttonGroup1.add(SA);
        SA.setText("Annealing");
        SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAActionPerformed(evt);
            }
        });
        jPanel2.add(SA, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 6;
        getContentPane().add(jPanel2, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Heuristicas: ");
        jPanel5.add(jLabel3, new java.awt.GridBagConstraints());

        buttonGroup2.add(heur1);
        heur1.setSelected(true);
        heur1.setLabel("Heuristico 1");
        heur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heur1ActionPerformed(evt);
            }
        });
        jPanel5.add(heur1, new java.awt.GridBagConstraints());

        buttonGroup2.add(heur2);
        heur2.setLabel("Heuristico 2");
        heur2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heur2ActionPerformed(evt);
            }
        });
        jPanel5.add(heur2, new java.awt.GridBagConstraints());

        buttonGroup2.add(heur3);
        heur3.setLabel("Heuristico 3");
        heur3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heur3ActionPerformed(evt);
            }
        });
        jPanel5.add(heur3, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel5, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Tiempo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(1, 27, 0, 0);
        jPanel6.add(jLabel1, gridBagConstraints);

        tiempo.setColumns(10);
        tiempo.setEditable(false);
        jPanel6.add(tiempo, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jPanel6, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 35));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        reiniciar.setText("Actualizar parametros");
        reiniciar.setToolTipText("Reiniciar el mapa");
        reiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reiniciarMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(reiniciar, gridBagConstraints);

        ejecutar.setText("Ejecutar");
        ejecutar.setToolTipText("Ejecutar el algoritmo seleccionado");
        ejecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ejecutarMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(ejecutar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel7.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        instrum.setColumns(10);
        instrum.setEditable(false);
        instrum.setLineWrap(true);
        instrum.setRows(10);
        instrum.setPreferredSize(new java.awt.Dimension(180, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel7.add(instrum, gridBagConstraints);

        drawPanel1.setPreferredSize(new java.awt.Dimension(400, 400));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel7.add(drawPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        getContentPane().add(jPanel7, gridBagConstraints);

        jMenu1.setText("Menu");

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Salir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void heur3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heur3ActionPerformed
// TODO add your handling code here:
        heur=3;
    }//GEN-LAST:event_heur3ActionPerformed

    private void heur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heur1ActionPerformed
// TODO add your handling code here:
        heur=1;
    }//GEN-LAST:event_heur1ActionPerformed

    private void heur2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heur2ActionPerformed
// TODO add your handling code here:
        heur=2;
    }//GEN-LAST:event_heur2ActionPerformed

    private void sizesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizesActionPerformed
// TODO add your handling code here:
        tp=sizes.getSelectedIndex()+10;
        p=new ProbAntenasBoard(nc,pot,tp);
        drawPanel1.setPlano(tp,p.getPlano());
    }//GEN-LAST:event_sizesActionPerformed

    private void SAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAActionPerformed
// TODO add your handling code here:
        alg=2;
    }//GEN-LAST:event_SAActionPerformed

    private void HCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HCActionPerformed
// TODO add your handling code here:
        alg=1;
    }//GEN-LAST:event_HCActionPerformed

    private void reiniciarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reiniciarMousePressed
// TODO add your handling code here:
      String s;
      s=nant.getText();
      nc=Integer.parseInt(s);
      
      s=pmaxima.getText();
      pot=Integer.parseInt(s);
      
      p=new ProbAntenasBoard(nc,pot,tp);
      drawPanel1.setPlano(tp,p.getPlano());
    }//GEN-LAST:event_reiniciarMousePressed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
// TODO add your handling code here:
      dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void ejecutarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ejecutarMousePressed
// TODO add your handling code here:
     Search search=null; //new DepthLimitedSearch(2*nc);;
     Problem problem =null;//  new Problem(p,new ProbAntenasSuccessorFunction(), new ProbAntenasGoalTest(),new ProbAntenasHeuristicFunction());
     
     p.solucionInicial();
     //p.printAntenas();
    
     if (heur==1) problem =  new Problem(p,new ProbAntenasSuccessorFunction(), new ProbAntenasGoalTest(),new ProbAntenasHeuristicFunction());
     if (heur==2) problem =  new Problem(p,new ProbAntenasSuccessorFunction(), new ProbAntenasGoalTest(),new ProbAntenasHeuristicFunction2());
     if (heur==3) problem =  new Problem(p,new ProbAntenasSuccessorFunction(), new ProbAntenasGoalTest(),new ProbAntenasHeuristicFunction3());
     
     if (alg==1) search =  new HillClimbingSearch();
     if (alg==2) search =  new SimulatedAnnealingSearch(2000,100,5,0.001);

     //p.printCobertura();
     //System.out.println("--"+p.calculaCobertura());
     
     //     Search search =  new BreadthFirstSearch(new TreeSearch());
     //Search search =  new HillClimbingSearch();
     try {
       Date d1,d2;
       Calendar a,b;
       
       d1=new Date();
       SearchAgent agent = new SearchAgent(problem,search);
       d2=new Date();

       a= Calendar.getInstance();
       b= Calendar.getInstance();
       a.setTime(d1);
       b.setTime(d2);

       long m=b.getTimeInMillis()-a.getTimeInMillis();

       tiempo.setText(m+" ms");
       ProbAntenasBoard pf= (ProbAntenasBoard) search.getGoalState();

       drawPanel1.setPlano(tp,pf.getState());
       //pf.printAntenas();
       //pf.printCobertura();
       //List actions=agent.getActions();
      //printActions(agent.getActions());

      printInstrumentation(agent.getInstrumentation());
      instrum.append("Cobertura: "+ pf.calculaCobertura()+"\n");
      for (int i=0;i<nc;i++)
       instrum.append("Antena "+i+":"+ pf.antenaToString(i)+"\n");
         
   } catch (Exception e) {
            e.printStackTrace();
     }
    }//GEN-LAST:event_ejecutarMousePressed
    
    private void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        instrum.setText("");
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            instrum.append(key + " : " + property+"\n");
            //System.out.println(key + " : " + property);
        }
        
    }
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProbAntenasJFrame().setVisible(true);
            }
        });             
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton HC;
    private javax.swing.JRadioButton SA;
    private javax.swing.JMenuItem Salir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private IA.probAntenas.AntenasCoberturaPanel drawPanel1;
    private javax.swing.JButton ejecutar;
    private javax.swing.JRadioButton heur1;
    private javax.swing.JRadioButton heur2;
    private javax.swing.JRadioButton heur3;
    private javax.swing.JTextArea instrum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField nant;
    private javax.swing.JLabel nantenas;
    private javax.swing.JLabel pmax;
    private javax.swing.JTextField pmaxima;
    private javax.swing.JButton reiniciar;
    private javax.swing.JLabel size;
    private javax.swing.JComboBox sizes;
    private javax.swing.JTextField tiempo;
    // End of variables declaration//GEN-END:variables
    
}
