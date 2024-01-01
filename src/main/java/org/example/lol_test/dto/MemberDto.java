package org.example.lol_test.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String pw;
    private String lolId;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public String getLolId() {
        return lolId;
    }

    public void setLolId(String lolId) {
        this.lolId = lolId;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
