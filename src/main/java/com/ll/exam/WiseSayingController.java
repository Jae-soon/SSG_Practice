package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private List<WiseSaying> wiseSayings;
    private int lastIndex;
    private Scanner sc;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayings = new ArrayList<>();
        lastIndex = 0;
    }

    public void write(Request rq) {
        int id = ++lastIndex;
        System.out.print("wiseSaying : ");
        String content = sc.nextLine().trim();
        System.out.print("author : ");
        String author = sc.nextLine().trim();

        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(newWiseSaying);

        System.out.printf("Add Your WiseSaying(ID = %d)\n", newWiseSaying.id);
    }

    public void list(Request rq) {
        System.out.println("List");
        System.out.println("id / WiseSaying / author");
        System.out.println("==============================");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying listwiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", listwiseSaying.id, listwiseSaying.content, listwiseSaying.author);
        }
    }

    public void delete(Request rq) {
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

    public void modify(Request rq) {
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

        System.out.printf("Edit Your WiseSaying(%d)\n", paramId);
        System.out.printf("Previous WiseSaying : %s\n", foundWiseSaying.content);
        System.out.print("Write New WiseSaying : ");
        String content = sc.nextLine().trim();
        System.out.printf("Previous author : %s\n", foundWiseSaying.author);
        System.out.print("Write New author : ");
        String author = sc.nextLine().trim();

        foundWiseSaying.content = content;
        foundWiseSaying.author = author;

        System.out.println("Successfully edit Your WiseSaying!");
    }
}
