/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rohit
 */
public class SearchRecord extends javax.swing.JFrame {

    /**
     * Creates new form SearchRecord
     */
    DefaultTableModel model;

    public SearchRecord() {
        initComponents();
        setRecordToTable();
    }

    public void setRecordToTable() {
        try {
            Connection con = DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from fees_details");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String receiptNo = rs.getString("reciept_no");
                String rollNo = rs.getString("roll_no");
                String studentName = rs.getString("student_name");
                String paymentMode = rs.getString("payment_mode");
                String courseName = rs.getString("courses");
                float amount = rs.getFloat("total_amount");
                String remark = rs.getString("remark");

                Object[] obj = {receiptNo, rollNo, studentName, courseName, paymentMode, amount, remark};

                model = (DefaultTableModel) tbl_studentdata.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(String str) {
        model = (DefaultTableModel) tbl_studentdata.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tbl_studentdata.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelsidebar = new javax.swing.JPanel();
        Panelview = new javax.swing.JPanel();
        btnview = new javax.swing.JLabel();
        Panelback = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();
        Panesearch = new javax.swing.JPanel();
        btnsearch = new javax.swing.JLabel();
        Paneledit = new javax.swing.JPanel();
        btnedit = new javax.swing.JLabel();
        Panellogout = new javax.swing.JPanel();
        btnlogout = new javax.swing.JLabel();
        Panelhome = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
        Panelcourse = new javax.swing.JPanel();
        btncourse = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentdata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panelsidebar.setBackground(new java.awt.Color(0, 102, 102));
        Panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panelview.setBackground(new java.awt.Color(0, 102, 102));
        Panelview.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panelview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelviewMouseEntered(evt);
            }
        });
        Panelview.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnview.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnview.setForeground(new java.awt.Color(255, 255, 255));
        btnview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/view all record.png"))); // NOI18N
        btnview.setText("View All Record");
        btnview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnviewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnviewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnviewMouseExited(evt);
            }
        });
        Panelview.add(btnview, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 240, -1));

        Panelsidebar.add(Panelview, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 290, 80));

        Panelback.setBackground(new java.awt.Color(0, 102, 102));
        Panelback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panelback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelbackMouseEntered(evt);
            }
        });
        Panelback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/left-arrow.png"))); // NOI18N
        btnback.setText(" Back ");
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });
        Panelback.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 180, -1));

        Panelsidebar.add(Panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 290, 80));

        Panesearch.setBackground(new java.awt.Color(0, 102, 102));
        Panesearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panesearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanesearchMouseEntered(evt);
            }
        });
        Panesearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsearch.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(255, 255, 255));
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/search2.png"))); // NOI18N
        btnsearch.setText("Search Record");
        btnsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchMouseExited(evt);
            }
        });
        Panesearch.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 230, -1));

        Panelsidebar.add(Panesearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 290, 80));

        Paneledit.setBackground(new java.awt.Color(0, 102, 102));
        Paneledit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Paneledit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaneleditMouseEntered(evt);
            }
        });
        Paneledit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnedit.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnedit.setForeground(new java.awt.Color(255, 255, 255));
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/edit2.png"))); // NOI18N
        btnedit.setText("Edit Course");
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btneditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btneditMouseExited(evt);
            }
        });
        Paneledit.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 60));

        Panelsidebar.add(Paneledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 290, 80));

        Panellogout.setBackground(new java.awt.Color(0, 102, 102));
        Panellogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panellogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanellogoutMouseEntered(evt);
            }
        });
        Panellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogout.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/logout.png"))); // NOI18N
        btnlogout.setText(" Log Out");
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogoutMouseExited(evt);
            }
        });
        Panellogout.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 170, -1));

        Panelsidebar.add(Panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 290, 80));

        Panelhome.setBackground(new java.awt.Color(0, 102, 102));
        Panelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panelhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelhomeMouseEntered(evt);
            }
        });
        Panelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/home.png"))); // NOI18N
        btnhome.setText("  HOME");
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhomeMouseExited(evt);
            }
        });
        Panelhome.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 60));

        Panelsidebar.add(Panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 290, 80));

        Panelcourse.setBackground(new java.awt.Color(0, 102, 102));
        Panelcourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        Panelcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelcourseMouseEntered(evt);
            }
        });
        Panelcourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncourse.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btncourse.setForeground(new java.awt.Color(255, 255, 255));
        btncourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/list.png"))); // NOI18N
        btncourse.setText("Course List");
        btncourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncourseMouseExited(evt);
            }
        });
        Panelcourse.add(btncourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, -1));

        Panelsidebar.add(Panelcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 290, 80));

        getContentPane().add(Panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 1030));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentdata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Receipt No", "Roll No", "Student Name", "Courses", "Payment Mode", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_studentdata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 840, 870));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search Record");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 180, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Enter Search String :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, 30));

        txt_search.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_searchMouseReleased(evt);
            }
        });
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 200, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 1540, 1030));

        setSize(new java.awt.Dimension(2037, 1073));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnviewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewMouseEntered
        Color clr = new Color(0, 153, 153);
        Panelview.setBackground(clr);
    }//GEN-LAST:event_btnviewMouseEntered

    private void btnviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewMouseExited
        Color clr = new Color(0, 102, 102);
        Panelview.setBackground(clr);
    }//GEN-LAST:event_btnviewMouseExited

    private void PanelviewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelviewMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelviewMouseEntered

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        Color clr = new Color(0, 153, 153);
        Panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        Color clr = new Color(0, 102, 102);
        Panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseExited

    private void PanelbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelbackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelbackMouseEntered

    private void btnsearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseEntered
        Color clr = new Color(0, 153, 153);
        Panesearch.setBackground(clr);
    }//GEN-LAST:event_btnsearchMouseEntered

    private void btnsearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseExited
        Color clr = new Color(0, 102, 102);
        Panesearch.setBackground(clr);
    }//GEN-LAST:event_btnsearchMouseExited

    private void PanesearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanesearchMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PanesearchMouseEntered

    private void btneditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseEntered
        Color clr = new Color(0, 153, 153);
        Paneledit.setBackground(clr);
    }//GEN-LAST:event_btneditMouseEntered

    private void btneditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseExited
        Color clr = new Color(0, 102, 102);
        Paneledit.setBackground(clr);
    }//GEN-LAST:event_btneditMouseExited

    private void PaneleditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaneleditMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PaneleditMouseEntered

    private void btnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseEntered
        Color clr = new Color(0, 153, 153);
        Panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseEntered

    private void btnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseExited
        Color clr = new Color(0, 102, 102);
        Panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseExited

    private void PanellogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanellogoutMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PanellogoutMouseEntered

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        Color clr = new Color(0, 153, 153);
        Panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        Color clr = new Color(0, 103, 103);
        Panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseExited

    private void PanelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelhomeMouseEntered

    }//GEN-LAST:event_PanelhomeMouseEntered

    private void btncourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncourseMouseEntered
        Color clr = new Color(0, 153, 153);
        Panelcourse.setBackground(clr);
    }//GEN-LAST:event_btncourseMouseEntered

    private void btncourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncourseMouseExited
        Color clr = new Color(0, 102, 102);
        Panelcourse.setBackground(clr);
    }//GEN-LAST:event_btncourseMouseExited

    private void PanelcourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelcourseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelcourseMouseEntered

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void txt_searchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_searchMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchMouseReleased

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        String searchString = txt_search.getText();
        search(searchString);
    }//GEN-LAST:event_txt_searchKeyReleased

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        home house = new home();
        house.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseClicked
        // TODO add your handling code here:
        SearchRecord search = new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsearchMouseClicked

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        EditCourse editCourse=new EditCourse();
        editCourse.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btneditMouseClicked

    private void btnviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewMouseClicked
        ViewAllRecord record=new ViewAllRecord();
        record.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnviewMouseClicked

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        home h= new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        Login lo=new Login();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnlogoutMouseClicked

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
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelback;
    private javax.swing.JPanel Panelcourse;
    private javax.swing.JPanel Paneledit;
    private javax.swing.JPanel Panelhome;
    private javax.swing.JPanel Panellogout;
    private javax.swing.JPanel Panelsidebar;
    private javax.swing.JPanel Panelview;
    private javax.swing.JPanel Panesearch;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btncourse;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnsearch;
    private javax.swing.JLabel btnview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_studentdata;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}