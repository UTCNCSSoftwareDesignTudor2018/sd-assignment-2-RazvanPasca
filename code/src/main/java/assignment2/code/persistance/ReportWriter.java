package assignment2.code.persistance;

import com.mongodb.*;

import java.util.Arrays;
import java.util.List;

public class ReportWriter {

    public ReportWriter() {

    }

    public void writeReportToDB() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        DB database = mongoClient.getDB("reportdb");
        DBCollection collection = database.getCollection("reports");

        List<Integer> books = Arrays.asList(27464, 747854);
        DBObject person = new BasicDBObject("_id", "jo")
                .append("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", books);
        collection.insert(person);

    }

}
