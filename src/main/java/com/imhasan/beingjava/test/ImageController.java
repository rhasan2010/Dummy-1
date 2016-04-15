/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imhasan.beingjava.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Uzzal
 */
public class ImageController {

    private Map<String, List<ImgEntry>> imageMap;

    public ImageController() {
        imageMap = new HashMap<>();
    }

    public Map<String, List<ImgEntry>> createHwAddressToImgEntriesMap(String directory) throws ParseException {
        for (File f : getFilesFromDirectory(directory)) {
            ImgEntry imgEntry = getObjFromFilePath(f);
            if (imageMap.keySet().contains(imgEntry.getHwAddress())) {
                imageMap.get(imgEntry.hwAddress).add(imgEntry);
            } else {
                List<ImgEntry> entrys = new ArrayList<>();
                entrys.add(imgEntry);
                imageMap.put(imgEntry.getHwAddress(), entrys);
            }
        }
        return Collections.unmodifiableMap(imageMap);
    }

    private List<File> getFilesFromDirectory(String directory) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        List<File> files = new ArrayList<>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (validateFile(listOfFiles[i].getName())) {
                    files.add(listOfFiles[i]);
                }
            }
        }
        return Collections.unmodifiableList(files);
    }

    private boolean validateFile(String path) {
        boolean valid = true;
        String ext = path.substring(path.lastIndexOf("."));
        path = path.substring(0, path.lastIndexOf("."));
        String[] params = path.split("_");
        if (params[0].length() <= 2) {
            try {
                Integer.parseInt(params[0]);
                valid = valid & true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
        if (params[1].length() == 12) {
            valid = valid & true;
        } else {
            return false;
        }
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
            cal.setTime(sdf.parse(params[2] + "_" + params[3]));
            valid = valid & true;
        } catch (ParseException ex) {
            return false;
        }
        return valid;
    }

    private ImgEntry getObjFromFilePath(File f) throws ParseException {
        String path = f.getName();
        String ext = path.substring(path.lastIndexOf("."));
        path = path.substring(0, path.lastIndexOf("."));
        String[] params = path.split("_");
        ImgEntry imgEntry = new ImgEntry();
        imgEntry.setEventCode(Integer.parseInt(params[0]));
        imgEntry.setHwAddress(params[1]);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HHmmss");
        cal.setTime(sdf.parse(params[2] + "_" + params[3]));
        imgEntry.setTime(cal);
        try {
            imgEntry.setMd5Hex(getFileContent(f));
        } catch (IOException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imgEntry;
    }

    private String getFileContent(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        String md5 = DigestUtils.md5Hex(fis);
        fis.close();
        return md5;
    }

    public String printMap(Map<String, List<ImgEntry>> images) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : images.keySet()) {
            stringBuilder = stringBuilder.append(images.get(key).toString());
        }
        System.out.println("ImageController{" + "imageMap=" + stringBuilder + '}');
        return "ImageController{" + "imageMap=" + stringBuilder + '}';
    }
}
