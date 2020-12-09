package src;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private ArrayList<Vehicle> vehicles;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
    }

    public void updateVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : vehicles)
            g.drawImage(v.vehicleImage, (int) v.getXcor(), (int) v.getyCor(), null); // see javadoc for more info on the parameters
    }
}
