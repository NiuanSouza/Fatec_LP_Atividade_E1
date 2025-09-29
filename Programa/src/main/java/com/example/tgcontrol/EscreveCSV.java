package com.example.tgcontrol;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EscreveCSV {

    private static final String FILE_PATH_NAME = "saida/output.csv";
    private static final String[] HEADERS = {"id", "name", "salary", "start_date", "dept"};

    public static void escreverLinha(String linhaCSV) throws IOException {

        Path path = Paths.get(FILE_PATH_NAME);
        Files.createDirectories(path.getParent());

        File file = path.toFile();
        boolean writeHeader = !file.exists() || file.length() == 0;

        CSVFormat format = CSVFormat.DEFAULT.builder().build();

        try (
                FileWriter fileWriter = new FileWriter(file, true);
                CSVPrinter csvPrinter = new CSVPrinter(fileWriter, format)
        ) {
            if (writeHeader) {
                csvPrinter.printRecord((Object[]) HEADERS);
            }

            String[] record = linhaCSV.split(",");

            csvPrinter.printRecord((Object[]) record);

        } catch (IOException e) {
            System.err.println("Erro ao escrever no CSV: " + e.getMessage());
            throw e;
        }
    }
}