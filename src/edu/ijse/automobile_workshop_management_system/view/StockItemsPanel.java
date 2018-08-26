package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.controller.BrandController;
import edu.ijse.automobile_workshop_management_system.controller.IIDescriptionController;
import edu.ijse.automobile_workshop_management_system.controller.ModelController;
import edu.ijse.automobile_workshop_management_system.model.BrandDTO;
import edu.ijse.automobile_workshop_management_system.model.IIDescripitonDTO;
import edu.ijse.automobile_workshop_management_system.model.ModelDTO;
import edu.ijse.automobile_workshop_management_system.utilities.CustomizeTable;
import edu.ijse.automobile_workshop_management_system.utilities.CustomizeTableHeader;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imalka
 */
public class StockItemsPanel extends javax.swing.JPanel {

    public StockItemsPanel() {
        initComponents();
        customizeTable();
        customizeComp();
        loadComboBrand();
        loadItems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cmbItem = new javax.swing.JComboBox<>();
        cmbVehicleBrand = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbVehicleModel = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        spnQty = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbPartNumber = new javax.swing.JComboBox<>();
        txtItemCode = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        chkSearchByQty = new javax.swing.JCheckBox();
        chkSearchData = new javax.swing.JCheckBox();
        scrItem = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 990));
        jPanel1.setLayout(null);
        add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 1080);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Qty");
        add(jLabel6);
        jLabel6.setBounds(1380, 220, 50, 40);

        add(cmbItem);
        cmbItem.setBounds(360, 280, 750, 40);

        add(cmbVehicleBrand);
        cmbVehicleBrand.setBounds(640, 40, 310, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Price");
        add(jLabel7);
        jLabel7.setBounds(1380, 280, 60, 40);

        add(cmbVehicleModel);
        cmbVehicleModel.setBounds(1250, 40, 310, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Part Number");
        add(jLabel8);
        jLabel8.setBounds(830, 220, 120, 40);
        add(spnQty);
        spnQty.setBounds(1450, 220, 110, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("SI0");
        add(jLabel9);
        jLabel9.setBounds(420, 220, 40, 40);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        add(txtPrice);
        txtPrice.setBounds(1450, 280, 310, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Brand");
        add(jLabel10);
        jLabel10.setBounds(570, 40, 60, 40);

        add(cmbPartNumber);
        cmbPartNumber.setBounds(950, 220, 310, 40);

        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });
        add(txtItemCode);
        txtItemCode.setBounds(460, 220, 160, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("Item");
        add(jLabel11);
        jLabel11.setBounds(290, 280, 60, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Model");
        add(jLabel12);
        jLabel12.setBounds(1180, 40, 60, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Item Code");
        add(jLabel13);
        jLabel13.setBounds(290, 220, 110, 40);

        chkSearchByQty.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkSearchByQty.setText(" Search By Qty");
        add(chkSearchByQty);
        chkSearchByQty.setBounds(1120, 130, 180, 33);

        chkSearchData.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkSearchData.setText(" Search Data");
        add(chkSearchData);
        chkSearchData.setBounds(900, 130, 170, 33);

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item", "Part Number", "Brand", "Model", "Qty", "Unit Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItem.getTableHeader().setReorderingAllowed(false);
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        scrItem.setViewportView(tblItem);

        add(scrItem);
        scrItem.setBounds(240, 350, 1670, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        /*comboModel();
        comboItem();
        addToInvoice();
        loadComboModel();
        loadComboBrand();
        loadItems();*/
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
       // setInvoice();
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked
       /* if (tblItem.getSelectedRow() > -1) {
            txtItemCode.setText(getNumberfromKey(tblItem.getValueAt(tblItem.getSelectedRow(), 0).toString()) + "");
            setInvoice();
        }*/
    }//GEN-LAST:event_tblItemMouseClicked

    private void loadComboBrand() {
        try {
            ArrayList<BrandDTO> brandList = BrandController.getAllBrands();
            cmbVehicleBrand.removeAllItems();
            cmbVehicleModel.removeAllItems();
            cmbVehicleBrand.addItem("Select");
            cmbVehicleModel.addItem("Select");
            cmbVehicleModel.setSelectedItem("Select");
            cmbVehicleBrand.setSelectedItem("Select");
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
    
    private void loadItems() {
        try {
            ArrayList<IIDescripitonDTO> list = IIDescriptionController.getAllItems();
            cmbItem.removeAllItems();
            cmbPartNumber.removeAllItems();
            cmbItem.addItem("Select");
            cmbPartNumber.addItem("Select");
            cmbItem.setSelectedItem("Select");
            cmbPartNumber.setSelectedItem("Select");
            for (IIDescripitonDTO iIDescripitonDTO : list) {
                cmbItem.addItem(iIDescripitonDTO.getDescription());
                cmbPartNumber.addItem(iIDescripitonDTO.getPartNumber());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void customizeTable() {
        tblItem.setDefaultRenderer(Object.class, new CustomizeTable());
        tblItem.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblItem.setRowHeight(30);
        tblItem.setShowGrid(true);
        tblItem.setFont(new Font("", 0, 20));
        scrItem.getViewport().setBackground(Color.WHITE);
    }
    
    private void customizeComp() {
        cmbItem.setBackground(Color.WHITE);
        cmbPartNumber.setBackground(Color.WHITE);
        cmbVehicleBrand.setBackground(Color.WHITE);
        cmbVehicleModel.setBackground(Color.WHITE);
        cmbItem.setFont(new Font("", 0, 18));
        cmbPartNumber.setFont(new Font("", 0, 18));
        cmbVehicleBrand.setFont(new Font("", 0, 18));
        cmbVehicleModel.setFont(new Font("", 0, 18));
        spnQty.setFont(new Font("", 0, 18));
        cmbItem.setEditable(true);
        cmbPartNumber.setEditable(true);
        cmbVehicleBrand.setEditable(true);
        cmbVehicleModel.setEditable(true);
        txtPrice.setFont(new Font("", 0, 18));
        txtItemCode.setFont(new Font("", 0, 18));
        chkSearchByQty.setBackground(Color.WHITE);
        chkSearchData.setBackground(Color.WHITE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkSearchByQty;
    private javax.swing.JCheckBox chkSearchData;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JComboBox<String> cmbPartNumber;
    private javax.swing.JComboBox<String> cmbVehicleBrand;
    private javax.swing.JComboBox<String> cmbVehicleModel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrItem;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
