package edu.vandy.model;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * Defines a mechanism that mediates concurrent access to a fixed
 * number of available Palantiri.  This class uses a "fair" Semaphore
 * and a ConcurrentHashMap, and synchronized statements to mediate
 * concurrent access to the Palantiri.  This class implements a
 * variant of the "Pooling" pattern
 * (kircher-schwanninger.de/michael/publications/Pooling.pdf).
 */
public class PalantiriManager {
    /**
     * Debugging tag used by the Android logger.
     */
    protected final static String TAG = 
        PalantiriManager.class.getSimpleName();

    /**
     * A FairSemaphore that limits concurrent access to the fixed
     * number of available palantiri managed by the PalantiriManager.
     */
    private final FairSemaphore mAvailablePalantiri;

    /**
     * A map that associates the @a Palantiri key to the @a boolean
     * values that keep track of whether the key is available.
     */
     * The Map interface is used here to work around an Android
     * version conflict between Java 7 and Java 8. In Java 7, keySet()
     * returns a Set<K>, while Java 8 was changed to return
     * ConcurrentHashMap.KeySetView<K,V>. The compiler will mismatch
     * the signature of the keySet() call when the invoked object is
     * of type ConcurrentHashMap but not if the invoked object is of
     * type Map<K,V>. This is only an issue when compiling with
     * targetCompatibility set to 1.7.
     */
    private final Map<Palantir, Boolean> mPalantiriMap;

    /**
     * Constructor creates a PalantiriManager for the List of @a
     * palantiri passed as a parameter and initializes the fields.
     */
    public PalantiriManager(List<Palantir> palantiri) {
        // Create a new ConcurrentHashMap, iterate through the List of
        // Palantiri and initialize each key in the HashMap with
        // "true" to indicate it's available, and initialize the
        // Semaphore to use a "fair" implementation that mediates
        // concurrent access to the given Palantiri.
        // TODO -- you fill in here.
    }

    /**
     * Get a Palantir from the PalantiriManager, blocking until one is
     * available.
     */
    public Palantir acquire() {
        // Acquire the Semaphore uninterruptibly and then keep
        // iterating through the ConcurrentHashMap to find the first
        // key in the HashMap whose value is "true" (which indicates
        // it's available for use) and atomically replace the value of
        // this key with "false" to indicate the Palantir isn't
        // available and then return that palantir to the client.
        // There should be *no* synchronized statements in this
        // method.
        // TODO -- you fill in here.
    }

    /**
     * Returns the designated @code palantir to the PalantiriManager
     * so that it's available for other Threads to use.  An invalid @a
     * palantir is ignored.
     */
    public void release(final Palantir palantir) {
        // Put the "true" value back into ConcurrentHashMap for the
        // palantir key and release the Semaphore if all works
        // properly.  There should be *no* synchronized statements in
        // this method.
        // TODO -- you fill in here.
    }

    /*
     * The following method is just intended for use by the regression
     * tests, not by applications.
     */

    /**
     * Returns the number of available permits on the semaphore.
     */
    public int availablePermits() {
        return mAvailablePalantiri.availablePermits();
    }
}
