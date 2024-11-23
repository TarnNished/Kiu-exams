package midterm1_23_24;

public class Entry {
    private String LastName;
    private String FirstName;
    private String BookTitle;

    public String getLastName() {
        return LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getBookTitle() {
        return BookTitle;
    }
    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }
    public Entry(String lastName, String FirstName, String BookTitle) {
       this.BookTitle = BookTitle;
       this.FirstName = FirstName;
       this.LastName = lastName;
    }
    public int compareTo(Entry b) {
      int isLastname = this.LastName.compareTo(b.LastName);
      if (isLastname != 0) return isLastname;
      int isfirstname = this.FirstName.compareTo(b.FirstName);
      if (isfirstname != 0) return isfirstname;

      return this.BookTitle.compareTo(b.BookTitle);
    }


}

