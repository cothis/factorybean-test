package com.example.factorybean;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContextTest {
	@Test
	void thread() throws InterruptedException {
		Runnable runnable = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		};
		List<Thread> collect = IntStream.of(1, 2).mapToObj(i -> new Thread(runnable)).collect(Collectors.toList());
		for (Thread thread : collect) {
			thread.start();
		}
		for (Thread thread : collect) {
			thread.join();
		}
	}

	@Test
	void test() throws InterruptedException {
		Runnable runnable = () -> {
			AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.example.factorybean");
			ac.close();
		};

		for (int i = 0; i < 10; i++) {
			List<Thread> collect = IntStream.range(0, 100)
					.mapToObj(i1 -> new Thread(runnable))
					.collect(Collectors.toList());
			collect.forEach(Thread::start);
			collect.forEach(t -> {
						try {
							t.join();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			);
			Thread.sleep(100);
		}

	}
}
