package web.automation.study;

public class TestSleepMethod1 extends Thread {
    public void run(){
        if(Thread.currentThread().isDaemon()){//checking for daemon thread  
            System.out.println("daemon thread work");
        }
        else{
            System.out.println("user thread work");
        }
    }
    public static void main(String[] args){
        TestSleepMethod1 t1=new TestSleepMethod1();//creating thread  
        TestSleepMethod1 t2=new TestSleepMethod1();
        TestSleepMethod1 t3=new TestSleepMethod1();

        t1.setDaemon(true);//now t1 is daemon thread  

        t1.start();//starting threads  
        t2.start();
        t3.start();
    }
}
