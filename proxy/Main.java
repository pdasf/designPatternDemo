package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Stack ori = new PosIntStack();
        Stack stack = (Stack) Proxy.newProxyInstance(
                ori.getClass().getClassLoader(),
                ori.getClass().getInterfaces(),
                new ProxyHandler(ori));

        stack.push(1);
        stack.push(-1);
        stack.push(2);
        while (true){
            Integer i =  stack.pop();
            if (i == null){
                break;
            }
            System.out.println(i);
        }
    }
}

interface Stack{
    void push(int input);
    Integer pop();
}

class PosIntStack implements Stack {
    private Deque<Integer> data;
    public PosIntStack(){
        this.data = new LinkedList<>();
    }
    public void push(int input){
        this.data.push(input);
    }

    public Integer pop(){
        try {
            return this.data.pop();
        }catch (Exception ignored){
            return null;
        }
    }
}

class ProxyHandler implements InvocationHandler{
    private Object target;
    public ProxyHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().contains("push")){
            if (args[0] instanceof Integer arg){
                if (arg < 0){
                    System.out.println(arg+" is not a positive integer");
                }else {
                    method.invoke(target,args);
                }
            }
            return null;
        }else {
            return method.invoke(target,args);
        }
    }
}