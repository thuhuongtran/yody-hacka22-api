package yody.hacka22.dto;

import lombok.Data;
import yody.hacka22.entity.TemplateShirt;

import java.util.Map;

@Data
public class FindTemplateShirtRequest {
    TemplateShirt templateShirt;
    Map<String, String> filter;
}
