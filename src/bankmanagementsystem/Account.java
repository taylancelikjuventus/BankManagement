/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SeeMonster
 */
public class Account extends javax.swing.JInternalFrame {

    /**
     * Creates new form Customer
     */
    public Account() {
        
         initComponents();
        try {
            //Create auto generated id for customer's registration
            autoID();
            //Fill the Combobox with available branch values in our database.
            //branch();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**************variables*******************/
    Connection conn;
    PreparedStatement insert;
    /******Generate auto ID for each Customer***********/
    public void autoID() throws ClassNotFoundException, SQLException{
        //load Driver
        Class.forName("com.mysql.jdbc.Driver");
        //get Connection
        conn = DriverManager.
     getConnection("jdbc:mysql://localhost/bankmanagement1","root","");
        
        Statement s = conn.createStatement();
        //select maximum cust_id number from table
        ResultSet rs = s.executeQuery("SELECT Max(acc_id) from Account");
        rs.next();
        String maxid = rs.getString("Max(acc_id)");
        if(rs.getString("Max(acc_id)") == null){
            acc_no.setText("AC001");     //customer id has 'CS' prefix this has 'AS' prefix
        }else{
            
            long id = Long.parseLong(rs.getString("Max(acc_id)")
             .substring(2, rs.getString("Max(acc_id)").length())
            );
            //increase id
            id++;
            
            acc_no.setText("AC" + String.format("%03d",id));
        }
    
    
    }
    
    /**************If user clicks Combobox for selecting branch**********/
    /*
    public void branch() throws ClassNotFoundException, SQLException{
        
           //load Driver
        Class.forName("com.mysql.jdbc.Driver");
        //get Connection
        conn = DriverManager.
        getConnection("jdbc:mysql://localhost/bankmanagement1","root","");
        //sql statement
        insert = conn.prepareStatement("select * from branch");
        //execute sql
        ResultSet rs = insert.executeQuery();
        //clear cb box
       // txtbranch.removeAllItems();
        while(rs.next()){
            //branch tablosunun 2. kolonundaki dataları ekler combobox a.
       //     txtbranch.addItem(rs.getString(2));
            
        }
        
    }
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcust_id = new javax.swing.JTextField();
        txtcustname = new javax.swing.JTextField();
        txtbalance = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        acc_no = new javax.swing.JLabel();
        txtacctype = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account"));

        jLabel2.setText("Account No :");

        jLabel3.setText("Customer ID :");

        jLabel4.setText("Customer Name :");

        jLabel5.setText("Account Type :");

        jLabel6.setText("Balance :");

        txtcustname.setEnabled(false);

        txtbalance.setEnabled(false);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        acc_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acc_no.setForeground(new java.awt.Color(153, 0, 153));

        txtacctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Saving", "Fix", "Current" }));
        txtacctype.setSelectedIndex(-1);

        jButton3.setText("Find");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcust_id)
                    .addComponent(txtcustname)
                    .addComponent(txtbalance)
                    .addComponent(acc_no, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(txtacctype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(acc_no))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcustname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtacctype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addGap(78, 78, 78))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("New Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /***************if user clicks CANCEL Button*******************/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        //delete Account.java object
        setVisible(false);
        dispose();       //deletes this Customer.java object from memory.
    }//GEN-LAST:event_jButton2ActionPerformed

    /*************If User Clicks ADD Button*******************/
    /*********Insert Data from Customer.java form to Database's Customer table*******************/
    /*********************We will add a row and fill the Account table in Database****/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        //get fields from Account.java GuiForm
        String acc_id = acc_no.getText();
        String cust_id = txtcust_id.getText();
        String custname = txtcustname.getText();
        String acctype = txtacctype.getSelectedItem().toString();
        String balance = txtbalance.getText();
        
        //insert fields into database
        try {
            //load Driver
            Class.forName("com.mysql.jdbc.Driver");
            //get Connection
            conn = DriverManager.
            getConnection("jdbc:mysql://localhost/bankmanagement1","root","");

            insert = conn.prepareStatement("insert into "+
                "account(acc_id,cust_id,acc_type,balance,opened_datetime) "+
                "values(?,?,?,?,?)");

            insert.setString(1,acc_id);
            insert.setString(2,cust_id);
            insert.setString(3,acctype);
            insert.setString(4,balance);
            insert.setString(5,LocalDateTime.now().toString());

            //execute sql
            insert.executeUpdate();

            //inform user with dialog window
            JOptionPane.showMessageDialog(this, "Account created ...");

            //Clering FORM for new Registration
            //clear fields from FORM to make it available for other customer registrations
            acc_no.setText("");
            txtcust_id.setText("");
            txtcustname.setText("");
            txtbalance.setText("");
            txtacctype.setSelectedIndex(-1); //selects nothing from combobox
            
            autoID(); //get available id from
            txtcust_id.requestFocus(); //set focus on firstname field

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /*************If user clickes FIND button after giving customer's id number****/
    /*************His name ,balance etc... will be appear on this form ****/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String custid = txtcust_id.getText();
        
        try {
            //load Driver
            Class.forName("com.mysql.jdbc.Driver");
              //get Connection
            conn = DriverManager.
            getConnection("jdbc:mysql://localhost/bankmanagement1","root","");
            //sql to find customer from customer table based on his custid
            insert = conn.prepareStatement("select * from customer where cust_id=?");
            insert.setString(1, custid);
            //execute Query
            ResultSet rs = insert.executeQuery();
            //check results
            if(rs.next() == false){
                JOptionPane.showMessageDialog(this, "No customer found...");
            }
            //this sql returns all columns from customer table
            else{
                //get firstname and lastname from result set
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                //put name into Account.java Form
                txtcustname.setText(firstname +" "+ lastname );
                               
            }
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_no;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> txtacctype;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextField txtcust_id;
    private javax.swing.JTextField txtcustname;
    // End of variables declaration//GEN-END:variables
}