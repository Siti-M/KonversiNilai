
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LihatData extends JFrame{
    String[][] data = new String [100][8]; //jumlah baris dan kolom tabel
    String[] kolom = {"nim","nama","mk1","nilai1","mk2","nilai2","rata-rata","nilai"}; // nama kolom bebas
    JTable tabel;
    JScrollPane scrollPane;
    Statement statement;
    ResultSet resultSet;
    
    public void cekData(){
        setTitle("Data Mahasiswa");
        try {
            //untuk mengambil data dari database
            koneksi conn = new koneksi();
            statement = conn.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM nilaimhs";
            resultSet = statement.executeQuery(sql);
            
            int p = 0;
            while (resultSet.next()){
                data[p][0]=resultSet.getString("nim"); // nama harus sesuai Database
                data[p][1]=resultSet.getString("nama");
                data[p][2]=resultSet.getString("mk1");
                data[p][3]=resultSet.getString("nilai1");
                data[p][4]=resultSet.getString("mk2");
                data[p][5]=resultSet.getString("nilai2");
                data[p][6]=resultSet.getString("nRata");
                data[p][7]=resultSet.getString("nHuruf");
                p++;
            }
            statement.close();
            conn.getKoneksi().close();
            
        } catch (SQLException sqle){
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqle);
        } catch (ClassNotFoundException classe){
            JOptionPane.showMessageDialog(rootPane, "Data Tidak Ditemukan" + classe);
        }
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);
        
        setLayout(new FlowLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
