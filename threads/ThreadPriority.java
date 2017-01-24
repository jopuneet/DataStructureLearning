class A extends Thread{
	
	public void run(){
	
		System.out.println("Thread A Started");
		for(int i=1;i<=4;i++){
			System.out.println("Thread A: i = "+i);
			if(i==2)
				yield();
		}
		System.out.println("Exit Thread A");	
	}
	
}

class B extends Thread{
	
	public void run(){
	
		System.out.println("Thread B Started");
		for(int i=1;i<=4;i++){
			System.out.println("Thread B: i = "+i);
			if(i==3)
				stop();
		}
		System.out.println("Exit Thread B");	
	}
	
}

class C extends Thread{
	
	public void run(){
	
		System.out.println("Thread C Started");
		for(int i=1;i<=4;i++){
			System.out.println("Thread C: i = "+i);
			if(i==2){
				try {
	
					sleep(1000);
				}
				catch(Exception ex){}
			}
		}
		System.out.println("Exit Thread C");	
	}
}	

class D extends Thread{
	
	public void run(){
	
		System.out.println("Thread D Started");
		for(int i=1;i<=4;i++){
			System.out.println("Thread D: i = "+i);
		}
		System.out.println("Exit Thread D");	
	}
}
public class ThreadPriority {
	
	public static void main(String args[]){
		
		A th1=new A();
		B th2=new B();
		C th3=new C();
		D th4=new D();
		
	 
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		th3.setPriority(th2.getPriority()+1);
		th4.setPriority(th1.getPriority()-1);
		
		System.out.println("Start Thread A");
		th1.start();
		
		System.out.println("Start Thread B ");
		th2.start();
		
		System.out.println("Start Thread C ");
		th3.start();
		
		System.out.println("Start Thread D ");
		th4.start();
	}
    
    
    
}