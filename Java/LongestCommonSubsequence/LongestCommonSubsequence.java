import java.util.ArrayList;
import java.io.*;
public class MessageDecoding
{
    public static void main (String[] args) throws IOException
    {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null)
        {
            line = line.trim();
            ProcessMessage(line.split(";"));
        }
    }
   
    private static void ProcessMessage(String[] messageSplit)
    {
        StringBuilder decodedMessage = new StringBuilder();
        char[] firstString = messageSplit[0].toCharArray();
        char[] secondString = messageSplit[1].toCharArray();
        Node root = new Node(null, 0, 0, null);
        
        root.children = getMatchingList(firstString, secondString, root);
        
        System.out.println(decodedMessage.toString());
    }

    private static Node processLists(Node parent, char[] firstString, char[] secondString)
    {
        parent.children = getChildren();

        
    }

    private static ArrayList<Node> getChildren(Node parent, char[] firstString, char[] secondString)
    {
        ArrayList<Node> matchingList = new ArrayList();
        for(int i = parent.firstPosition; i < firstString.length; i++)
        {
            for(int j = parent.secondPosition; j < secondString.length; j++)
            {
                if(firstString[i] == secondString[j])
                {
                    matchingList.add(new Node(firstString[i], i, j, parent))
                }
            }
        }

        return matchingList;
    }

    public class Node
    {
        public char letter;
        public int firstPosition;
        public int secondPosition;
        public Node parent;
        public ArrayList<Node> children;

        public Node(char letter, int firstPosition, int secondPosition, Node parent)
        {
            this.letter = letter;
            this.firstPosition = firstPosition;
            this.secondPosition = secondPosition;
            this.parent = parent;
        }
    }
}