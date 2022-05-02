import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private void startConnection(String ip, int port) {

		try (Socket clientSocket = new Socket(ip, port);
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

			System.out.println("Write your name: ");
			String name = reader.readLine();

			out.println(name);

			String serverWord = in.readLine();

			System.out.println(serverWord);

		} catch (IOException e) {
			System.out.println("Server is closed");
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.startConnection("localhost", 8080);
	}
}
