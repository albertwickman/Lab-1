package src;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.event.ChangeListener;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JPanel {
    // member fields:

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Turbo> turbos = new ArrayList<>();
    ArrayList<Ramp> ramps = new ArrayList<>();
    final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    final Timer timer = new Timer(delay, new CarController.TimerListener());
    private final int x;
    private final int y;

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton turnRightButton = new JButton("Turn Right");
    JButton turnLeftButton = new JButton("Turn Left");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public CarController(String frameName, int x, int y) {
        this.frame = new CarView(frameName);
        this.x = x;
        this.y = y;
    }


    //methods:

    public void initComponent() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        this.setLayout(new GridLayout(2,4));

        this.add(gasButton, 0);
        this.add(turboOnButton, 1);
        this.add(liftBedButton, 2);
        this.add(brakeButton, 3);
        this.add(turboOffButton, 4);
        this.add(lowerBedButton, 5);
        this.setPreferredSize(new Dimension((X/2)+4, 200));
        this.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

        turnLeftButton.setBackground(Color.yellow);
        turnLeftButton.setForeground(Color.red);
        turnLeftButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(turnLeftButton);

        turnRightButton.setBackground(Color.yellow);
        turnRightButton.setForeground(Color.red);
        turnRightButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(turnRightButton);
    }

    public void addTurbo(Turbo t) {
        turbos.add(t);
    }

    public void addRamp(Ramp r) {
        ramps.add(r);
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        frame.addVehicle(v);
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                checkBoundaries(vehicle);
                int x = (int) Math.round(vehicle.getXcor());
                int y = (int) Math.round(vehicle.getyCor());
                // repaint() calls the paintComponent method of the panel
                frame.repaintVehicles();
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(brake);
        }
    }

    /*
    **BUG**
    Starts all engines even if ramp is lowered.
     */
    public void startEngines() {
        for (Vehicle v : vehicles) {
            v.startEngine();
        }
    }

    public void stopEngines() {
        for (Vehicle v : vehicles) {
            v.stopEngine();
        }
    }

    private void checkBoundaries(Vehicle v) {
        if (isOnEdge(v))
            invertDirection(v);
    }

    private void invertDirection(Vehicle v) {
        v.setDx(-1 * v.getDx());
        v.setDy(-1 * v.getDy());
    }

    private boolean isOnEdge(Vehicle v) {
        return v.getXcor() > frame.getX() - 100 || v.getXcor() < 0 || v.getyCor() < 0 || v.getyCor() > frame.getY() - 300;
    }

    public void setTurboOn() {
        for (Turbo t : turbos) {
            t.setTurboOn();
        }
    }

    public void setTurboOff() {
        for (Turbo t : turbos) {
            t.setTurboOff();
        }
    }

    public void raiseRamp() {
        for (Ramp r : ramps) {
            r.setAngle(0);
        }
    }

    public void lowerRamp() {
        for (Ramp r : ramps) {
            r.setAngle(70);
        }
    }

    public void turnRight() {
        for (Vehicle v : vehicles) {
            v.turnRight();
        }
    }

    public void turnLeft() {
        for (Vehicle v : vehicles) {
            v.turnLeft();
        }
    }

    // This actionListener is for the gas button only
        gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.gas(gasAmount);
        }
    });
        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.brake(gasAmount);
        }
    });

        turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.setTurboOn();
        }
    });

        turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.setTurboOff();
        }
    });

        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.startEngines();
        }
    });

        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.stopEngines();
        }
    });

        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.raiseRamp();
        }
    });

        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.lowerRamp();
        }
    });

        turnRightButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.turnRight();
        }
    });

        turnLeftButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            carC.turnLeft();
        }
    });
}
