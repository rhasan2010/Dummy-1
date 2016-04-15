/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imhasan.beingjava.test;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Uzzal
 */
public class ImageControllerTest {

    ImageController instance;

    public ImageControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new ImageController();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createHwAddressToImgEntriesMap method, of class ImageController.
     */
    @Test
    public void testCreateHwAddressToImgEntriesMap() throws Exception {
        System.out.println("createHwAddressToImgEntriesMap");
        String expected = "ImageController{imageMap=[ImgEntry{eventCode=0, hwAddress=00050A010203, time=1405153239000, md5Hex=cf29de9e514d59ed03f33cdd5376520c}, ImgEntry{eventCode=0, hwAddress=00050A010203, time=1407505020000, md5Hex=b79b631054171dea899cf0bcdf1fbdc1}, ImgEntry{eventCode=1, hwAddress=00050A010203, time=1406895005000, md5Hex=e99bb926a03cdacfe2615889ee7271c5}][ImgEntry{eventCode=12, hwAddress=00050A01EFAC, time=1406916742000, md5Hex=63101a91c3c174874b0081b965c43410}][ImgEntry{eventCode=0, hwAddress=00050A0112AC, time=1406930074000, md5Hex=2b5a7f19ff072af9970f9d5334a726ec}, ImgEntry{eventCode=0, hwAddress=00050A0112AC, time=1406930352000, md5Hex=46a925876ba2781bb28b185338d39a24}]}";
        String directory = "C:\\Users\\Uzzal\\Desktop\\New folder\\questions_to_Robiul_Hasan\\data";
        Map<String, List<ImgEntry>> result = instance.createHwAddressToImgEntriesMap(directory);
        assertEquals(expected, instance.printMap(result));
    }

    @Test
    public void testCountCorrectFormattedFiles() throws ParseException {
        System.out.println("testCountCorrectFormattedFiles");
        int expected = 3;
        String directory = "C:\\Users\\Uzzal\\Desktop\\New folder\\questions_to_Robiul_Hasan\\data";
        Map<String, List<ImgEntry>> count = instance.createHwAddressToImgEntriesMap(directory);
        int result = count.size();
        assertEquals(expected, result);

    }
}
