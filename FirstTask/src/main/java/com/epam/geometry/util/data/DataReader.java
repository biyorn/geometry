package com.epam.geometry.util.data;

import com.epam.geometry.exception.file.PathToFileIsWrongException;
import com.epam.geometry.exception.file.FileNotReadException;
import com.epam.geometry.exception.file.FileWorkException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static final Logger log = Logger.getLogger(DataReader.class);

    public DataReader() {}

    public List<String> read(String path) throws FileWorkException {
        if(path == null) {
            log.error("Exception, the path to file is null");
            throw new PathToFileIsWrongException("Path is wrong");
        }
        log.info("Reading from file");
        List<String> list = new ArrayList<>();

        try(FileReader input = new FileReader(path);
            BufferedReader buffer = new BufferedReader(input)) {

            String line;
            while((line = buffer.readLine()) != null) {
                list.add(line);
            }
        } catch(IOException e) {
            log.error("Exception at work with file");
            throw new FileNotReadException("");
        }

        return list;
    }

}
