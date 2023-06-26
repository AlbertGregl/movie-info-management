/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.gregl.view;

import hr.gregl.controller.MovieController;
import hr.gregl.model.Movie;
import hr.gregl.utilities.FileUtils;
import hr.gregl.utilities.IconUtils;
import hr.gregl.utilities.MessageUtils;
import hr.gregl.view.model.MovieTableModel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;
import static javax.swing.text.html.HTML.Attribute.DIR;

/**
 *
 * @author albert
 */
public class MoviePanel extends javax.swing.JPanel {
    
    private static final int MAX_ICON_HEIGHT = 260;

    private MovieController movieController;

    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private MovieTableModel moviesTableModel;

    private Movie selectedMovie;

    /**
     * Creates new form MoviePanel
     */
    public MoviePanel() {
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
        tbMovies = new javax.swing.JTable();
        lbIcon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfReleaseYear = new javax.swing.JTextField();
        tfTitle = new javax.swing.JTextField();
        ReleaseYearError = new javax.swing.JLabel();
        lbTitleError = new javax.swing.JLabel();
        tfPicturePath = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();
        tfGenre = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lbGenreError = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1024, 680));
        setName(""); // NOI18N
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
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        add(lbPicturePathError, gridBagConstraints);

        jScrollPane1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        tbMovies.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tbMovies.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMovies.setMaximumSize(new java.awt.Dimension(2147483647, 10000));
        tbMovies.setMinimumSize(new java.awt.Dimension(300, 400));
        tbMovies.setName(""); // NOI18N
        tbMovies.setPreferredSize(new java.awt.Dimension(300, 600));
        tbMovies.setRowMargin(1);
        tbMovies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMoviesMouseClicked(evt);
            }
        });
        tbMovies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbMoviesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovies);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 996;
        gridBagConstraints.ipady = 263;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 36, 0);
        add(jScrollPane1, gridBagConstraints);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 190, 0, 0);
        add(lbIcon, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel8.setText("Release Year (yyyy)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 18, 0, 0);
        add(jLabel8, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel2.setText("Title");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 15, 0, 0);
        add(jLabel2, gridBagConstraints);

        tfReleaseYear.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tfReleaseYear.setName("Date"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 253;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        add(tfReleaseYear, gridBagConstraints);

        tfTitle.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 253;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 18, 0, 0);
        add(tfTitle, gridBagConstraints);

        ReleaseYearError.setForeground(new java.awt.Color(204, 0, 0));
        ReleaseYearError.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(ReleaseYearError, gridBagConstraints);

        lbTitleError.setForeground(new java.awt.Color(204, 0, 0));
        lbTitleError.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 12, 0, 0);
        add(lbTitleError, gridBagConstraints);

        tfPicturePath.setEditable(false);
        tfPicturePath.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tfPicturePath.setPreferredSize(new java.awt.Dimension(40, 21));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 346;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 6, 0, 0);
        add(tfPicturePath, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel4.setText("Genre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 18, 0, 0);
        add(jLabel4, gridBagConstraints);

        btnChooseImage.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnChooseImage.setText("Choose Image");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 18, 0, 0);
        add(btnChooseImage, gridBagConstraints);

        tfGenre.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 253;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 0, 0);
        add(tfGenre, gridBagConstraints);

        btnAdd.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 0);
        add(btnAdd, gridBagConstraints);

        lbGenreError.setForeground(new java.awt.Color(204, 0, 0));
        lbGenreError.setText("X");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(lbGenreError, gridBagConstraints);

        btnUpdate.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
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
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.ipadx = 245;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        add(btnDelete, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void tbMoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMoviesMouseClicked
        showMovie();
    }//GEN-LAST:event_tbMoviesMouseClicked

    private void tbMoviesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMoviesKeyReleased
        showMovie();
    }//GEN-LAST:event_tbMoviesKeyReleased

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
            Movie movie = new Movie(
                    tfTitle.getText().trim(),
                    tfGenre.getText().trim(),
                    Integer.parseInt(tfReleaseYear.getText().trim()),
                    localPicturePath
            );
            movieController.createMovie(movie, new ArrayList<>(), new ArrayList<>());
            moviesTableModel.setMovies(movieController.getAllMovies());
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to create movie!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose a movie to update");
            return;
        }
        if (!formValid()) {
            return;
        }
        try {
            if (!tfPicturePath.getText().trim().equals(selectedMovie.getImagePath())) {
                if (selectedMovie.getImagePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getImagePath()));
                }
                String localPicturePath = uploadPicture();
                selectedMovie.setImagePath(localPicturePath);
            }

            selectedMovie.setTitle(tfTitle.getText().trim());
            selectedMovie.setGenre(tfGenre.getText().trim());
            selectedMovie.setReleaseYear(Integer.parseInt(tfReleaseYear.getText().trim()));

            movieController.updateMovie(selectedMovie);
            moviesTableModel.setMovies(movieController.getAllMovies());
            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to update movie!");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedMovie == null) {
            MessageUtils.showInformationMessage("Wrong operation", "Please choose a movie to delete");
            return;
        }
        if (MessageUtils.showConfirmDialog(
                "Delete movie",
                "Do you really want to delete movie?")) {
            try {
                if (selectedMovie.getImagePath() != null) {
                    Files.deleteIfExists(Paths.get(selectedMovie.getImagePath()));
                }
                movieController.deleteMovie(selectedMovie.getMovieID());
                moviesTableModel.setMovies(movieController.getAllMovies());
                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Error", "Unable to delete movie!");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ReleaseYearError;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGenreError;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbPicturePathError;
    private javax.swing.JLabel lbTitleError;
    private javax.swing.JTable tbMovies;
    private javax.swing.JTextField tfGenre;
    private javax.swing.JTextField tfPicturePath;
    private javax.swing.JTextField tfReleaseYear;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfTitle, tfGenre, tfReleaseYear, tfPicturePath);
        errorLabels = Arrays.asList(lbTitleError, lbGenreError, ReleaseYearError, lbPicturePathError);
    }

    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }

    private void initRepository() throws Exception {
        this.movieController = new MovieController();
    }

    private void initTable() {
        tbMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovies.setAutoCreateRowSorter(true);
        tbMovies.setRowHeight(25);
        moviesTableModel = new MovieTableModel(movieController.getAllMovies());
        tbMovies.setModel(moviesTableModel);

        moviesTableModel.setColumnWidths(tbMovies);
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
        tfTitle.setText("");
        tfGenre.setText("");
        tfReleaseYear.setText("");
        tfPicturePath.setText("");
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/no_image.png")));
    }

    private boolean formValid() {
        hideErrors();
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
            if ("ReleaseYear".equals(validationFields.get(i).getName())) {
                try {
                    Integer.parseInt(validationFields.get(i).getText().trim());
                } catch (Exception e) {
                    ok = false;
                    errorLabels.get(i).setVisible(true);
                }
            }
        }
        return ok;
    }

    private void showMovie() {
        clearForm();
        int selectedRow = tbMovies.getSelectedRow();
        int rowIndex = tbMovies.convertRowIndexToModel(selectedRow);
        int selectedMovieId = (int) moviesTableModel.getValueAt(rowIndex, 0);

        try {
            Movie movie = movieController.getMovieById(selectedMovieId);
            selectedMovie = movie; // it would be better to use Optional...
            fillForm(movie);
        } catch (Exception ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Error", "Unable to show movie!");
        }
    }

    private void fillForm(Movie movie) {
        if (movie.getImagePath() != null && Files.exists(Paths.get(movie.getImagePath()))) {
            tfPicturePath.setText(movie.getImagePath());
            setIcon(lbIcon, new File(movie.getImagePath()));
        }
        tfTitle.setText(movie.getTitle());
        tfGenre.setText(movie.getGenre());
        tfReleaseYear.setText(String.valueOf(movie.getReleaseYear()));
    }

    private void setIcon(JLabel label, File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            ImageIcon icon = new ImageIcon(image);
            label.setIcon(IconUtils.scaleImageToHeight(icon, MAX_ICON_HEIGHT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
