package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.BusinessDao;
import yody.hacka22.entity.Business;
import yody.hacka22.repository.BusinessRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("business")
public class BusinessController {
    @Autowired
    private BusinessDao businessDao;
    @Autowired
    private BusinessRepository businessRepository;

    @PostMapping("save")
    public String save(@RequestBody Business business) {
        businessDao.save(business);
        return OK.toString();
    }

    @GetMapping("find")
    public Business getOne(@RequestParam("id") String id) {
        return businessDao.findById(id).get();
    }

    @GetMapping("list")
    public List<Business> listBusiness(@RequestParam("user-id") String userId) {
        return businessRepository.listBusinessByUserId(userId);
    }
}
