package com.epam.geometry.io;

import com.epam.geometry.exception.file.PathToFileIsWrongException;
import com.epam.geometry.exception.file.FileNotReadException;
import com.epam.geometry.exception.file.DataMissingException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> read(String path) throws DataMissingException {
        File file = new File(path);
        if(!file.exists()) {
            LOGGER.error("Error, the path to file is null");
            throw new PathToFileIsWrongException("Path is wrong");
        }
        List<String> list = new ArrayList<>();

        try(BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = buffer.readLine()) != null) {
                list.add(line);
            }
        } catch(IOException e) {
            LOGGER.error("Error at work with file");
            throw new FileNotReadException("");
        }

        return list;
    }

}
