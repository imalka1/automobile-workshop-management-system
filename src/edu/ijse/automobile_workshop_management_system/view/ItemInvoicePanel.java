package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.controller.BrandController;
import edu.ijse.automobile_workshop_management_system.controller.IIDescriptionController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceController;
import edu.ijse.automobile_workshop_management_system.controller.ItemInvoiceDescriptionController;
import edu.ijse.automobile_workshop_management_system.controller.ModelController;
import edu.ijse.automobile_workshop_management_system.model.BrandDTO;
import edu.ijse.automobile_workshop_management_system.model.IIDescripitonDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDTO;
import edu.ijse.automobile_workshop_management_system.model.ItemInvoiceDescriptionDTO;
import edu.ijse.automobile_workshop_management_system.model.ModelDTO;
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
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Imalka
 */
public class ItemInvoicePanel extends javax.swing.JPanel {

    private DefaultTableModel modelInvoice;
    private DefaultTableModel modelItem;
    private ModelDTO modelDTO;
    private IIDescripitonDTO itemDTO;
    private int itinid;
    private int oldQty;

    public ItemInvoicePanel() {
        initComponents();
        modelInvoice = (DefaultTableModel) tblInvoice.getModel();
        modelItem = (DefaultTableModel) tblItem.getModel();
        customizeComp();
        customizeTable();
        loadInvoice();
        loadItems();
        loadComboBrand();
        editorComboBrand();
        editorComboModel();
        editorComboBoxInvoiceName();
        editorComboBoxAddress();
        editorComboItem();
        editorComboPartNo();
        AutoCompleteDecorator.decorate(cmbInvoiceName);
        AutoCompleteDecorator.decorate(cmbAddress);
        AutoCompleteDecorator.decorate(cmbVehicleBrand);
        AutoCompleteDecorator.decorate(cmbVehicleModel);
        AutoCompleteDecorator.decorate(cmbItem);
        AutoCompleteDecorator.decorate(cmbPartNumber);
    }

