package com.bj.pijok.data;

import android.app.Activity;
import android.content.Context;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PartyDataProvider {

    private static final String DATA_FILE_NAME = "parties.dat";

    private static List<Party> parties;

    private static PartyDataProvider instance;

    private PartyDataProvider() {
    }

    public static PartyDataProvider getInstance(Activity activity) {
        if (instance == null) {
            instance = new PartyDataProvider();
            loadData(activity);
        }
        return instance;
    }

    public Party getCurrentParty() {
        // load parties
        // check if last party is still existing
        // if no then null
        return null;
    }

    public void addAlcoholEntry(Activity activity, AlcoholEntry alcoholEntry) {
        if (parties.isEmpty()) {
            Party party = new Party();
            party.addEntry(alcoholEntry);
            parties.add(party);
            saveData(activity);
        } else {
            Party lastParty = parties.get(parties.size() - 1);
            //// TU TRZEBA SPRAWDZIC CZY NIE WYGASLA TA IMPRA
            lastParty.addEntry(alcoholEntry);
            saveData(activity);
        }
    }

//    private List<Party> getParties(Activity activity) {
//        if (parties == null) {
//            loadData(activity);
//        }
//        return parties;
//    }

    private static void saveData(Activity activity) {
        try {
            FileOutputStream fos = activity.openFileOutput(DATA_FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(parties);
            os.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadData(Activity activity) {
        File file = new File(DATA_FILE_NAME);
        try {
            if (file.exists()) {
                FileInputStream fis = activity.openFileInput(DATA_FILE_NAME);
                ObjectInputStream is = new ObjectInputStream(fis);
                parties = (List<Party>) is.readObject();
                is.close();
                fis.close();
            } else {
                parties = new ArrayList<>();
                saveData(activity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            parties = new ArrayList<>();
        }
    }
}
