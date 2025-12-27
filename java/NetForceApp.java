import java.io.IOException;

public class NetForceApp {

    static void runProcess(String cmd) {
        try {
            new ProcessBuilder("/bin/sh", "-c", cmd)
                    .inheritIO()
                    .start();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {

        runProcess("python3 ../python/offline_worker.py");

        runProcess("../cpp/net_core");

        runProcess("../rust/net_watch");

        System.out.println("Running offline + network recovery safely.");
    }
}

