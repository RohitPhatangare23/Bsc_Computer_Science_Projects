/*
 * 
 */
package fees_management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author rohit
 */
public class EditCourse extends javax.swing.JFrame {

    
    DefaultTableModel model;
    public EditCourse() {
        initComponents();
        setRecordToTable();
    }
    public void setRecordToTable() {
        try {
            Connection con = DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from course");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                
                String courseId = rs.getString("id");
                String courseName = rs.getString("cname");
                String courseCost = rs.getString("ccost");
               
                Object[] obj = {courseId, courseName, courseCost};

                model = (DefaultTableModel) tbl_coursedata.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clearTable()
    {
        DefaultTableModel model=(DefaultTableModel) tbl_coursedata.getModel();
        model.setRowCount(0);
    }
    
    
    
    public  void addCourse(int id,String cname,double ccost)
    {
        try {
            Connection con = DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into course values(?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, cname);
            pst.setDouble(3, ccost);
            
            
            int rowCount=pst.executeUpdate();
            if (rowCount==1) {
                JOptionPane.showMessageDialog(this, "Course Added Successfully");  
                clearTable();
                setRecordToTable();
            }
            else{
                JOptionPane.showMessageDialog(this, "Course Insertion Failed");  
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Course Insertion Failed");  
            e.printStackTrace();
        }
    }
    public void update(int id,String cname,double ccost)
    {
        try {
            Connection con = DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("update course set cname=?,ccost=? where id=?");
            
            pst.setString(1, cname);
            pst.setDouble(2, ccost);
            pst.setInt(3, id);
            
            int rowCount=pst.executeUpdate();
            if (rowCount==1) {
                JOptionPane.showMessageDialog(this, "Course Updated Successfully");  
                clearTable();
                setRecordToTable();
            }
            else{
                JOptionPane.showMessageDialog(this, "Course updation Failed");  
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Course updation Failed");  
            e.printStackTrace();
        }
    
    }
    public void delete(int id)
    {
        try {
            Connection con = DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("delete from course where id=? ");
            
            
            pst.setInt(1, id);
            
            int rowCount=pst.executeUpdate();
            if (rowCount==1) {
                JOptionPane.showMessageDialog(this, "Course Deleted Successfully");  
                clearTable();
                setRecordToTable();
            }
            else{
                JOptionPane.showMessageDialog(this, "Course Deletion Failed");  
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Course Deletion Failed");  
            e.printStackTrace();
        }
    
    }
    

    
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
        tbl_coursedata = new javax.swing.JTable();
        txt_courseid = new javax.swing.JTextField();
        txt_coursCost = new javax.swing.JTextField();
        txt_coursname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_addd = new javax.swing.JButton();
        btn_updatee = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

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

        getContentPane().add(Panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 1030));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_coursedata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Cost"
            }
        ));
        tbl_coursedata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_coursedataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_coursedata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, 500));

        txt_courseid.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_courseid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 220, 30));

        txt_coursCost.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_coursCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursCostActionPerformed(evt);
            }
        });
        jPanel1.add(txt_coursCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 220, 30));

        txt_coursname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_coursname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_coursname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 220, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Cost :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 80, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course Id :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 60, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Name :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, 30));

        btn_delete.setBackground(new java.awt.Color(0, 102, 102));
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));

        btn_addd.setBackground(new java.awt.Color(0, 102, 102));
        btn_addd.setForeground(new java.awt.Color(255, 255, 255));
        btn_addd.setText("ADD");
        btn_addd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adddActionPerformed(evt);
            }
        });
        jPanel1.add(btn_addd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        btn_updatee.setBackground(new java.awt.Color(0, 102, 102));
        btn_updatee.setForeground(new java.awt.Color(255, 255, 255));
        btn_updatee.setText("Update");
        btn_updatee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_updatee, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edit Course Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 230, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 350, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management/image/back1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 70, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 1520, 1040));

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

    private void btnsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseClicked
        SearchRecord search=new SearchRecord();
        search.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsearchMouseClicked

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

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        home house=new home();
        house.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

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

    private void txt_courseidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseidActionPerformed

    private void txt_coursCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursCostActionPerformed

    private void txt_coursnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursnameActionPerformed

    private void btn_updateeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateeActionPerformed
        int id = Integer.parseInt(txt_courseid.getText());
        String cname= txt_coursname.getText();
        double ccost = Double.parseDouble(txt_coursCost.getText());
        update(id, cname, ccost);
    }//GEN-LAST:event_btn_updateeActionPerformed

    private void tbl_coursedataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_coursedataMouseClicked
        int rowNo=tbl_coursedata.getSelectedRow();
        TableModel model=tbl_coursedata.getModel();
        
        txt_courseid.setText(model.getValueAt(rowNo,0).toString());
        txt_coursname.setText((String)model.getValueAt(rowNo,1));
        txt_coursCost.setText(model.getValueAt(rowNo,2).toString());
    }//GEN-LAST:event_tbl_coursedataMouseClicked

    private void btn_adddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adddActionPerformed
        int id = Integer.parseInt(txt_courseid.getText());
        String cname= txt_coursname.getText();
        double ccost = Double.parseDouble(txt_coursCost.getText());
        addCourse(id, cname, ccost);
        
    }//GEN-LAST:event_btn_adddActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       int id = Integer.parseInt(txt_courseid.getText());
        delete(id);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        home house=new home();
        house.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditCourse().setVisible(true);
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
    private javax.swing.JButton btn_addd;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_updatee;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btncourse;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnsearch;
    private javax.swing.JLabel btnview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_coursedata;
    private javax.swing.JTextField txt_coursCost;
    private javax.swing.JTextField txt_courseid;
    private javax.swing.JTextField txt_coursname;
    // End of variables declaration//GEN-END:variables
}
