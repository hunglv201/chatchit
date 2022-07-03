package com.example.chatchit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SendChat implements Serializable {
    private String id;
    private String noidung;

    @Override
    public String toString() {
        return "SendChat{" +
                "id='" + id + '\'' +
                ", noidung='" + noidung + '\'' +
                '}';
    }
}
