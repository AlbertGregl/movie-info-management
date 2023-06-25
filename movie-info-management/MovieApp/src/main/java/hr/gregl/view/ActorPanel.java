/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.gregl.view;

import hr.gregl.controller.ActorController;
import hr.gregl.controller.MovieActorDirectorController;
import hr.gregl.model.Actor;
import hr.gregl.model.Director;
import hr.gregl.model.Movie;
import hr.gregl.model.MovieActorDirector;
import hr.gregl.utilities.FileUtils;
import hr.gregl.utilities.MessageUtils;
import hr.gregl.view.model.ActorTableModel;
import hr.gregl.view.model.MovieActorDirectorTableModel;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.COPY;
import javax.swing.text.JTextComponent;
import static javax.swing.text.html.HTML.Attribute.DIR;

/**
 *
 * @author albert
 */
public class ActorPanel extends javax.swing.JPanel {

    private ActorController actorController;
    private MovieActorDirectorController madController;

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private ActorTableModel actorsTableModel;
    private MovieActorDirectorTableModel madTableModel;

    private Actor selectedActor;
    private MovieActorDirector movieActorDirector;

    private List<Director> allDirectors;
    private List<Movie> allMovies;

    /**
     * Creates new form ActorPanel
     */
    public ActorPanel() {
        initComponents();
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

        lbPicturePathError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbActors = new javax.swing.JTable();
        lbIcon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfDateOfBirth = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        DateOfBirthError = new javax.swing.JLabel();
        lbNameError = new javax.swing.JLabel();
        tfPicturePath = new javax.swing.JTextField();
        btnChooseImage = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbFilmography = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tfActor = new javax.swing.JTextField();
        cbMovies = new javax.swing.JComboBox<>();
        cbDirectors = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAddMAD = new javax.swing.JButton();

        setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1024, 680));
        setPreferredSize(new java.awt.Dimension(1024, 680));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        lbPicturePathError.setForeground(new java.awt.Color(204, 0, 0));
        lbPicturePathError.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 0);
        add(lbPicturePathError, gridBagConstraints);

        jScrollPane1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 400));
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        tbActors.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tbActors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbActors.setMaximumSize(new java.awt.Dimension(2147483647, 10000));
        tbActors.setMinimumSize(new java.awt.Dimension(576, 400));
        tbActors.setName(""); // NOI18N
        tbActors.setPreferredSize(new java.awt.Dimension(576, 600));
        tbActors.setRowMargin(1);
        tbActors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbActorsMouseClicked(evt);
            }
        });
        tbActors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbActorsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbActors);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 537;
        gridBagConstraints.ipady = 334;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(14, 6, 0, 0);
        add(jScrollPane1, gridBagConstraints);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.ipadx = -23;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 28, 0, 0);
        add(lbIcon, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel8.setText("Date Of Birth (yyyy-mm-dd)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 12, 0, 0);
        add(jLabel8, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel2.setText("Actor Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 9, 0, 0);
        add(jLabel2, gridBagConstraints);

        tfDateOfBirth.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tfDateOfBirth.setName("Date"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 253;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 12, 0, 0);
        add(tfDateOfBirth, gridBagConstraints);

        tfName.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 253;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 0, 0);
        add(tfName, gridBagConstraints);

        DateOfBirthError.setForeground(new java.awt.Color(204, 0, 0));
        DateOfBirthError.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 11, 0, 0);
        add(DateOfBirthError, gridBagConstraints);

        lbNameError.setForeground(new java.awt.Color(204, 0, 0));
        lbNameError.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 11, 0, 0);
        add(lbNameError, gridBagConstraints);

        tfPicturePath.setEditable(false);
        tfPicturePath.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tfPicturePath.setPreferredSize(new java.awt.Dimension(40, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 254;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 0, 0);
        add(tfPicturePath, gridBagConstraints);

        btnChooseImage.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnChooseImage.setText("Choose Image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 6, 0, 0);
        add(btnChooseImage, gridBagConstraints);

        btnAdd.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        add(btnAdd, gridBagConstraints);

        btnUpdate.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 34, 0, 0);
        add(btnUpdate, gridBagConstraints);

        btnDelete.setBackground(new java.awt.Color(204, 0, 51));
        btnDelete.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 245;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 12, 0, 0);
        add(btnDelete, gridBagConstraints);

        jScrollPane2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jScrollPane2.setPreferredSize(new java.awt.Dimension(100, 420));
        jScrollPane2.setVerifyInputWhenFocusTarget(false);

        tbFilmography.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tbFilmography.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbFilmography.setMaximumSize(new java.awt.Dimension(2147483647, 10000));
        tbFilmography.setMinimumSize(new java.awt.Dimension(100, 400));
        tbFilmography.setName(""); // NOI18N
        tbFilmography.setPreferredSize(new java.awt.Dimension(100, 400));
        tbFilmography.setRowMargin(1);
        jScrollPane2.setViewportView(tbFilmography);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 428;
        gridBagConstraints.ipady = 422;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 15);
        add(jScrollPane2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("Filmography");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 161;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        add(jLabel3, gridBagConstraints);

        tfActor.setMaximumSize(new java.awt.Dimension(156, 48));
        tfActor.setMinimumSize(new java.awt.Dimension(156, 48));
        tfActor.setPreferredSize(new java.awt.Dimension(156, 48));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        add(tfActor, gridBagConstraints);

        cbMovies.setMaximumSize(new java.awt.Dimension(134, 32));
        cbMovies.setMinimumSize(new java.awt.Dimension(134, 32));
        cbMovies.setPreferredSize(new java.awt.Dimension(134, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 6, 0, 0);
        add(cbMovies, gridBagConstraints);

        cbDirectors.setMaximumSize(new java.awt.Dimension(134, 32));
        cbDirectors.setMinimumSize(new java.awt.Dimension(134, 32));
        cbDirectors.setPreferredSize(new java.awt.Dimension(134, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 6, 0, 0);
        add(cbDirectors, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 382;
        gridBagConstraints.ipady = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 0);
        add(jLabel1, gridBagConstraints);

        btnAddMAD.setText("Add Filmography");
        btnAddMAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMADActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.ipadx = 322;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 15);
        add(btnAddMAD, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tbActorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbActorsMouseClicked
        showActor();
    }//GEN-LAST:event_tbActorsMouseClicked

    private void tbActorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbActorsKeyReleased
        showActor();
    }//GEN-LAST:event_tbActorsKeyReleased

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
        File file = FileUtils.uploadFile("Images", "jpg", "jpeg", "png");
        if (file == null) {
            return;
        }
        tfPicturePath.setText(file.getAbsolutePath());
        setIcon(lbIcon, file);
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!formValid()) {
            return;
        }
        try {
            String localPicturePath = uploadPicture();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dob = LocalDate.parse(tfDateOfBirth.getText().trim(), formatter);
            Actor actor = new Actor(
                    tfName.getText().trim(),
                    dob,
                    localPicturePath
            );
            actorController.createActor(actor);
            actorsTableModel.setActors(actorController.getAllActors());
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to create actor!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedActor == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose an actor to update");
            return;
        }
        if (!formValid()) {
            return;
        }
        try {
            if (!tfPicturePath.getText().trim().equals(selectedActor.getImagePath())) {
                if (selectedActor.getImagePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedActor.getImagePath()));
                }
                String localPicturePath = uploadPicture();
                selectedActor.setImagePath(localPicturePath);
            }

            selectedActor.setName(tfName.getText().trim());
            selectedActor.setDob(LocalDate.parse(tfDateOfBirth.getText().trim())); // assuming the date is formatted as 'yyyy-MM-dd'

            actorController.updateActor(selectedActor);
            actorsTableModel.setActors(actorController.getAllActors());
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to update actor!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedActor == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose an actor to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
                "Delete actor",
                "Do you really want to delete this actor?")) {
            try {
                if (selectedActor.getImagePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedActor.getImagePath()));
                }
                actorController.deleteActor(selectedActor.getActorID());
                actorsTableModel.setActors(actorController.getAllActors());
                refreshMadTableData();
                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete actor!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown

    private void btnAddMADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMADActionPerformed
        // Check if the form data is valid
        if (!madDataValid()) {
            return;
        }
        try {
            // Save the movieActorDirector model to the database
            madController.addMovieActorDirector(movieActorDirector);
            refreshMadTableData();
            clearMadData();
        } catch (Exception ex) {
            Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to add movie/actor/director relation!");
        }
    }//GEN-LAST:event_btnAddMADActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateOfBirthError;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddMAD;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Director> cbDirectors;
    private javax.swing.JComboBox<Movie> cbMovies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbNameError;
    private javax.swing.JLabel lbPicturePathError;
    private javax.swing.JTable tbActors;
    private javax.swing.JTable tbFilmography;
    private javax.swing.JTextField tfActor;
    private javax.swing.JTextField tfDateOfBirth;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPicturePath;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
            initTable();
            initTableFilmography();
            initComboBoxLists();
            initDragNDrop();
        } catch (Exception ex) {
            Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfName, tfDateOfBirth, tfPicturePath);
        errorLabels = Arrays.asList(lbNameError, DateOfBirthError, lbPicturePathError);
    }

    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }

    private void initRepository() throws Exception {
        this.actorController = new ActorController();
        this.madController = new MovieActorDirectorController();
    }

    private void initTable() {
        tbActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbActors.setAutoCreateRowSorter(true);
        tbActors.setRowHeight(25);
        actorsTableModel = new ActorTableModel(actorController.getAllActors());
        tbActors.setModel(actorsTableModel);

        actorsTableModel.setColumnWidths(tbActors);
    }

    private void initTableFilmography() {
        tbFilmography.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbFilmography.setAutoCreateRowSorter(true);
        tbFilmography.setRowHeight(25);
        madTableModel = new MovieActorDirectorTableModel(madController.selectAllMovieActorDirectors(), madController);
        tbFilmography.setModel(madTableModel);
    }

    private String uploadPicture() throws IOException {
        String picturePath = tfPicturePath.getText();
        String ext = picturePath.substring(picturePath.lastIndexOf("."));
        String pictureName = UUID.randomUUID() + ext;
        String localPicturePath = DIR + File.separator + pictureName;

        FileUtils.copy(picturePath, localPicturePath);
        return localPicturePath;
    }

    private void clearForm() {
        hideErrors();
        tfName.setText("");
        tfDateOfBirth.setText("");
        tfPicturePath.setText("");
        tfActor.setText("");
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png")));
    }

    private boolean formValid() {
        hideErrors();
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
        }
        return ok;
    }

    private void showActor() {
        clearForm();
        int selectedRow = tbActors.getSelectedRow();
        int rowIndex = tbActors.convertRowIndexToModel(selectedRow);
        int selectedActorId = (int) actorsTableModel.getValueAt(rowIndex, 0);

        try {
            Actor actor = actorController.getActorById(selectedActorId);
            selectedActor = actor;
            fillForm(actor);
        } catch (Exception ex) {
            Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show actor!");
        }
    }

    private void fillForm(Actor actor) {
        if (actor.getImagePath() != null && Files.exists(Paths.get(actor.getImagePath()))) {
            tfPicturePath.setText(actor.getImagePath());
            setIcon(lbIcon, new File(actor.getImagePath()));
        }
        tfName.setText(actor.getName());
        tfDateOfBirth.setText(actor.getDob().toString());
    }

    private void setIcon(JLabel label, File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(image);
            label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Filmography
    private void initComboBoxLists() {
        movieActorDirector = new MovieActorDirector();
        allDirectors = madController.getAllDirectors();
        allMovies = madController.getAllMovies();
        fillDirectorsComboBox();
        fillMoviesComboBox();

        // set movieActorDirector to the first actor/movie from the list
        Director firstDirector = allDirectors.get(0);
        movieActorDirector.setDirectorID(firstDirector.getDirectorID());
        Movie firstMovie = allMovies.get(0);
        movieActorDirector.setMovieID(firstMovie.getMovieID());

        // add Listeners
        cbDirectors.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Director selectedDirector = (Director) e.getItem();
                    movieActorDirector.setDirectorID(selectedDirector.getDirectorID());
                }
            }
        });

        cbMovies.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Movie selectedMovie = (Movie) e.getItem();
                    movieActorDirector.setMovieID(selectedMovie.getMovieID());
                }
            }
        });

    }

    private void fillDirectorsComboBox() {
        allDirectors.forEach(a -> cbDirectors.addItem(a));
    }

    private void fillMoviesComboBox() {
        allMovies.forEach(a -> cbMovies.addItem(a));
    }

    private boolean madDataValid() {
        return !tfActor.getText().trim().isEmpty() && movieActorDirector.getActorID() != 0;
    }

    private void refreshMadTableData() {
        madTableModel.setMads(madController.selectAllMovieActorDirectors());
    }

    private void clearMadData() {
        tfActor.setText("");
        movieActorDirector.setActorID(0);
    }

    // drag and drop
    private void initDragNDrop() {
        tbActors.setDragEnabled(true);
        tbActors.setTransferHandler(new ExportTransferHandler());

        tfActor.setTransferHandler(new ImportTransferHandler());
    }

    private class ExportTransferHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        public Transferable createTransferable(JComponent c) {
            JTable table = (JTable) c;
            int selectedRow = table.getSelectedRow();
            int rowIndex = table.convertRowIndexToModel(selectedRow);
            int selectedActorId = (int) actorsTableModel.getValueAt(rowIndex, 0);

            try {
                Actor selectedActor = actorController.getActorById(selectedActorId);
                return new ActorTransferable(selectedActor);
            } catch (Exception ex) {
                Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    private class ImportTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(ActorTransferable.actorFlavor);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            Transferable transferable = support.getTransferable();
            try {
                Actor actor = (Actor) transferable.getTransferData(ActorTransferable.actorFlavor);
                tfActor.setText(actor.getName());
                movieActorDirector.setActorID(actor.getActorID());
                return true;
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(ActorPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    public class ActorTransferable implements Transferable {

        public static final DataFlavor actorFlavor = new DataFlavor(Actor.class, "java/Actor");
        private Actor actor;

        public ActorTransferable(Actor actor) {
            this.actor = actor;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{actorFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(actorFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return actor;
        }
    }

}
