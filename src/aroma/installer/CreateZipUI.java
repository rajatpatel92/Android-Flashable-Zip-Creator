/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aroma.installer;

/**
 *
 * @author Rajat
 */
public class CreateZipUI extends javax.swing.JFrame {

    /**
     * Creates new form CreateZipUI
     */
    public CreateZipUI() {
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

        CZ_Panel = new javax.swing.JPanel();
        CZ_headingPanel = new javax.swing.JPanel();
        lblCZHeading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaCZ = new javax.swing.JTextArea();
        progressCZ = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                windowCreated(evt);
            }
        });

        CZ_Panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                CZ_PanelComponentShown(evt);
            }
        });

        CZ_headingPanel.setBackground(new java.awt.Color(0, 0, 0));

        lblCZHeading.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblCZHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblCZHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCZHeading.setText("Creating Flashable ZIP");

        javax.swing.GroupLayout CZ_headingPanelLayout = new javax.swing.GroupLayout(CZ_headingPanel);
        CZ_headingPanel.setLayout(CZ_headingPanelLayout);
        CZ_headingPanelLayout.setHorizontalGroup(
            CZ_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCZHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        CZ_headingPanelLayout.setVerticalGroup(
            CZ_headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCZHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        textAreaCZ.setColumns(20);
        textAreaCZ.setRows(5);
        jScrollPane1.setViewportView(textAreaCZ);

        javax.swing.GroupLayout CZ_PanelLayout = new javax.swing.GroupLayout(CZ_Panel);
        CZ_Panel.setLayout(CZ_PanelLayout);
        CZ_PanelLayout.setHorizontalGroup(
            CZ_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CZ_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CZ_headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(progressCZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CZ_PanelLayout.setVerticalGroup(
            CZ_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CZ_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CZ_headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressCZ, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(CZ_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(CZ_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowCreated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowCreated
        // TODO add your handling code here:
    }//GEN-LAST:event_windowCreated

    private void CZ_PanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_CZ_PanelComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_CZ_PanelComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateZipUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreateZipUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CZ_Panel;
    private javax.swing.JPanel CZ_headingPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCZHeading;
    private javax.swing.JProgressBar progressCZ;
    private javax.swing.JTextArea textAreaCZ;
    // End of variables declaration//GEN-END:variables
}
