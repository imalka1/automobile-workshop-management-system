package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.utilities.DateAndTime;
import java.awt.Color;

public class MainPanel extends javax.swing.JPanel {
    
    private static CustomerVehiclePanel customerVehiclePanel;
    private static LoginPanel loginPanel;
    private static VehicleInformationPanel vehicleInformationPanel;
    private static CurrentRepairPanel currentRepairPanel;
    private static ItemInvoicePanel itemInvoicePanel;
    private static StockItemsPanel stockItemsPanel;
    private static DateAndTime dateAndTime;
    private static MainPanel newMainPanel;
    private boolean firstIsSelected = false;
    private boolean secondIsSelected = false;
    private boolean thirdIsSelected = false;
    private boolean fourthIsSelected = false;
    private boolean fifthIsSelected = false;
    
    public MainPanel() {
        initComponents();
        addPanel();
        hidePanel();
        hideArrows();
        labelLogo.setVisible(true);
        panelLogin.setVisible(false);
        panelMain.setVisible(true);
        loginPanel.setVisible(true);
        buttonCreateAccount.setVisible(false);
        buttonLogout.setVisible(false);
        firstIsSelected = true;
        buttonCustomerVehicle.setForeground(new Color(255, 191, 5));
        arrowCustomerVehicle.setVisible(true);
    }
    
    private void addPanel() {
        loginPanel = new LoginPanel();
        loginPanel.setBounds(0, 0, 1920, 990);
        customerVehiclePanel = new CustomerVehiclePanel();
        customerVehiclePanel.setBounds(0, 0, 1920, 990);
        vehicleInformationPanel = new VehicleInformationPanel();
        vehicleInformationPanel.setBounds(0, 0, 1920, 990);
        currentRepairPanel = new CurrentRepairPanel();
        currentRepairPanel.setBounds(0, 0, 1920, 990);
        itemInvoicePanel = new ItemInvoicePanel();
        itemInvoicePanel.setBounds(0, 0, 1920, 990);
        stockItemsPanel = new StockItemsPanel();
        stockItemsPanel.setBounds(0, 0, 1920, 990);
        dateAndTime = new DateAndTime();
        dateAndTime.setBounds(0, 0, 170, 90);
        mainPanel.add(loginPanel);
        mainPanel.add(customerVehiclePanel);
        mainPanel.add(vehicleInformationPanel);
        mainPanel.add(currentRepairPanel);
        mainPanel.add(itemInvoicePanel);
        mainPanel.add(stockItemsPanel);
        panelDateAndTime.add(dateAndTime);
    }
    
    private static void hidePanel() {
        customerVehiclePanel.setVisible(false);
        vehicleInformationPanel.setVisible(false);
        currentRepairPanel.setVisible(false);
        itemInvoicePanel.setVisible(false);
        stockItemsPanel.setVisible(false);
    }
    
    public static MainPanel getMainPanel() {
        if (newMainPanel == null) {
            newMainPanel = new MainPanel();
        }
        return newMainPanel;
    }
    
    public void managePanel(int x) {
        loginPanel.setVisible(false);
        customerVehiclePanel.setVisible(true);
        customerVehiclePanel.visibleFalse();
        buttonLogout.setVisible(true);
        labelLogo.setVisible(false);
        buttonCreateAccount.setVisible(false);
        if (x == 0) {
            customerVehiclePanel.visibleTrue();
            buttonCreateAccount.setVisible(true);
        }
        panelLogin.setVisible(true);
    }
    
    public static CustomerVehiclePanel getCustomerVehiclePanel() {
        if (customerVehiclePanel == null) {
            customerVehiclePanel = new CustomerVehiclePanel();
        }
        return customerVehiclePanel;
    }
    
    public static VehicleInformationPanel getVehicleInformationPanel() {
        if (vehicleInformationPanel == null) {
            vehicleInformationPanel = new VehicleInformationPanel();
        }
        return vehicleInformationPanel;
    }
    
    public static CurrentRepairPanel getCurrentRepairPanel() {
        if (currentRepairPanel == null) {
            currentRepairPanel = new CurrentRepairPanel();
        }
        return currentRepairPanel;
    }
    
    public static DateAndTime getDateAndTime() {
        if (dateAndTime == null) {
            dateAndTime = new DateAndTime();
        }
        return dateAndTime;
    }
    
