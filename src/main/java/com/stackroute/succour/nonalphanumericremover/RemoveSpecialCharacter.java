package com.stackroute.succour.nonalphanumericremover;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSpecialCharacter {
    public List<String> specialCharacterRemover() throws IOException {
      List<String[]> list=new ArrayList<>();
        InputStream is = new FileInputStream("/home/cgi/IdeaProjects/Currently Working/text-cleansing/test.txt");
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String words = sb.toString();

        Pattern pt = Pattern.compile("[^a-zA-Z0-9 ]");
        Matcher match = pt.matcher(words);
        while (match.find()) {
            String s = match.group();
            words = words.replaceAll("\\" + s, "");


        }
      // System.out.println(words);
        words = Normalizer.normalize(words, Normalizer.Form.NFKD);
        List<String> items = Arrays.asList(words.split(" "));

        return items;
    }
}

