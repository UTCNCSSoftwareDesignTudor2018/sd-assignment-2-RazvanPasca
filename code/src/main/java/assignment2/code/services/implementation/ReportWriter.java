package assignment2.code.services.implementation;

import assignment2.code.persistance.entity.Grade;
import assignment2.code.persistance.entity.Student;
import com.mongodb.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ReportWriter {

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    DB database = mongoClient.getDB("reportdb");
    DBCollection collection = database.getCollection("reports");

    public ReportWriter() {

    }

    public void writeReportToDB(List<Grade> grades) {
        for (Grade grade : grades) {
            Student student = grade.getEnrolment().getStudent();
            DBObject studentReport = new BasicDBObject("_id", student.getId())
                    .append("name", student.getName())
                    .append("address", new BasicDBObject("address", student.getAddress()))
                    .append("course", grade.getEnrolment().getCourse().getName())
                    .append("grade", grade.getGrade())
                    .append("date", grade.getRequestDate());
            collection.insert(studentReport);
        }
    }

}
