package com.zsh.thread.share;

import org.junit.Test;

/**
 * When you run your code from main it creates both beans, thus two threads - daemon and non-daemon. As long as non-daemon thread is running, your application won't exit. So it works.
 *
 *  It's different when run from JUnit.
 *  As soon as JUnit test method completes (and it completes immediately after the Spring context is up),
 *  JUnit assumes your tests are done. Thus it kills all your threads and basically the whole JVM.

 *Remember your Waitor1 bean spawns a background thread which JUnit doesn't care about.
 * As soon as you leave @Test method JUnit will just stop everything.
 */
public class EventCheckerTests {

    @Test
    public void testEvenGenerator() {
        EventChecker.test(new SynchronizedEvenGenerator());
    }
}
