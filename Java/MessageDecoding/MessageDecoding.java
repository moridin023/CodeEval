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
            ProcessMessage(SplitMessage(line));
        }
    }
   
    private static void ProcessMessage(String[] messageSplit)
    {
        StringBuilder decodedMessage = new StringBuilder();
        char[] header = messageSplit[0].toCharArray();
        String message = messageSplit[1];
        int index = 0;
        int messageLength = 0;
        
        while((messageLength = Integer.parseInt(message.substring(index, index+3), 2)) != 0)
        {
            // Increase the index past the length of the first set of numbers
            index += 3;
            String encodedDigit;

            while(!(encodedDigit = message.substring(index, index+messageLength)).equals(printOnes(messageLength)))
            {
                // Increase the index past the read in encoded digit
                index += messageLength;

                int headerPosition = (int)Math.pow(2, messageLength) - (messageLength + 1) + Integer.parseInt(encodedDigit, 2);
                decodedMessage.append(header[headerPosition]);
            }

            // Move the index past the last read in encoded digit
            index += messageLength;
        }

        System.out.println(decodedMessage.toString());
    }

    private static String printOnes(int num)
    {
        String ones = "";

        for(int i = num; i > 0; i--)
        {
            ones = ones + "1";
        }

        return ones;
    }

    private static String[] SplitMessage(String line)
    {
        char[] fullMessage = line.toCharArray();
        String[] splitMessage = new String[2];
        int index;

        for(index = fullMessage.length - 1; index >= 0; index--)
        {
            if(fullMessage[index] != '0' && fullMessage[index] != '1')
            {
                // Add one to the index because substring is exclusive for the last digit
                index += 1;
                break;
            }
        }

        splitMessage[0] = line.substring(0, index);
        splitMessage[1] = line.substring(index);

        return splitMessage;
    }
}