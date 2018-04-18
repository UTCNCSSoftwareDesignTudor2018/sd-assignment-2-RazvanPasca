package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Student;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.apache.http.HttpHeaders.USER_AGENT;

public class Poster {
    public static HttpResponse sendRequest(String url, Object object) {
        HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type", "application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonString = objectMapper.writeValueAsString(object);
            StringEntity postedString = new StringEntity(jsonString);
            HttpClient client = new DefaultHttpClient();
            post.setEntity(postedString);
            HttpResponse response = client.execute(post);
            return  response;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static List<Student> sendRequestWithResponse(String url, Object object){
        HttpResponse response = sendRequest(url,object);
        System.out.println(response);
        return  null;
    }

}
