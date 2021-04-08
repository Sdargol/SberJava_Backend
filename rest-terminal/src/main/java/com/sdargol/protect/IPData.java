package com.sdargol.protect;

public class IPData {
    private int attempts;
    private int numBlocked;
    private long blockingTime;

    public IPData(int attempts, int numBlocked, long blockingTime) {
        this.attempts = attempts;
        this.numBlocked = numBlocked;
        this.blockingTime = blockingTime;
    }

    public boolean getIpStatusBlocked() {
        return System.currentTimeMillis() < blockingTime;
    }

    private void blockIp() {
        ++numBlocked;
        blockingTime = System.currentTimeMillis() + 10_000;
        resetAttempt();
    }

    public long blockedTimeLeft() {
        if (getIpStatusBlocked()) {
            return (blockingTime - System.currentTimeMillis()) / 1000;
        }
        return 0;
    }

    public void addAttempt() {
        attempts = attempts + 1;

        if (attempts == 3) {
            blockIp();
        }
    }

    public void resetAttempt() {
        attempts = 0;
    }

    public int getNumBlocked() {
        return numBlocked;
    }
}
