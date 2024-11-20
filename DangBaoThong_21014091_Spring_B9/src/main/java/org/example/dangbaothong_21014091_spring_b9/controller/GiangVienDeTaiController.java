package org.example.dangbaothong_21014091_spring_b9.controller;

import org.example.dangbaothong_21014091_spring_b9.entities.DETAI;
import org.example.dangbaothong_21014091_spring_b9.entities.GIANGVIEN;
import org.example.dangbaothong_21014091_spring_b9.service.DeTaiService;
import org.example.dangbaothong_21014091_spring_b9.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/giangvien")
public class GiangVienDeTaiController {

    @Autowired
    private DeTaiService deTaiService;

    @Autowired
    private GiangVienService giangVienService;

    @GetMapping("/showFormForAddDeTai")
    public String showFormForAddDeTai(Model theModel) {
        DETAI theDeTai = new DETAI();
        List<GIANGVIEN> giangViens = giangVienService.getAllGiangVien();
        theModel.addAttribute("deTai", theDeTai);
        theModel.addAttribute("giangViens", giangViens);
        return "deTai-form";
    }

    @RequestMapping("/addDeTai")
    public String addDeTai(@Valid @ModelAttribute("deTai") DETAI deTai,
                           BindingResult result,
                           Model model,
                           @RequestParam("file") MultipartFile file,
                           @RequestParam("giangvienId") int giangvienId) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getDefaultMessage());
            });
            List<GIANGVIEN> giangViens = giangVienService.getAllGiangVien();
            model.addAttribute("giangViens", giangViens);
            return "deTai-form";
        }

        // Lấy giảng viên theo ID
        GIANGVIEN giangVien = giangVienService.getGiangVienById(giangvienId);
        deTai.setGiangvien(giangVien);

        // Xử lý tải lên hình ảnh
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();

                // Lấy đường dẫn tương đối từ thư mục gốc của ứng dụng (thư mục chứa resources)
                String uploadDir = "src/main/resources/static/image/";

                // Lấy thư mục gốc của dự án (trong môi trường phát triển, có thể sử dụng đường dẫn tương đối)
                Path path = Paths.get(uploadDir).toAbsolutePath().normalize();

                // Tạo đối tượng File cho thư mục đích
                File uploadPath = new File(path.toString());
                if (!uploadPath.exists()) {
                    uploadPath.mkdirs(); // Tạo thư mục nếu chưa tồn tại
                }

                // Tạo đối tượng File cho tệp đích
                File destinationFile = new File(uploadPath, fileName);
                file.transferTo(destinationFile); // Lưu tệp vào thư mục

                // Lưu đường dẫn tới tệp vào trường URLHINH
                deTai.setURLHINH("/image/" + fileName);

            } catch (IOException e) {
                e.printStackTrace();
                result.rejectValue("URLHINH", "error.deTai", "File upload failed");
                return "deTai-form";
            }
        }

        // Lưu thông tin Đề tài vào cơ sở dữ liệu
        deTaiService.addDeTai(deTai);
        return "redirect:/giangvien/list";
    }


    @PostMapping("/addGiangVien")
    public String addGiangVien(@Valid @ModelAttribute("giangVien") GIANGVIEN theGiangVien, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "giangVien-form";
        } else {
            giangVienService.addGiangVien(theGiangVien);
            return "redirect:/giangvien/list";
        }
    }

    @GetMapping("/showFormForAddGiangVien")
    public String showFormForAddGiangVien(Model theModel) {
        GIANGVIEN theGiangVien = new GIANGVIEN();
        theModel.addAttribute("giangVien", theGiangVien);
        return "giangVien-form";
    }

    @PostMapping("/delete")
    public String deleteDeTai(@RequestParam("MADETAI") int theId) {
        deTaiService.deleteDeTai(theId);
        return "redirect:/giangvien/list";
    }

    @GetMapping("/deTai")
    public String showDeTai(@RequestParam("MADETAI") int theId, Model theModel) {
        DETAI theDeTai = deTaiService.getDeTai(theId);
        theModel.addAttribute("deTai", theDeTai);
        return "deTai-detail";
    }

    @GetMapping("/list")
    public String listAll(Model theModel) {
        List<GIANGVIEN> theGiangViens = giangVienService.getAllGiangVien();
        Map<String, List<DETAI>> theDeTais = new HashMap<>();
        for (GIANGVIEN giangVien : theGiangViens) {
            theDeTais.put(giangVien.getTENGV(), deTaiService.getDeTaiByGiangVien(giangVien.getMAGV()));
        }
        theModel.addAttribute("giangViens", theGiangViens);
        theModel.addAttribute("deTais", theDeTais);
        return "list-giangVien";
    }
}