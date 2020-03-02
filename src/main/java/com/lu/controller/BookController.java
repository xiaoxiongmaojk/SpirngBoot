package com.lu.controller;

import com.lu.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** 将返回的对象数据直接以JSON或XML的形式写入HTTP Response中 */
@RestController
@RequestMapping("/api")
public class BookController {
    private List<Book> books = new ArrayList<>();

    @PostMapping("/book")
    /** @RequestBody 可以将 HttpRequest body 中的 JSON 类型数据反序列化为合适的 Java 类型 */
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        /** @ResponseEntity 表示整个HTTP Response：状态码，标头和正文内容 */
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")
    /** @PathVariable 取url地址中的参数 */
    public ResponseEntity deleteBookByID(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    /** @RequestParam url的查询参数 */
    public ResponseEntity getBookByName(@RequestParam("name") String name) {
        List<Book> results = books.stream().filter(
                book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}
