import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
public class MTRS extends JFrame{
    public MTRS(){
        setTitle("Movie Ticket Reservation System: 145");
        setSize(1280,720);
        setVisible(true);
        setLayout(null);
        // setDefaultCloseOption(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
            JTabbedPane tp=new JTabbedPane();
	        tp.setBounds(350,20,700,600);
            JPanel bookpanel=new JPanel();
            bookpanel.setBackground(Color.GREEN);
	        bookpanel.setLayout(null);

            JPanel viewpanel=new JPanel(); 
            viewpanel.setBackground(Color.ORANGE);
	        viewpanel.setLayout(null);

            JPanel cancelpanel=new JPanel();
            cancelpanel.setBackground(Color.RED);
            cancelpanel.setLayout(null);
    
	    tp.add("Book_Seats",bookpanel);
	    tp.add("View_Seats",viewpanel);
	    tp.add("Cancel_Reservation",cancelpanel);
        add(tp);

        BookSeats b = new BookSeats(bookpanel);
        ViewReservedSeats v = new ViewReservedSeats(viewpanel);
	    CancelReservation c = new CancelReservation(cancelpanel);
    }
    public static void main(String args[]){
        MTRS obj = new MTRS();
    }
}

class BookSeats implements ActionListener{
    private JLabel header1,header2,l1,l2,l3,l4,l5,l6,labelStatus;
    private JTextField in_name,in_mob_no,in_email_id;
    private JComboBox movies,seatNo;
    ButtonGroup radiogrp;
    JRadioButton r1,r2,r3,r4,r5;
    JButton submitBtn;
    String movies_arr[] = {"LEO","JAWAN","JAILER","AVATAR","TIGER3"};
    String seats_arr[] = {
        "1","2","3","4","5","6","7","8","9","10",
        "11","12","13","14","15","16","17","18","19","20",
        "21","22","23","24","25","26","27","28","29","30",
        "31","32","33","34","35","36","37","38","39","40",
        "41","42","43","44","45","46","47","48","49","50",
        "51","52","53","54","55","56","57","58","59","60",
        "61","62","63","64","65","66","67","68","69","70",
        "71","72","73","74","75","76","77","78","79","80",
        "81","82","83","84","85","86","87","88","89","90",        
        "91","92","93","94","95","96","97","98","99","100"};

