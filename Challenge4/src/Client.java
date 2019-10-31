import java.net.*;
import java.io.*;



public class Client {
	
	private int portNumber = 7777;
	private String name = "Bob";
	
	public static void main(String[] args) {
		Client client = new Client();
		client.run();
	}
	
	@SuppressWarnings("deprecation")
	public void run() {
		try {
			Socket socket = new Socket("localhost", portNumber);
			InputStreamReader in = new InputStreamReader(System.in);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(in);
			String message = "";
			while (!message.equalsIgnoreCase("end")) {
				message = reader.readLine();
				out.writeUTF("[" + name + "]" + " "+ message + "\n");
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
