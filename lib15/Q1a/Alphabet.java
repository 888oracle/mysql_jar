package slips;

class Alphabet implements Runnable
{
	public void run()
	{	
	try
		{
			for(char c='A';c<='Z';c++)
			{
				System.out.println(c);
				Thread.sleep(3000);	
			}
		}
		catch(Exception e)
		{
			System.out.println("error");
		}	
	}
	
	public static void main(String[] d)
	{
		Alphabet x=new Alphabet();
		Thread y=new Thread(x);
		y.start();
		//x.run();
	}
}