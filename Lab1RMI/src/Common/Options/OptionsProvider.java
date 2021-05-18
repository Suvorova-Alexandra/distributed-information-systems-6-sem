package Common.Options;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class OptionsProvider implements IOptionsProvider {
    private Path filePath;
    public OptionsProvider(Path path){
        this.filePath=path;
    }
    @Override
    public ServerOptions getOptions() {
        ServerOptions serverOptionsProvider=new ServerOptions();
        try {
            Object obj = new JSONParser().parse(new FileReader(filePath.toString()));
            JSONObject jo = (JSONObject) obj;
            serverOptionsProvider = new ServerOptions(Integer.parseInt(jo.get("port").toString()), (String) jo.get("name"));
        } catch (IOException e) {
            System.out.println("FilePath "+filePath+" not found!");
            System.exit(-1);
        } catch (ParseException e) {
            System.out.println("Server parameters cannot be parsed. Check out name, port parameters in your file.");
            System.exit(-1);
        }
        return serverOptionsProvider;
    }
}
