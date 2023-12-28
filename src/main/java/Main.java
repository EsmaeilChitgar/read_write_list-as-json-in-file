import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Mike", "Finland"));
        users.add(new User(2, "Tom", ""));

        FileIO.saveUsers(users);
        FileIO.loadUsers();
    }
}
