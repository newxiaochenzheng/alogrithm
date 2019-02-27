import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpURLConnection conn = null;
//        String patchUrl = "http://www.baidu.com";
        String patchUrl = "http://pimg1.126.net/apppatch/patch_sportybet_android_1.13.7_com.sportybet.plugin.jackpot_1.5.apk";
        FileOutputStream fos = new FileOutputStream(new File("a.apk"));
        URL patchInfoUrl = new URL(patchUrl);
        conn = (HttpURLConnection) patchInfoUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(1000 * 30);
        conn.connect();
        short s2 = 1;
        s2 += 1;
        int responseCode = conn.getResponseCode();
        System.out.println(conn.getResponseMessage());
        byte[] bytes = new byte[1024];
        int len;
        if (responseCode == 200) {
            InputStream is = conn.getInputStream();
            if (is != null) {
                while ((len = is.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                is.close();
            }
            fos.close();
            conn.disconnect();
        }
    }
}
