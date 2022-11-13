import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader1 = new JsonReader(new FileReader("tests.json"));
        JsonReader reader2 = new JsonReader(new FileReader("values.json"));

        // 1. Java object to JSON file
//        List<Tests> data = gson.fromJson(reader1, List.class);

        Type listType = new TypeToken<List<Value>>() {}.getType();
        List<Value> list = gson.fromJson(reader1, listType);

        for (Value i: list)
            System.out.println(i.toString());
//        Tests[] tests = gson.fromJson(reader1, Tests[].class);
//        System.out.println(tests.toString());
    }
//    public String loadFileFromClasspath(String fileName) throws IOException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
//            // common-io
//            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//        }
//    }
}