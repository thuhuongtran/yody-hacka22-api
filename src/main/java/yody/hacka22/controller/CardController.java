package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.CardDao;
import yody.hacka22.entity.Card;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class CardController {
    @Autowired
    private CardDao cardDao;

    @PostMapping("save")
    public String save(@RequestBody Card design) {
        cardDao.save(design);
        return OK.toString();
    }

    @GetMapping("find")
    public Card getById(@RequestParam("id") String id) {
        return cardDao.findById(id).get();
    }
}
