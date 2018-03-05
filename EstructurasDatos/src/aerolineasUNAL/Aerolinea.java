package aerolineasUNAL;

import java.util.Scanner;

import structures.LinkedList;
import structures.List;
import structures.MaxPriorityQueue;

public class Aerolinea {

	class Arco {
		int nodo_fin;
		int peso;

		public Arco(int nodo_fin, int peso) {
			this.nodo_fin = nodo_fin;
			this.peso = peso;
		}
	}

	class Grafo {
		int numero_nodos;
		LinkedList<Arco>[] arcos;

		@SuppressWarnings("unchecked")
		public Grafo(int numero_nodos) {

			this.numero_nodos = numero_nodos;
			arcos = new LinkedList[numero_nodos];

			for (int i = 0; i < numero_nodos; i++) {
				arcos[i] = new LinkedList<Arco>();
			}
		}

		public void agregarArco(int nodo_inicio, int nodo_fin, int peso) {
			arcos[nodo_inicio].insertLast(new Arco(nodo_fin, peso));
		}

		public List<Arco> adyacentes(int nodo_inicio) {
			return arcos[nodo_inicio];
		}
	}

	static class Par implements Comparable<Par> {
		int nodo;
		int prioridad;

		Par(int nodo, int prioridad) {

			this.nodo = nodo;
			this.prioridad = prioridad;
		}

		public int compareTo(Par p) {

			if (prioridad < p.prioridad)
				return -1;
			if (prioridad > p.prioridad)
				return +1;
			return 0;
		}
	}

	static class Dijkstra {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		static int[] caminoMasCorto(Grafo g, int inicio) {

			MaxPriorityQueue<Par> pq = new MaxPriorityQueue();
			int[] distancias = new int[g.numero_nodos];

			for (int i = 0; i < g.numero_nodos; i++) {
				distancias[i] = -1;
			}
			distancias[inicio] = 0;
			pq.insert(new Par(inicio, 0));

			while (!pq.isEmpty()) {
				Par p = pq.findMax();

				if (p.prioridad > distancias[p.nodo]) {
					continue;
				}

				for (int k = 0; k < g.numero_nodos; k++) {
					Arco arco = g.adyacentes(p.nodo).find(k);
					if (distancias[arco.nodo_fin] > distancias[p.nodo] + arco.peso) {
						distancias[arco.nodo_fin] = distancias[p.nodo] + arco.peso;
						pq.insert(new Par(arco.nodo_fin, distancias[arco.nodo_fin]));
					}
				}
			}
			return distancias;
		}
	}

	class HashTable {

		private int numPrimo;
		private String[] data;
		private int size;

		public HashTable() {
			super();
			this.numPrimo = 100109;
			this.data = new String[numPrimo];
			this.size = 0;
		}

		public int getNumPrimo() {
			return this.numPrimo;
		}

		public void setNumPrimo(int numPrimo) {
			this.numPrimo = numPrimo;
		}

		public String[] getData() {
			return data;
		}

		public void setData(String[] data) {
			this.data = data;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public String[] doubleHash(String string) {
			return hash(0, string);
		}

		private String[] hash(int attempts, String string) {
			int hash = fHash(string);
			int initHash = hash;
			do {
				if (data[hash] != null) {
					if (string.equals(data[hash])) {
						String[] ans = new String[2];
						ans[0] = hash + "";
						ans[1] = "YaExiste";
						return ans;
					} else
						hash = (initHash + attempts * attempts) % numPrimo;
					attempts++;
				}
			} while (data[hash] != null);
			String[] ans = new String[2];
			ans[0] = hash + "";
			ans[1] = string;
			return ans;
		}

		private int fHash(String string) {
			int intVal = 0;
			for (int i = 0; i < string.length(); i++) {
				char letra = string.charAt(i);
				intVal += (int) letra;
			}
			return (intVal) % numPrimo;
		}

		/*
		 * public void rehash() { setNumPrimo(nextOdd()); String[] newArray = new
		 * String[this.numPrimo]; for(int i=0; i<this.size;i++) { String[] v
		 * =doubleHash(this.users[i]); newArray[Integer.parseInt(v[1])]=v[2]; }
		 * setUsers(newArray); }
		 */

		public String[] insert(String string) {
			// if(this.size==this.users.length)rehash();
			String[] v = doubleHash(string);
			if (v[1].equals("YaExiste"))
				return v;
			data[Integer.parseInt(v[0])] = v[1];
			setSize(this.size + 1);
			return v;
		}

		public int search(String string) {
			return search(0, string);
		}

		private int search(int attempts, String string) {
			int hash = fHash(string);
			int initHash = hash;
			do {
				if (data[hash] != null) {
					if (string.equals(data[hash])) {
						return hash;
					} else
						hash = (initHash + attempts * attempts) % numPrimo;
					attempts++;
				}
			} while (data[hash] != null);
			return -1;
		}
	}

	int size;
	Grafo grafo;
	HashTable ciudades = new HashTable();

	public Aerolinea(int length) {
		super();
		this.size = 0;
		this.grafo = new Grafo(length);
	}

	public static void main(String[] args) {
		// FUNCION MAIN
		// try {
		Scanner s = new Scanner(System.in);
		int N = Integer.parseInt(s.nextLine().trim());
		Aerolinea aerolinea = new Aerolinea(100109);

		for (int i = 0; i < N; i++) {
			String linea = s.nextLine().trim();
			Scanner sc = new Scanner(linea);
			String cInicio = sc.next().trim();
			String cFinal = sc.next().trim();
			sc.close();

			String vCInicio = aerolinea.ciudades.insert(cInicio)[0];
			String vCFinal = aerolinea.ciudades.insert(cFinal)[0];
			aerolinea.grafo.agregarArco(Integer.parseInt(vCInicio), Integer.parseInt(vCFinal), 1);
		}

		int Q = Integer.parseInt(s.nextLine().trim());
		for (int i = 0; i < Q; i++) {
			String linea = s.nextLine().trim();
			Scanner sc = new Scanner(linea);
			String cInicio = sc.next().trim();
			String cFinal = sc.next().trim();
			sc.close();

			int hCInicio = aerolinea.ciudades.search(cInicio);
			int hCFinal = aerolinea.ciudades.search(cFinal);
			if (hCInicio != -1 && hCFinal != -1) {
				int[] distancias = Dijkstra.caminoMasCorto(aerolinea.grafo, hCInicio);
				int distancia = distancias[hCFinal];
				if (distancia == -1)
					System.out.println("No hay rutas de " + cInicio + " a " + cFinal);
				else
					System.out
							.println("De " + cInicio + " a " + cFinal + " se puede llegar en " + distancia + " vuelo");
			} else
				System.out.println("No hay rutas de " + cInicio + " a " + cFinal);
		}
		s.close();
		/*
		 * } catch (Exception e) {
		 * 
		 * }
		 */

	}

}
