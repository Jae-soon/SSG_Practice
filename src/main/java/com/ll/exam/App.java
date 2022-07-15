package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    List<WiseSaying> wiseSayings;
    int lastIndex;

    public App() {
        sc = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
        lastIndex = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("cmd) ");
            String cmd = sc.nextLine().trim();

            Request rq = new Request(cmd);

            switch(rq.getPath()) {
                case "exit":
                    break outer;
                case "write":
                    write(rq);
                    break;
                case "list":
                    list(rq);
                    break;
                case "delete":
                    delete(rq);
                    break;
            }
        }
    }

    private void write(Request rq) {
        int id = ++lastIndex;
        System.out.print("wiseSaying : ");
        String content = sc.nextLine().trim();
        System.out.print("author : ");
        String author = sc.nextLine().trim();

        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(newWiseSaying);

        System.out.printf("Add Your WiseSaying(ID = %d)\n", newWiseSaying.id);
    }

    private void list(Request rq) {
        System.out.println("List");
        System.out.println("id / WiseSaying / author");
        System.out.println("==============================");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying listwiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", listwiseSaying.id, listwiseSaying.content, listwiseSaying.author);
        }
    }

    private void delete(Request rq) {
        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0) {
            System.out.println("Check your cmd or Write WiseSaying ID!");
            return;
        }

        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.id == paramId) {
                foundWiseSaying = wiseSaying;
            }
        }

        if(foundWiseSaying == null) {
            System.out.printf("Cannot Found %d WiseSaying!\n", paramId);
            return;
        }

        wiseSayings.remove(foundWiseSaying);
        System.out.println("Successfully Delete!");
    }
}
