package edu.ijse.automobile_workshop_management_system.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

public class MainFrame extends javax.swing.JFrame {
    
    private MainPanel newMainPanel;
    
    public MainFrame() {
        initComponents();
        setSize();
        getContentPane().setBackground(Color.WHITE);
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("Lumina Motors");
        //setResizable(false);
       // mainPanel.add(MainPanel.getMainPanel());
        icon();
        newMainPanel=MainPanel.getMainPanel();
        newMainPanel.setBounds(0, 0, 1920, 1040);
        mainPanel.add(newMainPanel);
    }
    
    private void icon(){
        URL iconURL=this.getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Limousine Car_50px.png");
        ImageIcon imageIcon=new ImageIcon(iconURL);
        setIconImage(imageIcon.getImage());
    }
    
    private void setSize() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screensize.width, screensize.height);
        System.out.println(screensize.width);
        System.out.println(screensize.height);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(19200, 19200));
        getContentPane().setLayout(null);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(null);
        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
