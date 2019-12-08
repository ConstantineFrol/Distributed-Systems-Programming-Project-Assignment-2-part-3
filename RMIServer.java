import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.*;

public class RMIServer {

	public static void main(String a[]){

		try {
			Processor process = new Processor();
			Naming.rebind("Create_Thing",process);
			System.out.println("Server Started");
			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