    public BookSeats(JPanel panel1){
        header1 = new JLabel("## Movie Ticket Reservation Sytem ##");
	    header2 = new JLabel("Enter Your Details Here :");
	    l1 = new JLabel("Enter Your Name :");
        l2 = new JLabel("Enter Your Email ID :");
 	    l3 = new JLabel("Enter Your Mob No :");
 	    l4 = new JLabel("No of Tickets you want to buy :");
        l5 = new JLabel("Select Movie :");
        l6 = new JLabel("Choose Your Seat Number :");
        labelStatus = new JLabel("Reservation Status :");

	   in_name = new JTextField();
       in_email_id = new JTextField();
	   in_mob_no = new JTextField();
	   submitBtn = new JButton("SUBMIT >");

       movies = new JComboBox(movies_arr);
       seatNo = new JComboBox(seats_arr);

       r1 = new JRadioButton("1",true);
       r2 = new JRadioButton("2");
       r3 = new JRadioButton("3");
       r4 = new JRadioButton("4");
       r5 = new JRadioButton("5");
            radiogrp = new ButtonGroup();
            radiogrp.add(r1);
            radiogrp.add(r2);
            radiogrp.add(r3);
            radiogrp.add(r4);
            radiogrp.add(r5);

	   header1.setBounds(250,20,300,40);
       header2.setBounds(280,70,300,40);
	   l1.setBounds(150,130,150,40);
       l2.setBounds(150,180,150,40);
	   l3.setBounds(150,230,150,40);
	   l4.setBounds(150,280,200,40);
	   l5.setBounds(150,330,200,40);
	   l6.setBounds(150,380,200,40);
           panel1.add(header1);
           panel1.add(header2);
           panel1.add(l1);
           panel1.add(l2);
           panel1.add(l3);
           panel1.add(l4);
           panel1.add(l5);
           panel1.add(l6);
	   in_name.setBounds(350,130,200,30);
       in_email_id.setBounds(350,180,200,30);
	   in_mob_no.setBounds(350,230,200,30);
            r1.setBounds(350,280,50,30);
            r2.setBounds(400,280,50,30);
            r3.setBounds(450,280,50,30);
            r4.setBounds(500,280,50,30);
            r5.setBounds(550,280,100,30);
       movies.setBounds(350,330,100,30);
       seatNo.setBounds(350,380,100,30);
       submitBtn.setBounds(300,450,100,50);
       labelStatus.setBounds(150,500,300,50);
           panel1.add(in_name);
           panel1.add(in_email_id);
           panel1.add(in_mob_no);
           panel1.add(r1);           
           panel1.add(r2);
           panel1.add(r3);
           panel1.add(r4);
           panel1.add(r5);
           panel1.add(movies);
           panel1.add(seatNo);
           panel1.add(submitBtn);
           panel1.add(labelStatus);
       submitBtn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String username = in_name.getText();
        String emailid = in_email_id.getText();
        int mobno = Integer.parseInt(in_mob_no.getText());
        String selectedMovie = (String) movies.getSelectedItem(); 
        int selectedSeatNo = (int) seatNo.getSelectedItem();
        String selectedTickets = radiogrp.getSelection().getActionCommand();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement stmt = con.prepareStatement("insert into movie_ticket_reservation values (?,?,?,?,?,?)");
   			stmt.setString(1,username);
            stmt.setString(2,emailid);
   			stmt.setInt(3,mobno);
            stmt.setInt(4,Integer.parseInt(selectedTickets));
            stmt.setString(5,selectedMovie);
            stmt.setInt(6,selectedSeatNo);	      
            int rs=stmt.executeUpdate();
			if(rs>0){
                labelStatus.setText("Reservation Status : Seat Reserved Successfully..!");
                }
			else{
                labelStatus.setText("Reservation Status : Seat Is Already Reserved..!");
                }
			con.close();
        }catch(Exception ex){System.out.println(ex);}
        }
    // }
}
class ViewReservedSeats implements ActionListener
{
    JButton showSeats;
    JTable table;
    JScrollPane scrollpane; 
    ViewReservedSeats(JPanel panel2){
        showSeats = new JButton("CLICK HERE TO VIEW RESERVED SEATS");
        table = new JTable();
        scrollpane = new JScrollPane(table);
        showSeats.setBounds(200,20,300,30);
        scrollpane.setBounds(50,100,600,300);
        panel2.add(scrollpane);
        panel2.add(showSeats);
        showSeats.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        try
		{ 
            DefaultTableModel model = new DefaultTableModel();
			String []col={"Name","Email_Address","Mobile_No","Tickets","Movie_Name","Seat_No"};
 			model.setColumnIdentifiers(col);
            table.setModel(model);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		    Statement stmt = con.createStatement();
		    ResultSet rs=stmt.executeQuery("select * from movie_ticket_reservation");

            // ResultSetMetaData rsmd = rs.getMetaData();
            // DefaultTableModel tb1 = (DefaultTableModel) table.getModel();
            // model = (DefaultTableModel) table.getModel();

            // int column = rsmd.getColumnCount();
            // String[] colName = new String[column];
            // for(int i=1; i<column; i++){
            //     colName[i] = rsmd.getColumnName(i + 1);
            // }
            //  	model.setColumnIdentifiers(colName);

            // String []row1={"Shinde Mahesh T","maheshshinde9100@gmail.com","9529544681","1","LEO","45"};
            // model.addRow(row1);
			while(rs.next()){
                String value1 = rs.getString(1);
                String value2 = rs.getString(2);
                String value3 = String.valueOf(rs.getInt(3)); 
                String value4 = String.valueOf(rs.getInt(4));
                String value5 = rs.getString(5);
                String value6 = String.valueOf(rs.getInt(6));     

                String tdata[] = {value1,value2,value3,value4,value5,value6};     
                model.addRow(tdata);      
                }
			con.close();
		}catch(Exception ex){System.out.println(ex.getMessage());}
		}
}

class CancelReservation implements ActionListener{
    JLabel cancel_res1,cancel_res2,cancel_status;
    JTextField seat_no_for_cancel_res,movie_name_for_cancel_res;
    JButton cancel_res_button;
        CancelReservation(JPanel panel3){
            cancel_res1 = new JLabel("Enter Your Reserved Seat No. For Cancel Reservation :");
            cancel_res2 = new JLabel("Enter Movie Name :"); 
            cancel_status = new JLabel("Reservation cancelation status :");
            seat_no_for_cancel_res = new JTextField();
            movie_name_for_cancel_res = new JTextField();
            cancel_res_button = new JButton("CANCEL RESERVATION");
                cancel_res1.setBounds(100,130,400,30);
                cancel_res2.setBounds(100,180,150,30);
                cancel_status.setBounds(150,500,300,50);
            seat_no_for_cancel_res.setBounds(450,130,100,30);
            movie_name_for_cancel_res.setBounds(450,180,100,30);
            cancel_res_button.setBounds(400,300,200,30);
            panel3.add(cancel_res1);
            panel3.add(cancel_res2);
            panel3.add(movie_name_for_cancel_res);
            panel3.add(seat_no_for_cancel_res);
            panel3.add(cancel_res_button);
        cancel_res_button.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e){
        try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement stmt = con.prepareStatement("delete from movie_ticket_reservation where Seat_No=? and Movie_Name=?");
   			stmt.setString(1,seat_no_for_cancel_res.getText());
   			stmt.setString(2,movie_name_for_cancel_res.getText());
		      	int rs=stmt.executeUpdate();
            if(rs>0){
            cancel_status.setText("Seat Unreserved Succeesfully....!");
            }
			else{
                cancel_status.setText("Seat Not Reserved...!");
            }
			System.out.println("Deleted Record");
			con.close();
		}catch(Exception ex){
            System.out.println(ex);
        }
}
}

