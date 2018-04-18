package controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Course;
import entities.Grade;
import entities.Student;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            return response;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> sendRequestWithStudentsReply(String url, Object object) {
        HttpResponse response = sendRequest(url, object);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = EntityUtils.toString(response.getEntity());
            List<Student> students = objectMapper.readValue(json, new TypeReference<List<Student>>() {
            });
            System.out.println(students);
            return students;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return null;
    }

    public static Grade sendRequestWithGradeReply(String url, Object object){
        HttpResponse response = sendRequest(url, object);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = EntityUtils.toString(response.getEntity());
            Grade grade = new Grade();
            grade = objectMapper.readValue(json, new TypeReference<Grade>() {
            });
            System.out.println(grade);
            return grade;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return null;
    }

    public static void sendEmptyRequest(String url){

    }

    public static List<Course> getCoursesRequest(String url) {
        List<Course> courses = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL getCoursesRequest = new URL(url);
            Scanner scanner = new Scanner(getCoursesRequest.openStream());
            String response = scanner.useDelimiter("\\Z").next();
            courses = objectMapper.readValue(response, new TypeReference<List<Course>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }



}
