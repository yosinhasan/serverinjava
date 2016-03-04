/**
 * 
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author elpai
 * 
 */
public class Server {
	/**
	 * Port.
	 */
	public static final int PORT = 8080;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		System.out.println("Server: start");
		try (ServerSocket s = new ServerSocket(PORT);
				Socket socket = s.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);) {
			System.out.println("Started: " + s);
			System.out.println("Connection accepted: " + socket);
			while (true) {
				String str = in.readLine();
				if (str.equals("end")) {
					break;
				}
				System.out.println("Echoing: " + str);
				out.println(str);
			}
			System.out.println("Server: job done.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
