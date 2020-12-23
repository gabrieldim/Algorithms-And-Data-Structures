import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

//Here's only the Main class. The classes for the data structure implementation are deleted for author rights!

 
public class StackBukvi {
	
	public static int Funkcija(LinkedStack<Character> obj)
	{
		
		int flag=0;
		int izbrojaniT=0;
		int brojach=0;
		
	while(!obj.isEmpty())
	{
		if(obj.peek()=='T')
		{
			obj.pop();
			brojach++;
		}else if(obj.peek()=='S'){
			obj.pop();
				if(flag==0)
				{
					flag=1;
					izbrojaniT=brojach;
					brojach=0;
				}else {
					if(izbrojaniT!=brojach)
					{
						return 0;
					}
				}
			brojach=0;
		}
		
	}
		
	return 1;
	}
	
	public static void main(String[] args) throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String s;
	int i;
	s=br.readLine();
	LinkedStack<Character> obj=new LinkedStack<Character>();
	
	
	for(i=0;i<s.length();i++)
	{
		if(s.charAt(i)=='S' || s.charAt(i)=='T')
		{
			obj.push(s.charAt(i));
		}
	}
	
	
	int a=Funkcija(obj);
	System.out.println(a);
	}
}

