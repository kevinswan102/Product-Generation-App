package com.example.homepwner;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspect;
    private String valueInDollars = "";
    //private char[] serialNumber = {'a','c','d','e','f','g','z','q'};

    private String randomNoun;
    private String randomAdj;
    private String alphabet;

    Random rand;
    List<String> adj = new ArrayList<>();
    List<String> nouns = new ArrayList<>();
    String randName;
    StringBuilder sb = new StringBuilder(8);
    private String name, cost, ser, valStr="";

    // add 5 element in ArrayList

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public Crime() {
        this(UUID.randomUUID());
       // mId = UUID.randomUUID();
      //  mDate = new Date();
        rand = new Random();
        adj.add("Fuzzy"); adj.add("Rusty"); adj.add("Shiny"); adj.add("Fluffy"); adj.add("Sparkly");
        nouns.add("Bear"); nouns.add("Spork"); nouns.add("Mac"); nouns.add("Frog"); nouns.add("Cobra");
        randName="";
        randomNoun="";
        randomAdj = "";
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
    }

    public UUID getId() {
        return mId;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public Date getDate() { return mDate; }
    public void setDate(Date date) { mDate = date; }
    public boolean isSolved() { return mSolved; }
    public void setSolved(boolean solved) { mSolved = solved; }

    //Saves the cost value
    public String getValue() { return valueInDollars; }
    public void setValue(String val) { valueInDollars=val; }

    public void setVal() { valStr = Integer.toString(rand.nextInt(99)+1); }
    public String getVal() { return valStr; }

    public String getCost(){
        cost=getVal();
        return cost;
    }

    //Saves the serial number value in edit text
    public String getSerialNumber() { return name; }
    public void setSerialNumber(String serial) { name=serial; }

    public String getSerialNum(){
        name=getSerial();
        return name;
    }


    public String getSerial() { return ser; }

    public void setSerial() {
        for (int i = 0; i < 8; i++) {
            // serialNumber[i] = (alphabet.charAt(rand.nextInt(alphabet.length()-1)+0));
            int index = (int) (alphabet.length() * Math.random());

            // add Character one by one in end of sb
            if (sb.length() < 8)
                sb.append(alphabet.charAt(index));

            //save anything extra appended in the EditText after the 8th character

        }
            ser = sb.toString();

    }


    public String getAdj(){
        return randomAdj;
    }

    public void setAdj() {
        List<Integer> newList = new ArrayList<>();
        for(int i =0; i< adj.size(); i++) {
            int randomIndex = rand.nextInt(adj.size());
            randomAdj =adj.get(randomIndex);
        }
    }

    public String getNoun(){
        return randomNoun;
    }

    public void setNoun( ) {
        List<Integer> newList = new ArrayList<>();
        for(int i =0; i< nouns.size(); i++) {
            int randomIndex = rand.nextInt(nouns.size());
            randomNoun =nouns.get(randomIndex);
        }
    }


    public String getRandName() {
        randName = getAdj() + " " + getNoun();
        return randName; }

    public void setRandName(String random ) {
        randName=random;
    }

    public String getSuspect() {
        return mSuspect;
    }
    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }

}
