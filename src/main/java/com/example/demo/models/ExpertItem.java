package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Optional;

/**
 * @author Fedor Danilov 15.11.2021
 */
@Entity(name = "dc_expertitem")
public class ExpertItem {
    @Id
    private long docid;

    private int version;

    private String code;

    private String name;
    private String pr_prcode;
    private String pr_prname;
    private String bd_budgetcode;
    private String bd_budgetname;
    private String note;
    private Date data_startactive;
    private Date data_endactive;
    private String guidnsi;
    private String sortnp;

    public ExpertItem() {
    }

    public ExpertItem(int version, String code, String name, String pr_prcode, String pr_prname, String bd_budgetcode, String bd_budgetname, String note, Date data_startactive, Date data_endactive, String guidnsi, String sortnp) {
        this.version = version;
        this.code = code;
        this.name = name;
        this.pr_prcode = pr_prcode;
        this.pr_prname = pr_prname;
        this.bd_budgetcode = bd_budgetcode;
        this.bd_budgetname = bd_budgetname;
        this.note = note;
        this.data_startactive = data_startactive;
        this.data_endactive = data_endactive;
        this.guidnsi = guidnsi;
        this.sortnp = sortnp;
    }

    public long getDocid() {
        return docid;
    }

    public void setDocid(long docid) {
        this.docid = docid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPr_prcode() {
        return pr_prcode;
    }

    public void setPr_prcode(String pr_prcode) {
        this.pr_prcode = pr_prcode;
    }

    public String getPr_prname() {
        return pr_prname;
    }

    public void setPr_prname(String pr_prname) {
        this.pr_prname = pr_prname;
    }

    public String getBd_budgetcode() {
        return bd_budgetcode;
    }

    public void setBd_budgetcode(String bd_budgetcode) {
        this.bd_budgetcode = bd_budgetcode;
    }

    public String getBd_budgetname() {
        return bd_budgetname;
    }

    public void setBd_budgetname(String bd_budgetname) {
        this.bd_budgetname = bd_budgetname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getData_startactive() {
        return data_startactive;
    }

    public void setData_startactive(Date data_startactive) {
        this.data_startactive = data_startactive;
    }

    public Date getData_endactive() {
        return data_endactive;
    }

    public void setData_endactive(Date data_endactive) {
        this.data_endactive = data_endactive;
    }

    public String getGuidnsi() {
        return guidnsi;
    }

    public void setGuidnsi(String guidnsi) {
        this.guidnsi = guidnsi;
    }

    public String getSortnp() {
        return sortnp;
    }

    public void setSortnp(String sortnp) {
        this.sortnp = sortnp;
    }
}

//    CREATE TABLE ufos.dc_expertitem (
//        docid numeric NOT NULL,
//        "version" numeric NULL,
//        code varchar(10) NULL,
//        "name" varchar(2000) NULL,
//        pr_prcode varchar(10) NULL,
//        pr_prname varchar(2000) NULL,
//        bd_budgetcode varchar(20) NULL,
//        bd_budgetname varchar(250) NULL,
//        note varchar(2000) NULL,
//        data_startactive date NULL,
//        data_endactive date NULL,
//        guidnsi varchar(36) NULL,
//        sortnp varchar NULL,
//        CONSTRAINT pk_dc_expertitem PRIMARY KEY (docid)
//        );