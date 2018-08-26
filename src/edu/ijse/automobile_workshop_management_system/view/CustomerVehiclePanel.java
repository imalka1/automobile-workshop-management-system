package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.controller.BrandController;
import edu.ijse.automobile_workshop_management_system.controller.CustomerController;
import edu.ijse.automobile_workshop_management_system.controller.CustomerVehicleController;
import edu.ijse.automobile_workshop_management_system.controller.InvoiceController;
import edu.ijse.automobile_workshop_management_system.controller.ModelController;
import edu.ijse.automobile_workshop_management_system.controller.VehicleController;
import edu.ijse.automobile_workshop_management_system.model.BrandDTO;
import edu.ijse.automobile_workshop_management_system.model.CustomerDTO;
import edu.ijse.automobile_workshop_management_system.model.CustomerVehicleDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.InvoiceDTO;
import edu.ijse.automobile_workshop_management_system.model.ModelDTO;
import edu.ijse.automobile_workshop_management_system.model.VehicleDTO;
import edu.ijse.automobile_workshop_management_system.utilities.CustomizeTable;
import edu.ijse.automobile_workshop_management_system.utilities.CustomizeTableHeader;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CustomerVehiclePanel extends javax.swing.JPanel {
    
    private DefaultTableModel modelCustomer;
    private DefaultTableModel modelVehicle;
    private static CustomerVehiclePanel customerVehiclePanel;
    private boolean customerController = false;
    private boolean vehicleController = false;
    private int x = 0;
    private int y = 0;
    private int cvid = 0;
    
    public CustomerVehiclePanel() {
        initComponents();
        modelCustomer = (DefaultTableModel) this.tblCustomer.getModel();
        modelVehicle = (DefaultTableModel) this.tblVehicle.getModel();
        customizeVehicleTable();
        customizeCustomerTable();
        customizeText();
        visibleFalse();
        hideIcons();
        setVisible(true);
        loadComboBrand();
        editorComboBrand();
        editorComboModel();
        AutoCompleteDecorator.decorate(cmbVehicleBrand);
        AutoCompleteDecorator.decorate(cmbVehicleModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCustomerVehicle = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paneCustomer = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerAddress = new javax.swing.JTextField();
        txtTelephone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtVehicleNo = new javax.swing.JTextField();
        paneVehicle = new javax.swing.JScrollPane();
        tblVehicle = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        radioCustomer = new javax.swing.JRadioButton();
        radioVehicle = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        exitAdd = new javax.swing.JLabel();
        exitDeleteCustomer = new javax.swing.JLabel();
        exitDelete = new javax.swing.JLabel();
        exitVehicleDetails = new javax.swing.JLabel();
        exitClearAll = new javax.swing.JLabel();
        exitUpdateVehicle = new javax.swing.JLabel();
        exitUpdateCustomer = new javax.swing.JLabel();
        exitDeleteVehicle = new javax.swing.JLabel();
        enterAdd = new javax.swing.JLabel();
        enterDelete = new javax.swing.JLabel();
        enterVehicleDetails = new javax.swing.JLabel();
        enterClearAll = new javax.swing.JLabel();
        enterUpdateVehicle = new javax.swing.JLabel();
        enterUpdateCustomer = new javax.swing.JLabel();
        enterDeleteVehicle = new javax.swing.JLabel();
        enterDeleteCustomer = new javax.swing.JLabel();
        buttonAdd = new javax.swing.JLabel();
        buttonDelete = new javax.swing.JLabel();
        buttonClear = new javax.swing.JLabel();
        buttonUpdateCustomer = new javax.swing.JLabel();
        buttonUpdateVehicle = new javax.swing.JLabel();
        buttonDeleteVehicle = new javax.swing.JLabel();
        buttonDeleteCustomer = new javax.swing.JLabel();
        buttonVehicleDetails = new javax.swing.JLabel();
        labelCustomerVehicle = new javax.swing.JLabel();
        labelCustomer = new javax.swing.JLabel();
        labelVehicle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbVehicleBrand = new javax.swing.JComboBox<>();
        cmbVehicleModel = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1920, 860));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel1.setText("Email");
        add(jLabel1);
        jLabel1.setBounds(1190, 170, 90, 40);

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel3.setText("Customer Address");
        add(jLabel3);
        jLabel3.setBounds(1190, 70, 170, 40);

        jLabel4.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel4.setText("Telephone");
        add(jLabel4);
        jLabel4.setBounds(1190, 120, 110, 40);

        jLabel6.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel6.setText("Vehicle No");
        add(jLabel6);
        jLabel6.setBounds(270, 20, 100, 40);

        jLabel7.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel7.setText("Vehicle Model");
        add(jLabel7);
        jLabel7.setBounds(270, 70, 130, 40);

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Address", "Telephone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.getTableHeader().setReorderingAllowed(false);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        tblCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCustomerKeyPressed(evt);
            }
        });
        paneCustomer.setViewportView(tblCustomer);
        if (tblCustomer.getColumnModel().getColumnCount() > 0) {
            tblCustomer.getColumnModel().getColumn(0).setResizable(false);
            tblCustomer.getColumnModel().getColumn(1).setResizable(false);
            tblCustomer.getColumnModel().getColumn(2).setResizable(false);
            tblCustomer.getColumnModel().getColumn(3).setResizable(false);
        }

        add(paneCustomer);
        paneCustomer.setBounds(260, 600, 1630, 290);

        txtCustomerName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCustomerNameMouseClicked(evt);
            }
        });
        txtCustomerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCustomerNameKeyReleased(evt);
            }
        });
        add(txtCustomerName);
        txtCustomerName.setBounds(1360, 20, 430, 40);
        add(txtCustomerAddress);
        txtCustomerAddress.setBounds(1360, 70, 430, 40);

        txtTelephone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelephoneMouseClicked(evt);
            }
        });
        txtTelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelephoneKeyReleased(evt);
            }
        });
        add(txtTelephone);
        txtTelephone.setBounds(1360, 120, 430, 40);

        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        add(txtEmail);
        txtEmail.setBounds(1360, 170, 430, 40);

        txtVehicleNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVehicleNoMouseClicked(evt);
            }
        });
        txtVehicleNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehicleNoActionPerformed(evt);
            }
        });
        txtVehicleNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVehicleNoKeyReleased(evt);
            }
        });
        add(txtVehicleNo);
        txtVehicleNo.setBounds(400, 20, 570, 40);

        tblVehicle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehicle No", "Vehicle Brand", "Vehicle Model"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehicle.getTableHeader().setReorderingAllowed(false);
        tblVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehicleMouseClicked(evt);
            }
        });
        tblVehicle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVehicleKeyPressed(evt);
            }
        });
        paneVehicle.setViewportView(tblVehicle);
        if (tblVehicle.getColumnModel().getColumnCount() > 0) {
            tblVehicle.getColumnModel().getColumn(0).setResizable(false);
            tblVehicle.getColumnModel().getColumn(1).setResizable(false);
            tblVehicle.getColumnModel().getColumn(2).setResizable(false);
        }

        add(paneVehicle);
        paneVehicle.setBounds(260, 270, 1630, 290);

        jLabel11.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel11.setText("Customer Name");
        add(jLabel11);
        jLabel11.setBounds(1190, 20, 160, 40);

        radioCustomer.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCustomerVehicle.add(radioCustomer);
        radioCustomer.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        radioCustomer.setMnemonic('c');
        radioCustomer.setText("Search By Customer");
        add(radioCustomer);
        radioCustomer.setBounds(280, 200, 230, 31);

        radioVehicle.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupCustomerVehicle.add(radioVehicle);
        radioVehicle.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        radioVehicle.setMnemonic('v');
        radioVehicle.setSelected(true);
        radioVehicle.setText("Search By Vehicle");
        add(radioVehicle);
        radioVehicle.setBounds(280, 150, 210, 31);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setLayout(null);

        exitAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Add Property_52px.png"))); // NOI18N
        jPanel1.add(exitAdd);
        exitAdd.setBounds(10, 40, 60, 90);

        exitDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(exitDeleteCustomer);
        exitDeleteCustomer.setBounds(10, 830, 60, 90);

        exitDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(exitDelete);
        exitDelete.setBounds(10, 130, 60, 90);

        exitVehicleDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Show Property_52px.png"))); // NOI18N
        jPanel1.add(exitVehicleDetails);
        exitVehicleDetails.setBounds(10, 220, 60, 90);

        exitClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(exitClearAll);
        exitClearAll.setBounds(10, 310, 60, 90);

        exitUpdateVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Edit Property_52px.png"))); // NOI18N
        jPanel1.add(exitUpdateVehicle);
        exitUpdateVehicle.setBounds(10, 480, 60, 90);

        exitUpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Edit Property_52px.png"))); // NOI18N
        jPanel1.add(exitUpdateCustomer);
        exitUpdateCustomer.setBounds(10, 740, 60, 90);

        exitDeleteVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(exitDeleteVehicle);
        exitDeleteVehicle.setBounds(10, 570, 60, 90);

        enterAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Add Property_52px.png"))); // NOI18N
        jPanel1.add(enterAdd);
        enterAdd.setBounds(10, 40, 60, 90);

        enterDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(enterDelete);
        enterDelete.setBounds(10, 130, 60, 90);

        enterVehicleDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Show Property_52px.png"))); // NOI18N
        jPanel1.add(enterVehicleDetails);
        enterVehicleDetails.setBounds(10, 220, 60, 90);

        enterClearAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(enterClearAll);
        enterClearAll.setBounds(10, 310, 60, 90);

        enterUpdateVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Edit Property_52px.png"))); // NOI18N
        jPanel1.add(enterUpdateVehicle);
        enterUpdateVehicle.setBounds(10, 480, 60, 90);

        enterUpdateCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Edit Property_52px.png"))); // NOI18N
        jPanel1.add(enterUpdateCustomer);
        enterUpdateCustomer.setBounds(10, 740, 60, 90);

        enterDeleteVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(enterDeleteVehicle);
        enterDeleteVehicle.setBounds(10, 570, 60, 90);

        enterDeleteCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Delete Property_52px.png"))); // NOI18N
        jPanel1.add(enterDeleteCustomer);
        enterDeleteCustomer.setBounds(10, 830, 60, 90);

        buttonAdd.setBackground(new java.awt.Color(58, 58, 58));
        buttonAdd.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonAdd.setForeground(new java.awt.Color(107, 107, 107));
        buttonAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAdd.setText("               Add ");
        buttonAdd.setOpaque(true);
        buttonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAddMouseExited(evt);
            }
        });
        jPanel1.add(buttonAdd);
        buttonAdd.setBounds(0, 40, 230, 90);

        buttonDelete.setBackground(new java.awt.Color(58, 58, 58));
        buttonDelete.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(107, 107, 107));
        buttonDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDelete.setText("               Delete");
        buttonDelete.setOpaque(true);
        buttonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonDeleteMouseExited(evt);
            }
        });
        jPanel1.add(buttonDelete);
        buttonDelete.setBounds(0, 130, 230, 90);

        buttonClear.setBackground(new java.awt.Color(58, 58, 58));
        buttonClear.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonClear.setForeground(new java.awt.Color(107, 107, 107));
        buttonClear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonClear.setText("               Clear All");
        buttonClear.setOpaque(true);
        buttonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonClearMouseExited(evt);
            }
        });
        jPanel1.add(buttonClear);
        buttonClear.setBounds(0, 310, 230, 90);

        buttonUpdateCustomer.setBackground(new java.awt.Color(58, 58, 58));
        buttonUpdateCustomer.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonUpdateCustomer.setForeground(new java.awt.Color(107, 107, 107));
        buttonUpdateCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonUpdateCustomer.setText("               Update");
        buttonUpdateCustomer.setOpaque(true);
        buttonUpdateCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonUpdateCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonUpdateCustomerMouseExited(evt);
            }
        });
        jPanel1.add(buttonUpdateCustomer);
        buttonUpdateCustomer.setBounds(0, 740, 230, 90);

        buttonUpdateVehicle.setBackground(new java.awt.Color(58, 58, 58));
        buttonUpdateVehicle.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonUpdateVehicle.setForeground(new java.awt.Color(107, 107, 107));
        buttonUpdateVehicle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonUpdateVehicle.setText("               Update ");
        buttonUpdateVehicle.setOpaque(true);
        buttonUpdateVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateVehicleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonUpdateVehicleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonUpdateVehicleMouseExited(evt);
            }
        });
        jPanel1.add(buttonUpdateVehicle);
        buttonUpdateVehicle.setBounds(0, 480, 230, 90);

        buttonDeleteVehicle.setBackground(new java.awt.Color(58, 58, 58));
        buttonDeleteVehicle.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonDeleteVehicle.setForeground(new java.awt.Color(107, 107, 107));
        buttonDeleteVehicle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDeleteVehicle.setText("               Delete ");
        buttonDeleteVehicle.setOpaque(true);
        buttonDeleteVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDeleteVehicleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonDeleteVehicleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonDeleteVehicleMouseExited(evt);
            }
        });
        jPanel1.add(buttonDeleteVehicle);
        buttonDeleteVehicle.setBounds(0, 570, 230, 90);

        buttonDeleteCustomer.setBackground(new java.awt.Color(58, 58, 58));
        buttonDeleteCustomer.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonDeleteCustomer.setForeground(new java.awt.Color(107, 107, 107));
        buttonDeleteCustomer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDeleteCustomer.setText("               Delete ");
        buttonDeleteCustomer.setOpaque(true);
        buttonDeleteCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDeleteCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonDeleteCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonDeleteCustomerMouseExited(evt);
            }
        });
        jPanel1.add(buttonDeleteCustomer);
        buttonDeleteCustomer.setBounds(0, 830, 230, 90);

        buttonVehicleDetails.setBackground(new java.awt.Color(58, 58, 58));
        buttonVehicleDetails.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonVehicleDetails.setForeground(new java.awt.Color(107, 107, 107));
        buttonVehicleDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonVehicleDetails.setText("               Vehicle Details");
        buttonVehicleDetails.setOpaque(true);
        buttonVehicleDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonVehicleDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonVehicleDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonVehicleDetailsMouseExited(evt);
            }
        });
        jPanel1.add(buttonVehicleDetails);
        buttonVehicleDetails.setBounds(0, 220, 230, 90);

        labelCustomerVehicle.setFont(new java.awt.Font("Neuropol X Rg", 0, 17)); // NOI18N
        labelCustomerVehicle.setForeground(new java.awt.Color(107, 107, 107));
        labelCustomerVehicle.setText("Customer Vehicle");
        jPanel1.add(labelCustomerVehicle);
        labelCustomerVehicle.setBounds(10, 10, 210, 30);

        labelCustomer.setFont(new java.awt.Font("Neuropol X Rg", 0, 17)); // NOI18N
        labelCustomer.setForeground(new java.awt.Color(107, 107, 107));
        labelCustomer.setText("Customer");
        jPanel1.add(labelCustomer);
        labelCustomer.setBounds(10, 710, 160, 30);

        labelVehicle.setFont(new java.awt.Font("Neuropol X Rg", 0, 17)); // NOI18N
        labelVehicle.setForeground(new java.awt.Color(107, 107, 107));
        labelVehicle.setText("Vehicle");
        jPanel1.add(labelVehicle);
        labelVehicle.setBounds(10, 450, 160, 30);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 990);

        jLabel2.setFont(new java.awt.Font("Neuropol X Rg", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(107, 107, 107));
        jLabel2.setText("Customer");
        add(jLabel2);
        jLabel2.setBounds(970, 570, 290, 30);

        jLabel5.setFont(new java.awt.Font("Neuropol X Rg", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(107, 107, 107));
        jLabel5.setText("Vehicle");
        add(jLabel5);
        jLabel5.setBounds(980, 240, 260, 30);

        add(cmbVehicleBrand);
        cmbVehicleBrand.setBounds(400, 70, 280, 40);

        add(cmbVehicleModel);
        cmbVehicleModel.setBounds(690, 70, 280, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseClicked
        comboModel();
        addCustomerVehicle();
    }//GEN-LAST:event_buttonAddMouseClicked

    private void txtCustomerNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerNameKeyReleased
        searchCustomerName();
    }//GEN-LAST:event_txtCustomerNameKeyReleased

    private void txtVehicleNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleNoKeyReleased
        searchVehicleNumber();
    }//GEN-LAST:event_txtVehicleNoKeyReleased
    private void addCustomerVehicle() {
        try {
            if (!(txtCustomerName.getText().isEmpty()) && !(txtVehicleNo.getText().isEmpty()) && !(cmbVehicleBrand.getSelectedItem().equals("Select")) && !(cmbVehicleModel.getSelectedItem().equals("Select")) && !(cmbVehicleModel.getSelectedItem().equals("")) && !(cmbVehicleBrand.getSelectedItem().equals(""))) {
                if (CustomerController.getCid(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText())) == 0 && VehicleController.getVid(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid())) == 0) {
                    if (JOptionPane.showConfirmDialog(null, "Do you want to Add this Customer & Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                        customerController = CustomerController.addCustomer(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText()));
                        vehicleController = VehicleController.addVehicle(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid()));
                        if (customerController && vehicleController) {
                            if (CustomerVehicleController.addCustomerVehicle(new CustomerVehicleDetailDTO(CustomerController.getCid(), VehicleController.getVids()))) {
                                clearTableCustomer();
                                clearTableVehicle();
                                viewCustomer();
                                viewVehicle();
                                customerController = false;
                                vehicleController = false;
                            } else {
                                clearTableCustomer();
                            }
                        }
                    }
                } else if (CustomerController.getCid(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText())) > 0 && VehicleController.getVid(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid())) == 0) {
                    if (JOptionPane.showConfirmDialog(null, "Do you want to Add this Customer & Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                        vehicleController = VehicleController.addVehicle(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid()));
                        if (vehicleController) {
                            if (CustomerVehicleController.addCustomerVehicle(new CustomerVehicleDetailDTO(CustomerController.getCid(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText())), VehicleController.getVids()))) {
                                clearTableCustomer();
                                clearTableVehicle();
                                viewCustomer();
                                viewVehicle();
                                customerController = false;
                                vehicleController = false;
                            } else {
                                clearTableCustomer();
                            }
                        }
                    }
                } else if (CustomerController.getCid(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText())) == 0 && VehicleController.getVid(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid())) > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Do you want to Add this Customer & Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                        customerController = CustomerController.addCustomer(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText()));
                        if (customerController) {
                            if (CustomerVehicleController.addCustomerVehicle(new CustomerVehicleDetailDTO(CustomerController.getCid(), VehicleController.getVid(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid()))))) {
                                clearTableCustomer();
                                clearTableVehicle();
                                viewCustomer();
                                viewVehicle();
                                customerController = false;
                                vehicleController = false;
                            } else {
                                clearTableCustomer();
                            }
                        }
                    }
                } else if (CustomerController.getCid(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText())) > 0 && VehicleController.getVid(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid())) > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Do you want to Add this Customer & Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                        if (CustomerVehicleController.addCustomerVehicle(new CustomerVehicleDetailDTO(CustomerController.getCid(new CustomerDTO(txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText())), VehicleController.getVid(new VehicleDTO(txtVehicleNo.getText(), modelId().getMid()))))) {
                            clearTableCustomer();
                            clearTableVehicle();
                            viewCustomer();
                            viewVehicle();
                            customerController = false;
                            vehicleController = false;
                        } else {
                            clearTableCustomer();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please add Details or select existing Details");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        if (modelCustomer.getRowCount() > 0) {
            if (tblCustomer.getSelectedRow() > -1) {
                try {
                    x = CustomerController.getCid(giveTableCustomerDetails());
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (tblCustomer.getRowCount() > -1) {
            giveTableCustomerDetailsToText();
        }
        if (radioCustomer.isSelected()) {
            try {
                while (modelVehicle.getRowCount() != 0) {
                    modelVehicle.removeRow(0);
                }
                ArrayList<VehicleDTO> vehicleList = CustomerVehicleController.viewVehicle(CustomerController.getCid(giveTableCustomerDetails()));
                for (VehicleDTO vehicle : vehicleList) {
                    Object[] ob = {vehicle.getVehicleNo(), vehicle.getBrand(), vehicle.getModel()};
                    modelVehicle.addRow(ob);
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void tblVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehicleMouseClicked
        clickTableVehicle();
    }//GEN-LAST:event_tblVehicleMouseClicked
    private void clickTableVehicle() {
        if (modelVehicle.getRowCount() > 0) {
            if (tblVehicle.getSelectedRow() > -1) {
                try {
                    y = VehicleController.getVid(giveTableVehicleDetails());
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (tblVehicle.getRowCount() > -1) {
            giveTableVehicleDetailsToText();
        }
        if (radioVehicle.isSelected()) {
            try {
                while (modelCustomer.getRowCount() != 0) {
                    modelCustomer.removeRow(0);
                }
                ArrayList<CustomerDTO> customerList = CustomerVehicleController.viewCustomer(VehicleController.getVid(giveTableVehicleDetails()));
                for (CustomerDTO customer : customerList) {
                    Object[] ob = {customer.getName(), customer.getAddress(), customer.getTelephone(), customer.getEmail()};
                    modelCustomer.addRow(ob);
                }
                tblCustomer.setRowSelectionInterval(modelCustomer.getRowCount() - 1, modelCustomer.getRowCount() - 1);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void buttonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteMouseClicked
        if (modelCustomer.getRowCount() > 0 && modelVehicle.getRowCount() > 0) {
            if (tblCustomer.getSelectedRow() > -1 && tblVehicle.getSelectedRow() > -1) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to delete this Customer & Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                    try {
                        if (CustomerController.deleteCustomer(CustomerController.getCid(giveTableCustomerDetails())) && VehicleController.deleteVehicle(VehicleController.getVid(giveTableVehicleDetails()))) {
                            clearAll();
                        } else {
                            JOptionPane.showMessageDialog(null, "Delete Failed");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select Both Customer & Vehicle");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Search Both Customer & Vehicle");
        }
    }//GEN-LAST:event_buttonDeleteMouseClicked

    private void buttonUpdateCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCustomerMouseClicked
        try {
            if (x > 0) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to update this Customer", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                    if (CustomerController.updateCustomer(new CustomerDTO(x, txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText()))) {
                        clearTableCustomer();
                        viewCustomer();
                    } else {
                        clearTableCustomer();
                    }
                    x = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select Customer");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonUpdateCustomerMouseClicked

    private void buttonUpdateVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateVehicleMouseClicked
        try {
            if (y > 0) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to update this Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                    if (VehicleController.updateVehicle(new VehicleDTO(y, txtVehicleNo.getText(), modelId().getMid()))) {
                        clearTableVehicle();
                        viewVehicle();
                    } else {
                        clearTableVehicle();
                    }
                    y = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select Vehicle");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonUpdateVehicleMouseClicked

    private void buttonDeleteVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteVehicleMouseClicked
        if (modelVehicle.getRowCount() > 0) {
            if (tblVehicle.getSelectedRow() > -1) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to Delete this Vehicle", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                    try {
                        if (VehicleController.deleteVehicle(VehicleController.getVid(giveTableVehicleDetails()))) {
                            clearAll();
                        } else {
                            JOptionPane.showMessageDialog(null, "Delete Vehicle Failed");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a Vehicle");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Search a Vehicle");
        }
    }//GEN-LAST:event_buttonDeleteVehicleMouseClicked

    private void buttonDeleteCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteCustomerMouseClicked
        if (modelCustomer.getRowCount() > 0) {
            if (tblCustomer.getSelectedRow() > -1) {
                if (JOptionPane.showConfirmDialog(null, "Do you want to Delete this Customer", TOOL_TIP_TEXT_KEY, 0, 2) == 0) {
                    try {
                        if (CustomerController.deleteCustomer(CustomerController.getCid(giveTableCustomerDetails()))) {
                            clearAll();
                        } else {
                            JOptionPane.showMessageDialog(null, "Delete Customer Failed");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a Customer");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Search a Customer");
        }
    }//GEN-LAST:event_buttonDeleteCustomerMouseClicked

    private void txtTelephoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelephoneKeyReleased
        searchCustomerTelephone();
    }//GEN-LAST:event_txtTelephoneKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        searchCustomerEmail();
    }//GEN-LAST:event_txtEmailKeyReleased

    private void buttonClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseClicked
        clearText();
        clearTableCustomer();
        clearTableVehicle();
        x = 0;
        y = 0;
    }//GEN-LAST:event_buttonClearMouseClicked

    private void buttonVehicleDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVehicleDetailsMouseClicked
        searchVehileDetails();
    }//GEN-LAST:event_buttonVehicleDetailsMouseClicked
    private void searchVehileDetails() {
        if (tblCustomer.getSelectedRow() > -1 && tblVehicle.getSelectedRow() > -1) {
            try {
                cvid = CustomerVehicleController.getCvid(CustomerController.getCid(giveTableCustomerDetails()), VehicleController.getVid(giveTableVehicleDetails()));
                MainPanel.managePanelsForVehicleInformation();
                MainPanel.getVehicleInformationPanel().setData();
            } catch (SQLException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select Both Customer & Vehicle", TOOL_TIP_TEXT_KEY, 2);
        }
        MainPanel.getMainPanel().selectButton();
    }
    private void buttonDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteMouseEntered
        buttonDelete.setBackground(new Color(48, 48, 48));
        buttonDelete.setForeground(new Color(255, 191, 5));
        enterDelete.setVisible(true);
        exitDelete.setVisible(false);
    }//GEN-LAST:event_buttonDeleteMouseEntered

    private void buttonVehicleDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVehicleDetailsMouseEntered
        buttonVehicleDetails.setBackground(new Color(48, 48, 48));
        buttonVehicleDetails.setForeground(new Color(255, 191, 5));
        enterVehicleDetails.setVisible(true);
        exitVehicleDetails.setVisible(false);
    }//GEN-LAST:event_buttonVehicleDetailsMouseEntered

    private void buttonClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseEntered
        buttonClear.setBackground(new Color(48, 48, 48));
        buttonClear.setForeground(new Color(255, 191, 5));
        enterClearAll.setVisible(true);
        exitClearAll.setVisible(false);
    }//GEN-LAST:event_buttonClearMouseEntered

    private void buttonUpdateVehicleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateVehicleMouseEntered
        buttonUpdateVehicle.setBackground(new Color(48, 48, 48));
        buttonUpdateVehicle.setForeground(new Color(255, 191, 5));
        enterUpdateVehicle.setVisible(true);
        exitUpdateVehicle.setVisible(false);
    }//GEN-LAST:event_buttonUpdateVehicleMouseEntered

    private void buttonUpdateCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCustomerMouseEntered
        buttonUpdateCustomer.setBackground(new Color(48, 48, 48));
        buttonUpdateCustomer.setForeground(new Color(255, 191, 5));
        enterUpdateCustomer.setVisible(true);
        exitUpdateCustomer.setVisible(false);
    }//GEN-LAST:event_buttonUpdateCustomerMouseEntered

    private void buttonDeleteVehicleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteVehicleMouseEntered
        buttonDeleteVehicle.setBackground(new Color(48, 48, 48));
        buttonDeleteVehicle.setForeground(new Color(255, 191, 5));
        enterDeleteVehicle.setVisible(true);
        exitDeleteVehicle.setVisible(false);
    }//GEN-LAST:event_buttonDeleteVehicleMouseEntered

    private void buttonDeleteCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteCustomerMouseEntered
        buttonDeleteCustomer.setBackground(new Color(48, 48, 48));
        buttonDeleteCustomer.setForeground(new Color(255, 191, 5));
        enterDeleteCustomer.setVisible(true);
        exitDeleteCustomer.setVisible(false);
    }//GEN-LAST:event_buttonDeleteCustomerMouseEntered

    private void buttonAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseExited
        buttonAdd.setBackground(new Color(58, 58, 58));
        buttonAdd.setForeground(new Color(107, 107, 107));
        enterAdd.setVisible(false);
        exitAdd.setVisible(true);
    }//GEN-LAST:event_buttonAddMouseExited

    private void buttonAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddMouseEntered
        buttonAdd.setBackground(new Color(48, 48, 48));
        buttonAdd.setForeground(new Color(255, 191, 5));
        enterAdd.setVisible(true);
        exitAdd.setVisible(false);
    }//GEN-LAST:event_buttonAddMouseEntered

    private void buttonDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteMouseExited
        buttonDelete.setBackground(new Color(58, 58, 58));
        buttonDelete.setForeground(new Color(107, 107, 107));
        enterDelete.setVisible(false);
        exitDelete.setVisible(true);
    }//GEN-LAST:event_buttonDeleteMouseExited

    private void buttonVehicleDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVehicleDetailsMouseExited
        buttonVehicleDetails.setBackground(new Color(58, 58, 58));
        buttonVehicleDetails.setForeground(new Color(107, 107, 107));
        enterVehicleDetails.setVisible(false);
        exitVehicleDetails.setVisible(true);
    }//GEN-LAST:event_buttonVehicleDetailsMouseExited

    private void buttonClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClearMouseExited
        buttonClear.setBackground(new Color(58, 58, 58));
        buttonClear.setForeground(new Color(107, 107, 107));
        enterClearAll.setVisible(false);
        exitClearAll.setVisible(true);
    }//GEN-LAST:event_buttonClearMouseExited

    private void buttonUpdateVehicleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateVehicleMouseExited
        buttonUpdateVehicle.setBackground(new Color(58, 58, 58));
        buttonUpdateVehicle.setForeground(new Color(107, 107, 107));
        enterUpdateVehicle.setVisible(false);
        exitUpdateVehicle.setVisible(true);
    }//GEN-LAST:event_buttonUpdateVehicleMouseExited

    private void buttonUpdateCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateCustomerMouseExited
        buttonUpdateCustomer.setBackground(new Color(58, 58, 58));
        buttonUpdateCustomer.setForeground(new Color(107, 107, 107));
        enterUpdateCustomer.setVisible(false);
        exitUpdateCustomer.setVisible(true);
    }//GEN-LAST:event_buttonUpdateCustomerMouseExited

    private void buttonDeleteVehicleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteVehicleMouseExited
        buttonDeleteVehicle.setBackground(new Color(58, 58, 58));
        buttonDeleteVehicle.setForeground(new Color(107, 107, 107));
        enterDeleteVehicle.setVisible(false);
        exitDeleteVehicle.setVisible(true);
    }//GEN-LAST:event_buttonDeleteVehicleMouseExited

    private void buttonDeleteCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteCustomerMouseExited
        buttonDeleteCustomer.setBackground(new Color(58, 58, 58));
        buttonDeleteCustomer.setForeground(new Color(107, 107, 107));
        enterDeleteCustomer.setVisible(false);
        exitDeleteCustomer.setVisible(true);
    }//GEN-LAST:event_buttonDeleteCustomerMouseExited

    private void txtVehicleNoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVehicleNoMouseClicked
        searchVehicleNumber();
    }//GEN-LAST:event_txtVehicleNoMouseClicked

    private void txtCustomerNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCustomerNameMouseClicked
        searchCustomerName();
    }//GEN-LAST:event_txtCustomerNameMouseClicked

    private void txtTelephoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelephoneMouseClicked
        searchCustomerTelephone();
    }//GEN-LAST:event_txtTelephoneMouseClicked

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        searchCustomerEmail();
    }//GEN-LAST:event_txtEmailMouseClicked

    private void tblVehicleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVehicleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            clickTableVehicle();
            tblCustomer.requestFocus();
            evt.consume();
        }
    }//GEN-LAST:event_tblVehicleKeyPressed

    private void tblCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCustomerKeyPressed
        if (tblCustomer.getSelectedRow() > -1 && tblVehicle.getSelectedRow() > -1) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                searchVehileDetails();
                evt.consume();
            }
        }
    }//GEN-LAST:event_tblCustomerKeyPressed

    private void txtVehicleNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehicleNoActionPerformed
        tblVehicle.requestFocus();
    }//GEN-LAST:event_txtVehicleNoActionPerformed
    
    private VehicleDTO giveTableVehicleDetails() {
        try {
            BrandDTO brandDTO = BrandController.getBrandId(new BrandDTO(tblVehicle.getValueAt(tblVehicle.getSelectedRow(), 1).toString()));
            ModelDTO modelDTO = ModelController.getMid(new ModelDTO(brandDTO.getBrandid(), tblVehicle.getValueAt(tblVehicle.getSelectedRow(), 2).toString()));
            return new VehicleDTO(tblVehicle.getValueAt(tblVehicle.getSelectedRow(), 0).toString(), modelDTO.getMid());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private CustomerDTO giveTableCustomerDetails() {
        return new CustomerDTO(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString(), tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 1).toString(), tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 2).toString(), tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 3).toString());
    }
    
    private void giveTableVehicleDetailsToText() {
        txtVehicleNo.setText(tblVehicle.getValueAt(tblVehicle.getSelectedRow(), 0).toString());
        cmbVehicleBrand.setSelectedItem(tblVehicle.getValueAt(tblVehicle.getSelectedRow(), 1).toString());
        cmbVehicleModel.setSelectedItem(tblVehicle.getValueAt(tblVehicle.getSelectedRow(), 2).toString());
    }
    
    private void giveTableCustomerDetailsToText() {
        txtCustomerName.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 0).toString());
        txtCustomerAddress.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 1).toString());
        txtTelephone.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 2).toString());
        txtEmail.setText(tblCustomer.getValueAt(tblCustomer.getSelectedRow(), 3).toString());
    }
    
    private void searchCustomerName() {
        try {
            ArrayList<CustomerDTO> customerList;
            if (txtCustomerName.getText().isEmpty()) {
                customerList = CustomerController.searchCustomerData(" ");
            } else {
                customerList = CustomerController.searchCustomerData(txtCustomerName.getText());
            }
            while (modelCustomer.getRowCount() != 0) {
                modelCustomer.removeRow(0);
            }
            if (radioCustomer.isSelected()) {
                while (modelVehicle.getRowCount() != 0) {
                    modelVehicle.removeRow(0);
                }
            }
            for (CustomerDTO customer : customerList) {
                Object[] ob = {customer.getName(), customer.getAddress(), customer.getTelephone(), customer.getEmail()};
                modelCustomer.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchVehicleNumber() {
        try {
            ArrayList<VehicleDTO> vehicleList;
            if (txtVehicleNo.getText().isEmpty()) {
                vehicleList = VehicleController.searchVehicle(new VehicleDTO(" "));
            } else {
                vehicleList = VehicleController.searchVehicle(new VehicleDTO(txtVehicleNo.getText()));
            }
            while (modelVehicle.getRowCount() != 0) {
                modelVehicle.removeRow(0);
            }
            if (radioVehicle.isSelected()) {
                while (modelCustomer.getRowCount() != 0) {
                    modelCustomer.removeRow(0);
                }
            }
            for (VehicleDTO vehicle : vehicleList) {
                Object[] ob = {vehicle.getVehicleNo(), vehicle.getBrand(), vehicle.getModel()};
                modelVehicle.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchCustomerTelephone() {
        try {
            ArrayList<CustomerDTO> customerList;
            if (txtTelephone.getText().isEmpty()) {
                customerList = CustomerController.searchCustomerData(" ");
            } else {
                customerList = CustomerController.searchCustomerData(txtTelephone.getText());
            }
            while (modelCustomer.getRowCount() != 0) {
                modelCustomer.removeRow(0);
            }
            if (radioCustomer.isSelected()) {
                while (modelVehicle.getRowCount() != 0) {
                    modelVehicle.removeRow(0);
                }
            }
            for (CustomerDTO customer : customerList) {
                Object[] ob = {customer.getName(), customer.getAddress(), customer.getTelephone(), customer.getEmail()};
                modelCustomer.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchCustomerEmail() {
        try {
            ArrayList<CustomerDTO> customerList;
            if (txtEmail.getText().isEmpty()) {
                customerList = CustomerController.searchCustomerData(" ");
            } else {
                customerList = CustomerController.searchCustomerData(txtEmail.getText());
            }
            clearTableCustomer();
            if (radioCustomer.isSelected()) {
                clearTableVehicle();
            }
            for (CustomerDTO customer : customerList) {
                Object[] ob = {customer.getName(), customer.getAddress(), customer.getTelephone(), customer.getEmail()};
                modelCustomer.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void searchVehicleModel() {
        try {
            ArrayList<VehicleDTO> vehicleList;
            if (cmbVehicleBrand.getSelectedItem().toString().isEmpty()) {
                vehicleList = VehicleController.searchVehicle(new VehicleDTO(" "));
            } else {
                vehicleList = VehicleController.searchVehicle(new VehicleDTO(cmbVehicleBrand.getSelectedItem().toString()));
            }
            clearTableVehicle();
            if (radioVehicle.isSelected()) {
                clearTableCustomer();
            }
            for (VehicleDTO vehicle : vehicleList) {
                Object[] ob = {vehicle.getVehicleNo(), vehicle.getVehicleModel()};
                modelVehicle.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void visibleFalse() {
        buttonDeleteCustomer.setVisible(false);
        buttonDeleteVehicle.setVisible(false);
    }
    
    public void visibleTrue() {
        buttonDeleteCustomer.setVisible(true);
        buttonDeleteVehicle.setVisible(true);
    }
    
    private void clearTableCustomer() {
        while (modelCustomer.getRowCount() != 0) {
            modelCustomer.removeRow(0);
        }
    }
    
    private void clearTableVehicle() {
        while (modelVehicle.getRowCount() != 0) {
            modelVehicle.removeRow(0);
        }
    }
    
    private void viewCustomer() {
        Object[] ob = {txtCustomerName.getText(), txtCustomerAddress.getText(), txtTelephone.getText(), txtEmail.getText()};
        modelCustomer.addRow(ob);
    }
    
    private void viewVehicle() {
        Object[] ob = {txtVehicleNo.getText(), cmbVehicleBrand.getSelectedItem().toString(), cmbVehicleModel.getSelectedItem().toString()};
        modelVehicle.addRow(ob);
    }
    
    private void customizeVehicleTable() {
        tblVehicle.setDefaultRenderer(Object.class, new CustomizeTable());
        tblVehicle.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblVehicle.setRowHeight(30);
        tblVehicle.setShowGrid(true);
        tblVehicle.setFont(new Font("", 0, 20));
        tblVehicle.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblVehicle.getColumnModel().getColumn(1).setPreferredWidth(500);
        paneVehicle.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizeCustomerTable() {
        tblCustomer.setDefaultRenderer(Object.class, new CustomizeTable());
        tblCustomer.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblCustomer.setRowHeight(30);
        tblCustomer.setShowGrid(true);
        tblCustomer.setFont(new Font("", 0, 20));
        tblCustomer.getColumnModel().getColumn(0).setPreferredWidth(400);
        tblCustomer.getColumnModel().getColumn(1).setPreferredWidth(400);
        tblCustomer.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblCustomer.getColumnModel().getColumn(3).setPreferredWidth(400);
        tblCustomer.getTableHeader().setBackground(Color.red);
        paneCustomer.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizeText() {
        txtCustomerName.setFont(new Font("", 0, 18));
        txtCustomerAddress.setFont(new Font("", 0, 18));
        txtTelephone.setFont(new Font("", 0, 18));
        txtEmail.setFont(new Font("", 0, 18));
        txtVehicleNo.setFont(new Font("", 0, 18));
        
    }
    
    public int giveTableSelection() throws ClassNotFoundException, SQLException {
        if (tblCustomer.getSelectedRow() > -1 && tblVehicle.getSelectedRow() > -1) {
            return CustomerVehicleController.getCvid(CustomerController.getCid(giveTableCustomerDetails()), VehicleController.getVid(giveTableVehicleDetails()));
        } else {
            return 0;
        }
    }
    
    public int getCvid() {
        return cvid;
    }
    
    public void setCvid() {
        cvid = 0;
    }
    
    public void setData(String id) {
        try {
            CustomerVehicleDetailDTO customerVehicleDetailDTO = InvoiceController.getCvid(new InvoiceDTO(id));
            VehicleDTO vehicleDTO = VehicleController.giveVehicleData(new VehicleDTO(customerVehicleDetailDTO.getVid()));
            CustomerDTO customerDTO = CustomerController.giveCustomerData(new CustomerDTO(customerVehicleDetailDTO.getCid()));
            txtCustomerName.setText(customerDTO.getName());
            txtCustomerAddress.setText(customerDTO.getAddress());
            txtTelephone.setText(customerDTO.getTelephone());
            txtEmail.setText(customerDTO.getEmail());
            txtVehicleNo.setText(vehicleDTO.getVehicleNo());
            cmbVehicleBrand.setSelectedItem(vehicleDTO.getBrand());
            cmbVehicleModel.setSelectedItem(vehicleDTO.getModel());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] getTextVehicleNo() {
        String[] s = {txtVehicleNo.getText(), cmbVehicleBrand.getSelectedItem().toString(), cmbVehicleModel.getSelectedItem().toString()};
        return s;
    }
    
    private void clearText() {
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtTelephone.setText("");
        txtEmail.setText("");
        txtVehicleNo.setText("");
        cmbVehicleBrand.setSelectedItem("Select");
        cmbVehicleModel.setSelectedItem("Select");
    }
    
    private void clearAll() {
        clearText();
        clearTableCustomer();
        clearTableVehicle();
    }
    
    private void hideIcons() {
        enterAdd.setVisible(false);
        enterClearAll.setVisible(false);
        enterDelete.setVisible(false);
        enterDeleteCustomer.setVisible(false);
        enterDeleteVehicle.setVisible(false);
        enterUpdateCustomer.setVisible(false);
        enterUpdateVehicle.setVisible(false);
        enterVehicleDetails.setVisible(false);
    }
    
    private void editorComboBrand() {
        cmbVehicleBrand.setEditable(true);
        cmbVehicleBrand.setBackground(Color.WHITE);
        cmbVehicleBrand.setFont(new Font("", 0, 18));
        cmbVehicleBrand.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    comboBrand();
                }
            }
            
        });
    }
    
    private void comboBrand() {
        if (!(cmbVehicleBrand.getSelectedItem().equals("Select")) && !(cmbVehicleBrand.getSelectedItem().equals(""))) {
            try {
                BrandDTO brandDTO = BrandController.getBrandId(new BrandDTO(cmbVehicleBrand.getSelectedItem().toString()));
                if (brandDTO != null && cmbVehicleBrand.getSelectedIndex() > -1) {
                    
                } else if (cmbVehicleBrand.getSelectedIndex() == -1 && !(cmbVehicleBrand.getSelectedItem().equals(""))) {
                    BrandController.addBrand(cmbVehicleBrand.getSelectedItem().toString());
                    loadComboBrand();
                }
                loadComboModel();
                cmbVehicleModel.setSelectedItem("Select");
                cmbVehicleModel.requestFocus();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void editorComboModel() {
        cmbVehicleModel.setEditable(true);
        cmbVehicleModel.setBackground(Color.WHITE);
        cmbVehicleModel.setFont(new Font("", 0, 18));
        cmbVehicleModel.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    comboModel();
                }
            }
            
        });
    }
    
    private void comboModel() {
        if (!(cmbVehicleModel.getSelectedItem().equals("Select")) && !(cmbVehicleModel.getSelectedItem().equals(""))) {
            if (modelId() != null && cmbVehicleModel.getSelectedIndex() > -1) {
                
            } else if (cmbVehicleModel.getSelectedIndex() == -1 && !(cmbVehicleModel.getSelectedItem().equals(""))) {
                try {
                    ModelController.addModel(cmbVehicleModel.getSelectedItem().toString(), brandId().getBrandid());
                    loadComboModel();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private ModelDTO modelId() {
        try {
            ModelDTO modelDTO = ModelController.getMid(new ModelDTO(brandId().getBrandid(), cmbVehicleModel.getSelectedItem().toString()));
            return modelDTO;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private BrandDTO brandId() {
        try {
            BrandDTO brandDTO = BrandController.getBrandId(new BrandDTO(cmbVehicleBrand.getSelectedItem().toString()));
            return brandDTO;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void loadComboBrand() {
        try {
            ArrayList<BrandDTO> brandList = BrandController.getAllBrands();
            cmbVehicleBrand.removeAllItems();
            cmbVehicleBrand.addItem("Select");
            cmbVehicleModel.addItem("Select");
            cmbVehicleModel.setSelectedItem("Select");
            for (BrandDTO brandDTO : brandList) {
                cmbVehicleBrand.addItem(brandDTO.getBrandName());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadComboModel() {
        try {
            ArrayList<ModelDTO> modelList = ModelController.getModels(brandId().getBrandid());
            cmbVehicleModel.removeAllItems();
            cmbVehicleModel.addItem("Select");
            if (modelList != null) {
                for (ModelDTO modelDTO : modelList) {
                    cmbVehicleModel.addItem(modelDTO.getModelName());
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonAdd;
    private javax.swing.JLabel buttonClear;
    private javax.swing.JLabel buttonDelete;
    private javax.swing.JLabel buttonDeleteCustomer;
    private javax.swing.JLabel buttonDeleteVehicle;
    private javax.swing.ButtonGroup buttonGroupCustomerVehicle;
    private javax.swing.JLabel buttonUpdateCustomer;
    private javax.swing.JLabel buttonUpdateVehicle;
    private javax.swing.JLabel buttonVehicleDetails;
    private javax.swing.JComboBox<String> cmbVehicleBrand;
    private javax.swing.JComboBox<String> cmbVehicleModel;
    private javax.swing.JLabel enterAdd;
    private javax.swing.JLabel enterClearAll;
    private javax.swing.JLabel enterDelete;
    private javax.swing.JLabel enterDeleteCustomer;
    private javax.swing.JLabel enterDeleteVehicle;
    private javax.swing.JLabel enterUpdateCustomer;
    private javax.swing.JLabel enterUpdateVehicle;
    private javax.swing.JLabel enterVehicleDetails;
    private javax.swing.JLabel exitAdd;
    private javax.swing.JLabel exitClearAll;
    private javax.swing.JLabel exitDelete;
    private javax.swing.JLabel exitDeleteCustomer;
    private javax.swing.JLabel exitDeleteVehicle;
    private javax.swing.JLabel exitUpdateCustomer;
    private javax.swing.JLabel exitUpdateVehicle;
    private javax.swing.JLabel exitVehicleDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelCustomer;
    private javax.swing.JLabel labelCustomerVehicle;
    private javax.swing.JLabel labelVehicle;
    private javax.swing.JScrollPane paneCustomer;
    private javax.swing.JScrollPane paneVehicle;
    private javax.swing.JRadioButton radioCustomer;
    private javax.swing.JRadioButton radioVehicle;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTable tblVehicle;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtVehicleNo;
    // End of variables declaration//GEN-END:variables
}
