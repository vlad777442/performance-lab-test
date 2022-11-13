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

        Type listType = new TypeToken<Tests>() {}.getType();
        Tests tests = gson.fromJson(reader1, listType);

        Type listType2 = new TypeToken<SubValues>() {}.getType();
        SubValues values = gson.fromJson(reader2, listType2);

//        System.out.println(tests.getTests().get(0));
        for (int i = 0; i < tests.getTests().size(); i++) {
            System.out.println(tests.getTests().get(i).getId());
            if (tests.getTests().get(i).getValues() != null) {
                tests.getTests().get(i).getValues().get()
            }
            
        }
        while (true) {
            if ()
        }
//        for (int i = 0; i < values.getSubValuesData().size(); i++) {
//
//        }

//        for (Value i: list)
//            System.out.println(i.toString());
//        Tests[] tests = gson.fromJson(reader1, Tests[].class);
//        System.out.println(tests.toString());
    }
    public static Tests getArray(Value t1) {
        if (t1.getValues() != null)
            return getArray(t1.getValues().get())
    }

}