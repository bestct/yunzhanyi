package net.yunzhanyi.common.web.manager;

import net.yunzhanyi.common.core.utils.Threads;
import net.yunzhanyi.common.web.utils.BeanUtils;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author bestct
 * @date 2022/7/23
 * @type 类
 */

public class AsyncManager
{
    /**
     * 操作延迟10毫秒
     */
    private static final int OPERATE_DELAY_TIME = 10;

    /**
     * 异步操作任务调度线程池
     */
    private ScheduledExecutorService executor = BeanUtils.getBean("scheduledExecutorService");

    /**
     * 单例模式
     */
    private AsyncManager(){}

    private static AsyncManager me = new AsyncManager();

    public static AsyncManager me()
    {
        return me;
    }

    /**
     * 执行任务
     *
     * @param task 任务
     */
    public void execute(TimerTask task)
    {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 停止任务线程池
     */
    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
