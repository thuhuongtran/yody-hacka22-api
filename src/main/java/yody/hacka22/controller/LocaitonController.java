package yody.hacka22.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping
@CrossOrigin
public class LocaitonController {
    @GetMapping("cities")
    public ResponseEntity<List<String>> getCities(){
        String all = "'An Giang', 'Kon Tum', 'Đắk Nông', 'Sóc Trăng', 'Bình Phước', 'Hưng Yên', 'Thanh Hóa', 'Quảng Trị', 'Tuyên Quang', 'Quảng Ngãi', 'Hà Nội', 'Lào Cai', 'Vĩnh Long', 'Lâm Đồng', 'Bình Định', 'Nghệ An', 'Kiên Giang', 'Hà Giang', 'Phú Yên', 'Lạng Sơn', 'Đà Nẵng', 'Sơn La', 'Tây Ninh', 'Nam Định', 'Lai Châu', 'Bến Tre', 'Khánh Hòa', 'Bình Thuận', 'Cao Bằng', 'Hải Phòng', 'Ninh Bình', 'Yên Bái', 'Gia Lai', 'Hoà Bình', 'Bà Rịa - Vũng Tàu', 'Cà Mau', 'Bình Dương', 'Cần Thơ', 'Thừa Thiên Huế', 'Đồng Nai', 'Tiền Giang', 'Điện Biên', 'Vĩnh Phúc', 'Quảng Nam', 'Đắk Lắk', 'Thái Nguyên', 'Hải Dương', 'Bạc Liêu', 'Trà Vinh', 'Thái Bình', 'Hà Tĩnh', 'Ninh Thuận', 'Đồng Tháp', 'Long An', 'Hậu Giang', 'Quảng Ninh', 'Phú Thọ', 'Quảng Bình', 'Hồ Chí Minh', 'Hà Nam', 'Bắc Ninh', 'Bắc Giang', 'Bắc Kạn'";
        List<String> response = new ArrayList<>();
        String[] parses = all.split(",");
        for (String s : parses){
            String punedString = s.trim();
            response.add(punedString.substring(1,punedString.length()-1));
        }
//        Collections.sort(response);
        return ResponseEntity.ok((response));
    }
    @GetMapping("districts")
    public ResponseEntity<List<String>> getDistricts(){
        String districs = "Quận Ba Đình,Quận Hoàn Kiếm,Quận Tây Hồ,Quận Long Biên,Quận Cầu Giấy,Quận Đống Đa,Quận Hai Bà Trưng,Quận Hoàng Mai,Quận Thanh Xuân";
        String[] parses = districs.split(",");
        List<String> response = new ArrayList<>();
        for (String s : parses){
            String punedString = s.trim();
            response.add(punedString);
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("wards")
    public ResponseEntity<List<String>> getWards(){
        String districs = "Phúc Xá,Trúc Bạch,Quán Thánh,Ngọc Hà,Điện Biên";
        String[] parses = districs.split(",");
        List<String> response = new ArrayList<>();
        for (String s : parses){
            String punedString = s.trim();
            response.add(punedString);
        }
        return ResponseEntity.ok(response);
    }

}
