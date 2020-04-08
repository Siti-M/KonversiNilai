
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class form extends JFrame {
    JLabel lnama,lnim,lmk1,lnilai1,lmk2,lnilai2;
    JTextField tnama,tnim,tmk1,tnilai1,tmk2,tnilai2;
    JButton convert;
    Statement statement;
    
    public void lihatform (){
        setTitle("Hitung Nilai");
        
        lnim = new JLabel("NIM ");
        lnama = new JLabel("Nama ");
        lmk1 = new JLabel("Mata Kuliah 1 ");
        lnilai1 = new JLabel("Nilai 1 ");
        lmk2 = new JLabel("Mata Kuliah 2 ");
        lnilai2 = new JLabel("Nilai 2 ");
        
        tnim = new JTextField("");
        tnama = new JTextField("");
        tmk1 = new JTextField("");
        tnilai1 = new JTextField("");
        tmk2 = new JTextField("");
        tnilai2 = new JTextField("");
        
        convert = new JButton("Convert");
        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lmk1);
        add(lnilai1);
        add(lmk2);
        add(lnilai2);
        add(tnim);
        add(tnama);
        add(tmk1);
        add(tnilai1);
        add(tmk2);
        add(tnilai2);
        add(convert);
        
        // mengatur posisi gui
        lnim.setBounds(30, 50, 30, 20);
        lnama.setBounds(30, 75, 50, 20);
        lmk1.setBounds(30, 100, 80, 20);
        lnilai1.setBounds(30, 125, 50, 20);
        lmk2.setBounds(30, 150, 80, 20);
        lnilai2.setBounds(30, 175, 50, 20);
        tnim.setBounds(140, 50, 150, 20);
        tnama.setBounds(140, 75, 150, 20);
        tmk1.setBounds(140, 100, 150, 20);
        tnilai1.setBounds(140, 125, 150, 20);
        tmk2.setBounds(140, 150, 150, 20);
        tnilai2.setBounds(140, 175, 150, 20);
        convert.setBounds(120, 220, 100, 20);
        
        setSize(350,300); // menentukan luas jendela tampilan 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nim =  Integer.parseInt(tnim.getText());
                    String nama = tnama.getText();
                    String mk1 = tmk1.getText();
                    int nilai1 =  Integer.parseInt(tnilai1.getText());
                    String mk2 = tmk2.getText();
                    int nilai2 =  Integer.parseInt(tnilai2.getText());
                    float nRata = (float)((nilai1+nilai2)*0.5);
                    String nilai = angkaKeHuruf( nRata );
                    
                    // memasukan nilai input ke database
                    koneksi conn = new koneksi();
                    try {
                        
                        statement = conn.getKoneksi().createStatement();
                        statement.executeUpdate("INSERT INTO nilaimhs VALUES ('" + nim + "','" + nama +
                            "','" + mk1 + "','" + nilai1 + "','"+ mk2 + "','" + nilai2 + "','" + nRata + "','" + nilai + "')" );
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (SQLException ex) {
                        Logger.getLogger(form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    //menampilkan data 
                    System.out.println("NIM : "+ nim);
                    System.out.println("Nama : "+ nama);
                    System.out.println("Mata Kuliah 1 : "+ mk1);
                    System.out.println("Mata Kuliah 2 : "+ mk2);
                    System.out.println("Rata - rata : "+ nRata);
                    System.out.println("Nilai Huruf : "+ nilai);
                    
                    
                } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                } catch (Error ext){
                 JOptionPane.showMessageDialog(rootPane,"SALAH");
                 
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // mengubah nilai angka menjadi huruf
            private String angkaKeHuruf (float nRata) {
               if (nRata>=80 && nRata<=100) return "A";
               else if (nRata>=75 && nRata<80) return "B+";
               else if (nRata>=65 && nRata<75) return "B";
               else if (nRata>=60 && nRata<65) return "C+";
               else if (nRata>=50 && nRata<60) return "C";
               else if (nRata>=20 && nRata<50) return "D";
               else if (nRata>=0 && nRata<20) return "E";
               else return "Error";
            }
        });
    }
}
