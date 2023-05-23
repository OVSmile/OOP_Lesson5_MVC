package personal.views;

import personal.controllers.UserController;
import personal.model.User;

import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    private ValidateData validateData = new ValidateData();

    public ViewUser(UserController userController){
        this.userController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        createUserData();
                        break;
                    case READ:
                        readUserData();
                        break;
                    case LIST:
                        printListUsers();
                        break;
                    case UPDATE:
                        updateUserData();
                        break;
                    case DELETE:
                        deleteUserData();

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void deleteUserData() {
        printListUsers();
        String id = prompt("Идентификатор пользователя для удаления: ");
        try {
            User deleteUser = userController.readUser(id);
            userController.deleteUser(deleteUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private User inputUser(){
        String firstName;
        String lastName;
        String phone;
        do {
            firstName = prompt("Имя: ");
        } while (validateData.checkFirstName(firstName));

        do {
            lastName = prompt("Фамилия: ");
        } while (validateData.checkLastName(lastName));

        do {
            phone = prompt("Номер телефона: ");
        } while (validateData.checkPhone(phone));

        return new User(firstName, lastName, phone);
    }

    private void updateUserData() {
        String id = readUserData();
        User inputtedUser = inputUser();
        inputtedUser.setId(id);
        userController.updateUser(inputtedUser);
    }

    private void createUserData() {
        userController.saveUser(inputUser());
    }

    private String readUserData() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User user = userController.readUser(id);
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    private void printListUsers() {
        List<User> userList = userController.getList();
        for (User user: userList) {
            System.out.println(user);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
