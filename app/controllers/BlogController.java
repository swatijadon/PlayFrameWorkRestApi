package controllers;

import Model.Student;
import com.fasterxml.jackson.databind.JsonNode;
import play.api.mvc.Request;
import play.libs.Json;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.ok;

public class BlogController {
   // List<String> list = new ArrayList<String>();
    List<Student> stud = new ArrayList<Student>();
    Student student = new Student();


    public Result getAllStudent() {
        return ok(Json.toJson(stud));

    }

    public Result add(Http.Request request) {
        JsonNode jsonNode = request.body().asJson();
        String id = jsonNode.get("id").asText();
        String name = jsonNode.get("name").asText();
        String address = jsonNode.get("address").asText();

        student.setId(Integer.parseInt(id));
        student.setName(name);
        student.setAddress(address);

        stud.add(student);
        return ok();
    }

   /* public Result delete(int id) {
        list.remove(id);
        return ok(Json.toJson(list));
    }

    public Result update(Http.Request request, int id) {
        JsonNode jsonNode = request.body().asJson();
        String content = jsonNode.get("content").asText();

        if (list.size() > id) {
            list.set(id, content);

        }
        return ok();
    }*/

}
