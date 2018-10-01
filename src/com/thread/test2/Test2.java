package com.thread.test2;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.thread.test2.Test2
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/10/01
 *     desc   :
 * </pre>
 */

class Test2 {
    public static void main(String[] args) {
        Project project = new Project();
        ThreadA threadA = new ThreadA(project);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(project);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}

class Project {
    public void methodA() {
        try {
            System.out.println("end");
            synchronized (this) {
                System.out.println("Thread name:\t" + Thread.currentThread().getName() + "\tcurrent:" + System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("--------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        try {
            System.out.println("Thread name:\t" + Thread.currentThread().getName() + "\tcurrent:" + System.currentTimeMillis());
            synchronized (this) {
                Thread.sleep(3000);
                System.out.println("++++++");
            }
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    private Project project;

    ThreadA(Project project) {
        this.project = project;
    }

    @Override
    public void run() {
        super.run();
        project.methodA();
    }
}

class ThreadB extends Thread {
    private Project project;

    ThreadB(Project project) {
        this.project = project;
    }

    @Override
    public void run() {
        super.run();
        project.methodB();
    }
}