import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Calendar;

/*
服务器模块，单独运行
接收客户端请求
返回图片url
 */
public class Server {
    private static int port = 6666;//服务端

    public static void main(String[] arg0) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("服务器启动...");
        try {
            while (true) {
                Socket s = ss.accept();
                try {
                    new WorkThread(s);//创建新的工作线程
                } catch (IOException e) {
                    s.close();
                }
            }
        } finally {
            ss.close();
        }
    }
}

class WorkThread extends Thread {//工作线程
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;

    public WorkThread(Socket s) throws IOException {
        this.s = s;
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime()+"连接来自：" + s.getRemoteSocketAddress());
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);
        start();
    }

    public void run() {
        try {
            String str = null;
            while ((str = in.readLine()) != null) {
                if (str.equals("exit")) {//客户端发送exit命令终止服务
                    System.exit(0);
                }
                if (Check_file(str)) {//如果存在文件
                    out.println("http://wallpaper.yemuc.xyz/" + str + ".jpg");//返回url
                }
                else{//不存在返回错误jpg
                    out.println("http://wallpaper.yemuc.xyz/error.jpg");
                }

            }

        } catch (IOException e) {
        } finally {//断开连接
            try {
                System.out.println("正在断开与" + s.getRemoteSocketAddress() + "的连接...");
                s.close();
                System.out.println("已断开连接");
            } catch (IOException e) {
            }
        }
    }

    public boolean Check_file(String filename) {//检查文件是否存在
        File file = new File(filename+".jpg");//创建一个文件对象
        return file.exists();
    }
}
