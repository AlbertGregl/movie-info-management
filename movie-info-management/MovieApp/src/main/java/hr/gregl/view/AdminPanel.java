/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.gregl.view;

import hr.gregl.controller.AdminController;
import hr.gregl.utilities.FileUtils;
import hr.gregl.utilities.MessageUtils;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import static javax.swing.text.html.HTML.Attribute.DIR;

/**
 *
 * @author albert
 */
public class AdminPanel extends javax.swing.JPanel {

    private AdminController adminController;

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        this.adminController = new AdminController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnDeleteData = new javax.swing.JButton();
        btnLoadRssData1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1024, 680));
        setMinimumSize(new java.awt.Dimension(1024, 680));
        setLayout(new java.awt.GridBagLayout());

        btnDeleteData.setBackground(new java.awt.Color(204, 0, 0));
        btnDeleteData.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnDeleteData.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteData.setText("Delete Data");
        btnDeleteData.setMargin(new java.awt.Insets(10, 14, 1, 14));
        btnDeleteData.setName(""); // NOI18N
        btnDeleteData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 173;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(67, 409, 437, 342);
        add(btnDeleteData, gridBagConstraints);

        btnLoadRssData1.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnLoadRssData1.setText("Load RSS Data");
        btnLoadRssData1.setMargin(new java.awt.Insets(10, 14, 1, 14));
        btnLoadRssData1.setName(""); // NOI18N
        btnLoadRssData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadRssData1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 158;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(104, 409, 0, 342);
        add(btnLoadRssData1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDataActionPerformed

        if (MessageUtils.showConfirmDialog(
                "Delete Data from Database",
                "Do you really want to delete all Data from the database?")) {
            try {
                // Delete Data from database
                adminController.deleteAllDataFromDatabase();
                // Delete all images in the directory
                String directoryPath = DIR + File.separator;
                FileUtils.deleteFilesInDirectory(Paths.get(directoryPath));
            } catch (Exception ex) {
                Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete data!");
            }
        }

    }//GEN-LAST:event_btnDeleteDataActionPerformed

    private void btnLoadRssData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadRssData1ActionPerformed
        final JDialog loading = new JDialog((Frame) null, "Loading, please wait...", true);

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Load the data...
                adminController.parseAndSaveDataFromRSS();
                return null;
            }

            @Override
            protected void done() {
                loading.dispose();
            }
        };

        worker.execute();

        JOptionPane optionPane = new JOptionPane("Loading, please wait...", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        loading.setContentPane(optionPane);
        loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loading.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        loading.setLocation((screenSize.width - loading.getSize().width) / 2, (screenSize.height - loading.getSize().height) / 2);

        loading.setVisible(true);
    }//GEN-LAST:event_btnLoadRssData1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteData;
    private javax.swing.JButton btnLoadRssData1;
    // End of variables declaration//GEN-END:variables
}
