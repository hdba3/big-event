/**
 * @author 33319
 * @Description
 * @create 2024/6/14 15:53
 */
package org.example;

import org.junit.Test;

public class ThreadLocalTest {
    @Test
    public void testThreadLocal() throws InterruptedException {
        //提供一个线程局部变量，每个线程都有一个副本，互不干扰
        ThreadLocal tl = new ThreadLocal();
        //开启两个线程
        Thread t1 = new Thread(() -> {
            tl.set("线程1的数据");
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
        }, "aaa");

        Thread t2 = new Thread(() -> {
            tl.set("线程2的数据");
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
            System.out.println(Thread.currentThread().getName() + "：" + tl.get());
        }, "bbbb");

        t1.start();
        t2.start();

        // 等待线程t1和t2完成
        t1.join();
        t2.join();
    }
}
