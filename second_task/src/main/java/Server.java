import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private void start(int port) {

		try (ServerSocket serverSocket = new ServerSocket(port);
			 Socket clientSocket = serverSocket.accept();
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

			out.println("Write your name: ");

			String name;
			while ((name = in.readLine()).equals("")) {
				out.println("Write your name");
			}
			System.out.println(name);

			out.println("Are you child? (yes/no)");
			String inputLine;
			while ((inputLine = in.readLine()).equals("")) {
				out.println("Are you child? (yes/no)");
			}
			System.out.println(inputLine);

			if (inputLine.equals("yes")) {
				out.printf("Welcome to the kids area, %s, lets play \n", name);
			} else if (inputLine.equals("no")) {
				out.printf("Welcome to the adult area, %s, have a good rest \n", name);
			} else {
				out.println("You did something wrong");
			}

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
