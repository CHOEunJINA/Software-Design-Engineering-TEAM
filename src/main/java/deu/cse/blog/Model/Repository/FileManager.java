/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * 전반적인 데이터 입출력을 수행하는 FileManager
 *
 * @author 강대한
 */
public class FileManager {
    //싱글턴 패턴을 적용하여 객체를 하나만 생성되게 객체를 이른 초기화로 생성
    private static FileManager fileManager_ = new FileManager();
    
    //외부에서 생성자에 접근 못하게 한다.
    private FileManager() {
    }
    
    //정적 메서드를 통해 객체 반환
    public static FileManager fileManager() { 
        return fileManager_;
    }
    // 요청온 데이터 경로의 데이터 출력
    public static JSONArray get(String fileRoute) throws IOException, ParseException {

        Object obj = new Object();
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = new JSONArray();
        try {
            FileReader reader = new FileReader(fileRoute, Charset.forName("utf-8"));
            obj = parser.parse(reader);
            jsonArr = (JSONArray) obj;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArr;
    }
    // 요청온 데이터 경로에 데이터 입력
    public static void set(String fileRoute, JSONArray jsonArr) throws IOException, ParseException {
        
        try {
            FileWriter writer = new FileWriter(fileRoute, Charset.forName("utf-8"));
            writer.write(jsonArr.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
