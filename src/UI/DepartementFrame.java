/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.DepartmentDAO;
import DAOImp.DepartmentDAOImp;
import DAOImp.StudentDAOImp;

import dbConnection.DBConnection;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Department;

/**
 *
 * @author SAQIB
 */
public class DepartementFrame extends javax.swing.JFrame {
    Integer deptId;
     DepartmentDAO departmentDAO = new DepartmentDAOImp();
Object columns[]={"ID","Name","Code"};
    DefaultTableModel defaultTableModel;
   
   
  
    /**
     * Creates new form DepartementFrame
     */
    public DepartementFrame() {
        initComponents();
        defaultTableModel=(DefaultTableModel) bTable.getModel();
        fillTable();
    }
private boolean validateFields() {
        if (bName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(DepartementFrame.this, "Enter any Name");
            bName.grabFocus();
            return false;
        }
        if (bCode.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(DepartementFrame.this, "Enter any Code");
            bCode.grabFocus();
            return false;
        }
        
   
        return true;
    }


    private void fillTable(){
                defaultTableModel = new DefaultTableModel(columns, 0);
                        List<Department> prod = departmentDAO.getAllDepartment();
               for(Department s: prod){
                Object[] row={s.getDep_ID(),s.getDep_name(),s.getDep_code()};
                defaultTableModel.addRow(row);
                bTable.setModel(defaultTableModel);
                        }
    }
      
private void resetFields() {
       bName.setText("");
       bCode.setText("");
 
   }









    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bCode = new javax.swing.JTextField();
        bInsert = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Department");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\SAQIB\\Downloads\\arrow.png")); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jLabel3)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 677, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 112, -1, -1));

        bName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNameActionPerformed(evt);
            }
        });
        getContentPane().add(bName, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 107, 189, 32));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Code");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 112, 41, -1));

        bCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCodeActionPerformed(evt);
            }
        });
        getContentPane().add(bCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 106, 179, 35));

        bInsert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bInsert.setText("Insert");
        bInsert.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 153)));
        bInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertActionPerformed(evt);
            }
        });
        getContentPane().add(bInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 190, 39));

        bUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bUpdate.setText("Update");
        bUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 153)));
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(bUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 190, 38));

        bDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bDelete.setText("Delete");
        bDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 153)));
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(bDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 190, 42));

        bClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bClear.setText("Clear");
        bClear.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 153)));
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });
        getContentPane().add(bClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 190, 40));

        bTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 153)));
        bTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code"
            }
        ));
        bTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 350, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCodeActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_bCodeActionPerformed
  
    
    
    private void bInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertActionPerformed

        
                Connection con = DBConnection.getConnection();// TODO add your handling code here:

        
        Department dep = new Department();
        dep.setDep_name(bName.getText());
        dep.setDep_code(bCode.getText());

        //    ps.setString(6, bDepartment.getSelectedItem().toString());
        
       
        boolean success = departmentDAO.addDepartment(dep);
        if(success){
            JOptionPane.showMessageDialog(this,"added successfully");
             fillTable();
             resetFields();
            
        }
        
        
    }//GEN-LAST:event_bInsertActionPerformed

    private void bNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bNameActionPerformed

        private Department getDepartment(){
        String name = bName.getText();
        String code= bCode.getText();
        Department d = new Department();
        d.setDep_name(name);
        d.setDep_code(code);
        return d;
    }
    
    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        Department department = this.getDepartment();
        department.setDep_ID(deptId);
        boolean success = departmentDAO.updateDepartment(department);
        if (success) {
            JOptionPane.showMessageDialog(this, "Updated Successfully");
            fillTable();
            resetFields();
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTableMouseClicked
         deptId = Integer.parseInt(bTable.getValueAt(bTable.getSelectedRow(), 0).toString());
        Department department = departmentDAO.getDepartmentById(deptId);
        bName.setText(department.getDep_name());
        bCode.setText(department.getDep_code());
    }//GEN-LAST:event_bTableMouseClicked

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
           Department department = this.getDepartment();
        department.setDep_ID(deptId);
        boolean success = departmentDAO.deleteDepartment(deptId);
        if (success) {
            JOptionPane.showMessageDialog(this, "Deleted Successfully");
            fillTable();

            resetFields();
    }//GEN-LAST:event_bDeleteActionPerformed
    }
    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        resetFields();
    }//GEN-LAST:event_bClearActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Selection  selection =new  Selection();
        DepartementFrame.this.setVisible(false);
        selection.setVisible(true);
          DepartementFrame.this.dispose();
        
    
    }//GEN-LAST:event_jLabel4MouseClicked
    
    
      
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
            java.util.logging.Logger.getLogger(DepartementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartementFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClear;
    private javax.swing.JTextField bCode;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bInsert;
    private javax.swing.JTextField bName;
    private javax.swing.JTable bTable;
    private javax.swing.JButton bUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
