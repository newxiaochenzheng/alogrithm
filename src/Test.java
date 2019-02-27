import com.sun.istack.internal.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {
    private OnClick mClick;

    public static final String s1 = "abc";
    public static final String s2 = "def";
//    static{
//        s1="abc";
//        s2="def";
//    }
    public static void main(String[] args) {
        String s3=s1+s2;
        String s4="abcdef";
        System.out.println(s3==s4);

        List<User> userList = new ArrayList<>();
       Random random =  new Random(10);
        for(int i =0;i<10;i++){
            userList.add(new User(random.nextInt(100)));
        }
        Collections.sort(userList);
        for(User user:userList){
            System.out.println(user.age);
        }
    }

    void setOnClick(OnClick click) {
        this.mClick = click;
    }

    void run() {
        if (mClick != null) {
            View view = new View();
            view.name = "zhangsan";
            view.age = 12;
            view.runnable = multiState;
            mClick.onClick(view);
        }
    }

    private Runnable multiState = () -> {
        System.out.println("value1");
        System.out.println("vaule2");
    };
}

interface OnClick {
    void onClick(View v);
}

class View {
    String name;
    int age;
    Runnable runnable;

    public void deteleFile(@NotNull File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                file.delete();
            } else {
                for (File file1 : files) {
                    deteleFile(file1);
                }
            }

        } else {
            file.delete();
        }
    }
}
class User implements Comparable<User> {
    int age;

    User(int age){
        this.age = age;
    }
    @Override
    public int compareTo(User o) {
        return age - o.age;
    }
}