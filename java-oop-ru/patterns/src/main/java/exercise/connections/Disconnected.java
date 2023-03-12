package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private final TcpConnection tcpConnection;
    private final String NAME = "disconnected";

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        TcpConnection tcp = this.tcpConnection;
        tcp.setState(new Connected(tcp));
        System.out.println("Connections was established!");
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection is already broken!");
    }

    @Override
    public void write(String data) {
        System.out.println("Error! First you need to establish a connection!");
    }

    @Override
    public String toString() {
        return NAME;
    }
}
// END
