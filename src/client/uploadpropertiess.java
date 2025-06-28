package client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class uploadpropertiess extends JFrame {
    public JFileChooser fileChooser;
    public File selectedFile;
    private Connection conn;
    private static String  titlevalu =null;
    public JButton chooseButton, postButton;
    private JTextField priceTextField, squareMeterTextField, titleTextField;
    private JComboBox<String> locationComboBox, addressComboBox, conditionComboBox;
    private JTextArea descriptionTextArea;
    private JSpinner bathroomsSpinner, bedroomsSpinner;

    public uploadpropertiess() {
        JFrame proform = new JFrame();
        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        titleLabel.setBounds(38, 97, 85, 16);
        JLabel imageLabel = new JLabel("Select an image");
        imageLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        imageLabel.setBounds(38, 135, 175, 21);
        JLabel locationLabel = new JLabel("Property location");
        locationLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        locationLabel.setBounds(38, 172, 175, 21);
        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        addressLabel.setBounds(42, 209, 91, 21);
        JLabel squareMeterLabel = new JLabel("Square meter");
        squareMeterLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        squareMeterLabel.setBounds(38, 284, 145, 21);
        JLabel conditionLabel = new JLabel("Condition");
        conditionLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        conditionLabel.setBounds(38, 248, 107, 21);
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        descriptionLabel.setBounds(50, 373, 121, 21);
        JLabel bathroomsLabel = new JLabel("Bathrooms");
        bathroomsLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        bathroomsLabel.setBounds(441, 97, 121, 16);
        JLabel bedroomsLabel = new JLabel("Bedrooms");
        bedroomsLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        bedroomsLabel.setBounds(441, 135, 121, 16);
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 17));
        priceLabel.setBounds(441, 172, 121, 16);
        priceTextField = new JTextField();
        priceTextField.setBounds(603, 171, 78, 24);
        squareMeterTextField = new JTextField();
        squareMeterTextField.setBounds(219, 283, 107, 24);
        descriptionTextArea = new JTextArea(4, 1);
        descriptionTextArea.setPreferredSize(new Dimension(10, 60));
        descriptionTextArea.setLineWrap(false);
        descriptionTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        descriptionTextArea.setBounds(215, 349, 308, 91);
        String[] location = {"Addis Ababa",
        "Dire Dawa",
        "Gondar",
        "Bahir Dar",
        "Mekelle",
        "Jimma",
        "Hawassa",
        "Arba Minch",  "Harar",  "Awasa", "Dessie","Adama", "Hosaena", "Nekemte","Shashamane","Jijiga", "Debre Markos", "Dila", "Gambela", "Asosa" };
        String[] condition = { "New", "Old", "Fairly used" };
        locationComboBox = new JComboBox<>(location);
        locationComboBox.setBounds(219, 171, 150, 24);
        addressComboBox = new JComboBox<>(location);
        addressComboBox.setBounds(219, 208, 150, 24);
        conditionComboBox = new JComboBox<>(condition);
        conditionComboBox.setBounds(219, 247, 150, 24);
        chooseButton = new JButton("Choose File");
        chooseButton.setBounds(219, 134, 150, 24);
        bathroomsSpinner = new JSpinner();
        bathroomsSpinner.setBounds(603, 96, 78, 24);
        bedroomsSpinner = new JSpinner();
        bedroomsSpinner.setBounds(603, 134, 78, 24);
        titleTextField = new JTextField();
        titleTextField.setBounds(219, 96, 150, 24);
        postButton = new JButton("Update");
        postButton.setFont(new Font("Arial", Font.BOLD, 13));
        postButton.setBounds(566, 439, 107, 24);
        proform.setSize(800, 600);
        proform.setBackground(Color.LIGHT_GRAY);
        proform.setLayout(null);
        proform.add(titleLabel);
        proform.add(imageLabel);
        proform.add(locationLabel);
        proform.add(addressLabel);
        proform.add(squareMeterLabel);
        proform.add(conditionLabel);
        proform.add(descriptionLabel);
        proform.add(bathroomsLabel);
        proform.add(bedroomsLabel);
        proform.add(priceLabel);
        proform.add(priceTextField);
        proform.add(squareMeterTextField);
        proform.add(descriptionTextArea);
        proform.add(locationComboBox);
        proform.add(addressComboBox);
        proform.add(conditionComboBox);
        proform.add(chooseButton);
        proform.add(bathroomsSpinner);
        proform.add(bedroomsSpinner);
        proform.add(titleTextField);
        proform.add(postButton);
        proform.setVisible(true);
         postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertPropertys(titlevalu);
            }

        });
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image_uploder();
            }
        });
    }
public void  value(String val){
titlevalu =val;
}
    private void image_uploder() {
        fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            chooseButton.setText("File Selected ");
        } else {
            chooseButton.setText("No File Selected");
        }
    }

    public void insertPropertys(String  usr_id) {
        String title = titleTextField.getText();
        File imageFile = selectedFile;
        String locationpro = (String) locationComboBox.getSelectedItem();
        String addre = (String) addressComboBox.getSelectedItem();
        String squarem = squareMeterTextField.getText();
        String condition = (String) conditionComboBox.getSelectedItem();
        String description = descriptionTextArea.getText();
        int bathroom = (int) bathroomsSpinner.getValue();
        int bedroom = (int) bedroomsSpinner.getValue();
        String price = priceTextField.getText();
        try {
            initializeDatabase();
            // Check for empty or invalid inputs
            if (title.isEmpty() || locationpro.isEmpty() || condition.isEmpty() || addre.isEmpty()
                    || imageFile == null || bathroom <= 0 || squarem.isEmpty() || description.length() < 7) {
                JOptionPane.showMessageDialog(this, "Please fill the form correctly.");
            } else {
                // Prepare the SQL statement
                String sql = "UPDATE realpropforseller SET " +
                "title = ?, " +
                "image = ?, " +
                "location = ?, " +
                "address = ?, " +
                "square_meter = ?, " +
                "conditionn = ?, " +
                "description = ?, " +
                "bathrooms = ?, " +
                "bedrooms = ?, " +
                "price = ? " +
                "WHERE title = '"+usr_id+"'";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);
          
                preparedStatement.setString(1, title);
                FileInputStream fis = new FileInputStream(imageFile);
                preparedStatement.setBinaryStream(2, fis, (int) imageFile.length());
                preparedStatement.setString(3, locationpro);
                preparedStatement.setString(4, addre);
                preparedStatement.setString(5, squarem);
                preparedStatement.setString(6, condition);
                preparedStatement.setString(7, description);
                preparedStatement.setInt(8, bathroom);
                preparedStatement.setInt(9, bedroom);
                preparedStatement.setString(10, price);

                int rowsInserted = preparedStatement.executeUpdate();
                fis.close(); // Close the FileInputStream

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Updated successfully.");
                 dispose();
                    titleTextField.setText("");
                    // Set other fields as needed
                    locationComboBox.setSelectedIndex(0);
                    // Clear other fields
                } else {
                    JOptionPane.showMessageDialog(this, "update failed.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: update insertion failed.");
        }
         dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            uploadpropertiess form = new uploadpropertiess();
            form.setVisible(true);
        });
       
    }
      private void initializeDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate", "root", "");
            conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}