import java.net.InetAddress;
import net.wimpi.modbus.*;
import net.wimpi.modbus.msg.*;
import net.wimpi.modbus.io.*;
import net.wimpi.modbus.net.*;
import net.wimpi.modbus.procimg.Register;
import net.wimpi.modbus.procimg.SimpleRegister;


public class BackEnd 
{
	
	public static void Write() throws Exception 
	{
		String refe = "1"; // HEX Address
		String refe1 = "1=2"; // HEX Address
        int ref = Integer.parseInt(refe, 16); // Hex to int
        
		InetAddress ip = InetAddress.getByName("192.168.0.2");
	    TCPMasterConnection connection = new TCPMasterConnection(ip);
	    connection.setPort(502);
	    connection.connect();
	    
	    Register reg = new SimpleRegister(2);
	    WriteMultipleRegistersRequest request = new WriteMultipleRegistersRequest(ref, new Register[]{reg});
	    executeTransaction(connection, request);

	}
	
	private static ModbusResponse executeTransaction(TCPMasterConnection connection, ModbusRequest request) throws ModbusIOException, ModbusSlaveException, ModbusException 
	{
	   ModbusTCPTransaction transaction = new ModbusTCPTransaction(connection);
	   transaction.setRequest(request);
	   transaction.execute();
	   return transaction.getResponse();
	}
	
	
	public static void Read() throws Exception 
	{
		String refe = "1";// HEX Address to read
        int ref = Integer.parseInt(refe, 16);// Hex to int
		int count = 1;
		
		InetAddress ip = InetAddress.getByName("192.168.0.2");
		TCPMasterConnection connection = new TCPMasterConnection(ip);
		connection.setPort(502);
		connection.connect();
		
		ReadMultipleRegistersRequest request = new ReadMultipleRegistersRequest(ref, count); //FC3
		ReadMultipleRegistersResponse response = new ReadMultipleRegistersResponse();
	
		ModbusTCPTransaction transaction = new ModbusTCPTransaction(connection);
		
		transaction.setRetries(5);
		transaction.setReconnecting(true);
		transaction.setRequest(request);
		transaction.execute();
		
		response = (ReadMultipleRegistersResponse) transaction.getResponse();
		
	    System.out.println("Nuskaityta reiksme: " + response.getRegisterValue(ref)); 
			
	}	
		
}
	
	
	

	
	
	
	



