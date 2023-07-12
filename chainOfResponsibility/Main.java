package chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();
        Logger errorLogger = new ErrorLogger();
        logger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(errorLogger);

        logger.log(LoggerTarget.console,"this is console");
        logger.log(LoggerTarget.file,"this is file");
        logger.log(LoggerTarget.error,"this is error");
    }
}

enum LoggerTarget{
    console,file,error
}

abstract class Logger {
    protected LoggerTarget target;
    protected Logger nextLogger;

    public void setNextLogger(Logger next){
        this.nextLogger = next;
    }

    public void log(LoggerTarget target,String message){
        if (target == this.target){
            write(message);
        }else{
            this.nextLogger.log(target,message);
        }
    }

    abstract protected void write(String message);
}

class ConsoleLogger extends Logger {
    public ConsoleLogger(){
        target = LoggerTarget.console;
    }
    @Override
    protected void write(String message) {
        System.out.println("Console log:"+message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger(){
        this.target = LoggerTarget.error;
    }
    @Override
    protected void write(String message) {
        System.out.println("Error log:"+message);
    }
}

class FileLogger extends Logger {
    public FileLogger(){
        this.target = LoggerTarget.file;
    }
    @Override
    protected void write(String message) {
        System.out.println("File log:"+message);
    }
}
