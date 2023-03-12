package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection{
    private String ip;
    private final int port;
    private List<String> buffer;
    private Connection state;

    public void setState(Connection state) {
        this.state = state;
    }

    public Connection getState() {
        return state;
    }

    public String getCurrentState() {
        return state.toString();
    }

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.buffer = new ArrayList<>();
        setState(new Disconnected(this));
    }

    @Override
    public void connect() {
        getState().connect();
    }

    @Override
    public void disconnect() {
        getState().disconnect();
    }

    @Override
    public void write(String data) {
        getState().write(data);
    }

    public void addToBuffer(String data) {
        buffer.add(data);
    }
}
// END
