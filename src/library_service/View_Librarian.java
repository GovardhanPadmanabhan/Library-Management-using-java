/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_service;

/**
 *
 * @author Govardhan
 */
import java.awt.BorderLayout;
import java.io.BufferedReader;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JDialog;
public class View_Librarian extends javax.swing.JFrame {

    /**
     * Creates new form View_Librarian
     */
    public View_Librarian() {
        super("View Librarian");
        setSize(700, 415);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            Scanner reader = new Scanner(new File("D:/librarians.txt"));
            String[] libs = new String[100];
            int i=0;
            while(reader.hasNext()){
                libs[i++] = reader.nextLine();
            }
            String[][] args = new String[i][7];
            int k=0;
            double sum;
            reader.close();
            for(int j=0;j<i;j++){
                args[j] = libs[j].split(";");
                Scanner reader1 = new Scanner(new File("D:/Librarians/" + args[j][0] + ".txt"));
                sum=0;
                while(reader1.hasNext()){
                    String line = reader1.nextLine();
                    String[] words = line.split(";");
                    if(!words[2].equals("-"))
                        sum+= Double.parseDouble(words[2]);
                }
                args[j][6] = Double.toString(sum);
                reader1.close();
            }
            JTable jt = new JTable(args, new String[] { "ID Nos.", "NAME", "MAIL ID", "CONTACT Nos.", "PASSWORD", "PIN", "WORK HOURS" });
            JScrollPane jsp = new JScrollPane(jt);
            getContentPane().add(jsp, BorderLayout.CENTER);
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        pack();
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
            java.util.logging.Logger.getLogger(View_Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Librarian().setVisible(true);
            }
        });
        
//        String data[][]={ {"101","Amit","670000"},    
//                          {"102","Jai","780000"},    
//                          {"101","Sachin","700000"}};    
//    String column[]={"ID Nos.","NAME","MAIL ID","CONTACT Nos."};         
//    JTable jt=new JTable(data,column);    
//    jt.setBounds(30,40,200,300);          
//    JScrollPane sp=new JScrollPane(jt); 
//    JFrame f = new JFrame();
//    f.add(sp);          
//    f.setSize(300,400);    
//    f.setVisible(true);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}