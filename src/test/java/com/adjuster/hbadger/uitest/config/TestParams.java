package com.adjuster.hbadger.uitest.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TestParams {

    private Map<String, String> testParams;

    public TestParams(String file) {
        try {
            this.testParams = loadData(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> loadData(String filePath) throws IOException {
        Map<String, String> data = new HashMap<>();
        String delim = ",";
        try (Stream<String> lines = Files.lines(Paths.get("src/test/resources/data/"+filePath), StandardCharsets.UTF_8)) {
            lines.filter(line -> line.contains(delim)).forEach(
                    line -> data.putIfAbsent(line.split(delim)[0]
                            , line.split(delim)[1]));
        } catch (IOException e) {
            throw new IOException("Could not read from file.");
        }
        return data;
    }

    public String get(String param) {
        return testParams.get(param);
    }

}
