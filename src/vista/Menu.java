/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import Dao.MntoMedicamento;
import controlador.ControladorMntoEspecialidad;
import controlador.ControladorMntoMedicamento;
import controlador.Controlador_Datos_Ambulancia;
import controlador.Controlador_Datos_Hospital;
import javax.swing.JFrame;



/**
 *
 * @author karie
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setResizable(false);
        //panel.setBorder(new Fondo("/Unidad1.img/imagen.jpeg"));
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnUnidad1 = new javax.swing.JMenu();
        btnAmbulancia = new javax.swing.JMenu();
        btnUnidad2 = new javax.swing.JMenu();
        btnHospital = new javax.swing.JMenu();
        btnUnidad3 = new javax.swing.JMenu();
        btnMedicamento = new javax.swing.JMenu();
        btnUnidad4 = new javax.swing.JMenu();
        btnEspecialidad = new javax.swing.JMenu();
        btnSalir = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(6, 169, 157));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(145, 159, 214), null, null));

        btnUnidad1.setText("AMBULANCIA  ");
        btnUnidad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnidad1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUnidad1MousePressed(evt);
            }
        });

        btnAmbulancia.setText("Datos Ambulancia");
        btnAmbulancia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAmbulanciaMousePressed(evt);
            }
        });
        btnUnidad1.add(btnAmbulancia);

        jMenuBar1.add(btnUnidad1);

        btnUnidad2.setText("HOSPITAL");
        btnUnidad2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUnidad2MousePressed(evt);
            }
        });

        btnHospital.setText("Datos Hospital");
        btnHospital.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHospitalMousePressed(evt);
            }
        });
        btnUnidad2.add(btnHospital);

        jMenuBar1.add(btnUnidad2);

        btnUnidad3.setText("MEDICAMENTO");
        btnUnidad3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnidad3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUnidad3MousePressed(evt);
            }
        });

        btnMedicamento.setText("Datos Medicamento");
        btnMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMedicamentoMousePressed(evt);
            }
        });
        btnUnidad3.add(btnMedicamento);

        jMenuBar1.add(btnUnidad3);

        btnUnidad4.setText("ESPECIALIDAD ");
        btnUnidad4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnidad4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUnidad4MousePressed(evt);
            }
        });

        btnEspecialidad.setText("Datos especialidad");
        btnEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEspecialidadMousePressed(evt);
            }
        });
        btnUnidad4.add(btnEspecialidad);

        jMenuBar1.add(btnUnidad4);

        btnSalir.setText("SALIR");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnUnidad2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad2MousePressed
       
    }//GEN-LAST:event_btnUnidad2MousePressed

    private void btnHospitalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHospitalMousePressed
          Vista_Datos_Hospital vistita = new  Vista_Datos_Hospital();
        Controlador_Datos_Hospital crtHospital = new Controlador_Datos_Hospital(vistita);
        vistita.setVisible(true);
    }//GEN-LAST:event_btnHospitalMousePressed

    private void btnUnidad1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnidad1MouseClicked

    private void btnUnidad1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad1MousePressed
      
    }//GEN-LAST:event_btnUnidad1MousePressed

    private void btnAmbulanciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAmbulanciaMousePressed
        Vista_Datos_Ambulancia vista = new Vista_Datos_Ambulancia();
        Controlador_Datos_Ambulancia vistita = new Controlador_Datos_Ambulancia (vista);
        vista.setVisible(true);
    }//GEN-LAST:event_btnAmbulanciaMousePressed

    private void btnMedicamentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMedicamentoMousePressed
      MntoMedicamento frmMedicamento = new MntoMedicamento();
        ControladorMntoMedicamento ctrMedicamento = new ControladorMntoMedicamento(frmMedicamento);
        frmMedicamento.setVisible(true);
    }//GEN-LAST:event_btnMedicamentoMousePressed

    private void btnUnidad3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnidad3MouseClicked

    private void btnUnidad3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnidad3MousePressed

    private void btnEspecialidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEspecialidadMousePressed
           MntoEspecialidad frmEspec = new MntoEspecialidad();
        ControladorMntoEspecialidad ctrEspec = new ControladorMntoEspecialidad(frmEspec);
        frmEspec.setVisible(true);
    }//GEN-LAST:event_btnEspecialidadMousePressed

    private void btnUnidad4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnidad4MouseClicked

    private void btnUnidad4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnidad4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnidad4MousePressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu btnAmbulancia;
    public javax.swing.JMenu btnEspecialidad;
    public javax.swing.JMenu btnHospital;
    public javax.swing.JMenu btnMedicamento;
    private javax.swing.JMenu btnSalir;
    public javax.swing.JMenu btnUnidad1;
    public javax.swing.JMenu btnUnidad2;
    public javax.swing.JMenu btnUnidad3;
    public javax.swing.JMenu btnUnidad4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

   
}
