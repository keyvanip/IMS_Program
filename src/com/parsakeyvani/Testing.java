package com.parsakeyvani;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

 class Testing
{
  public void buildGUI()
  {
    Store myStore = new Store();
    
    myStore.addProduct(new Products( "Pencil", 2.33, 23));
    myStore.addProduct(new Products( "Binder", 4.33, 43 ));
    myStore.addProduct(new Products( "Pen", 4.33, 43));
    myStore.addProduct(new Products( "Marker", 2.19, 105));
    myStore.addProduct(new Products( "Eraser", 1.30, 14 ));
    Stack<String> colNames = new Stack<String>();
    colNames.push("ID");
    colNames.push("Item Name");
    colNames.push("Cost");
    colNames.push("Item Count");
    Vector rowData = myStore.vectorize();
    
    DefaultTableModel dtm = new DefaultTableModel(rowData, colNames);
    final JTable table = new JTable(dtm);
    JScrollPane sp = new JScrollPane(table);
    sp.setPreferredSize(new Dimension(800,600));
 
    JButton addBtn = new JButton("Add Product");
    addBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Product Name"));
            JTextField nameField= new JTextField();
            panel.add(nameField);
            panel.add(new JLabel("Product Price"));
            JTextField priceField = new JTextField();
            panel.add(priceField);
            panel.add(new JLabel("Product Stock"));
            JTextField stockField = new JTextField();
            panel.add(stockField);
            int result = JOptionPane.showConfirmDialog(null, panel, "Inventory", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
                Products newProduct = new Products(nameField.getText(), Integer.parseInt(priceField.getText()), Integer.parseInt(stockField.getText()));
                myStore.addProduct(newProduct.getId(), newProduct);
                dtm.addRow(newProduct.toVector());
            }
        }
    });

    JButton deleteBtn = new JButton("Remove Product");
    deleteBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Product ID"));
            JTextField IDField = new JTextField();
            panel.add(IDField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Remove Product", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(result == JOptionPane.OK_OPTION){
                int val = Integer.parseInt(IDField.getText());
                myStore.removeProduct(val);

                for(int index = 0; index < dtm.getRowCount(); index++){
                    if(Integer.parseInt(dtm.getValueAt(index, 0).toString()) == val){
                        dtm.removeRow(index);
                    }
                }
            }
        }
    });

   
    JPanel p = new JPanel(new GridLayout(1,2));
    p.add(addBtn);
    p.add(deleteBtn);
    JFrame f = new JFrame();
    f.getContentPane().add(sp);
    f.getContentPane().add(p,BorderLayout.SOUTH);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);



  }
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Testing().buildGUI();
      }
    });
  }
}
