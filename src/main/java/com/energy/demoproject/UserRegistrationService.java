package com.energy.demoproject;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserRegistrationService {
    private static final String DEFAULT_FILE_PATH = "./account.csv";
    private static final File DEFAULT_FILE = new File(DEFAULT_FILE_PATH);

    public void save(User user) throws RuntimeException {
        try {
            // create FileWriter object with file as parameter

            // append the file not deleting the existing one
            FileWriter outputfile = new FileWriter(DEFAULT_FILE, true);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // append data
            String[] record = new String[]{user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname()};
            writer.writeNext(record, false);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<User> loadUsers() {
        CSVReader reader;
        try {
            reader = new CSVReader(new FileReader(DEFAULT_FILE));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CsvToBean<User> csvReader = new CsvToBeanBuilder(reader)
                .withType(User.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        return csvReader.parse();
    }
}
