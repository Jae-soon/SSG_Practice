package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private List<WiseSaying> wiseSayings;
    private int lastIndex;

    WiseSayingService() {
        wiseSayings = new ArrayList<>();
        lastIndex = 0;
    }

    public WiseSaying write(String content, String author) {
        int id = ++lastIndex;
        WiseSaying newWiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(newWiseSaying);

        return newWiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.id == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public void modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null) {
            return;
        }

        wiseSaying.content = content;
        wiseSaying.author = author;
    }

    public void remove(int id) {
        WiseSaying foundWiseSaying = findById(id);
        wiseSayings.remove(foundWiseSaying);
    }
}
