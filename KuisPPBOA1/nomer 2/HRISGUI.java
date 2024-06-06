import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HRISGUI extends JFrame {
    private JPanel inputPanel;
    private JPanel showPanel;
    private JTextField nameField;
    private JTextField dateOfBirthField;
    private JComboBox<String> positionComboBox;
    private JComboBox<String> departmentComboBox;
    private JButton addEmployeeButton;
    private JButton showDataButton;
    private JButton backButton;
    private JButton filterButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;
    private List<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        inputPanel = createInputPanel();
        showPanel = createShowPanel();

        add(inputPanel);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel inputFormPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Name:");
        inputFormPanel.add(nameLabel, gbc);

        gbc.gridy++;
        JLabel dateOfBirthLabel = new JLabel("Date of Birth (DDMMYYYY):");
        inputFormPanel.add(dateOfBirthLabel, gbc);

        gbc.gridy++;
        JLabel departmentLabel = new JLabel("Department:");
        inputFormPanel.add(departmentLabel, gbc);

        gbc.gridy++;
        JLabel positionLabel = new JLabel("Position:");
        inputFormPanel.add(positionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        nameField = new JTextField(15);
        inputFormPanel.add(nameField, gbc);

        gbc.gridy++;
        dateOfBirthField = new JTextField(15);
        inputFormPanel.add(dateOfBirthField, gbc);

        gbc.gridy++;
        String[] departments = {"Product", "HR"};
        departmentComboBox = new JComboBox<>(departments);
        inputFormPanel.add(departmentComboBox, gbc);

        gbc.gridy++;
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);
        inputFormPanel.add(positionComboBox, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.0;
        gbc.weightx = 0.0;
        gbc.insets = new Insets(10, 5, 5, 5);

        addEmployeeButton = new JButton("Add Employee");
        inputFormPanel.add(addEmployeeButton, gbc);

        gbc.gridy++;
        showDataButton = new JButton("Show Data");
        inputFormPanel.add(showDataButton, gbc);

        panel.add(inputFormPanel, BorderLayout.CENTER);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        showDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });

        return panel;
    }

    private JPanel createShowPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel filterPanel = new JPanel(new FlowLayout());
        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"All", "Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = {"All", "Product", "HR"};
        departmentComboBox = new JComboBox<>(departments);

        filterButton = new JButton("Filter");
        backButton = new JButton("Back");

        filterPanel.add(positionLabel);
        filterPanel.add(positionComboBox);
        filterPanel.add(departmentLabel);
        filterPanel.add(departmentComboBox);
        filterPanel.add(filterButton);
        filterPanel.add(backButton);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Department");
        tableModel.addColumn("Date of Birth");
        tableModel.addColumn("Position");
        tableModel.addColumn("Salary");

        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        panel.add(filterPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterData();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backToInput();
            }
        });

        return panel;
    }

    private void addEmployee() {
        String name = nameField.getText();
        String dateOfBirth = dateOfBirthField.getText(); // Mendapatkan tanggal lahir langsung dari input
        String department = departmentComboBox.getSelectedItem().toString();
        String position = positionComboBox.getSelectedItem().toString();

        Employee employee = null;
        switch (position) {
            case "Manager":
                employee = new Manager(name, department, dateOfBirth);
                break;
            case "Developer":
                employee = new Developer(name, department, dateOfBirth);
                break;
            case "HR Staff":
                employee = new HRStaff(name, department, dateOfBirth);
                break;
        }

        if (employee != null) {
            employees.add(employee);
            JOptionPane.showMessageDialog(this, "Employee added: " + employee);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add employee.");
        }
    }


    private void showData() {
        tableModel.setRowCount(0); // Clear table
        for (Employee employee : employees) {
            displayEmployee(employee);
        }
        remove(inputPanel);
        add(showPanel);
        revalidate();
        repaint();
    }

    private void backToInput() {
        remove(showPanel);
        add(inputPanel);
        revalidate();
        repaint();
    }

    private void displayEmployee(Employee employee) {
        Object[] rowData = {employee.id, employee.name, employee.department, employee.dateOfBirth, employee.getClass().getSimpleName(), employee.salary};
        tableModel.addRow(rowData);
    }

    private void filterData() {
        String selectedPosition = positionComboBox.getSelectedItem().toString();
        String selectedDepartment = departmentComboBox.getSelectedItem().toString();

        DefaultTableModel model = (DefaultTableModel) dataTable.getModel();
        model.setRowCount(0); // Clear table

        for (Employee employee : employees) {
            if ((selectedPosition.equals("All") || employee.getClass().getSimpleName().equals(selectedPosition)) &&
                    (selectedDepartment.equals("All") || employee.department.equals(selectedDepartment))) {
                displayEmployee(employee);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI().setVisible(true);
            }
        });
    }
}
