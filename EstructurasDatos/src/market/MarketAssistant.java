package market;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ed2018.ArraybasedList;

public class MarketAssistant {

	private String[] productNames;
	private ArraybasedList<Float> prices;
	
	public MarketAssistant(int n) {
		this.productNames = new String[n];
		this.prices = new ArraybasedList<Float>(n);
	}
	
	public void addProduct(String name, float price) {
		this.productNames[this.prices.getSize()] = name;
		this.prices.insert(price);
	}
	
	public float getCost(String name, int quantity) {
		for(int i=0; i<this.productNames.length;i++) {
			if(this.productNames[i].equals(name)) return (this.prices.get(i)*quantity);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		MarketAssistant ma;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int trips = Integer.parseInt(br.readLine());
			for(int t=0; t<trips; t++) {
				int availableProducts = Integer.parseInt(br.readLine());
				ma = new MarketAssistant(availableProducts);
				for(int ap=0; ap<availableProducts; ap++) {
					String[] line = br.readLine().split(" ");
					ma.addProduct(line[0], Float.parseFloat(line[1]));
				}
				int products = Integer.parseInt(br.readLine());
				float total = 0;
				for(int pn=0; pn<products; pn++) {
					String[] line = br.readLine().split(" ");
					total += ma.getCost(line[0], Integer.parseInt(line[1]));
				}
				bw.write("R$ " + String.format("%.2f",total) + "\n");
				bw.flush();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}