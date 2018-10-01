package com.thread;

/**
 * <pre>
 *     author : xiaweizi
 *     class  : com.thread.Test1
 *     e-mail : 1012126908@qq.com
 *     time   : 2018/10/01
 *     desc   :
 * </pre>
 */

class Test1 {
    public static void main(String[] args) {
        Project project = new Project();
        ThreadA threadA = new ThreadA(project);
        threadA.setName("nameA");
        ThreadB threadB = new ThreadB(project);
        threadB.setName("nameB");
        threadA.start();
        threadB.start();
    }
}

class Project {
    synchronized public void methodA() {
        try {
            System.out.println("thread name:\t" + Thread.currentThread().getName() + "currentTime:\t" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("methodA end\t" + "current Time:" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        try {
            System.out.println("thread name:\t" + Thread.currentThread().getName() + "currentTime:\t" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("methodB end\t" + "current Time:" + System.currentTimeMillis());
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