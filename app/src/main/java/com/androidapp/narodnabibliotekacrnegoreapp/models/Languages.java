package com.androidapp.narodnabibliotekacrnegoreapp.models;

public class Languages {

    private int lang_code;
    private String lang;
    private String lang_short;
    private String lang_three;
    private int active;

    public Languages(int lang_code, String lang, String lang_short, String lang_three, int active) {
        this.lang_code = lang_code;
        this.lang = lang;
        this.lang_short = lang_short;
        this.lang_three = lang_three;
        this.active = active;
    }

    public int getLang_code() {
        return lang_code;
    }

    public void setLang_code(int lang_code) {
        this.lang_code = lang_code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang_short() {
        return lang_short;
    }

    public void setLang_short(String lang_short) {
        this.lang_short = lang_short;
    }

    public String getLang_three() {
        return lang_three;
    }

    public void setLang_three(String lang_three) {
        this.lang_three = lang_three;
    }

    public int getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }
}
