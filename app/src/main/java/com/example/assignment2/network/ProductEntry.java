package com.example.assignment2.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.assignment2.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A product entry in the list of products.
 */
public class ProductEntry {
    private static final String TAG = ProductEntry.class.getSimpleName();

    public final String name;
    public final Uri dynamicUrl;
    public final String url;

    public ProductEntry(
            String name, String dynamicUrl, String url, String bio) {
        this.name = name;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
    }

    /**
     * Loads a raw JSON at R.raw.products and converts it into a list of MatchesEntry objects
     */
    public static List<ProductEntry> initMatchesEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.matches);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error writing/reading from the JSON file.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error closing the input stream.", exception);
            }
        }
        String jsonProductsString = writer.toString();
        Gson gson = new Gson();
        Type productListType = new TypeToken<ArrayList<ProductEntry>>() {
        }.getType();
        return gson.fromJson(jsonProductsString, productListType);
    }
}
