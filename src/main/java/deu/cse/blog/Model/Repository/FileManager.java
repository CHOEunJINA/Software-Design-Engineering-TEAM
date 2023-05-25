/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deu.cse.blog.Model.Repository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author 조은진 // 파일 관리
 */
public class FileManager {

    private static JSONParser parser = new JSONParser();

    /**
     *
     * @param filepath
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static JSONArray readFile(String filepath) throws IOException, ParseException {

        FileReader reader = new FileReader(filepath, Charset.forName("utf-8"));
        Object obj = parser.parse(reader);

        JSONArray jsonArr = (JSONArray) obj;
        reader.close();
        return jsonArr;

    }

    /**
     *
     * @param filepath
     * @param jsonArr
     * @throws IOException
     * @throws ParseException
     */
    public static void writeFile(String filepath, JSONArray jsonArr) throws IOException, ParseException {
        // JSON 데이터를 텍스트 파일에 저장
        FileWriter fileWriter = new FileWriter(filepath, Charset.forName("utf-8"));
        fileWriter.write(jsonArr.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
