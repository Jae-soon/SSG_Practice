package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void write(Request rq) {
        System.out.print("wiseSaying : ");
        String content = sc.nextLine().trim();
        System.out.print("author : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("Add Your WiseSaying(ID = %d)\n", wiseSaying.id);
    }

    public void list(Request rq) {
        System.out.println("List");
        System.out.println("id / WiseSaying / author");
        System.out.println("==============================");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

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

        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);

        if(foundWiseSaying == null) {
            System.out.printf("Cannot Found %d WiseSaying!\n", paramId);
            return;
        }

        wiseSayingService.remove(paramId);
        System.out.println("Successfully Delete!");
    }

    public void modify(Request rq) {
        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0) {
            System.out.println("Check your cmd or Write WiseSaying ID!");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);

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

        wiseSayingService.modify(paramId, content, author);

        System.out.println("Successfully edit Your WiseSaying!");
    }

    public void build(Request rq) {
        wiseSayingService.dumpToJson();
    }
}
