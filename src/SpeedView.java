package src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpeedView extends JFrame implements ModelObserver {
    private String label = "";
    private final JLabel jLabel = new JLabel(label);
    private final JPanel panel = new JPanel();

    public SpeedView() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("SpeedView");
        this.setPreferredSize(new Dimension(70,100));
        this.setLayout(new GridLayout(1,1));

        panel.add(jLabel);
        this.add(panel);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actOnChange(ArrayList<Vehicle> vehicles) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<html>");
        for (Vehicle vehicle : vehicles) {
            stringBuilder.append(vehicle.getModelName()).append(": ").append(vehicle.getCurrentSpeed()).append("<br>");
        }
        stringBuilder.append("</html>");

        jLabel.setText(stringBuilder.toString());
        this.repaint();
    }
}