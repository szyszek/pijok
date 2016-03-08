package com.bj.pijok.data;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<AlcoholEntry> entries = new ArrayList<>();

    public List<AlcoholEntry> getEntries() {
        return entries;
    }

    public void addEntry(AlcoholEntry alcoholEntry) {
        entries.add(alcoholEntry);
    }
}
