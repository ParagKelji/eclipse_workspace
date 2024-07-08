package com.f21.test;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadsEx {
	
	class InnerThreadWorker {
		
		public void runMeAsThreadTask(int i) {
			System.out.println("Virtual Thread Worker: " + Thread.currentThread() + " and thread num count: " + i);
		}
	}
	
	public static void main(String[] args) {
		try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
		    IntStream.rangeClosed(1, 10000).forEach(i -> {
		        executor.submit(() -> {
		            new VirtualThreadsEx().new InnerThreadWorker().runMeAsThreadTask(i);
		            try {
		                Thread.sleep(Duration.ofSeconds(1));
		            } 
		            catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        });
		    });
		}
	}

}
