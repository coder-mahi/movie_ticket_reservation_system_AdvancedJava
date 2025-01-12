import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
public class test{
    public static void main(String args[]){
    JFrame f = new JFrame();
    f.setLayout(new FlowLayout());
    f.setVisible(true);
    f.setSize(500,500);
    JTable table = new JTable();
    JScrollPane scrollpane = new JScrollPane(table); 
    f.add(scrollpane);
    try{
            DefaultTableModel model = new DefaultTableModel();
        Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		    Statement stmt = con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from movie_ticket_reservation");

		while(rs.next()){   
                String tdata[] = {rs.getString(1),rs.getString(2),String.valueOf(rs.getInt(3)),String.valueOf(rs.getInt(4)),rs.getString(5),
                String.valueOf(rs.getInt(6))};
                model.addRow(tdata);
                System.out.println("connection established successfully...!");
                }
			con.close();
		}catch(Exception ex){System.out.println(ex);}
}
}
