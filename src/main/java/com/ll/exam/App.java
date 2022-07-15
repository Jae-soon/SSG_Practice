package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    String cmd;
    Scanner sc;
    List<WiseSaying> wiseSaying;
    int lastIndex;

    App() {
        sc = new Scanner(System.in);
        wiseSaying = new ArrayList<>();
        lastIndex = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("cmd) ");
            cmd = sc.nextLine().trim();

            switch(cmd) {
                case "exit":
                    break outer;
                case "write":
                    write();
                    break;
            }
        }
    }

    private void write() {
        int id = ++lastIndex;
        System.out.print("wiseSaying : ");
        String content = sc.nextLine().trim();
        System.out.print("author : ");
        String author = sc.nextLine().trim();

        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSaying.add(newWiseSaying);

        System.out.printf("Add Your WiseSaying(ID = %d)\n", newWiseSaying.id);
    }
}
