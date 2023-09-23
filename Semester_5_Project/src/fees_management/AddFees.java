package fees_management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class AddFees extends javax.swing.JFrame {

    public AddFees() {
        initComponents();
        displayChashFirst();
        fillComboBox();

        int receiptno = getReciptNo();
        txt_recepitno.setText(Integer.toString(receiptno));
    }

    public void displayChashFirst() {
        lbl_ddno.setVisible(false);
        lbl_checkno.setVisible(false);
        lbl_bankname.setVisible(false);

        txtddno.setVisible(false);
        txt_bankname.setVisible(false);
        txtcheckno.setVisible(false);

    }

    public boolean validation() {
        if (txt_recivedfromuser.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;

        }
        if (datechooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please Select Date");
            return false;
        }
        if (txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Please Enter Amount In Number");
            return false;
        }
        if (combopaymentmode.getSelectedItem().toString().equalsIgnoreCase("Cheque")) {
            if (txtcheckno.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Cheque Number");
                return false;
            }
            if (txt_bankname.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;

            }
        }
        if (combopaymentmode.getSelectedItem().toString().equalsIgnoreCase("DD")) {
            if (txtddno.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter DD Number");
                return false;
            }
            if (txt_bankname.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;

            }
        }
        if (combopaymentmode.getSelectedItem().toString().equalsIgnoreCase("Card")) {
            if (txt_bankname.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Bank Name");
                return false;

            }
        }

        return true;
    }

    public void fillComboBox() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/feesmanagementsystem", "root", "rohit23");
            String sql = "select cname from course";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                chombocourse.addItem(rs.getString("cname"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public int getReciptNo() {
        int receiptNo = 0;
        try {
            Connection con = (Connection) DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("select max(reciept_no) from fees_details");
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                receiptNo = rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return receiptNo + 1;
    }

    public String insertData() {

        String status = "";

        int recieptNo = Integer.parseInt(txt_recepitno.getText());
        String studentName = txt_recivedfromuser.getText();
        String rollno = txt_rollno.getText();
        String paymentmode = combopaymentmode.getSelectedItem().toString();
        String chequeno = txtcheckno.getText();
        String bankname = txt_bankname.getText();
        String ddno = txtddno.getText();
        String coursename = txt_coursename.getText();
        String gstin = txt_gstno.getText();
        float totalamount = Float.parseFloat(txt_total.getText());
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateformat.format(datechooser.getDate());
        float initialamount = Float.parseFloat(txt_amount.getText());
        float cgst = Float.parseFloat(txt_cgst.getText());
        float sgst = Float.parseFloat(txt_sgst.getText());
        String totalinwords = txt_totalinword.getText();
        String remark = txt_remark.getText();
        int year1 = Integer.parseInt(txt_year1.getText());
        int year2 = Integer.parseInt(txt_year2.getText());

        try {
            Connection con = DBConncection.getConnection();
            PreparedStatement pst = con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst.setInt(1, recieptNo);
            pst.setString(2, studentName);
            pst.setString(3, rollno);
            pst.setString(4, paymentmode);
            pst.setString(5, chequeno);
            pst.setString(6, bankname);
            pst.setString(7, ddno);

            pst.setString(8, coursename);
            pst.setString(9, gstin);
            pst.setFloat(10, totalamount);
            pst.setString(11, date);
            pst.setFloat(12, initialamount);
            pst.setFloat(13, cgst);
            pst.setFloat(14, sgst);
            pst.setString(15, totalinwords);
            pst.setString(16, remark);
            pst.setInt(17, year1);
            pst.setInt(18, year2);

            int rowcount = pst.executeUpdate();
            if (rowcount == 1) {
                status = "success";

            } else {
                status = "failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
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
        Panelparent = new javax.swing.JPanel();
        lbl_bankname = new javax.swing.JLabel();
        txt_gstno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_ddno = new javax.swing.JLabel();
        lbl_checkno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_bankname = new javax.swing.JTextField();
        txt_recepitno = new javax.swing.JTextField();
        txtcheckno = new javax.swing.JTextField();
        txtddno = new javax.swing.JTextField();
        combopaymentmode = new javax.swing.JComboBox<>();
        datechooser = new com.toedter.calendar.JDateChooser();
        panelchild = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_rollno = new javax.swing.JTextField();
        txt_year1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        chombocourse = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_coursename = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_totalinword = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_sgst = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_recivedfromuser = new javax.swing.JTextField();
        txt_year2 = new javax.swing.JTextField();

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

        getContentPane().add(Panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 1030));

        Panelparent.setBackground(new java.awt.Color(0, 153, 153));
        Panelparent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bankname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_bankname.setText("Bank Name  :");
        Panelparent.add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        txt_gstno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_gstno.setText("22AAAA001Z5");
        Panelparent.add(txt_gstno, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 120, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Mode Of Payment  :");
        Panelparent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lbl_ddno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_ddno.setText("DD No :");
        Panelparent.add(lbl_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_checkno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_checkno.setText("Cheque No :");
        Panelparent.add(lbl_checkno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Receipt No :  SOC -");
        Panelparent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Date :");
        Panelparent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("GSTIN :");
        Panelparent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        txt_bankname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_bankname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_banknameActionPerformed(evt);
            }
        });
        Panelparent.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 190, -1));

        txt_recepitno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_recepitno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recepitnoActionPerformed(evt);
            }
        });
        Panelparent.add(txt_recepitno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 190, 30));

        txtcheckno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtcheckno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtchecknoActionPerformed(evt);
            }
        });
        Panelparent.add(txtcheckno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 190, -1));

        txtddno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtddno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtddnoActionPerformed(evt);
            }
        });
        Panelparent.add(txtddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 190, -1));

        combopaymentmode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combopaymentmode.setSelectedIndex(2);
        combopaymentmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopaymentmodeActionPerformed(evt);
            }
        });
        Panelparent.add(combopaymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 190, 20));
        Panelparent.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 180, -1));

        panelchild.setBackground(new java.awt.Color(0, 153, 153));
        panelchild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("The Following Payments The College Office For The Year :  ");
        panelchild.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Roll No :");
        panelchild.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 80, -1));

        txt_rollno.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollnoActionPerformed(evt);
            }
        });
        panelchild.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 70, -1));

        txt_year1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        panelchild.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 70, 30));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Amount :");
        panelchild.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 70, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Recived Form :");
        panelchild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        chombocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chombocourseActionPerformed(evt);
            }
        });
        panelchild.add(chombocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 420, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("To");
        panelchild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 30, -1));
        panelchild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 230, 20));
        panelchild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 830, 10));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Course : ");
        panelchild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, -1));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Reciver Signature");
        panelchild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 140, -1));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Head : ");
        panelchild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 70, -1));

        txt_coursename.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursenameActionPerformed(evt);
            }
        });
        panelchild.add(txt_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 440, 30));

        txt_amount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panelchild.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 200, 30));

        txt_cgst.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        panelchild.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 200, 30));

        txt_total.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panelchild.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 200, 30));

        txt_totalinword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_totalinword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalinwordActionPerformed(evt);
            }
        });
        panelchild.add(txt_totalinword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 430, 30));
        panelchild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 830, 10));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("SGST : 18%");
        panelchild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 100, -1));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Total In Word : ");
        panelchild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 130, -1));

        txt_sgst.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        panelchild.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 200, 30));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panelchild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 430, 80));
        panelchild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 830, 10));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Remak :");
        panelchild.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, -1));

        btn_print.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelchild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 460, 80, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Sr No : ");
        panelchild.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, -1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("CGST : 18% ");
        panelchild.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 100, -1));

        txt_recivedfromuser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_recivedfromuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_recivedfromuserActionPerformed(evt);
            }
        });
        panelchild.add(txt_recivedfromuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, 30));

        txt_year2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panelchild.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 60, 30));

        Panelparent.add(panelchild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1310, 840));

        getContentPane().add(Panelparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 1500, 1040));

        setSize(new java.awt.Dimension(2037, 1073));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PanelhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelhomeMouseEntered

    }//GEN-LAST:event_PanelhomeMouseEntered

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        Color clr = new Color(0, 153, 153);
        Panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        Color clr = new Color(0, 103, 103);
        Panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseExited

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

    private void txt_banknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_banknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_banknameActionPerformed

    private void txt_recepitnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recepitnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_recepitnoActionPerformed

    private void txtchecknoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtchecknoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtchecknoActionPerformed

    private void txtddnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtddnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtddnoActionPerformed

    private void txt_rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollnoActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void txt_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursenameActionPerformed

    }//GEN-LAST:event_txt_coursenameActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        Float amount = Float.parseFloat(txt_amount.getText());
        Float cgst = (float) (amount * 0.09);
        Float sgst = (float) (amount * 0.09);

        txt_cgst.setText(cgst.toString());
        txt_sgst.setText(sgst.toString());

        float total = amount + cgst + sgst;
        txt_total.setText(Float.toString(total));

        txt_totalinword.setText(NumberToWordsConverter.convert((int) total) + " only ");
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed

    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_totalinwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalinwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalinwordActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_recivedfromuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_recivedfromuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_recivedfromuserActionPerformed

    private void combopaymentmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopaymentmodeActionPerformed
        if (combopaymentmode.getSelectedIndex() == 0) {
            lbl_ddno.setVisible(true);
            txtddno.setVisible(true);
            lbl_checkno.setVisible(false);
            txtcheckno.setVisible(false);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);

        }
        if (combopaymentmode.getSelectedIndex() == 1) {
            lbl_ddno.setVisible(false);
            txtddno.setVisible(false);
            lbl_checkno.setVisible(true);
            txtcheckno.setVisible(true);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);

        }
        if (combopaymentmode.getSelectedIndex() == 2) {
            lbl_ddno.setVisible(false);
            txtddno.setVisible(false);
            lbl_checkno.setVisible(false);
            txtcheckno.setVisible(false);
            lbl_bankname.setVisible(false);
            txt_bankname.setVisible(false);

        }
        if (combopaymentmode.getSelectedItem().equals("Card")) {
            lbl_ddno.setVisible(false);
            txtddno.setVisible(false);
            lbl_checkno.setVisible(false);
            txtcheckno.setVisible(false);
            lbl_bankname.setVisible(true);
            txt_bankname.setVisible(true);

        }

    }//GEN-LAST:event_combopaymentmodeActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if (validation() == true) {
            String result = insertData();
            if (result.equals("success")) {
                JOptionPane.showMessageDialog(this,"Record Inserted Successfully");
                PrintReceipt p=new PrintReceipt();
                p.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this,"Record Insertion Failed");
            }

        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void chombocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chombocourseActionPerformed

        txt_coursename.setText(chombocourse.getSelectedItem().toString());

    }//GEN-LAST:event_chombocourseActionPerformed

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        home house=new home();
        house.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchMouseClicked
        SearchRecord search=new SearchRecord();
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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelback;
    private javax.swing.JPanel Panelcourse;
    private javax.swing.JPanel Paneledit;
    private javax.swing.JPanel Panelhome;
    private javax.swing.JPanel Panellogout;
    private javax.swing.JPanel Panelparent;
    private javax.swing.JPanel Panelsidebar;
    private javax.swing.JPanel Panelview;
    private javax.swing.JPanel Panesearch;
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btncourse;
    private javax.swing.JLabel btnedit;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnsearch;
    private javax.swing.JLabel btnview;
    private javax.swing.JComboBox<String> chombocourse;
    private javax.swing.JComboBox<String> combopaymentmode;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_checkno;
    private javax.swing.JLabel lbl_ddno;
    private javax.swing.JPanel panelchild;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_coursename;
    private javax.swing.JLabel txt_gstno;
    private javax.swing.JTextField txt_recepitno;
    private javax.swing.JTextField txt_recivedfromuser;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalinword;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    private javax.swing.JTextField txtcheckno;
    private javax.swing.JTextField txtddno;
    // End of variables declaration//GEN-END:variables
}
