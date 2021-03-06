package com.ll.exam;

import java.util.Scanner;

public class App {
    public static String mode = "prod";
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public static String getBaseDir() {
        return mode + "_data";
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while(true) {
            System.out.print("cmd) ");
            String cmd = sc.nextLine().trim();

            Request rq = new Request(cmd);

            switch(rq.getPath()) {
                case "exit":
                    break outer;

                case "write":
                    wiseSayingController.write(rq);
                    break;

                case "list":
                    wiseSayingController.list(rq);
                    break;

                case "delete":
                    wiseSayingController.delete(rq);
                    break;

                case "edit":
                    wiseSayingController.modify(rq);
                    break;

                case "build":
                    wiseSayingController.build(rq);
            }
        }
        sc.close();
    }
}
