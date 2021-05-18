package Common.Options;


public class ServerOptions {
    private int port;
    private String name;

    public ServerOptions(int port, String name) {
        this.name = name;
        this.port = port;
    }

    public ServerOptions() {
        port = 0;
        name = "";
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }
}
