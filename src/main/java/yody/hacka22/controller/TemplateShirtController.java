package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import yody.hacka22.dto.FindTemplateShirtRequest;
import yody.hacka22.entity.TemplateShirt;
import yody.hacka22.repository.TemplateShirtRepository;

import java.util.Map;

@Controller
@RequestMapping("templateShirt")
public class TemplateShirtController {
    @Autowired
    TemplateShirtRepository templateShirtRepository;
    @GetMapping("find")
    public ResponseEntity<TemplateShirt> getShirtTemplate(@RequestBody Map<String, String> filterCriteria){
        return ResponseEntity.ok(templateShirtRepository.findTemplateShirt(filterCriteria));
    }

    @PostMapping("create")
    public ResponseEntity<TemplateShirt> createTemplateShirt(@RequestBody TemplateShirt templateShirt){
        return ResponseEntity.ok(templateShirtRepository.createTemplateShirt(templateShirt));
    }
}
