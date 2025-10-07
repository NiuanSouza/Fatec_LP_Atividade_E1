package com.example.programa;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class EscreveCSV {

    public static void escreverLinha(String filePath, String[] headers, String[] record) throws IOException {
        // Validação básica dos parâmetros
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("O caminho do arquivo não pode ser nulo ou vazio.");
        }
        if (headers == null || headers.length == 0) {
            throw new IllegalArgumentException("O cabeçalho não pode ser nulo ou vazio.");
        }
        if (record == null) {
            throw new IllegalArgumentException("O registro de dados não pode ser nulo.");
        }

        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            File file = path.toFile();
            boolean writeHeader = !file.exists() || file.length() == 0;

            CSVFormat format = CSVFormat.DEFAULT.builder().build();

            try (
                    FileWriter fileWriter = new FileWriter(file, true);
                    CSVPrinter csvPrinter = new CSVPrinter(fileWriter, format)
            ) {
                if (writeHeader) {
                    csvPrinter.printRecord((Object[]) headers);
                }
                csvPrinter.printRecord((Object[]) record);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV '" + filePath + "': " + e.getMessage());
            throw e;
        }
    }
}
