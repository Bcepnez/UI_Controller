import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class Drone_Map {

	private JFrame frame;
	private JTextField txtHello;
	private JTextField txtDroneinfo;
	private JTextField txtCurrentzposition;
	private JTextField txtDistancefromsurface;
	private JTextField txtAngle;
	private JLabel label;
	private JPanel panel;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;

	/**
	 * Launch the application.
	 */
	private String dir = System.getProperty("user.dir");
	private JToggleButton tglbtnConnectToUav;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drone_Map window = new Drone_Map();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Drone_Map() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 563);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		label = new JLabel("");
		label.setBackground(Color.WHITE);
		txtHello = new JTextField();
		txtHello.setEditable(false);
		txtHello.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtHello.setText("Disconnect from UAV");
		txtHello.setBounds(12, 13, 280, 50);
		txtHello.setBackground(Color.red);
		frame.getContentPane().add(txtHello);
		txtHello.setColumns(10);
		
		JButton button = new JButton("Start Flight");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon imgico = new ImageIcon(dir+"\\noey.jpg");
				imgico.getImage().flush();
				label.setIcon(imgico);
			}
		});
		button.setBounds(12, 420, 280, 83);
		frame.getContentPane().add(button);
		
		JToggleButton PatternFlightMode = new JToggleButton("Flight Mode : Pattern");
		PatternFlightMode.setEnabled(false);
		PatternFlightMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(PatternFlightMode.isSelected()){
					txtHello.setText("Pattern control");
					radioButton.setEnabled(true);
					radioButton_1.setEnabled(true);
					PatternFlightMode.setText("Flight Mode : Mannual");
				}
				else{
					txtHello.setText("Mannual control");
					radioButton.setEnabled(false);
					radioButton_1.setEnabled(false);
					PatternFlightMode.setText("Flight Mode : Pattern");
				}
				txtHello.setBackground(Color.cyan);
			}
		});
		PatternFlightMode.setBounds(12, 149, 280, 60);
		frame.getContentPane().add(PatternFlightMode);
		
		JLabel lblDroneInfo = new JLabel("Drone Info :");
		lblDroneInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDroneInfo.setBounds(12, 276, 108, 30);
		frame.getContentPane().add(lblDroneInfo);
		
		JLabel lblCurrentPosition = new JLabel("Current position :");
		lblCurrentPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentPosition.setBounds(12, 311, 108, 30);
		frame.getContentPane().add(lblCurrentPosition);
		
		JLabel lblDistance = new JLabel("Distance :");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDistance.setBounds(12, 344, 108, 30);
		frame.getContentPane().add(lblDistance);
		
		JLabel lblAngle = new JLabel("Angle :");
		lblAngle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAngle.setBounds(12, 377, 108, 30);
		frame.getContentPane().add(lblAngle);
		
		txtDroneinfo = new JTextField();
		txtDroneinfo.setEditable(false);
		txtDroneinfo.setText("Drone_info");
		txtDroneinfo.setBounds(127, 277, 165, 29);
		frame.getContentPane().add(txtDroneinfo);
		txtDroneinfo.setColumns(10);
		
		txtCurrentzposition = new JTextField();
		txtCurrentzposition.setEditable(false);
		txtCurrentzposition.setText("Current_Z_position");
		txtCurrentzposition.setColumns(10);
		txtCurrentzposition.setBounds(127, 311, 165, 29);
		frame.getContentPane().add(txtCurrentzposition);
		
		txtDistancefromsurface = new JTextField();
		txtDistancefromsurface.setEditable(false);
		txtDistancefromsurface.setText("DistanceFromSurface");
		txtDistancefromsurface.setColumns(10);
		txtDistancefromsurface.setBounds(127, 344, 165, 29);
		frame.getContentPane().add(txtDistancefromsurface);
		
		txtAngle = new JTextField();
		txtAngle.setEditable(false);
		txtAngle.setText("Angle");
		txtAngle.setColumns(10);
		txtAngle.setBounds(127, 377, 165, 29);
		frame.getContentPane().add(txtAngle);
		
		
		label.setBounds(304, 13, 561, 490);
		frame.getContentPane().add(label);
		
		panel = new JPanel();
		panel.setBounds(12, 222, 280, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		radioButton = new JRadioButton("Bottom Down");
		radioButton.setEnabled(false);
		radioButton.setBounds(29, 9, 105, 25);
		panel.add(radioButton);
		
		radioButton_1 = new JRadioButton("Rising Up");
		radioButton_1.setEnabled(false);
		radioButton_1.setBounds(165, 9, 81, 25);
		panel.add(radioButton_1);
		
		tglbtnConnectToUav = new JToggleButton("Connect to UAV");
		tglbtnConnectToUav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnConnectToUav.isSelected()){
					txtHello.setText("Connected to UAV");
					txtHello.setBackground(Color.green);
					PatternFlightMode.setEnabled(true);
					button.setEnabled(true);
					tglbtnConnectToUav.setText("Disconnect from UAV");
				}
				else{
					txtHello.setText("Disconnected to UAV");
					txtHello.setBackground(Color.red);
					radioButton.setEnabled(false);
					radioButton_1.setEnabled(false);
					PatternFlightMode.setEnabled(false);
					button.setEnabled(false);
					tglbtnConnectToUav.setText("Connect to UAV");
				}
			}
		});
		tglbtnConnectToUav.setBounds(12, 76, 280, 60);
		frame.getContentPane().add(tglbtnConnectToUav);
	}
}
