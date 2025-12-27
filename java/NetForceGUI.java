import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NetForceGUI {

    public static void main(String[] args) {

        Frame frame = new Frame("NetForce (Offline + Network Recovery)");
        frame.setSize(420, 160);
        frame.setLayout(null);
        frame.setResizable(false);

        Label status = new Label("Ready. Offline work is available.");
        status.setBounds(40, 50, 340, 20);

        Button startButton = new Button("Start Offline + Network Recovery");
        startButton.setBounds(60, 90, 300, 30);

        startButton.addActionListener(e -> {
            status.setText("Running...");
            new Thread(() -> {
                NetForceApp.main(new String[0]);
                status.setText("Process launched safely.");
                System.exit(0);
            }).start();
        });

        frame.add(status);
        frame.add(startButton);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}

