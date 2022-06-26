package com.example.chatchit.api;

public class SendChat {
    private String id;
    private String noidung;

    public SendChat(String id, String noidung) {
        this.id = id;
        this.noidung = noidung;
    }

    public String getId() {
        return id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    @Override
    public String toString() {
        return "SendChat{" +
                "id='" + id + '\'' +
                ", noidung='" + noidung + '\'' +
                '}';
    }
}
