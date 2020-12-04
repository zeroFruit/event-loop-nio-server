package io.zerofruit.tasync.concurrent;

import io.zerofruit.tasync.common.ObjectUtil;

public final class FastThreadLocalRunnable implements Runnable {
    private final Runnable runnable;

    private FastThreadLocalRunnable(Runnable runnable) {
        this.runnable = ObjectUtil.checkNotNull(runnable, "runnable");
    }
    @Override
    public void run() {

    }

    static Runnable wrap(Runnable runnable) {
        return runnable instanceof FastThreadLocalRunnable
                ? runnable
                : new FastThreadLocalRunnable(runnable);
    }
}
