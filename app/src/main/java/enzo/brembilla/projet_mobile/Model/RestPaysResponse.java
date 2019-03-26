package enzo.brembilla.projet_mobile.Model;

import java.util.List;

public class RestPaysResponse {

    private int count;
    private String next;
    private String previous;
    private List<Pays> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Pays> getResults() {
        return results;
    }

    public void setResults(List<Pays> results) {
        this.results = results;
    }
}
