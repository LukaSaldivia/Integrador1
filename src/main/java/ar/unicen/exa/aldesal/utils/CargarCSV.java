package ar.unicen.exa.aldesal.utils;

import ar.unicen.exa.aldesal.dao.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CargarCSV {
    public static <T> void cargar(CRUDDAO<T> c1, String filename) throws IOException, SQLException {
        String path = "../resources/" + filename;
        ArrayList<T> arr = new  ArrayList<T>();
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(filename));
        for (CSVRecord record : parser) {
            c1.agregarEnMemoria(record, arr);
        }

        c1.insertarVarios(arr);
    }
}
