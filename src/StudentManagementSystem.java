import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Student {
    String id;
    String name;
    int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class StudentManagementSystem extends JFrame {
    private JTextField tfId, tfName, tfAge;
    private JButton btnAdd, btnDelete;
    private JTable table;
    private DefaultTableModel model;
    private ArrayList<Student> students = new ArrayList<>();

    public StudentManagementSystem() {
        setTitle("Quản Lý Học Sinh");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       

        // Panel nhập thông tin
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin học sinh"));

        inputPanel.add(new JLabel("Mã học sinh:"));
        tfId = new JTextField();
        inputPanel.add(tfId);

        inputPanel.add(new JLabel("Họ tên:"));
        tfName = new JTextField();
        inputPanel.add(tfName);

        inputPanel.add(new JLabel("Tuổi:"));
        tfAge = new JTextField();
        inputPanel.add(tfAge);

        btnAdd = new JButton("Thêm");
        btnDelete = new JButton("Xoá");
        inputPanel.add(btnAdd);
        inputPanel.add(btnDelete);

        // Bảng hiển thị danh sách học sinh
        model = new DefaultTableModel(new Object[]{"Mã", "Họ tên", "Tuổi"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        loadFromFile();

        // Gộp layout chính
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Sự kiện nút thêm
        btnAdd.addActionListener(e -> addStudent());
       
        btnDelete.addActionListener(e -> deleteStudent());
        
    }

    private void addStudent() {
        String id = tfId.getText().trim();
        String name = tfName.getText().trim();
        int age;
        try {
            age = Integer.parseInt(tfAge.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tuổi phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        students.add(new Student(id, name, age));
        model.addRow(new Object[]{id, name, age});
        saveToFile();
        clearFields();
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            students.remove(selectedRow);
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn học sinh cần xoá!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        saveToFile();
        
    }

    private void clearFields() {
        tfId.setText("");
        tfName.setText("");
        tfAge.setText("");
    }
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.csv"))) {
            for (Student s : students) {
                writer.println(s.id + "," + s.name + "," + s.age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Gọi khi chương trình khởi động
private void loadFromFile() {
    File file = new File("students.csv");
    if (!file.exists()) return;

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống

            String[] parts = line.split(",", -1); // giữ cả phần trống
            if (parts.length == 3) {
                String id = parts[0].trim();
                String name = parts[1].trim();
                String ageStr = parts[2].trim();

                try {
                    int age = Integer.parseInt(ageStr);
                    Student s = new Student(id, name, age);
                    students.add(s);
                    model.addRow(new Object[]{id, name, age});
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi đọc tuổi từ dòng: " + line);
                }
            } else {
                System.err.println("Dòng không hợp lệ: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem().setVisible(true));
    }
}