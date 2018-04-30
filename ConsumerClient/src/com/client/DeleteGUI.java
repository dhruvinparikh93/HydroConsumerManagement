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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author imsil
 */
public class DeleteGUI extends javax.swing.JPanel {

    /**
     * Creates new form DeleteGUI
     */
    ObjectOutputStream outputObjectToServer = null;
    ObjectInputStream inputObjectFromServer = null;
    DataOutputStream outputDataToServer = null;
    DataInputStream inputDataFromServer = null;
    PrintStream printStream = null;
    DefaultTableModel model = null;

    public DeleteGUI() {
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

        btnClear = new javax.swing.JButton();
        txtConsumerID = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consumerTable = new javax.swing.JTable();
        btnDisplayAll = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

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

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        consumerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(consumerTable);

        btnDisplayAll.setText("Display All");
        btnDisplayAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayAllActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ConsumerID", "Defaulter", "Regular", ">Bill", "<Bill", ">=Bill", "<=Bill", "=Bill", "City" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(92, 92, 92)
                        .addComponent(btnDisplayAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(txtConsumerID, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(btnDelete)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConsumerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnSave)
                    .addComponent(btnDisplayAll))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.setTxtConsumerID("");
        InitTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtConsumerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsumerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConsumerIDActionPerformed
    long id = 0;
    String city = "";
    int chk = 0;
    double bill = 0;
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        InitTable();
        int c;
        try {
            outputObjectToServer = IOUtility.getObjectOutputStream();
            inputObjectFromServer = IOUtility.getObjectInputStream();
            outputDataToServer = IOUtility.getDataOutputStream();
            inputDataFromServer = IOUtility.getDataInputStream();
            printStream = IOUtility.getPrintStream();
        } catch (UnableToConnectException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        switch (jComboBox1.getSelectedIndex()) {

            case 0:
                if (Long.parseLong(txtConsumerID.getText()) > 9999999999L && Long.parseLong(txtConsumerID.getText()) < 100000000000L) {
                    try {
                        outputDataToServer.writeInt(13);
                        outputDataToServer.flush();
                        outputDataToServer.writeLong(Long.parseLong(txtConsumerID.getText()));
                        outputDataToServer.flush();
                        int cnt = inputDataFromServer.readInt();
                        id = Long.parseLong(txtConsumerID.getText());

                        Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
                        if (row.length == 0) {
                            throw new NoRecordException();
                        }
                        for (int i = 0; i < row.length; i++) {
                            model.addRow(row[i]);
                        }
                        id = Long.parseLong(txtConsumerID.getText());
                        chk = jComboBox1.getSelectedIndex();
                        JOptionPane.showMessageDialog(null, cnt + " record/s deleted");
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } catch (NoRecordException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } catch (NullPointerException ex) {
                        JOptionPane.showMessageDialog(null, "No such records");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ConsumerID must be 11 digits");
                }
                break;
            case 1:
            case 2:
                DateFormat df = new SimpleDateFormat("dd/MM/yy");
                 {
                    try {
                        Date date = new Date();
                        date = df.parse(txtConsumerID.getText());
                        outputDataToServer.writeInt(jComboBox1.getSelectedIndex() + 13);
                        outputDataToServer.flush();
                        printStream.println(txtConsumerID.getText());
                        printStream.flush();

                        c = inputDataFromServer.readInt();

                        Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
                        if (row.length == 0) {
                            throw new NoRecordException();
                        }
                        for (int i = 0; i < row.length; i++) {
                            model.addRow(row[i]);
                        }
                        chk = jComboBox1.getSelectedIndex();
                        JOptionPane.showMessageDialog(null, c + " record/s deleted");
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } catch (NoRecordException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    } catch (NullPointerException ex) {
                        JOptionPane.showMessageDialog(null, "No such records");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7: {
                try {
                    outputDataToServer.writeInt(jComboBox1.getSelectedIndex() + 13);
                    outputDataToServer.flush();
                    outputDataToServer.writeDouble(Double.parseDouble(txtConsumerID.getText()));
                    outputDataToServer.flush();
                    c = inputDataFromServer.readInt();
                    Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
                    if (row.length == 0) {
                        throw new NoRecordException();
                    }
                    for (int i = 0; i < row.length; i++) {
                        model.addRow(row[i]);
                    }
                    bill = Double.parseDouble(txtConsumerID.getText());
                    chk = jComboBox1.getSelectedIndex();
                    JOptionPane.showMessageDialog(null, c + " record/s deleted");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (NoRecordException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "No such records");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            break;
            case 8: {
                try {
                    outputDataToServer.writeInt(jComboBox1.getSelectedIndex() + 13);
                    outputDataToServer.flush();
                    printStream.println(txtConsumerID.getText());
                    printStream.flush();
                    c = inputDataFromServer.readInt();
                    Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
                    if (row.length == 0) {
                        throw new NoRecordException();
                    }
                    for (int i = 0; i < row.length; i++) {
                        model.addRow(row[i]);
                    }
                    city = txtConsumerID.getText();
                    chk = jComboBox1.getSelectedIndex();
                    JOptionPane.showMessageDialog(null, c + " record/s deleted");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (NoRecordException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "No such records");
                } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            }
            break;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
                switch (chk) {
                    case 0:
                        SaveConsumerResults.saveRecords("Delete-" + id + "-", consumers);
                        break;
                    case 1:
                        SaveConsumerResults.saveRecords("Delete-Defaulter-", consumers);
                        break;
                    case 2:
                        SaveConsumerResults.saveRecords("Delete-Regular-", consumers);
                        break;
                    case 3:
                        SaveConsumerResults.saveRecords("Delete-GT-" + bill + "-", consumers);
                        break;
                    case 4:
                        SaveConsumerResults.saveRecords("Delete-LE-" + bill + "-", consumers);
                        break;
                    case 5:
                        SaveConsumerResults.saveRecords("Delete-GE-" + bill + "-", consumers);
                        break;
                    case 6:
                        SaveConsumerResults.saveRecords("Delete-LT-" + bill + "-", consumers);
                        break;
                    case 7:
                        SaveConsumerResults.saveRecords("Delete-E-" + bill + "-", consumers);
                        break;
                    case 8:
                        SaveConsumerResults.saveRecords("Delete-CITY-" + city + "-", consumers);
                        break;
                    case 9:
                        SaveConsumerResults.saveRecords("All Records-", consumers);
                        break;
                }
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

    private void btnDisplayAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayAllActionPerformed
        InitTable();
        try {
            outputObjectToServer = IOUtility.getObjectOutputStream();
            inputObjectFromServer = IOUtility.getObjectInputStream();
            outputDataToServer = IOUtility.getDataOutputStream();
            inputDataFromServer = IOUtility.getDataInputStream();
            printStream = IOUtility.getPrintStream();
            // TODO add your handling code here:
            outputDataToServer.writeInt(22);
            outputDataToServer.flush();
            Object[][] row = CreateTable.getRow((List<Consumer>) inputObjectFromServer.readObject());
            if (row.length == 0) {
                throw new NoRecordException();
            }
            for (int i = 0; i < row.length; i++) {
                model.addRow(row[i]);
            }
            chk = 9;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (NoRecordException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (UnableToConnectException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDisplayAllActionPerformed

    private void txtConsumerIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsumerIDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            btnDeleteActionPerformed(null);
        }
    }//GEN-LAST:event_txtConsumerIDKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplayAll;
    private javax.swing.JButton btnSave;
    private javax.swing.JTable consumerTable;
    private javax.swing.JComboBox<String> jComboBox1;
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
