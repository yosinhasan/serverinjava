/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import server.Server;

/**
 * @author elpai
 * 
 */
public class Client {

	/**
	 * @param args
	 *            command line arguments
	 * @throws IOException
	 *             io exception
	 */
	public static void main(String[] args) {
		InetAddress addr;
		System.out.println("Client: start");
		try {
			addr = InetAddress.getByName(null);
			try (Socket socket = new Socket(addr, Server.PORT);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream())),
							true);
					Scanner sc = new Scanner(System.in);) {
				System.out.println("addr = " + addr);
				System.out.println("socket = " + socket);
				while (true) {
					System.out.println("type 'end' in order to close a session");
					if (sc.hasNext()) {
						String string = sc.next();
						out.println(string);
						if (string.equals("end")) {
							break;
						}
						String word = in.readLine();
						System.out.println("From server: " + word);
					
					}
				}
				System.out.println("Client: job done.");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} catch (UnknownHostException e1) {
			System.out.println(e1.getMessage());
		}
	}

}
