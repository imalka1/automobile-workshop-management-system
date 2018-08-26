package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.controller.SymptomDescriptionDetailController;
import edu.ijse.automobile_workshop_management_system.controller.EmployeeController;
import edu.ijse.automobile_workshop_management_system.controller.EmployeeInvoiceDetailController;
import edu.ijse.automobile_workshop_management_system.controller.InvoiceController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceDescriptionDetailController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceDetailController;
import edu.ijse.automobile_workshop_management_system.controller.RepairInvoiceDescriptionDetailController;
import edu.ijse.automobile_workshop_management_system.controller.RepairSectionController;
import edu.ijse.automobile_workshop_management_system.controller.VehicleController;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.EmployeeDTO;
import edu.ijse.automobile_workshop_management_system.model.EmployeeInvoiceDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.InvoiceDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.RepairInvoiceDescriptionDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDetailDTO;
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

public class VehicleInformationPanel extends javax.swing.JPanel {
    
    private boolean firstIsSelected = false;
    private boolean secondIsSelected = false;
    private DefaultTableModel modelInvoice;
    private DefaultTableModel modelRepair;
    private DefaultTableModel modelSymptom;
    private DefaultTableModel modelEmployee;
    private int count = 0;
    private int hold = 0;
    private int holdNew = 0;
    private int invoiceId = 0;
    
