package ed2018.strings;

import ed2018.LinkedList;

import java.io.*;

public class StringAsList {

	private LinkedList<StringNode> string = new LinkedList<StringNode>();
	
	public StringAsList(){
		super();
	}

	public StringAsList(char[] string_){
		super();
		for(int i = 0; i < string_.length; i++)
			string.insertFirst(new StringNode(string_[i]));
	}
	
	public void concatenate(StringAsList newString){
		string.insert(newString.string.getHead().getElement());
	}
	
	public StringAsList[] split(StringAsList regex){
		StringAsList[] response = null;
		//TODO:
		return response; 
	}
	
	public boolean contains(StringAsList regex){
		//TODO:
		return false;
	}
	
	public StringAsList substring(int beginIndex){
		StringAsList subString = new StringAsList();
		subString = this.sublist(beginIndex);
		return subString;
	}
	
	private StringAsList sublist(int beginIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private StringAsList sublist(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public StringAsList substring(int beginIndex, int endIndex){
		StringAsList subString = new StringAsList();
		subString = this.sublist(beginIndex, endIndex);
		return subString;
	}

	public int indexOf(StringNode regex){
		return string.firstIndexOf(regex); 
	}
	
	public boolean equals(StringAsList string_){
		return this.string.equals( string_.string );
	}
	
	public int length(){
		return this.string.getSize();
	}
	
	public StringAsList reverse(){
		StringAsList reverse = new StringAsList();
		reverse.string = string.cloneList();
		reverse.string.reverse();

		return reverse;
	}
	
	public boolean isPalindrome(){
		//TODO:
		return false;
	}
	
	public boolean isAnagram(StringAsList anagramCandidate){
		//TODO:
		return false;
	}
	
	
	public void print(){
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringNode temp = (StringNode)string.getHead().getElement();
			
		try 
		{
			while(temp != null)
			{
				bw.write(temp.character);
				temp = (StringNode)temp.getNext();
			}
			bw.flush();
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
}