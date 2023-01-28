import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.*; //external lib
import java.io.*;
import java.time.*;
import javax.swing.table.*;

public class GUIView implements ActionListener, MouseListener, FocusListener, WindowListener{
    //main component
    private JFrame fr;
    private JPanel p1, p2, p3, p4;
    private JPanel con1, con2, con3, con4;
    private JButton b1, b2, b3, b4;
    private JLabel lb1;
    private DateEvent date_event;
    private ArrayList<DateEvent> arr;
    private ArrayList<DateEvent> cpy_arr;
    int num = 0;
    
    //content1 component
    private JPanel c1_p1, c1_p2, c1_p3, c1_p4, c1_p5;
    private JLabel c1_lb1, c1_lb2, c1_lb3, c1_lb4, c1_lb5, c1_lb6;
    private JTextField c1_t2, c1_t3;
    private JButton c1_b1;
    private JDateChooser c1_t1;
    
    //content2 component
    private JScrollPane c2_sp1;
    private JPanel c2_p1, c2_p2, c2_p3, c2_p4, c2_p5, c2_p6;
    private JLabel c2_lb1, c2_lb2, c2_lb3;
    
    //content3 component
    private JComboBox c3_cb1, c3_cb2;
    private JPanel c3_p1, c3_p2, c3_p3, c3_p4, c3_p5, c3_p6, c3_p7;
    private JTextArea c3_ta1;
    private JScrollPane c3_sp1;
    private String[] arr_month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private String[] arr_day = {"Mon", "Tue", "Wed", "Tue", "Fri", "Sat", "Sun"};
    
    //content4 component
    private JPanel c4_p1, c4_p2;
    private JLabel c4_lb1, c4_lb2, c4_lb3;
    private JButton c4_b1, c4_b2, c4_b3;
    private JTextField c4_t1, c4_t2, c4_t3;
    private JScrollPane c4_sp1;
    private JTable c4_table;
    private JComboBox c4_cb;
    
    private int test = 0;
    
