package GetExcel_Data;

import java.util.LinkedHashSet;

public class interviewProg {
	
	public static void main (String [] args )
	{
		
		//Prime Number
		
		int num = 9;

		int count = 0;
		
		for(int i = 1; i<=num; i++ )
		{
			if(num%i==0)
			{
				count++;
			}
		}
		if(count==2)
		{
			System.out.println(num +" = Number is prime");
		}
		else
		{
			System.out.println(num +" = Number is not prime");

		}
		
		
		//Reverse Number
		
		int number = 12321;
		int orgnumber = number;
		int rev = 0;
		
		while(number>0)
		{
			int rem = number % 10;
			rev = rev * 10 + rem;
			number = number / 10;
			
		}
		
		if(orgnumber == rev)
		{
			System.out.println(rev + " = Number is palindrome");
		}
		else
		{
			System.out.println(rev + " = Number is not palindrome");
		}
		
		//Addition of numbers
		
		int add = 12345;
		int addition = 0;
		
		while(add>0)
		{
			int rem = add % 10;
			addition = addition + rem;
			add = add / 10;
			
		}
		
		System.out.println(addition);

		// Ascending Order
		
		int asc [] = {1, 4, 7, 3, 5};
		
		for(int i = 0; i<=asc.length-1; i++)
		{
			for(int j = i+1; j<=asc.length-1; j++)
			{
				if(asc[i] > asc[j])
				{
					int swap = asc[i];
					asc[i] = asc[j];
					asc[j] = swap;
				}
			}
		}
		
		for( int asce : asc)
		{
			System.out.print(asce + " ");
		}
		
		System.out.println();

		
		// Find Duplicate
		
		int dup [] = {10, 20, 40, 30, 40, 20, 10, 10};
		
		for (int i = 0; i<=dup.length-1; i++)
		{
			for(int j = i+1; j<=dup.length-1; j++)
			{
				if(dup[i] == dup[j])
				{
					System.out.print("Duplicates values " + dup[i] + " ");
				}
			}
		}
		
		System.out.println();

		// Maximum Number
		
		int max [] = {10, 20, 40, 30, 50, 99};
		int maxn = 0;
		
		for(int i = 0; i<=max.length-1; i++)
		{
			if(max[i] > maxn)
			{
				maxn = max[i];
			}
		}
		System.out.println(maxn);

		//Missing Number
		
		int mis [] = {1, 3, 4, 5, 10};
		
		for(int i = 0; i<mis.length-1; i++)
		{
			if(!(mis[i]+1 == mis[i+1]))
			{
				System.out.println(mis[i]+1);
			}
		}
		
		//Remove Duplicate
		
		int rdup [] = {10, 20, 20, 40, 40, 10, 50};
		
		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
		
		for(int i = 0; i<=rdup.length-1; i++)
		{
			hs.add(rdup[i]);
		}
		System.out.println(hs);
		
		//Reverse Strings
		
		String s ="Hello";
		
		for(int i = s.length()-1; i>=0; i--)
		{
			System.out.print(s.charAt(i));
		}
		
		System.out.println();

		
		String s1 = "This is String";
		
		String splitvalue [] = s1.split(" ");
		
		for(int i = splitvalue.length-1; i>=0; i--)
		{
			System.out.println(splitvalue[i]);
		}
		
		System.out.println();

		String s3 = "This is String";
		
		String splitv [] = s3.split(" ");
		
		for( String reverse : splitv)
		{
			for(int i = reverse.length()-1; i>=0; i--)
			{
				System.out.print(reverse.charAt(i));
			}
			System.out.print(" ");

		}
		
		System.out.println(" ");

		//Reoccurrance of character
		
		String reoc = "rsdrdrsd";
		int count1 = 0;
		int count2 = 0;
		
		for(int i = 0; i<=reoc.length()-1; i++)
		{
			if(reoc.charAt(i) == 'r')
			{
				count1 = count1 + 1;
			}
			else if(reoc.charAt(i) == 's')
			{
				count2 = count2 + 1;

			}
		}
		System.out.println(count1 + " " + count2);

		
		//Remove Alphabets
		
		String s4 = "qwe123qwe123";
		String num4 = "";
		
		for(int i = 0; i<=s4.length()-1; i++)
		{
			if(Character.isDigit(s4.charAt(i)))
			{
				num4 = num4 + s4.charAt(i);
			}
		}
		
		System.out.println(num4);

		//Remove Numbers
		
		String s5 = "qwe123qwe123";
		String num5 = "";
		
		for(int i = 0; i<=s5.length()-1; i++)
		{
			if(Character.isAlphabetic(s5.charAt(i)))
			{
				num5 = num5 + s5.charAt(i);
			}
		}
		
		System.out.println(num5);

		//Addition of numbers
		
		String s6 = "qwe123qwe123";
		String num6 ="";
		int temp6 = 0;
		
		for(int i = 0; i<=s6.length()-1; i++)
		{
			if(Character.isDigit(s6.charAt(i)))
			{
				num6 = num6 + s6.charAt(i);
				int intvalue = Integer.parseInt(num6);
				temp6 = temp6 + intvalue;
				num6="";
			}
		}
		System.out.println(temp6);

		//ReplaceAll Method
		
		String s8 = "qwe123qwe123";
		//System.out.println(s8.replaceAll("[^a-zA-Z]", ""));
		String s9 = s8.replaceAll("[a-zA-Z]", "");
		System.out.println(s9);

		//Remove Spaces
		
		String s7 = "This    is   String";
		
		for(int i = 0; i<=s7.length()-1; i++)
		{
			if(s7.charAt(i) == ' ' && s7.charAt(i+1) ==' ')
			{
				continue;
			}
			else
			{
				System.out.print(s7.charAt(i));

			}
		}
		
		System.out.println();

		
		//Addition of Numbers
		
		String s10 = "10qw10qw30qw";
		String num10 = "";
		int flag = 0;
		int temp10 = 0;
		
		for(int i = 0; i<=s10.length()-1; i++)
		{
			if(Character.isDigit(s10.charAt(i)))
			{
				num10 = num10 + s10.charAt(i);
				flag = 1;
				
				if(i != (s10.length()-1));
					 continue;
			}
			if(flag==1)
			{
				int value10 = Integer.parseInt(num10);
				temp10 = value10 + temp10;
				num10 = "";
				flag=0;
				
			}
		}
		System.out.println(temp10);
		
		/*String s11 = "sdfgsdfgsdf";
		int count11 = 0;
		
		String split11 [] = s11.split("");
		System.out.println(split11);
		
		for(String pat : split11)
		{
			if(pat.contains("s"))
			{
				count11 = count11 + 1;
			}
		}
		
		System.out.println(count11);
		*/
		
		String s12 = "sdhjsdjsd";
		int count12 = 0;
		
		for(int i = 0; i<=s12.length()-1; i++)
		{
			if(s12.contains("sd"))
			{
				count12 = count12 + 1;
			}
		}
		System.out.println(count12);
		
		
		String s13 = "wertwer";
		
		
		
		for(int i = 0; i<=s13.length()-1; i++)
		{
			for(int j = i+1; j<=s13.length()-1; j++)
			{
				if((s13.charAt(i) == s13.charAt(j)))
				{
					System.out.print(s13.charAt(i));

				}
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
