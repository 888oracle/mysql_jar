class Main {
    public static void main(String args[]) {
        String threadName;
        int threadPriority;
        
        Thread currentThread = Thread.currentThread();
        threadName = currentThread.getName();
        System.out.println("Current Thread name: " + threadName);
        
        threadPriority = currentThread.getPriority();
        System.out.println("Current thread priority: " + threadPriority);
    }
}
