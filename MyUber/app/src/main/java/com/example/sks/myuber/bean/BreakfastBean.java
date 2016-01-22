package com.example.sks.myuber.bean;

/**
 * Created by sks on 2016/1/17.
 */
public class BreakfastBean {

    private String mWeek;
    private String mFood;
    private String mPrice;
    private int mIcon;
    private  int mNoSelectIcon;
    private boolean isSelect;


    public int getmIcon() {
        return mIcon;
    }

    public void setmIcon(int mIcon) {
        this.mIcon = mIcon;
    }

    public int getmNoSelectIcon() {
        return mNoSelectIcon;
    }

    public void setmNoSelectIcon(int mNoSelectIcon) {
        this.mNoSelectIcon = mNoSelectIcon;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }

    public String getmWeek() {
        return mWeek;
    }

    public void setmWeek(String mWeek) {
        this.mWeek = mWeek;
    }

    public String getmFood() {
        return mFood;
    }

    public void setmFood(String mFood) {
        this.mFood = mFood;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

}
