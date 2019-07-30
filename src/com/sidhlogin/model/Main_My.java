package com.sidhlogin.model;

public class Main_My {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1=new Book();
		Book b2=new Book();
		b1.numberOfPages=1;
		b1.author="Sidhardh";
		b1.title="The art";
		
		
		b2.numberOfPages=9;
		b2.author="Sidhardh";
		b2.title="The art";
		
		int flg=b1.compareTo(b2);
		if(flg<0)
		{
			System.out.println("Order Book1");
		}
		else if (flg>0)
		{
			System.out.println("Order Book2");
		}
		else 
		{
			System.out.println("Same");
		}
		
	}

}
