package adapter;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableAdapter(new Task(10)));
        thread.start();
    }
}

class RunnableAdapter implements Runnable{
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable){
        this.callable = callable;
    }
    @Override
    public void run() {
        try {
            String result = (String) callable.call();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<String> {
    private int num;
    public Task(int n) {
        this.num = n;
    }
    @Override
    public String call(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<this.num;i++){
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString();
    }
}