    public VehicleInformationPanel() {
        initComponents();
        customizeInvoiceTable();
        customizeRepairTable();
        customizeSymptomTable();
        customizeEmployeeTable();
        customizePaymentTable();
        loadSectionCombo();
        loadInvoiceCombo();
        loadEmployeeCombo();
        loadVehicleNoCombo();
        hideIcons();
        //loadEmployeeSection();
        modelInvoice = (DefaultTableModel) tableInvoice.getModel();
        modelEmployee = (DefaultTableModel) tableEmployee.getModel();
        modelRepair = (DefaultTableModel) tableRepair.getModel();
        modelSymptom = (DefaultTableModel) tableSymptom.getModel();
        comboBoxYearOrMonth.setFont(new Font("", 0, 18));
        panelInvoiceButtons.setVisible(true);
        panelInvoice.setVisible(true);
        panelPayment.setVisible(false);
        panelPaymentButtons.setVisible(false);
        firstIsSelected = true;
        buttonInvoice.setForeground(new Color(255, 191, 5));
        enterInvoice.setVisible(true);
        exitInvoice.setVisible(false);
        cmbBoxEmployee.setBackground(Color.WHITE);
        cmbBoxSection.setBackground(Color.WHITE);
        comboBoxYearOrMonth.setBackground(Color.WHITE);
        comboBoxPayment.setBackground(Color.WHITE);
        cmbInvoiceNumber.setBackground(Color.WHITE);
        cmbVehicleNo.setBackground(Color.WHITE);
        textMeterReading.setText("0");
        textNextService.setText("0");
        lblAmount.setText("0");
        textDiscount.setText("0");
        cmbInvoiceNumber.requestFocus();
        textMeterReading.setFont(new Font("", 0, 18));
        textNextService.setFont(new Font("", 0, 18));
        textDiscount.setFont(new Font("", 0, 18));
        textPaidAmount.setFont(new Font("", 0, 18));
        editorComboEmployee();
        editorComboSection();
        editorComboVehicle();
        editorComboInvoiceNumber();
        AutoCompleteDecorator.decorate(cmbBoxSection);
        AutoCompleteDecorator.decorate(cmbInvoiceNumber);
        AutoCompleteDecorator.decorate(cmbBoxEmployee);
        AutoCompleteDecorator.decorate(cmbVehicleNo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButtons = new javax.swing.JPanel();
        exitPayment = new javax.swing.JLabel();
        exitInvoice = new javax.swing.JLabel();
        enterPayment = new javax.swing.JLabel();
        enterInvoice = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonInvoice = new javax.swing.JLabel();
        buttonPayment = new javax.swing.JLabel();
        panelInvoiceButtons = new javax.swing.JPanel();
        labelCustomer = new javax.swing.JLabel();
        labelCustomer1 = new javax.swing.JLabel();
        labelCustomer2 = new javax.swing.JLabel();
        exitNewInvoice = new javax.swing.JLabel();
        exitAddEmployee = new javax.swing.JLabel();
        exitDeleteInvoice = new javax.swing.JLabel();
        exitAddInvoice = new javax.swing.JLabel();
        exitUpdateInvoice = new javax.swing.JLabel();
        exitUpdateEmployee = new javax.swing.JLabel();
        exitDeleteEmployee = new javax.swing.JLabel();
        exitUpdateDescription = new javax.swing.JLabel();
        enterNewInvoice = new javax.swing.JLabel();
        enterAddEmployee = new javax.swing.JLabel();
        enterAddInvoice = new javax.swing.JLabel();
        enterUpdateInvoice = new javax.swing.JLabel();
        enterDeleteInvoice = new javax.swing.JLabel();
        enterUpdateEmployee = new javax.swing.JLabel();
        enterDeleteEmployee = new javax.swing.JLabel();
        enterUpdateDescription = new javax.swing.JLabel();
        buttonNewInvoice = new javax.swing.JLabel();
        buttonAddInvoice = new javax.swing.JLabel();
        buttonUpdateInvoice = new javax.swing.JLabel();
        buttonDeleteInvoice = new javax.swing.JLabel();
        buttonAddEmployee = new javax.swing.JLabel();
        buttonUpdateEmployee = new javax.swing.JLabel();
        buttonDeleteEmployee = new javax.swing.JLabel();
        buttonCustomerDetails = new javax.swing.JLabel();
        panelPaymentButtons = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        panelInvoice = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textMeterReading = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbBoxSection = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        textNextService = new javax.swing.JTextField();
        comboBoxYearOrMonth = new javax.swing.JComboBox();
        paneInvoice = new javax.swing.JScrollPane();
        tableInvoice = new javax.swing.JTable();
        paneSymptom = new javax.swing.JScrollPane();
        tableSymptom = new javax.swing.JTable();
        paneRepair = new javax.swing.JScrollPane();
        tableRepair = new javax.swing.JTable();
        paneEmployee = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        cmbBoxEmployee = new javax.swing.JComboBox();
        cmbInvoiceNumber = new javax.swing.JComboBox<>();
        cmbVehicleNo = new javax.swing.JComboBox<>();
        lblVehicle = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelPayment = new javax.swing.JPanel();
        panePayment = new javax.swing.JScrollPane();
        tablePayment = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        textPaidAmount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        comboBoxPayment = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtChequeNo = new javax.swing.JTextField();
        textDiscount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(null);

        panelButtons.setBackground(new java.awt.Color(58, 58, 58));
        panelButtons.setLayout(null);

        exitPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Right2_48px.png"))); // NOI18N
        panelButtons.add(exitPayment);
        exitPayment.setBounds(170, 60, 60, 60);

        exitInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Right2_48px.png"))); // NOI18N
        panelButtons.add(exitInvoice);
        exitInvoice.setBounds(170, 0, 60, 60);

        enterPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Right_48px.png"))); // NOI18N
        panelButtons.add(enterPayment);
        enterPayment.setBounds(170, 60, 60, 60);

        enterInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Chevron Right_48px.png"))); // NOI18N
        panelButtons.add(enterInvoice);
        enterInvoice.setBounds(170, 0, 60, 60);

        jLabel1.setBackground(new java.awt.Color(255, 191, 5));
        jLabel1.setOpaque(true);
        panelButtons.add(jLabel1);
        jLabel1.setBounds(20, 130, 190, 10);

        buttonInvoice.setBackground(new java.awt.Color(58, 58, 58));
        buttonInvoice.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonInvoice.setForeground(new java.awt.Color(107, 107, 107));
        buttonInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonInvoice.setText("    Invoice");
        buttonInvoice.setOpaque(true);
        buttonInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonInvoiceMouseExited(evt);
            }
        });
        panelButtons.add(buttonInvoice);
        buttonInvoice.setBounds(0, 0, 230, 60);

        buttonPayment.setBackground(new java.awt.Color(58, 58, 58));
        buttonPayment.setFont(new java.awt.Font("Neuropol X Rg", 0, 20)); // NOI18N
        buttonPayment.setForeground(new java.awt.Color(107, 107, 107));
        buttonPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonPayment.setText("    Payment");
        buttonPayment.setOpaque(true);
        buttonPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPaymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonPaymentMouseExited(evt);
            }
        });
        panelButtons.add(buttonPayment);
        buttonPayment.setBounds(0, 60, 230, 60);

        panelInvoiceButtons.setBackground(new java.awt.Color(58, 58, 58));
        panelInvoiceButtons.setLayout(null);

        labelCustomer.setFont(new java.awt.Font("Neuropol X Rg", 0, 17)); // NOI18N
        labelCustomer.setForeground(new java.awt.Color(107, 107, 107));
        labelCustomer.setText("Customer Details");
        panelInvoiceButtons.add(labelCustomer);
        labelCustomer.setBounds(10, 590, 220, 30);

        labelCustomer1.setFont(new java.awt.Font("Neuropol X Rg", 0, 17)); // NOI18N
        labelCustomer1.setForeground(new java.awt.Color(107, 107, 107));
        labelCustomer1.setText("Invoice");
        panelInvoiceButtons.add(labelCustomer1);
        labelCustomer1.setBounds(10, 1, 160, 30);

        labelCustomer2.setFont(new java.awt.Font("Neuropol X Rg", 0, 17)); // NOI18N
        labelCustomer2.setForeground(new java.awt.Color(107, 107, 107));
        labelCustomer2.setText("Employee");
        panelInvoiceButtons.add(labelCustomer2);
        labelCustomer2.setBounds(10, 330, 160, 30);

        exitNewInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Add Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitNewInvoice);
        exitNewInvoice.setBounds(10, 30, 60, 70);

        exitAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Add Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitAddEmployee);
        exitAddEmployee.setBounds(10, 360, 60, 70);

        exitDeleteInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Delete Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitDeleteInvoice);
        exitDeleteInvoice.setBounds(10, 240, 60, 70);

        exitAddInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Add Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitAddInvoice);
        exitAddInvoice.setBounds(10, 100, 60, 70);

        exitUpdateInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Edit Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitUpdateInvoice);
        exitUpdateInvoice.setBounds(10, 170, 60, 70);

        exitUpdateEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Edit Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitUpdateEmployee);
        exitUpdateEmployee.setBounds(10, 430, 60, 70);

        exitDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Delete Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitDeleteEmployee);
        exitDeleteEmployee.setBounds(10, 500, 60, 70);

        exitUpdateDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images1/Edit Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(exitUpdateDescription);
        exitUpdateDescription.setBounds(10, 620, 60, 70);

        enterNewInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Add Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterNewInvoice);
        enterNewInvoice.setBounds(10, 30, 60, 70);

        enterAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Add Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterAddEmployee);
        enterAddEmployee.setBounds(10, 360, 60, 70);

        enterAddInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Add Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterAddInvoice);
        enterAddInvoice.setBounds(10, 100, 60, 70);

        enterUpdateInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Edit Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterUpdateInvoice);
        enterUpdateInvoice.setBounds(10, 170, 60, 70);

        enterDeleteInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Delete Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterDeleteInvoice);
        enterDeleteInvoice.setBounds(10, 240, 60, 70);

        enterUpdateEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Edit Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterUpdateEmployee);
        enterUpdateEmployee.setBounds(10, 430, 60, 70);

        enterDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Delete Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterDeleteEmployee);
        enterDeleteEmployee.setBounds(10, 500, 60, 70);

        enterUpdateDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/automobile_workshop_management_system/utilities/images2/Edit Property_52px.png"))); // NOI18N
        panelInvoiceButtons.add(enterUpdateDescription);
        enterUpdateDescription.setBounds(10, 620, 60, 70);

        buttonNewInvoice.setBackground(new java.awt.Color(58, 58, 58));
        buttonNewInvoice.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonNewInvoice.setForeground(new java.awt.Color(107, 107, 107));
        buttonNewInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonNewInvoice.setText("               New");
        buttonNewInvoice.setOpaque(true);
        buttonNewInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonNewInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonNewInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonNewInvoiceMouseExited(evt);
            }
        });
        panelInvoiceButtons.add(buttonNewInvoice);
        buttonNewInvoice.setBounds(0, 30, 230, 70);

        buttonAddInvoice.setBackground(new java.awt.Color(58, 58, 58));
        buttonAddInvoice.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonAddInvoice.setForeground(new java.awt.Color(107, 107, 107));
        buttonAddInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAddInvoice.setText("               Add ");
        buttonAddInvoice.setOpaque(true);
        buttonAddInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAddInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAddInvoiceMouseExited(evt);
            }
        });
        panelInvoiceButtons.add(buttonAddInvoice);
        buttonAddInvoice.setBounds(0, 100, 230, 70);

        buttonUpdateInvoice.setBackground(new java.awt.Color(58, 58, 58));
        buttonUpdateInvoice.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonUpdateInvoice.setForeground(new java.awt.Color(107, 107, 107));
        buttonUpdateInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonUpdateInvoice.setText("               Update");
        buttonUpdateInvoice.setOpaque(true);
        buttonUpdateInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonUpdateInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonUpdateInvoiceMouseExited(evt);
            }
        });
        panelInvoiceButtons.add(buttonUpdateInvoice);
        buttonUpdateInvoice.setBounds(0, 170, 230, 70);

        buttonDeleteInvoice.setBackground(new java.awt.Color(58, 58, 58));
        buttonDeleteInvoice.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonDeleteInvoice.setForeground(new java.awt.Color(107, 107, 107));
        buttonDeleteInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDeleteInvoice.setText("               Delete");
        buttonDeleteInvoice.setOpaque(true);
        panelInvoiceButtons.add(buttonDeleteInvoice);
        buttonDeleteInvoice.setBounds(0, 240, 230, 70);

        buttonAddEmployee.setBackground(new java.awt.Color(58, 58, 58));
        buttonAddEmployee.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonAddEmployee.setForeground(new java.awt.Color(107, 107, 107));
        buttonAddEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAddEmployee.setText("               Add ");
        buttonAddEmployee.setOpaque(true);
        panelInvoiceButtons.add(buttonAddEmployee);
        buttonAddEmployee.setBounds(0, 360, 230, 70);

        buttonUpdateEmployee.setBackground(new java.awt.Color(58, 58, 58));
        buttonUpdateEmployee.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonUpdateEmployee.setForeground(new java.awt.Color(107, 107, 107));
        buttonUpdateEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonUpdateEmployee.setText("               Update ");
        buttonUpdateEmployee.setOpaque(true);
        panelInvoiceButtons.add(buttonUpdateEmployee);
        buttonUpdateEmployee.setBounds(0, 430, 230, 70);

        buttonDeleteEmployee.setBackground(new java.awt.Color(58, 58, 58));
        buttonDeleteEmployee.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonDeleteEmployee.setForeground(new java.awt.Color(107, 107, 107));
        buttonDeleteEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDeleteEmployee.setText("               Delete ");
        buttonDeleteEmployee.setOpaque(true);
        panelInvoiceButtons.add(buttonDeleteEmployee);
        buttonDeleteEmployee.setBounds(0, 500, 230, 70);

        buttonCustomerDetails.setBackground(new java.awt.Color(58, 58, 58));
        buttonCustomerDetails.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        buttonCustomerDetails.setForeground(new java.awt.Color(107, 107, 107));
        buttonCustomerDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonCustomerDetails.setText("                Customer");
        buttonCustomerDetails.setOpaque(true);
        buttonCustomerDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCustomerDetailsMouseClicked(evt);
            }
        });
        panelInvoiceButtons.add(buttonCustomerDetails);
        buttonCustomerDetails.setBounds(0, 620, 230, 70);

        panelButtons.add(panelInvoiceButtons);
        panelInvoiceButtons.setBounds(0, 150, 230, 840);

        panelPaymentButtons.setBackground(new java.awt.Color(58, 58, 58));
        panelPaymentButtons.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(107, 107, 107));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Delete Payment");
        panelPaymentButtons.add(jLabel36);
        jLabel36.setBounds(0, 160, 230, 80);

        jLabel37.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(107, 107, 107));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Pay");
        panelPaymentButtons.add(jLabel37);
        jLabel37.setBounds(0, 0, 230, 80);

        jLabel38.setFont(new java.awt.Font("Bell MT", 0, 21)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(107, 107, 107));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Update Payment");
        panelPaymentButtons.add(jLabel38);
        jLabel38.setBounds(0, 80, 230, 80);

        panelButtons.add(panelPaymentButtons);
        panelPaymentButtons.setBounds(0, 150, 230, 800);

        add(panelButtons);
        panelButtons.setBounds(0, 0, 230, 990);

        panelInvoice.setBackground(new java.awt.Color(255, 255, 255));
        panelInvoice.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel14.setText("Invoice Number");
        panelInvoice.add(jLabel14);
        jLabel14.setBounds(30, 20, 160, 40);

        jLabel32.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel32.setText("Vehicle No");
        panelInvoice.add(jLabel32);
        jLabel32.setBounds(30, 80, 160, 40);

        jLabel5.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel5.setText("Meter Reading");
        panelInvoice.add(jLabel5);
        jLabel5.setBounds(500, 20, 160, 40);

        textMeterReading.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textMeterReadingMouseClicked(evt);
            }
        });
        textMeterReading.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMeterReadingActionPerformed(evt);
            }
        });
        textMeterReading.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textMeterReadingKeyReleased(evt);
            }
        });
        panelInvoice.add(textMeterReading);
        textMeterReading.setBounds(670, 20, 230, 40);

        jLabel8.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel8.setText("Section");
        panelInvoice.add(jLabel8);
        jLabel8.setBounds(940, 20, 80, 40);

        cmbBoxSection.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        cmbBoxSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBoxSectionActionPerformed(evt);
            }
        });
        panelInvoice.add(cmbBoxSection);
        cmbBoxSection.setBounds(1020, 20, 260, 40);

        jLabel10.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel10.setText("Next Service");
        panelInvoice.add(jLabel10);
        jLabel10.setBounds(1310, 20, 120, 40);

        textNextService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textNextServiceMouseClicked(evt);
            }
        });
        textNextService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNextServiceActionPerformed(evt);
            }
        });
        textNextService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textNextServiceKeyReleased(evt);
            }
        });
        panelInvoice.add(textNextService);
        textNextService.setBounds(1440, 20, 110, 40);

        comboBoxYearOrMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Year", "Month" }));
        panelInvoice.add(comboBoxYearOrMonth);
        comboBoxYearOrMonth.setBounds(1560, 20, 110, 40);

        tableInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Invoice Number", "Meter Reading", "Next Service", "Section", "Discount", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInvoice.getTableHeader().setReorderingAllowed(false);
        tableInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInvoiceMouseClicked(evt);
            }
        });
        tableInvoice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableInvoiceKeyReleased(evt);
            }
        });
        paneInvoice.setViewportView(tableInvoice);
        if (tableInvoice.getColumnModel().getColumnCount() > 0) {
            tableInvoice.getColumnModel().getColumn(0).setResizable(false);
            tableInvoice.getColumnModel().getColumn(1).setResizable(false);
            tableInvoice.getColumnModel().getColumn(2).setResizable(false);
            tableInvoice.getColumnModel().getColumn(3).setResizable(false);
            tableInvoice.getColumnModel().getColumn(4).setResizable(false);
            tableInvoice.getColumnModel().getColumn(5).setResizable(false);
            tableInvoice.getColumnModel().getColumn(6).setResizable(false);
        }

        panelInvoice.add(paneInvoice);
        paneInvoice.setBounds(10, 140, 1670, 220);

        tableSymptom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description(Symptoms)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSymptom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSymptomMouseClicked(evt);
            }
        });
        paneSymptom.setViewportView(tableSymptom);
        if (tableSymptom.getColumnModel().getColumnCount() > 0) {
            tableSymptom.getColumnModel().getColumn(0).setResizable(false);
        }

        panelInvoice.add(paneSymptom);
        paneSymptom.setBounds(10, 640, 1130, 270);

        tableRepair.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Description(Repair)", "Unit Price", "Qty", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paneRepair.setViewportView(tableRepair);
        if (tableRepair.getColumnModel().getColumnCount() > 0) {
            tableRepair.getColumnModel().getColumn(0).setResizable(false);
            tableRepair.getColumnModel().getColumn(1).setResizable(false);
            tableRepair.getColumnModel().getColumn(2).setResizable(false);
            tableRepair.getColumnModel().getColumn(3).setResizable(false);
            tableRepair.getColumnModel().getColumn(4).setResizable(false);
        }

        panelInvoice.add(paneRepair);
        paneRepair.setBounds(10, 370, 1670, 260);

        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableEmployeeKeyReleased(evt);
            }
        });
        paneEmployee.setViewportView(tableEmployee);
        if (tableEmployee.getColumnModel().getColumnCount() > 0) {
            tableEmployee.getColumnModel().getColumn(0).setResizable(false);
        }

        panelInvoice.add(paneEmployee);
        paneEmployee.setBounds(1150, 640, 530, 270);

        cmbBoxEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        panelInvoice.add(cmbBoxEmployee);
        cmbBoxEmployee.setBounds(670, 80, 230, 40);

        cmbInvoiceNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInvoiceNumberActionPerformed(evt);
            }
        });
        panelInvoice.add(cmbInvoiceNumber);
        cmbInvoiceNumber.setBounds(220, 20, 250, 40);

        cmbVehicleNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVehicleNoActionPerformed(evt);
            }
        });
        panelInvoice.add(cmbVehicleNo);
        cmbVehicleNo.setBounds(190, 80, 280, 40);

        lblVehicle.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblVehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelInvoice.add(lblVehicle);
        lblVehicle.setBounds(940, 80, 340, 40);

        jLabel33.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel33.setText("Employee");
        panelInvoice.add(jLabel33);
        jLabel33.setBounds(500, 80, 150, 40);

        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("IN");
        panelInvoice.add(jLabel2);
        jLabel2.setBounds(190, 20, 30, 40);

        add(panelInvoice);
        panelInvoice.setBounds(230, 0, 1690, 990);

        panelPayment.setBackground(new java.awt.Color(255, 255, 255));
        panelPayment.setLayout(null);

        tablePayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Payment Method", "Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panePayment.setViewportView(tablePayment);
        if (tablePayment.getColumnModel().getColumnCount() > 0) {
            tablePayment.getColumnModel().getColumn(0).setResizable(false);
            tablePayment.getColumnModel().getColumn(1).setResizable(false);
            tablePayment.getColumnModel().getColumn(2).setResizable(false);
        }

        panelPayment.add(panePayment);
        panePayment.setBounds(20, 290, 1650, 370);

        jLabel15.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel15.setText("Payment Type");
        panelPayment.add(jLabel15);
        jLabel15.setBounds(640, 20, 140, 40);
        panelPayment.add(textPaidAmount);
        textPaidAmount.setBounds(200, 20, 310, 40);

        jLabel16.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel16.setText("Paid Amount");
        panelPayment.add(jLabel16);
        jLabel16.setBounds(50, 20, 140, 40);

        comboBoxPayment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cash", "Credit Card", "Cheque" }));
        panelPayment.add(comboBoxPayment);
        comboBoxPayment.setBounds(790, 20, 270, 40);

        jLabel17.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel17.setText("Cheque Number");
        panelPayment.add(jLabel17);
        jLabel17.setBounds(1160, 20, 140, 40);
        panelPayment.add(txtChequeNo);
        txtChequeNo.setBounds(1310, 20, 310, 40);
        panelPayment.add(textDiscount);
        textDiscount.setBounds(200, 80, 310, 40);

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        panelPayment.add(lblAmount);
        lblAmount.setBounds(800, 80, 260, 40);

        jLabel19.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel19.setText("Repair Finalized");
        panelPayment.add(jLabel19);
        jLabel19.setBounds(80, 140, 160, 40);

        jLabel21.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel21.setText("Amount");
        panelPayment.add(jLabel21);
        jLabel21.setBounds(640, 80, 140, 40);

        jLabel22.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel22.setText("Discount");
        panelPayment.add(jLabel22);
        jLabel22.setBounds(50, 80, 140, 40);

        jLabel23.setFont(new java.awt.Font("Bell MT", 0, 20)); // NOI18N
        jLabel23.setText("Payment Finalized");
        panelPayment.add(jLabel23);
        jLabel23.setBounds(80, 190, 190, 40);

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        panelPayment.add(jCheckBox1);
        jCheckBox1.setBounds(50, 150, 25, 25);

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        panelPayment.add(jCheckBox2);
        jCheckBox2.setBounds(50, 200, 25, 25);

        add(panelPayment);
        panelPayment.setBounds(230, 0, 1690, 990);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddInvoiceMouseClicked
        if (MainPanel.getCustomerVehiclePanel().getCvid() > 0) {
            if (hold == 1) {
                try {
                    int rsid = RepairSectionController.getRsid(cmbBoxSection.getSelectedItem().toString());
                    if (rsid > 0 && !(textDiscount.getText().equals("")) && !(lblAmount.getText().equals("")) && !(textMeterReading.getText().equals("")) && !(textNextService.getText().equals(""))) {
                        ArrayList<EmployeeInvoiceDetailDTO> employeeList = new ArrayList();
                        int iid = InvoiceController.getLastIid().getIid();
                        iid++;
                        for (int i = 0; i < modelEmployee.getRowCount(); i++) {
                            int eid = (EmployeeController.getEmpId(tableEmployee.getValueAt(i, 0).toString())).getEid();
                            employeeList.add(new EmployeeInvoiceDetailDTO(eid, iid));
                        }
                        if (InvoiceController.addInvoice(new InvoiceDTO(MainPanel.getCustomerVehiclePanel().getCvid(), rsid, cmbInvoiceNumber.getSelectedItem().toString(), textMeterReading.getText(), MainPanel.getDateAndTime().getDate(), Double.parseDouble(textDiscount.getText()), Double.parseDouble(lblAmount.getText()), "0", textNextService.getText(), comboBoxYearOrMonth.getSelectedItem().toString(), employeeList))) {
                            MainPanel.getCustomerVehiclePanel().setCvid();
                        } else {
                            JOptionPane.showMessageDialog(null, "Fail");
                        }
                    }
                    hold = 0;
                    holdNew = 0;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select New Invoice");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle", TOOL_TIP_TEXT_KEY, 2);
        }
    }//GEN-LAST:event_buttonAddInvoiceMouseClicked

    private void buttonInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonInvoiceMouseClicked
        panelInvoiceButtons.setVisible(true);
        panelInvoice.setVisible(true);
        panelPayment.setVisible(false);
        panelPaymentButtons.setVisible(false);
        resetButtons();
        firstIsSelected = true;
        secondIsSelected = false;
        buttonInvoice.setForeground(new Color(255, 191, 5));
        enterInvoice.setVisible(true);
        exitInvoice.setVisible(false);
    }//GEN-LAST:event_buttonInvoiceMouseClicked

    private void buttonPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPaymentMouseClicked
        panelInvoiceButtons.setVisible(false);
        panelInvoice.setVisible(false);
        panelPayment.setVisible(true);
        panelPaymentButtons.setVisible(true);
        resetButtons();
        secondIsSelected = true;
        firstIsSelected = false;
        buttonPayment.setForeground(new Color(255, 191, 5));
        enterPayment.setVisible(true);
        exitPayment.setVisible(false);
    }//GEN-LAST:event_buttonPaymentMouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void buttonInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonInvoiceMouseEntered
        buttonInvoice.setForeground(new Color(255, 191, 5));
        enterInvoice.setVisible(true);
        exitInvoice.setVisible(false);
    }//GEN-LAST:event_buttonInvoiceMouseEntered

    private void buttonPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPaymentMouseEntered
        buttonPayment.setForeground(new Color(255, 191, 5));
        enterPayment.setVisible(true);
        exitPayment.setVisible(false);
    }//GEN-LAST:event_buttonPaymentMouseEntered

    private void buttonInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonInvoiceMouseExited
        if (!firstIsSelected) {
            buttonInvoice.setForeground(new Color(107, 107, 107));
            enterInvoice.setVisible(false);
            exitInvoice.setVisible(true);
        }
    }//GEN-LAST:event_buttonInvoiceMouseExited

    private void buttonPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPaymentMouseExited
        if (!secondIsSelected) {
            buttonPayment.setForeground(new Color(107, 107, 107));
            enterPayment.setVisible(false);
            exitPayment.setVisible(true);
        }
    }//GEN-LAST:event_buttonPaymentMouseExited

    private void buttonAddInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddInvoiceMouseEntered
        buttonAddInvoice.setBackground(new Color(48, 48, 48));
        buttonAddInvoice.setForeground(new Color(255, 191, 5));
        enterAddInvoice.setVisible(true);
        exitAddInvoice.setVisible(false);
    }//GEN-LAST:event_buttonAddInvoiceMouseEntered

    private void buttonAddInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddInvoiceMouseExited
        buttonAddInvoice.setBackground(new Color(58, 58, 58));
        buttonAddInvoice.setForeground(new Color(107, 107, 107));
        enterAddInvoice.setVisible(false);
        exitAddInvoice.setVisible(true);
    }//GEN-LAST:event_buttonAddInvoiceMouseExited

    private void buttonUpdateInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateInvoiceMouseEntered
        buttonUpdateInvoice.setBackground(new Color(48, 48, 48));
        buttonUpdateInvoice.setForeground(new Color(255, 191, 5));
        enterUpdateInvoice.setVisible(true);
        exitUpdateInvoice.setVisible(false);
    }//GEN-LAST:event_buttonUpdateInvoiceMouseEntered

    private void buttonUpdateInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateInvoiceMouseExited
        buttonUpdateInvoice.setBackground(new Color(58, 58, 58));
        buttonUpdateInvoice.setForeground(new Color(107, 107, 107));
        enterUpdateInvoice.setVisible(false);
        exitUpdateInvoice.setVisible(true);
    }//GEN-LAST:event_buttonUpdateInvoiceMouseExited

    private void buttonNewInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNewInvoiceMouseClicked
        if (MainPanel.getCustomerVehiclePanel().getCvid() > 0) {
            holdNew++;
            if (holdNew == 1) {
                generateInvoiceNumber();
                clearTableInvoice();
                clearTableRepair();
                clearTableSymptom();
                clearEmployee();
                hold = 1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle", TOOL_TIP_TEXT_KEY, 2);
        }
    }//GEN-LAST:event_buttonNewInvoiceMouseClicked

    private void buttonNewInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNewInvoiceMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonNewInvoiceMouseEntered

    private void buttonNewInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNewInvoiceMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonNewInvoiceMouseExited

    private void tableInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInvoiceMouseClicked
        if (tableInvoice.getSelectedRow() > -1) {
            try {
                int iid = getInvoiceId();
                while (modelEmployee.getRowCount() != 0) {
                    modelEmployee.removeRow(0);
                }
                while (modelRepair.getRowCount() != 0) {
                    modelRepair.removeRow(0);
                }
                while (modelSymptom.getRowCount() != 0) {
                    modelSymptom.removeRow(0);
                }
                ArrayList<EmployeeDTO> employeeList = EmployeeInvoiceDetailController.viewEmployee(iid);
                for (EmployeeDTO employee : employeeList) {
                    Object[] obEmployee = {employee.getEmployeeName()};
                    modelEmployee.addRow(obEmployee);
                }
                ArrayList<SymptomDescriptionDetailDTO> details = SymptomDescriptionDetailController.viewSymptoms(iid);
                for (SymptomDescriptionDetailDTO detail : details) {
                    Object[] ob = {detail.getDescription()};
                    modelSymptom.addRow(ob);
                }
                ArrayList<RepairInvoiceDescriptionDetailDTO> repairDetails = RepairInvoiceDescriptionDetailController.viewRepairs(iid);
                ArrayList<ItemInvoiceDescriptionDetailDTO> invoiceDetails = ItemInvoiceDescriptionDetailController.viewItemInvoices(iid);
                ArrayList<ItemInvoiceDetailDTO> stockDetails = ItemInvoiceDetailController.viewStockInvoices(iid);
                for (RepairInvoiceDescriptionDetailDTO repairDetail : repairDetails) {
                    double price = repairDetail.getPrice() * repairDetail.getQty();
                    Object[] ob = {"", repairDetail.getDescription(), repairDetail.getPrice(), repairDetail.getQty(), price};
                    modelRepair.addRow(ob);
                }
                for (ItemInvoiceDescriptionDetailDTO invoiceDetail : invoiceDetails) {
                    double price = invoiceDetail.getPrice() * invoiceDetail.getQty();
                    Object[] ob = {"II0" + invoiceDetail.getItindid(), invoiceDetail.getDescription(), invoiceDetail.getPrice(), invoiceDetail.getQty(), price};
                    modelRepair.addRow(ob);
                }
                for (ItemInvoiceDetailDTO stockDetail : stockDetails) {
                    double price = stockDetail.getPrice() * stockDetail.getQty();
                    Object[] ob = {"SI0" + stockDetail.getItid(), stockDetail.getDescription(), stockDetail.getPrice(), stockDetail.getQty(), price};
                    modelRepair.addRow(ob);
                }
                totalAmount();
                cmbInvoiceNumber.setSelectedItem(getInvoiceNumber());
                textMeterReading.setText(tableInvoice.getValueAt(tableInvoice.getSelectedRow(), 2).toString());
                String number[] = tableInvoice.getValueAt(tableInvoice.getSelectedRow(), 3).toString().split("(\\D)");
                textNextService.setText(number[0]);
                String text[] = tableInvoice.getValueAt(tableInvoice.getSelectedRow(), 3).toString().replaceAll("\\s", "").split("(\\d)");
                comboBoxYearOrMonth.setSelectedItem(text[1]);
                cmbBoxSection.setSelectedItem(tableInvoice.getValueAt(tableInvoice.getSelectedRow(), 4));
                invoiceId = getInvoiceId();
                hold = 2;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tableInvoiceMouseClicked
    
    private int getInvoiceId() {
        try {
            String s = tableInvoice.getValueAt(tableInvoice.getSelectedRow(), 1).toString();
            char[] number = s.toCharArray();
            String newNumber = "";
            for (int i = 2; i < number.length; i++) {
                newNumber += number[i];
            }
            int value = InvoiceController.getInvoiceId(new InvoiceDTO(newNumber));
            return value;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    private String getInvoiceNumber() {
        String s = tableInvoice.getValueAt(tableInvoice.getSelectedRow(), 1).toString();
        char[] number = s.toCharArray();
        String newNumber = "";
        for (int i = 2; i < number.length; i++) {
            newNumber += number[i];
        }
        return newNumber;
    }

    private void tableEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableEmployeeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE && tableEmployee.getSelectedRow() > -1) {
            modelEmployee.removeRow(tableEmployee.getSelectedRow());
        }
    }//GEN-LAST:event_tableEmployeeKeyReleased

    private void cmbInvoiceNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInvoiceNumberActionPerformed
//        textMeterReading.requestFocus();
    }//GEN-LAST:event_cmbInvoiceNumberActionPerformed

    private void textMeterReadingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMeterReadingActionPerformed
        cmbBoxSection.requestFocus();
    }//GEN-LAST:event_textMeterReadingActionPerformed

    private void cmbBoxSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBoxSectionActionPerformed

    }//GEN-LAST:event_cmbBoxSectionActionPerformed

    private void textNextServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNextServiceActionPerformed
        comboBoxYearOrMonth.requestFocus();
    }//GEN-LAST:event_textNextServiceActionPerformed

    private void cmbVehicleNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVehicleNoActionPerformed

    }//GEN-LAST:event_cmbVehicleNoActionPerformed

    private void tableSymptomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSymptomMouseClicked

    }//GEN-LAST:event_tableSymptomMouseClicked

    private void textMeterReadingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMeterReadingKeyReleased
        if (!(textMeterReading.getText().matches("[0-9]+"))) {
            textMeterReading.setText("");
        }
    }//GEN-LAST:event_textMeterReadingKeyReleased

    private void textMeterReadingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMeterReadingMouseClicked
        textMeterReading.selectAll();
    }//GEN-LAST:event_textMeterReadingMouseClicked

    private void textNextServiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNextServiceKeyReleased
        if (!(textNextService.getText().matches("[0-9]+"))) {
            textNextService.setText("");
        }
    }//GEN-LAST:event_textNextServiceKeyReleased

    private void textNextServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNextServiceMouseClicked
        textNextService.selectAll();
    }//GEN-LAST:event_textNextServiceMouseClicked

    private void tableInvoiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableInvoiceKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE && tableEmployee.getSelectedRow() > -1) {
            
        }
    }//GEN-LAST:event_tableInvoiceKeyReleased

    private void buttonUpdateInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateInvoiceMouseClicked
        if (hold == 2) {
            
        }
    }//GEN-LAST:event_buttonUpdateInvoiceMouseClicked

    private void buttonCustomerDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCustomerDetailsMouseClicked
        MainPanel.getCustomerVehiclePanel().setData(cmbInvoiceNumber.getSelectedItem().toString());
        MainPanel.managePanelsForCustomerVehicle();
    }//GEN-LAST:event_buttonCustomerDetailsMouseClicked
    
    private void editorComboVehicle() {
        cmbVehicleNo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        MainPanel.getCustomerVehiclePanel().setCvid();
                        ArrayList<InvoiceDTO> invoiceList = InvoiceController.getInvoiceData(cmbVehicleNo.getSelectedItem().toString());
                        setInvoiceData(invoiceList);
                        setVehicleNumberByNo();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    private void editorComboSection() {
        cmbBoxSection.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    count++;
                }
                if (count == 2) {
                    textNextService.requestFocus();
                    count = 0;
                }
            }
            
        });
    }
    
    private void editorComboEmployee() {
        cmbBoxEmployee.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (!(cmbBoxEmployee.getSelectedItem().toString().equals("Select"))) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        Object[] ob = {cmbBoxEmployee.getSelectedItem()};
                        modelEmployee.addRow(ob);
                        //tableEmployee.requestFocus();
                    }
                }
            }
            
        });
    }
    
    private void editorComboInvoiceNumber() {
        cmbInvoiceNumber.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (!(cmbInvoiceNumber.getSelectedItem().toString().equals("Select"))) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        try {
                            ArrayList<InvoiceDTO> invoiceList = InvoiceController.getInvoiceData(cmbInvoiceNumber.getSelectedItem().toString());
                            setInvoiceData(invoiceList);
                            setVehicleNumberByInvoice();
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
        });
    }
    
    private void setInvoiceData(ArrayList<InvoiceDTO> invoiceList) {
        clearTableInvoice();
        clearEmployee();
        clearTableRepair();
        clearTableSymptom();
        for (InvoiceDTO invoice : invoiceList) {
            Object[] ob = {invoice.getDate(), "IN" + invoice.getInvoiceNumber(), invoice.getMeterReading(), invoice.getNextService() + " " + invoice.getYearOrMonth(), invoice.getRepairName(), invoice.getDiscount(), invoice.getAmount()};
            modelInvoice.addRow(ob);
        }
    }
    
    private void setVehicleNumberByNo() {
        try {
            VehicleDTO vehicleDTO = VehicleController.getVehicleModel(new VehicleDTO(cmbVehicleNo.getSelectedItem().toString()));
            if (vehicleDTO != null) {
                lblVehicle.setText(vehicleDTO.getBrand() + " - " + vehicleDTO.getModel());
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setVehicleNumberByInvoice() {
        try {
            VehicleDTO vehicleDTO = InvoiceController.getVehicleModelAndNo(cmbInvoiceNumber.getSelectedItem().toString());
            if (vehicleDTO != null) {
                lblVehicle.setText(vehicleDTO.getBrand() + " - " + vehicleDTO.getModel());
                cmbVehicleNo.setSelectedItem(vehicleDTO.getVehicleNo());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setData() {
        int id = MainPanel.getCustomerVehiclePanel().getCvid();
        if (id > 0) {
            String[] s = MainPanel.getCustomerVehiclePanel().getTextVehicleNo();
            cmbVehicleNo.setSelectedItem(s[0]);
            lblVehicle.setText(s[1] + " - " + s[2]);
            updateTable(id);
        } 
    }
    
    private void updateTable(int id) {
        while (modelInvoice.getRowCount() != 0) {
            modelInvoice.removeRow(0);
        }
        try {
            ArrayList<InvoiceDTO> invoiceList = InvoiceController.viewInvoice(id);
            for (InvoiceDTO invoice : invoiceList) {
                Object[] ob = {invoice.getDate(), "IN" + invoice.getInvoiceNumber(), invoice.getMeterReading(), invoice.getNextService(), RepairSectionController.getDescription(invoice.getRsid()), invoice.getDiscount(), invoice.getAmount()};
                modelInvoice.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void totalAmount() {
        double total = 0;
        for (int i = 0; i < modelRepair.getRowCount(); i++) {
            total += (Double) modelRepair.getValueAt(i, 4);
        }
        lblAmount.setText("" + total);
    }
    
    private void customizeInvoiceTable() {
        tableInvoice.setDefaultRenderer(Object.class, new CustomizeTable());
        tableInvoice.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableInvoice.setRowHeight(30);
        tableInvoice.setShowGrid(true);
        tableInvoice.setFont(new Font("", 0, 20));
        //tableInvoice.getColumnModel().getColumn(0).setPreferredWidth(100);
        //tableInvoice.getColumnModel().getColumn(1).setPreferredWidth(500);
        paneInvoice.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizeRepairTable() {
        tableRepair.setDefaultRenderer(Object.class, new CustomizeTable());
        tableRepair.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableRepair.setRowHeight(30);
        tableRepair.setShowGrid(true);
        tableRepair.setFont(new Font("", 0, 20));
        //tableRepair.getColumnModel().getColumn(0).setPreferredWidth(500);
        //tableRepair.getColumnModel().getColumn(1).setPreferredWidth(100);
        paneRepair.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizeSymptomTable() {
        tableSymptom.setDefaultRenderer(Object.class, new CustomizeTable());
        tableSymptom.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableSymptom.setRowHeight(30);
        tableSymptom.setShowGrid(true);
        tableSymptom.setFont(new Font("", 0, 20));
        paneSymptom.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizeEmployeeTable() {
        tableEmployee.setDefaultRenderer(Object.class, new CustomizeTable());
        tableEmployee.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableEmployee.setRowHeight(30);
        tableEmployee.setShowGrid(true);
        tableEmployee.setFont(new Font("", 0, 20));
        paneEmployee.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizePaymentTable() {
        tablePayment.setDefaultRenderer(Object.class, new CustomizeTable());
        tablePayment.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tablePayment.setRowHeight(30);
        tablePayment.setShowGrid(true);
        tablePayment.setFont(new Font("", 0, 20));
        panePayment.getViewport().setBackground(Color.WHITE);
    }
    
    private void hideIcons() {
        enterAddInvoice.setVisible(false);
        enterUpdateInvoice.setVisible(false);
        enterDeleteInvoice.setVisible(false);
        enterAddEmployee.setVisible(false);
        enterUpdateEmployee.setVisible(false);
        enterDeleteEmployee.setVisible(false);
        enterUpdateDescription.setVisible(false);
        enterInvoice.setVisible(false);
        enterPayment.setVisible(false);
    }
    
    private void resetButtons() {
        buttonInvoice.setBackground(new Color(58, 58, 58));
        buttonInvoice.setForeground(new Color(107, 107, 107));
        enterInvoice.setVisible(false);
        exitInvoice.setVisible(true);
        buttonPayment.setBackground(new Color(58, 58, 58));
        buttonPayment.setForeground(new Color(107, 107, 107));
        enterPayment.setVisible(false);
        exitPayment.setVisible(true);
    }
    
    private void loadInvoiceCombo() {
        try {
            cmbInvoiceNumber.setFont(new Font("", 0, 18));
            ArrayList<InvoiceDTO> invoiceNumbers = InvoiceController.getInvoiceNumbers();
            for (InvoiceDTO invoiceNumber : invoiceNumbers) {
                cmbInvoiceNumber.addItem(invoiceNumber.getInvoiceNumber());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void generateInvoiceNumber() {
        try {
            InvoiceDTO invoiceDTO = InvoiceController.getLastInvoiceNumber();
            int no = Integer.parseInt(invoiceDTO.getInvoiceNumber());
            no++;
            cmbInvoiceNumber.addItem("" + no);
            cmbInvoiceNumber.setSelectedIndex(cmbInvoiceNumber.getItemCount() - 1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadEmployeeCombo() {
        cmbBoxEmployee.setFont(new Font("", 0, 18));
        try {
            ArrayList<EmployeeDTO> employeeNames = EmployeeInvoiceDetailController.getAllEmployees();
            for (EmployeeDTO employeeName : employeeNames) {
                cmbBoxEmployee.addItem(employeeName.getEmployeeName());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSectionCombo() {
        cmbBoxSection.setFont(new Font("", 0, 18));
        try {
            ArrayList<String> repairSectionList = RepairSectionController.searchRepairSection();
            for (String repairSection : repairSectionList) {
                cmbBoxSection.addItem(repairSection);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadVehicleNoCombo() {
        try {
            cmbVehicleNo.setFont(new Font("", 0, 18));
            ArrayList<VehicleDTO> numberList = VehicleController.getAllVehicleNos();
            for (VehicleDTO vehicleNo : numberList) {
                cmbVehicleNo.addItem(vehicleNo.getVehicleNo());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearTableInvoice() {
        while (modelInvoice.getRowCount() != 0) {
            modelInvoice.removeRow(0);
        }
    }
    
    private void clearTableRepair() {
        while (modelRepair.getRowCount() != 0) {
            modelRepair.removeRow(0);
        }
    }
    
    private void clearTableSymptom() {
        while (modelSymptom.getRowCount() != 0) {
            modelSymptom.removeRow(0);
        }
    }
    
    private void clearEmployee() {
        while (modelEmployee.getRowCount() != 0) {
            modelEmployee.removeRow(0);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonAddEmployee;
    private javax.swing.JLabel buttonAddInvoice;
    private javax.swing.JLabel buttonCustomerDetails;
    private javax.swing.JLabel buttonDeleteEmployee;
    private javax.swing.JLabel buttonDeleteInvoice;
    private javax.swing.JLabel buttonInvoice;
    private javax.swing.JLabel buttonNewInvoice;
    private javax.swing.JLabel buttonPayment;
    private javax.swing.JLabel buttonUpdateEmployee;
    private javax.swing.JLabel buttonUpdateInvoice;
    private javax.swing.JComboBox cmbBoxEmployee;
    private javax.swing.JComboBox cmbBoxSection;
    private javax.swing.JComboBox<String> cmbInvoiceNumber;
    private javax.swing.JComboBox<String> cmbVehicleNo;
    private javax.swing.JComboBox comboBoxPayment;
    private javax.swing.JComboBox comboBoxYearOrMonth;
    private javax.swing.JLabel enterAddEmployee;
    private javax.swing.JLabel enterAddInvoice;
    private javax.swing.JLabel enterDeleteEmployee;
    private javax.swing.JLabel enterDeleteInvoice;
    private javax.swing.JLabel enterInvoice;
    private javax.swing.JLabel enterNewInvoice;
    private javax.swing.JLabel enterPayment;
    private javax.swing.JLabel enterUpdateDescription;
    private javax.swing.JLabel enterUpdateEmployee;
    private javax.swing.JLabel enterUpdateInvoice;
    private javax.swing.JLabel exitAddEmployee;
    private javax.swing.JLabel exitAddInvoice;
    private javax.swing.JLabel exitDeleteEmployee;
    private javax.swing.JLabel exitDeleteInvoice;
    private javax.swing.JLabel exitInvoice;
    private javax.swing.JLabel exitNewInvoice;
    private javax.swing.JLabel exitPayment;
    private javax.swing.JLabel exitUpdateDescription;
    private javax.swing.JLabel exitUpdateEmployee;
    private javax.swing.JLabel exitUpdateInvoice;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelCustomer;
    private javax.swing.JLabel labelCustomer1;
    private javax.swing.JLabel labelCustomer2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblVehicle;
    private javax.swing.JScrollPane paneEmployee;
    private javax.swing.JScrollPane paneInvoice;
    private javax.swing.JScrollPane panePayment;
    private javax.swing.JScrollPane paneRepair;
    private javax.swing.JScrollPane paneSymptom;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelInvoice;
    private javax.swing.JPanel panelInvoiceButtons;
    private javax.swing.JPanel panelPayment;
    private javax.swing.JPanel panelPaymentButtons;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTable tableInvoice;
    private javax.swing.JTable tablePayment;
    private javax.swing.JTable tableRepair;
    private javax.swing.JTable tableSymptom;
    private javax.swing.JTextField textDiscount;
    private javax.swing.JTextField textMeterReading;
    private javax.swing.JTextField textNextService;
    private javax.swing.JTextField textPaidAmount;
    private javax.swing.JTextField txtChequeNo;
    // End of variables declaration//GEN-END:variables
}
