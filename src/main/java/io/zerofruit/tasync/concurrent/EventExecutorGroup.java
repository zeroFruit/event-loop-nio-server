package io.zerofruit.tasync.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public interface EventExecutorGroup extends ScheduledExecutorService, Iterable<EventExecutor>{
    boolean isShuttingDown();
    Future<?> shutdownGracefully();
    Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit);

    /**
     * Returns the Future which is notified when all EventExecutors managed by this EventExecutorGroup
     * have beeen terminated
     */
    Future<?> terminationFuture();

    /**
     * Returns one of the EventExecutors managed by this EventExecutorGroup
     * @return
     */
    EventExecutor next();
}
