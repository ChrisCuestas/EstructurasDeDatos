package salaDeChatUN;

import java.util.Scanner;

public class SalaChat {
	
	private int  numPrimo;
	private String[] users;
	private int size;
	
	public SalaChat() {
		super();
		this.numPrimo= 11113;
		this.users = new String[numPrimo];
		this.size = 0;
	}

	public int getNumPrimo() {
		return this.numPrimo;
	}

	public  void setNumPrimo(int numPrimo) {
		this.numPrimo = numPrimo;
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	public String[] doubleHash(String nickname) {
		return hash(0, nickname);
	}

	private String[] hash(int attempts, String nickname) {
		int numRep=0;
		int hash=fHash(nickname);
		int initHash=hash;
		String firstNickname=nickname;
		do {
			if(users[hash]!=null) {
				if(nickname.equals(users[hash])) {
					numRep++;
					nickname=firstNickname+numRep;
					hash=fHash(nickname);
				}else hash=(initHash+attempts*attempts)%numPrimo;
				attempts++;
			} 
		}while(users[hash]!=null);
		String[] ans =new String[3];
		ans[0]=numRep+"";
		ans[1]=hash+"";
		ans[2]=nickname;
		return ans;
	}
	
	private int fHash(String nickname) {
		int intVal=0;
		for(int i=0;i<nickname.length();i++) {
			char letra = nickname.charAt(i);
			intVal+=(int)letra;
		}
		return (intVal)%numPrimo;
	}
	
	/*private int nextOdd() {
		return this.numPrimo*10 + 1;
	}
	
	/*public void rehash() {
		setNumPrimo(nextOdd());
		String[] newArray = new String[this.numPrimo];
		for(int i=0; i<this.size;i++) {
			String[] v =doubleHash(this.users[i]);
			newArray[Integer.parseInt(v[1])]=v[2];
		}
		setUsers(newArray);
	}*/
	
	public String insert(String nickname) {
		//if(this.size==this.users.length)rehash();
		String[] v =doubleHash(nickname);
		users[Integer.parseInt(v[1])]=v[2];
		setSize(this.size+1);
		if(Integer.parseInt(v[0])==0) return "OK";
		else return v[2];
	}

	public static void main(String args[]) {
		// FUNCION MAIN
			  //try {
				  Scanner s = new Scanner(System.in);
				  while(s.hasNextInt()) {
					  int N = Integer.parseInt(s.nextLine().trim());
				      SalaChat sala= new SalaChat();
					  for (int i = 0; i <N; i++) {
				          String nickname = s.nextLine().trim();
				          System.out.println(sala.insert(nickname));
				      }
				  }
			      s.close();
			/*} catch (Exception e) {
				
			}*/
	      
	  }

}
