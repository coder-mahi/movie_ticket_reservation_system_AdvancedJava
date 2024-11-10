// package microproject;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
public class MTRS extends JFrame{
    // JFrame frame = new JFrame();
    MTRS(){
        setTitle("Movie Ticket Reservation System: 145");
        setSize(1280,720);
        setVisible(true);
        setLayout(null);
        // setDefaultCloseOption(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
            JTabbedPane tp=new JTabbedPane();
	        tp.setBounds(350,20,600,600);
            JPanel bookpanel=new JPanel();
            bookpanel.setBackground(Color.GREEN);
	        bookpanel.setLayout(null);

            JPanel viewpanel=new JPanel(); 
            viewpanel.setBackground(Color.ORANGE);
	        viewpanel.setLayout(null);

            JPanel cancelpanel=new JPanel();
            cancelpanel.setBackground(Color.RED);
            cancelpanel.setLayout(null);
    
	    tp.add("Book_Seat",bookpanel);
	    tp.add("View_Seats",viewpanel);
	    tp.add("Cancel_Reservation",cancelpanel);
        add(tp);

        BookSeats b =new BookSeats(bookpanel);
        ViewReservedSeats v=new ViewReservedSeats(viewpanel);
	    CancelReservation c=new CancelReservation(cancelpanel);
}
    public static void main(String args[]){
        MTRS obj = new MTRS();
    }
}

class BookSeats implements ActionListener{
    JLabel header1,header2,l1,l2,l3,l4,l5,l6,labelStatus;
    JTextField in_name,in_mob_no,in_email_id;
    JComboBox movies,seatNo;
    ButtonGroup radiogrp;
    JRadioButton t1,t2,t3,t4,t5;
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

    BookSeats(JPanel panel1){
        header1 = new JLabel("## Movie Ticket Reservation Sytem ##");
	    header2 = new JLabel("Enter Your Details Here :");
	    l1 = new JLabel("Enter Your Name :");
        l2 = new JLabel("Enter Your Email ID :");
 	    l3 = new JLabel("Enter Your Mob No :");
 	    l4 = new JLabel("No of Tickets you want to buy :");
        l5 = new JLabel("Select Movie :");
        l6 = new JLabel("Choose Your Seat Number :");
        labelStatus = new JLabel("Reservation Satus :");

	   in_name = new JTextField(100);
       in_email_id = new JTextField(100);
	   in_mob_no = new JTextField(100);
	   submitBtn = new JButton("SUBMIT >");

       movies = new JComboBox(movies_arr);
       seatNo = new JComboBox(seats_arr);

       t1 = new JRadioButton("1",true);
       t2 = new JRadioButton("2");
       t3 = new JRadioButton("3");
       t4 = new JRadioButton("4");
       t5 = new JRadioButton("5");
              radiogrp = new ButtonGroup();
              radiogrp.add(t1);
              radiogrp.add(t2);
              radiogrp.add(t3);
              radiogrp.add(t4);
              radiogrp.add(t5);

	   header1.setBounds(200,20,300,40);
       header2.setBounds(250,70,300,40);
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
            t1.setBounds(350,280,50,30);
            t2.setBounds(400,280,50,30);
            t3.setBounds(450,280,50,30);
            t4.setBounds(500,280,50,30);
            t5.setBounds(550,280,100,30);
       movies.setBounds(350,330,100,30);
       seatNo.setBounds(350,380,100,30);
       submitBtn.setBounds(300,450,100,50);
       labelStatus.setBounds(350,550,200,50);
           panel1.add(in_name);
           panel1.add(in_email_id);
           panel1.add(in_mob_no);
           panel1.add(t1);           
           panel1.add(t2);
           panel1.add(t3);
           panel1.add(t4);
           panel1.add(t5);
           panel1.add(movies);
           panel1.add(seatNo);
           panel1.add(submitBtn);
           panel1.add(labelStatus);
    //    submitBtn.addActionListener(this);
    }
    public static void main(String args[]){
        BookSeats obj1 = new BookSeats();
    }
}
// public void actionPerformed(ActionEvent e){
//         String username = in_name.getText().toString();
//         String emailid = in_email_id.getText().toString();
//         int mobno = Integer.parseInt(in_mob_no.getText());
//         String selectedMovie = movies.getSelectedItem(); 
//         int selectedSeatNo = Integer.parseInt(seatNo.getSelectedItem());
//         String selectedTickets = radiogrp.getSelection().getActionCommand();
//         try{
//             Class.forName("oracle.jdbc.driver.OracleDriver");
// 			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
// 			PreparedStatement stmt = con.prepareStatement("insert into movie_ticket_reservation values (?,?,?,?,?,?)");
   			// stmt.setString(1,username);
            // stmt.setString(2,emailid);
   			// stmt.setInt(3,mobno);
            // stmt.setInt(4,Integer.parseInt(selectedTickets));
            // stmt.setString(5,selectedMovie);
            // stmt.setInt(6,selectedSeatNo);
		      
