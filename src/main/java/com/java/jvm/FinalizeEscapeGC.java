package com.java.jvm;

/**
 * jvm参数调优：https://blog.csdn.net/wang379275614/article/details/78471604
 * https://blog.csdn.net/lpw_cn/article/details/84423500
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes,I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc(); //调用该方法建议系统执行垃圾清理，但也并不一定执行
        //因为Finalize线程优先级较低，暂停0.5秒以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("No, I am dead!");
        //下面这段代码与上面完全相同，但这次却自救失败了
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null)
            SAVE_HOOK.isAlive();
        else
            System.out.println("No, I am dead!");
    }

}
