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
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imsil
 */
public class DueDateGUI extends javax.swing.JPanel {

    /**
     * Creates new form DateGUI
     */
    DefaultTableModel model = null;
    ObjectOutputStream outputObjectToServer = null;
    ObjectInputStream inputObjectFromServer = null;
    DataOutputStream outputDataToServer = null;
    DataInputStream inputDataFromServer = null;
    PrintStream printStream = null;

    public DueDateGUI() {
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

        btnGroupDate = new javax.swing.ButtonGroup();
        rbtnRegular = new javax.swing.JRadioButton();
        rbtnDefaulter = new javax.swing.JRadioButton();
        txtDate = new javax.swing.JTextField();
        btnDsiplay = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consumerTable = new javax.swing.JTable();

        btnGroupDate.add(rbtnRegular);
        rbtnRegular.setText("Regular");
        rbtnRegular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRegularActionPerformed(evt);
            }
        });

        btnGroupDate.add(rbtnDefaulter);
        rbtnDefaulter.setSelected(true);
        rbtnDefaulter.setText("Defaulter");
        rbtnDefaulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDefaulterActionPerformed(evt);
            }
        });

        txtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDateKeyPressed(evt);
            }
        });

        btnDsiplay.setText("Display");
        btnDsiplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDsiplayActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Due Date :");

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
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(rbtnDefaulter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnRegular)
                                .addGap(74, 74, 74))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(btnDsiplay))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(259, 259, 259)
                .addComponent(btnClear)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnDefaulter)
                    .addComponent(rbtnRegular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDsiplay)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClear)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnDefaulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDefaulterActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbtnDefaulterActionPerformed

    private void rbtnRegularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRegularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRegularActionPerformed
    int chk = 0;
    private void btnDsiplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDsiplayActionPerformed
        // TODO add your handling code here:
        InitTable();
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date date = new Date();
            date = df.parse(txtDate.getText());
            outputObjectToServer = IOUtility.getObjectOutputStream();
            inputObjectFromServer = IOUtility.getObjectInputStream();
            outputDataToServer = IOUtility.getDataOutputStream();
            inputDataFromServer = IOUtility.getDataInputStream();
            printStream = IOUtility.getPrintStream();

            outputDataToServer.writeInt(this.getChoice() + 6);
            outputDataToServer.flush();
            printStream.println(txtDate.getText());
            printStream.flush();

            Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
            if (row.length == 0) {
                throw new NoRecordException();
            }
            for (int i = 0; i < row.length; i++) {
                model.addRow(row[i]);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (UnableToConnectException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (NoRecordException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDsiplayActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.setTxtDate("");
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
            } else if (chk == 1) {
                SaveConsumerResults.saveRecords("Regular", consumers);
            } else if (chk == 2) {
                SaveConsumerResults.saveRecords("Defaulter", consumers);
            } else {
                throw new UnableToSaveException();
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

    private void txtDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            btnDsiplayActionPerformed(null);
        }
    }//GEN-LAST:event_txtDateKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDsiplay;
    private javax.swing.ButtonGroup btnGroupDate;
    private javax.swing.JButton btnSave;
    private javax.swing.JTable consumerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtnDefaulter;
    private javax.swing.JRadioButton rbtnRegular;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables

    public void setTxtDate(String txtDate) {
        this.txtDate.setText(txtDate);
    }

    public void InitTable() {
        int c = model.getRowCount();
        for (int i = c - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private int getChoice() {
        if (rbtnRegular.isSelected()) {
            chk = 1;
        } else if (rbtnDefaulter.isSelected()) {
            chk = 2;
        }
        return chk;
    }
}
