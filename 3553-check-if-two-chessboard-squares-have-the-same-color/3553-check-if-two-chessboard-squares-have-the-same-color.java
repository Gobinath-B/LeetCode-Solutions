
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
         char c1=coordinate1.charAt(0); char cl1='\0'; char c2=coordinate2.charAt(0); char cl2='\0';
		 if(c1=='a'||c1=='c'||c1=='e'||c1=='g') {
			 if((coordinate1.charAt(1)-'0')%2==0) cl1='w';
			 else cl1='b';
			 
		 }
		 else {
			 if((coordinate1.charAt(1)-'0')%2==0) cl1='b';
			 else cl1='w';
		 }
		 if(c2=='a'||c2=='c'||c2=='e'||c2=='g') {
			 if((coordinate2.charAt(1)-'0')%2==0) cl2='w';
			 else cl2='b';
			 
		 }
		 else {
			 if((coordinate2.charAt(1)-'0')%2==0) cl2='b';
			 else cl2='w';
		 }
		 return cl1==cl2;
    }
}