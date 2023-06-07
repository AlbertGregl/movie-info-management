/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hr.gregl;

import hr.gregl.model.User;
import hr.gregl.view.ActorPanel;
import hr.gregl.view.AdminPanel;
import hr.gregl.view.DirectorPanel;
import hr.gregl.view.LoginPanel;
import hr.gregl.view.MoviePanel;

/**
 *
 * @author albert
 */
public class MovieApp extends javax.swing.JFrame {

    // user
    private User user;

    /**
     * Creates new form MovieApp
     */
    public MovieApp() {
        initComponents();

        // set user with login form
        setupUser();


        configureUserPanels();
        configureAdminPanels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpContent = new javax.swing.JTabbedPane();
        menuMain = new javax.swing.JMenuBar();
        menuUser = new javax.swing.JMenu();
        menuItemLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(808, 600));
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        tpContent.setMaximumSize(new java.awt.Dimension(1920, 1080));
        tpContent.setMinimumSize(new java.awt.Dimension(800, 600));
        tpContent.setName(""); // NOI18N
        getContentPane().add(tpContent, "card2");

        menuUser.setText("Username");

        menuItemLogout.setText("Logout");
        menuUser.add(menuItemLogout);
        menuUser.add(jSeparator1);

        menuItemExit.setText("Exit");
        menuUser.add(menuItemExit);

        menuMain.add(menuUser);

        setJMenuBar(menuMain);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovieApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JMenu menuUser;
    private javax.swing.JTabbedPane tpContent;
    // End of variables declaration//GEN-END:variables

    private void setupUser() {
        tpContent.addTab("Login", new LoginPanel());

        // set user based on login
        user = new User();


    }

    private void configureUserPanels() {

        tpContent.addTab("Movie", new MoviePanel());
        tpContent.addTab("Actor", new ActorPanel());
        tpContent.addTab("Director", new DirectorPanel());

    }

    private void configureAdminPanels() {
        configureUserPanels();
        tpContent.addTab("Administrator", new AdminPanel());

    }



}
