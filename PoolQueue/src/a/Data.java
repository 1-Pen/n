package a;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Data extends JPanel {

	private JTextField txtName;
    private JComboBox<String> cbHours;
    private JComboBox<String> cbGuests;
    private Page main;

    public Data(CardLayout layout, JPanel container, Page main) {
        this.main = main;
        setLayout(null);
        
        JLabel lblTitle = new JLabel("Fill in the form");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(130, 30, 200, 30);
        add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(50, 100, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(100, 100, 200, 30);
        add(txtName);

        JLabel lblHour = new JLabel("Hour:");
        lblHour.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHour.setBounds(50, 130, 100, 30);
        add(lblHour);

        String[] hourOptions = {"1", "2", "3", "4", "5", "6"};
        cbHours = new JComboBox<>(hourOptions);
        cbHours.setBounds(100, 130, 200, 30);
        add(cbHours);

        JLabel lblGuests = new JLabel("People:");
        lblGuests.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblGuests.setBounds(50, 160, 100, 30);
        add(lblGuests);

        String[] guestOptions = {"1", "2", "3", "4", "5", "6+"};
        cbGuests = new JComboBox<>(guestOptions);
        cbGuests.setBounds(100, 160, 200, 30);
        add(cbGuests);

        JButton btnBack = new JButton("back");
        btnBack.setBounds(10, 10, 80, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                layout.show(container, "TableSelection"); 
            }
        });
        add(btnBack);

        JButton btnConfirm = new JButton("Enter");
        btnConfirm.setBounds(100, 200, 200, 40);
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(txtName.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(Data.this, "Please fill everything in form", "Alert", JOptionPane.WARNING_MESSAGE);
                } else {
                	layout.show(container, "Payment");

                    String name = txtName.getText();
                    String hour = (String) cbHours.getSelectedItem();
                    String guests = (String) cbGuests.getSelectedItem();
                    
                    System.out.println("--- information ---");
                    System.out.println("name: " + name);
                    System.out.println("Hour: " + hour);
                    System.out.println("Person: " + guests);
                }
            }
        });
        add(btnConfirm);
    }
}