    public GUIView(){
        fr = new JFrame("Simp");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        con1 = new JPanel();
        con2 = new JPanel();
        con3 = new JPanel();
        con4 = new JPanel();
        b1 = new JButton("  ADD");
        b2 = new JButton("LIST");
        b3 = new JButton("CALENDAR");
        b4 = new JButton("TABLE");
        lb1 = new JLabel("WELCOME TO PROGRAM");
        arr = new ArrayList();
        
        
        //starting gui
        p1.setLayout(new BorderLayout());
        p3.setLayout(new GridLayout(1,1));
        p1.add(p4, BorderLayout.NORTH);
        p1.add(p2, BorderLayout.WEST);
        p1.add(p3, BorderLayout.CENTER);
        p3.add(con1);
        p4.add(lb1, BorderLayout.CENTER);
        p2.setLayout(new FlowLayout());
        fr.add(p1);
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        con1.setLayout(new FlowLayout());
        
        p2.setPreferredSize( new Dimension( 300, 500 ) );
        b1.setPreferredSize( new Dimension( 290, 100 ) );
        b2.setPreferredSize( new Dimension( 290, 100 ) );
        b3.setPreferredSize( new Dimension( 290, 100 ) );
        b4.setPreferredSize( new Dimension( 290, 100 ) );
        
        p2.setBackground(new Color(35,35,50));
        b1.setBackground(new Color(35,35,50));
        b1.setForeground(Color.white);
        b1.setBorder(null);
        b1.setFocusable(false);
        b1.setBorder(BorderFactory.createLineBorder(Color.white,1));
        b2.setBackground(new Color(35,35,50));
        b2.setForeground(Color.white);
        b2.setBorder(null);
        b2.setFocusable(false);
        b2.setBorder(BorderFactory.createLineBorder(Color.white,1));
        b3.setBackground(new Color(35,35,50));
        b3.setForeground(Color.white);
        b3.setBorder(null);
        b3.setFocusable(false);
        b3.setBorder(BorderFactory.createLineBorder(Color.white,1));
        b4.setBackground(new Color(35,35,50));
        b4.setForeground(Color.white);
        b4.setBorder(null);
        b4.setFocusable(false);
        b4.setBorder(BorderFactory.createLineBorder(Color.white,1));
        
        //button font
        b1.setFont(new Font("Arial", Font.PLAIN, 30));
        b2.setFont(new Font("Arial", Font.PLAIN, 30));
        b3.setFont(new Font("Arial", Font.PLAIN, 30));
        b4.setFont(new Font("Arial", Font.PLAIN, 30));
        
        //button image
        b1.setIcon(new ImageIcon(this.getClass().getResource("image/addicon1.jpg")));
        b2.setIcon(new ImageIcon(this.getClass().getResource("image/taskpng.jpg")));
        b3.setIcon(new ImageIcon(this.getClass().getResource("image/calendarpng.jpg")));
        b4.setIcon(new ImageIcon(this.getClass().getResource("image/tablepng.jpg")));
        
        con1.setBackground(new Color(240,255,255));
        con2.setBackground(new Color(240,255,255));
        con3.setBackground(new Color(240,255,255));
        con4.setBackground(new Color(240,255,255));
        
        //con1 setLayout
        ImageIcon icon = new ImageIcon(GUIView.class.getResource("image/textfield.png"));
        c1_t2 = new JTextField("HH:MM", 30);
        c1_t3 = new JTextField(30);
        c1_lb1 = new JLabel(icon);
        c1_lb2 = new JLabel(icon);
        c1_lb3 = new JLabel(icon);
        c1_lb4 = new JLabel("DATE :  ");
        c1_lb5 = new JLabel("TIME :  ");
        c1_lb6 = new JLabel("EVENT : ");
        c1_p1 = new JPanel();
        c1_p2 = new JPanel();
        c1_p3 = new JPanel();
        c1_p4 = new JPanel();
        c1_p5 = new JPanel();
        c1_b1 = new JButton("Add");
        
        Calendar maxCalendar = Calendar.getInstance ( );
        maxCalendar.set ( 2050, 12, 31 );
        Date maxDate = maxCalendar.getTime ( );
        Calendar minCalendar = Calendar.getInstance ( );
        minCalendar.set ( 2020, 1, 1 );
        Date minDate = minCalendar.getTime ( );
        c1_t1 = new JDateChooser ();
        c1_t1.setDate ( new Date ( ) );
        c1_t1.setDateFormatString("dd/MM/yyyy");
        c1_t1.setMaxSelectableDate ( maxDate );
        c1_t1.setMinSelectableDate ( minDate );
        c1_t1.setPreferredSize(new Dimension(349,50));
        c1_t2.setPreferredSize(new Dimension(349,50));
        c1_t3.setPreferredSize(new Dimension(349,50));
        
        ((JTextFieldDateEditor)c1_t1.getDateEditor()).setBackground(Color.black);
        ((JTextFieldDateEditor)c1_t1.getDateEditor()).setForeground(Color.white);
        c1_t2.setOpaque( false );
        c1_t3.setOpaque( false );
        c1_p1.setBackground(new Color(240,255,255));
        c1_p2.setBackground(new Color(240,255,255));
        c1_p3.setBackground(new Color(240,255,255));
        c1_p4.setBackground(new Color(240,255,255));
        c1_p5.setBackground(new Color(240,255,255));
        c1_t2.setForeground(Color.gray);
        c1_t3.setForeground(Color.white);
        
        c1_p1.setLayout(new GridLayout(5, 1));
        c1_p2.setLayout(new FlowLayout());
        c1_p3.setLayout(new FlowLayout());
        c1_p4.setLayout(new FlowLayout());
        c1_p5.setLayout(new FlowLayout());
        c1_lb1.setLayout(new FlowLayout());
        c1_lb2.setLayout(new FlowLayout());
        c1_lb3.setLayout(new FlowLayout());
        
        c1_lb1.add(c1_t1);
        c1_lb2.add(c1_t2);
        c1_lb3.add(c1_t3);
        
        c1_p2.add(c1_lb4);
        c1_p2.add(c1_lb1);
        c1_p3.add(c1_lb5);
        c1_p3.add(c1_lb2);
        c1_p4.add(c1_lb6);
        c1_p4.add(c1_lb3);
        c1_p5.add(c1_b1);
        
        c1_p1.add(new JLabel(""));
        c1_p1.add(c1_p2);
        c1_p1.add(c1_p3);
        c1_p1.add(c1_p4);
        c1_p1.add(c1_p5);
        con1.add(c1_p1);
        
        c1_t2.setCaretColor(Color.WHITE);
        c1_t3.setCaretColor(Color.WHITE);
        
        c1_lb4.setFont(new Font("Monospaced", Font.BOLD, 20));
        c1_lb5.setFont(new Font("Monospaced", Font.BOLD, 20));
        c1_lb6.setFont(new Font("Monospaced", Font.BOLD, 20));
        c1_t2.setFont(new Font("Monospaced", Font.BOLD, 18));
        c1_t3.setFont(new Font("Monospaced", Font.BOLD, 18));
        ((JTextFieldDateEditor)c1_t1.getDateEditor()).setFont(new Font("Monospaced", Font.BOLD, 18));
        c1_lb1.setPreferredSize( new Dimension(360, 59)  );
        c1_lb2.setPreferredSize( new Dimension(360, 59)  );
        c1_lb3.setPreferredSize( new Dimension(360, 59)  );
        c1_b1.setPreferredSize( new Dimension (120, 59));
        c1_p1.setPreferredSize( new Dimension( 1000, 500)  );
        c1_t2.setBorder(null);
        c1_t3.setBorder(null);
        ((JTextFieldDateEditor)c1_t1.getDateEditor()).addFocusListener(this);
        c1_t2.addFocusListener(this);
        
        //con2
        c2_sp1 = new JScrollPane();
        
        //con3
        c3_cb1 = new JComboBox();
        c3_cb2 = new JComboBox();
        c3_sp1 = new JScrollPane();
        con3.add(c3_sp1);
        
        for(int i=0; i<12; i++){
            c3_cb1.addItem(arr_month[i]);
        }
        for(int i=2020; i<=2050; i++){
            c3_cb2.addItem(i);
        }
        
        c3_cb1.addActionListener(this);
        c3_cb2.addActionListener(this);
        
        //con4 setLayout
        c4_p1 = new JPanel();
        c4_p2 = new JPanel();
        c4_lb1 = new JLabel("Date :");
        c4_lb2 = new JLabel("Time :");
        c4_lb3 = new JLabel("Event :");
        c4_t1 = new JTextField(20);
        c4_t2 = new JTextField(20);
        c4_t3 = new JTextField(20);
        c4_sp1 = new JScrollPane();
        c4_b1 = new JButton("UPDATE");
        c4_b2 = new JButton("DELETE");
        c4_b3 = new JButton("Export To Excel");
        c4_cb = new JComboBox();
        
        c4_cb.addItem("ID : low - high");
        c4_cb.addItem("ID : high - low");
        c4_cb.addItem("Date : low - high");
        c4_cb.addItem("Date : high - low");
        
        c4_p1.setLayout(new FlowLayout());
        c4_p2.setLayout(new FlowLayout());
        c4_p1.add(c4_lb1);
        c4_p1.add(c4_t1);
        c4_p1.add(new JLabel("         "));
        c4_p1.add(c4_lb2);
        c4_p1.add(c4_t2);
        c4_p1.add(new JLabel("         "));
        c4_p1.add(c4_lb3);
        c4_p1.add(c4_t3);
        c4_p2.add(c4_b1);
        c4_p2.add(new JLabel("         "));
        c4_p2.add(c4_b2);
        con4.add(c4_cb);
        con4.add(new Label("            "));
        con4.add(c4_b3);
        
        c4_lb1.setFont(new Font("Monospaced", Font.BOLD, 20));
        c4_lb2.setFont(new Font("Monospaced", Font.BOLD, 20));
        c4_lb3.setFont(new Font("Monospaced", Font.BOLD, 20));
        
        c4_p1.setBackground(new Color(240,255,255));
        c4_p2.setBackground(new Color(240,255,255));
        
        c4_cb.setPreferredSize(new Dimension(400,40));
        c4_t1.setPreferredSize(new Dimension(0,25));
        c4_t2.setPreferredSize(new Dimension(0,25));
        c4_t3.setPreferredSize(new Dimension(0,25));
        c4_b1.setPreferredSize(new Dimension(200,40));
        c4_b2.setPreferredSize(new Dimension(200,40));
        c4_p1.setPreferredSize( new Dimension(1000, 59)  );
        
        //add windowlistener
        fr.addWindowListener(this);
        
        //add actionlistner
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        c1_b1.addActionListener(this);
        c4_b1.addActionListener(this);
        c4_b2.addActionListener(this);
        c4_b3.addActionListener(this);
        c4_cb.addActionListener(this);
        
        //add mouselistener
        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        b4.addMouseListener(this);
        
        fr.setSize(1400, 850);
        fr.setResizable(false);
        fr.setLocation(300, 100);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b1)){
            changeContent(con1);
        }
        else if(e.getSource().equals(b2)){
            changeContent(con2);
            cpy_arr = (ArrayList)arr.clone();
            cpy_arr.sort(new DateAndTimeSorter());
            ListContent(cpy_arr);
        }
        else if(e.getSource().equals(b3)){
            changeContent(con3);
            cpy_arr = (ArrayList)arr.clone();
            CreateCalendar(cpy_arr);
        }
        else if(e.getSource().equals(b4)){
            changeContent(con4);
            cpy_arr = (ArrayList)arr.clone();
            createTable(cpy_arr);
            c4_cb.setSelectedIndex(0);
        }
        else if(e.getSource().equals(c1_b1)){
            if(Integer.parseInt(((JTextField)c1_t1.getDateEditor().getUiComponent()).getText().substring(0,2)) > 31 ||
               Integer.parseInt(((JTextField)c1_t1.getDateEditor().getUiComponent()).getText().substring(3,5)) > 12){
                JOptionPane.showMessageDialog(null, "Please insert date in format DD:MM:YYYY");
                return;
            }
            if(c1_t2.getText().length() != 5 || !c1_t2.getText().contains(":") || c1_t2.getText().equals("HH:MM")){
                JOptionPane.showMessageDialog(null, "Please insert time in format HH:MM.");
                return;
            }
            if(c1_t3.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please insert event.");
                return;
            }
            if(arr.isEmpty()){
                num = 1;
            }
            else{
                num = (arr.get(arr.size()-1).getID())+1;
            }
            date_event = new DateEvent(num, ((JTextField)c1_t1.getDateEditor().getUiComponent()).getText(), c1_t2.getText(), c1_t3.getText());
            for(int i=0; i<arr.size(); i++){
                if(date_event.getDate().equals(arr.get(i).getDate()) && date_event.getTime().equals(arr.get(i).getTime())){
                    JOptionPane.showMessageDialog(null, "You have an appointment");
                    return;
                }
            }
            arr.add(date_event);
            for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i).getID()+" ");
                System.out.print(arr.get(i).getDate()+" ");
                System.out.print(arr.get(i).getTime()+" ");
                System.out.println(arr.get(i).getEvent());
            }
            JOptionPane.showMessageDialog(null, "Done.");
            c1_t2.setText("");
            c1_t3.setText("");
        }
        else if(e.getSource().equals(c4_b1)){
            DefaultTableModel model = (DefaultTableModel)c4_table.getModel();
            
            String id = model.getValueAt(c4_table.getSelectedRow(), 0).toString();
            String date = c4_t1.getText();
            String time = c4_t2.getText();
            String event = c4_t3.getText();
            if(model.getValueAt(c4_table.getSelectedRow(), 1).toString().equals(c4_t1.getText()) &&
               model.getValueAt(c4_table.getSelectedRow(), 2).toString().equals(c4_t2.getText()) &&
               model.getValueAt(c4_table.getSelectedRow(), 3).toString().equals(c4_t3.getText())){
                return;
            }
            for(int i=0; i<arr.size(); i++){
                if(String.valueOf(arr.get(i).getID()).equals(id)){
                    continue;
                }
                
                if(arr.get(i).getDate().equals(date) && arr.get(i).getTime().equals(time)){
                    JOptionPane.showMessageDialog(null, "You have an appointment");
                    return;
                }
            }
            if(c4_table.getSelectedRowCount() == 1){
                model.setValueAt(date, c4_table.getSelectedRow(), 1);
                model.setValueAt(time, c4_table.getSelectedRow(), 2);
                model.setValueAt(event, c4_table.getSelectedRow(), 3);
            }
            for(int i=0; i<arr.size(); i++){
                if(arr.get(i).getID() == Integer.parseInt(model.getValueAt(c4_table.getSelectedRow(), 0).toString())){
                    arr.get(i).setDate(date);
                    arr.get(i).setTime(time);
                    arr.get(i).setEvent(event);
                    break;
                }
                
            }
        }
        else if(e.getSource().equals(c4_b2)){
            DefaultTableModel model = (DefaultTableModel)c4_table.getModel();
            
            if(c4_table.getSelectedRowCount() == 1){
                for(int i=0; i<arr.size(); i++){
                if(arr.get(i).getID() == Integer.parseInt(model.getValueAt(c4_table.getSelectedRow(), 0).toString())){
                    arr.remove(i);
                    break;
                }
            }
                model.removeRow(c4_table.getSelectedRow());
            }
            else{
                if(c4_table.getRowCount() == 0){
                    JOptionPane.showMessageDialog(null, "Table is Empty");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select Single Row");
                }
            }
            c4_t1.setText("");
            c4_t2.setText("");
            c4_t3.setText("");
        }
        else if(e.getSource().equals(c4_cb)){ //content4 combobox low-high
            if(c4_cb.getSelectedIndex() == 0 || c4_cb.getSelectedIndex() == 1){
                cpy_arr = (ArrayList)arr.clone();
                cpy_arr.sort(new idSorter());
                if(c4_cb.getSelectedIndex() == 1){
                    Collections.reverse(cpy_arr);
                }
            }
            else if(c4_cb.getSelectedIndex() == 2 || c4_cb.getSelectedIndex() == 3){ 
                cpy_arr = (ArrayList)arr.clone();
                cpy_arr.sort(new DateAndTimeSorter());
                if(c4_cb.getSelectedIndex() == 3){
                    Collections.reverse(cpy_arr);
                }
            }
            createTable(cpy_arr);
        }
        else if(e.getSource().equals(c4_b3)){ // content4 export to excel
            JFileChooser fchoose = new JFileChooser();
            int option = fchoose.showSaveDialog(null);
            if(option == JFileChooser.APPROVE_OPTION){
                String name = fchoose.getSelectedFile().getName(); 
                String path = fchoose.getSelectedFile().getParentFile().getPath();
                String file = path + "\\" + name + ".xls"; 
                export(c4_table, new File(file));
           }
        }
        // content3 combobox month
        else if(e.getSource().equals(c3_cb1)){ 
            cpy_arr = (ArrayList)arr.clone();
            CreateCalendar(cpy_arr);
        }
        // content3 combobox year
        else if(e.getSource().equals(c3_cb2)){ 
            cpy_arr = (ArrayList)arr.clone();
            CreateCalendar(cpy_arr);
        }
    }
    
    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(c4_table)){
            DefaultTableModel model = (DefaultTableModel)c4_table.getModel();
            c4_t1.setText(model.getValueAt(c4_table.getSelectedRow(), 1).toString());
            c4_t2.setText(model.getValueAt(c4_table.getSelectedRow(), 2).toString());
            c4_t3.setText(model.getValueAt(c4_table.getSelectedRow(), 3).toString());
        }
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if(e.getSource().equals(b1)){
            b1.setBackground(new Color(153,153,153));
            b1.setIcon(new ImageIcon(this.getClass().getResource("image/addicon_hover.jpg")));
        }
        else if(e.getSource().equals(b2)){
            b2.setBackground(new Color(153,153,153));
            b2.setIcon(new ImageIcon(this.getClass().getResource("image/taskpng_hover.jpg")));
        }
        else if(e.getSource().equals(b3)){
            b3.setBackground(new Color(153,153,153));
            b3.setIcon(new ImageIcon(this.getClass().getResource("image/calendarpng_hover.jpg")));
        }
        else if(e.getSource().equals(b4)){
            b4.setBackground(new Color(153,153,153));
            b4.setIcon(new ImageIcon(this.getClass().getResource("image/tablepng_hover.jpg")));
        }
    }
    public void mouseExited(MouseEvent e) {
        if(e.getSource().equals(b1)){
            b1.setBackground(new Color(35,35,50));
            b1.setIcon(new ImageIcon(this.getClass().getResource("image/addicon1.jpg")));
        }
        else if(e.getSource().equals(b2)){
            b2.setBackground(new Color(35,35,50));
            b2.setIcon(new ImageIcon(this.getClass().getResource("image/taskpng.jpg")));
        }
        else if(e.getSource().equals(b3)){
            b3.setBackground(new Color(35,35,50));
            b3.setIcon(new ImageIcon(this.getClass().getResource("image/calendarpng.jpg")));
        }
        else if(e.getSource().equals(b4)){
            b4.setBackground(new Color(35,35,50));
            b4.setIcon(new ImageIcon(this.getClass().getResource("image/tablepng.jpg")));
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource().equals(c1_t2) && c1_t2.getText().equals("HH:MM")){
            c1_t2.setText("");
            c1_t2.setForeground(Color.white);
        }
        if(e.getSource().equals(((JTextFieldDateEditor)c1_t1.getDateEditor()))){
            ((JTextFieldDateEditor)c1_t1.getDateEditor()).setForeground(Color.white);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource().equals(c1_t2) && c1_t2.getText().isEmpty()){
            c1_t2.setText("HH:MM");
            c1_t2.setForeground(Color.gray);
        }
        if(e.getSource().equals(((JTextFieldDateEditor)c1_t1.getDateEditor()))){
            ((JTextFieldDateEditor)c1_t1.getDateEditor()).setForeground(Color.white);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if(e.getSource().equals(fr)){
            File f = new File("date.data");
            if(f.exists()){
                try(FileInputStream fin = new FileInputStream("date.data"); 
                    ObjectInputStream in = new ObjectInputStream(fin);){
                    arr = (ArrayList<DateEvent>) in.readObject();
                }
                catch(Exception i){
                    System.out.println(i);
                }
            }
        }
    }
    public void windowClosing(WindowEvent e) {
        if(e.getSource().equals(fr)){
            try(FileOutputStream fOut = new FileOutputStream("date.data"); 
                ObjectOutputStream oout = new ObjectOutputStream(fOut);){
                oout.writeObject(arr);
            }
            catch(Exception i){
                System.out.println(i);
            }
        }
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    
    public void changeContent(JPanel panel){
        //remove content
        p3.removeAll();
        p3.repaint();
        p3.revalidate();
        
        //add content
        p3.add(panel);
        p3.repaint();
        p3.revalidate();
    }
    
    public void ListContent(ArrayList<DateEvent> arr){
        c2_p1 = new JPanel();
        c2_sp1.getViewport().add(c2_p1);
        String c2_day = "";
        c2_p1.setLayout(new FlowLayout());
        
        for(int i=0; i<arr.size(); i++){
            int year = Integer.parseInt(arr.get(i).getDate().substring(6));
            int month = Integer.parseInt(arr.get(i).getDate().substring(3,5));
            int day = Integer.parseInt(arr.get(i).getDate().substring(0,2));
            String dayofweek = (LocalDate.of( year , month , day ).getDayOfWeek().toString());
            c2_p2 = new JPanel();
            c2_p3 = new JPanel();
            c2_p4 = new JPanel();
            c2_p5 = new JPanel();
            c2_p6 = new JPanel();
            c2_lb1 = new JLabel(arr.get(i).getDate());
            c2_lb2 = new JLabel(arr.get(i).getEvent());
            c2_lb3 = new JLabel(arr.get(i).getTime());
            
            c2_p2.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 0));
            c2_p3.setLayout(new GridBagLayout());
            c2_p4.setLayout(new GridLayout(1, 3));
            c2_p5.setLayout(new GridBagLayout());
            c2_p6.setLayout(new GridBagLayout());
            
            if(! c2_day.equals(arr.get(i).getDate())){
                c2_p3.add(c2_lb1);
                c2_day = arr.get(i).getDate();
            }
            if(dayofweek.equals("MONDAY")){
                c2_p4.setBackground(new Color(253, 253, 150));
                c2_p5.setBackground(new Color(253, 253, 150));
                c2_p6.setBackground(new Color(253, 253, 150));
            }
            else if(dayofweek.equals("TUESDAY")){
                c2_p4.setBackground(new Color(253, 150, 253));
                c2_p5.setBackground(new Color(253, 150, 253));
                c2_p6.setBackground(new Color(253, 150, 253));
            }
            else if(dayofweek.equals("WEDNESDAY")){
                c2_p4.setBackground(new Color(150, 253, 150));
                c2_p5.setBackground(new Color(150, 253, 150));
                c2_p6.setBackground(new Color(150, 253, 150));
            }
            else if(dayofweek.equals("THURSDAY")){
                c2_p4.setBackground(new Color(253, 202, 150));
                c2_p5.setBackground(new Color(253, 202, 150));
                c2_p6.setBackground(new Color(253, 202, 150));   
            }
            else if(dayofweek.equals("FRIDAY")){
                c2_p4.setBackground(new Color(150, 253, 253));
                c2_p5.setBackground(new Color(150, 253, 253));
                c2_p6.setBackground(new Color(150, 253, 253));    
            }
            else if(dayofweek.equals("SATURDAY")){
                c2_p4.setBackground(new Color(202, 150, 253));
                c2_p5.setBackground(new Color(202, 150, 253));
                c2_p6.setBackground(new Color(202, 150, 253));   
            }
            else if(dayofweek.equals("SUNDAY")){
                c2_p4.setBackground(new Color(253, 150, 150));
                c2_p5.setBackground(new Color(253, 150, 150));
                c2_p6.setBackground(new Color(253, 150, 150));    
            }
            
            c2_lb1.setFont(new Font("Monospaced", Font.BOLD, 18));
            c2_lb2.setFont(new Font("Monospaced", Font.BOLD, 18));
            c2_lb3.setFont(new Font("Monospaced", Font.BOLD, 18));
            c2_p2.setPreferredSize(new Dimension(1040, 77));
            c2_p3.setPreferredSize(new Dimension(200, 70));
            c2_p4.setPreferredSize(new Dimension(700, 70));
            c2_p2.setBackground(new Color(240,255,255));
            c2_p3.setBackground(new Color(240,255,255));
            
            c2_p1.add(c2_p2);
            c2_p2.add(c2_p3);
            c2_p2.add(c2_p4);
            c2_p5.add(c2_lb2);
            c2_p4.add(c2_p5);
            c2_p4.add(new JLabel(""));
            c2_p6.add(c2_lb3);
            c2_p4.add(c2_p6);
        }
        
        c2_sp1.setPreferredSize(new Dimension(1070, 775));
        c2_p1.setPreferredSize(new Dimension(1050, arr.size()*83));
        c2_p1.setBackground(new Color(240,255,255));
        con2.add(c2_sp1);
    }
    
    public void CreateCalendar(ArrayList<DateEvent> arr){
        c3_p1 = new JPanel();
        c3_p2 = new JPanel();
        c3_p3 = new JPanel();
        c3_p4 = new JPanel();
        c3_p5 = new JPanel();
        arr.sort(new DateAndTimeSorter());
        int emp_block = 0;
        int month_num = YearMonth.of(Integer.parseInt(c3_cb2.getSelectedItem().toString()), c3_cb1.getSelectedIndex()+1).lengthOfMonth();
        String firstday = (LocalDate.of( Integer.parseInt(c3_cb2.getSelectedItem().toString()) , c3_cb1.getSelectedIndex()+1 , 1 ).getDayOfWeek().toString());
        
        c3_p1.setLayout(new BorderLayout());
        c3_p2.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
        c3_p3.setLayout(new BorderLayout());
        c3_p4.setLayout(new GridLayout(1, 7));
        c3_p5.setLayout(new GridLayout(6, 7));
        
        if(firstday.equals("MONDAY")){
            emp_block = 0;
        }
        else if(firstday.equals("TUESDAY")){
            emp_block = 1;
        }
        else if(firstday.equals("WEDNESDAY")){
            emp_block = 2;
        }
        else if(firstday.equals("THURSDAY")){
            emp_block = 3; 
        }
        else if(firstday.equals("FRIDAY")){
            emp_block = 4;   
        }
        else if(firstday.equals("SATURDAY")){
            emp_block = 5;  
        }
        else if(firstday.equals("SUNDAY")){
            emp_block = 6;
        }
        
        for(int i=0; i<7; i++){
            c3_p6 = new JPanel();
            c3_p6.setLayout(new GridBagLayout());
            c3_p6.setPreferredSize(new Dimension(0, 40));
            c3_p6.setBorder(BorderFactory.createLineBorder(Color.black));
            c3_p6.add(new JLabel(arr_day[i]));
            if(i == 0){
                c3_p6.setBackground(new Color(253, 253, 150));
            }
            else if(i == 1){
                c3_p6.setBackground(new Color(253, 150, 253));
            }
            else if(i == 2){
                c3_p6.setBackground(new Color(150, 253, 150));
            }
            else if(i == 3){
                c3_p6.setBackground(new Color(253, 202, 150));  
            }
            else if(i == 4){
                c3_p6.setBackground(new Color(150, 253, 253));  
            }
            else if(i == 5){
                c3_p6.setBackground(new Color(202, 150, 253));   
            }
            else if(i == 6){
                c3_p6.setBackground(new Color(253, 150, 150));  
            }
            c3_p4.add(c3_p6);
        }
        
        for(int i=0; i<emp_block; i++){
            c3_p6 = new JPanel();
            c3_p6.setLayout(new GridBagLayout());
            c3_p6.setBackground(new Color(240,255,255));
            c3_p6.add(new JLabel(""));
            c3_p5.add(c3_p6);
        }
        
        for(int i=0; i<month_num; i++){
            c3_p6 = new JPanel();
            c3_p7 = new JPanel();
            c3_ta1 = new JTextArea(5, 6);
            c3_ta1.setEditable(false);
            int status = 0;
            
            for(int j=0; j<arr.size(); j++){
                String year = c3_cb2.getSelectedItem().toString();
                String month = String.valueOf(c3_cb1.getSelectedIndex()+1);
                String day = String.valueOf(i+1);
                if(day.length() == 1){
                    day = "0"+day;
                }
                if(month.length() == 1){
                    month = "0"+month;
                }
                String current_day = day+"/"+month+"/"+year;
                
                if(arr.get(j).getDate().equals(current_day)){
                    c3_ta1.setText(c3_ta1.getText()+" "+arr.get(j).getTime()+" - "+arr.get(j).getEvent()+"\n");
                    status = 1;
                }
                else if(status == 1 && !arr.get(j).getDate().equals(current_day)){
                    break;
                }
            }
            
            c3_p6.setLayout(new BorderLayout());
            c3_p7.setLayout(new GridBagLayout());
            c3_p6.add(c3_p7, BorderLayout.NORTH);
            c3_p6.add(c3_ta1, BorderLayout.CENTER);
            c3_p7.add(new JLabel(String.valueOf(i+1)));
            c3_p6.setBorder(BorderFactory.createLineBorder(Color.black));
            c3_p5.add(c3_p6);
        }
        
        for(int i=0; i<(42-month_num-emp_block); i++){
            c3_p6 = new JPanel();
            c3_p6.setLayout(new GridBagLayout());
            c3_p6.add(new JLabel(""));
            c3_p6.setBackground(new Color(240,255,255));
            c3_p5.add(c3_p6);
        }
        
        c3_sp1.getViewport().add(c3_p1);
        c3_p1.add(c3_p2, BorderLayout.NORTH);
        c3_p2.add(c3_cb1);
        c3_p2.add(c3_cb2);
        c3_p1.add(c3_p3, BorderLayout.CENTER);
        c3_p3.add(c3_p4, BorderLayout.NORTH);
        c3_p3.add(c3_p5, BorderLayout.CENTER);
        
        c3_p1.setPreferredSize(new Dimension(1070, 775));
        c3_cb1.setPreferredSize(new Dimension(200, 30));
        c3_cb2.setPreferredSize(new Dimension(200, 30));
        
        c3_sp1.setBackground(new Color(240,255,255));
        c3_p1.setBackground(new Color(240,255,255));
        c3_p2.setBackground(new Color(240,255,255));
        c3_p3.setBackground(new Color(240,255,255));
        c3_p4.setBackground(new Color(240,255,255));
        c3_p5.setBackground(new Color(240,255,255));
    }
    
    public void createTable(ArrayList<DateEvent> arr){
        String[][] data = new String[arr.size()][4];
            for(int i=0; i<arr.size(); i++){
                data[i][0] = String.valueOf(arr.get(i).getID());
                data[i][1] = arr.get(i).getDate();
                data[i][2] = arr.get(i).getTime();
                data[i][3] = arr.get(i).getEvent();
            }
            String column[]={"ID","DATE","TIME", "EVENT"};
            c4_table = new JTable();
            c4_table.setModel(new DefaultTableModel(data, column));
            c4_table.setBackground(new Color(255, 223, 211));
            c4_table.setDefaultEditor(Object.class, null);
            c4_sp1.getViewport().add(c4_table);
            c4_table.setRowHeight(50);
            c4_sp1.setPreferredSize(new Dimension(1050, 523));
            con4.add(c4_sp1);
            con4.add(c4_p1);
            con4.add(c4_p2);
            c4_t1.setText("");
            c4_t2.setText("");
            c4_t3.setText("");
            c4_table.addMouseListener(this);
    }
    
    public void export(JTable table, File file){
        try
        {
          TableModel m = table.getModel();
          FileWriter fw = new FileWriter(file);
          for(int i = 0; i < m.getColumnCount(); i++){
            fw.write(m.getColumnName(i) + "\t");
          }
          fw.write("\n");
          for(int i=0; i < m.getRowCount(); i++) {
            for(int j=0; j < m.getColumnCount(); j++) {
              fw.write(m.getValueAt(i,j).toString()+"\t");
            }
            fw.write("\n");
          }
          fw.close();
        }
        catch(IOException e){ System.out.println(e); }
  }
}