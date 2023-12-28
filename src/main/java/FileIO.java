import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    private final static String USERS_LOG_FILE = "users.log";
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveUsers(List<User> listCity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_LOG_FILE, false))) {
            writer.write(gson.toJson(listCity));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<User> loadUsers() {
        List<User> users;
        StringBuilder stringBuilder = new StringBuilder();

        Type type = new TypeToken<ArrayList<User>>() {
        }.getType();

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_LOG_FILE))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        users = gson.fromJson(stringBuilder.toString(), type);

        return users;
    }
}