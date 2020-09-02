public class Demo4 {

    public static void main(String args[]) {

        Runnable runnable=new Runnable(){

			@Override
			public void run() {
                for(int i=0;i<1000;i++){
                    System.out.println(
                        Thread.currentThread().getId()+" : "+i
                    );
                }
				
			}

        };

        Thread thread=new Thread(runnable);
        thread.start();

        Thread thread1=new Thread(runnable);
        thread1.start();

        Thread thread2=new Thread(runnable);
        thread2.start();
        
    }
    
}