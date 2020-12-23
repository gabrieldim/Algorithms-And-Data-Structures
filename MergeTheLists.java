import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Here's only the Main class. The classes for the data structure implementation are deleted for author rights!


public class SpecialSLLJoin {
	
	public static void NeizmenichnoSpojuvanje(SLL<Integer> lista1, SLL<Integer> lista2, SLL<Integer> lista3)
	{
		SLLNode<Integer> p=lista1.getFirst();
		SLLNode<Integer> q=lista2.getFirst();
		
		while(p!=null && q!=null)
		{
			if(p!=null)
			{
				lista3.insertLast(p.element);
				p=p.succ;
			}
			if(p!=null)
			{
				lista3.insertLast(p.element);
				p=p.succ;
			}
			
			if(q!=null) {
				lista3.insertLast(q.element);
				q=q.succ;
			}
			if(q!=null)
			{
				lista3.insertLast(q.element);
				q=q.succ;
			}
		}
		
		while(p!=null)
		{
			lista3.insertLast(p.element);
			p=p.succ;
		}
		while(q!=null)
		{
			lista3.insertLast(q.element);
			q=q.succ;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		String [] pom;
		int i,N,broj;
		
		SLL<Integer> lista1=new SLL<Integer>();
		SLL<Integer> lista2=new SLL<Integer>();
		SLL<Integer> lista3=new SLL<Integer>();
		
		s=br.readLine();
		N=Integer.parseInt(s);
		s=br.readLine();
		pom=s.split(" ");
		for(i=0;i<N;i++)
		{
			broj=Integer.parseInt(pom[i]);
			lista1.insertLast(broj);
		}
		s=br.readLine();
		N=Integer.parseInt(s);
		s=br.readLine();
		pom=s.split(" ");
		for(i=0;i<N;i++)
		{
			broj=Integer.parseInt(pom[i]);
			lista2.insertLast(broj);
		}
		NeizmenichnoSpojuvanje(lista1,lista2,lista3);
		System.out.println(lista3);
		
	}	
}
