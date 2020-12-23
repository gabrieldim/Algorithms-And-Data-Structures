import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Here's only the Main class. The classes for the data structure implementation are deleted for author rights!

public class WindowsExplorer {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i = 0; i < N; i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");

        // vasiot kod stoi ovde
        String[] temp;
        String command;
        String namee;
        SLLNode<String> opened = tree.root;
        for (i = 0; i < N; i++) {
            temp = commands[i].split(" ");
            command = temp[0];
            if (temp.length == 2) {
            	
                namee = temp[1];
                
                SLLNode<String> jazol = new SLLNode<String>(namee);
                
                if (command.equals("CREATE")) {
                    SLLNode<String> ttemp = opened.firstChild;
                    SLLNode<String> ttemposen = opened.firstChild;
                    int counter = 0;
                    while (ttemp != null) {
                        if (namee.compareTo(ttemp.element) > 0) 
                        {
                            counter++;
                            ttemposen = ttemp;
                        }
                        
                        ttemp = ttemp.sibling;
                    }
                    
                    if (counter == 0)
                    {   
                    			tree.addChild(opened, namee);
                    }
                    else 
                    {
                        SLLNode<String> nov = new SLLNode<String>(namee);
                        nov.sibling = ttemposen.sibling;
                        ttemposen.sibling = nov;
                        nov.parent = opened;
                    }
                    
                } 
                else if (command.equals("OPEN"))
                {
                    SLLNode<String> ttemp = opened.firstChild;
                    while (ttemp != null) 
                    {
                        if (ttemp.element.compareTo(namee) == 0)
                            opened = ttemp;
                        ttemp = ttemp.sibling;
                    }
                }
                else if (command.equals("DELETE"))
                
                {
                
                	SLLNode<String> ttemp = opened.firstChild;
                    while (ttemp != null)
                    {
                        if (ttemp.element.equals(namee)) {
                            tree.remove(ttemp);
                            break;
                        }
                        ttemp = ttemp.sibling;
                    }
                }
            }
            else
            {
                if (command.equals("BACK"))
                {       opened = opened.parent;
            }
                
                else if (command.equals("PATH")) {
                    SLLNode<String> ttemp = opened;
                    String s = "\\";
                    while (ttemp != tree.root) {
                        s = ttemp.element + s;
                        s = "\\" + s;
                        ttemp = ttemp.parent;
                    }
                    System.out.print(tree.root.element);
                    System.out.println(s);
                } else if (command.equals("PRINT"))
                    tree.printTree();
                else 
                	{
                	return;
                	
                	}
            }
        }
    }
}

