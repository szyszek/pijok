package com.bj.pijok.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Party implements Serializable {
    static final long serialVersionUID = 2L;

    private List<AlcoholEntry> entries = new ArrayList<>();

    public List<AlcoholEntry> getEntries() {
        return entries;
    }

    public void addEntry(AlcoholEntry alcoholEntry) {
        entries.add(alcoholEntry);
    }
}
