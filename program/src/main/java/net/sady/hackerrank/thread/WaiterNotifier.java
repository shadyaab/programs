package net.sady.hackerrank.thread;

class Message {
	
	private String msg;
	
	public Message(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

class Waiter implements Runnable{

	private Message msg;
	
	public Waiter(Message msg) {
		this.msg = msg;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		synchronized (msg) {
			System.out.println(name + ": Waiting for thread to call notify at " + System.currentTimeMillis());
			try {
				msg.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + ": Waiter Thread get notified at " + System.currentTimeMillis());
			
			System.out.println(name + " processed " + msg.getMsg());
		}
	}
}

class Notifier implements Runnable{
	
	private Message msg;
	
	public Notifier(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + ": started");
		
		try {
			Thread.sleep(3000);
			synchronized (msg) {
				msg.setMsg(name + " notifier work done");
				msg.notify();
				//msg.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


public class WaiterNotifier {

	public static void main(String[] args) {
		
		Message message = new Message("Process it");
		Thread thread1 = new Thread(new Waiter(message), "waiter1");
		
		Thread thread2 = new Thread(new Waiter(message), "waiter2");
		
		thread1.start();
		thread2.start();
		
		Thread threadNotifier = new Thread(new Notifier(message), "Notifier");
		threadNotifier.start();
		
	}

}






