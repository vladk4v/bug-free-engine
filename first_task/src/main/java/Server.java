import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private void start(int port) {

		try (ServerSocket serverSocket = new ServerSocket(port);
			 Socket clientSocket = serverSocket.accept();
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

			System.out.println("New connection accepted");

			final String inputLine = in.readLine();

			out.println(String.format("Hi, %s, your port is %d", inputLine, clientSocket.getPort()));

			System.out.println("Server closed");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		int port = 8080;
		server.start(port);
	}
}
