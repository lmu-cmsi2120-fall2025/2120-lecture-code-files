import java.util.*;

public class ProductPriceHash {

    // Constants
    // -----------------------------------------------------------------------
    private static final int START_SIZE = 8;

    // Fields
    // -----------------------------------------------------------------------
    private LinkedList<Entry>[] buckets;
    private int size;

    // Constructor
    // -----------------------------------------------------------------------

    /**
     * Creates a new ProductPriceHash with the given START_SIZE number of buckets
     */
    public ProductPriceHash() {
        this.buckets = new LinkedList[START_SIZE];
        this.size = 0;
        for (int i = 0; i < buckets.length; i++) {
            this.buckets[i] = new LinkedList<Entry>();
        }
    }

    // Public Methods
    // -----------------------------------------------------------------------

    /**
     * Returns the number of unique key-value pairs stored in this ProductPriceHash
     *
     * @return The number of unique key-values pairs stored within
     */
    public int size() {
        return this.size;
    }

    /**
     * Associates the given productName with its corresponding price
     *
     * @param productName  [Key] Name of the product to price
     * @param productPrice [Value] Price of the product
     */
    public void put(String productName, double productPrice) {
        LinkedList<Entry> targetBucket = this.buckets[this.getBucketIndex(productName)];
        Entry existing = this.findEntry(targetBucket, productName);

        if (existing != null) {
            existing.price = productPrice;
        } else {
            targetBucket.add(new Entry(productName, productPrice));
            this.size++;
        }
    }

    /**
     * Returns the price associated with the given productName, or throws
     * an IllegalArgumentException if the key does not exist
     *
     * @param productName [Key] Name of the product for which to query the table
     * @throws IllegalArgumentException
     * @return
     */
    public double getPrice(String productName) {
        LinkedList<Entry> targetBucket = this.buckets[this.getBucketIndex(productName)];
        Entry entry = this.findEntry(targetBucket, productName);

        if (entry != null) {
            return entry.price;
        }

        throw new IllegalArgumentException("Key does not exist in this table!");
    }

    // Private Helper Methods
    // -----------------------------------------------------------------------

    /**
     * Returns the index corresponding to the given productName in the Table
     *
     * @param productName productName to search for in the Table
     * @return The index in the range of [0, # of buckets - 1]
     */
    private int getBucketIndex(String productName) {
        int rawHash = productName.hashCode();
        return Math.abs(rawHash) % this.buckets.length;
    }

    /**
     * Searches for an entry with the given productName in the provided bucket
     *
     * @param targetBucket The bucket to search within
     * @param productName  The product name to search for
     * @return The Entry if found, null otherwise
     */
    private Entry findEntry(LinkedList<Entry> targetBucket, String productName) {
        for (Entry entry : targetBucket) {
            if (entry.name.equals(productName)) {
                return entry;
            }
        }
        return null;
    }

    // Private Inner Class
    // -----------------------------------------------------------------------

    // [!] Note: in some implementations, this is a public inner class and can be
    // accessed / interacted-with by the user (Java's makes this public)
    private class Entry {

        String name;
        double price;

        Entry(String n, double p) {
            this.name = n;
            this.price = p;
        }

        @Override
        public boolean equals(Object other) {
            if (this.getClass() != other.getClass()) {
                return false;
            }
            Entry otherEntry = (Entry) other;
            return this.name.equals(otherEntry.name);
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }

    }

}