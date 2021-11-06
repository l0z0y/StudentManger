package studentmanger;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author li'zi'yao
 */
public class My {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> array = new ArrayList<>();
        while (true) {
            welcomeStatement();
            String count = sc.next();
            switch (count) {
                case "1" -> addStudent(array);
                case "2" -> deleteMessage(array);
                case "3" -> modifyInformation(array);
                case "4" -> viewStudentInformation(array);
                case "5" -> {
                    System.out.println("5.谢谢使用");
                    System.exit(0);
                    //JVM 退出
                }
                default -> System.err.println("error");
            }
        }
    }


    /**
     * 欢迎界面
     */
    public static void welcomeStatement() {            //欢迎声明()

        System.out.println("--------欢迎来到学生管理系统--------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生信息");
        System.out.println("4.查看所有信息");
        System.out.println("5.退出");
    }


    /**
     * 添加学生
     */
    public static void addStudent(ArrayList<User> array) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("--------欢迎来到学生管理系统--------");
        System.out.println("1.添加学生学号");
        while (true) {
            String id = sc.next();
            boolean flag = studentIdCheck(array, id);
            if (flag) {
                System.out.println("输入有误请重新输入");
            } else {
                user.setNum(id);
                break;
            }
        }
        System.out.println("2.添加学生姓名");
        String name = sc.next();
        user.setName(name);
        System.out.println("3.输入学生年龄");
        String age = sc.next();
        user.setAge(age);
        System.out.println("4.输入学生班级");
        String grade = sc.next();
        user.setGrade(grade);
        array.add(user);
        System.out.println("5.添加成功");

    }


    /**
     * 删除学生信息
     */
    public static void deleteMessage(ArrayList<User> array) {
        Scanner sc = new Scanner(System.in);
        if (array.size() == 0) {
            System.out.println("无信息");
        } else {
            System.out.println("输入你要删除的学号");
            String id = sc.next();
            for (int i = 0; i < array.size(); i++) {
                User s = array.get(i);
                if (id.equals(s.getNum())) {
                    array.remove(s);
                    System.out.println("删除成功");

                } else {
                    System.out.println("未找到此学号");
                    break;
                }


            }
        }

    }


    /**
     * 修改学生信息
     */
    public static void modifyInformation(ArrayList<User> array) {
        Scanner sc = new Scanner(System.in);
        if (array.size() == 0) {
            System.err.println("无信息");
        } else {
            System.out.println("请输入你想修改信息的学号");
            String id = sc.next();
            for (int i = 0; i < array.size(); i++) {
                User s = array.get(i);
                if (id.equals(s.getNum())) {
                    System.out.println("请修改姓名");
                    String name = sc.next();
                    System.out.println("请修改年龄");
                    String age = sc.next();
                    System.out.println("请修改级别");
                    String grade = sc.next();
                    User user = new User();
                    user.setNum(id);
                    user.setName(name);
                    user.setAge(age);
                    user.setGrade(grade);
                    array.set(i, user);
                    System.out.println("successfully");
                    break;
                }
            }

        }
    }


    /**
     * 查看学生信息
     */
    public static void viewStudentInformation(ArrayList<User> array) {
        if (array.size() == 0) {
            System.err.println("无信息");
        } else {
            System.out.println("学号 姓名 年龄  级别");
            for (int i = 0; i < array.size(); i++) {
                User user = array.get(i);
                System.err.println(user.getNum() + "\t" + user.getName() + "\t" + user.getAge() + "\t" + user.getGrade());
            }
        }
    }

    /**
     * 检查学号是否重复
     */
    public static boolean studentIdCheck(ArrayList<User> array, String id) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            User s = array.get(i);
            if (id.equals(s.getNum())) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}