    public static void managePanelsForVehicleInformation() {
        hidePanel();
        vehicleInformationPanel.setVisible(true);
    }
    
    public static void managePanelsForCustomerVehicle() {
        hidePanel();
        customerVehiclePanel.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelDateAndTime = new javax.swing.JPanel();
        buttonLogout = new javax.swing.JLabel();
        buttonCreateAccount = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        arrowStockItems = new javax.swing.JLabel();
        arrowCustomerVehicle = new javax.swing.JLabel();
        arrowVehicleInformation = new javax.swing.JLabel();
        arrowCurrentRepairs = new javax.swing.JLabel();
        arrowItemInvoice = new javax.swing.JLabel();
        buttonCustomerVehicle = new javax.swing.JLabel();
        buttonVehicleInformation = new javax.swing.JLabel();
        buttonItemInvoice = new javax.swing.JLabel();
        buttonCurrentRepairs = new javax.swing.JLabel();
        buttonStockItems1 = new javax.swing.JLabel();
        seperator = new javax.swing.JLabel();
        seperator2 = new javax.swing.JLabel();
        seperator3 = new javax.swing.JLabel();
        seperator4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        seperator1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(null);

        panelMain.setBackground(new java.awt.Color(35, 35, 35));
        panelMain.setLayout(null);

        panelDateAndTime.setBackground(new java.awt.Color(35, 35, 35));
        panelDateAndTime.setLayout(null);
        panelMain.add(panelDateAndTime);
        panelDateAndTime.setBounds(1748, 0, 170, 90);

        buttonLogout.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        buttonLogout.setForeground(new java.awt.Color(102, 102, 102));
        buttonLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonLogout.setText("Logout");
        buttonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLogoutMouseClicked(evt);
            }
        });
        panelMain.add(buttonLogout);
        buttonLogout.setBounds(1640, 0, 90, 40);

        buttonCreateAccount.setBackground(new java.awt.Color(35, 35, 35));
        buttonCreateAccount.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        buttonCreateAccount.setForeground(new java.awt.Color(102, 102, 102));
        buttonCreateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonCreateAccount.setText("User");
        buttonCreateAccount.setOpaque(true);
        panelMain.add(buttonCreateAccount);
        buttonCreateAccount.setBounds(1660, 50, 70, 40);

        panelLogin.setBackground(new java.awt.Color(35, 35, 35));
        panelLogin.setLayout(null);

        arrowStockItems.setBackground(new java.awt.Color(35, 35, 35));
        arrowStockItems.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowStockItems.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Down_48px.png"))); // NOI18N
        arrowStockItems.setOpaque(true);
        panelLogin.add(arrowStockItems);
        arrowStockItems.setBounds(1430, 60, 190, 20);

        arrowCustomerVehicle.setBackground(new java.awt.Color(35, 35, 35));
        arrowCustomerVehicle.setForeground(new java.awt.Color(0, 132, 132));
        arrowCustomerVehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowCustomerVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Down_48px.png"))); // NOI18N
        arrowCustomerVehicle.setOpaque(true);
        panelLogin.add(arrowCustomerVehicle);
        arrowCustomerVehicle.setBounds(230, 60, 300, 20);

        arrowVehicleInformation.setBackground(new java.awt.Color(35, 35, 35));
        arrowVehicleInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowVehicleInformation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Down_48px.png"))); // NOI18N
        arrowVehicleInformation.setOpaque(true);
        panelLogin.add(arrowVehicleInformation);
        arrowVehicleInformation.setBounds(570, 60, 290, 20);

        arrowCurrentRepairs.setBackground(new java.awt.Color(35, 35, 35));
        arrowCurrentRepairs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowCurrentRepairs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Down_48px.png"))); // NOI18N
        arrowCurrentRepairs.setOpaque(true);
        panelLogin.add(arrowCurrentRepairs);
        arrowCurrentRepairs.setBounds(900, 60, 250, 20);

        arrowItemInvoice.setBackground(new java.awt.Color(35, 35, 35));
        arrowItemInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arrowItemInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Down_48px.png"))); // NOI18N
        arrowItemInvoice.setOpaque(true);
        panelLogin.add(arrowItemInvoice);
        arrowItemInvoice.setBounds(1190, 60, 200, 20);

        buttonCustomerVehicle.setBackground(new java.awt.Color(35, 35, 35));
        buttonCustomerVehicle.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonCustomerVehicle.setForeground(new java.awt.Color(102, 102, 102));
        buttonCustomerVehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonCustomerVehicle.setText("Customer Vehicle");
        buttonCustomerVehicle.setOpaque(true);
        buttonCustomerVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCustomerVehicleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCustomerVehicleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCustomerVehicleMouseExited(evt);
            }
        });
        panelLogin.add(buttonCustomerVehicle);
        buttonCustomerVehicle.setBounds(230, 0, 300, 90);

        buttonVehicleInformation.setBackground(new java.awt.Color(35, 35, 35));
        buttonVehicleInformation.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonVehicleInformation.setForeground(new java.awt.Color(102, 102, 102));
        buttonVehicleInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonVehicleInformation.setText("Vehicle Information");
        buttonVehicleInformation.setOpaque(true);
        buttonVehicleInformation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonVehicleInformationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonVehicleInformationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonVehicleInformationMouseExited(evt);
            }
        });
        panelLogin.add(buttonVehicleInformation);
        buttonVehicleInformation.setBounds(570, 0, 290, 90);

        buttonItemInvoice.setBackground(new java.awt.Color(35, 35, 35));
        buttonItemInvoice.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonItemInvoice.setForeground(new java.awt.Color(102, 102, 102));
        buttonItemInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonItemInvoice.setText("Item Invoice");
        buttonItemInvoice.setOpaque(true);
        buttonItemInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonItemInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonItemInvoiceMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonItemInvoiceMouseClicked(evt);
            }
        });
        panelLogin.add(buttonItemInvoice);
        buttonItemInvoice.setBounds(1190, 0, 200, 90);

        buttonCurrentRepairs.setBackground(new java.awt.Color(35, 35, 35));
        buttonCurrentRepairs.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonCurrentRepairs.setForeground(new java.awt.Color(102, 102, 102));
        buttonCurrentRepairs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonCurrentRepairs.setText("Current Repairs");
        buttonCurrentRepairs.setOpaque(true);
        buttonCurrentRepairs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCurrentRepairsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonCurrentRepairsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonCurrentRepairsMouseExited(evt);
            }
        });
        panelLogin.add(buttonCurrentRepairs);
        buttonCurrentRepairs.setBounds(900, 0, 250, 90);

        buttonStockItems1.setBackground(new java.awt.Color(35, 35, 35));
        buttonStockItems1.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonStockItems1.setForeground(new java.awt.Color(102, 102, 102));
        buttonStockItems1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonStockItems1.setText("Stock Items");
        buttonStockItems1.setOpaque(true);
        buttonStockItems1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonStockItems1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonStockItems1MouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonStockItems1MouseClicked(evt);
            }
        });
        panelLogin.add(buttonStockItems1);
        buttonStockItems1.setBounds(1430, 0, 190, 90);

        seperator.setBackground(new java.awt.Color(255, 191, 5));
        seperator.setOpaque(true);
        panelLogin.add(seperator);
        seperator.setBounds(1410, 30, 10, 30);

        seperator2.setBackground(new java.awt.Color(255, 191, 5));
        seperator2.setOpaque(true);
        panelLogin.add(seperator2);
        seperator2.setBounds(540, 30, 10, 30);

        seperator3.setBackground(new java.awt.Color(255, 191, 5));
        seperator3.setOpaque(true);
        panelLogin.add(seperator3);
        seperator3.setBounds(880, 30, 10, 30);

        seperator4.setBackground(new java.awt.Color(255, 191, 5));
        seperator4.setOpaque(true);
        panelLogin.add(seperator4);
        seperator4.setBounds(1170, 30, 10, 30);

        jLabel1.setBackground(new java.awt.Color(183, 136, 0));
        jLabel1.setOpaque(true);
        panelLogin.add(jLabel1);
        jLabel1.setBounds(30, 50, 90, 10);

        jLabel2.setBackground(new java.awt.Color(183, 136, 0));
        jLabel2.setOpaque(true);
        panelLogin.add(jLabel2);
        jLabel2.setBounds(30, 10, 90, 10);

        jLabel3.setBackground(new java.awt.Color(255, 191, 5));
        jLabel3.setOpaque(true);
        panelLogin.add(jLabel3);
        jLabel3.setBounds(80, 70, 90, 10);

        jLabel4.setBackground(new java.awt.Color(255, 191, 5));
        jLabel4.setOpaque(true);
        panelLogin.add(jLabel4);
        jLabel4.setBounds(80, 30, 90, 10);

        panelMain.add(panelLogin);
        panelLogin.setBounds(0, 0, 1640, 100);

        labelLogo.setBackground(new java.awt.Color(35, 35, 35));
        labelLogo.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 191, 5));
        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setText("Lumina Motors");
        labelLogo.setOpaque(true);
        panelMain.add(labelLogo);
        labelLogo.setBounds(781, 0, 350, 90);

        jLabel5.setBackground(new java.awt.Color(183, 136, 0));
        jLabel5.setOpaque(true);
        panelMain.add(jLabel5);
        jLabel5.setBounds(711, 40, 50, 10);

        jLabel6.setBackground(new java.awt.Color(183, 136, 0));
        jLabel6.setOpaque(true);
        panelMain.add(jLabel6);
        jLabel6.setBounds(1151, 40, 50, 10);

        seperator1.setBackground(new java.awt.Color(255, 191, 5));
        seperator1.setOpaque(true);
        panelMain.add(seperator1);
        seperator1.setBounds(1730, 10, 10, 70);

        add(panelMain);
        panelMain.setBounds(0, 0, 1920, 90);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(null);
        add(mainPanel);
        mainPanel.setBounds(0, 90, 1920, 990);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogoutMouseClicked
        hidePanel();
        panelLogin.setVisible(false);
        labelLogo.setVisible(true);
        buttonCreateAccount.setVisible(false);
        buttonLogout.setVisible(false);
        loginPanel.setVisible(true);
        loginPanel.clearText();
    }//GEN-LAST:event_buttonLogoutMouseClicked
    private void selection() {
        firstIsSelected = false;
        secondIsSelected = false;
        thirdIsSelected = false;
        fourthIsSelected = false;
        fifthIsSelected = false;
    }
    
    private void hideArrows() {
        arrowCustomerVehicle.setVisible(false);
        arrowVehicleInformation.setVisible(false);
        arrowCurrentRepairs.setVisible(false);
        arrowItemInvoice.setVisible(false);
        arrowStockItems.setVisible(false);
    }
    private void buttonCustomerVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCustomerVehicleMouseClicked
        hidePanel();
        resetButtons();
        customerVehiclePanel.setVisible(true);
        selection();
        firstIsSelected = true;
        buttonCustomerVehicle.setForeground(new Color(255, 191, 5));
        arrowCustomerVehicle.setVisible(true);
    }//GEN-LAST:event_buttonCustomerVehicleMouseClicked

    private void buttonCustomerVehicleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCustomerVehicleMouseEntered
        buttonCustomerVehicle.setForeground(new Color(255, 191, 5));
        arrowCustomerVehicle.setVisible(true);

    }//GEN-LAST:event_buttonCustomerVehicleMouseEntered

    private void buttonCustomerVehicleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCustomerVehicleMouseExited
        if (!firstIsSelected) {
            buttonCustomerVehicle.setForeground(new Color(102, 102, 102));
            arrowCustomerVehicle.setVisible(false);
        }
    }//GEN-LAST:event_buttonCustomerVehicleMouseExited

    private void buttonVehicleInformationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVehicleInformationMouseClicked
        hidePanel();
        resetButtons();
        vehicleInformationPanel.setVisible(true);
        selection();
        secondIsSelected = true;
        MainPanel.getVehicleInformationPanel().setData();
        buttonVehicleInformation.setForeground(new Color(255, 191, 5));
        arrowVehicleInformation.setVisible(true);
    }//GEN-LAST:event_buttonVehicleInformationMouseClicked

    private void buttonVehicleInformationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVehicleInformationMouseEntered
        buttonVehicleInformation.setForeground(new Color(255, 191, 5));
        arrowVehicleInformation.setVisible(true);
    }//GEN-LAST:event_buttonVehicleInformationMouseEntered

    private void buttonVehicleInformationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVehicleInformationMouseExited
        if (!secondIsSelected) {
            buttonVehicleInformation.setForeground(new Color(102, 102, 102));
            arrowVehicleInformation.setVisible(false);
        }
    }//GEN-LAST:event_buttonVehicleInformationMouseExited

    private void buttonCurrentRepairsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCurrentRepairsMouseClicked
        hidePanel();
        currentRepairPanel.setVisible(true);
    }//GEN-LAST:event_buttonCurrentRepairsMouseClicked

    private void buttonItemInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonItemInvoiceMouseClicked
        hidePanel();
        itemInvoicePanel.setVisible(true);
    }//GEN-LAST:event_buttonItemInvoiceMouseClicked

    private void buttonCurrentRepairsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCurrentRepairsMouseEntered
        buttonCurrentRepairs.setForeground(new Color(255, 191, 5));
        arrowCurrentRepairs.setVisible(true);
    }//GEN-LAST:event_buttonCurrentRepairsMouseEntered

    private void buttonItemInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonItemInvoiceMouseEntered
        buttonItemInvoice.setForeground(new Color(255, 191, 5));
        arrowItemInvoice.setVisible(true);
    }//GEN-LAST:event_buttonItemInvoiceMouseEntered

    private void buttonCurrentRepairsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCurrentRepairsMouseExited
        buttonCurrentRepairs.setForeground(new Color(102, 102, 102));
        arrowCurrentRepairs.setVisible(false);
    }//GEN-LAST:event_buttonCurrentRepairsMouseExited

    private void buttonItemInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonItemInvoiceMouseExited
        buttonItemInvoice.setForeground(new Color(102, 102, 102));
        arrowItemInvoice.setVisible(false);
    }//GEN-LAST:event_buttonItemInvoiceMouseExited

    private void buttonStockItems1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStockItems1MouseEntered
        buttonStockItems1.setForeground(new Color(255, 191, 5));
        arrowStockItems.setVisible(true);
    }//GEN-LAST:event_buttonStockItems1MouseEntered

    private void buttonStockItems1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStockItems1MouseExited
        buttonStockItems1.setForeground(new Color(102, 102, 102));
        arrowStockItems.setVisible(false);
    }//GEN-LAST:event_buttonStockItems1MouseExited

    private void buttonStockItems1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStockItems1MouseClicked
        hidePanel();
        stockItemsPanel.setVisible(true);
    }//GEN-LAST:event_buttonStockItems1MouseClicked
    
    private void resetButtons() {
        buttonCustomerVehicle.setForeground(new Color(102, 102, 102));
        buttonVehicleInformation.setForeground(new Color(102, 102, 102));
        buttonCurrentRepairs.setForeground(new Color(102, 102, 102));
        buttonItemInvoice.setForeground(new Color(102, 102, 102));
        buttonStockItems1.setForeground(new Color(102, 102, 102));
        arrowCustomerVehicle.setVisible(false);
        arrowVehicleInformation.setVisible(false);
        arrowItemInvoice.setVisible(false);
        arrowCurrentRepairs.setVisible(false);
        arrowStockItems.setVisible(false);
    }
    
    public void selectButton() {
        resetButtons();
        selection();
        secondIsSelected = true;
        buttonVehicleInformation.setForeground(new Color(255, 191, 5));
        arrowVehicleInformation.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrowCurrentRepairs;
    private javax.swing.JLabel arrowCustomerVehicle;
    private javax.swing.JLabel arrowItemInvoice;
    private javax.swing.JLabel arrowStockItems;
    private javax.swing.JLabel arrowVehicleInformation;
    private javax.swing.JLabel buttonCreateAccount;
    private javax.swing.JLabel buttonCurrentRepairs;
    private javax.swing.JLabel buttonCustomerVehicle;
    private javax.swing.JLabel buttonItemInvoice;
    private javax.swing.JLabel buttonLogout;
    private javax.swing.JLabel buttonStockItems1;
    private javax.swing.JLabel buttonVehicleInformation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelDateAndTime;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelMain;
    private javax.swing.JLabel seperator;
    private javax.swing.JLabel seperator1;
    private javax.swing.JLabel seperator2;
    private javax.swing.JLabel seperator3;
    private javax.swing.JLabel seperator4;
    // End of variables declaration//GEN-END:variables
}
