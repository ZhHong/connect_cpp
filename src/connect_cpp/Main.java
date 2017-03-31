package connect_cpp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
	public static void main(String args[]){
		try {
			Socket socket = new Socket("127.0.0.1",8888);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			pw.write("1000");
			pw.write(" ");
			pw.write("100000");
			pw.flush();
			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info = bf.readLine())!= null){
				System.out.println("server say......."+info);
				
			}
			bf.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
