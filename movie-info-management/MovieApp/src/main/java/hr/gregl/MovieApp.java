/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hr.gregl;

import hr.gregl.listeners.LoginListener;
import hr.gregl.model.Role;
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
public class MovieApp extends javax.swing.JFrame implements LoginListener {

    private User currentUser;

    /**
     * Creates new form MovieApp
     */
    public MovieApp() {
        initComponents();

        setUpForm();

        setupUser();
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
        setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 720));
        setSize(new java.awt.Dimension(1024, 720));
        getContentPane().setLayout(new java.awt.CardLayout());

        tpContent.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        tpContent.setMaximumSize(new java.awt.Dimension(1920, 1080));
        tpContent.setMinimumSize(new java.awt.Dimension(800, 600));
        tpContent.setName(""); // NOI18N
        getContentPane().add(tpContent, "card2");

        menuMain.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N

        menuUser.setText("Username");
        menuUser.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N

        menuItemLogout.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        menuItemLogout.setText("Logout");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        menuUser.add(menuItemLogout);
        menuUser.add(jSeparator1);

        menuItemExit.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        menuUser.add(menuItemExit);

        menuMain.add(menuUser);

        setJMenuBar(menuMain);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        // extit the app
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        // remove all tabs
        tpContent.removeAll();
        
        setUpForm();
        setupUser();
    }//GEN-LAST:event_menuItemLogoutActionPerformed

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
        LoginPanel loginPanel = new LoginPanel();
        // set the MovieApp as the login listener
        loginPanel.setLoginListener(this);
        tpContent.addTab("Login", loginPanel);
    }

    @Override
    public void onLoginSuccess(User user) {
        currentUser = user;
        // chnage tpContent name to username
        menuUser.setText("User: " + currentUser.getUsername());

        // Configure panels based on user type
        if (user.getRole() == Role.ADMINISTRATOR) {
            configureAdminPanels();
        } else {
            configureUserPanels();
        }
    }

    private void configureUserPanels() {
        // remove login panel
        tpContent.remove(0);
        // add movie, actor and director panels
        tpContent.addTab("Movie", new MoviePanel());
        tpContent.addTab("Actor", new ActorPanel());
        tpContent.addTab("Director", new DirectorPanel());
    }

    private void configureAdminPanels() {
        configureUserPanels();
        tpContent.addTab("Administrator", new AdminPanel());
    }

    private void setUpForm() {
        menuUser.setText("User");
    }

}
