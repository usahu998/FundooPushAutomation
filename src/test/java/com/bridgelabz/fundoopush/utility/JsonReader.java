package com.bridgelabz.fundoopush.utility;

import com.google.gson.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonReader {
    public static Object[][] getJSONdata(String JSON_path, String JSON_data ,int JSON_attributes) throws IOException, ParseException {


        Object obj = new JSONParser().parse(new FileReader(JSON_path));
        JSONObject jo = (JSONObject)obj;
        JSONArray js = (JSONArray)jo.get(JSON_data);

        Object [][] arr = new String[js.size()][JSON_attributes];
        for (int i = 0; i < js.size(); i++)
        {
            JSONObject obj1 = (JSONObject)js.get(i);
            arr[i][0] = String.valueOf(obj1.get("UserID"));
            arr[i][1] = String.valueOf(obj1.get("Password"));
            arr[i][2] = String.valueOf(obj1.get("ConPassword"));
        }
        return arr;
    }

    public static Object[][] getdata(String JSON_path, String typeData, int totalDataRow, int totalColumnEntry) throws JsonIOException, JsonSyntaxException, FileNotFoundException
    {
        JsonParser jsonParser =  new JsonParser();
        JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
        JsonArray array = (JsonArray) jsonObj.get(typeData);
        return searchJsonElemnet(array, totalDataRow, totalColumnEntry);
    }


    public static Object[][] toArray(List<List<Object>> list)
    {
        Object[][] r = new Object[list.size()+1][];
        int i = 0;
        for (List<Object> next : list)
        {
            r[i++] = next.toArray(new Object[next.size()+1]);
        }
        return r;
    }

    public static Object[][] searchJsonElemnet(JsonArray jsonArray, int totalDataRow, int totalColumnEntry) throws NullPointerException
    {

        Object[][] matrix = new Object[totalDataRow][totalColumnEntry];
        int i =0;
        int j = 0;
        for (JsonElement jsonElement : jsonArray)
        {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet())
            {
                matrix[i][j] = entry.getValue().toString().replace("\"","");
                j++;
            }
            i++;
            j = 0;
        }
        return matrix;
    }
}

