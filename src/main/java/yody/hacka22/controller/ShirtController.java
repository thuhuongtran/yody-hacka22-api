package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yody.hacka22.dao.ShirtDao;
import yody.hacka22.entity.Shirt;
import yody.hacka22.repository.ShirtRepository;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("shirt")
public class ShirtController {
    @Autowired
    private ShirtDao shirtDao;

    @Autowired
    private ShirtRepository shirtRepository;

    @PostMapping("save")
    public String save(@RequestBody Shirt shirt) {
        shirtDao.save(shirt);
        return OK.toString();
    }

}
