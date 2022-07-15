package com.ll.exam;

import java.util.List;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository;

    WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.add(content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(int id, String content, String author) {
        wiseSayingRepository.modify(id, content, author);
    }

    public void remove(int id) {
        wiseSayingRepository.remove(id);
    }
}
