import java.io.*;
import java.util.*;

class a4
{
	public static void main(String[] args) 
	{
				String r = "";
				try
		{
		BufferedReader br = new BufferedReader(new FileReader("data/recA.txt"));
			String s;
			while((s = br.readLine())!=null)
			{
				//System.out.println(s);
				r = r+s;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		System.out.println(r);	
	}
}