package sucursalBancariaUNAL;

import structures.*;

public class Banco {

	private double[] cuentas;
	private int size;
	private SegmentTree<Double> sumas;
	private SegmentMaxTree<Double> maximos;
	private SegmentMinTree<Double> minimos;

	public Banco(double[] cuentas, int size) {
		super();
		this.cuentas=cuentas;
		this.size=size;
		this.sumas = new SegmentTree<Double>(cuentas, size);
		this.maximos= new SegmentMaxTree<>(cuentas, size);
		this.minimos= new SegmentMinTree<>(cuentas, size);
		//toStringArr();
	}
	
	public void depositar(int nCliente, double deposito) {
		nCliente--;
		double newVal= cuentas[nCliente]+deposito;
		sumas.updateValue(cuentas, size, nCliente, newVal);
		cuentas[nCliente]=newVal;
		maximos.updateValue(cuentas, size, nCliente, newVal);
		minimos.updateValue(cuentas, size, nCliente, newVal);
		//toStringArr();
	}
	
	public void retirar(int nCliente, double retiro) {
		nCliente--;
		double newVal = cuentas[nCliente] - retiro;
		if(newVal>=0) {
			sumas.updateValue(cuentas, size, nCliente, newVal);
			cuentas[nCliente]=newVal;
			maximos.updateValue(cuentas, size, nCliente, newVal);
			minimos.updateValue(cuentas, size, nCliente, newVal);
			//toStringArr();
		}
	}
	
	public void consultar(int i, int j) {
		//System.out.println("El rango de la consulta es: "+i+","+j);
		double promedio= round(sumas.getSum(size, i-1, j-1)/(j-i+1),1);
		//System.out.println("pide suma y promedia");
		double mayor= round(maximos.getMax(size, i-1, j-1),1);
		//System.out.println("pide el mayor");
		double menor= round(minimos.getMin(size, i-1, j-1),1);
		//System.out.println("pide el menor");
		System.out.println(menor+" "+mayor+" "+promedio);
	}
	private double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public void toStringArr() {
		for(double d: cuentas) {
			System.out.print(d+" ");
		}
		System.out.println();
	}
}
