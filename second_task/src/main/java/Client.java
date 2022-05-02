import java.io.*;
import java.net.Socket;

public class Client {

	private void startConnection(String ip, int port) {

		try (Socket clientSocket = new Socket(ip, port);
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

			String serverWord;
			while ((serverWord = in.readLine()) != null) {
				System.out.println(serverWord);

				String word = reader.readLine();

				if (word.equals(".")) {
					break;
				} else {
					out.println(word);
				}
			}
		} catch (IOException e) {
			System.out.println("Server is closed");
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.startConnection("netology.homework", 8080);
	}
}
