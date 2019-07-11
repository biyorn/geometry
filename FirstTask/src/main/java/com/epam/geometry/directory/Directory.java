package com.epam.geometry.directory;

import com.epam.geometry.creator.PyramidCreator;
import com.epam.geometry.io.data.DataReader;
import com.epam.geometry.valid.impl.Validator;

public class Directory {

    private DataReader reader;
    private Validator valid;
    private PyramidCreator creater;

    public Directory(DataReader reader, Validator valid, PyramidCreator creater) {
        this.reader = reader;
        this.valid = valid;
        this.creater = creater;
    }

    public void realization() {


    }

}
