/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imhasan.beingjava.test;

import java.util.Calendar;

/**
 *
 * @author Uzzal
 */
public class ImgEntry {

    public Integer eventCode; // NN
    public String hwAddress; // XXXXXXXXXXXX
    public Calendar time; // yyyy-MM-dd_HHmmss
    public String md5Hex; // MD5 digest of the file contents

    public Integer getEventCode() {
        return eventCode;
    }

    public void setEventCode(Integer eventCode) {
        this.eventCode = eventCode;
    }

    public String getHwAddress() {
        return hwAddress;
    }

    public void setHwAddress(String hwAddress) {
        this.hwAddress = hwAddress;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public String getMd5Hex() {
        return md5Hex;
    }

    public void setMd5Hex(String md5Hex) {
        this.md5Hex = md5Hex;
    }

    @Override
    public String toString() {
        return "ImgEntry{" + "eventCode=" + eventCode + ", hwAddress=" + hwAddress + ", time=" + time.getTimeInMillis() + ", md5Hex=" + md5Hex + '}';
    }

}
