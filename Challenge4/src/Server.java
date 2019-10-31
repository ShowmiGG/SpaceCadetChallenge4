import java.net.*;
import java.io.*;

public class Server {
	
	private int portNumber = 7777;
	private Socket socket;
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}
	
	public void run() {
		try {
			serverSocket = new ServerSocket(portNumber);
			socket = serverSocket.accept();
			System.out.println(socket.getLocalAddress() + " has connected");
			InputStreamReader in = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(in);
			String message = "";
			while (!socket.isClosed()) {
				message = reader.readLine();
				System.out.println(message);
			}
			serverSocket.close();
			socket.close();
			in.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

