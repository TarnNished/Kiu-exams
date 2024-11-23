package midterm1_23_24;

public class Library {
    private Entry[] entries;

    public Library(Entry[] entries) {
       this.entries = entries == null ? new Entry[0] : entries;
    }

    public Entry searchHelper(Entry book){
        int l = 0;
        int r = this.entries.length - 1;
        int m;
        int compRes;
        while (l <= r) {
            m = (l + r) / 2;
            compRes = book.compareTo(this.entries[m]);
            if (compRes == 0) {
                return this.entries[m];
            }else if (this.entries[m].compareTo(book) == 1 ) {
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        return null;
    }

}