    private void loadInvoice() {
        try {
            ArrayList<ItemInvoiceDTO> itemList = ItemInvoiceController.getInvoiceName();
            cmbInvoiceName.removeAllItems();
            cmbInvoiceName.addItem("Select");
            cmbInvoiceName.setSelectedItem("Select");
            for (ItemInvoiceDTO itemInvoiceDTO : itemList) {
                cmbInvoiceName.addItem(itemInvoiceDTO.getName());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAddress() {
        try {
            ArrayList<ItemInvoiceDTO> itemList = ItemInvoiceController.getInvoiceAddress(new ItemInvoiceDTO(cmbInvoiceName.getSelectedItem().toString()));
            cmbAddress.removeAllItems();
            cmbAddress.addItem("Select");
            cmbAddress.setSelectedItem("Select");
            for (ItemInvoiceDTO itemInvoiceDTO : itemList) {
                cmbAddress.addItem(itemInvoiceDTO.getAddress());
            }
            cmbAddress.setSelectedIndex(cmbAddress.getItemCount() - 1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void editorComboBoxInvoiceName() {
        cmbInvoiceName.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    loadAddress();
                }
            }

        });
    }

    private void editorComboBoxAddress() {
        cmbAddress.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addToSQLTable();
                    addToInvoiceTable();
                }
            }

        });
    }

    private void addToInvoiceTable() {
        try {
            ItemInvoiceDTO itemInvoiceDTO = ItemInvoiceController.getItinid(new ItemInvoiceDTO(txtInvoiceNumber.getText(), cmbInvoiceName.getSelectedItem().toString(), cmbAddress.getSelectedItem().toString()));
            Object[] ob = {itemInvoiceDTO.getItinid(), txtInvoiceNumber.getText(), cmbInvoiceName.getSelectedItem(), cmbAddress.getSelectedItem()};
            modelInvoice.addRow(ob);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addToSQLTable() {
        try {
            ItemInvoiceDTO itemInvoiceDTO = ItemInvoiceController.getItinid(new ItemInvoiceDTO(txtInvoiceNumber.getText(), cmbInvoiceName.getSelectedItem().toString(), cmbAddress.getSelectedItem().toString()));
            if (itemInvoiceDTO != null) {
                ItemInvoiceDTO invoiceDTO = new ItemInvoiceDTO();
                invoiceDTO.setInvoiceNumber(txtInvoiceNumber.getText());
                ArrayList<ItemInvoiceDTO> data = ItemInvoiceController.getInvoiceData(invoiceDTO);
                while (modelInvoice.getRowCount() != 0) {
                    modelInvoice.removeRow(0);
                }
                for (ItemInvoiceDTO item : data) {
                    Object[] ob = {item.getItinid(), item.getInvoiceNumber(), item.getName(), item.getAddress()};
                    modelInvoice.addRow(ob);
                }
            } else {
                ItemInvoiceController.addInvoice(new ItemInvoiceDTO(txtInvoiceNumber.getText(), cmbInvoiceName.getSelectedItem().toString(), cmbAddress.getSelectedItem().toString()));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                System.out.println("error");
            } else {
                Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private String[] calculateData() {
        String[] data = new String[4];
        if (!(cmbItem.getSelectedItem().toString().isEmpty()) && !(spnQty.getValue().toString().isEmpty()) && !(txtPrice.getText().isEmpty())) {
            if (tblItem.getSelectedRow() == -1) {
                Object[] ob = {("II0" + txtItemCode.getText()), cmbItem.getSelectedItem().toString(), cmbPartNumber.getSelectedItem().toString(), cmbVehicleBrand.getSelectedItem().toString(), cmbVehicleModel.getSelectedItem().toString(), spnQty.getValue(), txtPrice.getText()};
                int count = 0;
                for (int i = 0; i < modelItem.getRowCount(); i++) {
                    if (tblItem.getValueAt(i, 0).toString().equals("II0" + txtItemCode.getText())) {
                        data[0] = "update";
                        int newQty = Integer.parseInt(tblItem.getValueAt(i, 5).toString()) + Integer.parseInt(spnQty.getValue().toString());
                        Object[] obj = {txtPrice.getText(), newQty};
                        tblItem.setValueAt(obj[0], i, 6);
                        tblItem.setValueAt(obj[1], i, 5);
                        data[1] = spnQty.getValue().toString();
                        data[2] = tblItem.getValueAt(i, 6).toString();
                        data[3] = i + "";
                        count++;
                    }
                }
                if (count == 0) {
                    modelItem.addRow(ob);
                    data[0] = "add";
                    data[1] = tblItem.getValueAt(tblItem.getRowCount() - 1, 5).toString();
                    data[2] = tblItem.getValueAt(tblItem.getRowCount() - 1, 6).toString();
                }

            } else if (tblItem.getSelectedRow() > -1) {
                Object[] ob = {("II0" + txtItemCode.getText()), cmbItem.getSelectedItem().toString(), txtPrice.getText(), spnQty.getValue()};
                oldQty = Integer.parseInt(tblItem.getValueAt(tblItem.getSelectedRow(), 5).toString());
                int count = 0;
                for (int i = 0; i < modelItem.getRowCount(); i++) {
                    if (tblItem.getValueAt(i, 0).toString().equals("II0" + txtItemCode.getText())) {
                        data[0] = "update";
                        int newQty = Integer.parseInt(spnQty.getValue().toString());
                        Object[] obj = {txtPrice.getText(), newQty};
                        tblItem.setValueAt(obj[0], i, 6);
                        tblItem.setValueAt(obj[1], i, 5);
                        data[1] = tblItem.getValueAt(i, 5).toString();
                        data[2] = tblItem.getValueAt(i, 6).toString();
                        data[3] = -1 + "";
                        count++;
                    }
                }
                if (count == 0) {
                    modelItem.addRow(ob);
                    data[0] = "add";
                    data[1] = tblItem.getValueAt(tblItem.getRowCount() - 1, 5).toString();
                    data[2] = tblItem.getValueAt(tblItem.getRowCount() - 1, 6).toString();
                }
            }
        }
        return data;
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
                    cmbVehicleModel.removeAllItems();
                    cmbVehicleModel.addItem("Select");
                    cmbVehicleModel.setSelectedItem("Select");
                } else if (cmbVehicleBrand.getSelectedIndex() == -1 && !(cmbVehicleBrand.getSelectedItem().equals(""))) {
                    BrandController.addBrand(cmbVehicleBrand.getSelectedItem().toString());
                    loadComboBrand();
                }
                loadComboModel();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void editorComboModel() {
        cmbVehicleModel.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (!chkSearchData.isSelected()) {
                            ArrayList<ItemInvoiceDTO> itemInvoiceDTOs = ItemInvoiceController.getInvoiceData(new ItemInvoiceDTO(txtInvoiceNumber.getText(), cmbInvoiceName.getSelectedItem().toString(), cmbAddress.getSelectedItem().toString()));
                            if (itemInvoiceDTOs != null) {
                                while (modelInvoice.getRowCount() != 0) {
                                    modelInvoice.removeRow(0);
                                }
                                for (ItemInvoiceDTO itemInvoiceDTO : itemInvoiceDTOs) {
                                    Object[] ob = {itemInvoiceDTO.getItinid(), itemInvoiceDTO.getInvoiceNumber(), itemInvoiceDTO.getName(), itemInvoiceDTO.getAddress()};
                                    modelInvoice.addRow(ob);
                                }

                            }
                        } else {
                            if (!chkSearchByQty.isSelected()) {
                                ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
                                descriptionDTO.setDescription(cmbItem.getSelectedItem().toString());
                                descriptionDTO.setModelName(cmbVehicleModel.getSelectedItem().toString());
                                ArrayList<ItemInvoiceDescriptionDTO> itemInvoiceDTOs = ItemInvoiceDescriptionController.getAllDataUsingDescAndModel(descriptionDTO);
                                clearTableItem();
                                for (ItemInvoiceDescriptionDTO itemInvoiceDTO : itemInvoiceDTOs) {
                                    Object[] ob = {"II0" + itemInvoiceDTO.getItindid(), itemInvoiceDTO.getDescription(), itemInvoiceDTO.getPartNumber(), itemInvoiceDTO.getBrandName(), itemInvoiceDTO.getModelName(), itemInvoiceDTO.getQty(), itemInvoiceDTO.getPrice()};
                                    modelItem.addRow(ob);
                                }
                            } else {
                                ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
                                descriptionDTO.setDescription(cmbItem.getSelectedItem().toString());
                                descriptionDTO.setModelName(cmbVehicleModel.getSelectedItem().toString());
                                descriptionDTO.setQty((int) spnQty.getValue());
                                ArrayList<ItemInvoiceDescriptionDTO> itemInvoiceDTOs = ItemInvoiceDescriptionController.getAllDataUsingDescAndModelAndQty(descriptionDTO);
                                clearTableItem();
                                for (ItemInvoiceDescriptionDTO itemInvoiceDTO : itemInvoiceDTOs) {
                                    Object[] ob = {"II0" + itemInvoiceDTO.getItindid(), itemInvoiceDTO.getDescription(), itemInvoiceDTO.getPartNumber(), itemInvoiceDTO.getBrandName(), itemInvoiceDTO.getModelName(), itemInvoiceDTO.getQty(), itemInvoiceDTO.getPrice()};
                                    modelItem.addRow(ob);
                                }
                            }
                        }
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
    }

    private void editorComboItem() {
        cmbItem.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    IIDescripitonDTO iid = new IIDescripitonDTO();
                    ModelDTO mdto=new ModelDTO();
                    BrandDTO brandDTO=new BrandDTO();
                    brandDTO.setBrandName(cmbVehicleBrand.getSelectedItem().toString());
                    mdto.setModelName(cmbVehicleModel.getSelectedItem().toString());
                    mdto.setBrandid(BrandController.getBrandId(brandDTO).getBrandid());
                    iid.setDescription(cmbItem.getSelectedItem().toString());
                    iid.setMid(ModelController.getMid(mdto).getMid());
                    IIDescripitonDTO iIDescripitonDTO = IIDescriptionController.getItemAndPartNo(iid);
                    if (iIDescripitonDTO != null) {
                        cmbPartNumber.setSelectedItem(iIDescripitonDTO.getPartNumber());
                        txtItemCode.setText(iIDescripitonDTO.getIidid() + "");
                    }
                    if (chkSearchData.isSelected()) {
                        ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
                        descriptionDTO.setDescription(cmbItem.getSelectedItem().toString());
                        ArrayList<ItemInvoiceDescriptionDTO> itemInvoiceDTOs = ItemInvoiceDescriptionController.getAllDataUsingDesc(descriptionDTO);
                        clearTableItem();
                        if (itemInvoiceDTOs != null) {
                            for (ItemInvoiceDescriptionDTO itemInvoiceDTO : itemInvoiceDTOs) {
                                Object[] ob = {"II0" + itemInvoiceDTO.getItindid(), itemInvoiceDTO.getDescription(), itemInvoiceDTO.getPartNumber(), itemInvoiceDTO.getBrandName(), itemInvoiceDTO.getModelName(), itemInvoiceDTO.getQty(), itemInvoiceDTO.getPrice()};
                                modelItem.addRow(ob);
                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
    }

    private void editorComboPartNo() {
        cmbPartNumber.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        IIDescripitonDTO iid = new IIDescripitonDTO();
                        iid.setPartNumber(cmbPartNumber.getSelectedItem().toString());
                        IIDescripitonDTO iIDescripitonDTO = IIDescriptionController.getItemAndPartNo(iid);
                        cmbItem.setSelectedItem(iIDescripitonDTO.getDescription());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
    }

    private void addToInvoice() {
        try {
            String[] data = calculateData();
            if (data[0].equals("add")) {
                ItemInvoiceDescriptionController.addItem(new ItemInvoiceDescriptionDTO(itemDTO.getIidid(), itinid, (int) spnQty.getValue(), Double.parseDouble(txtPrice.getText())));
            } else if (data[0].equals("update") && !(data[3].equals("-1"))) {
                updateData(data, getNumberfromKey(tblItem.getValueAt(Integer.parseInt(data[3]), 0).toString()));
            } else if (data[0].equals("update") && (data[3].equals("-1"))) {
                updateData(data, getNumberfromKey(tblItem.getValueAt(tblItem.getSelectedRow(), 0).toString()));
                tblItem.clearSelection();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateData(String[] data, int value) {
        try {
            if (tblItem.getSelectedRow() == -1) {
                ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
                descriptionDTO.setQty(Integer.parseInt(data[1]));
                descriptionDTO.setPrice(Double.parseDouble(data[2]));
                descriptionDTO.setItindid(value);
                ItemInvoiceDescriptionController.updateItemWithPrice(descriptionDTO);
            } else if (tblItem.getSelectedRow() > -1) {
                int newQty = Integer.parseInt(data[1]) - oldQty;
                ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
                descriptionDTO.setQty(newQty);
                descriptionDTO.setPrice(Double.parseDouble(data[2]));
                descriptionDTO.setItindid(value);
                ItemInvoiceDescriptionController.updateItemWithPrice(descriptionDTO);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comboItem() {
        if (!(cmbItem.getSelectedItem().equals("Select")) && !(cmbItem.getSelectedItem().equals(""))) {
            if (itemId() != null && cmbItem.getSelectedIndex() > -1) {
                itemDTO = itemId();
            } else {
                try {
                    IIDescriptionController.addItem(new IIDescripitonDTO(cmbItem.getSelectedItem().toString(), cmbPartNumber.getSelectedItem().toString(), modelDTO.getMid()));
                    itemDTO = itemId();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void comboModel() {
        if (!(cmbVehicleModel.getSelectedItem().equals("Select")) && !(cmbVehicleModel.getSelectedItem().equals(""))) {
            if (modelId() != null && cmbVehicleModel.getSelectedIndex() > -1) {
                modelDTO = modelId();
            } else if (cmbVehicleModel.getSelectedIndex() == -1 && !(cmbVehicleModel.getSelectedItem().equals(""))) {
                try {
                    ModelController.addModel(cmbVehicleModel.getSelectedItem().toString(), brandId().getBrandid());
                    modelDTO = modelId();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerVehiclePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private IIDescripitonDTO itemId() {
        try {
            IIDescripitonDTO iIDescripitonDTO = IIDescriptionController.getIid(new IIDescripitonDTO(cmbItem.getSelectedItem().toString(), cmbPartNumber.getSelectedItem().toString(), modelDTO.getMid()));
            return iIDescripitonDTO;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    private void customizeComp() {
        cmbInvoiceName.setBackground(Color.WHITE);
        cmbInvoiceName.setFont(new Font("", 0, 18));
        cmbAddress.setBackground(Color.WHITE);
        cmbAddress.setFont(new Font("", 0, 18));
        cmbItem.setBackground(Color.WHITE);
        cmbPartNumber.setBackground(Color.WHITE);
        cmbVehicleBrand.setBackground(Color.WHITE);
        cmbVehicleModel.setBackground(Color.WHITE);
        cmbItem.setFont(new Font("", 0, 18));
        cmbPartNumber.setFont(new Font("", 0, 18));
        cmbVehicleBrand.setFont(new Font("", 0, 18));
        cmbVehicleModel.setFont(new Font("", 0, 18));
        spnQty.setFont(new Font("", 0, 18));
        cmbInvoiceName.setEditable(true);
        cmbAddress.setEditable(true);
        cmbItem.setEditable(true);
        cmbPartNumber.setEditable(true);
        cmbVehicleBrand.setEditable(true);
        cmbVehicleModel.setEditable(true);
        txtInvoiceNumber.setFont(new Font("", 0, 18));
        txtPrice.setFont(new Font("", 0, 18));
        txtItemCode.setFont(new Font("", 0, 18));
        chkSearchByQty.setBackground(Color.WHITE);
        chkSearchData.setBackground(Color.WHITE);
    }

    private void customizeTable() {
        tblInvoice.setDefaultRenderer(Object.class, new CustomizeTable());
        tblInvoice.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblInvoice.setRowHeight(30);
        tblInvoice.setShowGrid(true);
        tblInvoice.setFont(new Font("", 0, 20));
        scrInvoice.getViewport().setBackground(Color.WHITE);
        tblItem.setDefaultRenderer(Object.class, new CustomizeTable());
        tblItem.getTableHeader().setDefaultRenderer(new CustomizeTableHeader());
        tblItem.setRowHeight(30);
        tblItem.setShowGrid(true);
        tblItem.setFont(new Font("", 0, 20));
        scrItem.getViewport().setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrInvoice = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        scrItem = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        txtInvoiceNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbAddress = new javax.swing.JComboBox<>();
        cmbInvoiceName = new javax.swing.JComboBox<>();
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
        chkSearchByQty = new javax.swing.JCheckBox();
        chkSearchData = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(58, 58, 58));
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 990));
        jPanel1.setLayout(null);
        add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 1080);

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Invoice Number", "Invoice Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoice.getTableHeader().setReorderingAllowed(false);
        tblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoiceMouseClicked(evt);
            }
        });
        scrInvoice.setViewportView(tblInvoice);
        if (tblInvoice.getColumnModel().getColumnCount() > 0) {
            tblInvoice.getColumnModel().getColumn(0).setResizable(false);
            tblInvoice.getColumnModel().getColumn(1).setResizable(false);
            tblInvoice.getColumnModel().getColumn(2).setResizable(false);
            tblInvoice.getColumnModel().getColumn(3).setResizable(false);
        }

        add(scrInvoice);
        scrInvoice.setBounds(240, 140, 1670, 270);

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
        if (tblItem.getColumnModel().getColumnCount() > 0) {
            tblItem.getColumnModel().getColumn(0).setResizable(false);
            tblItem.getColumnModel().getColumn(1).setResizable(false);
            tblItem.getColumnModel().getColumn(2).setResizable(false);
            tblItem.getColumnModel().getColumn(3).setResizable(false);
            tblItem.getColumnModel().getColumn(4).setResizable(false);
            tblItem.getColumnModel().getColumn(5).setResizable(false);
            tblItem.getColumnModel().getColumn(6).setResizable(false);
        }

        add(scrItem);
        scrItem.setBounds(240, 550, 1670, 320);
        add(txtInvoiceNumber);
        txtInvoiceNumber.setBounds(410, 20, 430, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Invoice Number");
        add(jLabel3);
        jLabel3.setBounds(240, 20, 160, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Address");
        add(jLabel4);
        jLabel4.setBounds(1140, 80, 80, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Invoice Name");
        add(jLabel5);
        jLabel5.setBounds(240, 80, 160, 40);

        add(cmbAddress);
        cmbAddress.setBounds(1250, 80, 660, 40);

        add(cmbInvoiceName);
        cmbInvoiceName.setBounds(410, 80, 660, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Qty");
        add(jLabel6);
        jLabel6.setBounds(1120, 490, 60, 40);

        add(cmbItem);
        cmbItem.setBounds(310, 490, 750, 40);

        add(cmbVehicleBrand);
        cmbVehicleBrand.setBounds(1190, 430, 310, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Price");
        add(jLabel7);
        jLabel7.setBounds(1520, 490, 60, 40);

        add(cmbVehicleModel);
        cmbVehicleModel.setBounds(1590, 430, 310, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Part Number");
        add(jLabel8);
        jLabel8.setBounds(630, 430, 120, 40);
        add(spnQty);
        spnQty.setBounds(1190, 490, 110, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("II0");
        add(jLabel9);
        jLabel9.setBounds(370, 430, 40, 40);

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        add(txtPrice);
        txtPrice.setBounds(1590, 490, 310, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Brand");
        add(jLabel10);
        jLabel10.setBounds(1120, 430, 60, 40);

        add(cmbPartNumber);
        cmbPartNumber.setBounds(750, 430, 310, 40);

        txtItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemCodeActionPerformed(evt);
            }
        });
        add(txtItemCode);
        txtItemCode.setBounds(410, 430, 160, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("Item");
        add(jLabel11);
        jLabel11.setBounds(240, 490, 60, 40);

        chkSearchByQty.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkSearchByQty.setText(" Search By Qty");
        add(chkSearchByQty);
        chkSearchByQty.setBounds(1470, 20, 180, 33);

        chkSearchData.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        chkSearchData.setText(" Search Data");
        add(chkSearchData);
        chkSearchData.setBounds(1250, 20, 170, 33);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Model");
        add(jLabel12);
        jLabel12.setBounds(1520, 430, 60, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Item Code");
        add(jLabel13);
        jLabel13.setBounds(240, 430, 110, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        comboModel();
        comboItem();
        addToInvoice();
        loadComboModel();
        loadComboBrand();
        loadItems();
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemCodeActionPerformed
        setInvoice();
    }//GEN-LAST:event_txtItemCodeActionPerformed

    private void setInvoice() {
        try {
            ItemInvoiceDescriptionDTO descriptionDTO = new ItemInvoiceDescriptionDTO();
            descriptionDTO.setItindid(Integer.parseInt(txtItemCode.getText()));
            ItemInvoiceDTO itemInvoiceDTO = ItemInvoiceController.getItemData(descriptionDTO);
            while (modelInvoice.getRowCount() != 0) {
                modelInvoice.removeRow(0);
            }
            if (itemInvoiceDTO != null) {
                Object[] ob = {itemInvoiceDTO.getItinid(), itemInvoiceDTO.getInvoiceNumber(), itemInvoiceDTO.getName(), itemInvoiceDTO.getAddress()};
                modelInvoice.addRow(ob);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoiceMouseClicked
        getItemsFromInvoice();
    }//GEN-LAST:event_tblInvoiceMouseClicked

    private void getItemsFromInvoice() {
        try {
            if (tblInvoice.getSelectedRow() > -1) {
                itinid=Integer.parseInt(tblInvoice.getValueAt(tblInvoice.getSelectedRow(), 0).toString());
                ItemInvoiceDescriptionDTO iiddto = new ItemInvoiceDescriptionDTO();
                iiddto.setItinid((int) tblInvoice.getValueAt(tblInvoice.getSelectedRow(), 0));
                ArrayList<ItemInvoiceDescriptionDTO> itemInvoiceDescriptionDTOs = ItemInvoiceDescriptionController.getAllDataUsingInvoice(iiddto);
                clearTableItem();
                for (ItemInvoiceDescriptionDTO itemInvoiceDescriptionDTO : itemInvoiceDescriptionDTOs) {
                    Object[] ob = {"II0" + itemInvoiceDescriptionDTO.getItindid(), itemInvoiceDescriptionDTO.getDescription(), itemInvoiceDescriptionDTO.getPartNumber(), itemInvoiceDescriptionDTO.getBrandName(), itemInvoiceDescriptionDTO.getModelName(), itemInvoiceDescriptionDTO.getQty(), itemInvoiceDescriptionDTO.getPrice()};
                    modelItem.addRow(ob);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemInvoicePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearTableItem() {
        while (modelItem.getRowCount() != 0) {
            modelItem.removeRow(0);
        }
    }
    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked
        if (tblItem.getSelectedRow() > -1) {
            txtItemCode.setText(getNumberfromKey(tblItem.getValueAt(tblItem.getSelectedRow(), 0).toString()) + "");
            cmbItem.setSelectedItem(tblItem.getValueAt(tblItem.getSelectedRow(), 1));
            cmbPartNumber.setSelectedItem(tblItem.getValueAt(tblItem.getSelectedRow(), 2));
            cmbVehicleBrand.setSelectedItem(tblItem.getValueAt(tblItem.getSelectedRow(), 3));
            cmbVehicleModel.setSelectedItem(tblItem.getValueAt(tblItem.getSelectedRow(), 4));
            spnQty.setValue(tblItem.getValueAt(tblItem.getSelectedRow(), 5));
            txtPrice.setText(tblItem.getValueAt(tblItem.getSelectedRow(), 6).toString());
            setInvoice();
        }

    }//GEN-LAST:event_tblItemMouseClicked

    private int getNumberfromKey(String key) {
        char[] keyArr = key.toCharArray();
        String number="";
        for (int i = 3; i < keyArr.length; i++) {
            number+= keyArr[i];
        }       
        int value = Integer.parseInt(number);
        return value;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkSearchByQty;
    private javax.swing.JCheckBox chkSearchData;
    private javax.swing.JComboBox<String> cmbAddress;
    private javax.swing.JComboBox<String> cmbInvoiceName;
    private javax.swing.JComboBox<String> cmbItem;
    private javax.swing.JComboBox<String> cmbPartNumber;
    private javax.swing.JComboBox<String> cmbVehicleBrand;
    private javax.swing.JComboBox<String> cmbVehicleModel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrInvoice;
    private javax.swing.JScrollPane scrItem;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JTable tblItem;
    private javax.swing.JTextField txtInvoiceNumber;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
