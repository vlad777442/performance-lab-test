import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        JsonReader reader1 = new JsonReader(new FileReader("tests.json"));
        JsonReader reader2 = new JsonReader(new FileReader("values.json"));

        Type listType = new TypeToken<Tests>() {}.getType();
        Tests tests = gson.fromJson(reader1, listType);

        Type listType2 = new TypeToken<SubValues>() {}.getType();
        SubValues values = gson.fromJson(reader2, listType2);


        for (int i = 0; i < tests.getTests().size(); i++) {
//            System.out.println(tests.getTests().get(i).getId());
            tests.getTests().get(i).setValue(searchForValue(tests.getTests().get(i).getId(), values));
            if (tests.getTests().get(i).getValues() != null) {
                for (int j = 0; j < tests.getTests().get(i).getValues().size(); j++) {
                    tests.getTests().get(i).getValues().get(j).setValue(
                            searchForValue(tests.getTests().get(i).getValues().get(j).getId(), values));
                }
            }

        }


        for (int i = 0; i < tests.getTests().size(); i++)
            System.out.println(tests.getTests().get(i).toString());

        try (Writer writer = new FileWriter("report.json")) {
            Gson gson2 = new GsonBuilder().create();
            gson2.toJson(tests, writer);
        }

    }
//    public static Tests getArray(Value t1, int k) {
//        if (t1.getValues().size() < k)
//
//        if (t1.getValues() != null)
//            return getArray(t1.getValues().get())
//    }
    public static String searchForValue(int id, SubValues data) {
        System.out.println(id);

        System.out.println(data.getValues().size());
        for (int i = 0; i < data.getValues().size(); i++) {
            if (data.getValues().get(i).getId() == id) {
                System.out.println(id);
                return data.getValues().get(i).getValue();
            }
        }
        return null;
    }

}