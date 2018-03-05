package sucursalBancariaUNAL;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			  
			int nClientes = Integer.parseInt(s.next().trim());
			double[] cuentas= new double[nClientes];
			//System.out.println("Hay "+nClientes+" clientes");
			  
			for(int i=0; i<nClientes;i++) {
				cuentas[i]=Double.parseDouble(s.next().trim());
			}
			  
			Banco bancoUNAL = new Banco(cuentas, nClientes);
			  
			int nOperaciones = Integer.parseInt(s.next().trim());
			
			for (int i = 0; i < nOperaciones; i++) {
				String operacion = s.next().trim();
			      
				if(operacion.equals("consultar")) {
					//System.out.println("es una consulta");
					int k= Integer.parseInt(s.next().trim());
					int l= Integer.parseInt(s.next().trim());
					bancoUNAL.consultar(k, l);
				}else if(operacion.equals("retirar")) {
					//System.out.println("es un retiro");
					int clienteIndex= Integer.parseInt(s.next().trim());
					double monto= Double.parseDouble(s.next().trim());
					if(monto>=0) bancoUNAL.retirar(clienteIndex, monto);
				}else if(operacion.equals("depositar")) {
					//System.out.println("es un depósito");
					int clienteIndex= Integer.parseInt(s.next().trim());
					double monto= Double.parseDouble(s.next().trim());
					if(monto>=0) bancoUNAL.depositar(clienteIndex, monto);
				}
			} 
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
