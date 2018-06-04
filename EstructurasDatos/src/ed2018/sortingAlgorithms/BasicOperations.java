package ed2018.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BasicOperations {

	
	/**
	 * 
	 * @param array
	 */
	public void printArray(int[] array)
	{
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		
		try
		{
			for(int i = 0; i < array.length - 1; i++)
				bw.write(array[i] + ",");
			
			bw.write(array[array.length - 1] + "\n");
			bw.flush();
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public int sum(int[] array)
	{
		int acum = 0;
		
		for(int i = 0; i < array.length; i++)
			acum += array[i];
		
		return acum;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public double average(int[] array)
	{
		return sum(array) / (double)array.length;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public int min(int[] array)
	{
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] < min)
				min = array[i];
			
		return min;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public int max(int[] array)
	{
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] > max)
				max = array[i];
			
		return max;
	}
	
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public int indexOf(int[] array, int value)
	{
		int index = -1;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] == value)
			{
				index = i;
				break;
			}
		
		return index;
	}
	
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public int occurrencesOf(int[] array, int value)
	{
		int counter = 0;
		
		for(int i = 0; i < array.length; i++)
			if(array[i] == value)
				counter += 1;
		
		return counter; 
	}
	
	
	/**
	 * 
	 * @param array
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public int[] subarray(int[] array, int beginIndex, int endIndex)
	{
		int[] sub = null;
		
		if(beginIndex < endIndex && endIndex < array.length)
		{
			sub = new int[endIndex - beginIndex];
			for(int i = 0; i < (endIndex - beginIndex); i++)
				sub[i] = array[beginIndex + i];
		}
		
			
		return sub;
	}
	
	
	/**
	 * 
	 * @param array
	 * @param oldNumber
	 * @param newNumber
	 */
	public void replace(int[] array, int oldNumber, int newNumber)
	{
		for(int i = 0; i < array.length; i++)
			if(array[i] == oldNumber)
				array[i] = newNumber;
	}
	
	public int[] readArrayFromFile(String pathFile)
	{
		try
		{
			FileReader fr = new FileReader(pathFile);
			BufferedReader br = new BufferedReader( fr );
			
			String[] numbers = br.readLine().split(",");
			int[] arrayNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++)
				arrayNumbers[i] = Integer.parseInt( numbers[i] );
			
			br.close();
			
			return arrayNumbers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public int[] readArrayFronConsole()
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		
		try
		{
			String[] numbers = br.readLine().split(",");
			int[] arrayNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++)
				arrayNumbers[i] = Integer.parseInt( numbers[i] );
			
			return arrayNumbers;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return null;
	}
}
