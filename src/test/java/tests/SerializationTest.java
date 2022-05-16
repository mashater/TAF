import com.google.gson.Gson;
import models.Project;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class SerializationTest {

    @Test
    public void objectToJsonTest() throws IOException {
        Gson gson = new Gson(); // переменная для сереализации/десереализации
        Project project = new Project("Test Project", "Big Test data...", false, 2);


        String objectJson = gson.toJson(project);
        System.out.println(objectJson);

        FileWriter file = new FileWriter("projectResult.json");
        gson.toJson(project, file);
        file.close();



    }

    @Test
    public void jsonToObjectTest() throws IOException {
        Gson gson = new Gson();

        String json = "{\n" +
                "  \"name\" : \"Test Project\",\n" +
                "  \"announcement\" : \"Big Announcement text \",\n" +
                "  \"show_announcement\" : true,\n" +
                "  \"type\" : 1\n" +
                "}"; // скопировали из gson файл в ""

        Project projectFromString = gson.fromJson(json, Project.class);
        System.out.println(projectFromString.toString());
        System.out.println(projectFromString.getName());

        Reader reader = Files.newBufferedReader(Paths.get("projectResult.json")); // добавление по пути-названию

        Project projectFromFile = gson.fromJson(reader, Project.class);
        System.out.println(projectFromFile.toString());
        System.out.println(projectFromFile.getName());
    }
}
