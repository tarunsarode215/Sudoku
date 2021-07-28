import java.net.*; 
import java.io.*; 
class client {
    public static void main(String[] args) throws Exception {
        try
        { 
            Socket socket = new Socket("192.168.42.129",6666); 
            System.out.println("Connected"); 
			
            DataInputStream input  = new DataInputStream(System.in); 
			DataInputStream in = new DataInputStream(
			new BufferedInputStream(socket.getInputStream())); 
			DataOutputStream out    = new DataOutputStream(socket.getOutputStream()); 
            String line = "";
			while (!line.equals("Over")) 
            {
				line = input.readLine();
                out.writeUTF(line);
				line = in.readUTF(); 
                System.out.println(line);
			} 
			System.out.println("Disconnected");
            input.close(); 
            out.close(); 
            socket.close(); 			
        } 
        catch(Exception e) 
        { 
            System.out.println(e); 
        }     
    }
}
