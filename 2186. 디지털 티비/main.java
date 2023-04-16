import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int kbs1_idx=0;
		int kbs2_idx=0;
		String res="";
		String[] tv=new String[n];
		
		for(int i=0; i<n; i++)
		{
			String str=br.readLine();
			tv[i]=str;
			if(str.equals("KBS1"))
				kbs1_idx=i;
			if(str.equals("KBS2"))
				kbs2_idx=i;
		}
		
		if(kbs1_idx < kbs2_idx)
		{
			for(int i=0; i<kbs1_idx; i++)
				res+="1";
			for(int i=0; i<kbs1_idx; i++)
				res+="4";
			for(int i=0; i<kbs2_idx; i++)
				res+="1";
			for(int i=0; i<kbs2_idx-1; i++)
				res+="4";
		}
        
		else if(kbs1_idx > kbs2_idx)
		{
			for(int i=0; i<kbs1_idx; i++)
				res+="1";
			for(int i=0; i<kbs1_idx; i++)
				res+="4";
			for(int i=0; i<kbs2_idx+1; i++)
				res+="1";
			for(int i=0; i<kbs2_idx; i++)
				res+="4";
		}
        
		System.out.println(res);
	}
	
}
