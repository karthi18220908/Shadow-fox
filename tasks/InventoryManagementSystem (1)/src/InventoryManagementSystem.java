import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementSystem extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameInput, quantityInput, priceInput;

    public InventoryManagementSystem() {
        setTitle("Inventory Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table setup
        model = new DefaultTableModel(new String[]{"Item Name", "Quantity", "Price"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Input fields
        nameInput = new JTextField(10);
        quantityInput = new JTextField(5);
        priceInput = new JTextField(5);

        // Buttons
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        // Button actions
        addButton.addActionListener(e -> addItem());
        updateButton.addActionListener(e -> updateItem());
        deleteButton.addActionListener(e -> deleteItem());

        // Layout setup
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Item Name:"));
        inputPanel.add(nameInput);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityInput);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceInput);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    // Methods for adding, updating, and deleting items
    private void addItem() {
        String name = nameInput.getText();
        String quantity = quantityInput.getText();
        String price = priceInput.getText();
        if (!name.isEmpty() && !quantity.isEmpty() && !price.isEmpty()) {
            model.addRow(new Object[]{name, Integer.parseInt(quantity), Double.parseDouble(price)});
            clearInputs();
        }
    }

    private void updateItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.setValueAt(nameInput.getText(), selectedRow, 0);
            model.setValueAt(Integer.parseInt(quantityInput.getText()), selectedRow, 1);
            model.setValueAt(Double.parseDouble(priceInput.getText()), selectedRow, 2);
            clearInputs();
        }
    }

    private void deleteItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        }
    }

    private void clearInputs() {
        nameInput.setText("");
        quantityInput.setText("");
        priceInput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManagementSystem ims = new InventoryManagementSystem();
            ims.setVisible(true);
        });
    }
}
