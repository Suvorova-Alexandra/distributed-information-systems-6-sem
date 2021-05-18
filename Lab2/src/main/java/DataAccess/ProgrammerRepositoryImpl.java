package DataAccess;


import DataAccess.models.ProgrammerRepository;
import DataAccess.models.pojo.Programmer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    private static ProgrammerRepository repository;

    public static ProgrammerRepository getInstance() {
        if (repository == null) repository = new ProgrammerRepositoryImpl();
        return repository;
    }


    @Override
    public ArrayList<Programmer> getProgrammers(Path path) {
        ArrayList<Programmer> listProgrammers = new ArrayList<>();
        try {
            Object obj = new JSONParser().parse(new FileReader(path.toString()));
            JSONObject jo = (JSONObject) obj;
            JSONArray programmers = (JSONArray) jo.get("programmers");
            for (int i = 0; i < programmers.size(); i++) {
                JSONObject object = (JSONObject) programmers.get(i);
                Programmer programmer = new Programmer(object.get("FIO").toString(),
                        Integer.parseInt(object.get("experience").toString()),
                        object.get("position").toString(),
                        object.get("coreTechnology").toString(),
                        Float.parseFloat(object.get("salary").toString()));
                listProgrammers.add(programmer);
            }

        } catch (IOException e) {
            System.out.println("FilePath " + path + " not found!");

        } catch (ParseException e) {
            System.out.println("Parameters cannot be parsed. Check out parameters in your file.");
        }
        return listProgrammers;
    }
}
