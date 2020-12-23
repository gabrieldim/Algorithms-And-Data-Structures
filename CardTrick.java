
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

//Here's only the Main class. The classes for the data structure implementation are deleted for author rights!

public class card_trick {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		s=br.readLine();
		int N=Integer.parseInt(s);
		int i=0;
		int counter=0;
		
		LinkedQueue<Integer> spil=new LinkedQueue<Integer>();
		for(i=1;i<=51;i++)
		{
		spil.enqueue(i);	
		}
		
		int vrv=spil.peek();
		LinkedStack<Integer> obj=new LinkedStack<Integer>();
		while(vrv!=N)
		{
			for(i=0;i<7;i++) {
			obj.push(spil.dequeue());
			}
			for(i=0;i<7;i++)
			{
				spil.enqueue(obj.pop());
				spil.enqueue(spil.dequeue());
			}
			vrv=spil.peek();
			counter++;
		}

	System.out.println(counter);	
	
	}
	

}