//         //     int rs=stmt.executeUpdate();
// 		// 	if(rs>0){
//         //         labelStatus.setText("Reservation Status : Seat Reserved");}
// 		// 	else{
//         //         labelStatus.setText("Reservation Status : Seat Is Already Reserved...!");
//         //         }
// 			con.close();

//         }catch(Exception ex){
//             System.out.println(ex);
//         }
// }

class ViewReservedSeats{
    JButton showSeats;
    ViewReservedSeats(JPanel panel2){
        showSeats = new JButton("CLICK HERE TO VIEW RESERVED SEATS");
        showSeats.setBounds(200,200,300,40);
        panel2.add(showSeats);
        // viewseat.addActionListener(this);
    }
}
// public void actionPerformed(ActionEvent e){
//     try{
//             Class.forName("oracle.jdbc.driver.OracleDriver");
// 			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
// 	// 		Statement stmt = con.prepareStatement("select * from movie_ticket_reservation");
//     //          ResultSet rs=stmt.executeQuery();
// 	// 	        System.out.println(123);
// 	// 		while(rs.next())
// 	// 		{
// 	// 		    System.out.println(rs.getString("Name")+ "  "+rs.getString("Email_Address")+"  "+rs.getString("Movie_Name")+" "+ rs.getInt("Seat_No"));
// 	// 			// model1.addRow(new Object[]{rs.getString("Name"), rs.getString("Email_Address"), rs.getString("Movie_Name"), rs.getInt("Seat_No")});
// 	// 		}
// 		con.close();
// 		}catch(Exception e){System.out.println(e);
//         }
// }
class CancelReservation{
    JLabel cancel_res1,cancel_res2;
    JTextField seat_no_for_cancel_res,movie_name_for_cancel_res;
    JButton cancel_res_button;
        CancelReservation(JPanel panel3){
            cancel_res1 = new JLabel("Enter Your Reserved Seat No. For Cancel Reservation :");
            cancel_res2 = new JLabel("Enter Movie Name :"); 
            seat_no_for_cancel_res = new JTextField();
            movie_name_for_cancel_res = new JTextField();
            cancel_res_button = new JButton("CANCEL RESERVATION");
                cancel_res1.setBounds(300,200,600,30);
                cancel_res2.setBounds(300,250,600,30);

            seat_no_for_cancel_res.setBounds(300,200,100,30);
            movie_name_for_cancel_res.setBounds(300,250,100,30);
            cancel_res_button.setBounds(400,300,200,50);
            panel3.add(cancel_res1);
            panel3.add(cancel_res2);
            panel3.add(movie_name_for_cancel_res);
            panel3.add(seat_no_for_cancel_res);
            panel3.add(cancel_res_button);
        // cancel_res_button.addActionListener(this);
        }
}
// public void actionPerformed(ActionEvent e){
//         try
// 		{
// 			Class.forName("oracle.jdbc.driver.OracleDriver");
// 			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
// 		// 	PreparedStatement stmt = con.prepareStatement("delete from Employee where Seat_No=? and Movie_Name=?");
//    		// 	stmt.setString(1,seat_no_for_cancel_res.getText());
//    		// 	stmt.setString(2,movie_name_for_cancel_res.getText());
// 		//       	int rs=stmt.executeUpdate();
//         //                 if(rs>0){l3.setText("Seat Unreserved Succeesfully....!");}
// 		// 	else{l3.setText("Seat Not Reserved...!");}
// 		// 	System.out.println("Deleted Record");
// 			con.close();
// 		}catch(Exception e){
//             System.out.println(e);
//         }
// }
