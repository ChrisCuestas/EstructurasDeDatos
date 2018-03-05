package computadorDañado;

import structures.*;

import java.util.Scanner;


public class TestClass {
    @SuppressWarnings({ "unused", "resource" })
	public static void main(String args[] ) throws Exception {
        
    	ArrayBasedList<Integer> arrayA=  new ArrayBasedList<Integer>(0);
    	LinkedList<Integer> arrayL= new LinkedList<Integer>();
    	
        Scanner s = new Scanner(System.in);
        String line;
        
        while (s.hasNextLine() && !( line = s.nextLine() ).equals( "" )){
			DoubleQueue<String> texto 	= new DoubleQueue<String>();
			Stack<Character> ubic	= new Stack<Character>();
			String token = "";
			Scanner sl = new Scanner(line);
			/*while(sl.hasNextByte()) {//
				char ch = (char)sl.nextByte();
				if(ch == '#' || ch == '$') {
					if(ubic.peek()!=null) {
						if(ubic.peek()=='#') texto.enqueueFront(token);
						else texto.enqueueBack(token);
					}
					else texto.enqueueBack(token);
					token="";
					ubic.push(ch);
				}else {
					token=token+ch;
				}
			}
			sl.close();*/
			for(char ch : line.toCharArray()) {
				if(ch == '#' || ch == '$') {
					if(ubic.peek()!=null) {
						if(ubic.peek()=='#') texto.enqueueFront(token);
						else texto.enqueueBack(token);
					}
					else texto.enqueueBack(token);
					token="";
					ubic.push(ch);
				}else {
					token=token+ch;
				}
			}
			
			//Esto se hace para garantizar que se incluyó en la cola el ultimo token si en no se
			//encuentra ningún '#' o '$'. si lo hay, añade a la cola un token "" al final.
			if(ubic.peek()!=null) {
				if(ubic.peek()=='#') texto.enqueueFront(token);
				else texto.enqueueBack(token);
			}
			else texto.enqueueBack(token);
			token="";
			//Mientras que haya algo en la cola, desencola hasta desocupar la cola e imprime cada token 
			//desde el front hasta el back.
			while(texto.getSize()>0){
				System.out.print(texto.dequeueFront());
			}
			System.out.print("\n");//Finaliza cada linea con un fin de linea.
			
        }
        
        s.close();
    }
}