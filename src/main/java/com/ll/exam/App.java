package com.ll.exam;

import java.util.Scanner;

public class App {
    String cmd;
    Scanner sc;

    App() {
        sc = new Scanner(System.in);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        System.out.print("cmd) ");
        cmd = sc.nextLine().trim();

        outer:
        switch(cmd) {
            case "exit":
              break outer;
        }
    }
}
