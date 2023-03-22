import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String name = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Введите пароль повторно: ");
        String confirmPassword = scanner.nextLine();
        if(m.checkLoginAndPassword(name, password, confirmPassword)){
            System.out.println("Данные успешно введены");
        }
    }
    public boolean checkLoginAndPassword(String login,
                                      String password,
                                      String confirmPassword) throws WrongLoginException, WrongPasswordException {
        try {
            if (login == null || login.isEmpty() || login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
                throw new WrongLoginException("Логин должен состоять из латинских букв, цифр и знака " +
                        "подчеркивания, и быть не длиннее 20 символов");
            }
            if (password == null || password.isEmpty() || password.length() >= 20 ||
                    !password.matches("[a-zA-Z0-9_]+")) {
                throw new WrongPasswordException("Пароль должен состоять из латинских букв, цифр и знака " +
                        "подчеркивания, и быть меньше 20 символов");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
            return true;
        } catch (WrongPasswordException e) {
            throw e;

        }catch (WrongLoginException ex){
            throw ex;
        }finally {
            System.out.println("Обработка параметров завершена");
        }

    }


}