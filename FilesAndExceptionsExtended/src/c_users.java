import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class c_users {
    public static void main(String[] args) throws IOException {
        String path = "./users.txt";
        try(Scanner reader = new Scanner(new FileInputStream(path))) {
            HashMap<String, User> users = new HashMap<>();

            User loggedInUser = null;

            while (reader.hasNext()) {
                String[] tokens = reader.nextLine().split(" ");

                User user = new User();
                user.username = tokens[0];
                user.password = tokens[1];
                user.isLogged = Boolean.parseBoolean(tokens[2]);
                if (user.isLogged) {
                    loggedInUser = user;
                }
                users.put(user.username, user);
            }

            Scanner scanner = new Scanner(System.in);

            while(true)
            {
                String[] input = scanner.nextLine().split(" ");
                if (input[0].equals("exit"))
                {
                    break;
                }

                switch(input[0])
                {
                    case "register":
                        String username = input[1];
                        String password = input[2];
                        String repeatPassword = input[3];
                        if (users.containsKey(username))
                        {
                            System.out.println("The given username already exists.");
                        }
                        else if (!password.equals(repeatPassword))
                        {
                            System.out.println("The two passwords must match.");
                        }
                        else
                        {
                            User user = new User();
                            user.username = username;
                            user.password = password;
                            user.isLogged = false;
                            users.put(user.username, user);
                        }
                        break;
                    case "login":
                        String loginUsername = input[1];
                        String loginPass = input[2];
                        if (!users.containsKey(loginUsername))
                        {
                            System.out.println("There is no user with the given username.");
                            continue;
                        }
                        User userToLogin = users.get(loginUsername);
                        if (userToLogin.isLogged)
                        {
                            System.out.println("There is already a logged in user.");
                        }
                        else if (!loginPass.equals(userToLogin.password))
                        {
                            System.out.println("The password you entered is incorrect.");
                        }
                        else
                        {
                            users.get(loginUsername).isLogged = true;
                            loggedInUser = userToLogin;
                        }
                        break;
                    case "logout":
                        if (loggedInUser == null)
                        {
                            System.out.println("There is no currently logged in user.");
                        }
                        else
                        {
                            loggedInUser.isLogged = false;
                            loggedInUser = null;
                        }
                        break;
                }
            }
            try(PrintWriter writer = new PrintWriter(new FileWriter(path))) {
                for (User user : users.values()) {
                    String userToWrite = String.format("%s %s %s%n", user.username, user.password, user.isLogged);
                    writer.write(userToWrite);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class User {

    public String username;
    public String password;
    public boolean isLogged;

}