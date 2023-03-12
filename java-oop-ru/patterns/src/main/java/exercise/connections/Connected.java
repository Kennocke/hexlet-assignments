package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private final TcpConnection tcpConnection;
    private final String NAME = "connected";

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection already established!");
    }

    @Override
    public void disconnect() {
        TcpConnection tcp = this.tcpConnection;
        tcp.setState(new Disconnected(tcp));
        System.out.println("Connection lost!");
    }

    @Override
    public void write(String data) {
        this.tcpConnection.addToBuffer(data);
        System.out.println("Data was written!");
    }

    @Override
    public String toString() {
        return NAME;
    }
}
// END
