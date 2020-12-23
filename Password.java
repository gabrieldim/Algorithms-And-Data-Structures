import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
//Here's only the Main class. The classes for the data structure implementation are deleted for author rights!

 
public class Lozinki {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        CBHT<String,String> server = new CBHT<String,String>(N);
        for(int i=0;i<N;i++)
        {
            String imeLozinka=br.readLine();
            String parts[] =  imeLozinka.split(" ");
            server.insert(parts[0],parts[1]);
        }
        String line=br.readLine();
        while(!line.equals("KRAJ"))
        {
            String parts[] = line.split(" ");
            if(server.search(parts[0])!=null)
            {
                SLLNode<MapEntry<String,String>> eli = server.search(parts[0]);
                if(eli.element.value.equals(parts[1]))
                {
                    System.out.println("Najaven");
                    break;
                }
                else
                    System.out.println("Nenajaven");
            }
                else
                    System.out.println("Nenajaven");
            line=br.readLine();
        }
 
    }
 
}
