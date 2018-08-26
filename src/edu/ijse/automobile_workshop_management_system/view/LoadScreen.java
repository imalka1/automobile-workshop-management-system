package edu.ijse.automobile_workshop_management_system.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class LoadScreen extends javax.swing.JFrame {

    private int count = 0;
    private Timer time;
    private MainFrame mainFrame;

    public LoadScreen() {
        initComponents();
        setSize(600, 800);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(new Color(58, 58, 58));
        setBackground(new Color(58, 58, 58,220));
        prgLoading.setBackground(new Color(58, 58, 58,220));
        runProgram();
        icon();
        mainFrame = new MainFrame();
    }
    
    private void icon(){
        URL iconURL=this.getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Limousine Car_50px.png");
        ImageIcon imageIcon=new ImageIcon(iconURL);
        setIconImage(imageIcon.getImage());
    }

    private void runProgram() {

        time = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                prgLoading.setValue(prgLoading.getValue()+1);
                if(prgLoading.getValue()==prgLoading.getMaximum()){
                  time.stop();
                  LoadScreen.this.dispose();
                  mainFrame.setVisible(true);
                }
            }
        });
        time.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        prgLoading = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Neuropol X Rg", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 191, 5));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lumina ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 110, 510, 60);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(224, 166, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Loading");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 620, 210, 40);

        jLabel3.setFont(new java.awt.Font("Neuropol X Rg", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 191, 5));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Motors");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 190, 500, 80);

        prgLoading.setForeground(new java.awt.Color(255, 191, 5));
        prgLoading.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(prgLoading);
        prgLoading.setBounds(30, 584, 540, 20);

        jLabel4.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 166, 0));
        jLabel4.setText("Starting...");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 760, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar prgLoading;
    // End of variables declaration//GEN-END:variables
}
