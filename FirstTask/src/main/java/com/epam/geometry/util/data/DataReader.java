package com.epam.geometry.util.data;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger log = Logger.getLogger(DataReader.class);

    public List<String> read(String path) {
        log.info("");
        List<String> list = new ArrayList<>();
        File file = new File(path);

        try(FileReader input = new FileReader(file);
            BufferedReader buffer = new BufferedReader(input)) {

            String line;
            while((line = buffer.readLine()) != null) {
                list.add(line);
            }
        } catch(IOException e) {
            log.error("");

        }

        return list;
    }

}
