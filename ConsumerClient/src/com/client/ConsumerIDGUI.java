/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client;

import com.model.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imsil
 */
public class ConsumerIDGUI extends javax.swing.JPanel {

    /**
     * Creates new form ConsumerIDGUI
     */
    ObjectOutputStream outputObjectToServer = null;
    ObjectInputStream inputObjectFromServer = null;
    DataOutputStream outputDataToServer = null;
    DataInputStream inputDataFromServer = null;
    DefaultTableModel model = null;

    public ConsumerIDGUI() {
        initComponents();
        Object[] columns = {"Consumer Id", "First Name", "Last Name", "City", "Bill Amount", "Due Date"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        // set the model to the table
        consumerTable.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtConsumerID = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consumerTable = new javax.swing.JTable();

        txtConsumerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsumerIDActionPerformed(evt);
            }
        });
        txtConsumerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConsumerIDKeyPressed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Consumer ID :");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        consumerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(consumerTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(txtConsumerID, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsumerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClear))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents
long id = 0;
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        InitTable();
        if (Long.parseLong(txtConsumerID.getText()) > 9999999999L && Long.parseLong(txtConsumerID.getText()) < 100000000000L) {
            try {
                outputObjectToServer = IOUtility.getObjectOutputStream();
                inputObjectFromServer = IOUtility.getObjectInputStream();
                outputDataToServer = IOUtility.getDataOutputStream();
                inputDataFromServer = IOUtility.getDataInputStream();
                
                outputDataToServer.writeInt(9);
                outputDataToServer.flush();
                outputDataToServer.writeLong(Long.parseLong(txtConsumerID.getText()));
                outputDataToServer.flush();

                Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
                if (row.length == 0) {
                    throw new NoRecordException();
                }
                for (int i = 0; i < row.length; i++) {
                    model.addRow(row[i]);
                }
                id = Long.parseLong(txtConsumerID.getText());
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } catch (NoRecordException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No Such record found");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } catch (UnableToConnectException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ConsumerID must be 11 digits");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtConsumerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumerIDActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.setTxtConsumerID("");
        InitTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        List<Consumer> consumers = new ArrayList<>();

        int b = model.getRowCount();

        try {
            for (int i = b - 1; i >= 0; i--) {
                Consumer c = new Consumer();
                c.setConsumerID(Long.parseLong(model.getValueAt(i, 0).toString()));
                c.setFirstName(model.getValueAt(i, 1).toString());
                c.setLastName(model.getValueAt(i, 2).toString());
                c.setCity(model.getValueAt(i, 3).toString());
                c.setBillAmount(Double.parseDouble(model.getValueAt(i, 4).toString()));
                DateFormat df = new SimpleDateFormat("dd/MM/yy");
                c.setDueDate(df.parse(model.getValueAt(i, 5).toString()));
                consumers.add(c);
            }
            if (b < 1) {
                throw new UnableToSaveException();
            } else {
                SaveConsumerResults.saveRecords("ConsumerID-" + (id + "-"), consumers);
            }
            JOptionPane.showMessageDialog(null, "Result saved");
        } catch (ValidBillAmountException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ValidNameException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (UnableToSaveException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtConsumerIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsumerIDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            btnSearchActionPerformed(null);
        }
    }//GEN-LAST:event_txtConsumerIDKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTable consumerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtConsumerID;
    // End of variables declaration//GEN-END:variables

    public void setTxtConsumerID(String txtConsumerID) {
        this.txtConsumerID.setText(txtConsumerID);
    }

    public void InitTable() {
        int c = model.getRowCount();
        for (int i = c - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
}
