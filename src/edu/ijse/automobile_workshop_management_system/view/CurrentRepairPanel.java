package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.controller.InvoiceController;
import edu.ijse.automobile_workshop_management_system.controller.ItemController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceDescriptionController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceDescriptionDetailController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceDetailController;
import edu.ijse.automobile_workshop_management_system.controller.RepairDescriptionController;
import edu.ijse.automobile_workshop_management_system.controller.RepairInvoiceDescriptionDetailController;
import edu.ijse.automobile_workshop_management_system.controller.SymptomDescriptionController;
import edu.ijse.automobile_workshop_management_system.controller.SymptomDescriptionDetailController;
import edu.ijse.automobile_workshop_management_system.controller.VehicleController;
import edu.ijse.automobile_workshop_management_system.model.InvoiceDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.RepairDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.RepairInvoiceDescriptionDetailDTO;
import edu.ijse.automobile_workshop_management_system.model.RepairSectionDTO;
import edu.ijse.automobile_workshop_management_system.model.SymptomDescriptionDTO;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class CurrentRepairPanel extends javax.swing.JPanel {

    private JTextField textVehicleNo;
    private JTextField textInvoiceDesc;
    private JTextField textSymptomDesc;
    private ArrayList<String> comboTextVehicleNo;
    private ArrayList<String> comboTextInvoiceDesc;
    private ArrayList<String> comboTextSymptomDesc;
    private DefaultTableModel modelRepairInvoice;
    private DefaultTableModel modelRepairDetails;
    private DefaultTableModel modelSymptom;
    private int iid = 0;
    private int cvid = 0;
    private int count = 0;
    private int comboInvoiceHold = 0;
    private int rowCount = 0;
    private int oldQty = 0;

    public CurrentRepairPanel() {
        initComponents();
        customizeRepairTable();
        customizeSymptomTable();
        customizeRepairInvoiceTable();
        customizeComponents();
        loadVehicleNo();
        loadSymptomDesc();
        loadData();
        editorComboVehicleNo();
        editorComboSymptom();
        editorComboSelect();
        editorComboInvoiceDesc();
        editorComboPartNumber();
        editorStockItemCode();
        editorItemInvoiceCode();
        modelRepairInvoice = (DefaultTableModel) tableRepairInvoice.getModel();
        modelSymptom = (DefaultTableModel) tableVehicleSymptoms.getModel();
        modelRepairDetails = (DefaultTableModel) tableRepairDetails.getModel();
        AutoCompleteDecorator.decorate(comboBoxVehicleNo);
        AutoCompleteDecorator.decorate(comboBoxSymptomDescription);
        AutoCompleteDecorator.decorate(comboBoxInvoiceDescription);
        AutoCompleteDecorator.decorate(cmbSelect);
        AutoCompleteDecorator.decorate(cmbPartNumber);
        AutoCompleteDecorator.decorate(cmbStockItemCode);
        AutoCompleteDecorator.decorate(cmbInvoiceItemCode);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonAddSymptoms = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxVehicleNo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboBoxInvoiceDescription = new javax.swing.JComboBox();
        paneRepair = new javax.swing.JScrollPane();
        tableRepairDetails = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spnQty = new javax.swing.JSpinner();
        textPrice = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        comboBoxSymptomDescription = new javax.swing.JComboBox();
        paneSymptom = new javax.swing.JScrollPane();
        tableVehicleSymptoms = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblVehicle = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        paneRepairInvoice = new javax.swing.JScrollPane();
        tableRepairInvoice = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbPartNumber = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        lblQtyOnHand = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbStockItemCode = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbSelect = new javax.swing.JComboBox<>();
        chkVehicle = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbInvoiceItemCode = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 990));
        jPanel1.setLayout(null);

        buttonAddSymptoms.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        buttonAddSymptoms.setForeground(new java.awt.Color(107, 107, 107));
        buttonAddSymptoms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonAddSymptoms.setText("Add Symptoms");
        buttonAddSymptoms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAddSymptomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAddSymptomsMouseExited(evt);
            }
        });
        jPanel1.add(buttonAddSymptoms);
        buttonAddSymptoms.setBounds(0, 0, 230, 90);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(107, 107, 107));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Update Symptoms");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(0, 90, 230, 90);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(107, 107, 107));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Delete Symptoms");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(0, 180, 230, 90);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(107, 107, 107));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Add Description");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(0, 310, 230, 90);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(107, 107, 107));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Delete Description");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(0, 490, 230, 90);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(107, 107, 107));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Update Description");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(0, 400, 230, 90);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 990);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Vehicle No");
        add(jLabel1);
        jLabel1.setBounds(250, 10, 90, 40);

        comboBoxVehicleNo.setAutoscrolls(true);
        comboBoxVehicleNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVehicleNoActionPerformed(evt);
            }
        });
        add(comboBoxVehicleNo);
        comboBoxVehicleNo.setBounds(360, 10, 290, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Part Number");
        add(jLabel2);
        jLabel2.setBounds(880, 200, 110, 40);

        comboBoxInvoiceDescription.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        comboBoxInvoiceDescription.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxInvoiceDescriptionItemStateChanged(evt);
            }
        });
        comboBoxInvoiceDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxInvoiceDescriptionActionPerformed(evt);
            }
        });
        comboBoxInvoiceDescription.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboBoxInvoiceDescriptionPropertyChange(evt);
            }
        });
        add(comboBoxInvoiceDescription);
        comboBoxInvoiceDescription.setBounds(740, 270, 670, 40);

        tableRepairDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Description", "UnitPrice", "Qty", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRepairDetails.getTableHeader().setReorderingAllowed(false);
        tableRepairDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRepairDetailsMouseClicked(evt);
            }
        });
        paneRepair.setViewportView(tableRepairDetails);
        if (tableRepairDetails.getColumnModel().getColumnCount() > 0) {
            tableRepairDetails.getColumnModel().getColumn(0).setResizable(false);
            tableRepairDetails.getColumnModel().getColumn(1).setResizable(false);
            tableRepairDetails.getColumnModel().getColumn(2).setResizable(false);
            tableRepairDetails.getColumnModel().getColumn(3).setResizable(false);
            tableRepairDetails.getColumnModel().getColumn(4).setResizable(false);
        }

        add(paneRepair);
        paneRepair.setBounds(250, 320, 1650, 260);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 71, 71));
        jLabel4.setText("Repair Details");
        add(jLabel4);
        jLabel4.setBounds(250, 270, 142, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Qty On Hand :");
        add(jLabel13);
        jLabel13.setBounds(1660, 200, 120, 40);

        spnQty.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spnQtyKeyReleased(evt);
            }
        });
        add(spnQty);
        spnQty.setBounds(1540, 270, 90, 40);

        textPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPriceActionPerformed(evt);
            }
        });
        add(textPrice);
        textPrice.setBounds(1720, 270, 180, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Price");
        add(jLabel16);
        jLabel16.setBounds(1660, 270, 37, 40);

        comboBoxSymptomDescription.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        add(comboBoxSymptomDescription);
        comboBoxSymptomDescription.setBounds(740, 590, 670, 40);

        tableVehicleSymptoms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVehicleSymptoms.getTableHeader().setReorderingAllowed(false);
        paneSymptom.setViewportView(tableVehicleSymptoms);
        if (tableVehicleSymptoms.getColumnModel().getColumnCount() > 0) {
            tableVehicleSymptoms.getColumnModel().getColumn(0).setResizable(false);
        }

        add(paneSymptom);
        paneSymptom.setBounds(250, 640, 1650, 260);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Description");
        add(jLabel7);
        jLabel7.setBounds(640, 590, 100, 40);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Total");
        add(jLabel15);
        jLabel15.setBounds(1650, 590, 50, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 71, 71));
        jLabel6.setText("Vehicle Symptoms");
        add(jLabel6);
        jLabel6.setBounds(250, 590, 186, 40);

        lblVehicle.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lblVehicle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblVehicle);
        lblVehicle.setBounds(280, 50, 340, 50);
        add(lblTotalAmount);
        lblTotalAmount.setBounds(1730, 590, 170, 40);

        tableRepairInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Invoice Number", "Section", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRepairInvoice.getTableHeader().setReorderingAllowed(false);
        tableRepairInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRepairInvoiceMouseClicked(evt);
            }
        });
        paneRepairInvoice.setViewportView(tableRepairInvoice);
        if (tableRepairInvoice.getColumnModel().getColumnCount() > 0) {
            tableRepairInvoice.getColumnModel().getColumn(0).setResizable(false);
            tableRepairInvoice.getColumnModel().getColumn(1).setResizable(false);
            tableRepairInvoice.getColumnModel().getColumn(2).setResizable(false);
            tableRepairInvoice.getColumnModel().getColumn(3).setResizable(false);
        }

        add(paneRepairInvoice);
        paneRepairInvoice.setBounds(660, 10, 1240, 150);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Description");
        add(jLabel3);
        jLabel3.setBounds(640, 270, 100, 40);

        cmbPartNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        add(cmbPartNumber);
        cmbPartNumber.setBounds(990, 200, 480, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Qty");
        add(jLabel14);
        jLabel14.setBounds(1490, 270, 37, 40);
        add(lblQtyOnHand);
        lblQtyOnHand.setBounds(1800, 200, 100, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Select");
        add(jLabel5);
        jLabel5.setBounds(620, 200, 60, 40);

        cmbStockItemCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        add(cmbStockItemCode);
        cmbStockItemCode.setBounds(420, 200, 160, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Item Code");
        add(jLabel11);
        jLabel11.setBounds(270, 200, 110, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SI0");
        add(jLabel12);
        jLabel12.setBounds(370, 200, 40, 40);

        jLabel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Item"));
        add(jLabel17);
        jLabel17.setBounds(250, 180, 345, 76);

        cmbSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Other", "Invoice", "Stock" }));
        add(cmbSelect);
        cmbSelect.setBounds(690, 200, 160, 40);

        chkVehicle.setBackground(new java.awt.Color(255, 255, 255));
        chkVehicle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkVehicle.setText("  Filter Data");
        chkVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVehicleActionPerformed(evt);
            }
        });
        add(chkVehicle);
        chkVehicle.setBounds(1500, 200, 140, 40);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Item Code");
        add(jLabel18);
        jLabel18.setBounds(270, 120, 110, 40);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("II0");
        add(jLabel20);
        jLabel20.setBounds(370, 120, 40, 40);

        cmbInvoiceItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbInvoiceItemCodeActionPerformed(evt);
            }
        });
        add(cmbInvoiceItemCode);
        cmbInvoiceItemCode.setBounds(420, 120, 160, 40);

        jLabel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice Item"));
        add(jLabel21);
        jLabel21.setBounds(250, 100, 345, 76);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddSymptomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddSymptomsMouseEntered
        buttonAddSymptoms.setBackground(new Color(0, 91, 91));
    }//GEN-LAST:event_buttonAddSymptomsMouseEntered

    private void buttonAddSymptomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddSymptomsMouseExited
        buttonAddSymptoms.setBackground(new Color(0, 71, 71));
    }//GEN-LAST:event_buttonAddSymptomsMouseExited

    private void comboBoxVehicleNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVehicleNoActionPerformed

    }//GEN-LAST:event_comboBoxVehicleNoActionPerformed

    private void tableRepairInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRepairInvoiceMouseClicked
        try {
            iid = InvoiceController.getInvoiceId(new InvoiceDTO(tableRepairInvoice.getValueAt(tableRepairInvoice.getSelectedRow(), 1).toString()));
            while (modelRepairDetails.getRowCount() != 0) {
                modelRepairDetails.removeRow(0);
            }
            while (modelSymptom.getRowCount() != 0) {
                modelSymptom.removeRow(0);
            }
            ArrayList<SymptomDescriptionDetailDTO> details = SymptomDescriptionDetailController.viewSymptoms(iid);
            ArrayList<RepairInvoiceDescriptionDetailDTO> repairDetails = RepairInvoiceDescriptionDetailController.viewRepairs(iid);
            ArrayList<ItemInvoiceDescriptionDetailDTO> invoiceDetails = ItemInvoiceDescriptionDetailController.viewItemInvoices(iid);
            ArrayList<ItemInvoiceDetailDTO> stockDetails = ItemInvoiceDetailController.viewStockInvoices(iid);
            for (RepairInvoiceDescriptionDetailDTO repairDetail : repairDetails) {
                double price = repairDetail.getPrice() * repairDetail.getQty();
                Object[] ob = {"", repairDetail.getDescription(), repairDetail.getPrice(), repairDetail.getQty(), price};
                modelRepairDetails.addRow(ob);
            }
            for (SymptomDescriptionDetailDTO detail : details) {
                Object[] ob = {detail.getDescription()};
                modelSymptom.addRow(ob);
            }
            for (ItemInvoiceDescriptionDetailDTO invoiceDetail : invoiceDetails) {
                double price = invoiceDetail.getPrice() * invoiceDetail.getQty();
                Object[] ob = {"II0" + invoiceDetail.getItindid(), invoiceDetail.getDescription(), invoiceDetail.getPrice(), invoiceDetail.getQty(), price};
                modelRepairDetails.addRow(ob);
            }
            for (ItemInvoiceDetailDTO stockDetail : stockDetails) {
                double price = stockDetail.getPrice() * stockDetail.getQty();
                Object[] ob = {"SI0" + stockDetail.getItid(), stockDetail.getDescription(), stockDetail.getPrice(), stockDetail.getQty(), price};
                modelRepairDetails.addRow(ob);
            }
            totalAmount();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableRepairInvoiceMouseClicked

    private void textPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPriceActionPerformed
        try {
            if (iid != 0 && (count > 0 || tableRepairDetails.getSelectedRow() > -1) && !(comboBoxInvoiceDescription.getSelectedItem().toString().equals("Select"))) {
                if (!(comboBoxInvoiceDescription.getSelectedItem().toString().isEmpty()) && !(spnQty.getValue().toString().isEmpty()) && !(textPrice.getText().isEmpty())) {
                    if (comboBoxInvoiceDescription.getSelectedItem().toString().matches(".+\\(SI\\)")) {
                        String[] data = calculateData("SI0", cmbStockItemCode);
                        if (data[0].equals("add")) {
                            ItemInvoiceDetailController.addItemInvoice(new ItemInvoiceDetailDTO(iid, getNumberfromKey(tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 0).toString()), Integer.parseInt(data[1]), Double.parseDouble(data[2])));
                            comboInvoiceHold = 0;
                        } else if (data[0].equals("update") && !(data[3].equals("-1"))) {
                            updateData(Integer.parseInt(data[3]));
                        } else if (data[0].equals("update") && (data[3].equals("-1"))) {
                            updateData(tableRepairDetails.getSelectedRow());
                            tableRepairDetails.clearSelection();
                        }
                    } else if (comboBoxInvoiceDescription.getSelectedItem().toString().matches(".+\\(II\\)")) {
                        String[] data = calculateData("II0", cmbInvoiceItemCode);
                        if (data[0].equals("add")) {
                            ItemInvoiceDescriptionDetailController.addItemInvoice(new ItemInvoiceDescriptionDetailDTO(iid, getNumberfromKey(tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 0).toString()), Integer.parseInt(data[1]), Double.parseDouble(data[2])));
                            comboInvoiceHold = 0;
                        } else if (data[0].equals("update") && !(data[3].equals("-1"))) {
                            updateData(Integer.parseInt(data[3]));
                        } else if (data[0].equals("update") && (data[3].equals("-1"))) {
                            updateData(tableRepairDetails.getSelectedRow());
                            tableRepairDetails.clearSelection();
                        }
                    } else {
                        RepairDescriptionDTO repairDescriptionDTO = RepairDescriptionController.getRdid(new RepairDescriptionDTO(comboBoxInvoiceDescription.getSelectedItem().toString()));
                        if (comboBoxInvoiceDescription.getSelectedIndex() > -1 && repairDescriptionDTO != null && !comboBoxInvoiceDescription.getSelectedItem().toString().isEmpty()) {
                            String[] data = calculateRepairs();
                            if (data[0].equals("add")) {
                                RepairInvoiceDescriptionDetailController.addRepair(new RepairInvoiceDescriptionDetailDTO(repairDescriptionDTO.getRdid(), iid, Integer.parseInt(data[1]), Double.parseDouble(data[2])));
                                comboInvoiceHold = 0;
                            } else if (data[0].equals("update") && !(data[3].equals("-1"))) {
                                updateData(Integer.parseInt(data[3]));
                            } else if (data[0].equals("update") && (data[3].equals("-1"))) {
                                updateData(tableRepairDetails.getSelectedRow());
                                tableRepairDetails.clearSelection();
                            }
                        } else if (comboBoxInvoiceDescription.getSelectedIndex() == -1 && !comboBoxInvoiceDescription.getSelectedItem().toString().isEmpty()) {
                            String[] data = calculateRepairs();
                            RepairDescriptionController.addSymptom(new RepairDescriptionDTO(comboBoxInvoiceDescription.getSelectedItem().toString(), new RepairInvoiceDescriptionDetailDTO(iid, Integer.parseInt(data[1]), Double.parseDouble(data[2]))));
                            String s = comboBoxInvoiceDescription.getSelectedItem().toString();
                            loadData();
                            comboBoxInvoiceDescription.setSelectedItem(s);
                            comboInvoiceHold = 0;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_textPriceActionPerformed

    private String[] calculateData(String text, JComboBox cmb) {
        String[] data = new String[4];
        if (!(comboBoxInvoiceDescription.getSelectedItem().toString().isEmpty()) && !(spnQty.getValue().toString().isEmpty()) && !(textPrice.getText().isEmpty())) {
            if (tableRepairDetails.getSelectedRow() == -1) {
                if (Integer.parseInt(lblQtyOnHand.getText()) >= Integer.parseInt(spnQty.getValue().toString())) {
                    double total = Double.parseDouble(textPrice.getText()) * Integer.parseInt(spnQty.getValue().toString());
                    String s[] = comboBoxInvoiceDescription.getSelectedItem().toString().split("\\-");
                    Object[] ob = {(text + cmb.getSelectedItem()), s[0], textPrice.getText(), spnQty.getValue(), total};
                    lblQtyOnHand.setText("" + (Integer.parseInt(lblQtyOnHand.getText()) - Integer.parseInt(spnQty.getValue().toString())));
                    int count = 0;
                    for (int i = 0; i < modelRepairDetails.getRowCount(); i++) {
                        if (tableRepairDetails.getValueAt(i, 0).toString().equals(text + cmb.getSelectedItem().toString())) {
                            data[0] = "update";
                            int newQty = Integer.parseInt(tableRepairDetails.getValueAt(i, 3).toString()) + Integer.parseInt(spnQty.getValue().toString());
                            double newTotal = newQty * Double.parseDouble(textPrice.getText());
                            Object[] obj = {textPrice.getText(), newQty, newTotal};
                            tableRepairDetails.setValueAt(obj[0], i, 2);
                            tableRepairDetails.setValueAt(obj[1], i, 3);
                            tableRepairDetails.setValueAt(obj[2], i, 4);
                            data[1] = tableRepairDetails.getValueAt(i, 3).toString();
                            data[2] = tableRepairDetails.getValueAt(i, 2).toString();
                            data[3] = i + "";
                            count++;
                        }
                    }
                    if (count == 0) {
                        modelRepairDetails.addRow(ob);
                        data[0] = "add";
                        data[1] = tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 3).toString();
                        data[2] = tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 2).toString();
                    }
                    totalAmount();
                } else {
                    JOptionPane.showMessageDialog(null, "Qty Exceeded");
                }
            } else if (tableRepairDetails.getSelectedRow() > -1) {
                if (Integer.parseInt(lblQtyOnHand.getText()) >= (Integer.parseInt(spnQty.getValue().toString()) - Integer.parseInt(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 3).toString()))) {
                    double total = Double.parseDouble(textPrice.getText()) * Integer.parseInt(spnQty.getValue().toString());
                    String s[] = comboBoxInvoiceDescription.getSelectedItem().toString().split("\\-");
                    Object[] ob = {(text + cmb.getSelectedItem()), s[0], textPrice.getText(), spnQty.getValue(), total};
                    oldQty = Integer.parseInt(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 3).toString());
                    lblQtyOnHand.setText(Integer.parseInt(lblQtyOnHand.getText()) - ((int) spnQty.getValue() - oldQty) + "");
                    int count = 0;
                    for (int i = 0; i < modelRepairDetails.getRowCount(); i++) {
                        if (tableRepairDetails.getValueAt(i, 0).toString().equals(text + cmb.getSelectedItem().toString())) {
                            data[0] = "update";
                            int newQty = Integer.parseInt(spnQty.getValue().toString());
                            double newTotal = newQty * Double.parseDouble(textPrice.getText());
                            Object[] obj = {textPrice.getText(), newQty, newTotal};
                            tableRepairDetails.setValueAt(obj[0], i, 2);
                            tableRepairDetails.setValueAt(obj[1], i, 3);
                            tableRepairDetails.setValueAt(obj[2], i, 4);
                            data[1] = tableRepairDetails.getValueAt(i, 3).toString();
                            data[2] = tableRepairDetails.getValueAt(i, 2).toString();
                            data[3] = -1 + "";
                            count++;
                        }
                    }
                    if (count == 0) {
                        modelRepairDetails.addRow(ob);
                        data[0] = "add";
                        data[1] = tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 3).toString();
                        data[2] = tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 2).toString();
                    }
                    totalAmount();
                } else {
                    JOptionPane.showMessageDialog(null, "Qty Exceeded");
                }
            }
        }
        return data;
    }

    private String[] calculateRepairs() {
        String[] data = new String[4];
        if (!(comboBoxInvoiceDescription.getSelectedItem().toString().isEmpty()) && !(textPrice.getText().isEmpty())) {
            double total = Double.parseDouble(textPrice.getText()) * Integer.parseInt(spnQty.getValue().toString());
            String s = comboBoxInvoiceDescription.getSelectedItem().toString();
            Object[] ob = {"", s, textPrice.getText(), spnQty.getValue(), total};
            int count = 0;
            for (int i = 0; i < modelRepairDetails.getRowCount(); i++) {
                if ((tableRepairDetails.getValueAt(i, 1).toString()).equals(s)) {
                    if (tableRepairDetails.getSelectedRow() == -1) {
                        data[0] = "update";
                        int newQty = Integer.parseInt(tableRepairDetails.getValueAt(i, 3).toString()) + Integer.parseInt(spnQty.getValue().toString());
                        double newTotal = newQty * Double.parseDouble(textPrice.getText());
                        Object[] obj = {textPrice.getText(), newQty, newTotal};
                        tableRepairDetails.setValueAt(obj[0], i, 2);
                        tableRepairDetails.setValueAt(obj[1], i, 3);
                        tableRepairDetails.setValueAt(obj[2], i, 4);
                        data[1] = tableRepairDetails.getValueAt(i, 3).toString();
                        data[2] = tableRepairDetails.getValueAt(i, 2).toString();
                        data[3] = i + "";
                        count++;
                    } else {
                        data[0] = "update";
                        int newQty = Integer.parseInt(spnQty.getValue().toString());
                        double newTotal = newQty * Double.parseDouble(textPrice.getText());
                        Object[] obj = {textPrice.getText(), newQty, newTotal};
                        tableRepairDetails.setValueAt(obj[0], i, 2);
                        tableRepairDetails.setValueAt(obj[1], i, 3);
                        tableRepairDetails.setValueAt(obj[2], i, 4);
                        data[1] = tableRepairDetails.getValueAt(i, 3).toString();
                        data[2] = tableRepairDetails.getValueAt(i, 2).toString();
                        data[3] = -1 + "";
                        count++;
                    }
                }
            }
            if (count == 0) {
                modelRepairDetails.addRow(ob);
                data[0] = "add";
                data[1] = tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 3).toString();
                data[2] = tableRepairDetails.getValueAt(tableRepairDetails.getRowCount() - 1, 2).toString();
            }
            totalAmount();
        }
        return data;
    }

    private void chkVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVehicleActionPerformed
        loadData();
    }//GEN-LAST:event_chkVehicleActionPerformed

    private void cmbInvoiceItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbInvoiceItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbInvoiceItemCodeActionPerformed

    private void comboBoxInvoiceDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxInvoiceDescriptionActionPerformed

    }//GEN-LAST:event_comboBoxInvoiceDescriptionActionPerformed

    private void comboBoxInvoiceDescriptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxInvoiceDescriptionItemStateChanged

    }//GEN-LAST:event_comboBoxInvoiceDescriptionItemStateChanged

    private void comboBoxInvoiceDescriptionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboBoxInvoiceDescriptionPropertyChange

    }//GEN-LAST:event_comboBoxInvoiceDescriptionPropertyChange

    private void tableRepairDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRepairDetailsMouseClicked
        if (tableRepairDetails.getSelectedRow() > -1) {
            if (tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString().equals("")) {
                setValues();
                lblQtyOnHand.setText("");
            } else if (tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString().matches("II.+")) {
                try {
                    setValues();
                    cmbInvoiceItemCode.setSelectedItem(getNumberfromKey(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString()));
                    ItemInvoiceDescriptionDTO itemInvoiceDescription = new ItemInvoiceDescriptionDTO();
                    itemInvoiceDescription.setItindid(getNumberfromKey(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString()));
                    ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO = ItemInvoiceDescriptionController.getQtyAndPartNo(itemInvoiceDescription);
                    lblQtyOnHand.setText(itemInvoiceDescriptionDTO.getQty() + "");
                    cmbPartNumber.setSelectedItem(itemInvoiceDescriptionDTO.getPartNumber());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString().matches("SI.+")) {
                try {
                    setValues();
                    cmbStockItemCode.setSelectedItem(getNumberfromKey(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString()));
                    ItemDTO item = new ItemDTO();
                    item.setItemId(getNumberfromKey(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 0).toString()));
                    ItemDTO itemDTO = ItemController.getQtyAndPartNo(item);
                    lblQtyOnHand.setText(itemDTO.getQty() + "");
                    cmbPartNumber.setSelectedItem(itemDTO.getPartNo());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_tableRepairDetailsMouseClicked

    private void setValues() {
        clearText();
        comboBoxInvoiceDescription.setSelectedItem(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 1));
        textPrice.setText(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 2).toString());
        spnQty.setValue(tableRepairDetails.getValueAt(tableRepairDetails.getSelectedRow(), 3));
    }

    private int getNumberfromKey(String key) {
        char[] keyArr = key.toCharArray();
        String number = keyArr[keyArr.length - 1] + "";
        int value = Integer.parseInt(number);
        return value;
    }

    private void spnQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spnQtyKeyReleased

    }//GEN-LAST:event_spnQtyKeyReleased

    private void totalAmount() {
        double total = 0;
        for (int i = 0; i < modelRepairDetails.getRowCount(); i++) {
            total += (Double) tableRepairDetails.getValueAt(i, 4);
        }
        lblTotalAmount.setText("" + total);
    }

    private void editorComboVehicleNo() {
        comboBoxVehicleNo.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        ArrayList<InvoiceDTO> invoiceList = InvoiceController.getInvoiceRepairData(comboBoxVehicleNo.getSelectedItem().toString());
                        while (modelRepairInvoice.getRowCount() != 0) {
                            modelRepairInvoice.removeRow(0);
                        }
                        for (InvoiceDTO invoiceDTO : invoiceList) {
                            Object[] ob = {invoiceDTO.getDate(), invoiceDTO.getInvoiceNumber(), invoiceDTO.getRepairName(), invoiceDTO.getAmount()};
                            modelRepairInvoice.addRow(ob);
                        }
                        VehicleDTO vehicleDTO = VehicleController.getVehicleModel(new VehicleDTO(comboBoxVehicleNo.getSelectedItem().toString()));
                        lblVehicle.setText(vehicleDTO.getBrand() + " - " + vehicleDTO.getModel());
                        loadData();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    private void editorComboSymptom() {
        comboBoxSymptomDescription.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (iid != 0) {
                            SymptomDescriptionDTO symptomDescriptionDTO = SymptomDescriptionController.getBrdId(new SymptomDescriptionDTO(comboBoxSymptomDescription.getSelectedItem().toString()));
                            if (comboBoxSymptomDescription.getSelectedIndex() > -1 && symptomDescriptionDTO != null && !comboBoxSymptomDescription.getSelectedItem().toString().isEmpty()) {
                                if (SymptomDescriptionDetailController.addSymptom(new SymptomDescriptionDetailDTO(symptomDescriptionDTO.getBrdid(), iid))) {
                                    Object[] ob = {comboBoxSymptomDescription.getSelectedItem().toString()};
                                    modelSymptom.addRow(ob);
                                }
                            } else if (comboBoxSymptomDescription.getSelectedIndex() == -1 && !comboBoxSymptomDescription.getSelectedItem().toString().isEmpty()) {
                                if (SymptomDescriptionController.addSymptom(new SymptomDescriptionDTO(comboBoxSymptomDescription.getSelectedItem().toString(), new SymptomDescriptionDetailDTO(iid)))) {
                                    Object[] ob = {comboBoxSymptomDescription.getSelectedItem().toString()};
                                    modelSymptom.addRow(ob);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Select an Invoice");
                        }
                    } catch (SQLException ex) {
                        if (ex.getErrorCode() == 1062) {

                        } else {
                            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    loadSymptomDesc();
                }
            }
        });
    }

    private void editorComboSelect() {
        cmbSelect.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loadData();
                }
            }
        });
    }

    private void editorComboInvoiceDesc() {
        comboBoxInvoiceDescription.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    count++;
                    comboInvoiceHold++;
                    if (comboBoxInvoiceDescription.getSelectedItem().toString().matches(".+\\(SI\\)")) {
                        String s[] = comboBoxInvoiceDescription.getSelectedItem().toString().split("\\-");
                        setCombosSI(s);
                    } else if (comboBoxInvoiceDescription.getSelectedItem().toString().matches(".+\\(II\\)")) {
                        String s[] = comboBoxInvoiceDescription.getSelectedItem().toString().split("\\-");
                        setCombosII(s);
                    } else {
                        clearTextForReapair();
                    }

                    if (count == 2) {
                        spnQty.requestFocus();
                        count = 0;
                    }
                }
            }
        });
    }

    private void editorComboPartNumber() {
        cmbPartNumber.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    count++;
                    if (tableRepairDetails.getSelectedRow() == -1) {
                        if (cmbPartNumber.getSelectedItem().toString().matches(".+\\(SI\\)")) {
                            String s[] = cmbPartNumber.getSelectedItem().toString().split("\\-");
                            setCombosSI(s);
                        } else if (cmbPartNumber.getSelectedItem().toString().matches(".+\\(II\\)")) {
                            String s[] = cmbPartNumber.getSelectedItem().toString().split("\\-");
                            setCombosII(s);
                        } else {
                            clearText();
                        }
                    } else if (tableRepairDetails.getSelectedRow() > -1) {

                    }
                    if (count == 2) {
                        spnQty.requestFocus();
                        count = 0;
                    }
                }
            }

        });
    }

    private void editorStockItemCode() {
        cmbStockItemCode.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String[] s = new String[2];
                    s[0] = cmbStockItemCode.getSelectedItem().toString();
                    s[1] = s[0];
                    setCombosSI(s);
                }
            }

        });
    }

    private void editorItemInvoiceCode() {
        cmbInvoiceItemCode.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String[] s = new String[3];
                    s[0] = cmbInvoiceItemCode.getSelectedItem().toString();
                    s[1] = s[0];
                    s[2] = s[1];
                    setCombosII(s);
                }
            }

        });
    }

    private void setCombosSI(String s[]) {
        try {
            ArrayList<ItemDTO> itemDTOs = ItemController.getItemData(new ItemDTO(s[0].trim()));
            if (itemDTOs != null) {
                for (ItemDTO itemDTO : itemDTOs) {
                    if (s[1].trim().equals(itemDTO.getBrandName() + "(" + itemDTO.getModelName() + ")" + " / (SI)")) {
                        clearText();
                        cmbStockItemCode.setSelectedItem(itemDTO.getItemId());
                        cmbPartNumber.setSelectedItem(itemDTO.getPartNo());
                        lblQtyOnHand.setText(itemDTO.getQty() + "");
                        textPrice.setText(itemDTO.getPrice() + "");
                        comboBoxInvoiceDescription.setSelectedItem(itemDTO.getDescription());
                    }
                    if (s[1].trim().equals(itemDTO.getItemId() + "")) {
                        clearText();
                        cmbStockItemCode.setSelectedItem(itemDTO.getItemId());
                        cmbPartNumber.setSelectedItem(itemDTO.getPartNo());
                        lblQtyOnHand.setText(itemDTO.getQty() + "");
                        textPrice.setText(itemDTO.getPrice() + "");
                        comboBoxInvoiceDescription.setSelectedItem(itemDTO.getDescription());
                    }
                }
            }
            if (s[1].trim().equals("Select")) {
                clearText();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setCombosII(String s[]) {
        try {
            ArrayList<ItemInvoiceDescriptionDTO> itemInvoiceDescriptionDTOs = ItemInvoiceDescriptionController.getItemData(new ItemInvoiceDescriptionDTO(s[0].trim()));
            if (itemInvoiceDescriptionDTOs != null) {
                for (ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO : itemInvoiceDescriptionDTOs) {
                    if (s[1].trim().equals("(" + itemInvoiceDescriptionDTO.getName() + ")") && s[2].trim().equals(itemInvoiceDescriptionDTO.getBrandName() + "(" + itemInvoiceDescriptionDTO.getModelName() + ")" + " / (II)")) {
                        clearText();
                        cmbPartNumber.setSelectedItem(itemInvoiceDescriptionDTO.getPartNumber());
                        lblQtyOnHand.setText(itemInvoiceDescriptionDTO.getQty() + "");
                        textPrice.setText(itemInvoiceDescriptionDTO.getPrice() + "");
                        comboBoxInvoiceDescription.setSelectedItem(itemInvoiceDescriptionDTO.getDescription() + " - " + "(" + itemInvoiceDescriptionDTO.getName() + ")");
                        cmbInvoiceItemCode.setSelectedItem(itemInvoiceDescriptionDTO.getItindid());
                    }
                    if (s[1].trim().equals(itemInvoiceDescriptionDTO.getItindid() + "")) {
                        clearText();
                        cmbPartNumber.setSelectedItem(itemInvoiceDescriptionDTO.getPartNumber());
                        lblQtyOnHand.setText(itemInvoiceDescriptionDTO.getQty() + "");
                        textPrice.setText(itemInvoiceDescriptionDTO.getPrice() + "");
                        comboBoxInvoiceDescription.setSelectedItem(itemInvoiceDescriptionDTO.getDescription() + " - " + "(" + itemInvoiceDescriptionDTO.getName() + ")");
                        cmbInvoiceItemCode.setSelectedItem(itemInvoiceDescriptionDTO.getItindid());
                    }
                }
            }
            if (s[1].trim().equals("Select")) {
                clearText();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateData(int i) {
        try {
            if (tableRepairDetails.getValueAt(i, 0).toString().equals("")) {
                int rdid = RepairDescriptionController.getRdid(new RepairDescriptionDTO(comboBoxInvoiceDescription.getSelectedItem().toString())).getRdid();
                int qty = Integer.parseInt(tableRepairDetails.getValueAt(i, 3).toString());
                double price = Double.parseDouble(textPrice.getText());
                RepairInvoiceDescriptionDetailController.updateRepairs(new RepairInvoiceDescriptionDetailDTO(rdid, iid, qty, price));
            } else if (tableRepairDetails.getValueAt(i, 0).toString().matches("SI.+")) {
                if (tableRepairDetails.getSelectedRow() > -1) {
                    int itid = getNumberfromKey(tableRepairDetails.getValueAt(i, 0).toString());
                    double price = Double.parseDouble(textPrice.getText());
                    int newQty = (int) spnQty.getValue() - oldQty;
                    ItemInvoiceDetailController.updateItemInvoice(new ItemInvoiceDetailDTO(iid, itid, newQty, price));
                } else {
                    int itid = getNumberfromKey(tableRepairDetails.getValueAt(i, 0).toString());
                    int qty = (int) spnQty.getValue();
                    double price = Double.parseDouble(textPrice.getText());
                    ItemInvoiceDetailController.updateItemInvoice(new ItemInvoiceDetailDTO(iid, itid, qty, price));
                }
            } else if (tableRepairDetails.getValueAt(i, 0).toString().matches("II.+")) {
                if (tableRepairDetails.getSelectedRow() > -1) {
                    int itindid = getNumberfromKey(tableRepairDetails.getValueAt(i, 0).toString());
                    double price = Double.parseDouble(textPrice.getText());
                    int newQty = (int) spnQty.getValue() - oldQty;
                    ItemInvoiceDescriptionDetailController.updateItemInvoice(new ItemInvoiceDescriptionDetailDTO(iid, itindid, newQty, price));
                } else {
                    int itindid = getNumberfromKey(tableRepairDetails.getValueAt(i, 0).toString());
                    int qty = (int) spnQty.getValue();
                    double price = Double.parseDouble(textPrice.getText());
                    ItemInvoiceDescriptionDetailController.updateItemInvoice(new ItemInvoiceDescriptionDetailDTO(iid, itindid, qty, price));
                }
            }
            totalAmount();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearText() {
        cmbStockItemCode.setSelectedItem("Select");
        cmbInvoiceItemCode.setSelectedItem("Select");
        cmbPartNumber.setSelectedItem("Select");
        comboBoxInvoiceDescription.setSelectedItem("Select");
        lblQtyOnHand.setText("");
        textPrice.setText("");
    }

    private void clearTextForReapair() {
        cmbStockItemCode.setSelectedItem("Select");
        cmbInvoiceItemCode.setSelectedItem("Select");
        cmbPartNumber.setSelectedItem("Select");
        lblQtyOnHand.setText("");
        textPrice.setText("");
    }

    public String getTotalAmount() {
        return lblTotalAmount.getText();
    }

    private void customizeComponents() {
        comboBoxSymptomDescription.setEditable(true);
        comboBoxSymptomDescription.setFont(new Font("", 0, 18));
        comboBoxInvoiceDescription.setEditable(true);
        comboBoxInvoiceDescription.setFont(new Font("", 0, 18));
        comboBoxInvoiceDescription.setBackground(Color.WHITE);
        spnQty.setFont(new Font("", 0, 18));
        spnQty.setBackground(Color.WHITE);
        lblQtyOnHand.setFont(new Font("", 0, 18));
        lblTotalAmount.setFont(new Font("", 0, 18));
        textPrice.setFont(new Font("", 0, 18));
        cmbPartNumber.setFont(new Font("", 0, 18));
        cmbPartNumber.setBackground(Color.WHITE);
        cmbStockItemCode.setFont(new Font("", 0, 18));
        cmbStockItemCode.setBackground(Color.WHITE);
        comboBoxSymptomDescription.setBackground(Color.WHITE);
        comboBoxVehicleNo.setFont(new Font("", 0, 18));
        comboBoxVehicleNo.setBackground(Color.WHITE);
        cmbSelect.setFont(new Font("", 0, 18));
        cmbSelect.setBackground(Color.WHITE);
        cmbInvoiceItemCode.setFont(new Font("", 0, 18));
        cmbInvoiceItemCode.setBackground(Color.WHITE);
    }

    private void customizeRepairTable() {
        tableRepairDetails.setDefaultRenderer(Object.class, new CustomizeTable());
        tableRepairDetails.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableRepairDetails.setRowHeight(30);
        tableRepairDetails.setShowGrid(true);
        tableRepairDetails.setFont(new Font("", 0, 20));
        //tableRepairDetails.getColumnModel().getColumn(0).setPreferredWidth(100);
        //tableRepairDetails.getColumnModel().getColumn(1).setPreferredWidth(500);
        paneRepair.getViewport().setBackground(Color.WHITE);
    }

    private void customizeSymptomTable() {
        tableVehicleSymptoms.setDefaultRenderer(Object.class, new CustomizeTable());
        tableVehicleSymptoms.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableVehicleSymptoms.setRowHeight(30);
        tableVehicleSymptoms.setShowGrid(true);
        tableVehicleSymptoms.setFont(new Font("", 0, 20));
        tableVehicleSymptoms.getColumnModel().getColumn(0).setPreferredWidth(100);
        paneSymptom.getViewport().setBackground(Color.WHITE);
    }

    private void customizeRepairInvoiceTable() {
        tableRepairInvoice.setDefaultRenderer(Object.class, new CustomizeTable());
        tableRepairInvoice.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tableRepairInvoice.setRowHeight(30);
        tableRepairInvoice.setShowGrid(true);
        tableRepairInvoice.setFont(new Font("", 0, 20));
        paneRepairInvoice.getViewport().setBackground(Color.WHITE);
    }

    private void loadSymptomDesc() {
        try {
            comboBoxSymptomDescription.removeAllItems();
            comboBoxSymptomDescription.addItem("Select");
            comboBoxSymptomDescription.setSelectedItem("Select");
            ArrayList<SymptomDescriptionDTO> descList = SymptomDescriptionController.viewAllDesc();
            for (SymptomDescriptionDTO symptomDescriptionDTO : descList) {
                comboBoxSymptomDescription.addItem(symptomDescriptionDTO.getDescription());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadData() {
        try {
            ArrayList<ItemDTO> itemList = ItemController.getAllItemDesc();
            ArrayList<ItemInvoiceDescriptionDTO> invoiceItemList = ItemInvoiceDescriptionController.getAllInvoices();
            ArrayList<RepairSectionDTO> descList = RepairDescriptionController.getAllReapairDesc();
            if (itemList != null && descList != null && invoiceItemList != null) {
                comboBoxInvoiceDescription.removeAllItems();
                cmbPartNumber.removeAllItems();
                cmbStockItemCode.removeAllItems();
                cmbInvoiceItemCode.removeAllItems();
                cmbPartNumber.addItem("Select");
                cmbPartNumber.setSelectedItem("Select");
                cmbStockItemCode.addItem("Select");
                cmbStockItemCode.setSelectedItem("Select");
                cmbInvoiceItemCode.addItem("Select");
                cmbInvoiceItemCode.setSelectedItem("Select");
                comboBoxInvoiceDescription.addItem("Select");
                comboBoxInvoiceDescription.setSelectedItem("Select");
                if (cmbSelect.getSelectedItem().toString().equals("Other")) {
                    itemList(itemList);
                    invoiceItemList(invoiceItemList);
                    for (RepairSectionDTO repairSectionDTO : descList) {
                        comboBoxInvoiceDescription.addItem(repairSectionDTO.getDescription());
                    }
                } else if (cmbSelect.getSelectedItem().toString().equals("Invoice")) {
                    invoiceItemList(invoiceItemList);
                } else if (cmbSelect.getSelectedItem().toString().equals("Stock")) {
                    itemList(itemList);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void itemList(ArrayList<ItemDTO> itemList) {
        if (itemList != null) {
            for (ItemDTO itemDTO : itemList) {
                if (chkVehicle.isSelected()) {
                    if (lblVehicle.getText().equals(itemDTO.getBrandName() + " - " + itemDTO.getModelName()) && itemDTO.getQty() > 0) {
                        comboBoxInvoiceDescription.addItem(itemDTO.getDescription() + " - " + itemDTO.getBrandName() + "(" + itemDTO.getModelName() + ")" + " / (SI)");
                        cmbPartNumber.addItem(itemDTO.getPartNo() + " - " + itemDTO.getBrandName() + "(" + itemDTO.getModelName() + ")" + " / (SI)");
                        cmbStockItemCode.addItem(itemDTO.getItemId() + "");
                    }
                } else {
                    comboBoxInvoiceDescription.addItem(itemDTO.getDescription() + " - " + itemDTO.getBrandName() + "(" + itemDTO.getModelName() + ")" + " / (SI)");
                    cmbPartNumber.addItem(itemDTO.getPartNo() + " - " + itemDTO.getBrandName() + "(" + itemDTO.getModelName() + ")" + " / (SI)");
                    cmbStockItemCode.addItem(itemDTO.getItemId() + "");
                }
            }
        }
    }

    private void invoiceItemList(ArrayList<ItemInvoiceDescriptionDTO> invoiceItemList) {
        if (invoiceItemList != null) {
            for (ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO : invoiceItemList) {
                if (chkVehicle.isSelected()) {
                    if (lblVehicle.getText().equals(itemInvoiceDescriptionDTO.getBrandName() + " - " + itemInvoiceDescriptionDTO.getModelName()) && itemInvoiceDescriptionDTO.getQty() > 0) {
                        comboBoxInvoiceDescription.addItem(itemInvoiceDescriptionDTO.getDescription() + " - (" + itemInvoiceDescriptionDTO.getName() + ")" + " - " + itemInvoiceDescriptionDTO.getBrandName() + "(" + itemInvoiceDescriptionDTO.getModelName() + ")" + " / (II)");
                        cmbPartNumber.addItem(itemInvoiceDescriptionDTO.getPartNumber() + " - (" + itemInvoiceDescriptionDTO.getName() + ")" + " - " + itemInvoiceDescriptionDTO.getBrandName() + "(" + itemInvoiceDescriptionDTO.getModelName() + ")" + " / (II)");
                        cmbInvoiceItemCode.addItem(itemInvoiceDescriptionDTO.getItindid() + "");
                    }
                } else {
                    comboBoxInvoiceDescription.addItem(itemInvoiceDescriptionDTO.getDescription() + " - (" + itemInvoiceDescriptionDTO.getName() + ")" + " - " + itemInvoiceDescriptionDTO.getBrandName() + "(" + itemInvoiceDescriptionDTO.getModelName() + ")" + " / (II)");
                    cmbPartNumber.addItem(itemInvoiceDescriptionDTO.getPartNumber() + " - (" + itemInvoiceDescriptionDTO.getName() + ")" + " - " + itemInvoiceDescriptionDTO.getBrandName() + "(" + itemInvoiceDescriptionDTO.getModelName() + ")" + " / (II)");
                    cmbInvoiceItemCode.addItem(itemInvoiceDescriptionDTO.getItindid() + "");
                }
            }
        }
    }

    private void loadVehicleNo() {
        try {
            ArrayList<String> numberList = InvoiceController.searchVehicleNumber();
            for (String number : numberList) {
                comboBoxVehicleNo.addItem(number);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentRepairPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonAddSymptoms;
    private javax.swing.JCheckBox chkVehicle;
    private javax.swing.JComboBox<String> cmbInvoiceItemCode;
    private javax.swing.JComboBox<String> cmbPartNumber;
    private javax.swing.JComboBox<String> cmbSelect;
    private javax.swing.JComboBox<String> cmbStockItemCode;
    private javax.swing.JComboBox comboBoxInvoiceDescription;
    private javax.swing.JComboBox comboBoxSymptomDescription;
    private javax.swing.JComboBox comboBoxVehicleNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblQtyOnHand;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblVehicle;
    private javax.swing.JScrollPane paneRepair;
    private javax.swing.JScrollPane paneRepairInvoice;
    private javax.swing.JScrollPane paneSymptom;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JTable tableRepairDetails;
    private javax.swing.JTable tableRepairInvoice;
    private javax.swing.JTable tableVehicleSymptoms;
    private javax.swing.JTextField textPrice;
    // End of variables declaration//GEN-END:variables
}
